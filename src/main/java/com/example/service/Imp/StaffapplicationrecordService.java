package com.example.service.Imp;

import com.example.dao.StaffapplicationrecordDao;
import com.example.entity.Staffapplicationrecord;
import com.example.service.IStaffService;
import com.example.service.IStaffapplicationrecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
* @author 86158
* @description 针对表【staffapplicationrecord(员工申请记录表)】的数据库操作Service实现
* @createDate 2023-07-11 09:28:57
*/
@Service
public class StaffapplicationrecordService implements IStaffapplicationrecordService {

    @Resource
    private IStaffService staffService;

    private final StaffapplicationrecordDao sarDao;


    @Autowired
    public StaffapplicationrecordService(StaffapplicationrecordDao sarDao) {
        this.sarDao = sarDao;
    }

    @Override
    public List<Staffapplicationrecord> getSarByCondition(long sarID, long cID, long sID, Date startTime, Date endTime, String status) {
        return sarDao.getSarByCondition(sarID, cID, sID, startTime, endTime, status);
    }

    @Override
    public int addSar(Staffapplicationrecord sar) {
        if(sar.getSarpass()==null) {
            sar.setSarpass("未处理");
        }
        return sarDao.addSar(sar);
    }

    @Override
    public int updateSar(Staffapplicationrecord sar) {
        try{
            sarDao.updateSar(sar);
//            if(sar.getSarpass()=="通过")
//                staffService.updateStaffHealth(sar.getsID());
            // 需要staff的直接更改健康残疾的接口
            return 1;
        }
        catch (Exception e){
            System.out.println("更新失败");

        }
        finally {
            return 0;
        }
    }

    @Override
    public int deleteSar(long sarID) {
        return sarDao.deleteSar(sarID);
    }
}




