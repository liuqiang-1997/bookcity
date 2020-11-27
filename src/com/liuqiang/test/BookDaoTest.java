package com.liuqiang.test;

import com.liuqiang.dao.BookDao;
import com.liuqiang.dao.impl.BookDaoImpl;
import com.liuqiang.pojo.Book;
import org.junit.Test;

import java.math.BigDecimal;

public class BookDaoTest {

    private BookDao bookDao = new BookDaoImpl();

    @Test
    public void addBook() {
//        Integer id, String name, BigDecimal price, String author, Integer sales, Integer stock, String imgPath
        bookDao.addBook(new Book(null,"科比的慕斯",new BigDecimal(824281),"kobe-bryant",61111,0,null));
    }

    @Test
    public void deleteBookById() {
        bookDao.deleteBookById(4);
    }

    @Test
    public void updateBook() {
        bookDao.updateBook(new Book(3,"怎样引起富婆的注意",new BigDecimal(3333),"年轻人",100,12,null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookDao.queryBookById(25));
    }

    @Test
    public void queryBooks() {
        for (Book queryBook:bookDao.queryBooks()) {
            System.out.println(queryBook);
        }

    }
    @Test
    public void queryForPageTotalCount() {
        System.out.println(bookDao.queryForPageTotalCount());
    }

    @Test
    public void queryFprPageItems() {
        System.out.println(bookDao.queryFprPageItems(4,4));
    }

    @Test
    public void queryForPageTotalCountByPrice() {
        System.out.println(bookDao.queryForPageTotalCountByPrice(10,34));
    }

    @Test
    public void queryFprPageItemsByPrice() {
        System.out.println(bookDao.queryFprPageItemsByPrice(1,4,20,10020));
    }


}