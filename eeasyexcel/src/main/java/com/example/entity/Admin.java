package com.example.entity;


public class Admin {

  private long usrId;
  private String usrName;
  private String usrPasswd;
  private long usrClass;
  private long usrPermission;


  public long getUsrId() {
    return usrId;
  }

  public void setUsrId(long usrId) {
    this.usrId = usrId;
  }


  public String getUsrName() {
    return usrName;
  }

  public void setUsrName(String usrName) {
    this.usrName = usrName;
  }


  public String getUsrPasswd() {
    return usrPasswd;
  }

  public void setUsrPasswd(String usrPasswd) {
    this.usrPasswd = usrPasswd;
  }


  public long getUsrClass() {
    return usrClass;
  }

  public void setUsrClass(long usrClass) {
    this.usrClass = usrClass;
  }


  public long getUsrPermission() {
    return usrPermission;
  }

  public void setUsrPermission(long usrPermission) {
    this.usrPermission = usrPermission;
  }

}
