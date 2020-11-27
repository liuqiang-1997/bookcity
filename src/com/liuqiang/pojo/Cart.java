package com.liuqiang.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 购物车对象
 */
public class Cart {

//    private Integer totalCount;
//    private BigDecimal totalprice;
    //    Integer 商品编号  CartItem 商品信息
    private Map<Integer, CartItem> items = new LinkedHashMap<Integer, CartItem>();

    /**
     * 添加商品项
     *
     * @param cartItem
     */
    public void addItem(CartItem cartItem) {
        // 创建被添加商品实例
        CartItem item = items.get(cartItem.getId());
        // 判断商品是否已存在？数量累加，总金额累加:添加
        if (item == null) {
            // 没有，添加
            items.put(cartItem.getId(), cartItem);
        } else {
            // 有 数据累加
            item.setCount(item.getCount() + 1);
            item.setTotalPricr(item.getPrice().multiply(new BigDecimal(item.getCount()))); // 更新总金额
        }
    }

    /**
     * 删除商品项
     */
    public void deleteItem(Integer id) {

        items.remove(id);
    }

    /**
     * 清空购物车
     */
    public void cleanItem() {
        items.clear();
    }

    /**
     * 修改商品数量
     * 先判断是否有，有则修改商品数量，更新总金额
     */
    public void updateCount(Integer id, Integer count) {
        CartItem cartItem = items.get(id);

        if (cartItem != null) {
            cartItem.setCount(count);
            cartItem.setTotalPricr(cartItem.getPrice().multiply(new BigDecimal(cartItem.getCount())));
        }

    }

    public Integer getTotalCount() {
       Integer totalCount = 0;

        for(Map.Entry<Integer,CartItem>entry:items.entrySet()){
            totalCount += entry.getValue().getCount();
        }
        return totalCount;
    }



    public BigDecimal getTotalprice() {
        BigDecimal totalprice = new BigDecimal(0);
        for(Map.Entry<Integer,CartItem>entry:items.entrySet()){
            totalprice = totalprice.add(entry.getValue().getTotalPricr());
        }
        return totalprice;
    }



    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalprice=" + getTotalprice() +
                ", items=" + items +
                '}';
    }
}
