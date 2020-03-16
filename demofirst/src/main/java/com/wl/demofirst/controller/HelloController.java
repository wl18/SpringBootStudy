package com.wl.demofirst.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: weilong
 * @Date: 2020/3/15 16:23
 */

@RestController
public class HelloController {

    @Value("${person.last-name}")
    private String name;

    @RequestMapping("/hello")
    public String hello(){
        return "spring boot " + name;
    }

}
