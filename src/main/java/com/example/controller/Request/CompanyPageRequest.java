package com.example.controller.Request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CompanyPageRequest extends BaseRequest{
    @JsonProperty("ebObject")
    private String ebObject;
    @JsonProperty("max")
    private String cAddress;
    @JsonProperty("cRegion")
    private String cRegion;
}
