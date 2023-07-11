package com.example.controller;

import com.example.common.Result;
import com.example.controller.Request.DpfederationPageRequest;
import com.example.entity.Dpfederation;
import com.example.service.Imp.DpfederationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Dpfederation")
public class DpfederationController {
    @Autowired
    private DpfederationService dpfService;

    @PostMapping("/getDpfByCondition")
    public Result getDpfByCondition(@RequestBody DpfederationPageRequest dpfPageRequest){
        Long dpfID = dpfPageRequest.getDpfID();
        String dpfRegion = dpfPageRequest.getDpfRegion();
        Long dpfParentID = dpfPageRequest.getDpfParentID();
        return Result.success(dpfService.getDpfByCondition(dpfID,dpfRegion,dpfParentID));
    }

    @PostMapping("/addDpf")
    public Result addDpf(@RequestBody Dpfederation dpf){
        return Result.success(dpfService.addDpf(dpf));
    }

    @PostMapping("/updateDpf")
    public Result updateDpf(@RequestBody Dpfederation dpf){
        return Result.success(dpfService.updateDpf(dpf));
    }

    @GetMapping("/deleteDpf/{dpfID}")
    public Result deleteDpf(@PathVariable("dpfID") Long dpfID){
        return Result.success(dpfService.deleteDpf(dpfID));
    }
}
