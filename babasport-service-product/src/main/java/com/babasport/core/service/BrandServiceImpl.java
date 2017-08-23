package com.babasport.core.service;

import com.babasport.core.dao.BrandDao;
import com.babasport.core.pojo.Brand;
import com.babasport.core.tools.PageHelper;
import com.babasport.core.tools.PageHelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 品牌服务接口实现类
 * Created by hwd on 2017/8/15.
 */
@Service("brandService")
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandDao brandDao;
    @Autowired
    private Jedis jedis;

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
        // 将品牌信息同步存入redis
        jedis.hset("brand", String.valueOf(brand.getId()), brand.getName());
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

    @Override
    public List<Brand> findAllBrandsFromRedis() {
        Map<String, String> hgetAll = jedis.hgetAll("brand");
        // 将查询的结果放入品牌对象集合中
        List<Brand> brands = new ArrayList<>();
        Set<Map.Entry<String, String>> entrySet = hgetAll.entrySet();
        for (Map.Entry<String, String> entry : entrySet) {
            Brand brand = new Brand();
            brand.setId(Long.valueOf(entry.getKey()));
            brand.setName(entry.getValue());
            brands.add(brand);
        }
        return brands;
    }
}
