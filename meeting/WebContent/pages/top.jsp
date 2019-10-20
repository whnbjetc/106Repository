<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<title>无标题文档</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/styles/common.css"/>
</head>

<body>
  <div class="page-header">
            <div class="header-banner">
                <br /><img src="${pageContext.request.contextPath }/images/header.png" alt="CoolMeeting"/>
            </div>
            <div class="header-title">
                欢迎访问Cool-Meeting会议管理系统
            </div>
            <div class="header-quicklink">
                欢迎您，<strong>${employee.username }</strong>
                <a href="${pageContext.request.contextPath }/pages/changepassword.jsp" target="main">[修改密码]</a>
                <a href="${pageContext.request.contextPath }/LogoutServlet" target="_blank">[退出]</a>
            </div>
        </div>
</body>
</html>