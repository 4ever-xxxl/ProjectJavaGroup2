package com.example.controller.Request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class WithheldbillPageRequest extends BaseRequest{
    @JsonProperty("max_wbamount")
    private Integer max_wbamount;
    @JsonProperty("min_wbamount")
    private Integer min_wbamount;
    @JsonProperty("wbFinancialID")
    private Long wbFinancialID;
}
