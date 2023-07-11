package com.example.dao;

import com.example.controller.Request.StaffapplicationrecordPageRequest;
import com.example.entity.Staffapplicationrecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
* @author 86158
* @description 针对表【staffapplicationrecord(员工申请记录表)】的数据库操作Mapper
* @createDate 2023-07-11 09:28:57
* @Entity com.example.entity.Staffapplicationrecord
*/
@Repository
@Component
public interface StaffapplicationrecordDao extends BaseMapper<Staffapplicationrecord> {

    /*
        * @description 多条件查询【员工申请记录表】信息
        * @param sarID 申请记录ID
        * @param cID 公司ID
        * @param sID 员工ID
        * @param startTime 申请开始时间
        * @param endTime 申请结束时间
        * @param status 申请状态
        * @return List<Staffapplicationrecord>
        * @createDate 2023-07-11 09:28:57
        * @updateDate 2023-07-11 09:28:57
     */
    List<Staffapplicationrecord> getSarByCondition(long sarID, long cID, long sID, Date startTime, Date endTime, String status);

    /*
        * @description add【员工申请记录表】
        * @param staffapplicationrecord
        * @return int
        * @createDate 2023-07-11 09:28:57
     */
    int addSar(Staffapplicationrecord sar);

    /*
        * @description update【员工申请记录表】
        * @param staffapplicationrecord
        * @return int
        * @createDate 2023-07-11 09:28:57
     */
    int updateSar(Staffapplicationrecord sar);

    /*
        * @description 通过ID删除【员工申请记录表】
        * @param sarID
        * @return int
        * @createDate 2023-07-11 09:28:57
     */
    int deleteSar(long sarID);


    List<Staffapplicationrecord> searchSar(StaffapplicationrecordPageRequest SarPR);

    Long searchSarCount(StaffapplicationrecordPageRequest SarPR);

}




