package com.babasport.core.dao;

import com.babasport.core.pojo.Color;
import com.babasport.core.pojo.Sku;
import com.babasport.core.pojo.SuperPojo;
import com.github.abel533.mapper.Mapper;

import java.util.List;

/**
 * 库存管理Dao接口
 * Created by hwd on 2017/8/19.
 */
public interface SkuDao extends Mapper<Sku> {
    /**
     * 查询颜色
     * @param productId
     * @return
     */
    Color findColorByProductId(Long productId);

    /**
     * 根据商品id查询
     * @param productId
     * @return
     */
    List<Sku> findByProductId(Long productId);

    /**
     * 根据商品id 查询库存与颜色
     * @param productId
     * @return
     */
    List<SuperPojo> findSkuAndColorByProductId(Long productId);
}
