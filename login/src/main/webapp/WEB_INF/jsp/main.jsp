<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core" 			%>
<%@ taglib prefix="fn" 		uri="http://java.sun.com/jsp/jstl/functions" 		%>
<%@ taglib prefix="fmt" 	uri="http://java.sun.com/jsp/jstl/fmt" 				%>
<%@ taglib prefix="spring" 	uri="http://www.springframework.org/tags" 			%>
<%@ taglib prefix="form" 	uri="http://www.springframework.org/tags/form" 		%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<span id="aaa"></span>
아이읻 : <input type="text" id="id"/>
비밀번호 : <input type="passward" id="pwd"/>

</body>
</html>

<script>
	
	
	function login() {
		
		var data = {
				userId : $("#id").val()
				, userPwd : $("#pwd").val()
		}
		
		$.ajax({
			type : "POST",
			data : data,
			url : "<c:url value='/login'/>",
			dataType : "JSON",
			success : function(data) {
				
			},
			complete : function(data) {
			}, 
			error:function(request,status,error){
				alert("An error occurred, \nPlease contact the administrator.");
				//console.log("code:"+request.status+"\n"+"error:"+error+"\n"+"message:"+request.responseText);
			}
		});
		
	}
</script>