package com.layui.controller;

import com.layui.service.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class UserController {

    @Resource
    private UserServiceImpl userService;

    @RequestMapping("/login")
    public String Login(String username,String password,String loginType){

        try {
            userService.checkLogin(username,password,loginType);
            System.out.println("登录成功");
            return "admin";
        } catch (Exception e) {
            System.out.println("登录失败");
            return "login";
        }

    }

}
