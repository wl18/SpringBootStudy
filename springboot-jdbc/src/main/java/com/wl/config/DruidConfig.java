package com.wl.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: weilong
 * @Date: 2020/3/27 14:05
 */
@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }

    //后台监控 ：相当于web.xml, ServletRegistrationBean
    //因为Spring Boot 内置了Servlet容器，所以没有web.xml, 替代方法：ServletRegistrationBean
    @Bean
    public ServletRegistrationBean StatViewServlet() {
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");

        //后台需要有人登陆，账号密码配置
        HashMap<String,String> initParameters = new HashMap<>();

        //增加配置
        initParameters.put("loginUsername","admin"); //登陆key 是固定的 loginUsername loginUsername
        initParameters.put("loginPassword","123456");

        //允许谁可以访问
        initParameters.put("allow",""); //后面参数为空则允许任何人访问

        //禁止谁能访问     initParameters.put("kuangshen","192.168.11.123");

        bean.setInitParameters(initParameters); //设置初始化参数
        return bean;
    }

    //filter
    @Bean
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();


        bean.setFilter(new WebStatFilter());

        //可以过滤哪些请求呢？

        Map<String, String> initParameters = new HashMap<>();

        //这些东西不进行统计
        initParameters.put("exclusions","*.js,*.css,/druid/*");

        bean.setInitParameters(initParameters);


        return bean;
    }

}






