package com.layui.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.layui.entity.Items;
import com.layui.vo.ItemsBarVO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ItemsMapper extends BaseMapper<Items> {

    @Select("select i.name,sum(items_num) count from orderdetail od,items i where od.items_id=i.id group by items_id")
    List<ItemsBarVO> findAllItemsBarVO();

}
