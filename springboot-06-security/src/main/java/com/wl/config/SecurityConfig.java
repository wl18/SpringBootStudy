package com.wl.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Author: weilong
 * @Date: 2020/3/28 09:11
 */

//AOP: 拦截器！
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //授权
    //链式编程
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //首页所有人可以访问，功能页只有对应有权限的人才可以访问
        //请求授权的规则
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("vip1")
                .antMatchers("/level2/**").hasRole("vip2")
                .antMatchers("/level3/**").hasRole("vip3");

        //没有权限默认会到登录页面,需要开启登录的页面
        //  /login
        // 定制登录页， LoginPage("/toLogin"); 在把它转到真正的登录界面
        http.formLogin().loginPage("/toLogin").loginProcessingUrl("/login");


        //防止网站工具：get,post
        http.csrf().disable();//关闭csrf功能，登录失败可能存在的原因
        //注销，开启了注销功能,（跳到首页）
        http.logout().logoutSuccessUrl("/");

        //开启记住我功能  cookie的功能，默认保存两周
        http.rememberMe().rememberMeParameter("remember"); //添加自己定制的remember
    }

    //认证 ， 测试了在 springboot2.1.x 可以直接使用
    //密码编码 ：PasswordEncoder
    //在spring security 5.0+ 新增了很多加密方法，要是报密码编码错误，我们就可以加上
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        //这些数据正常应该从数据库中读，这里只是演示
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("ww").password(new BCryptPasswordEncoder().encode("123456")).roles("vip2","vip3")
                .and()
                .withUser("root").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1","vip2","vip3")
                .and()
                .withUser("guest").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1");
    }
}
