package com.liuqiang.test;

import com.liuqiang.dao.OrderItemDao;
import com.liuqiang.dao.impl.OrderItemDaoImpl;
import com.liuqiang.pojo.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class OrderItemDaoImplTest {

    private OrderItemDao orderItemDao = new OrderItemDaoImpl();

    @Test
    public void saveOrderItem() {

        orderItemDao.saveOrderItem(new OrderItem(null,"java",2,new BigDecimal(12),new BigDecimal(24),"1234567890"));
    }

    @Test
    public void queryOrderDetailByOrderId(){
        List<OrderItem> orderItems = orderItemDao.queryOrderDetailByOrderId("160567953727010");
        System.out.println(orderItems);
    }


}