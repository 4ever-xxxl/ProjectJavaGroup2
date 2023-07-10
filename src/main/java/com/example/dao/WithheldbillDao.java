package com.example.dao;

import com.example.entity.Withheldbill;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


/**
* @author DELL
* @description 针对表【withheldbill(残保金代扣账目表)】的数据库操作Mapper
* @createDate 2023-07-11 02:11:57
* @Entity com.example.entity.Withheldbill
*/
@Repository
@Component
public interface WithheldbillDao extends BaseMapper<Withheldbill> {

}




