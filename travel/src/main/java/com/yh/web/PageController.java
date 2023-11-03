package com.yh.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: Yanjw
 * @Date: 2023/11/2 - 11 - 02 - 16:26
 * @Description: com.yh.web
 * @version: 1.0
 */
@Controller
@RequestMapping("to")
public class PageController {
    @RequestMapping("{page}")
    public String getPage(@PathVariable("page")String page){
        return page;
    }
}
