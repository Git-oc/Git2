package com.service.impl;

import com.exception.CustomException;
import com.mapper.ItemsMapper;
import com.mapper.ItemsMapperCustom;
import com.po.Items;
import com.po.ItemsCustom;
import com.po.ItemsQueryVo;
import com.service.ItemsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ItemsServiceImpl implements ItemsService {

    @Autowired
    private ItemsMapperCustom itemsMapperCustom;

    @Autowired
    private ItemsMapper itemsMapper;

    public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception {
        return itemsMapperCustom.findItemsList(itemsQueryVo);
    }

    public ItemsCustom findItemsById(Integer id) throws Exception {
        Items items = itemsMapper.selectByPrimaryKey(id);
        if (items == null) {
            throw new CustomException("修改的商品信息不存在!");
        }

        ItemsCustom itemsCustom = null;

        itemsCustom = new ItemsCustom();
        BeanUtils.copyProperties(items, itemsCustom);

        return itemsCustom;
    }

    public void updateItems(Integer id, ItemsCustom itemsCustom) throws Exception {
        itemsCustom.setId(id);
        itemsMapper.updateByPrimaryKeyWithBLOBs(itemsCustom);
    }
}
