<%--
  Created by IntelliJ IDEA.
  User: Le'novo
  Date: 2022/6/30
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>json交互测试</title>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.5.1.min.js"></script>
    <script type="text/javascript">
        //请求json，输出是json
        function requestJson() {
            $.ajax({
                type: 'post',
                url: '${pageContext.request.contextPath }/requestJson.action',
                contentType: 'application/json;charset=utf-8',
                //数据格式是json串，商品信息
                data: '{"name":"手机","price":999}',
                success: function (data) {//返回json结果
                    alert(data);
                }
            });
        }
        //请求key/value，输出是json
        function responseJson() {
            $.ajax({
                type: 'post',
                url: '${pageContext.request.contextPath }/responseJson.action',
                data: 'name=手机&price=999',
                success: function (data) {//返回json结果
                    alert(data.name);
                }
            });
        }
    </script>
</head>
<body>
    <input type="button" onclick="requestJson()" value="请求json，输出是json"/>
    <input type="button" onclick="responseJson()" value="请求key/value，输出是json"/>
</body>
</html>
