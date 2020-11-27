package com.liuqiang.dao;

import com.liuqiang.pojo.OrderItem;

import java.util.List;

public interface OrderItemDao {

    /**
     * 保存订单项
     * @param orderItem
     * @return
     */
    public int saveOrderItem(OrderItem orderItem);

    /**
     * 个人通过订单号查询其订单详情
     * @param orderId
     * @return
     */
    public List<OrderItem> queryOrderDetailByOrderId(String orderId);


}
