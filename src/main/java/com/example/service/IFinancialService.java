package com.example.service;

import com.example.controller.Request.FinancialPageRequest;
import com.example.entity.Financial;

import java.util.List;

public interface IFinancialService {
    List<Financial> getAllFinancial();
    void addFinancial(Financial financial);
    void updateFinancial(Financial financial);
    void deleteFinancial(int financialId);
    List<Financial> searchFinancial(FinancialPageRequest financialPageRequest);
}
