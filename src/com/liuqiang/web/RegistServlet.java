package com.liuqiang.web;

import com.liuqiang.pojo.User;
import com.liuqiang.service.UserService;
import com.liuqiang.service.impl.userServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistServlet extends HttpServlet{
    // 创建一个service实例来调用Dao持久层操作数据库
    private UserService userService = new userServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求的参数
        String username = req.getParameter("username");
        String passwd = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");


        //检查验证码是否正确 先写死验证码为abcd
        if ("abcd".equalsIgnoreCase(code)){
            //验证码正确，检查用户名是否可用
            if(userService.existsUserName(username)){
               //不可用 跳回注册页面
                System.out.println("用户名"+username+"已存在！");
                // 将错误信息和回显的表单项信息保存到request域中
                req.setAttribute("msg","用户名已存在");
                req.setAttribute("username",username);
                req.setAttribute("email",email);
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
            }else{
                //可用，调用service保存到数据库
                userService.registUser(new User(null,username,passwd,email));
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req,resp);
            }

        }else{
            // 将错误信息和回显的表单项信息保存到request域中
            req.setAttribute("msg","验证码错误");
            req.setAttribute("username",username);
            req.setAttribute("email",email);
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
        }




    }
}
