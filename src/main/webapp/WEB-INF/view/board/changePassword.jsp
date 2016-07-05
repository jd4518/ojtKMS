<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html data-ng-app="projectApp">
<%@ include file="/WEB-INF/view/include/common.jsp" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>비밀번호 변경</title>
<%String ss = request.getParameter("loginId"); %>
   	
</head>
<body  data-ng-controller="changePwCtrl">
<article class="container" >
   <div class="pen-title" style="padding-top: 20px;">
</div>
<!-- Form Module-->
<div class="module form-module">
  <div class="toggle">
  </div>
  <div class="form">
  <div align="center">
    <h2 style="font-weight: bold;color: #000000; margin-bottom: 50px;">비밀번호 변경</h2>
    </div>
   <div>
   	<h3 style="font-weight: bold;">비밀번호 입력</h3>
      <input type="password" id="password"  name="password"  data-ng-model="memberPassword"  />
      <button data-ng-click="checkPw('<%=ss %>')" >확인</button>
      <button  onclick="self.close()" style="margin-top: 10px; margin-bottom: 20px;">취소</button>
   </div>
   <div data-ng-show="a">
      <h3 style="font-weight: bold;">변경하실 비밀번호를 입력해주세요</h3><br>
      <input type="password" id="password"  name="password" data-ng-model="memberChangePassword" style="margin-top: 10px;"/>
      <button  data-ng-click="changePassword('<%=ss %>')">변경</button>
      </div>
  </div>

</div>
      </article>
</body>
</html>