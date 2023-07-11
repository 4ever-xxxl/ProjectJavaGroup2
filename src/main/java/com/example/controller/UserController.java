package com.example.controller;


import com.example.common.Result;
import com.example.controller.Request.LoginRequest;
import com.example.controller.Request.UserPageRequest;
import com.example.controller.dto.LoginDTO;
import com.example.entity.Staff;
import com.example.entity.User;
import com.example.service.IUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/User")
public class UserController {
    @Autowired
    private IUserService userService;

    @PostMapping("/Login")
    public LoginDTO Login(@RequestBody LoginRequest loginRequest)
    {
        return userService.Login(loginRequest);
    }

    @PostMapping("/addUser")
    public Result addUser(@RequestBody User user){
        userService.addUser(user);
        return Result.success();
    }

    @DeleteMapping("/deleteUser/{userId}")
    public Result deleteUser(@PathVariable long userId){
        System.out.println(userId);
        userService.deleteUser(userId);
        return Result.success();
    }

    @GetMapping("/getAllUser")
    public Result getAllUser(){
        return Result.success(userService.getAllUser());
    }

    @PutMapping("/updateUser")
    public Result updateUser(@RequestBody User user){
        System.out.println(user.getUsrName());
        userService.updateUser(user);
        return Result.success();
    }
    @PostMapping("/searchUser")
    public Result searchUser(@RequestBody UserPageRequest userPageRequest){
        PageHelper.startPage(userPageRequest.getPageNum(),userPageRequest.getPageSize());
        List<User> users=userService.searchUser(userPageRequest);
        return Result.success(new PageInfo<>(users));
    }


}
