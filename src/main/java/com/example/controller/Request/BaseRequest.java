package com.example.controller.Request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BaseRequest {
    @JsonProperty("pageNum")
    public Integer pageNum = 1;
    @JsonProperty("pageSize")
    public Integer pageSize = 20;
}
