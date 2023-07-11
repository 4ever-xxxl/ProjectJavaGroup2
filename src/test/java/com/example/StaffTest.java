package com.example;

import com.example.dao.StaffDao;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class StaffTest {
    @Resource
    private StaffDao staffdao;

}
