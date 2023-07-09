package com.example.controller.Response;

import com.example.entity.Staff;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class StaffResponse {
    String TableName;
    Object data;
    Map<String, List<Map<String, Object>>> columns;
    long Total=0;

    public StaffResponse(String s, List<Staff> staff, Map<String, List<Map<String, Object>>> columns) {
        TableName=s;
        data=staff;
        this.columns=columns;
    }
}
