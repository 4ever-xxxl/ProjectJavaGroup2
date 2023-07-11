package com.example.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.example.common.Result;
import com.example.controller.Request.StaffPageRequest;
import com.example.entity.Staff;
import com.example.service.IStaffService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/Staff")
public class StaffController {
    @Autowired
    private IStaffService staffService;


    @GetMapping("/getAllCompanyStaff")
    public Result getAllCompanyStaff()
    {
        System.out.println("成功staff");
        return Result.success(staffService.list());
    }
    @GetMapping("/hello")
    private String hello()
    {
        return "hello";
    }
    @PostMapping("/addCompanyStaff")
    public Result addCompanyStuff(@RequestBody Staff staff)
    {
        staffService.addCompanyStuff(staff);
        return Result.success();
    }

    @PutMapping("/updateCompanyStaff")
    public Result updateCompanyStaff(@RequestBody Staff staff)
    {
        staffService.updateCompanyStaff(staff);
        return Result.success();
    }

    @DeleteMapping("/deleteCompanyStaff/{sId}")
    public Result deleteCompanyStaff(@PathVariable long sId){
        staffService.deleteCompanyStaff(sId);
        return Result.success();
    }

    @PostMapping("/searchCompanyStaff")
    public Result searchCompanyStaff(@RequestBody StaffPageRequest staffPageRequest)
    {
        PageHelper.startPage(staffPageRequest.getPageNum(),staffPageRequest.getPageSize());
        List<Staff> staffs=staffService.searchCompanyStaff(staffPageRequest);

        //生成新的分页信息
        PageInfo<Staff> pageInfo=new PageInfo<>(staffs);
        List<Staff> staff=pageInfo.getList();
        return Result.success(staff);
    }

}
