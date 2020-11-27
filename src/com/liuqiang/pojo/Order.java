package com.liuqiang.pojo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单模块，包含订单号，下单时间，订单金额，订单状态，订单持有人
 */

public class Order {
    private String orderId; // 订单号
    private Date createTime; // 下单时间
    private BigDecimal price; // 订单金额
    private Integer status = 0; //订单状态 0未发货；1已发货；2已签收
    private Integer userid; //用户名

    public Order() {
    }

    public Order(String orderId, Date createTime, BigDecimal price, Integer status, Integer userid) {
        this.orderId = orderId;
        this.createTime = createTime;
        this.price = price;
        this.status = status;
        this.userid = userid;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", createTime=" + createTime +
                ", price=" + price +
                ", status=" + status +
                ", userid='" + userid + '\'' +
                '}';
    }
}
