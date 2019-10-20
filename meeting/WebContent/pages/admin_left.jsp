<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<title>无标题文档</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/styles/common02.css"/>
</head>
<body>
            <div class="page-sidebar">
                <div class="sidebar-menugroup">
                    <div class="sidebar-grouptitle">个人中心</div>
                    <ul class="sidebar-menu">
                        <li class="sidebar-menuitem"><a href="01.html" target="main">最新通知</a></li>
                        <li class="sidebar-menuitem active"><a href="01.html" target="main">我的预定</a></li>
                        <li class="sidebar-menuitem"><a href="01.html" target="main" >我的会议</a></li>
                    </ul>
                </div>
              
                <div class="sidebar-menugroup">
                    <div class="sidebar-grouptitle">人员管理</div>
                    <ul class="sidebar-menu">
                        <li class="sidebar-menuitem"><a href="${pageContext.request.contextPath }/SearchDepartmentServlet"  target="main">部门管理</a></li>
                        <li class="sidebar-menuitem"><a href="${pageContext.request.contextPath }/ApproveAccountServlet" target="main">注册审批</a></li>
                        <li class="sidebar-menuitem"><a href="${pageContext.request.contextPath }/SearchEmployeeServlet" target="main">搜索员工</a></li>
                    </ul>
                </div>              
                <div class="sidebar-menugroup">
                    <div class="sidebar-grouptitle">会议预定</div>
                    <ul class="sidebar-menu">
                        <li class="sidebar-menuitem"><a href="${pageContext.request.contextPath }/pages/addmeetingroom.jsp" target="main">添加会议室</a></li>
                        <li class="sidebar-menuitem"><a href="${pageContext.request.contextPath }/SearchMeetingroomServlet"target="main">查看会议室</a></li>
                        <li class="sidebar-menuitem"><a href="${pageContext.request.contextPath }/BookMeetingServlet" target="main">预定会议</a></li>
                       
                    </ul>
                </div>
            </div>
</body>
</html>