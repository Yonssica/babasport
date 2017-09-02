package com.babasport.core.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * 购物车实体类
 * Created by hwd on 2017/8/29.
 */
public class Cart {
    //  购买项的集合
    private List<Item> items = new ArrayList<>();
    // 添加购买项
    public void addItem(Item item) {
        for (Item item2 : items) {
            if (item2.getSkuId().equals(item.getSkuId())) {
                item2.setAmount(item2.getAmount() + item.getAmount());
                return;
            }
        }
        items.add(item);
    }
    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
    // 合计等相关信息
}
