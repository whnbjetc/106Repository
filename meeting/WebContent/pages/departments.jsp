<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/styles/common.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script type="text/javascript">
	function addDepartment(){
		if($("#departmentname").val()!=""){
			$("#addForm").submit();
		}
	}
	function editDepartment(departmentid,departmentname){
		$("#depname"+departmentid).html("<input type='text' id='departmentname"+departmentid+"' value='"+departmentname+"' />");
		$("#cancelBtn"+departmentid).show();
		$("#editRealBtn"+departmentid).show();
		$("#editBtn"+departmentid).hide();
	}
	function cancel(departmentid,departmentname){
		$("#depname"+departmentid).html(departmentname);
		$("#cancelBtn"+departmentid).hide();
		$("#editRealBtn"+departmentid).hide();
		$("#editBtn"+departmentid).show();
	}
	function editDepartmentReal(departmentid){
		$("#editDname").val($("#departmentname"+departmentid).val());
		$("#editDid").val(departmentid);
		$("#editForm").submit();
	}
	function deleteDep(departmentid){
		if(confirm("如果删除该部门，则该部门下的员工也将被删除，确定删除吗？")){
			window.location.href = "${pageContext.request.contextPath}/DeleteDepartmentServlet?departmentid="+departmentid;
		}
	}
</script>
</head>
<body>
<form action="${pageContext.request.contextPath}/EditDepartmentServlet" method="post" id="editForm">
	<input style="display:none;" type="text" name="departmentname" id="editDname"/>
	<input style="display:none;" type="text" name="departmentid" id="editDid"/>
</form>
<div class="page-content">
                <div class="content-nav">
                    人员管理 > 部门管理
                </div>
                <form action="${pageContext.request.contextPath}/AddDepartmentServlet" method="post" id="addForm">
                    <fieldset>
                        <legend>添加部门</legend>
                        部门名称:
                        <input type="text" id="departmentname" name="departmentname" maxlength="20"/>
                        <input type="button" onclick="addDepartment();" class="clickbutton" value="添加"/>
                    </fieldset>
                </form>
                <table class="listtable">
                    <caption>所有部门:</caption>
                    <tr class="listheader">
                        <th>部门编号</th>
                        <th>部门名称</th>
                        <th>操作</th>
                    </tr>
                    <c:forEach items="${list }" var="department">
                    <tr>
                        <td>${department.departmentid }</td>
                        <td id="depname${department.departmentid }">${department.departmentname }</td>
                        <td>
                            <a class="clickbutton" id="editBtn${department.departmentid }" onclick="editDepartment('${department.departmentid }','${department.departmentname }');">编辑</a>
                            <a style="display:none;" id="editRealBtn${department.departmentid }" class="clickbutton" onclick="editDepartmentReal('${department.departmentid }');">编辑</a>
                            <a style="display:none;" id="cancelBtn${department.departmentid }" class="clickbutton" onclick="cancel('${department.departmentid }','${department.departmentname }');">取消</a>
                            <a class="clickbutton" onclick="deleteDep('${department.departmentid }');">删除</a>
                        </td>
                    </tr>
                    </c:forEach>
                </table>
            </div>
</body>
</html>