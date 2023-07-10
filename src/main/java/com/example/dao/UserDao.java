package com.example.dao;

import com.example.controller.Request.UserPageRequest;
import com.example.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Component
public interface UserDao {
    String getPassword(String usrName);
    User getByUsrName(String usrName);
    void addUser(User user);
    void deleteUser(long userId);
    List<User> getAllUser();
    void updateUser(User user);
    List<User> searchUser(UserPageRequest userPageRequest);
}
