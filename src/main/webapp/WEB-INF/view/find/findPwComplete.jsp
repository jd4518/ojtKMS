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
<body > 
<h1>비밀번호 찾기</h1>
<br>
<br>
<c:if test="${pw!=0 }">
 <div align="center">
 <h3>등록하신 email로 임시비밀번호가 발송되었습니다.</h3>
</div>
</c:if>
<c:if test="${pw ==0}">
 <div align="center">
 <h3>등록된 회원이 아닙니다. 회원가입을 해주세요.</h3>
</div>
</c:if>
</body>
</html>