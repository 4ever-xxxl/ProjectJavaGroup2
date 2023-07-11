package com.example.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.example.common.Result;
import com.example.controller.Request.StaffPageRequest;
import com.example.entity.Staff;
import com.example.entity.Staffapplicationrecord;
import com.example.service.IStaffService;
import com.example.service.IStaffapplicationrecordService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/Staff")
public class StaffController {
    @Autowired
    private IStaffService staffService;
    @Autowired
    private IStaffapplicationrecordService staffapplicationrecordService;
    @GetMapping("/getAllStaff")
    public Result getAllStaff()
    {
        try {
            System.out.println("成功staff");
            return Result.success(staffService.list());
        }
        catch (Exception e){
            return Result.error(e.getMessage());
        }
    }
    @GetMapping("/hello")
    private String hello()
    {
        return "hello";
    }
    @PostMapping("/addStaff")
    public Result addCompanyStuff(@RequestBody Staff staff)
    {
        try {
            staffService.addCompanyStuff(staff);
            return Result.success();
        }
        catch (Exception e)
        {
            return Result.error(e.getMessage());
        }
    }
    @PutMapping("/updateStaff")
    public Result updateStaff(@RequestBody Staff staff)
    {
        try {
            Staff staff1 =staffService.getStaffById(staff.getSId());
            System.out.println(staff1.getSName()+staff1.getSDisabled());
            if(staff1.getSDisabled()=="健康"&&staff.getSDisabled()=="残疾"){
                staffapplicationrecordService.addSar(new Staffapplicationrecord(0,new Date(),staff.getSId(),null));
                staffService.updateStaffHealth(staff.getSId());
                Staff staff2 =staffService.getStaffById(staff.getSId());
                System.out.println(staff2.getSName()+staff2.getSDisabled());
            }
            staffService.updateStaff(staff);
            return Result.success();
        }
        catch (Exception e)
        {
            return Result.error(e.getMessage());
        }
    }
    @DeleteMapping("/deleteStaff/{sId}")
    public Result deleteStaff(@PathVariable long sId){
        try{
            staffService.deleteStaff(sId);
            return Result.success();
        }
        catch (Exception e){
            return Result.error(e.getMessage());
        }
    }
    @PostMapping("/searchStaff")
    public Result searchStaff(@RequestBody StaffPageRequest staffPageRequest)
    {
        try{
        PageHelper.startPage(staffPageRequest.getPageNum(),staffPageRequest.getPageSize());
        List<Staff> staffs=staffService.searchStaff(staffPageRequest);
        return Result.success(new PageInfo<>(staffs));}
        catch (Exception e){
            return Result.error(e.getMessage());
        }
    }
    @GetMapping("/updateStaffHealth/{id}")
    public Result updateStaffHealth(@PathVariable long id)
    {
        try {
            staffService.updateStaffHealth(id);
            return Result.success();
        }
        catch (Exception e)
        {
            return Result.error(e.getMessage());
        }
    }
}


