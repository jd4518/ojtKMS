<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="ko" data-ng-app="projectApp">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../include/common.jsp" %>
<%request.setCharacterEncoding("utf-8"); %>

<script type="text/javascript" src="/Project/js/joinController.js"></script>

</head>
<body data-ng-controller="mainCtrl">

<article class="container"  >

       
      <div class="pen-title">  
  <h1> 회원가입<small><span> <i class='fa fa-paint-brush'></i></span></small> </h1>
   </div>
 <div class="module form-module">
   <div class="toggle">
  </div>
          <div class="form">
    <h2>Create an account</h2>
    <form  novalidate="novalidate" data-ng-submit="submit()">
      <input type="text" placeholder="Id" value="${param.memberId}"/>
      <input type="email" placeholder="Email Address" value="${param.memberEmail}"/>
      <input type="text" data-ng-model="name" placeholder="Name"/>
      {{name}}
      <input type="password" placeholder="Password"/>
      <button type="submit">가입</button> <button type="cancle()">가입취소</button>
    </form>
  </div>
  </div>
          <hr>
      </article>

</body>
</html>