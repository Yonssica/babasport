package com.babasport.core.service;

import com.babasport.core.pojo.Sku;

import java.util.List;

/**
 * 库存管理接口
 * Created by hwd on 2017/8/19.
 */
public interface SkuService {
    /**
     * 根据商品id查询库存
     *
     * @param productId
     * @return
     */
    List<Sku> findByProductId(Long productId);

    /**
     * 修改库存数据
     *
     * @param sku
     */
    void update(Sku sku);
}
