package com.layui.entity;

import lombok.Data;

@Data
public class Users {

  private Integer id;
  private String username;
  private String password;
  private String passwordSalt;

}
