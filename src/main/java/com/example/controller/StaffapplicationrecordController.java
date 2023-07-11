package com.example.controller;


import com.example.common.Result;
import com.example.controller.Request.StaffapplicationrecordPageRequest;
import com.example.dao.StaffapplicationrecordDao;
import com.example.entity.Staffapplicationrecord;
import com.example.service.IStaffService;
import com.example.service.IStaffapplicationrecordService;
import com.example.service.Imp.StaffapplicationrecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

@RestController
@RequestMapping("/Staffapplicationrecord")
public class StaffapplicationrecordController {

    @Autowired
    IStaffapplicationrecordService sarService;

    @Autowired
    IStaffService staffService;

    @PostMapping("/getSarByCondition")
    public Result getSarByCondition(@RequestBody StaffapplicationrecordPageRequest sarPageRequest){
        Long sarID = sarPageRequest.getSarID();
        Long sID = sarPageRequest.getSarStaffID();
        Long cID = sarPageRequest.getSarCompanyID();
        Date startTime = sarPageRequest.getStartTime();
        Date endTime = sarPageRequest.getEndTime();
        String sarPass = sarPageRequest.getSarPass();
        return Result.success(sarService.getSarByCondition(sarID,sID,cID,startTime,endTime,sarPass));
    }

    @PostMapping("/addSar")
    public Result addSar(@RequestBody Staffapplicationrecord sar){
        return Result.success(sarService.addSar(sar));
    }

    @PostMapping("/updateSar")
    public Result updateSar(@RequestBody Staffapplicationrecord sar){
        try{
            sarService.updateSar(sar);
            if(sar.getSarpass()=="通过"){
                System.out.println("更新成功");
                Staffapplicationrecord tmpSar=sarService.getSarByCondition(sar.getSarid(),0L,0L,null,null,null).get(0);
                System.out.println(tmpSar.getSarstaffid());
                staffService.updateStaffHealth(tmpSar.getSarstaffid());
            }
            return Result.success("更新成功");
        }catch (Exception e){
            return Result.error("更新失败");
        }
    }

    @GetMapping("/deleteSar/{sarID}")
    public Result deleteSar(@PathVariable("sarID") Long sarID){
        return Result.success(sarService.deleteSar(sarID));
    }
}

