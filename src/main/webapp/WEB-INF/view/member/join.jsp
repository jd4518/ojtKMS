<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%
	request.setCharacterEncoding("utf-8");
%>
</head>
<body>

	<article class="container">
		<div class="pen-title">
			<h1>
				회원가입<small><span> <i class='fa fa-paint-brush'></i></span></small>
			</h1>
		</div>
		<div class="module form-module">
			<div class="toggle"></div>
			<div class="form">
				<h2>Create an account</h2>
				<form class="form-horizontal" name="myFrm" data-ng-submit="submit()" method="POST"  >
					<input type="text" data-ng-model="join.memberId" name="memberId"
						placeholder="Id" required="required" data-ng-blur="checkId()" />
						<span data-ng-show="a" style="color: red; font-weight: bold;">이미 사용중인 아이디 입니다.</span>
						<span data-ng-show="b" style="color: green; font-weight: bold;">사용가능한 아이디 입니다.</span>
					<input type="email"
						data-ng-model="join.memberEmail" name="memberEmail"
						placeholder="Email Address"  required="required" />
						<span data-ng-show="myFrm.memberEmail.$error.email" style="color: red; font-weight: bold;">올바른 이메일을 입력해 주세요.</span>
					<input
						type="text" data-ng-model="join.memberName" name="memberName" placeholder="Name" required="required" /> 
					<input type="password"
						data-ng-model="join.memberPassword" name="memberPassword"
						placeholder="Password" required="required" />
						 <input type="submit" class="btn btn-success" data-ng-disabled="a" value="회원가입" />
					<button type="button" data-ng-click="cl()">가입취소</button>
				</form>
			</div>
		</div>
	</article>

</body>
</html>