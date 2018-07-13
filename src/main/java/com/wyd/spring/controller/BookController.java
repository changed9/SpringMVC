package com.wyd.spring.controller;

import com.wyd.spring.model.Book;
import com.wyd.spring.model.User;
import com.wyd.spring.service.BookService;
import com.wyd.spring.service.UserService;
import com.wyd.spring.utils.R;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * Created by wyd
 */
@RestController
@RequestMapping("/book")
public class BookController {
    @Resource
    private BookService bookService;

    /**
     * 数据列表
     * */
    @RequestMapping("/showBook")
    public Object queryBook(HttpServletRequest request, Model model) {
        List<Book> book = bookService.queryUser();
        return book;
    }
    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete (@RequestBody Integer[] ids){
        bookService.delete(ids);
        return R.ok();
    }
    /**
     * 新增
     * */
    @RequestMapping("/save")
    public R save(@RequestBody Book book){
        bookService.save(book);
        return R.ok();
    }
}