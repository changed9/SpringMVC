package com.wyd.spring.controller;

import com.wyd.spring.model.User;
import com.wyd.spring.service.UserService;
import com.wyd.spring.utils.R;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

;

/**
 * Created by wyd
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    /**
     * 数据列表
     * */
    @RequestMapping("/showUser")
    public Object queryUser(HttpServletRequest request, Model model) {
        List<User> user = userService.queryUser();
        return user;
    }
    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete (@RequestBody Integer[] ids){
        userService.delete(ids);
        return R.ok();
    }
    /**
     * 新增
     * */
    @RequestMapping("/save")
    public R save(@RequestBody User user){
        userService.save(user);
        return R.ok();
    }
}