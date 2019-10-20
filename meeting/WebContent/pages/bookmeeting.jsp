<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/styles/common.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js"></script>
<style type="text/css">
#divfrom {
	float: left;
	width: 150px;
}

#divto {
	float: left;
	width: 150px;
}

#divoperator {
	float: left;
	width: 50px;
	padding: 60px 5px;
}

#divoperator input[type="button"] {
	margin: 10px 0;
}

#selDepartments {
	display: block;
	width: 100%;
}

#selEmployees {
	display: block;
	width: 100%;
	height: 200px;
}

#selSelectedEmployees {
	display: block;
	width: 100%;
	height: 225px;
}
</style>
<script type="application/javascript">
            
            var selDepartments;
            var selEmployees;
            var selSelectedEmployees;  
            function body_load(){
                selDepartments = document.getElementById("selDepartments");
                selEmployees = document.getElementById("selEmployees");
                selSelectedEmployees = document.getElementById("selSelectedEmployees");
            }
            
            var ids = "meetingname,numberofparticipants,starttime,endtime";
        	var msgs = "请输入会议室名称,请输入预计参加人数,请选择预计开始时间,请选择预计结束时间";
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
        	
        	function checkNum(id){
        		var reg = /^[1-9]\d*$/;
        		if(!reg.test($("#"+id).val())){
        			$("#"+id+"Error").html("请输入正整数");
        			return false;
        		}
        		return true;
        	}
        	
        	function checkCapacity(){
        		var flag = false;
        		var numberofparticipants = $("#numberofparticipants").val();
        		$.ajax({
        			   type: "POST",
        			   url: "${pageContext.request.contextPath}/AjaxRoomcapacityServlet",
        			   data: "roomid="+$("#roomid").val(),
        			   dataType:"json",
        			   async: false,
        			   success: function(data){
        					var capacity = data.capacity;
        					if(capacity>numberofparticipants){
        						flag = true;
        					}else{
        						$("#numberofparticipantsError").html(data.roomname+"的最多容纳人数为"+data.capacity);
        					}
        			   }
        		});
        		return flag;
        	}
        	
        	function checkTime(){
        		var flag = false;
        		var numberofparticipants = $("#numberofparticipants").val();
        		$.ajax({
        			   type: "POST",
        			   url: "${pageContext.request.contextPath}/AjaxCheckTimeServlet",
        			   data: "starttime="+$("#starttime").val()+"&endtime="+$("#endtime").val()+"&roomid="+$("#roomid").val(),
        			   async: false,
        			   success: function(data){
        				   if(data=="fail"){
        					   $("#endtimeError").html("该会议室在此时间段已被占用");
        				   }else{
        					   flag = true;
        				   }
        			   }
        		});
        		return flag;
        	}
        	
        	function checkEmp(){
        		var str = $("#selSelectedEmployees option").map(function(){return $(this).val();}).get().join(",");
        		if(str==""){
        			$("#selEmployeesError").html("请选择参会人员");
        			return false;
        		}else{
        			$("#selEmpIds").val(str);
        			return true;
        		}
        	}
        	function bookmeeting(){
        		if(checkNulls() && checkNum("numberofparticipants") && checkCapacity() && checkTime() && checkEmp()){
        			$("#meetingForm").submit();
        		}
        	}
            
            function fillEmployees(){
                clearList(selEmployees);
                var departmentid = selDepartments.options[selDepartments.selectedIndex].value;
          
               	if(departmentid!=""){
               		$.ajax({
          			   type: "POST",
          			   url: "${pageContext.request.contextPath}/AjaxEmpByDepidServlet",
          			   data: "departmentid="+departmentid,
          			   dataType:"json",
          			   async: false,
          			   success: function(employees){
          				  for(i=0;i<employees.length;i++){
          	                    var emp = document.createElement("option");
          	                    emp.value = employees[i].employeeid;
          	                    emp.text = employees[i].employeename;
          	                    selEmployees.appendChild(emp);
          	                } 
          			   }
          		});
               	}
                
            }
            
            function clearList(list){
                while(list.childElementCount > 0){
                    list.removeChild(list.lastChild);
                }
            }
            
            function selectEmployees(){
                for(var i=0;i<selEmployees.options.length;i++){
                    if (selEmployees.options[i].selected){
                        addEmployee(selEmployees.options[i]);
                        selEmployees.options[i].selected = false;
                    }
                }
            }
            
            function deSelectEmployees(){
                var elementsToRemoved = new Array();
                var options = selSelectedEmployees.options;
                for(var i=0;i<options.length;i++){
                    if (options[i].selected){
                        elementsToRemoved.push(options[i]);
                    }
                }
                for(i=0;i<elementsToRemoved.length;i++){
                    selSelectedEmployees.removeChild(elementsToRemoved[i]);
                }
            }
            
            function addEmployee(optEmployee){
                var options = selSelectedEmployees.options;
                var i = 0;
                var insertIndex = -1;
                while(i < options.length){
                    if (optEmployee.value == options[i].value){
                        return;
                    } else if (optEmployee.value < options[i].value) {
                        insertIndex = i;
                        break;
                    }
                    i++;
                }
                var opt = document.createElement("option");
                opt.value = optEmployee.value;
                opt.text = optEmployee.text;
                
                if (insertIndex == -1){
                    selSelectedEmployees.appendChild(opt);
                } else {
                    selSelectedEmployees.insertBefore(opt, options[insertIndex]);
                }
            }            
        </script>
