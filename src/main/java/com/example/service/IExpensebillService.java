package com.example.service;

import com.example.common.Result;
import com.example.controller.Request.ExpensebillPageRequest;
import com.example.entity.Expensebill;

import java.util.List;

public interface IExpensebillService {
    Result addExpensebill(Expensebill expensebill);
    Result updateExpensebill(Expensebill expensebill);
    Result deleteExpensebillById(long ebID);

    List<Expensebill> searchExpensebill(ExpensebillPageRequest expensebillpagerequest);
}
