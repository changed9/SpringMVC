package com.wyd.spring.service;

import com.wyd.spring.model.Book;
import com.wyd.spring.model.UserBook;

import java.util.List;

/**
 * Created by wyd
 */
public interface BookService {

    List<Book> queryUser();

    void delete(Integer[] ids);

    void save(Book book);

    List<UserBook> queryUBbook(String name);
}
