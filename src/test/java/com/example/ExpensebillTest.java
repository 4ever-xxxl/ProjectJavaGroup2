package com.example;

import com.example.common.Result;
import com.example.controller.Request.ExpensebillPageRequest;
import com.example.dao.AccountDao;
import com.example.dao.ExpensebillDao;
import com.example.entity.Account;
import com.example.entity.Expensebill;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
/**
 * 方法阅读说明:Dao是基础SQL语句到接口方法的映射，sql语句写在（表名）.xml文件中
 * I{表名}Service是对Dao中接口的进一步封装（依然是接口），涉及到增删改三个方法，主要作用是将Dao中方法的Integer返回值类型封装为为Result,并且对Dao中sql语句返回的异常进行捕捉与处理
 * {表名}Service是对I{表名}Service中接口的实现
 * Controller中对于查询直接使用了Dao接口中的方法，对于增删改使用了封装后的Service方法
 *
 */
@SpringBootTest
public class ExpensebillTest {
    @Resource
    private ExpensebillDao expensebilldao;
    @Resource
    private AccountDao accountdao;

    @Test
    public void addExpensebill() {
        Integer effectedRow;


        Date date=new Date(123, Calendar.JULY,7,15,0,0);
        BigDecimal bigDecimal=new BigDecimal(1000);

        Expensebill expensebill = new Expensebill();


        Account account=new Account(expensebill.getEbAccountID(),"",expensebill.getEbAmount());
        try {
            effectedRow = expensebilldao.addExpensebill(expensebill);
            accountdao.updateBecauseExpensebill(account);
            System.out.println(Result.success(effectedRow));
        }
        catch (DataIntegrityViolationException e){
            System.out.println("添加失败！添加的支出账户ID或支出财政局部门ID不存在！或添加了重复的支出账单ID!");
        }
    }

    @Test
    public void updateExpensebill() {
        Integer effectedRow;
        Date date=new Date(123, Calendar.JULY,7,15,0,0);
        BigDecimal bigDecimal=new BigDecimal("11111111.11");
        Expensebill expensebill = new Expensebill(1,2,3,bigDecimal,date,"UpdateTestObject");
        try {
            effectedRow = expensebilldao.updateExpensebill(expensebill);
            System.out.println(Result.success(effectedRow));
        } catch (Exception e) {
            System.out.println(Result.error("更新失败！\n" + e));
        }
    }

    @Test
    public void deleteExpensebillById() {
        long ebID = 1;
        Integer effectedRow;
        try {
            effectedRow = expensebilldao.deleteExpensebillById(ebID);
            System.out.println(Result.success(effectedRow));
        } catch (Exception e) {
            System.out.println(Result.error("删除失败！\n" + e));
        }
    }

    @Test
    public void getExpensebillByEbfId() {
        long ebFinancialID = 1;
        for (Expensebill expensebill :
                expensebilldao.getExpensebillByEbfId(ebFinancialID)) {
            System.out.println(expensebill);
        }
    }

    @Test
    public void getExpensebillByEbId() {
        long ebID = 2;
        System.out.println(expensebilldao.getExpensebillByEbId(ebID));
    }

    @Test
    public void getExpensebillByEbaId() {
        long ebAccountID = 1;
        for (Expensebill expensebill :
                expensebilldao.getExpensebillByEbaId(ebAccountID)) {
            System.out.println(expensebill);
        }
    }

    @Test
    public void getAllExpensebill() {
        for (Expensebill expensebill :
                expensebilldao.getAllExpensebill()) {
            System.out.println(expensebill);
        }
    }

    @Test
    public void searchExpensebill(){
        ExpensebillPageRequest expensebillPageRequest=new ExpensebillPageRequest();
        expensebillPageRequest.setEbAccountID(1);
        for (Expensebill expensebill :
                expensebilldao.searchExpensebill(expensebillPageRequest)) {
            System.out.println(expensebill);
        }
    }
}
