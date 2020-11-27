package com.liuqiang.service;

import com.liuqiang.pojo.*;

import java.util.List;

public interface OrderService {

    /**
     * 创建订单
     * @param cart  购物车对象
     * @param userId  用户
     * @return
     */
    public String createOrder(Cart cart,Integer userId);

    /**
     * 通过用户id查询其下所有账单
     * @param userId 用户id
     */
    public List<Order> myOrders(Integer userId);

    /**
     * 通过订单号查询其订单详情
     * @param orderID String 订单号
     */
    public List<OrderItem> orderDetails(String orderID);

    /**
     * 修改订单状态
     */
    public void sendorreveiveOrder(Integer status, String orderId);

    /**
     * 查询所有订单信息
     * @return
     */
    public List<Order> allOrders();

    /**
     * 对分页模块进行数据处理
     * @param pageNo
     * @param pageSize
     * @return
     */

    Page<Order> page(int pageNo, int pageSize);

}
