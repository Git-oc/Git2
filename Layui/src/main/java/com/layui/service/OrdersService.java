package com.layui.service;

import com.layui.vo.DataVO;
import com.layui.entity.Orders;
import com.layui.vo.OrderVO;

import java.util.List;

public interface OrdersService {

    List<Orders> getOrderVO();
    DataVO<OrderVO> findData(int page, int limit);

}
