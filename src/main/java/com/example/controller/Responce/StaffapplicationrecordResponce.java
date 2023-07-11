package com.example.controller.Responce;

import com.example.entity.Staffapplicationrecord;
import lombok.Data;

import java.util.List;

@Data
public class StaffapplicationrecordResponce {
    private List<Staffapplicationrecord> list;

    private Long total;

}
