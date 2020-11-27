package com.liuqiang.web;

import com.liuqiang.pojo.Remark;
import com.liuqiang.pojo.Reply;
import com.liuqiang.pojo.User;
import com.liuqiang.service.RemarkService;
import com.liuqiang.service.ReplyService;
import com.liuqiang.service.UserService;
import com.liuqiang.service.impl.RemarkServiceImpl;
import com.liuqiang.service.impl.ReplyServiceImpl;
import com.liuqiang.service.impl.userServiceImpl;
import com.liuqiang.utils.WebUtils;
import org.apache.commons.collections.ArrayStack;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class RemarkServlet extends BaseServlet {
    private RemarkService remarkService = new RemarkServiceImpl();
    private ReplyService replyService = new ReplyServiceImpl();
    private UserService userService = new userServiceImpl();


    protected void queryRemarkByBookId(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        List<User> user = new ArrayList<User>();
        // 获取请求中参数图书id
        Remark remark = WebUtils.copyParamToBean(req.getParameterMap(),new Remark());
        Integer bookId = remark.getBookId();
        // 调用remarkService.queryRemarkByBookId(bookId)方法来获取所有的评论
        List<Remark> remarks = remarkService.queryRemarkByBookId(bookId);
        for (Remark id:remarks
             ) {
            Integer observer = id.getObserver();
//            System.out.println("评论者"+observer);
            User remarkUserId = userService.queryByUserId(observer);
            user.add(remarkUserId);
        }
//
        //保存到request域中
        System.out.println(user);
        req.setAttribute("remarkUserId",user);
        req.setAttribute("remarks",remarks);
        //转发到review.jsp页面
        req.getRequestDispatcher("/pages/client/review.jsp").forward(req,resp);

    }

    protected void addRemark(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {

        User loginuser = (User) req.getSession().getAttribute("user");
        //判断是否登录
        if(loginuser == null){
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
            return;
        }

        // 获取请求参数 bookid,remarks,observer,remark_time
        Remark remarks = WebUtils.copyParamToBean(req.getParameterMap(), new Remark());
//        System.out.println(remarks);
        // 调用remarkService.addRemark(remark)保存评论
        remarkService.addRemark(remarks);
        // 转发到review.jsp页面查看回复
        resp.sendRedirect(req.getContextPath()+"/remarkServlet?action=queryRemarkByBookId&bookId="+remarks.getBookId());
    }

    protected void queryRemarkByObserver(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        // 获取评论者id参数
        String  id = req.getParameter("observer");
        Integer observer = WebUtils.parseInts(id,0);
      // 调用remarkService.queryRemarkByObserver(observer)方法获取个人评论
        List<Remark> remarks = remarkService.queryRemarkByObserver(observer);
        //  保存数据到request域中
        req.setAttribute("observer_comment",remarks);

        // 转发到personal_review.jsp页面
        req.getRequestDispatcher("/pages/client/personal_review.jsp").forward(req,resp);
    }

    protected void deleteRemark(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        // 获取评论id

        String id = req.getParameter("remarkId");
        Integer remarkId = WebUtils.parseInts(id,0);
        String observer =  req.getParameter("observer");
        System.out.println(observer);
        //调用remarkService.deleteRemark(remarkId)方法删除相应评论
        remarkService.deleteRemark(remarkId);
        // 调用replyService.clearReply()方法删除其下相应回复
        replyService.clearReply();
        resp.sendRedirect(req.getContextPath()+"/remarkServlet?action=queryRemarkByObserver&observer="+observer);
    }
}
