package com.wl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Author: weilong
 * @Date: 2020/3/27 10:49
 */

@RestController
public class JDBCController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    //查询数据库的所有信息
    //没有实体类，数据库中的东西怎么获取？  用Map
    @GetMapping("/userList")
    public List<Map<String,Object>> userList() {
        String sql = "select * from t_user";
        List<Map<String, Object>> list_maps = jdbcTemplate.queryForList(sql);
        return list_maps;
    }

    @GetMapping("/addUser")
    public String addUser() {
        String sql = "insert into t_user(loginName,loginPwd,realName) values('aa','123456','丽丽')";
        jdbcTemplate.update(sql);
        return "update-ok";
    }

    //要传参就这么写
    @GetMapping("/updateUser/{id}")
    public String updateUser(@PathVariable("id") int id) {
        String sql = "update test.t_user set loginName=?,loginPwd=? where id=" + id;

        //封装
        Object[] objects =new Object[2];
        objects[0] = "BB";
        objects[1] = "45678";
        jdbcTemplate.update(sql,objects);
        return "update-ok";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        String sql = "delete from test.t_user where id=?";
        jdbcTemplate.update(sql,id);
        return "update-ok";
    }
}
