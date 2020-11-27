package com.liuqiang.service;

import com.liuqiang.pojo.Book;
import com.liuqiang.pojo.Page;

import java.util.List;

public interface BookService {
    /**
     * 增加图书
     * @param book 参数为book实例对象
     */
    public void addBook(Book book);

    /**
     * 通过id删除图书
     * @param id
     */

    public void deleteBookById(Integer id);

    /**
     * 更新图书
     * @param book
     */
    public void updateBook(Book book);

    /**
     * 通过id查找图书
     * @param id
     * @return
     */

    public Book queryBookById(Integer id);

    /**
     * 查看所有图书
     * @return
     */

    public List<Book> queryBooks();

    /**
     * 对分页模块进行数据处理
     * @param pageNo
     * @param pageSize
     * @return
     */

    Page<Book> page(int pageNo, int pageSize);

    /**
     * 根据价格区间对图书数据进行分页
     * @param pageNo
     * @param pageSize
     * @param min
     * @param max
     * @return
     */

    Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max);
}
