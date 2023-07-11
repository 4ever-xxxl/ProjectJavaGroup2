package com.example;

import com.example.dao.StaffDao;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class StaffTest {
    @Resource
    private StaffDao staffdao;

    /*
     要使用此测试方法，需将StaffPageRequest中的相关属性访问权限更改为public
    @Test
    public void searchStaff(){
        StaffPageRequest staffPageRequest=new StaffPageRequest();
        staffPageRequest.minSalary=2000;
        staffPageRequest.maxSalary=10000;
        for (Staff staff:
                staffdao.searchCompanyStaff(staffPageRequest)) {
            System.out.println(staff);
        }
    }

    */
}
