package com.example.controller.Response;

import com.example.entity.Staff;
import lombok.Data;

import java.util.List;

@Data
public class StaffResponse {
    String TableName;
    Object data;
    long Total=0;

    public StaffResponse(String s, List<Staff> staff) {
        TableName=s;
        data=staff;
    }
}
