package com.example;

import com.example.controller.AccountController;
import com.example.controller.Request.AccountPageRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

@SpringBootTest
public class ApplicationTest {
    @Autowired
    AccountController accountController;

    @Test
    public void selectTest() throws ParseException {
        AccountPageRequest accountPageRequest = new AccountPageRequest();
        System.out.println(accountController.searchAccount(accountPageRequest).toString());
        System.out.println("success");
    }
}
