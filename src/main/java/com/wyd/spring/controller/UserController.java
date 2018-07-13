package com.wyd.spring.controller;

import com.wyd.spring.model.User;
import com.wyd.spring.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
;import java.util.List;

/**
 * Created by wyd
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

//    @RequestMapping("/showUser")
//    public String toIndex(HttpServletRequest request, Model model) {
//        int userId = Integer.parseInt(request.getParameter("id"));
//        User user = this.userService.getUserById(userId);
//        model.addAttribute("user", user);
//        return "showUser";
//    }

    @RequestMapping("/showUser")
    public Object queryUser(HttpServletRequest request, Model model) {
        List<User> user = userService.queryUser();
        return user;
    }

//    @RequestMapping("/delete")
//    public Object delete (@RequestBody Integer[] ids){
//        userService.delete(ids);
//        return
//    }
}