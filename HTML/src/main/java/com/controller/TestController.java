package com.controller;

import com.po.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @RequestMapping("/student")
    public String Login(User user){
        System.out.println(user);
        return "student";
    }

}
