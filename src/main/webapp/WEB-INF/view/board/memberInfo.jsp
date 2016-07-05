<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>내 정보</title>
<%
	request.setCharacterEncoding("utf-8");
%>
</head>
<body>
<article class="container">
   <div class="pen-title">
  <h1>내 정보 <small><span> <i class='fa fa-paint-brush'></i></span></small></h1>
</div>
<!-- Form Module-->
<div class="module form-module">
  <div class="toggle">
  </div>
  <div class="form">
  <div align="center">
    <h2>회원정보</h2>
    </div>
   <div>
   	<h3 style="font-weight: bold;">아이디</h3>
      <input type="text" id="id"  name="id"  value="${member.memberId }" style="border: 0px; font-weight: bold;" readonly="readonly"/>
   </div>
   <div>
    <h3 style="font-weight: bold;">이름</h3>
      <input type="text" id="name"  name="name" data-ng-model="memberName"  placeholder="${member.memberName }" />
      </div>
      <div>
      <h3 style="font-weight: bold;">이메일</h3>
      <input type="text" id="email"  name="email" data-ng-model="memberEmail" placeholder="${member.memberEmail }"/>
      </div>
      <div>
      <h3 style="font-weight: bold;">비밀번호</h3>
      <input type="password" id="password"  name="password" data-ng-model="memberPassword" />
      </div>
      <button  data-ng-click="memberInfoUpdate(${member.memberId })">수정</button>
      
      <button  data-ng-click="back()" style="margin-top: 10px;">취소</button>
  </div>

  <div class="cta"><a onclick="memberPwUp('${member.memberId }');" class="aTag" >비밀번호 변경하기</a></div>
</div>
      </article>
      
      <script type="text/javascript">
      
      function memberPwUp(loginId){
  		var popUp = window.open("/Project/board/changePassword.do?loginId="+loginId,"changePassword","width=500, height=600, left=600, top=150");
  		popUp.focus();
  	}
      </script>
</body>
</html>