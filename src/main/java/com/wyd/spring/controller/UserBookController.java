package com.wyd.spring.controller;

import com.wyd.spring.model.User;
import com.wyd.spring.model.UserBook;
import com.wyd.spring.service.UserBookService;
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
@RequestMapping("/userbook")
public class UserBookController {
    @Resource
    private UserBookService userBookService;

    /**
     * 数据列表
     * */
    @RequestMapping("/showUserBook")
    public Object queryUser(HttpServletRequest request, Model model) {
        List<UserBook> userBooks = userBookService.queryUserBook();
        return userBooks;
    }
    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete (@RequestBody Integer[] ids){
        userBookService.delete(ids);
        return R.ok();
    }
    /**
     * 新增
     * */
    @RequestMapping("/save")
    public R save(@RequestBody UserBook userBook){
        userBookService.save(userBook);
        return R.ok();
    }
}