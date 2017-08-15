package com.babasport.core.pojo;

import java.io.Serializable;

/**
 * 品牌
 * Created by hwd on 2017/8/15.
 */
public class Brand implements Serializable {
    // 品牌id
    private Long id;
    // 品牌名称
    private String name;
    // 品牌描述
    private String description;
    // 图片URL
    private String imgUrl;
    // 排序 越大越靠前
    private Integer sort;
    // 是否可用     0 不可用   1 可用
    private Integer isDisplay;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getIsDisplay() {
        return isDisplay;
    }

    public void setIsDisplay(Integer isDisplay) {
        this.isDisplay = isDisplay;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", sort=" + sort +
                ", isDisplay=" + isDisplay +
                '}';
    }
}
