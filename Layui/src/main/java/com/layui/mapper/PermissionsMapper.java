package com.layui.mapper;

import java.util.Set;

public interface PermissionsMapper {

    Set<String> getPermissionByUsername(String username);

}
