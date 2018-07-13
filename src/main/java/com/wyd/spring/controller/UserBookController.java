package com.wyd.spring.controller;

import com.wyd.spring.model.UserBook;
import com.wyd.spring.service.UserBookService;
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
@RequestMapping("/userbook")
public class UserBookController {
    @Resource
    private UserBookService userBookService;

    /**
     *
     * */
    @RequestMapping("/showuserbook.do")
    public String toPage() {
        return "showuserbook";
    }

    /**
     * 数据列表
     * */
    @RequestMapping("/userbooklist")
    @ResponseBody
    public Object queryUser(HttpServletRequest request, Model model) {
        List<UserBook> userBooks = userBookService.queryUserBook();
        return userBooks;
    }
    /**
     * 删除
     */
    @RequestMapping("/delete")
    @ResponseBody
    public R delete (Integer id){
        userBookService.delete(id);
        return R.ok();
    }
    /**
     * 新增
     * */
    @RequestMapping("/save")
    @ResponseBody
    public R save(@RequestBody UserBook userBook){
        userBookService.save(userBook);
        return R.ok();
    }
}