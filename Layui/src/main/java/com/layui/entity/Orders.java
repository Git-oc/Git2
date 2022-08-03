package com.layui.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
public class Orders {

    private Integer id;
    private Integer itemsId;
    private Integer number;
    private Integer count;
    private Timestamp createtime;
    private String note;

}
