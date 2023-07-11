package com.example.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Expensebill {
    private long ebID;
    private long ebFinancialID;
    private long ebAccountID;
    private BigDecimal ebAmount;
    private Date ebTime;
    private String ebObject;

    public Expensebill(long ebID,long ebFinancialID,long ebAccountID,BigDecimal ebAmount,Date ebTime,String ebObject){
        this.ebAccountID=ebAccountID;
        this.ebAmount=ebAmount;
        this.ebID=ebID;
        this.ebTime=ebTime;
        this.ebObject=ebObject;
        this.ebFinancialID=ebFinancialID;
    }
    public Expensebill(){

    }
}
