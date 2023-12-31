package com.example.controller.Request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class StaffapplicationrecordPageRequest extends BaseRequest {
    @JsonProperty("sarID")
    private Long sarID;
    @JsonProperty("sarStaffID")
    private Long sarStaffID;
    @JsonProperty("sarCompanyID")
    private Long sarCompanyID;
    @JsonProperty("startTime")
    private Date startTime;
    @JsonProperty("endTime")
    private Date endTime;
    @JsonProperty("sarPass")
    private String sarPass;
}
