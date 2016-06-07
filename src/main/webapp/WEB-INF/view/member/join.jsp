<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%
	request.setCharacterEncoding("utf-8");
%>
<%@ include file="/WEB-INF/view/include/common.jsp"%>
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
				<form class="form-horizontal" novalidate="novalidate"
					data-ng-submit="submit()">
					<input type="text" data-ng-model="join.memberId" name="memberId"
						placeholder="Id" value="${param.memberId}" /> <input type="email"
						data-ng-model="join.memberEmail" name="memberEmail"
						placeholder="Email Address" value="${param.memberEmail}" /> <input
						type="text" data-ng-model="join.memberName" name="memberName"
						data-ng-model="name" placeholder="Name" /> {{name}}
					{{join.memberId}} <input type="password"
						data-ng-model="join.memberPassword" name="memberPassword"
						placeholder="Password" /> <input type="submit" value="회원가입" />
					<button type="button" onclick="cl()">가입취소</button>
				</form>
			</div>
		</div>
		<hr>
	</article>

</body>
</html>