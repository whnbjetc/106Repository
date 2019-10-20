<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" href="${pageContext.request.contextPath }/styles/common.css"/>
 <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.js"></script>
<script type="text/javascript">
	var ids = "employeename,username,password,confirm,phone,email";
	var msgs = "请输入姓名,请输入用户名,请输入密码,请输入确认密码,请输入手机号,请输入电子邮件";
	function checkNulls(){
		var idArray = ids.split(",");
		var msgArray = msgs.split(",");
		for(var i=0;i<idArray.length;i++){
			if($("#"+idArray[i]).val()==""){
				$("#"+idArray[i]+"Error").html(msgArray[i]);
				return false;
			}
		}
		return true;
	}
	function checkPwd(){
		if($("#password").val().length<6){
			$("#passwordError").html("请输入6位以上密码");
			return false;
		}
		if($("#password").val()!=$("#confirm").val()){
			$("#confirmError").html("两次密码输入不一致");
			return false;
		}
		return true;
	}
	function checkPhone(){
		var reg = /^1[3|4|5|7|8][0-9]{9}$/;
		if(!reg.test($("#phone").val())){
			$("#phoneError").html("请输入正确格式的手机号");
			return false;
		}
		return true;
	}
	function checkEmail(){
		var reg = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
		if(!reg.test($("#email").val())){
			$("#emailError").html("请输入正确格式的电子邮件");
			return false;
		}
		return true;
	}
	function ajaxCheckName(){
		var flag = false;
		$.ajax({
			   type: "POST",
			   url: "AjaxCheckNameServlet",
			   data: "username="+$("#username").val(),
			   async: false,
			   success: function(data){
				   if(data=="success"){
					   flag = true;
				   }else{
					   $("#usernameError").html("用户名已存在，请重新输入");
					   flag = false;
				   }
			   }
		});
		return flag;
	}
	function regist(){
		if(checkNulls() && ajaxCheckName() && checkPwd() && checkPhone() && checkEmail()){
			$("#registForm").submit();
		}
	}
</script>
</head>
<body>
	<div class="page-header">
            <div class="header-banner">
                <img src="images/header.png" alt="CoolMeeting"/>
            </div>
            <div class="header-title">
                欢迎访问Cool-Meeting会议管理系统
            </div>
            
        </div>
	<div class="page-content">
                <div class="content-nav">
                    人员管理 > 员工注册
                </div>
                <form action="RegistServlet" method="post" id="registForm">
                    <fieldset>
                        <legend>员工信息</legend>
                        <table class="formtable" style="width:50%">
                            <tr>
                                <td>姓名：</td>
                                <td>
                                    <input type="text" id="employeename" name="employeename" maxlength="20"/>
                               		<span style="color:red;" id="employeenameError"></span>
                                </td>
                            </tr>
                            <tr>
                                <td>账户名：</td>
                                <td>
                                    <input type="text" id="username" name="username" maxlength="20"/>
                               		<span style="color:red;" id="usernameError"></span>
                                </td>
                            </tr>
                            <tr>
                                <td>密码：</td>
                                <td>
                                    <input type="password" id="password" name="password" maxlength="20" placeholder="请输入6位以上的密码"/>
                                	<span style="color:red;" id="passwordError"></span>
                                </td>
                            </tr>
                            <tr>
                                <td>确认密码：</td>
                                <td>
                                    <input type="password" id="confirm" maxlength="20"/>
                                    <span style="color:red;" id="confirmError"></span>
                                </td>
                            </tr>
                            <tr>
                                <td>联系电话：</td>
                                <td>
                                    <input type="text" id="phone" name="phone" maxlength="20"/>
                               		<span style="color:red;" id="phoneError"></span>
                                </td>
                            </tr>
                            <tr>
                                <td>电子邮件：</td>
                                <td>
                                    <input type="text" id="email" name="email" maxlength="20"/>
                                	<span style="color:red;" id="emailError"></span>
                                </td>
                            </tr>
                            <tr>
							<td>所在部门：</td>
                                <td>
                                    <select name="departmentid">  
                                    	<c:forEach items="${list}" var="department">
                                    		<option value="${department.departmentid }">${department.departmentname }</option>
                                    	</c:forEach>  
                                     </select>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="6" class="command">
                                    <input type="button" class="clickbutton" value="注册" onclick="regist();"/>
                                    <input type="reset" class="clickbutton" value="重置"/>
                                </td>
                            </tr>
                        </table>
                    </fieldset>
                </form>
            </div>
</body>
</html>