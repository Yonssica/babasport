package com.babasport.core.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table(name="bbs_order")
public class Order implements Serializable {
    /**
     * ID或订单号
     */
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Long id;

    /**
     * 运费
     */
    @Column(name = "deliver_fee")
    private Float deliverFee;

    /**
     * 应付金额
     */
    @Column(name = "total_price")
    private Float totalPrice;

    /**
     * 订单金额
     */
    @Column(name = "order_price")
    private Float orderPrice;

    /**
     * 支付方式 0:到付 1:在线 2:邮局 3:公司转帐
     */
    @Column(name = "payment_way")
    private Integer paymentWay;

    /**
     * 货到付款方式.1现金,2POS刷卡
     */
    @Column(name = "payment_cash")
    private Integer paymentCash;

    /**
     * 送货时间
     */
    @Column(name = "delivery")
    private Integer delivery;

    /**
     * 是否电话确认 1:是  0: 否
     */
    @Column(name = "is_confirm")
    private Integer isConfirm;

    /**
     * 支付状态 :0到付1待付款,2已付款,3待退款,4退款成功,5退款失败
     */
    @Column(name = "is_paiy")
    private Integer isPaiy;

    /**
     * 订单状态 0:提交订单 1:仓库配货 2:商品出库 3:等待收货 4:完成 5待退货 6已退货
     */
    @Column(name = "order_state")
    private Integer orderState;

    /**
     * 订单生成时间
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 附言
     */
    @Column(name = "note")
    private String note;

    /**
     * 用户ID
     */
    @Column(name = "buyer_id")
    private Long buyerId;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getDeliverFee() {
        return deliverFee;
    }

    public void setDeliverFee(Float deliverFee) {
        this.deliverFee = deliverFee;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Float getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Float orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Integer getPaymentWay() {
        return paymentWay;
    }

    public void setPaymentWay(Integer paymentWay) {
        this.paymentWay = paymentWay;
    }

    public Integer getPaymentCash() {
        return paymentCash;
    }

    public void setPaymentCash(Integer paymentCash) {
        this.paymentCash = paymentCash;
    }

    public Integer getDelivery() {
        return delivery;
    }

    public void setDelivery(Integer delivery) {
        this.delivery = delivery;
    }

    public Integer getIsConfirm() {
        return isConfirm;
    }

    public void setIsConfirm(Integer isConfirm) {
        this.isConfirm = isConfirm;
    }

    public Integer getIsPaiy() {
        return isPaiy;
    }

    public void setIsPaiy(Integer isPaiy) {
        this.isPaiy = isPaiy;
    }

    public Integer getOrderState() {
        return orderState;
    }

    public void setOrderState(Integer orderState) {
        this.orderState = orderState;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", deliverFee=").append(deliverFee);
        sb.append(", totalPrice=").append(totalPrice);
        sb.append(", orderPrice=").append(orderPrice);
        sb.append(", paymentWay=").append(paymentWay);
        sb.append(", paymentCash=").append(paymentCash);
        sb.append(", delivery=").append(delivery);
        sb.append(", isConfirm=").append(isConfirm);
        sb.append(", isPaiy=").append(isPaiy);
        sb.append(", orderState=").append(orderState);
        sb.append(", createDate=").append(createDate);
        sb.append(", note=").append(note);
        sb.append(", buyerId=").append(buyerId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}