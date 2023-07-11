package com.example.service.Imp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.Staffapplicationrecord;
import com.example.service.IStaffapplicationrecordService;
import com.example.dao.StaffapplicationrecordDao;
import org.springframework.stereotype.Service;

/**
* @author 86158
* @description 针对表【staffapplicationrecord(员工申请记录表)】的数据库操作Service实现
* @createDate 2023-07-11 09:28:57
*/
@Service
public class StaffapplicationrecordService extends ServiceImpl<StaffapplicationrecordDao, Staffapplicationrecord>
    implements IStaffapplicationrecordService {

}




