package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login(HttpSession session,String username,String password) throws Exception{

        session.setAttribute("username",username);
        session.setAttribute("password",password);

        return "redirect:/items/queryItems.action";

    }
    @RequestMapping("logout")
    public String logout(HttpSession session) throws Exception{

        session.invalidate();

        return "redirect:/items/queryItems.action";
    }

}
