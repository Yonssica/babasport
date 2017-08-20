package com.babasport.core.service;

import com.babasport.core.pojo.Brand;
import com.babasport.core.tools.PageHelper.Page;

import java.util.List;


/**
 * 品牌服务接口
 * Created by hwd on 2017/8/15.
 */
public interface BrandService {

    /**
     * 根据条件查询
     * @param brand 条件封装成Brand 如果是null则查询所有
     * @return
     */
    public Page<Brand> findByExample(Brand brand, Integer pageSize, Integer pageNum);

    /**
     * 根据id查询品牌
     * @param brandId
     * @return
     */
    Brand findById(Long brandId);

    /**
     * 根据id修改品牌
     * @param brand
     */
    void updateById(Brand brand);

    /**
     * 根据ids批量删除品牌
     * @param ids
     */
    void deleteByIds(String ids);

    /**
     * 查询所有brand
     * @return
     */
    List<Brand> findAllBrands();
}
