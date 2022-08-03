package com.layui.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.layui.mapper.ItemsMapper;
import com.layui.mapper.OrderMapper;
import com.layui.service.OrdersService;
import com.layui.vo.DataVO;
import com.layui.entity.Orders;
import com.layui.vo.OrderVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private ItemsMapper itemsMapper;

    @Override
    public List<Orders> getOrderVO() {
        List<Orders> list = orderMapper.findAllOrderVO();
        List<Orders> orderVOList = list.stream()
                .map(e -> new Orders(
                        e.getId(),
                        e.getItemsId(),
                        e.getNumber(),
                        e.getCount(),
                        e.getCreatetime(),
                        e.getNote()
                )).collect(Collectors.toList());
        return orderVOList;
    }

    @Override
    public DataVO<OrderVO> findData(int page, int limit) {
        DataVO<OrderVO> dataVO = new DataVO<>();
        dataVO.setCode(0);
        dataVO.setMsg("");

        IPage<Orders> ordersIPage = new Page<>(page,limit);
        IPage<Orders> result = orderMapper.selectPage(ordersIPage,null);
        dataVO.setCount(result.getTotal());

        List<Orders> ordersList = result.getRecords();
        List<OrderVO> orderVOList = new ArrayList<>();
        for (Orders orders:ordersList) {
            OrderVO orderVO = new OrderVO();
            BeanUtils.copyProperties(orders,orderVO);
            QueryWrapper wrapper = new QueryWrapper<>();
            wrapper.eq("id",orders.getItemsId());
            orderVO.setItemsName(itemsMapper.selectOne(wrapper).getName());
            orderVOList.add(orderVO);
        }
        dataVO.setData(orderVOList);
        return dataVO;
    }

}
