package com.liuqiang.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

public abstract class BaseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //解决post请求中文乱码问题（获取请求参数之前调用有效）
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        // 获取用户请求的功能类型
        String action = req.getParameter("action");
        try {
            //通过action业务鉴别字符串，获取相应的业务方法反射对象
            Method method = this.getClass().getDeclaredMethod(action,HttpServletRequest.class,HttpServletResponse.class);
//            System.out.println(method);
            //调用目标业务方法(反射)
            method.invoke(this,req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        System.out.println(action);
//        // 对用户请求的功能类型做判断
//        if("login".equals(action)){
//            System.out.println(action);
//           login(req,resp);
//        }else if("regist".equals(action)){
//            System.out.println(action);
//           regist(req,resp);
//
//        }
    }
}
