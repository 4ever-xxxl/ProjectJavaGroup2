package com.example.service.Imp;

import com.example.common.Result;
import com.example.dao.CompanyDao;
import com.example.entity.Company;
import com.example.service.ICompanyService;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CompanyService implements ICompanyService {

    @Resource
    private CompanyDao companydao;
    @Override
    public Result addCompany(Company company) {
        Integer effectedRow;
        try{
            effectedRow=companydao.addCompany(company);
            return Result.success(effectedRow);
        }catch (DuplicateKeyException e){
            return Result.error("添加失败！非法主键！");
        }
    }

    @Override
    public Result updateCompany(Company company) {
        Integer effectedRow;
        try{
            effectedRow=companydao.updateCompany(company);
            return Result.success(effectedRow);
        }catch (Exception e){
            return Result.error("更新失败！\n"+e);
        }
    }

    @Override
    public Result deleteCompanyById(long cID) {
        Integer effectedRow;
        try{
            effectedRow=companydao.deleteCompanyById(cID);
            return Result.success(effectedRow);
        }catch (Exception e){
            return Result.error("删除失败！\n"+e);
        }
    }
}
