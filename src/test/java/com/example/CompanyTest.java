package com.example;

import com.example.common.Result;
import com.example.dao.CompanyDao;
import com.example.entity.Company;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;

import javax.annotation.Resource;

@SpringBootTest
public class CompanyTest {
    @Resource
    private CompanyDao companydao;

    @Test
    public void addCompany() {
        Integer effectedRow;
        Company company=new Company(1,"TestCode","TestName","TestAddress","TestRegion");
        try{
            effectedRow=companydao.addCompany(company);
            System.out.println(Result.success(effectedRow));
        }catch (DuplicateKeyException e){
            System.out.println(Result.error("添加失败！非法主键！"+e));
        }
    }
    @Test
    public void updateCompany() {
        Integer effectedRow;
        Company company=new Company(2,"UpDateTestCode","TestName","TestAddress","TestRegion");
        try{
            effectedRow=companydao.updateCompany(company);
            System.out.println(Result.success(effectedRow));
        }catch (Exception e){
            System.out.println(Result.error("更新失败！\n"+e));
        }
    }

    @Test
    public void deleteCompanyById() {
        long cID=1;
        Integer effectedRow;
        try{
            effectedRow=companydao.deleteCompanyById(cID);
            System.out.println(Result.success(effectedRow));
        }catch (Exception e){
            System.out.println(Result.error("删除失败！\n"+e));
        }
    }
    @Test
    public void getCompanyById(){
        long cID=1;
        System.out.println(companydao.getCompanyById(cID));
    }

    @Test
    public void getAllCompany(){
        for (Company company:
                companydao.getAllCompany()) {
            System.out.println(company);
        }
    }

    @Test
    public void getCompanyByName(){
        for (Company company:
                companydao.getCompanyByName('%'+"子"+'%')) {
            System.out.println(company);
        }
    }
}
