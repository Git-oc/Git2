package com.mapper;

import com.po.ItemsCustom;
import com.po.ItemsQueryVo;

import java.util.List;

public interface ItemsMapperCustom {

    List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;

}
