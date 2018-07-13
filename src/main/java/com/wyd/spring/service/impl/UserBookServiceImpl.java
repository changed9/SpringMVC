package com.wyd.spring.service.impl;

import com.wyd.spring.dao.BookDao;
import com.wyd.spring.dao.UserBookDao;
import com.wyd.spring.dao.UserDao;
import com.wyd.spring.model.Book;
import com.wyd.spring.model.User;
import com.wyd.spring.model.UserBook;
import com.wyd.spring.service.UserBookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by wyd
 */
@Service("userBookService")
public class UserBookServiceImpl implements UserBookService {
    @Resource
    private UserBookDao userBookDao;
    @Resource
    private UserDao userDao;
    @Resource
    private BookDao bookDao;

    public void delete(Integer id) {
        userBookDao.delete(id);
    }

    public List<UserBook> queryUserBook() {
        return userBookDao.queryUserBook();
    }

    public void save(UserBook userBook) {
        userBookDao.save(userBook);
    }

    public List<User> queryUser() {
        return userDao.queryUser();
    }

    public List<Book> queryBook() {
        return bookDao.queryBook();
    }
}
