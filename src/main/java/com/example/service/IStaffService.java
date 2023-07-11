package com.example.service;

import com.example.controller.Request.StaffPageRequest;
import com.example.entity.Staff;
import org.apache.ibatis.annotations.Param;

import java.util.List;
public interface IStaffService {
    List<Staff> list();
    void addCompanyStuff(Staff staff);
    void updateStaff(Staff staff);
    void deleteStaff(long sId);
    List<Staff> searchStaff(StaffPageRequest staffPageRequest);
    void updateStaffHealth(long Id);
    Staff getStaffById(long staffId);
}
