<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/styles/common.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script type="text/javascript">
	$(function(){
		var msg = '${msg}';
		if(msg!=null && msg!=""){
			alert(msg);
		}
	});
	function approve(status,employeeid){
		$("#status").val(status);
		$("#employeeid").val(employeeid);
		$("#approveForm").submit();
	}
</script>
</head>
<body>
<form action="${pageContext.request.contextPath}/ApproveServlet" method="post" id="approveForm">
	<input type="text" name="status" id="status" style="display:none;"/>
	<input type="text" name="employeeid" id="employeeid" style="display:none;"/>
</form>
<div class="page-content">
                <div class="content-nav">
                    人员管理 > 注册审批
                </div>
                <table class="listtable">
                    <caption>所有待审批注册信息：</caption>
                    <tr class="listheader">
                        <th>姓名</th>
                        <th>账号名</th>
                        <th>联系电话</th>
                        <th>电子邮件</th>
                        <th>操作</th>
                    </tr>
                    <c:forEach items="${list}" var="employee">
                    <tr>
                        <td>${employee.employeename }</td>
                        <td>${employee.username }</td>
                        <td>${employee.phone }</td>
                        <td>${employee.email }</td>
                        <td>
                            <input type="button" class="clickbutton" value="通过" onclick="approve('1','${employee.employeeid}')"/>
                            <input type="button" class="clickbutton" value="拒绝" onclick="approve('2','${employee.employeeid}')"/>
                        </td>
                    </tr>
                    </c:forEach>
                    
                   
               
                </table>
            </div>
</body>
</html>