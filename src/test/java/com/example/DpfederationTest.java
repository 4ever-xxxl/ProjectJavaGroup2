package com.example;

import com.example.controller.DpfederationController;
import com.example.controller.Request.DpfederationPageRequest;
import com.example.entity.Dpfederation;
import com.example.service.Imp.DpfederationService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class DpfederationTest {
    @Resource
    private DpfederationController dpfController;

    @Resource
    private DpfederationService dpfService;

    @Test
    public void getDpfByCondition() {
        System.out.println("[+] getDpfByCondition");
        long dpfID = 0L;
        String dpfRegion = null;
        long dpfParentID = 0L;
        for (Dpfederation dpf : dpfService.getDpfByCondition(dpfID, dpfRegion, dpfParentID)) {
            System.out.println(dpf);
        }
    }
}
