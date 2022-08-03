package com.layui.mapper;

import com.layui.entity.Users;

public interface UsersMapper {

    Users queryUsername(String username)throws Exception;

}
