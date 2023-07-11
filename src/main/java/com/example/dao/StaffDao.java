package com.example.dao;

import com.example.controller.Request.StaffPageRequest;
import com.example.entity.Staff;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import com.example.controller.Request.BaseRequest;
import java.util.List;

@Repository
@Component
public interface StaffDao {
//    List<Staff> getAllStaff();
//    void saveStaff(Staff staff);
    List<Staff> list();
//    List<Staff> getStaffByCondition(BaseRequest baseRequest);
//    Staff getStaffById(Integer id);
//    List<Staff> getStaffbyname(String name);
//    void updateDisablityByNo(String idname);
    Staff getCompanyStaff(@Param("companyId")long companyId,@Param("staffId") long staffId);
    void addCompanyStuff(Staff staff);
    void updateCompanyStaff(Staff staff);
    void deleteCompanyStaff(long sId);
    List<Staff> searchCompanyStaff(StaffPageRequest staffPageRequest);
}
