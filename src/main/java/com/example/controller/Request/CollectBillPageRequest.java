package com.example.controller.Request;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class CollectBillPageRequest extends BaseRequest{
    //数据型按精确值查找，日期按范围查找，字符串模糊查找
    private Long cbid;
    private Long cbaccountid;
    private Long cbcompanyid;
    private BigDecimal cbdue;
    private BigDecimal cbrelief;
    private Date max_cbduedate;
    private Date min_cbduedate;
    private Date max_cbdelaydate;
    private Date min_cbdelaydate;
    private String cbstatement;
    private Date max_cbstatetime;
    private Date min_cbstatetime;
}
