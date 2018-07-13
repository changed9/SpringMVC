package com.wyd.spring.service.impl;

import com.wyd.spring.dao.UserBookDao;
import com.wyd.spring.dao.UserDao;
import com.wyd.spring.model.User;
import com.wyd.spring.model.UserBook;
import com.wyd.spring.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by wyd
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;
    @Resource
    private UserBookDao userBookDao;

    public List<User> queryUser() {

        return userDao.queryUser();
    }

    public void delete(int ids) {
        userDao.delete(ids);
    }

    public void save(User user) {
        userDao.save(user);
    }

    public List<UserBook> queryUBuser(String userName) {
        return userBookDao.queryUBuser(userName);
    }

}
