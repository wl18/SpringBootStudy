package com.wl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: weilong
 * @Date: 2020/3/21 14:53
 */


@Controller
public class IndexController {

    @RequestMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("msg","hello,springboot");
        return "hello";
    }
}
