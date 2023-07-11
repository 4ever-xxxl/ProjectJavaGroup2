package com.example.service.Imp;

import com.example.common.Result;
import com.example.controller.Request.ExpensebillPageRequest;
import com.example.dao.AccountDao;
import com.example.dao.ExpensebillDao;
import com.example.entity.Account;
import com.example.entity.Expensebill;
import com.example.service.IExpensebillService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class ExpensebillService implements IExpensebillService {
    @Resource
    private ExpensebillDao  expensebilldao;
    @Resource
    private AccountDao accountdao;


    /**
     * 这个方法涉及到另一个表的联合改动，在此说明
     * 我在Account中新写了一个构造方法
     * 在accountdao中新写了updateBecauseExpensebill（因expensebill改动造成的更新）
     * 在updateBecauseExpensebill方法中，传入的account实体的aid=expensebill.ebAccountID；abankcard不传入，无用； abanlance=ebAmount；
     * 也就是说，这个account实体的abanlance是 减量值
     * 在account.xml中，对应地写入了减量更新的sql语句
     * @param expensebill
     * @return
     */
    @Override
    public Result addExpensebill(Expensebill expensebill) {
        Integer effectedRow;
        try{
            effectedRow=expensebilldao.addExpensebill(expensebill);

            Account account=new Account(expensebill.getEbAccountID(),"",expensebill.getEbAmount());
            accountdao.updateBecauseExpensebill(account);


            return Result.success(effectedRow);
        }catch (DataIntegrityViolationException e){
            return Result.error("添加失败！添加的支出账户ID或支出财政局部门ID不存在！或添加了重复的支出账单ID!");
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
