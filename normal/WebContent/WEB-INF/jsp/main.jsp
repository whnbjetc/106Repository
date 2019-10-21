<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
${pageContext.request.contextPath}--
<%-- 导航 --%>
<c:if test="${not empty sessionScope.user}">
	欢迎${user.uname}登录
</c:if>
<c:if test="${empty sessionScope.user}">
	<a href="${pageContext.request.contextPath}/login.jsp">请登录</a>
	|
	<a href="${pageContext.request.contextPath}/reg.jsp">注册</a>
</c:if>


<p>----------------------------分割线-------------------------------</p>


<%-- 内容区 --%>
<c:if test="${not empty requestScope.menuList}">
	<c:forEach items="${requestScope.menuList}" var="menu">
		${menu.mname}<br>
	</c:forEach>
</c:if>
<c:if test="${empty requestScope.menuList}">
	没有数据显示
</c:if>
</body>
</html>