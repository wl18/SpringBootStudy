package com.wl.controller;

import com.wl.mapper.UserMapper;
import com.wl.pojo.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: weilong
 * @Date: 2020/3/27 16:14
 */
@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    private static final Logger logger = Logger.getLogger(UserController.class);

    //查询全部用户
    @GetMapping("/queryUserList")
    public List<User> queryUserList() {
        List<User> userList = userMapper.queryUserList();
        for(User user : userList) {
            //System.out.println(user);
            logger.info(user);
        }
        return userList;
    }

    //添加一个用户
    @GetMapping("/addUser")
    public String addUser() {
        userMapper.addUser(new User("AA","8989@163.com"));
        return "add ok";
    }

    //根据id修改一个用户
    @GetMapping("/updateUser")
    public String updateUser(){
        userMapper.updateUser(new User(1,"BB","00000@qq.com"));
        return "update ok";
    }

    //根据id删除用户
    @GetMapping("/deleteUser")
    public String deleteUser(){
        userMapper.deleteUser(6);
        return "delete ok";
    }
}
