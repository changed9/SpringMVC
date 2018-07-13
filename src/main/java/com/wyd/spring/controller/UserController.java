package com.wyd.spring.controller;

import com.wyd.spring.model.User;
import com.wyd.spring.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
;import java.util.List;

/**
 * Created by wyd
 */
@Controller
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
    public String queryUser(HttpServletRequest request, Model model) {
        List<User> user = userService.queryUser();
        return "showUser";
    }
}