package com.he.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;
//是一个国际化类
public class MylocaleResource implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String l = request.getParameter("l");
        Locale lacale = Locale.getDefault();
        if (!StringUtils.isEmpty(l)){
            String[] s = l.split("_");

            lacale = new Locale(s[0], s[1]);
        }


        return lacale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
