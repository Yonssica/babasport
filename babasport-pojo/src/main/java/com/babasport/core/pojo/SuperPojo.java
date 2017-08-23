package com.babasport.core.pojo;

import java.io.Serializable;
import java.util.TreeMap;

/**
 * 超级实体类对象，可以装载任意实体类之任意属性，可以用于装载多表连接查询返回的复合数据
 * Created by hwd on 2017/8/20.
 */
public class SuperPojo extends TreeMap<String, Object> implements Serializable {

    /**
     * 设置实体类属性
     *
     * @param name  属性名
     * @param value 属性值
     * @return 已经设置好的实体类本身，实现连点设置属性的特点
     */
    public SuperPojo setProperty(String name, Object value) {
        this.put(name, value);
        return this;
    }
}
