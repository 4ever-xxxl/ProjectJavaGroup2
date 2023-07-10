package com.example.service.Imp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.AccountDao;
import com.example.entity.Account;
import com.example.service.IAccountService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AccountService extends ServiceImpl<AccountDao, Account>
        implements IAccountService {


    public void insert() {
    }
}
