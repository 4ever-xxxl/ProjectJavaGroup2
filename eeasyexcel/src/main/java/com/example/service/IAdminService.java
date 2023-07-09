package com.example.service;

import com.example.controller.Request.LoginRequest;
import com.example.controller.dto.LoginDTO;
import com.example.entity.Admin;
import org.springframework.stereotype.Service;

public interface IAdminService {
    String getPasswd(String Usrname);
    LoginDTO Login(LoginRequest loginRequest);
    Admin getByUsrName(String name);
}
