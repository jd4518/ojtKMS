<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html lang="ko" >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>B I T</title>
<%
	request.setCharacterEncoding("utf-8");
%>
<script type="text/javascript">
	window.onload = function(){
		interval = setInterval(function(){
			location.href="${pageContext.request.contextPath}/logout.do";
		},3000);
	}
</script>
</head>
<body > 
<br>
<br>
 <div align="center">
 <h3>${accused.memberId } 님<b style="font-size: xx-large;"> <fmt:formatDate var="startDateFmt" pattern="yyyy-MM-dd HH:mm" value="${accused.stopStartDate }"/>
 <c:out value="${startDateFmt }"/>
부터 
<fmt:formatDate var="endDateFmt" pattern="yyyy-MM-dd HH:mm" value="${accused.stopEndDate}" />
<c:out value="${endDateFmt }"/>까지</b> 정지 입니다.</h3>
</div>
</body>
</html>