package com.controller;

import com.po.ItemsCustom;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JsonTest {

    @RequestMapping("/requestJson")
    @ResponseBody
    public ItemsCustom requestJson(@RequestBody ItemsCustom itemsCustom){
        return itemsCustom;
    }

    @RequestMapping("/response")
    @ResponseBody
    public ItemsCustom responseJson(ItemsCustom itemsCustom){

        return itemsCustom;

    }

}
