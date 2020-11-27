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
import java.util.List;

public class BookServlet extends BaseServlet {

    private BookService bookService = new BookServiceImpl();

    /**
     * 新增图书
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 将请求参数中的pageNo进行加一操作，使其永远跳转到最后一页
        int pageNo = WebUtils.parseInts(req.getParameter("pageNo"),0);
        pageNo +=1;

        // 获取请求的参数封装为Book对象
        Book book = WebUtils.copyParamToBean(req.getParameterMap(),new Book());

        //调用bookService.addBook()方法保存
        bookService.addBook(book);
        //跳转到图书列表页面
        //请求转发是一次请求，用户使用F5功能键会引起重复操作最后一次请求缓存bug，这里使用重定向
//        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=query");
        //添加分页功能后跳转到添加图书所在页
        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=page&pageNo=" +pageNo);
    }

    /**
     * 删除图书
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//            方法一：
//        //获取请求参数中的图书id
//        int id = WebUtils.parseInt(req.getParameter("id"), 0);
//        //调用bookService.deleteBookById()方法删除图书
//        bookService.deleteBookById(id);
//            方法二
        //获取请求参数中的图书id
        Book book = WebUtils.copyParamToBean(req.getParameterMap(),new Book());
        //调用bookService.deleteBookById()方法删除图书
        bookService.deleteBookById(book.getId());
        //重定向回图书列表管理页面
//        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=query");
        //添加分页功能后
        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=page&pageNo="+req.getParameter("pageNo"));
    }


    /**
     * 查找图书
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */

    protected void query(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 通过BookServlet程序查询所有的图书信息
        List<Book> books = bookService.queryBooks();
        // 2.将所有的图书信息保存到request域中
        req.setAttribute("books",books);
        // 3.请求转发到/pages/manager/book_manager.jsp页面

        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);

    }

    /**
     * 用于修改图书信息的转发
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */

    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求的参数图书id
        Book book = WebUtils.copyParamToBean(req.getParameterMap(),new Book());
        //调用bookService.queryBookById()查询图书
        Book book1 = bookService.queryBookById(book.getId());
        //将查询信息保存到request域中
        req.setAttribute("bookinfo",book1);
        //请求转发到pages/manager/book_edit.jsp页面
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req,resp);
    }

    /**
     * 保存更改图书信息操作
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 获取请求的参数封装为Book对象
        Book book = WebUtils.copyParamToBean(req.getParameterMap(),new Book());
        //调用bookService.updateBook()修改图书信息
         bookService.updateBook(book);
        //重定向回图书列表管理页面/工程名/manager/bookServlet?action=query
//        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=query");
        //添加分页功能后
        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=page&pageNo="+req.getParameter("pageNo"));

    }

    /**
     * 处理分页功能
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
          // 设置后台url地址
        page.setUrl("manager/bookServlet?action=page");
        //保存page对象到request域中
        req.setAttribute("page",page);
       //请求转发到pages/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);

    }

}
