package com.wl.demofirst.bean;

import org.hibernate.validator.constraints.Email;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author: weilong
 * @Date: 2020/3/15 17:09
 * 将配置文件中配置的每个属性的值，映射到这个组件中
 * @ConfigurationProperties :告诉SpringBoot将本类中的所有属性和配置文件中相关的配置进行绑定
 *      prefix = "person" :配置文件中哪个下面的所有属性进行一一配置
 *
 *    只有这个组件是容器中的组件，才能使用容器中提供的@ConfigurationProperties功能；
 *
 */
//@PropertySource(value = {"classpath:person.properties"})  //另一种指定注入方式
@Component
@ConfigurationProperties(prefix = "person") //支持JSR303数据校验
@Validated // JSR303数据校验
public class Person {

//    @Value("${person.last-name}") //不支持JSR303数据校验
    //验证，lastName必须是邮箱格式
//    @Email
    private String lastName;
//    @Value("#{11*2}")
    private Integer age;
//    @Value("true")
    private boolean boss;
    private Date birth;

    private Map<String,Object> maps;
    private List<Object> list;
    private  Dog dog;

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", age=" + age +
                ", boss=" + boss +
                ", birth=" + birth +
                ", maps=" + maps +
                ", list=" + list +
                ", dog=" + dog +
                '}';
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public boolean isBoss() {
        return boss;
    }

    public void setBoss(boolean boss) {
        this.boss = boss;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }
}
