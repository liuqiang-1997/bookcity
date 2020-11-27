package com.liuqiang.service.impl;

import com.liuqiang.dao.BookDao;
import com.liuqiang.dao.OrderDao;
import com.liuqiang.dao.OrderItemDao;
import com.liuqiang.dao.impl.BookDaoImpl;
import com.liuqiang.dao.impl.OrderDaoImpl;
import com.liuqiang.dao.impl.OrderItemDaoImpl;
import com.liuqiang.pojo.*;
import com.liuqiang.service.OrderService;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class OrderServiceImpl implements OrderService {

    private BookDao bookDao = new BookDaoImpl(); //修改图书销量显示
    private OrderDao orderDao = new OrderDaoImpl();
    private OrderItemDao orderItemDao = new OrderItemDaoImpl();
    @Override
    public String createOrder(Cart cart, Integer userId) {
        // 创建订单号
        String orderId = System.currentTimeMillis()+""+userId;
        // 创建订单对象
        Order order = new Order(orderId,new Date(),cart.getTotalprice(),0,userId);
        // 保存订单
        orderDao.savaOrder(order);
        // 遍历购物车中每一个商品项转化为订单项保存到数据库
        for(Map.Entry<Integer, CartItem> entry :cart.getItems().entrySet()){
            // 获取每一个购物车中的商品项
            CartItem cartItem = entry.getValue();
            //转化为每一个订单项中的商品
            OrderItem orderItem = new OrderItem(null,cartItem.getName(),cartItem.getCount(),cartItem.getPrice(),
                    cartItem.getTotalPricr(),orderId);
            // 保存订单项到数据库
            orderItemDao.saveOrderItem(orderItem);

            // 更新库存和销量
            // 查询订单项中的图书编号
            Book book = bookDao.queryBookById(cartItem.getId());
            // 修改销量
            book.setSales(book.getSales()+cartItem.getCount());
            // 修改库存
            book.setStock(book.getStock()-cartItem.getCount());
            // 保存修改
            bookDao.updateBook(book);

        }
        //清空购物车
        cart.cleanItem();
        return orderId;
    }

    @Override
    public List<Order> myOrders(Integer userId) {
        return orderDao.queryMyOrders(userId);
    }

    @Override
    public List<OrderItem> orderDetails(String orderID) {
        return orderItemDao.queryOrderDetailByOrderId(orderID);
    }

    @Override
    public void sendorreveiveOrder(Integer status,String orderId) {
        orderDao.changeOrderStatus(status, orderId);
    }

    @Override
    public List<Order> allOrders() {
        return orderDao.allOrders();
    }

    @Override
    public Page<Order> page(int pageNo, int pageSize) {

            Page<Order> page = new Page<Order>();

            // 设置页码显示大小
            page.setPageSize(pageSize);

            //求总记录数
            Integer pageTotalCount = orderDao.queryForPageTotalCount();

            //设置总记录数
            page.setPageTotalCount(pageTotalCount);

            //求总页码
            Integer pageTotal = pageTotalCount / pageSize;
            if(pageTotalCount % pageSize > 0){
                pageTotal += 1;
            }

            //设置总页码
            page.setPageTotal(pageTotal);

            //设置当前页码
            page.setPageNo(pageNo);

            // 求当前页数据的开始索引
            int begin = (page.getPageNo() - 1) * pageSize;

            //求当前页数据
            List<Order> items = orderDao.queryFprPageItems(begin,pageSize);

            //设置当前页数据
            page.setItems(items);
            return page;
        }

}
