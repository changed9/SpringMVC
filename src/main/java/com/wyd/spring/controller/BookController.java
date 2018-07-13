package com.wyd.spring.controller;

import com.wyd.spring.model.Book;
import com.wyd.spring.model.User;
import com.wyd.spring.model.UserBook;
import com.wyd.spring.service.BookService;
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


/**
 * Created by wyd
 */
@Controller
@RequestMapping("/book")
public class BookController {
    @Resource
    private BookService bookService;

    /**
     *
     * */
    @RequestMapping("/showbook.do")
    public String toPage() {
        return "showbook";
    }

    /**
     * 数据列表
     * */
    @RequestMapping("/booklist.do")
    @ResponseBody
    public Object queryBook(HttpServletRequest request, Model model) {
        List<Book> book = bookService.queryUser();
        return book;
    }

    /**
     * 删除
     */
    @RequestMapping("/delete.do")
    @ResponseBody
    public R delete (String name, Integer id){
        List<UserBook> userBooks = bookService.queryUBbook(name);
        if (userBooks.size()>=1){
            return R.error("未还书，删除失败");
        }else {
            bookService.delete(id);
            return R.ok();
        }
    }

    /**
     * 新增
     * */
    @RequestMapping("/save.do")
    @ResponseBody
    public R save(String name,String writer){
        Book book =new Book();
        book.setName(name);
        book.setBookWriter(writer);
        bookService.save(book);
        return R.ok();
    }
}