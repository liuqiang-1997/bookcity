package com.liuqiang.pojo;

import java.math.BigDecimal;

/**
 * 购物车内商品信息
 */
public class CartItem {

    private Integer id;  // 商品编号
    private String name;  // 商品名
    private Integer count;  // 商品总数
    private BigDecimal price;  // 商品单价
    private BigDecimal totalPricr;  // 商品总价

    public CartItem() {
    }

    public CartItem(Integer id, String name, Integer count, BigDecimal price, BigDecimal totalPricr) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.price = price;
        this.totalPricr = totalPricr;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTotalPricr() {
        return totalPricr;
    }

    public void setTotalPricr(BigDecimal totalPricr) {
        this.totalPricr = totalPricr;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", price=" + price +
                ", totalPricr=" + totalPricr +
                '}';
    }
}
