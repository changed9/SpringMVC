package com.wyd.spring.dao;

import com.wyd.spring.model.Book;
import com.wyd.spring.model.User;

import java.util.List;

/**
 * @author Grated by wyd
 */
public interface BookDao {


    List<Book> queryBook();

    void delete(Integer[] ids);

    void save(Book book);
}
