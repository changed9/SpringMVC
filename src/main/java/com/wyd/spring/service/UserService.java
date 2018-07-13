package com.wyd.spring.service;

import com.wyd.spring.model.User;
import com.wyd.spring.model.UserBook;

import java.util.List;

/**
 * Created by wyd
 */
public interface UserService {
//    User getUserById(int userId);

    List<User> queryUser();

    void delete(int ids);


    void save(User user);

    List<UserBook> queryUBuser(String userName);
}
