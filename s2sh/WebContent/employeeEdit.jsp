<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="employeeAction!update" method="post">

	<input type="hidden" name="id" value="${employee.id }">
	
	员工姓名：<input type="text" name="name" value="${employee.name }"><br>
	员工生日：<input type="text" name="birthday" value="${employee.birthday }"><br>
	所在部门：<br>
	
	<input type="submit" value="确认修改">
	<a href="javascript:history.go(-1)">返回</a>

</form>
</body>
</html>