package com.liuqiang.web;

import com.liuqiang.pojo.*;
import com.liuqiang.service.OrderService;
import com.liuqiang.service.impl.OrderServiceImpl;
import com.liuqiang.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class OrderServlet extends BaseServlet{

    private OrderService orderService = new OrderServiceImpl();

    /**
     * 创建订单
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 先获取cart购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        // 获取userid
        User loginuser = (User) req.getSession().getAttribute("user");
        //判断是否登录
        if(loginuser == null){
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
            return;
        }
        Integer id = loginuser.getId();
        // 调用orderService.createOrder(cart,userId）生成订单；返回订单号
        String orderId = orderService.createOrder(cart, id);
//        //保存订单号到request域中 因为重定向不支持request域，使用session
//        req.setAttribute("orderId",orderId);
        req.getSession().setAttribute("orderId",orderId);
        // 请求重定向（防止重复提交bug）到结算页面
//        req.getRequestDispatcher("/pages/cart/checkout.jsp").forward(req,resp);
        resp.sendRedirect(req.getContextPath()+"/pages/cart/checkout.jsp");
    }

    /**
     * 查询我的订单
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void myOrders(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求参数中的用户id
        User loginuser = (User) req.getSession().getAttribute("user");

        // 做登录判断，没登录不能查看我的订单，跳回登录页面
        if(loginuser == null){
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
            return;
        }
        Integer id = loginuser.getId();
        //调用orderService.myOrders(userId) 方法来获取order信息；
        List<Order> myOrders = orderService.myOrders(id);
        //保存订单号到request域中
        req.setAttribute("myOrders",myOrders);
        req.getRequestDispatcher("/pages/order/order.jsp").forward(req,resp);
    }

    /**
     * 查看个人订单详情
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void orderDetails(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        // 获取请求参数中的订单号orderid
        OrderItem orderItem = WebUtils.copyParamToBean(req.getParameterMap(),new OrderItem());
        String id = orderItem.getOrderId();
        // 调用orderService.orderDetails(orderId)方法获取订单详情
        List<OrderItem> orderDetails = orderService.orderDetails(id);
        //保存订单详情到request域中
        req.setAttribute("orderDetails",orderDetails);
        // 转发pages/order/orderitem.jsp
        req.getRequestDispatcher("/pages/order/orderitem.jsp").forward(req,resp);

//        req.getRequestDispatcher("/pages/manager/order_manager.jsp").forward(req,resp);

    }

    /**
     * 查看所有订单信息（管理员功能）
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void allOrders(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException{
//        System.out.println("获取到请求查看所有的订单请求");
       // 调用orderService.allOrders()方法获取订单
        List<Order> orders = orderService.allOrders();
//        System.out.println(orders);
        //保存到request域
        req.setAttribute("allOrders",orders);
        //请求重定向
        req.getRequestDispatcher("/pages/manager/order_manager.jsp").forward(req,resp);

    }

    /**
     * 发货（管理员功能）收货(客户功能)  修改订单状态
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void sendorreveiveOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException{
        // 获取请求中的参数
        Order order = WebUtils.copyParamToBean(req.getParameterMap(),new Order());
        Integer status = order.getStatus();
        String orderId = order.getOrderId();
        System.out.println("请求"+status+"单号"+orderId);

        // 调用orderService.sendorreveiveOrder(status,orderId)修改订单状态
        orderService.sendorreveiveOrder(status,orderId);
//        System.out.println("路径"+req.getContextPath()+"/orderServlet?action=allOrders");
        // 判断请求类型
        if(status == 1){
            resp.sendRedirect(req.getContextPath()+"/orderServlet?action=allOrders");
        }else if(status == 2){
            resp.sendRedirect(req.getContextPath()+"/orderServlet?action=myOrders");
        }

    }


}
