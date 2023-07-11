package com.example.dao;

import com.example.controller.Request.ExpensebillPageRequest;
import com.example.entity.Expensebill;

import java.util.List;

public interface ExpensebillDao {
    Expensebill getExpensebillByEbId(long ebID);
    List<Expensebill> getExpensebillByEbaId(long ebAccountID);
    List<Expensebill> getExpensebillByEbfId(long ebFinancialID);
    List<Expensebill> getAllExpensebill();


    Integer addExpensebill(Expensebill expensebill);
    Integer deleteExpensebillById(long cID);

    Integer updateExpensebill(Expensebill expensebill);

    List<Expensebill> searchExpensebill(ExpensebillPageRequest expensebillpagerequest);
}
