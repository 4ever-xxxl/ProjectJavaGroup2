package com.example.controller.Response;

import com.example.entity.Account;
import lombok.Data;

import java.util.List;

@Data
public class AccountResponse{
    private List<Account> tableData;
    private long total=0;
}
