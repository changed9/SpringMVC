package com.wyd.spring.service.impl;

import com.wyd.spring.dao.UserBookDao;
import com.wyd.spring.dao.UserDao;
import com.wyd.spring.dao.UserMapper;
import com.wyd.spring.model.User;
import com.wyd.spring.model.UserBook;
import com.wyd.spring.service.UserBookService;
import com.wyd.spring.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by wyd
 */
@Service("userService")
public class UserBookServiceImpl implements UserBookService {
    @Resource
    private UserBookDao userBookDao;

    public void delete(Integer[] ids) {
        userBookDao.delete(ids);
    }

    public List<UserBook> queryUserBook() {
        return userBookDao.queryUserBook();
    }

    public void save(UserBook userBook) {
        userBookDao.save(userBook);
    }
}
