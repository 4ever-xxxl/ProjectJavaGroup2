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
    public void addCompanyStuff(Staff staff){
        staffDao.addCompanyStuff(staff);
    }
    @Override
    public void updateStaff(Staff staff)
    {
        staffDao.updateStaff(staff);
    }
    @Override
    public void updateStaffHealth(long id)
    {
        staffDao.updateStaffHealth(id);
    }
    @Override
    public void deleteStaff(long sId)
    {
        staffDao.deleteStaff(sId);
    }
    @Override
    public List<Staff> searchStaff(StaffPageRequest staffPageRequest){
        return staffDao.searchStaff(staffPageRequest);
    }
}
