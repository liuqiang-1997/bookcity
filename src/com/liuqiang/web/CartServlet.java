package com.liuqiang.web;

import com.liuqiang.pojo.Book;
import com.liuqiang.pojo.Cart;
import com.liuqiang.pojo.CartItem;
import com.liuqiang.pojo.User;
import com.liuqiang.service.BookService;
import com.liuqiang.service.impl.BookServiceImpl;
import com.liuqiang.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CartServlet extends BaseServlet{

    private BookService bookService = new BookServiceImpl();
    /**
     * 将商品添加至购物车
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("加入购物车");
//        System.out.println("商品编号"+req.getParameter("id"));
        // 获取请求参数中的用户id
        User loginuser = (User) req.getSession().getAttribute("user");

        // 做登录判断，没登录不能查看我的订单，跳回登录页面
        if(loginuser == null){
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
            return;
        }
        // 获取请求参数中的商品编号
        Book book = WebUtils.copyParamToBean(req.getParameterMap(),new Book());
        //调用bookService.queryBookById(id)得到图书信息
        Book book1 = bookService.queryBookById(book.getId());
        //将图书信息转化为CartItem商品项
        CartItem cartItem = new CartItem(book1.getId(), book1.getName(),1,book1.getPrice(),book1.getPrice());
        //调用Cart.add(CartItem）添加商品项
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if(cart == null){
            cart = new Cart();
            req.getSession().setAttribute("cart",cart);
        }
        cart.addItem(cartItem);
        System.out.println(cart);
        //重定向回原来商品所在商品列表的页面
        resp.sendRedirect(req.getHeader("Referer"));
        //记录最后一个商品的session
        req.getSession().setAttribute("lastName",cartItem.getName());
    }

    /**
     * 删除购物车中的商品
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        // 获取商品编号
        int id = WebUtils.parseInts(req.getParameter("id"),0);
        // 获取购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        // 判断是否有车
        if(cart != null){
            // 删除
            cart.deleteItem(id);
            //重定向回原来的页面
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    protected void cleanItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        // 获取购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        // 判断是否有车
        if(cart != null){
            // 清空
            cart.cleanItem();
            //重定向回原来的页面
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    /**
     * 修改商品数量
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        //获取请求的商品编号和数量
        int id = WebUtils.parseInts(req.getParameter("id"),0);
        int count = WebUtils.parseInts(req.getParameter("counts"),6);
        System.out.println("更新书"+count);
        // 获取购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        //判断是否有车
        if(cart != null){
            // 修改
            cart.updateCount(id,count);
            //重定向回原来的页面
            resp.sendRedirect(req.getHeader("Referer"));
        }

    }
}
