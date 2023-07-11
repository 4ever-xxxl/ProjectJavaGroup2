package com.example.controller;

import com.example.common.Result;
import com.example.controller.Request.ExpensebillPageRequest;
import com.example.dao.ExpensebillDao;
import com.example.entity.Expensebill;
import com.example.service.Imp.ExpensebillService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/Expensebill")
public class ExpensebillController {

    @Resource
    private ExpensebillService expensebillservice;
    @Resource
    private ExpensebillDao expensebilldao;

    @GetMapping("/getExpensebillByEbId/{ebID}")
    public Result getExpensebillByEbId(@PathVariable long ebID){
        return Result.success(expensebilldao.getExpensebillByEbId(ebID));
    }
    @GetMapping("/getExpensebillByEbfId/{ebFinancialID}")
    public Result getExpensebillByEbfId(@PathVariable long ebFinancialID){
        return Result.success(expensebilldao.getExpensebillByEbfId(ebFinancialID));
    }
    @GetMapping("/getExpensebillById/{ebAccountID}")
    public Result getExpensebillByEbaId(@PathVariable long ebAccountID){
        return Result.success(expensebilldao.getExpensebillByEbaId(ebAccountID));
    }


    @GetMapping("/getAllExpensebill")
    public Result getExpensebillById(){
        return Result.success(expensebilldao.getAllExpensebill());
    }


    @PostMapping("/addExpensebill")
    public Result addExpensebillStuff(@RequestBody Expensebill expensebill)
    {
        return expensebillservice.addExpensebill(expensebill);
    }

    @PutMapping("/updateExpensebill")
    public Result updateExpensebill(@RequestBody Expensebill expensebill)
    {
        return expensebillservice.updateExpensebill(expensebill);
    }

    @DeleteMapping("/deleteExpensebill/{ebID}")
    public Result deleteExpensebill(@PathVariable long ebID){
        return  expensebillservice.deleteExpensebillById(ebID);
    }

    @PostMapping("/searchExpensebill")
    public Result searchExpensebill(@RequestBody ExpensebillPageRequest expensebillpagerequest)
    {
        PageHelper.startPage(expensebillpagerequest.getPageNum(),expensebillpagerequest.getPageSize());
        List<Expensebill> expensebills=expensebillservice.searchExpensebill(expensebillpagerequest);

        return Result.success(new PageInfo<>(expensebills));
    }
}