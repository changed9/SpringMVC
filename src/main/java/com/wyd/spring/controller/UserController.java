package com.wyd.spring.controller;

import com.wyd.spring.model.User;
import com.wyd.spring.model.UserBook;
import com.wyd.spring.service.UserService;
import com.wyd.spring.utils.R;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

;

/**
 * Created by wyd
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    /**
     *
     * */
    @RequestMapping("/showuser.do")
    public String toPage() {
        return "showuser";
    }

    /**
     * 数据列表
     * */
    @RequestMapping("/userlist.do")
    @ResponseBody
    public Object queryUser(HttpServletRequest request, Model model) {
        List<User> user = userService.queryUser();
        return user;
    }
    /**
     * 删除
     */
    @RequestMapping("/delete.do")
    @ResponseBody
    public R delete (String name,Integer id){
        List<UserBook> userBooks = userService.queryUBuser(name);
        if (userBooks.size()>=1){
            return R.error("未还书，删除失败");
        }else {
            userService.delete(id);
            return R.ok();
        }
    }
    /**
     * 新增
     * */
    @RequestMapping("/save.do")
    @ResponseBody
    public R save(String name){
        User user = new User();
        user.setName(name);
        userService.save(user);
        return R.ok();
    }
}