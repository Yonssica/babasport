package com.babasport.core.service;

import com.babasport.core.pojo.Color;
import com.babasport.core.pojo.Product;
import com.babasport.core.pojo.SuperPojo;
import com.babasport.core.tools.PageHelper.Page;
import org.apache.solr.client.solrj.SolrServerException;

import java.io.IOException;
import java.util.List;

/**
 * 商品服务接口
 * Created by hwd on 2017/8/17.
 */
public interface ProductService {

    /**
     * 根据条件查询（带分页）
     * @param product
     * @param pageNum
     * @param pageSize
     * @return
     */
    Page<Product> findByExample(Product product, Integer pageNum, Integer pageSize);

    /**
     * 查询可用的颜色结果集（颜色的父id不为0）
     * @return
     */
    List<Color> findEnableColors();

    /**
     * 添加商品
     * @param product
     */
    void add(Product product);

    /**
     * 修改商品上架状态
     * @param product
     * @param ids
     */
    void updateIsShow(Product product, String ids) throws IOException, SolrServerException;

    /**
     * 根据id查询单个商品信息
     * @param productId
     * @return
     */
    SuperPojo findProductById(Long productId);
}
