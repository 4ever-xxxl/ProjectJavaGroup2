package com.example.controller;


import com.example.common.Result;
import com.example.controller.Request.StaffapplicationrecordPageRequest;
import com.example.dao.StaffapplicationrecordDao;
import com.example.entity.Staffapplicationrecord;
import com.example.service.Imp.StaffapplicationrecordService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

@RestController
@RequestMapping("/Staffapplicationrecord")
public class StaffapplicationrecordController {

    @Resource
    private StaffapplicationrecordService sarservice;

    @Resource
    private StaffapplicationrecordDao sardao;

    @PostMapping("/getSarByCondition")
    public Result getSarByCondition(@RequestBody StaffapplicationrecordPageRequest sarPageRequest){
        Long sarID = sarPageRequest.getSarID();
        Long sID = sarPageRequest.getSarStaffID();
        Long cID = sarPageRequest.getSarCompanyID();
        Date startTime = sarPageRequest.getStartTime();
        Date endTime = sarPageRequest.getEndTime();
        String sarPass = sarPageRequest.getSarPass();
        return Result.success(sardao.getSarByCondition(sarID,sID,cID,startTime,endTime,sarPass));
    }

    @PostMapping("/addSar")
    public Result addSar(@RequestBody Staffapplicationrecord sar){
        return Result.success(sardao.addSar(sar));
    }

    @PostMapping("/updateSar")
    public Result updateSar(@RequestBody Staffapplicationrecord sar){
        return Result.success(sardao.updateSar(sar));
    }




}

