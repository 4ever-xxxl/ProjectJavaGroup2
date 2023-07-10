package com.example.controller.Request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class ExpensebillPageRequest extends BaseRequest{

    @JsonProperty("ebObject")
    private String ebObject;
    @JsonProperty("maxAmount")
    public double maxAmount;
    @JsonProperty("minAmount")
    public double minAmount;
    @JsonProperty("maxDate")
    public Date maxDate;
    @JsonProperty("minDate")
    public Date minDate;
}
