<%--
  Created by IntelliJ IDEA.
  User: Le'novo
  Date: 2022/6/30
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/login.action" method="post">
        用户账户：<input type="text" name="username"/><br/>
        用户密码：<input type="password" name="password"/><br/>
        <input type="submit" value="登录"/><br/>
    </form>

</body>
</html>
