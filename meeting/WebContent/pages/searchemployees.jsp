<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/styles/common.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.js"></script>
<script type="text/javascript">
$(function(){
	var msg = '${msg}';
	if(msg!=null && msg!=""){
		alert(msg);
	}
});
	function gotoPage(currentPage){
		$("#currentPage").val(currentPage);
		$("#searchForm").submit();
	}
	function tz(){
		var currentPage = $("#pagenum").val();
		var reg = /^[1-9]\d*$/;
		if(reg.test(currentPage)){
			var pageCount = "${page.pageCount}";
			if(parseInt(pageCount)<parseInt(currentPage)){
				gotoPage(pageCount);
			}else{
				gotoPage(currentPage);
			}
		}else{
			gotoPage(1);
		}
		
	}
	function approve(status,employeeid){
		var msg = "";
		var statusSearch = "${status}";
		if(status=="1"){
			if(statusSearch=="0" || statusSearch=="2"){
				msg = "确定要通过审批吗？";
			}else{
				msg = "确定要启用吗？";
			}
		}else if(status=="2"){
			msg="确定要拒绝吗？";
		}else if(status=="3"){
			msg = "确定要禁用吗？";
		}
		if(confirm(msg)){
			$("#status").val(status);
			$("#employeeid").val(employeeid);
			$("#approveForm").submit();
		}
		
	}
</script>
</head>
<body>
<form action="${pageContext.request.contextPath}/ApproveServlet" method="post" id="approveForm">
	<input type="text" name="status" id="status" style="display:none;"/>
	<input type="text" name="employeeid" id="employeeid" style="display:none;"/>
	<input type="text" name="index" id="index" value="searchEmployee" style="display:none;"/>
</form>
<div class="page-content">
                <div class="content-nav">
                    会议预定 > 搜索员工
                </div>
                <form action="${pageContext.request.contextPath }/SearchEmployeeServlet" method="post" id="searchForm">
                <input type="text" id="currentPage" name="currentPage" style="display:none;"/>
                    <fieldset>
                        <legend>搜索会议</legend>
                        <table class="formtable">
                            <tr>
                                <td>姓名：</td>
                                <td>
                                    <input type="text" name="employeename" value="${employeename }" maxlength="20"/>
                                </td>
                                <td>账号名：</td>
                                <td>
                                    <input type="text" name="username" value="${username }" maxlength="20"/>
                                </td>
                                <td>状态：</td>
                                <td>
                                    <input type="radio" name="status" value="1" <c:if test="${status==1 }">checked</c:if> /><label>已批准</label>
                                    <input type="radio" name="status" value="0" <c:if test="${status==0 }">checked</c:if> /><label>待审批</label>
									<input type="radio" name="status" value="2" <c:if test="${status==2 }">checked</c:if> /><label>未通过</label>
                                    <input type="radio" name="status" value="3" <c:if test="${status==3 }">checked</c:if> /><label>已关闭</label>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="6" class="command">
                                    <input type="submit" class="clickbutton" value="查询"/>
                                    <input type="reset" class="clickbutton" value="重置"/>
                                </td>
                            </tr>
                        </table>
                    </fieldset>
                </form>
                <div>
                    <h3 style="text-align:center;color:black">查询结果</h3>
                    <div class="pager-header">
                        <div class="header-info">
                            共<span class="info-number">${page.totalCount }</span>条结果，
                            分成<span class="info-number">${page.pageCount }</span>页显示，
                            当前第<span class="info-number">${page.currentPage }</span>页
                        </div>
                        <div class="header-nav">
                            <input type="button" class="clickbutton" value="首页" onclick="gotoPage('1');"/>
                            <c:if test="${page.currentPage>1 }">
                            <input type="button" class="clickbutton" value="上页" onclick="gotoPage('${page.currentPage-1}');"/>
                            </c:if>
                            <c:if test="${page.currentPage<page.pageCount }">
                            <input type="button" class="clickbutton" value="下页" onclick="gotoPage('${page.currentPage+1}');"/>
                            </c:if>
                            <input type="button" class="clickbutton" value="末页" onclick="gotoPage('${page.pageCount}');"/>
                            跳到第<input type="text" id="pagenum" class="nav-number" value="${page.currentPage }" />页
                            <input type="button" class="clickbutton" value="跳转" onclick="tz();"/>
                        </div>
                    </div>
                </div>
                <table class="listtable">
                    <tr class="listheader">
                        <th>姓名</th>
                        <th>账号名</th>
                        <th>联系电话</th>
                        <th>电子邮件</th>
                        <th>操作</th>
                    </tr>
                    <c:forEach items="${page.list }" var="employee">
                    <tr>
                        <td>${employee.employeename }</td>
                        <td>${employee.username }</td>
                        <td>${employee.phone }</td>
                        <td>${employee.email }</td>
                        <td>
                        	<c:if test="${status==1}">
                        	 <a class="clickbutton" onclick="approve(3,'${employee.employeeid}')">禁用</a>
                        	</c:if>
                        	<c:if test="${status==0 || status==2}">
                        	<a class="clickbutton" onclick="approve(1,'${employee.employeeid}')">通过</a>
                        	</c:if>
                        	<c:if test="${status==0}">
                        	<a class="clickbutton" onclick="approve(2,'${employee.employeeid}')">拒绝</a>
                        	</c:if>
                        	
                            <c:if test="${status==3}">
							<a class="clickbutton" onclick="approve(1,'${employee.employeeid}')">启用</a>
							</c:if>
                        </td>
                    </tr>
                    </c:forEach>
                    <c:if test="${page.list==null || page.list.size()==0 }">
                    	<td colspan="5">未找到匹配结果</td>
                    </c:if>
                    
                </table>
            </div>
            
</body>
</html>