package com.example.service.Imp;

import cn.hutool.crypto.SecureUtil;
import com.example.controller.Request.LoginRequest;
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
    public LoginDTO Login(LoginRequest request) {
        System.out.println("UserService测试");
        System.out.println(request.getPassWd()+request.getUsrName());
        User user = null;
        try {
            user = userDao.getByUsrName(request.getUsrName());
        } catch (Exception e) {
            log.error("根据用户名{} 查询出错", request.getUsrName());
            throw new ServiceException("用户名错误");
        }
        if (user == null) {
            throw new ServiceException("用户名或密码错误");
        }
        // 判断密码是否合法
        String securePass = securePass(request.getPassWd());
        /*if (!securePass.equals(user.getUsrPasswd())) {
            throw new ServiceException("用户名或密码错误");
        }*/
        System.out.println(user.getUsrPasswd()+"   "+request.getPassWd());
        System.out.println(user.getUsrPasswd().equals(request.getPassWd()));
        if (!user.getUsrPasswd().equals(request.getPassWd())) {
            throw new ServiceException("用户名或密码错误");
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
