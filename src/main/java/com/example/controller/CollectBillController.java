package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.common.Result;
import com.example.controller.Request.AccountPageRequest;
import com.example.controller.Request.CollectBillPageRequest;
import com.example.dao.AccountDao;
import com.example.dao.CollectBillDao;
import com.example.entity.Account;
import com.example.entity.CollectBill;
import com.example.service.Imp.CollectBillService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/CollectBill")
public class CollectBillController {
    @Autowired
    CollectBillService collectBillService;

    @Autowired
    CollectBillDao collectBillDao;

    @Autowired
    AccountDao accountDao;

    @GetMapping("/getAllCollectBill")
    public Result getAllCollectBill(){
        return Result.success(collectBillService.list());
    }

    @DeleteMapping("/deleteCollectBill/{cbId}")
    public Result deleteCollectBill(@PathVariable long cbId){
        try{
            collectBillDao.deleteById(cbId);
            return Result.success();
        }catch(Exception e){
            System.out.println("delete error");
            return Result.error(e.toString());
        }
    }

    @PostMapping("/addCollectBill")
    public Result addCollectBill(@RequestBody CollectBill collectBill){
        try {
            //如果已缴状态为空或者值不为”是“或”否“
            if(collectBill.getCbstatement() == null ||
                    (!collectBill.getCbstatement().equals("是")&&!collectBill.getCbstatement().equals("否"))){
                System.out.println("illegal insert:statement");
                return Result.error("illegal insert");
            }else if(collectBill.getCbstatement().equals("是")&&collectBill.getCbstatetime()==null){ //状态为已缴但是没有结单日期，那么不合法
                System.out.println("illegal insert:no statementTime");
                return Result.error("illegal insert");
            }

            //只检查cbRelief不为空的情况，可以不设该值
            if (collectBill.getCbrelief() != null){
                if (-1 == (collectBill.getCbdue().compareTo(collectBill.getCbrelief()))) {  //如果应缴小于减免，那么不合法
                    System.out.println("illegal insert:relief");
                    return Result.error("illegal insert");
                }
            }
            //同上
            if(collectBill.getCbdelaydate()!=null){
                if(1 == (collectBill.getCbduedate().compareTo(collectBill.getCbdelaydate()))){    //如果应缴日期大于缓缴日期，那么不合法
                    System.out.println("illegal insert:delaydate");
                    return Result.error("illegal insert");
                }
            }

            collectBillDao.insert(collectBill);
            //如果已经结单，则修改account
            if(collectBill.getCbstatement().equals("是")) {
                //查找相应的表项
                Account account = new Account();
                account.setAid(collectBill.getCbaccountid());
                account = accountDao.selectById(account);

                //设置新值并update，保留两位小数并四舍五入，因为BigDecimal没有定义运算符所以很丑
                account.setAbalance(account.getAbalance().add(
                                collectBill.getCbdue().subtract(
                                        collectBill.getCbrelief()))
                        .setScale(2));
                account.setAlastupdate(new Date());

                accountDao.updateById(account);
            }

            return Result.success();
        }catch(Exception e){
            System.out.println("insert error:addCollectBill");
            return Result.error(e.toString());
        }
    }

    @PostMapping("/searchCollectBill")
    public Result searchCollectBill(@RequestBody CollectBillPageRequest collectBillPageRequest){
        PageHelper.startPage(collectBillPageRequest.getPageNum(),collectBillPageRequest.getPageSize());

        //如果传过来id不为空，那么按id找
        if(collectBillPageRequest.getCbid() != null){
            CollectBill collectBill = new CollectBill();
            collectBill.setCbid(collectBillPageRequest.getCbid());
            try{
                return Result.success(collectBillDao.selectById(collectBill));
            }catch (Exception e) {
                System.out.println("search error");
                return Result.error(e.toString());
            }
        }

        //根据账户id，公司id，应缴金额，减免金额，应缴日期，缓缴日期，是否结单，结单时间查找
        QueryWrapper<CollectBill> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq(collectBillPageRequest.getCbaccountid()!=null,"cbaccountid",collectBillPageRequest.getCbaccountid())
                .eq(collectBillPageRequest.getCbcompanyid()!=null,"cbcompanyid",collectBillPageRequest.getCbcompanyid())
                .eq(collectBillPageRequest.getCbdue()!=null,"cbdue",collectBillPageRequest.getCbdue())
                .eq(collectBillPageRequest.getCbrelief()!=null,"cbrelief",collectBillPageRequest.getCbrelief())
                .le(collectBillPageRequest.getMax_cbduedate()!=null,"cbduedate",collectBillPageRequest.getMax_cbduedate())
                .ge(collectBillPageRequest.getMin_cbduedate()!=null,"cbduedate",collectBillPageRequest.getMin_cbduedate())
                .le(collectBillPageRequest.getMax_cbdelaydate()!=null,"cbdelaydate",collectBillPageRequest.getMax_cbdelaydate())
                .ge(collectBillPageRequest.getMin_cbdelaydate()!=null,"cbdelaydate",collectBillPageRequest.getMin_cbdelaydate())
                .like(collectBillPageRequest.getCbstatement()!=null,"cbstatement",collectBillPageRequest.getCbstatement())
                .le(collectBillPageRequest.getMax_cbstatetime()!=null,"cbstatetime",collectBillPageRequest.getMax_cbstatetime())
                .ge(collectBillPageRequest.getMin_cbstatetime()!=null,"cbstatetime",collectBillPageRequest.getMin_cbstatetime());

        List<CollectBill> collectBills=collectBillDao.selectList(queryWrapper);

        //生成新的分页信息
        return Result.success(new PageInfo<>(collectBills));
    }

    @PutMapping("/updateCollectBill")
    public Result updateCollectBill(@RequestBody CollectBill collectBill){
        try{
            //如果之前结单状态为”否“，现在为”是“，那么更改account；不能从”是“改为”否“
            CollectBill collectBill_prev=new CollectBill();
            collectBill_prev.setCbid(collectBill.getCbid());
            collectBill_prev=collectBillDao.selectById(collectBill_prev);

            if(collectBill_prev.getCbstatement().equals("是")&&collectBill.getCbstatement().equals("否")){
                System.out.println("update error");
                return Result.error("update error");
            }else if(collectBill_prev.getCbstatement().equals("否")&&collectBill.getCbstatement().equals("是")){
                //查找相应的表项
                Account account = new Account();
                account.setAid(collectBill.getCbaccountid());
                account = accountDao.selectById(account);

                //设置新值并update，保留两位小数并四舍五入，因为BigDecimal没有定义运算符所以很丑
                account.setAbalance(account.getAbalance().add(
                                collectBill.getCbdue().subtract(
                                        collectBill.getCbrelief()))
                        .setScale(2));
                account.setAlastupdate(new Date());

                accountDao.updateById(account);
            }

            collectBillDao.updateById(collectBill);
            return Result.success();
        }catch(Exception e){
            System.out.println("update error");
            return Result.error(e.toString());
        }
    }
}
