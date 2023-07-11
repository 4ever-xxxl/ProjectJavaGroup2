package com.example.controller.Request;

import lombok.Data;

import java.util.Date;

@Data
public class StaffapplicationrecordPageRequest extends BaseRequest {
    private Long sarID;
    private long sarStaffID;
    private long sarCompanyID;
    private Date startTime;
    private Date endTime;
    private String sarPass;
}
