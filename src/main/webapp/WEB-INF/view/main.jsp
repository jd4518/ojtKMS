<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko" data-ng-app="projectApp">
<head>

<meta name="viewport" content="width=device-width, initial-scale=1">
<%@ include file="include/common.jsp" %>

<!-- <script type="text/javascript"> -->
<!--  var app = angular.module("projectApp", []); -->

<!--  app.controller("mainCtrl", function($scope) { -->
<!--      $scope.name = "John"; -->
<!--  }); -->

<!-- </script> -->
<title>Main.jsp</title>
<script type="text/javascript">

var app = angular.module("travelerApp", ['ngRoute']);
	app.config(['$routeProvider'],function($routeProvider) {
		console.log("/insert config...")
		
				$routeProvider.when('/join', {				
				templateUrl: "join.do",				
				controller: "mainCtrl"			
			});
	});
app.controller("mainCtrl", function($scope, $http, $location) {
	
	console.log("mainController...");
});

</script>
</head>
<body data-ng-controller="mainCtrl">

    <!-- Navigation -->
    <nav class="navbar navbar-default navbar-fixed-top topnav" role="navigation">
        <div class="container topnav">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand topnav" href="main.do">It Information Broadcast</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li>
                    </li>
                    <li>
                        <a href="member/login.do">Login</a>
                    </li>
                    <li>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>


    <!-- Header -->
    <a name="about"></a>
    <div class="intro-header">
        <div class="container">

            <div class="row">
                <div class="col-lg-12">
                    <div class="intro-message">
                        <h1>It Information Broadcast</h1>
                        <h3>K M System</h3>
                        <hr class="intro-divider">
                        <div id="align">
                        <div id="content">
           <form class="form-horizontal" role="form" action="member/join.do" method="post" >
  <div class="form-group">
    <label class="control-label col-sm-2" for="id">ID:</label>
    <div class="col-sm-10">
      <input type="text" name="memberId" class="form-control" id="id" placeholder="Enter id">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="email">Email:</label>
    <div class="col-sm-10"> 
     <input type="email" data-ng-model="name" name="memberEmail" class="form-control" id="email" placeholder="Enter email">
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
      <button type="submit" class="btn btn-lg btn-primary btn-block">Sign Up</button>
      <a href="#/join">angular 라우터 테스트</a>
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
