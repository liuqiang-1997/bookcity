package com.liuqiang.test;

import com.liuqiang.pojo.Book;
import com.liuqiang.service.BookService;
import com.liuqiang.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

public class BookServiceTest {

    private BookService bookService = new BookServiceImpl();

    @Test
    public void addBook() {
        bookService.addBook(new Book(3,"怎样引起富婆的注意",new BigDecimal(3333),"年轻人",100,12,null));
    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(18);
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(22,"怎样引起富婆的注意",new BigDecimal(1111),"年轻人",100,15,null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(22));
    }

    @Test
    public void queryBooks() {
        for (Book querybooks:bookService.queryBooks()
             ) {
            System.out.println(querybooks);
        }
    }

    @Test
    public void page(){

        System.out.println(bookService.page(1,4));
    }

    @Test
    public void pageByPrice(){
        System.out.println(bookService.pageByPrice(1,4,10,50));
    }
}