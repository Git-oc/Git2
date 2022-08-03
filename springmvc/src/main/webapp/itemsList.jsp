<%--
  Created by IntelliJ IDEA.
  User: Le'novo
  Date: 2022/7/5
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>添加商品</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

    <form action="test/add" method="post">
        <p>商品id：<label>
            <input type="text" name="id"/>
        </label></p>
        <p>商品名称：<label>
            <input type="text" name="name"/>
        </label></p>
        <p>商品价格：<label>
            <input type="text" name="price"/>
        </label></p>
        <p>商品品牌：<label>
            <input type="text" name="pic"/>
        </label></p>
        <p>出版时间：<label>
            <input type="text" name="createtime"/>
        </label></p>
        <p>商品类型：<label>
            <input type="text" name="detail"/>
        </label></p>
        <p><input type="submit" value="提交"/></p>
    </form>

</body>
</html>
