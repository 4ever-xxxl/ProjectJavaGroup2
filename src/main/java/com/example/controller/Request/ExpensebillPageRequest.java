package com.example.controller.Request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class ExpensebillPageRequest extends BaseRequest{
    @JsonProperty("ebID")
    private long ebID;
    @JsonProperty("ebAccountID")
    private long ebAccountID;
    @JsonProperty("ebFinancialID")
    private long ebFinancialID;
    @JsonProperty("ebObject")
    private String ebObject;
    @JsonProperty("maxAmount")
    private double maxAmount;
    @JsonProperty("minAmount")
    private double minAmount;
    @JsonProperty("maxDate")
    public Date maxDate;
    @JsonProperty("minDate")
    public Date minDate;
}
