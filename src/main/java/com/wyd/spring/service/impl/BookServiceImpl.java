package com.wyd.spring.service.impl;

import com.wyd.spring.dao.BookDao;
import com.wyd.spring.model.Book;
import com.wyd.spring.service.BookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by wyd
 */
@Service("bookService")
public class BookServiceImpl implements BookService {
    @Resource
    private BookDao bookDao;

    public List<Book> queryUser() {
        return bookDao.queryBook();
    }

    public void delete(Integer[] ids) {
        bookDao.delete(ids);
    }

    public void save(Book book) {
        bookDao.save(book);
    }
}
