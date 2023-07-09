package com.example.service.Imp;

import cn.hutool.crypto.SecureUtil;
import com.example.controller.Request.LoginRequest;
import com.example.controller.dto.LoginDTO;
import com.example.dao.AdminDao;
import com.example.dao.StaffDao;
import com.example.entity.Admin;
import com.example.exception.ServiceException;
import com.example.service.IAdminService;
import com.example.utils.TokenUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AdminService implements IAdminService {
    private final AdminDao adminDao;
    @Autowired
    public AdminService(AdminDao adminDao) {
        this.adminDao = adminDao;
    }
    @Override
    public String getPasswd(String Usrname){
        return adminDao.getPassword(Usrname);
    }

    @Override
    public Admin getByUsrName(String name)
    {
        return adminDao.getByUsrName(name);
    }

    @Override
    public LoginDTO Login(LoginRequest request) {
        System.out.println(request.getPassWd()+request.getUsrName());
        Admin admin = null;
        try {
            admin = adminDao.getByUsrName(request.getUsrName());
        } catch (Exception e) {
            log.error("根据用户名{} 查询出错", request.getUsrName());
            throw new ServiceException("用户名错误");
        }
        if (admin == null) {
            throw new ServiceException("用户名或密码错误");
        }
        // 判断密码是否合法
        String securePass = securePass(request.getPassWd());
        /*if (!securePass.equals(admin.getUsrPasswd())) {
            throw new ServiceException("用户名或密码错误");
        }*/
        System.out.println(admin.getUsrPasswd()+"   "+request.getPassWd());
        System.out.println(admin.getUsrPasswd().equals(request.getPassWd()));
        if (!admin.getUsrPasswd().equals(request.getPassWd())) {
            throw new ServiceException("用户名或密码错误");
        }
        LoginDTO loginDTO = new LoginDTO();
        BeanUtils.copyProperties(admin, loginDTO);

        // 生成token
        String token = TokenUtils.genToken(String.valueOf(admin.getUsrName()), admin.getUsrPasswd());
        loginDTO.setToken(token);
        return loginDTO;
    }

    private String securePass(String password) {
        return SecureUtil.md5(password + "uestc");
    }
}
