<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>

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
										<label class="control-label col-sm-2" for="id">ID:</label>
										<div class="col-sm-10">
											<input type="text" data-ng-model="name" name="memberId"
												class="form-control" id="id" placeholder="Enter id">
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-sm-2" for="email">Email:</label>
										<div class="col-sm-10">
											<input type="text" data-ng-model="email" name="memberEmail"
												class="form-control" id="email" placeholder="Enter email">
										</div>
									</div>
									<div class="form-group">
										<div class="col-sm-offset-2 col-sm-10">
											<!--       <div class="checkbox"> -->
											<!--         <label><input type="checkbox"> Remember me</label> -->
											<!--       </div> -->
										</div>
									</div>
									<div class="form-group">
										<div class="col-sm-offset-2 col-sm-10">
											<a href="member/memberMain.do"
												class="btn btn-lg btn-primary btn-block">Sign Up</a>
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
