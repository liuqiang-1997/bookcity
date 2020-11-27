package com.liuqiang.test;

import com.liuqiang.dao.OrderDao;
import com.liuqiang.dao.impl.OrderDaoImpl;
import com.liuqiang.pojo.Book;
import com.liuqiang.pojo.Order;
import com.liuqiang.pojo.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class OrderDaoTest {

    @Test
    public void savaOrder() {
        OrderDao orderDao = new OrderDaoImpl();
        orderDao.savaOrder(new Order("1234567890",new Date(),new BigDecimal(100),0,10));
    }
    @Test
    public void queryMyOrders(){
        OrderDao orderDao = new OrderDaoImpl();
        for (Order order:orderDao.queryMyOrders(12)) {
            System.out.println(order);
        }
    }

    @Test
    public void changeOrderStatus() {

        OrderDao orderDao = new OrderDaoImpl();
        orderDao.changeOrderStatus(0,"160567953727010");
    }

    @Test
    public void allOrders() {
        OrderDao orderDao = new OrderDaoImpl();
        List<Order> orders = orderDao.allOrders();
        System.out.println(orders);
    }
}