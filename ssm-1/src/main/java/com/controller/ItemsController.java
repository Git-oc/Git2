package com.controller;

import com.controller.converter.validation.ValidGroup1;
import com.po.ItemsCustom;
import com.po.ItemsQueryVo;
import com.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/items")
public class ItemsController {

    @Autowired
    private ItemsService itemsService;

    // 商品分类
    //itemtypes表示最终将方法返回值放在request中的key
    @ModelAttribute("itemtypes")
    public Map<String, String> getItemTypes() {

        Map<String, String> itemTypes = new HashMap<>();
        itemTypes.put("101", "数码");
        itemTypes.put("102", "母婴");

        return itemTypes;
    }

    @RequestMapping("/queryItems")
    public ModelAndView queryItems(HttpServletRequest request, ItemsQueryVo itemsQueryVo) throws Exception {

        List<ItemsCustom> itemsList = itemsService.findItemsList(itemsQueryVo);

        ModelAndView modelAndView = new ModelAndView("items/itemsList");
        modelAndView.addObject("itemsList", itemsList);
        return modelAndView;
    }

    @RequestMapping(value = "/editItems", method = {RequestMethod.POST, RequestMethod.GET})
    public String editItems(Model model, @RequestParam(value = "id", required = true) Integer items_id) throws Exception {


        ItemsCustom itemsCustom = itemsService.findItemsById(items_id);

        model.addAttribute("items", itemsCustom);

        return "items/editItems";
    }
    @RequestMapping("/itemsView/{id}")
    @ResponseBody
    public ItemsCustom itemsView(@PathVariable("id") Integer items_id) throws Exception {

        //调用service查询商品信息
        return itemsService.findItemsById(items_id);

    }

    @RequestMapping("/editItemsSubmit")
    public String editItemsSubmit(Model model, HttpServletRequest request, Integer id, @ModelAttribute("items") @Validated(value = ValidGroup1.class) ItemsCustom itemsCustom, BindingResult bindingResult, MultipartFile items_pic) throws Exception {

        if (bindingResult.hasErrors()) {

            List<ObjectError> allErrors = bindingResult.getAllErrors();

            for (ObjectError objectError : allErrors) {

                System.out.println(objectError.getDefaultMessage());
            }
            model.addAttribute("allErrors", allErrors);

            return "items/editItems";
        }

        return "forward:/items/queryItems.action";

    }

    // 批量删除 商品信息
    @RequestMapping("/deleteItems")
    public String deleteItems(Integer[] items_id) throws Exception {

        System.out.println(items_id);

        return "success";

    }

    // 批量修改商品页面，将商品信息查询出来，在页面中可以编辑商品信息
    @RequestMapping("/editItemsQuery")
    public ModelAndView editItemsQuery(HttpServletRequest request, ItemsQueryVo itemsQueryVo) throws Exception {

        //调用service查找数据库，查询商品列表
        List<ItemsCustom> itemsList = itemsService.findItemsList(itemsQueryVo);

        //返回ModelAndView
        ModelAndView modelAndView = new ModelAndView();
        //相当于request的setAttribute方法,在jsp页面中通过itemsList取数据
        modelAndView.addObject("itemsList", itemsList);

        modelAndView.setViewName("items/editItemsQuery");

        return modelAndView;
    }

    // 批量修改商品提交
    // 通过ItemsQueryVo接收批量提交的商品信息，将商品信息存储到itemsQueryVo中itemsList属性中。
    @RequestMapping("/editItemsAllSubmit")
    public String editItemsAllSubmit(ItemsQueryVo itemsQueryVo) throws Exception {
        return "success";
    }

}
