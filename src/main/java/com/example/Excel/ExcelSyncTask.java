package com.example.Excel;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.example.dao.CollectBillDao;
import com.example.entity.CollectBill;
import com.example.service.Imp.CollectBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

import com.alibaba.excel.EasyExcel;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ExcelSyncTask {
    private final CollectBillService collectBillService;

    public ExcelSyncTask(CollectBillService collectBillService) {
        this.collectBillService = collectBillService;
    }

    //@Scheduled(cron = "*/10 * * * * *") // 每10秒执行一次
    public void syncExcelData() {
        System.out.println("读一次");
        String filePath = "C:\\Users\\Administrator\\Desktop\\CollectBill.xls"; // 替换为你的Excel表路径

        // 读取Excel表数据
        List<CollectBill> collectBillList1 = readExcelData(filePath);
        System.out.println(collectBillList1);
        // 批量插入或更新CollectBill表数据
        collectBillService.saveOrUpdateBatch(collectBillList1);

        // 从数据库中读取数据
        List<CollectBill> collectBillList2 = collectBillService.list();

        // 写入Excel表格
        writeExcelData(filePath, collectBillList2);

    }

    private void writeExcelData(String filePath, List<CollectBill> data) {
        ExcelWriter excelWriter = null;
        try {
            excelWriter = EasyExcel.write(filePath, CollectBill.class).build();
            WriteSheet writeSheet = EasyExcel.writerSheet().build();
            excelWriter.write(data, writeSheet);
        } finally {
            if (excelWriter != null) {
                excelWriter.finish();
            }
        }
    }
    private List<CollectBill> readExcelData(String filePath) {
        return EasyExcel.read(filePath).head(CollectBill.class).sheet().doReadSync();
    }
}
