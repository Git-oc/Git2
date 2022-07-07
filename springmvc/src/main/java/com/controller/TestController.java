package com.controller;

import com.po.Items;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("test")
public class TestController {

    @RequestMapping("/add")
    public String addBook(Items items){
        System.out.println(items);
        return "tips";
    }

}
