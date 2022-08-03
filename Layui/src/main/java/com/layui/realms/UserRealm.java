package com.layui.realms;

import com.layui.entity.Users;
import com.layui.mapper.PermissionsMapper;
import com.layui.mapper.RolesMapper;
import com.layui.mapper.UsersMapper;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;
import java.util.Set;

public class UserRealm extends AuthorizingRealm {

    @Resource
    private UsersMapper usersMapper;
    @Resource
    private RolesMapper rolesMapper;
    @Resource
    private PermissionsMapper permissionsMapper;

    @Override
    public String getName() {
        return "UserRealm";
    }


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取用户的用户名
        String username  = (String) principalCollection.iterator().next();
        //根据用户名查询用户角色
        Set<String> roles = rolesMapper.queryRoleNamesByUsername(username);
        //根据用户名查询用户权限
        Set<String> permissions = permissionsMapper.getPermissionByUsername(username);
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        info.setRoles(roles);
        info.setStringPermissions(permissions);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //参数authenticationToken就是传递的 subject.login(token)
        UsernamePasswordToken token= (UsernamePasswordToken) authenticationToken;
        //从token中获取用户名
        String username = token.getUsername();
        //根据用户名从数据库查询用户安全数据
        AuthenticationInfo info = null;
        try {
            Users user = usersMapper.queryUsername(username);
            info = new SimpleAuthenticationInfo(username,user.getPassword(),getName());
        } catch (Exception e) {
            System.out.println();
        }
        return info;
    }
}
