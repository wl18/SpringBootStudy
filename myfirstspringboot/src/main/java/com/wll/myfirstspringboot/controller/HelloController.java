package com.wll.myfirstspringboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: weilong
 * @Date: 2020/3/15 16:14
 */

@RestController
public class HelloController {
    @RequestMapping("/test")
    public String hello(){
        return "hello";
    }
}
