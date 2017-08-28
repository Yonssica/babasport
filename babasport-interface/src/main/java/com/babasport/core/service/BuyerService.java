package com.babasport.core.service;

import com.babasport.core.pojo.Buyer;

/**
 * 买家服务类接口
 * Created by hwd on 2017/8/27.
 */
public interface BuyerService {
    /**
     * 通过用户名查询买家
     * @param username
     * @return
     */
    Buyer findByUsername(String username);
}
