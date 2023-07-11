package com.example.service;

import com.example.controller.Request.StaffPageRequest;
import com.example.entity.Staff;

import java.util.List;
public interface IStaffService {
    List<Staff> list();
    Staff getStaff(long companyId,long stuffId);
    void addCompanyStuff(Staff staff);
    void updateStaff(Staff staff);
    void deleteStaff(long sId);
    List<Staff> searchStaff(StaffPageRequest staffPageRequest);
}
