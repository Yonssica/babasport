package com.babasport.core.service;

import com.babasport.core.dao.SkuDao;
import com.babasport.core.pojo.Sku;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 库存管理接口实现类
 * Created by hwd on 2017/8/19.
 */
@Service("skuService")
public class SkuServiceImpl implements SkuService {

    @Autowired
    private SkuDao skuDao;

    @Override
    public List<Sku> findByProductId(Long productId) {
        return skuDao.findByProductId(productId);
    }

    @Override
    public void update(Sku sku) {
        skuDao.updateByPrimaryKeySelective(sku);
    }

}
