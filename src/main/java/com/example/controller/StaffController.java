package com.example.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.example.common.Result;
import com.example.controller.Request.StaffPageRequest;
import com.example.controller.Response.StaffResponse;
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
        return Result.success(staffService.list());
    }
    @GetMapping("/hello")
    private String hello()
    {
        return "hello";
    }
    @GetMapping("/{companyId}/{staffId}")
    public Result getCompanyStaff(@PathVariable long companyId,@PathVariable long staffId){

        return Result.success(staffService.getCompanyStaff(companyId,staffId));
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

    @DeleteMapping("/deleteCompanyStaff/{companyId}/{sId}")
    public Result deleteCompanyStaff(@PathVariable long companyId,@PathVariable long sId){
        staffService.deleteCompanyStaff(companyId,sId);
        return Result.success();
    }

    @PostMapping("/searchCompanyStaff")
    public Result searchCompanyStaff(@RequestBody StaffPageRequest staffPageRequest)
    {
        PageHelper.startPage(staffPageRequest.getPageNum(),staffPageRequest.getPageSize());
        List<Staff> staffs=staffService.searchCompanyStaff(staffPageRequest);
        PageInfo<Staff> pageInfo=new PageInfo<>(staffs);
        List<Staff> staff=pageInfo.getList();
        StaffResponse staffResponse =new StaffResponse("staff",staff);
        staffResponse.setTotal(pageInfo.getTotal());
        return Result.success(staffResponse);
    }

    @PostMapping("importUnitEmployees")
    public Result importUnitEmployees()
    {
        return Result.success();
    }

    @GetMapping("/exportUnitEmployees")
    public Result exportUnitEmployees(@RequestBody StaffPageRequest staffPageRequest)
    {
        System.out.println(staffPageRequest.getPageNum());
        PageHelper.startPage(staffPageRequest.getPageNum(),staffPageRequest.getPageSize());
        List<Staff> staffs=staffService.searchCompanyStaff(staffPageRequest);
        List<Staff> staff=new PageInfo<>(staffs).getList();
        ExcelWriter excelWriter = EasyExcel.write(staffPageRequest.getPath(),Staff.class).build();
        WriteSheet sheet=EasyExcel.writerSheet("staff").build();

        try {
            excelWriter.write(staff, sheet);
        } catch (Exception e) {
            // 处理异常的代码
            e.printStackTrace(); // 输出异常堆栈轨迹信息
            // 其他异常处理逻辑...
        }
        excelWriter.finish();
        System.out.println(staff.get(1).getSName());
        return Result.success();
    }

}
