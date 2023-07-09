package com.example.service;

import com.example.controller.Request.LoginRequest;
import com.example.controller.dto.LoginDTO;
import com.example.entity.User;

public interface IUserService {
    String getPasswd(String Usrname);
    LoginDTO Login(LoginRequest loginRequest);
    User getByUsrName(String name);
}
