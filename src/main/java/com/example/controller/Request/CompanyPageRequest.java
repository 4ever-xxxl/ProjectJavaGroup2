package com.example.controller.Request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CompanyPageRequest extends BaseRequest{
    @JsonProperty("cSocialCreditCode")
    private String cSocialCreditCode;
    @JsonProperty("cID")
    private long cID;
    @JsonProperty("cName")
    private String cName;
    @JsonProperty("cAddress")
    private String cAddress;
    @JsonProperty("cRegion")
    private String cRegion;
}
