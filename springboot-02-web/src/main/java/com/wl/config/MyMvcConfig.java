package com.wl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Locale;

/**
 * @Author: weilong
 * @Date: 2020/3/21 16:39
 */

//如果我们要拓展springmvc，官方建议我们这样做！！
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    //视图跳转
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/wl").setViewName("hello");
    }

}


//如果你想diy一些定制化的功能，只要写这个组件，然后将它交给springboot，springboot就会帮我们自动装配！
//拓展SpringMvc
//@Configuration
//public class MyMvcConfig implements WebMvcConfigurer {
//
//    //视图跳转
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/wl").setViewName("hello");
//    }
//
//    //ViewResolver 实现了视图解析器借口的类，我们就可以把它看作视图解析器
//    @Bean
//    public ViewResolver myViewResolver() {
//        return new MyViewResolver();
//    }
//
//    //自定义了一个自己的视图解析器MyViewResolver
//    public static class MyViewResolver implements ViewResolver {
//        @Override
//        public View resolveViewName(String s, Locale locale) throws Exception {
//            return null;
//        }
//    }
//
//}











