package com.example.controller.Request;

import lombok.Data;

@Data
public class DpfederationPageRequest extends BaseRequest {
    private Long dpfID;
    private String dpfRegion;
    private Long dpfParentID;
}
