package com.example.service;

import com.example.entity.Dpfederation;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author 86158
* @description 针对表【dpfederation(残联)】的数据库操作Service
* @createDate 2023-07-11 15:12:34
*/
public interface IDpfederationService{

    List<Dpfederation> getDpfByCondition(long dpfID, String dpfRegion, long dpfParentID);

    int addDpf(Dpfederation dpf);

    int updateDpf(Dpfederation dpf);

    int deleteDpf(long dpfID);
}
