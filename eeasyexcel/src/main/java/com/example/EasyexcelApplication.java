package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.example.dao")

public class EasyexcelApplication {
    public static void main(String[] args) {
        SpringApplication.run(EasyexcelApplication.class, args);
    }
}
