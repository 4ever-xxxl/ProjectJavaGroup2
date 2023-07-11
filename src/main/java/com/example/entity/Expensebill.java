package com.example.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Expensebill {
    private long ebID;
    private long ebFinancialID;
    private long ebAccountID;
    private double ebAmount;
    private Date ebTime;
    private String ebObject;

    public Expensebill(long ebID,long ebFinancialID,long ebAccountID,double ebAmount,Date ebTime,String ebObject){
        this.ebAccountID=ebAccountID;
        this.ebAmount=ebAmount;
        this.ebID=ebID;
        this.ebTime=ebTime;
        this.ebObject=ebObject;
        this.ebFinancialID=ebFinancialID;
    }

}
