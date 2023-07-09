package com.example;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.example.dao.AdminDao;
import com.example.dao.StaffDao;
import com.example.entity.Staff;
import com.example.service.Imp.StaffService;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.apache.ibatis.session.RowBounds;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestDao extends EasyexcelApplicationTests{

    @Autowired
    private StaffDao staffDao;
    @Autowired
    private AdminDao adminDao;
    /*
    @Test
    public void test(){/*
        Student std= new Student() ;
        RowBounds rowBounds=new RowBounds(1,10);
        List<Student> Students=student.selectByRowBounds(std,rowBounds);
        for (Student T: Students){
            System.out.println(T);
        }
    }
    public class StudentListener extends AnalysisEventListener<Student> {

        @Override
        public void invoke(Student data, AnalysisContext context) {
            //每读取一条数据就调用该方法一次，我这里没有与数据库进行交互，纯输出读取到的对象
            System.out.println(data);
        }

        @Override
        public void doAfterAllAnalysed(AnalysisContext context) {
            //读取结束会调用该方法
            System.out.println("end...");
        }
    }

    @Test
    public void excelOut()
    {
        String path="C:\\Users\\Administrator\\Desktop\\test4.xlsx";
        Student std= new Student() ;
        RowBounds rowBounds=new RowBounds(0,10);
        List<Student> Students=student.selectByRowBounds(std,rowBounds);
        ExcelWriter excelWriter = EasyExcel.write(path,Student.class).build();
        WriteSheet sheet=EasyExcel.writerSheet("test").build();
        excelWriter.write(Students,sheet);
        excelWriter.finish();

    }
    @Test
    public void excelIn()
    {
        String path = "C:\\Users\\Administrator\\Desktop\\test3.xlsx"; //excel文件路径
        EasyExcel.read(path, Student.class,new StudentListener()).sheet().doRead();
    }
    @Test
    public void servicetest()
    {
        student.delectById(1);
        Student std=new Student(122,"jack","123");
        System.out.println(std);
        student.insertStudent(std);
    }*/
    @Test
    public void StaffDaoSest()
    {

    }

    @Test
    public void excelOut()
    {

    }
    @Test
    public void test(){
        System.out.println(adminDao.getPassword("zwei"));

    }
}
