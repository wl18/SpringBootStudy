package com.wl.demofirst.config;

import com.wl.demofirst.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: weilong
 * @Date: 2020/3/16 10:42
 *
 * @Configuration: 指明当前类是一个配置类；就是来替代之前的Spring配置文件
 *
 * 在配置文件中用<bean></bean>标签添加组件
 */
@Configuration
public class MyAppConfig {

    @Bean //将方法的返回值添加到容器中；容器中这个组件默认的id就是方法名
    public HelloService helloService() {
        System.out.println("配置类@Bean给容器中添加组件了...");
        return new HelloService();
    }
}
