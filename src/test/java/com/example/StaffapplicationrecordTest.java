package com.example;

import com.example.dao.StaffapplicationrecordDao;
import com.example.entity.Staffapplicationrecord;
import com.example.service.Imp.StaffapplicationrecordService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Date;

@SpringBootTest
public class StaffapplicationrecordTest {
    @Resource
    private StaffapplicationrecordDao sarDao;

//    测试多条件查询
    @Test
    public void getSarByCondition() {
        System.out.println("[+] getSarByCondition");
        Long SarID = 0L;
        Long Cid = 0L;
        Long Sid = 0L;
        Date startTime = new Date("2000/7/11 00:00:00");
        Date endTime = new Date("2021/7/11 12:00:00");
        String Status = null;
        for (Staffapplicationrecord sar : sarDao.getSarByCondition(SarID, Cid, Sid, startTime, endTime, Status)) {
            System.out.println(sar);
        }
    }

    // 测试新增记录
    @Test
    public void addSar(){
        System.out.println("[+] addSar");
        Staffapplicationrecord sar = new Staffapplicationrecord(1000L,new Date("1145/1/14 12:00:00"),10L,"未处理");
        System.out.println(sar);
        System.out.println(sarDao.addStaffapplicationrecord(sar));
    }




}
