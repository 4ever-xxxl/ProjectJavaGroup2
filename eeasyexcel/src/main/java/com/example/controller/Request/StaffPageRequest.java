package com.example.controller.Request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class StaffPageRequest extends BaseRequest{

    @JsonProperty("name")
    private String name;
    @JsonProperty("maxSalary")
    private double maxSalary;
    @JsonProperty("minSalary")
    private double minSalary;
    @JsonProperty("disabled")
    private String disabled;
    @JsonProperty("address")
    private String address;
    @JsonProperty("path")
    private String path;
}
