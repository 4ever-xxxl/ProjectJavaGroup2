package com.example;

import com.example.controller.Request.StaffapplicationrecordPageRequest;
import com.example.controller.StaffapplicationrecordController;
import com.example.entity.Staffapplicationrecord;
import com.example.service.Imp.StaffapplicationrecordService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Date;

@SpringBootTest
public class StaffapplicationrecordTest {
    @Resource
    private StaffapplicationrecordService sarService;

    @Resource
    private StaffapplicationrecordController sarController;

//    测试多条件查询
    @Test
    public void getSarByCondition() {
        System.out.println("[+] getSarByCondition");
//        Long SarID = 1L;
//        Long Cid = 0L;
//        Long Sid = 0L;
//        Date startTime = null;
//        Date endTime = null;
//        Date startTime = new Date("2000/7/11 00:00:00");
//        Date endTime = new Date("2021/7/11 12:00:00");
//        String Status = null;
        StaffapplicationrecordPageRequest sarPR = new StaffapplicationrecordPageRequest();
        sarPR.setSarPass("通过");
        sarPR.setPageSize(10);
        sarPR.setPageNum(1);
        System.out.println(sarPR);

//        for (Staffapplicationrecord sar : sarService.getSarByCondition(SarID, Cid, Sid, startTime, endTime, Status)) {
//            System.out.println(sar);
//        }
        for (Staffapplicationrecord sar : sarService.searchSar(sarPR)) {
            System.out.println(sar);
        }
    }

    // 测试新增记录
    @Test
    public void addSar(){
        System.out.println("[+] addSar");
        Staffapplicationrecord sar = new Staffapplicationrecord(1004L,new Date(),11L,"未处理");
        System.out.println(sar);
        System.out.println(sarService.addSar(sar));
    }

    // 测试修改
    @Test
    public void updateSar() {
        System.out.println("[+] updateSar");
        Staffapplicationrecord sar = new Staffapplicationrecord(93L,null,0,"通过");
        System.out.println(sarController.updateSar(sar));
    }




}
