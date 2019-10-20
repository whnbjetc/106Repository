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
	var ids = "roomnumber,capacity,roomcapacity";
	var msgs = "请输入门牌号,请输入会议室名称,请输入最多容纳人数";
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
	function ajaxCheckRoomnum(){
		var flag = false;
		var roomnum = "${meetingroom.roomnum}";
		if(roomnum==$("#roomnumber").val()){
			return true;
		}
		$.ajax({
			   type: "POST",
			   url: "${pageContext.request.contextPath}/AjaxCheckRoomnumServlet",
			   data: "roomnum="+$("#roomnumber").val(),
			   async: false,
			   success: function(data){
				   if(data=="success"){
					   flag = true;
				   }else{
					   $("#roomnumberError").html("门牌号已存在，请重新输入");
					   flag = false;
				   }
			   }
		});
		return flag;
	}
	function ajaxCheckRoomname(){
		var flag = false;
		var capacity = "${meetingroom.roomname}";
		if(capacity==$("#capacity").val()){
			return true;
		}
		$.ajax({
			   type: "POST",
			   url: "${pageContext.request.contextPath}/AjaxCheckRoomnameServlet",
			   data: "capacity="+$("#capacity").val(),
			   async: false,
			   success: function(data){
				   if(data=="success"){
					   flag = true;
				   }else{
					   $("#capacityError").html("会议室名称已存在，请重新输入");
					   flag = false;
				   }
			   }
		});
		return flag;
	}
	function checkNum(id){
		var reg = /^[1-9]\d*$/;
		if(!reg.test($("#"+id).val())){
			$("#"+id+"Error").html("请输入正整数");
			return false;
		}
		return true;
	}
	function editmeetingroom(){
		var roomnum = $("#roomnumber").val();
		var roomcapacity = $("#roomcapacity").val();
		if(checkNulls() && checkNum('roomnumber') && ajaxCheckRoomnum() && ajaxCheckRoomname() && checkNum('roomcapacity')){
			$("#editForm").submit();
		}
	}
</script>
</head>
<body>
 <div class="page-content">
                <div class="content-nav">
                    会议预定 > 修改会议室信息
                </div>
                <form action="${pageContext.request.contextPath}/EditMeetingRoomServlet" method="post" id="editForm">
                <input type="text" style="display:none;" name="roomid" value="${meetingroom.roomid }"/>
                    <fieldset>
                        <legend>会议室信息</legend>
                        <table class="formtable">
                            <tr>
                                <td>门牌号:</td>
                                <td>
                                    <input id="roomnumber" name="roomnumber" type="text" value="${meetingroom.roomnum }" maxlength="10"/>
                                	<span style="color:red;" id="roomnumberError"></span>
                                </td>
                            </tr>
                            <tr>
                                <td>会议室名称:</td>
                                <td>
                                    <input id="capacity" name="capacity" type="text" value="${meetingroom.roomname }" maxlength="20"/>
                                	<span style="color:red;" id="capacityError"></span>
                                </td>
                            </tr>
                            <tr>
                                <td>最多容纳人数：</td>
                                <td>
                                    <input id="roomcapacity" name="roomcapacity" type="text" value="${meetingroom.capacity }"/>
                                	<span style="color:red;" id="roomcapacityError"></span>
                                </td>
                            </tr>
                            <tr>
                                <td>当前状态：</td>
                                <td>
                                 	<input type="radio" name="status" value="0" <c:if test="${meetingroom.status==0}">checked</c:if>/>
                                 	<label for="status">启用</label>
                                    <input type="radio" name="status" value="1" <c:if test="${meetingroom.status==1}">checked</c:if>/>
                                    <label for="status">停用</label>
                                  
                                </td>
                            </tr>
                            <tr>
                                <td>备注：</td>
                                <td>
                                    <textarea id="description" maxlength="200" rows="5" cols="60" >${meetingroom.description }</textarea>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2" class="command">
                                    <input type="button" onclick="editmeetingroom();" value="确认修改" class="clickbutton"/>
                                    <input type="button" class="clickbutton" value="返回" onclick="window.history.back();"/>
                                </td>
                            </tr>
                        </table>
                    </fieldset>
                </form>
            </div>
</body>
</html>