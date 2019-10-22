<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

显示所有员工信息<br>
	员工姓名--员工生日--员工所在部门

<c:forEach items="${eList}" var="employee">
	${employee.name}--${employee.birthday}--${employee.department.departmentName }
	
	<a href="employeeAction!findById?id=${employee.id}&type=find">查看</a>
	<a href="employeeAction!findById?id=${employee.id}&type=edit">编辑</a>
	
	<br>
</c:forEach>

</body>
</html>