package com.example.controller.Response;

import com.example.entity.Company;
import lombok.Data;

import java.util.List;

@Data
public class CompanyResponse {
    String TableName;
    Object data;
    long Total=0;

    public CompanyResponse(String s, List<Company> company) {
        TableName=s;
        data= company;
    }
}