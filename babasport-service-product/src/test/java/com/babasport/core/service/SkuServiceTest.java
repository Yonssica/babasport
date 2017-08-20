package com.babasport.core.service;

import com.babasport.core.pojo.Sku;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by hwd on 2017/8/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class SkuServiceTest {
    @Autowired
    private SkuService skuService;

    @Test
    public void findByProductId() throws Exception {
        Long productId = 1l;
        List<Sku> skus = skuService.findByProductId(productId);
        System.out.println(skus.size());
        for (Sku sku : skus) {
            System.out.println(sku);
            System.out.println(sku.getColor());
            System.out.println(sku.getColor().getName());
        }
    }

}