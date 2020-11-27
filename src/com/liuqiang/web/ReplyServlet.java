package com.liuqiang.web;

import com.liuqiang.pojo.Reply;
import com.liuqiang.pojo.User;
import com.liuqiang.service.ReplyService;
import com.liuqiang.service.impl.ReplyServiceImpl;
import com.liuqiang.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class ReplyServlet extends BaseServlet {
    private ReplyService replyService = new ReplyServiceImpl();


    protected void queryReplyByRemarkId(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {

        // 获取请求参数
        Reply reply = WebUtils.copyParamToBean(req.getParameterMap(),new Reply());
        Integer remarkId = reply.getRemarkId();

        // 调用replyService.queryReplyByRemarkId(remarkId)方法来获取评论下的所有回复
        List<Reply> replies = replyService.queryReplyByRemarkId(remarkId);
        // 保存到request域
        req.setAttribute("replys",replies);
        // 转发到reply.jsp
        req.getRequestDispatcher("/pages/client/reply.jsp").forward(req,resp);

    }
    protected void addReply(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {

        User loginuser = (User) req.getSession().getAttribute("user");
        //判断是否登录
        if(loginuser == null){
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
            return;
        }
        // 获取参数
        Reply reply = WebUtils.copyParamToBean(req.getParameterMap(),new Reply());
        Integer replyUser = reply.getReplyUser();
        Integer remarkIds = reply.getRemarkId();
        Integer remarkUser = reply.getRemarkUser();
//        String reply1 = reply.getReply();
        // 调用replyService.addReply(reply)方法新加评论
        replyService.addReply(reply);
        resp.sendRedirect(req.getContextPath()+"/replyServlet?action=queryReplyByRemarkId&observer="+remarkUser+"&remarkId="+remarkIds);




    }
    protected void queryReplyByreplyUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        System.out.println("queryReplyByreplyUser被访问了");
        // 获取请求参数 replyUser
        Reply reply = WebUtils.copyParamToBean(req.getParameterMap(),new Reply());
        Integer replyUser = reply.getReplyUser();
       // 调用replyService.queryReplyByreplyUser(replyUser)获取个人回复
        List<Reply> byreplyUser = replyService.queryReplyByreplyUser(replyUser);
        // 保存到request域
        req.setAttribute("personal_reply",byreplyUser);
        // 转发到personal_reply.jsp
        req.getRequestDispatcher("/pages/client/personal_reply.jsp").forward(req,resp);

    }

    protected void queryReplyByremarkUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        System.out.println("queryReplyByremarkUser被访问了");
        // 获取请求参数 replyUser
        Reply reply = WebUtils.copyParamToBean(req.getParameterMap(),new Reply());
        Integer remarkUser = reply.getRemarkUser();
        // 调用replyService.queryReplyByremarkUser(remarkUser)获取个人回复
        List<Reply> byreplyUser = replyService.queryReplyByremarkUser(remarkUser);
        // 保存到request域
        req.setAttribute("byreply",byreplyUser);
        // 转发到personal_reply.jsp
        req.getRequestDispatcher("/pages/client/byreply.jsp").forward(req,resp);

    }

    protected void deleteReply(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException{
        Reply reply = WebUtils.copyParamToBean(req.getParameterMap(),new Reply());
        Integer remarkId = reply.getRemarkId();
        Integer replyUser = reply.getReplyUser();
//        System.out.println("回复用户："+replyUser + "被回复评论"+remarkId);

        replyService.deleteReply(replyUser,remarkId);

        resp.sendRedirect(req.getContextPath()+"/replyServlet?action=queryReplyByreplyUser&replyUser="+replyUser);

    }
}
