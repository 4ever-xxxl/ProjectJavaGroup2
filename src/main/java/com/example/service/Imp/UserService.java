package com.example.service.Imp;

import cn.hutool.crypto.SecureUtil;
import com.example.controller.Request.LoginRequest;
import com.example.controller.Request.UserPageRequest;
import com.example.controller.dto.LoginDTO;
import com.example.dao.UserDao;
import com.example.entity.User;
import com.example.exception.ServiceException;
import com.example.service.IUserService;
import com.example.utils.TokenUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserService implements IUserService {
    private final UserDao userDao;
    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }
    @Override
    public String getPasswd(String Usrname){
        return userDao.getPassword(Usrname);
    }

    @Override
    public User getByUsrName(String name)
    {
        return userDao.getByUsrName(name);
    }
    @Override
    public void addUser(User user){
        user.setUsrPasswd(securePass(user.getUsrPasswd()));
        userDao.addUser(user);
    }
    @Override
    public void deleteUser(long userId){
        userDao.deleteUser(userId);
    }
    @Override
    public List<User> getAllUser(){
        return userDao.getAllUser();
    }
    @Override
    public void updateUser(User user){
        user.setUsrPasswd(securePass(user.getUsrPasswd()));
        System.out.println("passwd"+user.getUsrPasswd());
        System.out.println("id"+userDao.getByUsrName(user.getUsrName()));
        user.setUsrId(userDao.getByUsrName(user.getUsrName()).getUsrId());
        userDao.updateUser(user);
    }
    @Override
    public List<User> searchUser(UserPageRequest userPageRequest)
    {
        return userDao.searchUser(userPageRequest);
    }
    @Override
    public LoginDTO Login(LoginRequest request) {
        User user = null;
        try {
            user = userDao.getByUsrName(request.getUsrName());
        } catch (Exception e) {
            log.error("根据用户名{} 查询出错", request.getUsrName());
            throw new ServiceException("用户名错误");
        }
        if (user == null) {
            throw new ServiceException("用户名错误");
        }
        // 判断密码是否合法
        String securePass = securePass(request.getPassWd());
        /*if (!securePass.equals(user.getUsrPasswd())) {
            throw new ServiceException("用户名或密码错误");
        }*/
        System.out.println(user.getUsrPasswd()+"   "+request.getPassWd());
        System.out.println(user.getUsrPasswd().equals(request.getPassWd()));
        System.out.println(user.getUsrPasswd()+"?");
        System.out.println(securePass);
        System.out.println((!user.getUsrPasswd().equals(request.getPassWd()))&&(!securePass.equals(user.getUsrPasswd())));
        if ((!user.getUsrPasswd().equals(request.getPassWd()))&&(!securePass.equals(user.getUsrPasswd()))) {
            throw new ServiceException("用户名或密码错误123");
        }
        LoginDTO loginDTO = new LoginDTO();
        BeanUtils.copyProperties(user, loginDTO);

        // 生成token
        String token = TokenUtils.genToken(String.valueOf(user.getUsrName()), user.getUsrPasswd());
        loginDTO.setToken(token);
        return loginDTO;
    }

    private String securePass(String password) {
        return SecureUtil.md5(password + "uestc");
    }
}
