<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/UserRegistServlet" method="post">
		用户名：<input type="text" name="name">
		密码：<input type="password" name="pwd">
		住址：<input type="text" name="address">
		生日：<input type="text" name="birthday">
		年龄：<input type="text" name="age">
		<input type="submit" value="注册">
		
		<input type="hidden" name="mark" value="reg">
	</form>
	<font color="red">${message}</font>
</body>
</html>