package com.example.dao;

import com.example.controller.Request.StaffPageRequest;
import com.example.entity.Staff;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Component
public interface StaffDao {
    List<Staff> list();
    Staff getStaff(@Param("companyId")long companyId,@Param("staffId") long staffId);
    void addCompanyStuff(Staff staff);
    void updateStaff(Staff staff);
    void deleteStaff(long sId);
    List<Staff> searchStaff(StaffPageRequest staffPageRequest);
    void updateStaffHealth(long id);
}
