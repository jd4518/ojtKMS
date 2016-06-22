<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<script type="text/javascript" src="/Project/js/test.js"></script>
</head>
<body onload="document.loginfrm.loginId.focus();">
<article class="container">
   <div class="pen-title">
  <h1>Login <small><span> <i class='fa fa-paint-brush'></i></span></small></h1>
</div>
<!-- Form Module-->
<c:url var="loginUrl" value="/login" />
<div class="module form-module">
  <div class="toggle">
  </div>
  <div class="form">
    <h2>Login to your account</h2>
   <form id="loginFrm" name="loginFrm"  action="${loginUrl}" method="POST">
      <input type="text" id="id"  name="id" required="required"/>
      <input type="password" id="pwd"  name="pwd"  required="required"/>
      <button  data-ng-click="doLogin()">Login</button>
       <input type="hidden" name="${_csrf.parameterName}"

			value="${_csrf.token}" />
    </form>
  </div>

  <div class="cta"><a href="http://andytran.me">Forgot your password?</a></div>
</div>
      </article>
		<c:if test="${not empty error}">

			<div class="error">${error}</div>

		</c:if>

		<c:if test="${not empty msg}">

			<div class="msg">${msg}</div>

		</c:if>
</body>
</html>