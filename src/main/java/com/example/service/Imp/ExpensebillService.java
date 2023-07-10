package com.example.service.Imp;

import com.example.common.Result;
import com.example.controller.Request.ExpensebillPageRequest;
import com.example.dao.ExpensebillDao;
import com.example.entity.Expensebill;
import com.example.service.IExpensebillService;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class ExpensebillService implements IExpensebillService {
    @Resource
    private ExpensebillDao  expensebilldao;
    @Override
    public Result addExpensebill(Expensebill expensebill) {
        Integer effectedRow;
        try{
            effectedRow=expensebilldao.addExpensebill(expensebill);
            return Result.success(effectedRow);
        }catch (DuplicateKeyException e){
            return Result.error("添加失败！非法主键！");
        }
    }

    @Override
    public Result updateExpensebill(Expensebill expensebill) {
        Integer effectedRow;
        try{
            effectedRow=expensebilldao.updateExpensebill(expensebill);
            return Result.success(effectedRow);
        }catch (Exception e){
            return Result.error("更新失败！\n"+e);
        }
    }


    @Override
    public Result deleteExpensebillById(long cID) {
        Integer effectedRow;
        try{
            effectedRow=expensebilldao.deleteExpensebillById(cID);
            return Result.success(effectedRow);
        }catch (Exception e){
            return Result.error("删除失败！\n"+e);
        }
    }

    @Override
    public List<Expensebill> searchExpensebill(ExpensebillPageRequest expensebillpagerequest){
        return expensebilldao.searchExpensebill(expensebillpagerequest);
    }
}
