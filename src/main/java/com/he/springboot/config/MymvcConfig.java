package com.he.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MymvcConfig implements WebMvcConfigurer {
    //自己的视图简析器
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/user").setViewName("seccass");
    }
    //这个用来配置springmvc的自动化配置，加强mvc
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        //配置的第二个视图解析器
        //用来index.html的首页拦截跳转
       return new WebMvcConfigurer(){
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("index");
                registry.addViewController("/index.html").setViewName("index");
                registry.addViewController("/main.html").setViewName("dashboard");
            }
           @Override
           public void addInterceptors(InterceptorRegistry registry) {

               registry.addInterceptor(new LoginHandler()).addPathPatterns("/**")
                       .excludePathPatterns("/index.html","/","/login","/asserts/**","/webjars/**");
           }
       };
    }
    //配置一个语言国际化的插件
    @Bean
    public LocaleResolver localeResolver(){
        return new MylocaleResource();
    }

    }
