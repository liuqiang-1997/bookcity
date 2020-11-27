package com.liuqiang.web;

import com.liuqiang.pojo.User;
import com.liuqiang.service.UserService;
import com.liuqiang.service.impl.userServiceImpl;
import com.liuqiang.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

public class UserServlet extends BaseServlet {


    // 创建一个service实例来调用Dao持久层操作数据库
    private UserService userService = new userServiceImpl();

    /**
     * 处理用户登陆的功能
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求的参数
//        String username = req.getParameter("username");
//        String password = req.getParameter("password");
          User user = WebUtils.copyParamToBean(req.getParameterMap(),new User());

        //调用service方法处理业务逻辑
        User loginUser = userService.login(new User(null, user.getUsername(), user.getpassword(), null));

        if(loginUser != null){

            // 获取当前登陆session对象
            HttpSession session = req.getSession();
            // 将用户名保存到session域中
            session.setAttribute("user",loginUser);
            //登录成功跳回登陆成功页面
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
        }else{

            // 将错误信息和回显的表单项信息保存到request域中
            req.setAttribute("msg","用户名或密码错误");
            req.setAttribute("username",user.getUsername());
            //登录失败跳回登陆页面
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        }



    }

    /**
     * 处理用户登出的功能（注销）
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        // 获取登录用户的session会话对象
        HttpSession session = req.getSession();
        // 立刻销毁session
        session.invalidate();
        // 重定向到未登陆首页
        resp.sendRedirect(req.getContextPath());
    }


    /**
     * 处理用户注册的功能
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求的参数
//        String username = req.getParameter("username");
//        String password = req.getParameter("password");
//        String email = req.getParameter("email");
          String code = req.getParameter("code");
          User user = WebUtils.copyParamToBean(req.getParameterMap(),new User());

        //检查验证码是否正确 先获取session中的验证码
        String session_code = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        // 删除session中的验证码，以防止重复提交
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);

        if ( session_code != null && session_code.equalsIgnoreCase(code) ){
            //验证码正确，检查用户名是否可用
            if(userService.existsUserName(user.getUsername())){
                //不可用 跳回注册页面
                System.out.println("用户名"+user.getUsername()+"已存在！");
                // 将错误信息和回显的表单项信息保存到request域中
                req.setAttribute("msg","用户名已存在");
                req.setAttribute("username",user.getUsername());
                req.setAttribute("email",user.getEmail());
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
            }else{
                //可用，调用service保存到数据库
                User registuser = userService.registUser(new User(null,user.getUsername(),user.getpassword(),user.getEmail()));
                // 获取当前注册session对象
                HttpSession session = req.getSession();
                // 将用户名保存到session域中
                session.setAttribute("user",registuser);
                // 注册成功跳回登录页面
                req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
            }

        }else{
            // 将错误信息和回显的表单项信息保存到request域中
            req.setAttribute("msg","验证码错误");
            req.setAttribute("username",user.getUsername());
            req.setAttribute("email",user.getEmail());
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
        }
    }


    //此段代码被封装为一个父类用于继承实现代码优化
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        // 获取用户请求的功能类型
//        String action = req.getParameter("action");
//        try {
//            //通过action业务鉴别字符串，获取相应的业务方法反射对象
//            Method method = this.getClass().getDeclaredMethod(action,HttpServletRequest.class,HttpServletResponse.class);
////            System.out.println(method);
//            //调用目标业务方法(反射)
//            method.invoke(this,req,resp);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    // 此段代码被上述代码替换实现优化
////        System.out.println(action);
////        // 对用户请求的功能类型做判断
////        if("login".equals(action)){
////            System.out.println(action);
////           login(req,resp);
////        }else if("regist".equals(action)){
////            System.out.println(action);
////           regist(req,resp);
////
////        }
//    }
    protected void updateUserPassword(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException{

         Integer id = WebUtils.parseInts(req.getParameter("userId"),0);
         String newpwd = req.getParameter("newpwd");
         String finpwd = req.getParameter("finpwd");

        if(newpwd.equals(finpwd)){
            userService.updateUserPassword(id,finpwd);

            resp.sendRedirect(req.getContextPath()+"/pages/user/login.jsp");
        }


    }
}
