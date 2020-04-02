package com.he.springboot.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@org.springframework.stereotype.Controller
public class Controller {
    @RequestMapping("/hello")
    public String hello(){
        return "hello";

    }
    @RequestMapping("/seccass")
    public String sueeass(Map<String,Object> map){
        map.put("hahah",121);
        map.put("hello","<h3>你好</h3>");
        map.put("hehe", Arrays.asList("你好",666,5555));

        return "seccass";
    }
    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map,
                        HttpSession session){

        if ( StringUtils.isEmpty(username)||"123456".equals(password)){
            session.setAttribute("login_name",username);
            return "redirect:/main.html";
        }else {
            map.put("msg", "密码输入错误");
            return "index";
        }

    }


}
