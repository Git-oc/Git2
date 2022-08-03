package com.layui.mapper;

import com.layui.entity.Items;
import com.layui.vo.ItemsBarVO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class ItemsMapperTest {

    @Resource
    private ItemsMapper itemsMapper;

    @Test
    void test1(){
        for (Items items : itemsMapper.selectList(null)) {
            System.out.println(items);
        }
    }

    @Test
    void test2(){
        List<ItemsBarVO> list = itemsMapper.findAllItemsBarVO();
        System.out.println(list);
    }

}