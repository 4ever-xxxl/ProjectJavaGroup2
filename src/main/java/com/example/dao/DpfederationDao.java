package com.example.dao;

import com.example.entity.Dpfederation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* @author 86158
* @description 针对表【dpfederation(残联)】的数据库操作Mapper
* @createDate 2023-07-11 15:12:34
* @Entity com.example.entity.Dpfederation
*/
@Repository
@Component
public interface DpfederationDao extends BaseMapper<Dpfederation> {
    /*

     */
    List<Dpfederation> getDpfByCondition(long dpfID, String dpfRegion, long dpfParentID);

    /*

     */
    int addDpf(Dpfederation dpf);

    /*

     */
    int updateDpf(Dpfederation dpf);

    /*

     */
    int deleteDpf(long dpfID);

}




