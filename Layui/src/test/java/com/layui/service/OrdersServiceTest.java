package com.layui.service;

import com.layui.vo.DataVO;
import com.layui.vo.OrderVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OrdersServiceTest {

    @Autowired
    private OrdersService ordersService;

    @Test
    void getOrderVO() {
    }

    @Test
    void findData() {
        DataVO<OrderVO> dataVO = ordersService.findData(1,10);
        System.out.println(dataVO);
    }
}