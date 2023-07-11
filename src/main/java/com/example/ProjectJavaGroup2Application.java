package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.example.dao")
@EnableScheduling
public class ProjectJavaGroup2Application {
    public static void main(String[] args) {
        SpringApplication.run(ProjectJavaGroup2Application.class, args);
    }
}
