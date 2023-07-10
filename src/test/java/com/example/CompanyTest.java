package com.example;

import com.example.common.Result;
import com.example.dao.CompanyDao;
import com.example.entity.Company;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;

import javax.annotation.Resource;


/**
 * 方法阅读说明:CompanyDao是基础SQL语句到接口方法的映射，sql语句写在Company.xml文件中
 * ICompanyService是对Dao中接口的进一步封装（依然是接口），涉及到增删改三个方法，主要作用是将Dao中方法的Integer返回值类型封装为为Result,并且对Dao中sql语句返回的异常进行捕捉与处理
 * CompanyService是对ICompanyService中接口的实现
 * Controller中对于查询直接使用了Dao接口中的方法，对于增删改使用了封装后的Service方法
 *
 */
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
