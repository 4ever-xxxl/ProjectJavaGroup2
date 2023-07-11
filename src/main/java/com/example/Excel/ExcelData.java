package com.example.Excel;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ExcelData {
    private Long cbid;
    private Long cbaccountid;
    private Long cbcompanyid;
    private BigDecimal cbdue;
    private BigDecimal cbrelief;
    private Date cbduedate;
    private Date cbdelaydate;
    private String cbstatement;
    private Date cbstatetime;
}
