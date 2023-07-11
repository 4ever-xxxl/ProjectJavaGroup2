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

    @Autowired
    StaffapplicationrecordDao sarDao;

    @PostMapping("/searchStaffapplicationrecord")
    public Result searchSar(@RequestBody StaffapplicationrecordPageRequest sarPageRequest){
        PageHelper.startPage(sarPageRequest.getPageNum(),sarPageRequest.getPageSize());
        if(sarPageRequest.getSarID() != null) {
            sarService.getSarByCondition(sarPageRequest.getSarID(),0L,0L,null,null,null).get(0);
            return Result.success(sarService.getSarByCondition(sarPageRequest.getSarID(),0L,0L,null,null,null).get(0));
        }
        QueryWrapper<Staffapplicationrecord> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(sarPageRequest.getSarStaffID()!=null,"sarstaffid",sarPageRequest.getSarStaffID())
                .eq(sarPageRequest.getSarStaffID()!=null,"sarstaffid",sarPageRequest.getSarStaffID())
                .inSql(sarPageRequest.getSarCompanyID()!=null,"sarcompanyid","select sCompanyID from staffapplicationrecord left join staff on staff.sID=staffapplicationrecord.sarstaffid where staff.sCompanyID="+sarPageRequest.getSarCompanyID())
                .le(sarPageRequest.getStartTime()!=null,"starttime",sarPageRequest.getStartTime())
                .ge(sarPageRequest.getEndTime()!=null,"endtime",sarPageRequest.getEndTime())
                .eq(sarPageRequest.getSarPass()!=null,"sarpass",sarPageRequest.getSarPass());

        List<Staffapplicationrecord> Sars = sarDao.selectList(queryWrapper);
        return Result.success(new PageInfo<>(Sars));
    }

//    @PostMapping("/searchStaffapplicationrecord")
//    public Result getSarByCondition(@RequestBody StaffapplicationrecordPageRequest sarPageRequest){
//        PageHelper.startPage(sarPageRequest.getPageNum(),sarPageRequest.getPageSize());
//        List<Staffapplicationrecord> Sars = sarService.searchSar(sarPageRequest);
//        StaffapplicationrecordResponce res = new StaffapplicationrecordResponce();
//        res.setList(Sars);
//        res.setTotal(sarService.searchSarCount(sarPageRequest));
//        return Result.success(new PageInfo<>(Sars));
//    }

    @PostMapping("/addStaffapplicationrecord")
    public Result addSar(@RequestBody Staffapplicationrecord sar){
        return Result.success(sarService.addSar(sar));
    }

    @PutMapping("/updateStaffapplicationrecord")
    public Result updateSar(@RequestBody Staffapplicationrecord sar){
        try{
            sarService.updateSar(sar);
            if(sar.getSarpass()=="通过"){
//                System.out.println("更新成功");
                Staffapplicationrecord tmpSar=sarService.getSarByCondition(sar.getSarid(),0L,0L,null,null,null).get(0);
                System.out.println(tmpSar.getSarstaffid());
                staffService.updateStaffHealth(tmpSar.getSarstaffid());
            }
            return Result.success("更新成功");
        }catch (Exception e){
            return Result.error("更新失败");
        }
    }

    @GetMapping("/deleteStaffapplicationrecord/{sarID}")
    public Result deleteSar(@PathVariable("sarID") Long sarID){
        return Result.success(sarService.deleteSar(sarID));
    }
}

