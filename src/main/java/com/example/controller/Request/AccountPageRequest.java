package com.example.controller.Request;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class AccountPageRequest extends BaseRequest {
    private Long aid;
    private String abankcard;
    private BigDecimal abalance;
    private Date alastupdate;
}