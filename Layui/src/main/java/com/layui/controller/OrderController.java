package com.layui.controller;

import com.layui.service.OrdersService;
import com.layui.vo.DataVO;
import com.layui.entity.Orders;
import com.layui.vo.OrderVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class OrderController {

    @Resource
    private OrdersService ordersService;

    @RequestMapping("/orderVO")
    @ResponseBody
    public List<Orders> getOrderVO(){
        return ordersService.getOrderVO();
    }

    @RequestMapping("/orders")
    @ResponseBody
    public DataVO<OrderVO> orders(Integer page, Integer limit){
        return ordersService.findData(page,limit);
    }

}
