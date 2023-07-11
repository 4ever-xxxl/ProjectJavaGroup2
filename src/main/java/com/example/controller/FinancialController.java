package com.example.controller;

import com.example.common.Result;
import com.example.controller.Request.FinancialPageRequest;
import com.example.controller.Request.StaffPageRequest;
import com.example.entity.Financial;
import com.example.entity.Staff;
import com.example.service.IFinancialService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/Financial")
public class FinancialController {

    @Autowired
    private IFinancialService financialService;
    @GetMapping("/getAllFinancial")
    public Result getAllFinancial(){
        System.out.println("成功");
        return Result.success(financialService.getAllFinancial());
    }
    @DeleteMapping("/deleteFinancial/{fId}")
    public Result deleteFinancial(@PathVariable int fId){
        financialService.deleteFinancial(fId);
        return Result.success();
    }
    @PostMapping("/addFinancial")
    public Result addCompanyStuff(@RequestBody Financial financial)
    {
        financialService.addFinancial(financial);
        return Result.success();
    }

    @PutMapping("/updateFinancial")
    public Result updateStaff(@RequestBody Financial financial)
    {
        financialService.updateFinancial(financial);
        return Result.success();
    }

    @PostMapping("/searchFinancial")
    public Result searchStaff(@RequestBody FinancialPageRequest financialPageRequest){
        PageHelper.startPage(financialPageRequest.getPageNum(),financialPageRequest.getPageSize());
        System.out.println(financialPageRequest);
        List<Financial> financials=financialService.searchFinancial(financialPageRequest);
        //生成新的分页信息
        PageInfo<Financial> pageInfo=new PageInfo<>(financials);
        List<Financial> financial=pageInfo.getList();
        return Result.success(new PageInfo<>(financials));
    }

}
