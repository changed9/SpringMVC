package com.wyd.spring.dao;

import com.wyd.spring.model.Book;

import java.util.List;

/**
 * @author Grated by wyd
 */
public interface BookDao {


    List<Book> queryBook();

    void delete(int id);

    void save(Book book);
}
