package com.layui.vo;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class OrderVO {

    private Integer id;
    private String itemsName;
    private Integer number;
    private Integer count;
    private Timestamp createtime;
    private String note;

}
