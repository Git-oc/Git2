package com.mapper;

import com.po.Orders;
import com.po.OrdersCustom;
import com.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class OrdersMapperCustomTest {

    private SqlSessionFactory sqlSessionFactory;

    // 此方法是在执行testFindUserById之前执行
    @Before
    public void setUp() throws Exception {
        // 创建sqlSessionFactory

        // mybatis配置文件
        String resource = "mybatis/SqlMapConfig.xml";
        // 得到配置文件流
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // 创建会话工厂，传入mybatis的配置文件信息
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void FindOrdersUser() throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 创建代理对象
        OrdersMapperCustom ordersMapperCustom = sqlSession
                .getMapper(OrdersMapperCustom.class);

        // 调用maper的方法
        List<OrdersCustom> list = ordersMapperCustom.findOrdersUser();

        System.out.println(list);

        sqlSession.close();
    }

    @Test
    public void FindOrdersUserResultMap() throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 创建代理对象
        OrdersMapperCustom ordersMapperCustom = sqlSession
                .getMapper(OrdersMapperCustom.class);

        // 调用maper的方法
        List<Orders> list = ordersMapperCustom.findOrdersUserResultMap();

        System.out.println(list);

        sqlSession.close();
    }

    @Test
    public void FindOrdersAndOrderDetailResultMap() throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 创建代理对象
        OrdersMapperCustom ordersMapperCustom = sqlSession
                .getMapper(OrdersMapperCustom.class);

        // 调用maper的方法
        List<Orders> list = ordersMapperCustom
                .findOrdersAndOrderDetailResultMap();

        System.out.println(list);

        sqlSession.close();
    }

    @Test
    public void FindUserAndItemsResultMap() throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 创建代理对象
        OrdersMapperCustom ordersMapperCustom = sqlSession
                .getMapper(OrdersMapperCustom.class);

        // 调用maper的方法
        List<User> list = ordersMapperCustom.findUserAndItemsResultMap();

        System.out.println(list);

        sqlSession.close();
    }

    // 查询订单关联查询用户，用户信息使用延迟加载
    @Test
    public void FindOrdersUserLazyLoading() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();// 创建代理对象
        OrdersMapperCustom ordersMapperCustom = sqlSession
                .getMapper(OrdersMapperCustom.class);
        // 查询订单信息（单表）
        List<Orders> list = ordersMapperCustom.findOrdersUserLazyLoading();

        // 遍历上边的订单列表
        for (Orders orders : list) {
            // 执行getUser()去查询用户信息，这里实现按需加载
            User user = orders.getUser();
            System.out.println(user);
        }
    }

    // 一级缓存测试
    @Test
    public void Cache1() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();// 创建代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        // 第一次发起请求，查询id为1的用户
        User user1 = userMapper.findUserById(1);
        System.out.println(user1);

        // 第二次发起请求，查询id为1的用户
        User user2 = userMapper.findUserById(1);
        System.out.println(user2);

        sqlSession.close();

    }

    // 二级缓存测试
    @Test
    public void Cache2() throws Exception {
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        SqlSession sqlSession3 = sqlSessionFactory.openSession();
        // 创建代理对象
        UserMapper userMapper1 = sqlSession1.getMapper(UserMapper.class);
        // 第一次发起请求，查询id为1的用户
        User user1 = userMapper1.findUserById(1);
        System.out.println(user1);

        sqlSession1.close();

        UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);
        // 第二次发起请求，查询id为1的用户
        User user2 = userMapper2.findUserById(1);
        System.out.println(user2);

        sqlSession2.close();

    }

}