<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
        <title>CoolMeeting会议管理系统</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath }/styles/common.css"/>
        <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.js"></script>
    	<script type="text/javascript">
    		function login(){
    			if($("#username").val()==""){
    				$("#usernameError").html("请输入用户名");
    				return;
    			}
    			if($("#password").val()==""){
    				$("#passwordError").html("请输入密码");
    				return;
    			}
    			$("#loginForm").submit();
    		}
    		function focusNull(errorid){
    			$("#"+errorid).html("");
    		}
    		function validateNull(validateid,errorMsg){
    			if($("#"+validateid).val()==""){
    				$("#"+validateid+"Error").html(errorMsg);
    			}
    		}
    	</script>
    </head>
    <body>
        <div class="page-header">
            <div class="header-banner">
                <img src="${pageContext.request.contextPath }/images/header.png" alt="CoolMeeting"/>
            </div>
            <div class="header-title">
                欢迎访问Cool-Meeting会议管理系统
            </div>
            
        </div>
        <div class="page-body">
            
            <div class="page-content">
                <div class="content-nav">
                    登录
                </div>
                <form action="${pageContext.request.contextPath }/LoginServlet" method="post" id="loginForm">
                    <fieldset>
                        <legend>登录信息</legend>
                        <table class="formtable" style="width:50%">
                            <tr>
                                <td>账号名:</td>
                                <td>
                                    <input id="username" name="username" type="text" onfocus="focusNull('usernameError');" onblur="validateNull('username','请输入用户名')"/>
                                    <span id="usernameError" style="color:red"></span>
                                </td>
                            </tr>
                            <tr>
                                <td>密码:</td>
                                <td>
                                    <input id="password" name="password" type="password" onfocus="focusNull('passwordError')" onblur="validateNull('password','请输入密码')"/>
                                    <span id="passwordError" style="color:red"></span>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2" class="command">
                                    <input type="button" value="登录" class="clickbutton" onclick="login();"/>
                                    <input type="button" value="取消" class="clickbutton" onclick="window.history.back();"/>
                               		<a href="${pageContext.request.contextPath }/RegistJspServlet">用户注册</a>
                               		<span style="color:red">${msg }</span>
                                </td>
                            </tr>
                        </table>
                    </fieldset>
                </form>
            </div>
        </div>
        <div class="page-footer">
            <hr/>
            更多问题，欢迎联系<a href="mailto:webmaster@eeg.com">管理员</a>
            <img src="${pageContext.request.contextPath }/images/footer.png" alt="CoolMeeting"/>
        </div>
    </body>
</html>