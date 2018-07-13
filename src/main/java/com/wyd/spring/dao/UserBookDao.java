package com.wyd.spring.dao;

import com.wyd.spring.model.User;
import com.wyd.spring.model.UserBook;

import java.util.List;

/**
 * @author Grated by wyd
 */
public interface UserBookDao {


    List<UserBook> queryUserBook();

    void delete(Integer[] ids);

    void save(UserBook userBook);
}
