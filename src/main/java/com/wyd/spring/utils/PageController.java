package com.wyd.spring.utils;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Grated by wyd
 */
@Controller
public class PageController {

    @RequestMapping("{page}")
    public String toPage(@PathVariable("page") String page){
        return page;
    }

}
