package com.layui.controller;

import com.layui.entity.Items;
import com.layui.service.ItemsService;
import com.layui.vo.BarVO;
import com.layui.vo.DataVO;
import com.layui.vo.PieVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ItemsController {

    @Autowired
    private ItemsService itemsService;

    @RequestMapping("/items")
    @ResponseBody
    public DataVO<Items> items(Integer page,Integer limit){
        return itemsService.findData(page,limit);
    }

    @GetMapping("/{url}")
    public String redirect(@PathVariable("url") String url){
        return url;
    }

    @RequestMapping("/barVO")
    @ResponseBody
    public BarVO getBarVO(){
        return itemsService.getBarVO();
    }

    @RequestMapping("/pieVO")
    @ResponseBody
    public List<PieVO> getPieVO(){
        return itemsService.getPieVO();
    }


}
