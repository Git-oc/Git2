package com.dao;

import com.entity.UserBean;

public interface UserDao {

    //验证登录信息
    public UserBean getUsrInfoByNameAndPsw(UserBean userbean);
    //修改密码
    public void mmxg(UserBean userbean);

}
