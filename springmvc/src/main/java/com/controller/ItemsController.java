package com.controller;

import com.po.Items;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("items")
public class ItemsController {

    @RequestMapping("/add")
    public ModelAndView queryItems(Integer id,String name,Float price,String pic,String detail) throws Exception {

        System.out.println(id+"\t"+name+"\t"+price+"\t"+pic+"\t"+"\t"+detail);

        ModelAndView modelAndView = new ModelAndView("/tips");
        modelAndView.addObject("key","value");
        modelAndView.addObject("items",new Items(1,"笔记本电脑",6000.0f,"联想","R7000"));
        return modelAndView;

    }

}
