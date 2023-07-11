package com.example.service;

import com.example.common.Result;
import com.example.controller.Request.StaffapplicationrecordPageRequest;
import com.example.entity.Staffapplicationrecord;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Date;
import java.util.List;

/**
* @author 86158
* @description 针对表【staffapplicationrecord(员工申请记录表)】的数据库操作Service
* @createDate 2023-07-11 09:28:57
*/
public interface IStaffapplicationrecordService{

    List<Staffapplicationrecord> getSarByCondition(long sarID, long cID, long sID, Date startTime, Date endTime, String status);

    List<Staffapplicationrecord> searchSar(StaffapplicationrecordPageRequest SarPR);

    int addSar(Staffapplicationrecord sar);

    int updateSar(Staffapplicationrecord sar);

    int deleteSar(long sarID);

    Long searchSarCount(StaffapplicationrecordPageRequest SarPR);
}
