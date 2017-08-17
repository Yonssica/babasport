package com.babasport.core.dao;

import com.babasport.core.pojo.Brand;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 品牌管理DAO
 * Created by hwd on 2017/8/15.
 */
public interface BrandDao {

    /**
     * 根据条件查询
     * @param brand
     * @return
     */
    public List<Brand> findByExample(Brand brand);

    /**
     * 根据id查询
     * @param brandId
     * @return
     */
    Brand findById(Long brandId);

    /**
     * 根据id修改
     * @param brand
     */
    void updateById(Brand brand);

    /**s
     * 根据ids批量删除
     * @param ids
     */
    void deleteByIds(@Param("ids") String ids);
}
