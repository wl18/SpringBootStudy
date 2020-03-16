package com.wl.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: weilong
 * @Date: 2020/3/15 22:52
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello(){
        return "spring ";
    }
}
