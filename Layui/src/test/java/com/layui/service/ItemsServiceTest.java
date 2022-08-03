package com.layui.service;

import com.layui.entity.Items;
import com.layui.vo.BarVO;
import com.layui.vo.DataVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ItemsServiceTest {

    @Autowired
    private ItemsService itemsService;

    @Test
    void findData(Integer page,Integer limit) {
        DataVO<Items> dataVO = itemsService.findData(page, limit);
        System.out.println(dataVO);
    }

    @Test
    void test(){
        BarVO barVO = itemsService.getBarVO();
        System.out.println(barVO);
    }

}