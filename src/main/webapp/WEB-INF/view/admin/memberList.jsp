<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style type="text/css">
th {
	text-align: center;
	background-color: #5cb85c;
	color: white;
}
td {
	valign:top;
	text-align: center;
}
</style>

</head>
<body class="container">
<div class="table-responsive">
	<div>
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">회원 목록 - 관리자 전용</div>
				<!-- <hr>
				<div class="col-md-offset-8 input-group">
					<input type="text" class="form-control">
					<span class="input-group-btn">
						<button class="btn btn-success" type="button">
							<i class="fa fa-search"></i>
						</button>
					</span>
				</div> -->
				<!-- /.panel-heading -->
				<div class="panel-body">
					<div>
						<table class="table table-striped table-bordered table-hover" align="center">
							<thead>
								<tr class="center">
									<th class="col-sm-1">No</th>
									<th class="col-sm-1">아이디</th>
									<th class="col-sm-1">이름</th>
									<th class="col-sm-1">이메일</th>
									<th class="col-sm-1">가입날짜</th>
									<th class="col-sm-3">마지막 로그인 시간</th>
									<th class="col-sm-1">정지 횟수</th>
									<th class="col-sm-1">권한</th>
									<th class="col-sm-1">강퇴</th>
									<th class="col-sm-1">매니저</th>
								</tr>
							</thead>
							<tbody>
								<tr data-ng-repeat="member in list.member">
									<td style="padding-top: 45px">{{member.rn}}</td>
									<td style="padding-top: 45px">{{member.memberId}}</td>
									<td style="padding-top: 45px">{{member.memberName}}</td>
									<td style="padding-top: 45px">{{member.memberEmail}}</td>
									<td style="padding-top: 45px">{{member.memberHireDate}}</td>
									<td style="padding-top: 45px">{{member.memberLastLogin}}</td>
									<td style="padding-top: 45px">{{member.memberStopPoint}}</td>
									<td style="padding-top: 45px"><div data-ng-if="member.authority=='ROLE_USER'" >사용자</div>
									<div data-ng-if="member.authority=='ROLE_ADMIN'" style="font-weight: bold;">운영자</div>
									<div data-ng-if="member.authority=='ROLE_MANAGER'" style="font-weight: bold;">매니저</div>
									<div data-ng-if="member.authority=='ROLE_STOP'" style="color:red;">정지중</div>
									</td>
									
									<td style="padding-top: 38px">
									<sec:authorize access="hasRole('ROLE_ADMIN')">
											<button class="btn btn-danger" type="button" data-ng-click="memberDelete(member.memberId)">
										      <i class='fa fa-trash'></i>
										    </button>
										    </sec:authorize>
									</td>
									<td style="padding-top: 38px">
									<sec:authorize access="hasRole('ROLE_ADMIN')">
										<span data-ng-if="member.authority=='ROLE_USER'">
											<button class="btn btn-success" type="button" data-ng-click="memberUpgrade(member.memberId)">
										      <i class='fa fa-arrow-up'></i>
										    </button>
										    </span>
										    <span data-ng-if="member.authority=='ROLE_MANAGER'">
											<button class="btn btn-primary" type="button" data-ng-click="memberDowngrade(member.memberId)">
										      <i class='fa fa-arrow-down'></i>
										    </button>
										    </span>
									</sec:authorize>
									</td>
								</tr>
							</tbody>
							<tr align="center"><td colspan="11">
								<uib-pagination
										data-total-items="list.page.totalItem"
										data-ng-model="pageNo"
										data-max-size="10"
										data-ng-change="selectPage()"
										data-boundary-links="true">
								</uib-pagination>
								</td>
							</tr>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>