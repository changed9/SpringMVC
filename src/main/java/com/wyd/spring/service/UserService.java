package com.wyd.spring.service;

import com.wyd.spring.model.User;

import java.util.List;

/**
 * Created by wyd
 */
public interface UserService {
//    User getUserById(int userId);

    List<User> queryUser();
}
