package com.layui.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.layui.entity.Items;
import com.layui.mapper.ItemsMapper;
import com.layui.service.ItemsService;
import com.layui.vo.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemsServiceImpl implements ItemsService {

    @Resource
    private ItemsMapper itemsMapper;


    @Override
    public DataVO<Items> findData(Integer page,Integer limit) {

        DataVO<Items> dataVO = new DataVO<>();
        dataVO.setCode(0);
        dataVO.setMsg("");

        IPage<Items> itemsIPage = new Page<>(page,limit);
        IPage<Items> result = itemsMapper.selectPage(itemsIPage,null);
        dataVO.setCount(result.getTotal());

        List<Items> itemsList = result.getRecords();
        dataVO.setData(itemsList);
        return dataVO;
    }

    @Override
    public BarVO getBarVO() {

        List<ItemsBarVO> list = itemsMapper.findAllItemsBarVO();
        List<String> names = new ArrayList<>();
        List<Integer> values = new ArrayList<>();
        for (ItemsBarVO itemsBarVO:list) {
            names.add(itemsBarVO.getName());
            values.add(itemsBarVO.getCount());
        }
        BarVO barVO = new BarVO();
        barVO.setNames(names);
        barVO.setValues(values);
        return barVO;

    }

    @Override
    public List<PieVO> getPieVO() {
        List<ItemsBarVO> list = itemsMapper.findAllItemsBarVO();
        List<PieVO> pieVOList = list.stream()
                .map(e -> new PieVO(
                        e.getCount(),
                        e.getName()
                )).collect(Collectors.toList());
        return pieVOList;
    }

}
