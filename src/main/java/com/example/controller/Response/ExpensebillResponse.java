package com.example.controller.Response;
import com.example.entity.Expensebill;
import lombok.Data;

import java.util.List;

@Data
public class ExpensebillResponse {
    String TableName;
    Object data;
    long Total=0;

    public ExpensebillResponse(String s, List<Expensebill> expensebill) {
        TableName=s;
        data= expensebill;
    }
}
