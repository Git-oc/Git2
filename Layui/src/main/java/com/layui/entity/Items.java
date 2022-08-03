package com.layui.entity;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Items {

  private Integer id;
  private String name;
  private Double price;
  private String detail;
  private String pic;
  private Timestamp createtime;

}
