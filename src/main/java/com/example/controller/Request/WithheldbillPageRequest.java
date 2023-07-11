package com.example.controller.Request;

import lombok.Data;

@Data
public class WithheldbillPageRequest extends BaseRequest{
    private Integer max_wbamount;
    private Integer min_wbamount;
}
