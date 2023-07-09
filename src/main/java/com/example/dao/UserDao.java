package com.example.dao;

import com.example.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface UserDao {
    String getPassword(String usrName);
//    String save(User user);
    User getByUsrName(String usrName);
}
