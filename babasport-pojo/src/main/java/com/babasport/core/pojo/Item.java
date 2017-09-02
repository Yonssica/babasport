package com.babasport.core.pojo;

import java.io.Serializable;

/**
 * 购买项
 * Created by hwd on 2017/8/29.
 */
public class Item implements Serializable {
    // 库存id（单独提取出来方便操作）
    private Long skuId;
    // 变异的复合型sku
    private SuperPojo sku;
    // 购买数量
    private Integer amount;

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public SuperPojo getSku() {
        return sku;
    }

    public void setSku(SuperPojo sku) {
        this.sku = sku;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
