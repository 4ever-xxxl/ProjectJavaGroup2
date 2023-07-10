package com.example.service;

import com.example.controller.Request.LoginRequest;
import com.example.controller.Request.UserPageRequest;
import com.example.controller.dto.LoginDTO;
import com.example.entity.User;

import java.util.List;

public interface IUserService {
    String getPasswd(String Usrname);
    LoginDTO Login(LoginRequest loginRequest);
    User getByUsrName(String name);
    void addUser(User user);
    void deleteUser(long userId);
    List<User> getAllUser();
    void updateUser(User user);
    List<User> searchUser(UserPageRequest userPageRequest);
}
