package com.example.service.Imp;

import com.example.controller.Request.FinancialPageRequest;
import com.example.dao.FinancialDao;
import com.example.entity.Financial;
import com.example.service.IFinancialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinancialService implements IFinancialService {

    @Autowired
    private final FinancialDao financialDao;

    public FinancialService(FinancialDao financialDao)
    {
        this.financialDao=financialDao;
    }

    @Override
    public List<Financial> getAllFinancial(){
        return financialDao.getAllFinancial();
    }
    @Override
    public void addFinancial(Financial financial){
        financialDao.addFinancial(financial);
    }
    @Override
    public void updateFinancial(Financial financial){
        financialDao.updateFinancial(financial);
    }
    @Override
    public void deleteFinancial(int financialId){
        financialDao.deleteFinancial(financialId);
    }
    @Override
    public List<Financial> searchFinancial(FinancialPageRequest financialPageRequest){
        return financialDao.searchFinancial(financialPageRequest);
    }

}
