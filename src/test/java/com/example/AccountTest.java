package com.example;

import com.example.controller.AccountController;
import com.example.controller.Request.AccountPageRequest;
import com.example.entity.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.ParseException;

@SpringBootTest
public class AccountTest {
    @Resource
    AccountController accountController;

    @Test
    public void selectTest() throws ParseException {
        AccountPageRequest accountPageRequest = new AccountPageRequest();
        Account account=new Account();
        account.setAbankcard("TestAccount");
        account.setAbalance(new BigDecimal("114514.19"));

        accountController.addAccount(account);
        System.out.println("Test success");
    }
}
