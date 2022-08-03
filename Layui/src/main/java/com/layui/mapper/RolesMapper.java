package com.layui.mapper;

import java.util.Set;

public interface RolesMapper {

    Set<String> queryRoleNamesByUsername(String username);

}
