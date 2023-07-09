package com.example.controller;


import com.example.controller.Request.LoginRequest;
import com.example.controller.dto.LoginDTO;
import com.example.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/User")
public class UserController {
    @Autowired
    private IUserService userService;

    @PostMapping("/Login")
    public LoginDTO Login(@RequestBody LoginRequest loginRequest)
    {
        System.out.println(loginRequest.getUsrName());
        return userService.Login(loginRequest);
    }
}
