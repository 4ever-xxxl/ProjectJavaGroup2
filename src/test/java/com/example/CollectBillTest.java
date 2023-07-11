package com.example;

import com.example.controller.CollectBillController;
import com.example.entity.Account;
import com.example.entity.CollectBill;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;

@SpringBootTest
public class CollectBillTest {
    @Resource
    CollectBillController collectBillController;

    @Test
    public void test1(){
        Account account;

        CollectBill collectBill = new CollectBill();
        collectBill.setCbaccountid(53L);
        collectBill.setCbdue(new BigDecimal(5000));
        collectBill.setCbrelief(new BigDecimal(4000));
        collectBill.setCbduedate(new Date(2023,7,11));
        collectBill.setCbstatement("是");
        collectBill.setCbstatetime(new Date(2023,7,11,11,11,11));

        collectBillController.addCollectBill(collectBill);
        System.out.println("success");
    }
}
