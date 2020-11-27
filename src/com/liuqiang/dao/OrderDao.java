package com.liuqiang.dao;

import com.liuqiang.pojo.Book;
import com.liuqiang.pojo.Order;
import com.liuqiang.pojo.OrderItem;

import java.util.List;

public interface OrderDao {

    /**
     * 保存订单
     * @param order
     * @return
     */
    public int savaOrder(Order order);

    /**
     * 通过客户id查询其下所有的订单
     * @param userId
     * @return
     */
    public List<Order> queryMyOrders(Integer userId);

    /**
     * 通过订单号修改订单状态
     */
    public int changeOrderStatus(Integer status,String orderId);

    /**
     * 查询所有订单
     * @return
     */
    public List<Order> allOrders();

    /**
     * 查询订单总数
     * @return
     */
    Integer queryForPageTotalCount();

    /**
     * 查询订单的开始和每页显示数
     * @param begin
     * @param pageSize
     * @return
     */
    List<Order> queryFprPageItems(int begin, int pageSize);



}
