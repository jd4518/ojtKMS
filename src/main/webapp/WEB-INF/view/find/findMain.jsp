<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html lang="ko" >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/WEB-INF/view/include/common.jsp" %>
<title>B I T</title>
<%
	request.setCharacterEncoding("utf-8");
%>
</head>
<body style="background-color: white;"> 
<h1 style="font-size: xx-large; margin-top: 5px; color:black; font-weight: bold;">아이디 / 비밀번호 찾기<i class="fa fa-search" aria-hidden="true"></i></h1>
 <div align="center" style="margin-top: 100px;"> 
 <div>
      <a type="button" class="btn btn-default " style="width: 100%;border-width:0px; font-weight: bold;" href="/Project/find/findId.do">아이디 찾기</a>
      </div>
      <div>
      <a type="button" class="btn btn-default " style="width: 100%;border-width:0px; font-weight: bold;" href="/Project/find/findPw.do">비밀번호 찾기</a>
      </div>
</div>
</body>
</html>