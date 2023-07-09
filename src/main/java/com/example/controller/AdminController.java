package com.example.controller;


import com.example.controller.Request.LoginRequest;
import com.example.controller.dto.LoginDTO;
import com.example.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/Admin")
public class AdminController {
    @Autowired
    private IAdminService adminService;

    @PostMapping("/Login")
    public LoginDTO Login(@RequestBody LoginRequest loginRequest)
    {
        System.out.println(loginRequest.getUsrName());
        return adminService.Login(loginRequest);
    }
}
