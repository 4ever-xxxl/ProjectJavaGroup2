package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.common.Result;
import com.example.controller.Request.AccountPageRequest;
import com.example.dao.AccountDao;
import com.example.entity.Account;
import com.example.entity.Staff;
import com.example.service.Imp.AccountService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        try{
            accountDao.insert(account);
            return Result.success();
        }catch(Exception e){
            System.out.println("insert error");
            return Result.error(e.toString());
        }
    }

    @DeleteMapping("/deleteAccount")
    public Result deleteAccount(@PathVariable long accountID){
        try{
            accountDao.deleteById(accountID);
            return Result.success();
        }catch(Exception e){
            System.out.println("delete error");
            return Result.error(e.toString());
        }
    }

    @PostMapping("/searchAccount    ")
    public Result searchAccount(@RequestBody AccountPageRequest accountPageRequest){
        PageHelper.startPage(accountPageRequest.getPageNum(),accountPageRequest.getPageSize());

        //���������id��Ϊ�գ���ô��id��
        if(accountPageRequest.getAid() != null){
            Account account = new Account();
            account.setAid(accountPageRequest.getAid());
            try{
                return Result.success(accountDao.selectById(account));
            }catch (Exception e) {
                System.out.println("search error");
                return Result.error(e.toString());
            }
        }

        //���ݿ��š����������ʱ�����
        QueryWrapper<Account> queryWrapper=new QueryWrapper<>();
        queryWrapper.like(accountPageRequest.getAbankcard()!=null,"abankcard",accountPageRequest.getAbankcard())
                .eq(accountPageRequest.getAbalance()!=null,"abalance",accountPageRequest.getAbalance())
                .le(accountPageRequest.getMax_alastupdate()!=null,"alastupdate",accountPageRequest.getMax_alastupdate())
                .ge(accountPageRequest.getMin_alastupdate()!=null,"alastupdate",accountPageRequest.getMin_alastupdate());


        List<Account> accounts=accountDao.selectList(queryWrapper);

        //�����µķ�ҳ��Ϣ
        PageInfo<Account> pageInfo=new PageInfo<>(accounts);
        List<Account> account=pageInfo.getList();
        return Result.success(account);
    }

    @PutMapping("/updateAccount")
    public Result updateAccount(@RequestBody Account account){
        try{
            accountDao.updateById(account);
            return Result.success();
        }catch(Exception e){
            System.out.println("update error");
            return Result.error(e.toString());
        }
    }

}
