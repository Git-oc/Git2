package com.layui.service;

import com.layui.entity.Items;
import com.layui.vo.BarVO;
import com.layui.vo.DataVO;
import com.layui.vo.PieVO;

import java.util.List;

public interface ItemsService {

    DataVO<Items> findData(Integer page, Integer limit);
    BarVO getBarVO();
    List<PieVO> getPieVO();



}
