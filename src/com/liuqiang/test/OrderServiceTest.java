package com.liuqiang.test;

import com.liuqiang.pojo.Cart;
import com.liuqiang.pojo.CartItem;
import com.liuqiang.pojo.OrderItem;
import com.liuqiang.service.OrderService;
import com.liuqiang.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class OrderServiceTest {

    OrderService orderService = new OrderServiceImpl();
    @Test
    public void createOrder() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"java从入门到精通",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(1,"java从入门到精通",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(2,"数据结构与算法",1,new BigDecimal(100),new BigDecimal(100)));

        OrderItem orderItem = new OrderItem();
        String order = orderService.createOrder(cart, 10);
        System.out.println(order);
    }
}