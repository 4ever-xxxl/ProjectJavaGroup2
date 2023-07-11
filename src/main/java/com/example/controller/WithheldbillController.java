package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.common.Result;
import com.example.controller.Request.WithheldbillPageRequest;
import com.example.dao.WithheldbillDao;
import com.example.entity.Withheldbill;
import com.example.service.Imp.WithheldbillService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/Withheldbill")
public class WithheldbillController {

    @Resource
    private WithheldbillService withheldbillService;

    @Resource
    private WithheldbillDao withheldbillDao;

    @GetMapping("/getAllWithheldbill")
    public Result getAllWithheldbill(){
        return Result.success(withheldbillService.list());
    }

    @PostMapping("/addWithheldbill")
    public Result addWithheldbill(@RequestBody Withheldbill withheldbill){
        try{
            withheldbillDao.insert(withheldbill);
            return Result.success();
        }catch(Exception e){
            System.out.println("insert error");
            return Result.error(e.toString());
        }
    }

    @PutMapping("/updateWithheldbill")
    public Result updateWithheldbill(@RequestBody Withheldbill withheldbill){
        try{
            withheldbillService.updateById(withheldbill);
            return Result.success();
        }catch(Exception e){
            System.out.println("update error");
            return Result.error(e.toString());
        }
    }
    @DeleteMapping("/deleteWithheldbill/{wbid}")
    public Result deleteWithheldbill(@PathVariable long wbid){
        try{
            withheldbillDao.deleteById(wbid);
            return Result.success();
        }catch(Exception e){
            System.out.println("delete error");
            return Result.error(e.toString());
        }
    }

    @PostMapping("/searchWithheldbill")
    public Result searchWithheldbill(@RequestBody WithheldbillPageRequest withheldbillPageRequest){
        System.out.println("----------");
        System.out.println(withheldbillPageRequest);
        System.out.println("----------");
        PageHelper.startPage(withheldbillPageRequest.getPageNum(),withheldbillPageRequest.getPageSize());
        QueryWrapper<Withheldbill> queryWrapper=new QueryWrapper<>();
        if (withheldbillPageRequest.getMin_wbamount() != null && withheldbillPageRequest.getMax_wbamount() != null) {
            queryWrapper.between("wbamount", withheldbillPageRequest.getMin_wbamount(), withheldbillPageRequest.getMax_wbamount());
        } else if (withheldbillPageRequest.getMin_wbamount() != null) {
            queryWrapper.ge("wbamount", withheldbillPageRequest.getMin_wbamount());
        } else if (withheldbillPageRequest.getMax_wbamount() != null) {
            queryWrapper.le("wbamount", withheldbillPageRequest.getMax_wbamount());
        }
        if (withheldbillPageRequest.getWbFinancialID() != null) queryWrapper.eq("wbFinancialID",withheldbillPageRequest.getWbFinancialID());
        //生成新的分页信息
        List<Withheldbill> withheldbills=withheldbillDao.selectList(queryWrapper);
        return Result.success(new PageInfo<>(withheldbills));
    }
}
