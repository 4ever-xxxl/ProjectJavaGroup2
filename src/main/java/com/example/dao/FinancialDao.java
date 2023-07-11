package com.example.dao;

import com.example.controller.Request.FinancialPageRequest;
import com.example.entity.Financial;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FinancialDao {
    List<Financial> getAllFinancial();
    void addFinancial(Financial financial);
    void updateFinancial(Financial financial);
    void deleteFinancial(int financialId);
    List<Financial> searchFinancial(FinancialPageRequest financialPageRequest);
}

