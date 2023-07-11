package com.example.service.Imp;

import com.example.controller.Request.StaffPageRequest;
import com.example.dao.StaffDao;
import com.example.entity.Staff;
import com.example.service.IStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StaffService implements IStaffService {

    private final StaffDao staffDao;
    @Autowired
    public StaffService(StaffDao staffDao) {
        this.staffDao = staffDao;
    }
    @Override
    public List<Staff> list(){
        return staffDao.list();
    }
    @Override
    public Staff getCompanyStaff(long companyId,long stuffId)   {
        return staffDao.getCompanyStaff(companyId,stuffId);
    }
    @Override
    public void addCompanyStuff(Staff staff){
        staffDao.addCompanyStuff(staff);
    }
    @Override
    public void updateCompanyStaff(Staff staff)
    {
        staffDao.updateCompanyStaff(staff);
    }
    @Override
    public void deleteCompanyStaff(long sId)
    {
        staffDao.deleteCompanyStaff(sId);
    }
    @Override
    public List<Staff> searchCompanyStaff(StaffPageRequest staffPageRequest){
        return staffDao.searchCompanyStaff(staffPageRequest);
    }
}
