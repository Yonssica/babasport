package com.babasport.core.service;

import com.babasport.core.dao.BrandDao;
import com.babasport.core.pojo.Brand;
import com.babasport.core.tools.PageHelper;
import com.babasport.core.tools.PageHelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 品牌服务接口实现类
 * Created by hwd on 2017/8/15.
 */
@Service("brandService")
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandDao brandDao;

    @Override
    public Page<Brand> findByExample(Brand brand, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        List<Brand> brands = this.brandDao.findByExample(brand);
        Page endPage = PageHelper.endPage();
        return endPage;
    }

    @Override
    public Brand findById(Long brandId) {
        return brandDao.findById(brandId);
    }

    @Override
    public void updateById(Brand brand) {
        brandDao.updateById(brand);
    }

    @Override
    public void deleteByIds(String ids) {
        brandDao.deleteByIds(ids);
    }

    @Override
    public List<Brand> findAllBrands() {
        return brandDao.findAll();
    }
}
