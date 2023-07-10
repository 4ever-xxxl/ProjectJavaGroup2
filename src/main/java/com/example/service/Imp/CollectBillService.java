package com.example.service.Imp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.CollectBillDao;
import com.example.entity.CollectBill;
import com.example.service.ICollectBillService;
import org.springframework.stereotype.Service;

@Service
public class CollectBillService extends ServiceImpl<CollectBillDao, CollectBill>
        implements ICollectBillService {
}
