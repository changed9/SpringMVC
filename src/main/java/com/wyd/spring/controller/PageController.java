package com.wyd.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Grated by yanweijun on 2018-07-13
 */
@Controller
public class PageController {

    @RequestMapping("{page}")
    public String toPage(@PathVariable("page") String page){
        return page;
    }

}
