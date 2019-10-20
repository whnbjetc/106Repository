<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
 </script>
</head>
<body>
<div class="page-content">
                <div class="content-nav">
                    会议预定 > 查看会议室
                </div>
                <table class="listtable">
                    <caption>所有会议室:</caption>
                    <tr class="listheader">
                        <th>门牌编号</th>
                        <th>会议室名称</th>
                        <th>容纳人数</th>
                        <th>当前状态</th>
                        <th>操作</th>
                    </tr>
                    <c:forEach items="${list }" var="meetingroom">
                    <tr>
                        <td>${meetingroom.roomnum }</td>
                        <td>${meetingroom.roomname }</td>
                        <td>${meetingroom.capacity }</td>
                        <td>
							<c:if test="${meetingroom.status=='0' }">
							启用
							</c:if>
							<c:if test="${meetingroom.status=='1' }">
							停用
							</c:if>
						</td>
                        <td>
                            <a class="clickbutton" href="${pageContext.request.contextPath}/MeetingroomDetailServlet?roomid=${meetingroom.roomid}">查看详情</a>
							<a class="clickbutton" href="${pageContext.request.contextPath}/DeleteMeetingroomServlet?roomid=${meetingroom.roomid}">删除</a>
                        </td>
                    </tr>
                   </c:forEach>
                </table>
            </div>
</body>
</html>