package com.example.service.Imp;

import com.example.dao.DpfederationDao;
import com.example.entity.Dpfederation;
import com.example.service.IDpfederationService;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DpfederationService implements IDpfederationService {
    private final DpfederationDao dpfDao;

    @Autowired
    public DpfederationService(DpfederationDao dpfDao) {
        this.dpfDao = dpfDao;
    }

    @Override
    public List<Dpfederation> getDpfByCondition(long dpfID, String dpfRegion, long dpfParentID) {
        return dpfDao.getDpfByCondition(dpfID, dpfRegion, dpfParentID);
    }


    @Override
    public int addDpf(Dpfederation dpf) {
        return dpfDao.addDpf(dpf);
    }

    @Override
    public int updateDpf(Dpfederation dpf) {
        return dpfDao.updateDpf(dpf);
    }

    @Override
    public int deleteDpf(long dpfID) {
        return dpfDao.deleteDpf(dpfID);
    }
}
