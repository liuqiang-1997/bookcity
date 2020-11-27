package com.liuqiang.test;

import com.liuqiang.pojo.Cart;
import com.liuqiang.pojo.CartItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CartTest {

    @Test
    public void addItem() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"javaweb",1,new BigDecimal(11),new BigDecimal(11)));
        cart.addItem(new CartItem(1,"javaweb",1,new BigDecimal(11),new BigDecimal(11)));
        cart.addItem(new CartItem(2,"vue",1,new BigDecimal(100),new BigDecimal(100)));
        System.out.println(cart);
    }

    @Test
    public void deleteItem() {
    }

    @Test
    public void cleanItem() {
    }

    @Test
    public void updateCount() {
        Cart cart =new Cart();
        cart.addItem(new CartItem(1,"java从入门到精通",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(1,"java从入门到精通",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(2,"数据结构与算法",1,new BigDecimal(100),new BigDecimal(100)));
        cart.deleteItem(1);
        cart.cleanItem();
        cart.addItem(new CartItem(1,"java从入门到精通",1,new BigDecimal(1000),new BigDecimal(1000)));
        System.out.println(cart);
        cart.updateCount(1,10);
        System.out.println(cart);

    }
}