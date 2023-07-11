package com.example.service;

import com.example.controller.Request.StaffPageRequest;
import com.example.entity.Staff;

import java.util.List;
public interface IStaffService {
    List<Staff> list();
    Staff getCompanyStaff(long companyId,long stuffId);
    void addCompanyStuff(Staff staff);
    void updateCompanyStaff(Staff staff);
    void deleteCompanyStaff(long sId);
    List<Staff> searchCompanyStaff(StaffPageRequest staffPageRequest);
}
