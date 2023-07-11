package com.example.Excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;

import java.util.List;

public class ExcelReader {
    public List<ExcelData> readExcelData(String filePath) {
        ExcelReaderBuilder excelReaderBuilder = EasyExcel.read(filePath, ExcelData.class, null);
        return excelReaderBuilder.sheet().doReadSync();
    }
}
