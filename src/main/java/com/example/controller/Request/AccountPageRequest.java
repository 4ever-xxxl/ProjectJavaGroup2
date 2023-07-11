package com.example.controller.Request;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class AccountPageRequest extends BaseRequest {
    //数据型按精确值查找，日期按范围查找，字符串模糊查找
    private Long aid;
    private String abankcard;
    private BigDecimal abalance;
    private Date max_alastupdate;
    private Date min_alastupdate;
}