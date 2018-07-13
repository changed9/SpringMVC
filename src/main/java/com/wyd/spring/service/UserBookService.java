package com.wyd.spring.service;

import com.wyd.spring.model.User;
import com.wyd.spring.model.UserBook;

import java.util.List;

/**
 * Created by wyd
 */
public interface UserBookService {

    void delete(Integer[] ids);

    List<UserBook> queryUserBook();

    void save(UserBook userBook);
}
