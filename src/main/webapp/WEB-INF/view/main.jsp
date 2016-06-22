<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<%@ include file="/WEB-INF/view/include/common.jsp"%>
<meta name="viewport" content="width=device-width, initial-scale=1">


<title>Main.jsp</title>
</head>
<body>

	


	<!-- Header -->
	<a name="about"></a>
	<div class="intro-header">
		<div class="container">

			<div class="row">
				<div class="col-lg-12">
					<div class="intro-message">
						<h1>Broadcast IT</h1>
						<h3>BIT</h3>
						<hr class="intro-divider">
						<div id="align">
							<div id="content">
								<form class="form-horizontal" role="form"
									action="member/join.do" method="post">
								
									<div class="form-group">
										<div class="col-sm-offset-2 col-sm-10">
											<!--       <div class="checkbox"> -->
											<!--         <label><input type="checkbox"> Remember me</label> -->
											<!--       </div> -->
										</div>
									</div>
									<div class="form-group">
										<div class="col-sm-offset-1 col-sm-5">
											<a href="member/memberMain.do"
												class="btn btn-lg btn-success btn-block">회원가입</a>
										</div>
										<div class="col-sm-offset-1 col-sm-5">
											<a href="member/memberMain.do#/login"
												class="btn btn-lg btn-primary btn-block">로그인</a>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>

	</div>

</body>

</html>
