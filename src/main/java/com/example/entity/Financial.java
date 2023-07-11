package com.example.entity;


public class Financial {

  private long fId;
  private String fregion;
  private long fParentId;


  public long getFId() {
    return fId;
  }

  public void setFId(long fId) {
    this.fId = fId;
  }


  public String getFregion() {
    return fregion;
  }

  public void setFregion(String fregion) {
    this.fregion = fregion;
  }


  public long getFParentId() {
    return fParentId;
  }

  public void setFParentId(long fParentId) {
    this.fParentId = fParentId;
  }

}
