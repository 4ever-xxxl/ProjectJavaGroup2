package com.example.dao;

import com.example.entity.Admin;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface AdminDao {
    String getPassword(String usrName);
//    String save(Admin admin);
    Admin getByUsrName(String usrName);
}
