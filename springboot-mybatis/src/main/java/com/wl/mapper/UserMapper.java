package com.wl.mapper;

import com.wl.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: weilong
 * @Date: 2020/3/27 15:51
 */

//这个注解表示了这是一个mybatis 的 mapper类； Dao
@Mapper
@Repository
public interface UserMapper {

    List<User> queryUserList();

    User queryUserById(int id);

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(int id);

}









