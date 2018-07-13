package com.wyd.spring.service.impl;

import com.wyd.spring.dao.UserDao;
import com.wyd.spring.dao.UserMapper;
import com.wyd.spring.model.User;
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
    private UserMapper userMapper;
    @Resource
    private UserDao userDao;
    public User getUserById(int userId) {
        return this.userMapper.selectByPrimaryKey(userId);
    }

    public List<User> queryUser() {

        return userDao.queryUser();
    }

    public void delete(Integer[] ids) {
        userDao.delete(ids);
    }
}
