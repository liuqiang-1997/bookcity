package com.liuqiang.web;

import com.liuqiang.pojo.Book;
import com.liuqiang.pojo.Page;
import com.liuqiang.service.BookService;
import com.liuqiang.service.impl.BookServiceImpl;
import com.liuqiang.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClientBookServlet extends BaseServlet {

    private BookService bookService = new BookServiceImpl();

    /**
     * 处理图书分页功能
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 获取请求的参数pageNo和pageSize
        int pageNo = WebUtils.parseInts(req.getParameter("pageNo"),1);
        int pageSize = WebUtils.parseInts(req.getParameter("pageSize"), Page.PAGE_SIZE);
        //调用bookService.page(pageNo,pageSize)返回page对象
        Page<Book> page = bookService.page(pageNo,pageSize);
        // 设置前台url地址
        page.setUrl("client/bookServlet?action=page");
        //保存page对象到request域中
        req.setAttribute("page",page);
        //请求转发到/pages/client/index.jsp页面
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);

    }

    /**
     * 处理按价格搜索结果的分页
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void pageByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 获取请求的参数（pageNo，pageSize，min，max）
        int pageNo = WebUtils.parseInts(req.getParameter("pageNo"),1);
        int pageSize = WebUtils.parseInts(req.getParameter("pageSize"), Page.PAGE_SIZE);
        int min = WebUtils.parseInts(req.getParameter("min"),0);
        int max = WebUtils.parseInts(req.getParameter("max"),Integer.MAX_VALUE);
        // 调用bookService.pageByPrice(pageNo，pageSize，min，max)方法获取page对象
        Page<Book> page = bookService.pageByPrice(pageNo,pageSize,min,max);
        // 设置分页条在价格划分之后带价格参数的地址
        StringBuilder sb = new StringBuilder("client/bookServlet?action=pageByPrice");
        if(req.getParameter("min") != null){
            sb.append("&min=").append(req.getParameter("min"));
        }
        if(req.getParameter("max") != null){
            sb.append("&max=").append(req.getParameter("max"));
        }
        // 设置前台url地址
        page.setUrl(sb.toString());
        // 保存分页对象到request域中
        req.setAttribute("page",page);
        // 请求转发到/pages/client/index.jsp页面
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);






    }
}
