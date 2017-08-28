package com.babasport.core.service;

import com.babasport.core.dao.BuyerDao;
import com.babasport.core.pojo.Buyer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 买家服务实现类
 * Created by hwd on 2017/8/27.
 */
@Service("buyerService")
public class BuyerServiceImpl implements BuyerService {
    @Autowired
    private BuyerDao buyerDao;

    @Override
    public Buyer findByUsername(String username) {
        Buyer buyer = new Buyer();
        buyer.setUsername(username);
        Buyer selectOne = buyerDao.selectOne(buyer);
        return selectOne;
    }
}
