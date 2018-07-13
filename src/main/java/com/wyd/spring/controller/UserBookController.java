package com.wyd.spring.controller;

import com.wyd.spring.model.Book;
import com.wyd.spring.model.User;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        Map<String, Object> map = new HashMap<String, Object>();
        List<UserBook> userBooks = userBookService.queryUserBook();
        List<User> users = userBookService.queryUser();
        List<Book> books = userBookService.queryBook();
        map.put("userBooks",userBooks);
        map.put("users",users);
        map.put("books",books);
        return map;
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
    public R save(String borrowUser, String bookName){
        UserBook userBook = new UserBook();
        userBook.setBookName(bookName);
        userBook.setBorrowUser(borrowUser);
        userBookService.save(userBook);
        return R.ok();
    }
}