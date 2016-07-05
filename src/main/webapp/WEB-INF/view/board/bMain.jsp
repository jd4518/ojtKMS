<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html lang="ko">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>B I T</title>
</head>
<body>
	<div class="container clearfix">
		<div class="row">
			<div class="col-md-6 col-sm-12">
				<div class="qsz-orange">
					<div class="qsz-title-orange font-16 en">
						 <span class="pull-right white">+</span> <b class="white">최근에
								올라온 글 </b>
						
					</div>
					<div class="widget-box">
						<div class="img-wrap col-lg-12" style="padding-bottom: 42.4%;">
							<div class="img-item">
								<div id="htrcpilfoskmenjuqgdv" class="flexslider">
									<table class="table table-striped table-hover">
										<thead>
											<tr style="color: #ffffff;">
												<th>NO</th>
												<th>글 제목</th>
												<th>아이디</th>
												<th>카테고리이름</th>
												<th>추천 수</th>
											</tr>
										</thead>
										<tbody style="background-color: #ffffff">
											<tr data-ng-repeat="r in recent">
												<td style="font-weight: bold;">{{$index+1}}</td>
												<td>{{r.boardTitle}}</td>
												<td>{{r.memberId}}</td>
												<td>{{r.categoryName}}</td>
												<td>{{r.boardRecommandPoint}}</td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>

				</div>

			</div>
			<div class="col-md-6 col-sm-12">
				<!-- 로그인 시작 -->
				<div class="qsz-gray">
					<div class="div-title-underbar font-16 en"></div>

					<div class="qsz-orange">
						<div class="qsz-title-orange font-16 en">
							<span class="pull-right white">+</span> <b class="white">추천이
									가장 많은 글 </b>
							
						</div>
						<div class="widget-box">
							<div class="img-wrap col-lg-12" style="padding-bottom: 42.4%;">
								<div class="img-item">
									<div id="htrcpilfoskmenjuqgdv" class="flexslider">
										<table class="table table-striped table-hover">
										<thead>
											<tr style="color: #ffffff;">
												<th>NO</th>
												<th>글 제목</th>
												<th>아이디</th>
												<th>카테고리이름</th>
												<th>추천 수</th>
											</tr>
										</thead>
										<tbody style="background-color: #ffffff">
											<tr data-ng-repeat="t in topRecommand">
												<td style="font-weight: bold;">{{$index+1}}</td>
												<td>{{t.boardTitle}}</td>
												<td>{{t.memberId}}</td>
												<td>{{t.categoryName}}</td>
												<td>{{t.boardRecommandPoint}}</td>
											</tr>
										</tbody>
									</table>
									</div>
								</div>
							</div>
						</div>

					</div>
				</div>
			</div>
		</div>
		<!-- 로그인 끝 -->
	</div>
</body>
</html>