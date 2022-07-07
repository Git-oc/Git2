package com.mapper;

import com.po.Items;
import com.po.ItemsExample;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

public class ItemsMapperTest {

    private ItemsMapper itemsMapper;

    //在setUp这个方法得到spring容器
    @Before
    public void setUp() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
        itemsMapper = (ItemsMapper) applicationContext.getBean("itemsMapper");
    }

    //根据主键删除
    @Test
    public void DeleteByPrimaryKey() {
        Items items = itemsMapper.selectByPrimaryKey(1);
        System.out.println(items);
        itemsMapper.deleteByPrimaryKey(1);
    }

    //插入
    @Test
    public void Insert() {
        Items items = new Items();
        items.setName("手机");
        items.setPrice(999f);
        items.setCreatetime(new Date());
        itemsMapper.insert(items);
    }

    //自定义条件查询
    @Test
    public void SelectByExample() {
        ItemsExample itemsExample = new ItemsExample();
        //通过criteria构造查询条件
        ItemsExample.Criteria criteria = itemsExample.createCriteria();
        criteria.andNameEqualTo("笔记本");
        //可能返回多条记录
        List<Items> list = itemsMapper.selectByExample(itemsExample);

        System.out.println(list);

    }

    //根据主键查询
    @Test
    public void SelectByPrimaryKey() {
        Items items = itemsMapper.selectByPrimaryKey(1);
        System.out.println(items);
    }

    //更新数据
    @Test
    public void UpdateByPrimaryKey() {

        Items items = itemsMapper.selectByPrimaryKey(1);

        items.setName("手机");

        itemsMapper.updateByPrimaryKey(items);

    }
}