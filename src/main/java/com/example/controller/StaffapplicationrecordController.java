package com.example.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.common.Result;
import com.example.controller.Request.StaffapplicationrecordPageRequest;
import com.example.controller.Responce.StaffapplicationrecordResponce;
import com.example.dao.StaffapplicationrecordDao;
import com.example.entity.Staffapplicationrecord;
import com.example.service.IStaffService;
import com.example.service.IStaffapplicationrecordService;
import com.example.service.Imp.StaffapplicationrecordService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/Staffapplicationrecord")
public class StaffapplicationrecordController {

    @Autowired
    IStaffapplicationrecordService sarService;

    @Autowired
    IStaffService staffService;

//    @PostMapping("/searchStaffapplicationrecord")
//    public Result getSarByCondition(@RequestBody StaffapplicationrecordPageRequest sarPageRequest){
//        Long sarID = sarPageRequest.getSarID();
//        Long sID = sarPageRequest.getSarStaffID();
//        Long cID = sarPageRequest.getSarCompanyID();
//        Date startTime = sarPageRequest.getStartTime();
//        Date endTime = sarPageRequest.getEndTime();
//        String sarPass = sarPageRequest.getSarPass();
//        return Result.success(sarService.getSarByCondition(sarID,sID,cID,startTime,endTime,sarPass));
//    }

    @PostMapping("/searchStaffapplicationrecord")
    public Result getSarByCondition(@RequestBody StaffapplicationrecordPageRequest sarPR){
        System.out.println("----------");
        System.out.println(sarPR);
        System.out.println("----------");
        PageHelper.startPage(sarPR.getPageNum(),sarPR.getPageSize());
        return Result.success( new PageInfo<>(sarService.searchSar(sarPR)));
    }

    @PostMapping("/addStaffapplicationrecord")
    public Result addSar(@RequestBody Staffapplicationrecord sar){
        System.out.println(sar.getSarid());
        return Result.success(sarService.addSar(sar));
    }

    @PutMapping("/updateStaffapplicationrecord")
    public Result updateSar(@RequestBody Staffapplicationrecord sar){
        try{
            System.out.println("更新");
            System.out.println(sar);
            sarService.updateSar(sar);
            if(sar.getSarpass().equals("通过")) {
//                System.out.println("更新成功");
                Staffapplicationrecord tmpSar = sarService.getSarByCondition(sar.getSarid(), 0L, 0L, null, null, null).get(0);
                System.out.println(tmpSar.getSarstaffid());
                staffService.updateStaffHealth(tmpSar.getSarstaffid());
            }
            return Result.success("更新成功");

        }catch (Exception e){
            return Result.error("更新失败");
        }
    }

    @DeleteMapping("/deleteStaffapplicationrecord/{sarID}")
    public Result deleteSar(@PathVariable("sarID") Long sarID){
        return Result.success(sarService.deleteSar(sarID));
    }

    @PostMapping("/getsomething")
    public Result getsomething(@RequestBody StaffapplicationrecordPageRequest sarPR){
        System.out.println("----------");
        System.out.println(sarPR);
        System.out.println("----------");
        PageHelper.startPage(sarPR.getPageNum(),sarPR.getPageSize());
        QueryWrapper<Staffapplicationrecord> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("sar_staff_id",sarPR.getSarStaffID());
        return Result.success( new PageInfo<>(sarService.searchSar(sarPR)));
    }

}

