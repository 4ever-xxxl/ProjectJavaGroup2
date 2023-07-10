package com.example.controller;

import com.example.common.Result;
import com.example.dao.AccountDao;
import com.example.entity.Account;
import com.example.service.Imp.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/Account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountDao accountDao;

    @GetMapping("/getAllAccount")
    public Result getAllAccount(){
        return Result.success(accountService.list());
    }

    @PostMapping("/addAccount")
    public Result addAccount(@RequestBody Account account){
        accountDao.insert(account);
        return Result.success();
    }

    @GetMapping("/searchAccount")
    public Result searchAccount(@PathVariable long accountID){
        return Result.success(accountService.getById(accountID));
    }

}
