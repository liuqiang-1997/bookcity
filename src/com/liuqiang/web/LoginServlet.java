package com.liuqiang.web;

import com.liuqiang.pojo.User;
import com.liuqiang.service.UserService;
import com.liuqiang.service.impl.userServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    // 创建一个service实例来调用Dao持久层操作数据库
    private UserService userService = new userServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求的参数
        String username = req.getParameter("username");
        String passwd = req.getParameter("password");

        //调用service方法处理业务逻辑
        User loginUser = userService.login(new User(null, username, passwd, null));
        if (loginUser != null){
            //登录成功跳回登陆成功页面
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
        }else{
            // 将错误信息和回显的表单项信息保存到request域中
            req.setAttribute("msg","用户名或密码错误");
            req.setAttribute("username",username);
            //登录失败跳回登陆页面
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        }


    }
}
