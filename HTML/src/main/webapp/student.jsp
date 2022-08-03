<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<title>学生信息</title>
	</head>
	
	<form action="student.jsp" method="post">
		<frameset rows="150,*" >
			<frame noresize="noresize" src="head.jsp" style="background-color:#cccc33"/>
			<frameset cols="200,*">
				<frame noresize="noresize" src="left.jsp"/>
				<frame noresize="noresize" src="homePage.jsp" name="body" />
			</frameset>
		</frameset>
	</form>
</html>