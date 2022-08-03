package com.layui.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.layui.entity.Orders;
import com.layui.vo.OrderVO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderMapper extends BaseMapper<Orders> {

    @Select("select i.id,i.name,sum(items_num) count,i.price,i.detail,i.pic,i.createtime from orderdetail od,items i where od.items_id=i.id group by items_id")
    List<Orders> findAllOrderVO();

}
