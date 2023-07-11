package com.example.entity;


import com.alibaba.excel.annotation.ExcelProperty;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

//@Data
public class Staff {

  //@JsonProperty("sId")
  //@ExcelProperty(value = "ID", index = 0)
  private long sId;

  //@JsonProperty("sName")
  //@ExcelProperty(value = "姓名", index = 1)
  private String sName;

  //@JsonProperty("sSex")
  //@ExcelProperty(value = "性别", index = 2)
  private String sSex;

  //@JsonProperty("sIdNum")
  //@ExcelProperty(value = "身份证", index = 3)
  private String sIdNum;

  //@JsonProperty("sPhone")
  //@ExcelProperty(value = "电话号码", index = 4)
  private String sPhone;

  //@JsonProperty("sCompanyId")
  //@ExcelProperty(value = "公司ID", index = 5)
  private long sCompanyId;

  //@JsonProperty("sDisabled")
  //@ExcelProperty(value = "是否残疾", index = 6)
  private String sDisabled;

  //@JsonProperty("sAddress")
  //@ExcelProperty(value = "地址", index = 7)
  private String sAddress;

  //@JsonProperty("sEduBackground")
  //@ExcelProperty(value = "名字", index = 8)
  private String sEduBackground;

  //@JsonProperty("sPosition")
  //@ExcelProperty(value = "支撑", index = 9)
  private String sPosition;

 //@JsonProperty("sHireDate")
  //@ExcelProperty(value = "入职日期", index = 10)
  private Date sHireDate;

  //@JsonProperty("sSalary")
  //@ExcelProperty(value = "薪水", index = 11)
  private double sSalary;


  public long getSId() {
    return sId;
  }

  public void setSId(long sId) {
    this.sId = sId;
  }


  public String getSName() {
    return sName;
  }

  public void setSName(String sName) {
    this.sName = sName;
  }


  public String getSSex() {
    return sSex;
  }

  public void setSSex(String sSex) {
    this.sSex = sSex;
  }


  public String getSIdNum() {
    return sIdNum;
  }

  public void setSIdNum(String sIdNum) {
    this.sIdNum = sIdNum;
  }


  public String getSPhone() {
    return sPhone;
  }

  public void setSPhone(String sPhone) {
    this.sPhone = sPhone;
  }


  public long getSCompanyId() {
    return sCompanyId;
  }

  public void setSCompanyId(long sCompanyId) {
    this.sCompanyId = sCompanyId;
  }


  public String getSDisabled() {
    return sDisabled;
  }

  public void setSDisabled(String sDisabled) {
    this.sDisabled = sDisabled;
  }


  public String getSAddress() {
    return sAddress;
  }

  public void setSAddress(String sAddress) {
    this.sAddress = sAddress;
  }


  public String getSEduBackground() {
    return sEduBackground;
  }

  public void setSEduBackground(String sEduBackground) {
    this.sEduBackground = sEduBackground;
  }


  public String getSPosition() {
    return sPosition;
  }

  public void setSPosition(String sPosition) {
    this.sPosition = sPosition;
  }


  public Date getSHireDate() {
    return sHireDate;
  }

  public void setSHireDate(java.sql.Date sHireDate) {
    this.sHireDate = sHireDate;
  }


  public double getSSalary() {
    return sSalary;
  }

  public void setSSalary(double sSalary) {
    this.sSalary = sSalary;
  }


    @Override
    public String toString() {
        return "Staff{" +
                "sId=" + sId +
                ", sName='" + sName + '\'' +
                ", sSex='" + sSex + '\'' +
                ", sIdNum='" + sIdNum + '\'' +
                ", sPhone='" + sPhone + '\'' +
                ", sCompanyId=" + sCompanyId +
                ", sDisabled='" + sDisabled + '\'' +
                ", sAddress='" + sAddress + '\'' +
                ", sEduBackground='" + sEduBackground + '\'' +
                ", sPosition='" + sPosition + '\'' +
                ", sHireDate=" + sHireDate +
                ", sSalary=" + sSalary +
                '}';
    }

}
