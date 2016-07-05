<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="ko" >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>B I T</title>
<%
	request.setCharacterEncoding("utf-8");
%>
</head>
<script type="text/javascript">
	window.onload = function(){
		interval = setInterval(function(){
			location.href="${pageContext.request.contextPath}/logout.do";
		},3000);
	}
</script>
<body > 
<br>
<br>
 <div align="center">
 <h3><b style="font-size: xx-large;"> ${member.memberId} </b> 님 정지가 풀렸습니다 . <br><br> 다시 로그인 해주세요.</h3>
</div>
</body>
</html>