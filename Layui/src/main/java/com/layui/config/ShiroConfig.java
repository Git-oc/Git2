package com.layui.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.layui.realms.AdminRealm;
import com.layui.realms.UserRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Bean
    public ShiroDialect getShiroDialect(){
        return new ShiroDialect();
    }

    @Bean
    public HashedCredentialsMatcher getHashedCredentialsMatcher(){
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        //加密方式
        matcher.setHashAlgorithmName("md5");
        //hash次数
        matcher.setHashIterations(1);
        return matcher;
    }

    @Bean
    public UserRealm userRealm(HashedCredentialsMatcher matcher){
        UserRealm userRealm = new UserRealm();
        //设置加密规则
        userRealm.setCredentialsMatcher(matcher);
        return userRealm;
    }
    @Bean
    public AdminRealm adminRealm(HashedCredentialsMatcher matcher){
        AdminRealm adminRealm = new AdminRealm();
        //设置加密规则
        adminRealm.setCredentialsMatcher(matcher);
        return adminRealm;
    }

    @Bean
    public UserRealm userRealm(){
        return new UserRealm();
    }
    @Bean
    public AdminRealm adminRealm(){
        return new AdminRealm();
    }
    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(){
        DefaultWebSecurityManager securityManager=new DefaultWebSecurityManager();
        //securityManager要完成校验，需要realm
        Collection<Realm> realms = new ArrayList<>();
        realms.add(userRealm());
        realms.add(adminRealm());
        securityManager.setRealms(realms);
        return securityManager;
    }

    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean filter=new ShiroFilterFactoryBean();
        filter.setSecurityManager(defaultWebSecurityManager);
        //设置shiro的拦截规则
        //anon   匿名用户可访问
        //authc  认证用户可访问
        //user   使用RemeberMe的用户可访问
        //perms  对应权限可访问
        //role   对应的角色可访问
        Map<String,String> filterMap=new HashMap<>();
        filterMap.put("/","anon");
        filterMap.put("/login.html","anon");
        filterMap.put("/admin.html","anon");
        filterMap.put("/login","anon");
        filterMap.put("/admin","anon");
        filterMap.put("/logout","logout");
        filterMap.put("/static/**","anon");
        filterMap.put("/**","authc");
        filter.setFilterChainDefinitionMap(filterMap);

        filter.setLoginUrl("/login.html");
        //设置未授权页面跳转到登录页面
        filter.setUnauthorizedUrl("/login.html");
        return filter;
    }

}
