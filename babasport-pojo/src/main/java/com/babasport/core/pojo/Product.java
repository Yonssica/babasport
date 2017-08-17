package com.babasport.core.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table(name="bbs_product")
public class Product implements Serializable {
    /**
     * ID或商品编号
     */
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Long id;

    /**
     * 品牌ID
     */
    @Column(name = "brand_id")
    private Long brandId;

    /**
     * 商品名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 重量 单位:克
     */
    @Column(name = "weight")
    private Float weight;

    /**
     * 是否新品:0:旧品,1:新品
     */
    @Column(name = "is_new")
    private Integer isNew;

    /**
     * 是否热销:0,否 1:是
     */
    @Column(name = "is_hot")
    private Integer isHot;

    /**
     * 推荐 1推荐 0 不推荐
     */
    @Column(name = "is_commend")
    private Integer isCommend;

    /**
     * 上下架:0否 1是
     */
    @Column(name = "is_show")
    private Integer isShow;

    /**
     * 商品图片集
     */
    @Column(name = "img_url")
    private String imgUrl;

    /**
     * 是否删除:0删除,1,没删除
     */
    @Column(name = "is_del")
    private Integer isDel;

    /**
     * 商品描述
     */
    @Column(name = "description")
    private String description;

    /**
     * 包装清单
     */
    @Column(name = "package_list")
    private String packageList;

    /**
     * 颜色集
     */
    @Column(name = "colors")
    private String colors;

    /**
     * 尺寸集
     */
    @Column(name = "sizes")
    private String sizes;

    /**
     * 添加时间
     */
    @Column(name = "create_time")
    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Integer getIsNew() {
        return isNew;
    }

    public void setIsNew(Integer isNew) {
        this.isNew = isNew;
    }

    public Integer getIsHot() {
        return isHot;
    }

    public void setIsHot(Integer isHot) {
        this.isHot = isHot;
    }

    public Integer getIsCommend() {
        return isCommend;
    }

    public void setIsCommend(Integer isCommend) {
        this.isCommend = isCommend;
    }

    public Integer getIsShow() {
        return isShow;
    }

    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPackageList() {
        return packageList;
    }

    public void setPackageList(String packageList) {
        this.packageList = packageList;
    }

    public String getColors() {
        return colors;
    }

    public void setColors(String colors) {
        this.colors = colors == null ? null : colors.trim();
    }

    public String getSizes() {
        return sizes;
    }

    public void setSizes(String sizes) {
        this.sizes = sizes == null ? null : sizes.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", brandId=").append(brandId);
        sb.append(", name=").append(name);
        sb.append(", weight=").append(weight);
        sb.append(", isNew=").append(isNew);
        sb.append(", isHot=").append(isHot);
        sb.append(", isCommend=").append(isCommend);
        sb.append(", isShow=").append(isShow);
        sb.append(", imgUrl=").append(imgUrl);
        sb.append(", isDel=").append(isDel);
        sb.append(", description=").append(description);
        sb.append(", packageList=").append(packageList);
        sb.append(", colors=").append(colors);
        sb.append(", sizes=").append(sizes);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}