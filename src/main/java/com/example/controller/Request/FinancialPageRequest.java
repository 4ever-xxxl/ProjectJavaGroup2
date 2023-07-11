package com.example.controller.Request;

import lombok.Data;

@Data
public class FinancialPageRequest extends BaseRequest{
    private long fId;
    private String fregion;
    private long fParentId;

}
