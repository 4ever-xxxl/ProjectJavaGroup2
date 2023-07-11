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
    @GetMapping("/getAllStaff")
    public Result getAllStaff()
    {
        System.out.println("成功staff");
        return Result.success(staffService.list());
    }
    @GetMapping("/hello")
    private String hello()
    {
        return "hello";
    }
    @PostMapping("/addStaff")
    public Result addCompanyStuff(@RequestBody Staff staff)
    {
        staffService.addCompanyStuff(staff);
        return Result.success();
    }

    @PutMapping("/updateStaff")
    public Result updateStaff(@RequestBody Staff staff)
    {
        staffService.updateStaff(staff);
        return Result.success();
    }

    @DeleteMapping("/deleteStaff/{sId}")
    public Result deleteStaff(@PathVariable long sId){
        staffService.deleteStaff(sId);
        return Result.success();
    }

    @PostMapping("/searchStaff")
    public Result searchStaff(@RequestBody StaffPageRequest staffPageRequest)
    {
        PageHelper.startPage(staffPageRequest.getPageNum(),staffPageRequest.getPageSize());
        List<Staff> staffs=staffService.searchStaff(staffPageRequest);

        //生成新的分页信息
        return Result.success(new PageInfo<>(staffs));
    }

}