</head>
<body onload="body_load()">
<div class="page-content">
                <div class="content-nav">
                    会议预定 > 预定会议
                </div>
                <form id="meetingForm" method="post" action="${pageContext.request.contextPath}/AddMeetingServlet">
                <input style="display:none;" type="text" id="selEmpIds" name="selEmpIds" />
                    <fieldset>
                        <legend>会议信息</legend>
                        ${msg }
                        <table class="formtable">
                            <tr>
                                <td>会议名称：</td>
                                <td>
                                    <input type="text" id="meetingname" name="meetingname" maxlength="20"/>
                                    <span style="color:red;" id="meetingnameError"></span>
                                </td>
                            </tr>
                            <tr>
                                <td>会议室名称：</td>
                                <td>
                                    <select name="roomid" id="roomid">    
                                    	<c:forEach items="${meetingroomList }" var="meetingroom">
                                     	<option value="${meetingroom.roomid }">${meetingroom.roomname }</option>
                                     	</c:forEach>
                                     </select>
                                </td>
                            </tr>
                            <tr>
                                <td>预计参加人数：</td>
                                <td>
                                    <input type="text" id="numberofparticipants" name="numberofparticipants"/>
                                    <span style="color:red;" id="numberofparticipantsError"></span>
                                </td>
                            </tr>
                            <tr>
                                <td>预计开始时间：</td>
                                <td>
                                    <input id="starttime" name="starttime" class="Wdate" type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',minDate:'%y-%M-{%d+1}'})"/>
                                	<span style="color:red;" id="starttimeError"></span>
                                </td>
                            </tr>
                            <tr>
                                <td>预计结束时间：</td>
                                <td>
                                    <input id="endtime" name="endtime" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',minDate:'#F{$dp.$D(\'starttime\')}'})"/>
                                	<span style="color:red;" id="endtimeError"></span>
                                </td>
                            </tr>
                            <tr>
                                <td>会议说明：</td>
                                <td>
                                    <textarea id="description" name="description" rows="5"></textarea>
                                </td>
                            </tr>
                            <tr>
                                <td>选择参会人员：</td>
                                <td>
                                    <div id="divfrom">
                                        <select id="selDepartments" onchange="fillEmployees()">
                                        	<option value="">请选择</option>
                                        	<c:forEach items="${departmentList }" var="department">
                                     			<option value="${department.departmentid }">${department.departmentname }</option>
                                     		</c:forEach>
                                        </select>
                                        <select id="selEmployees" multiple="true">
                                        </select>
                                        <span style="color:red;" id="selEmployeesError"></span>
                                    </div>
                                    <div id="divoperator">
                                        <input type="button" class="clickbutton" value="&gt;" onclick="selectEmployees()"/>
                                        <input type="button" class="clickbutton" value="&lt;" onclick="deSelectEmployees()"/>
                                    </div>
                                    <div id="divto">
                                        <select id="selSelectedEmployees" multiple="true">
                                        </select>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td class="command" colspan="2">
                                    <input type="button" onclick="bookmeeting();" class="clickbutton" value="预定会议"/>
                                    <input type="reset" class="clickbutton" value="重置"/>
                                </td>
                            </tr>
                        </table>
                    </fieldset>
                </form>
            </div>
</body>
</html>