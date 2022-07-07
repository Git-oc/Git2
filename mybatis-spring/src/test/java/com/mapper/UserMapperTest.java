package com.mapper;

import com.po.User;
import com.po.UserCustom;
import com.po.UserQueryVo;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;


public class UserMapperTest {

    private ApplicationContext applicationContext;

    // 此方法是在执行testFindUserById之前执行
    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
    }

    @Test
    public void FindUserById() throws Exception {

        UserMapper userMapper = (UserMapper) applicationContext.getBean("userMapper");

        //调用userMapper的方法
        User user = userMapper.findUserById(1);

        System.out.println(user);

    }

    @Test
    public void FindUserByName() throws Exception {

        UserMapper userMapper = (UserMapper) applicationContext.getBean("userMapper");

        //调用userMapper的方法
        List<User> user = userMapper.findUserByName("夏明");

        System.out.println(user);

    }

    //用户信息的综合查询
    @Test
    public void FindUserList() throws Exception {

        UserMapper userMapper = (UserMapper) applicationContext.getBean("userMapper");


        UserQueryVo userQueryVo = new UserQueryVo();
        UserCustom userCustom = new UserCustom();
        userCustom.setSex("1");

        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(10);
        ids.add(16);
        userQueryVo.setIds(ids);

        userQueryVo.setUserCustom(userCustom);

        List<UserCustom> list = userMapper.findUserList(userQueryVo);

        System.out.println(list);

    }

    //用户信息综合查询总数
    @Test
    public void FindUserCount() throws Exception {

        UserMapper userMapper = (UserMapper) applicationContext.getBean("userMapper");

        //创建包装对象，设置查询条件
        UserQueryVo userQueryVo = new UserQueryVo();
        UserCustom userCustom = new UserCustom();
        //由于这里使用动态sql，如果不设置某个值，条件不会拼接在sql中
        userCustom.setSex("1");
        userCustom.setUsername("小");
        userQueryVo.setUserCustom(userCustom);
        //调用userMapper的方法

        int count = userMapper.findUserCount(userQueryVo);

        System.out.println(count);

    }

    @Test
    public void FindUserByIdResultMap() throws Exception {

        UserMapper userMapper = (UserMapper) applicationContext.getBean("userMapper");

        //调用userMapper的方法
        User user = userMapper.findUserByIdResultMap(1);

        System.out.println(user);

    }

}