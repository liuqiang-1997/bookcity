package com.liuqiang.dao.impl;

import com.liuqiang.dao.OrderDao;
import com.liuqiang.pojo.Book;
import com.liuqiang.pojo.Order;
import com.liuqiang.pojo.OrderItem;

import java.util.List;

public class OrderDaoImpl extends BaseDao implements OrderDao {

    @Override
    public int savaOrder(Order order) {
        String sql = "insert into t_order(order_id,create_time,price,status,user_id)values(?,?,?,?,?)";
        return update(sql,order.getOrderId(),order.getCreateTime(),order.getPrice(),order.getStatus(),
                order.getUserid());
    }

    @Override
    public List<Order> queryMyOrders(Integer userId) {
        String sql = "select order_id as orderId,create_time as createTime,price,status,user_id as userId from " +
                "t_order where user_id = ? order by createTime desc";
        return queryForList(Order.class,sql,userId);
    }

    @Override
    public int changeOrderStatus(Integer status,String orderId) {
        String sql = "update t_order set status=? where order_id = ?";
        return update(sql,status,orderId);
    }


    @Override
    public List<Order> allOrders() {
        String sql = "select order_id as orderId,create_time as createTime,price,status,user_id as userId from " +
                "t_order order by createTime desc ";
        return queryForList(Order.class,sql);
    }

    @Override
    public Integer queryForPageTotalCount() {
        String sql = "select count(*) from t_order";
        Number count = (Number) queryForSingleValue(sql);
        return count.intValue();
    }

    @Override
    public List<Order> queryFprPageItems(int begin, int pageSize) {
        String sql = "select order_id as orderId,create_time as createTime,price,status,user_id as userId from " +
                "t_order limit ?,?";
        return queryForList(Order.class,sql,begin,pageSize);
    }
}
