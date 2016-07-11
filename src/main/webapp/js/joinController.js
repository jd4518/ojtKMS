
app.config(function($routeProvider) {
	$routeProvider.when('/join', {
		templateUrl : 'join.do',
		controller : 'joinCtrl'
	});
});

app.controller('joinCtrl', function($scope, $http, $location) {
	$scope.join = {};
	$scope.memberId = {};
	

	$scope.submit = function() {
		var ajax = $http.post("/Project/member/member.do", {
			memberId : $scope.join.memberId,
			memberEmail : $scope.join.memberEmail,
			memberName : $scope.join.memberName,
			memberPassword : $scope.join.memberPassword
		});
		ajax.then(function(value) {
			location.href = "/Project/member/memberMain.do#/login";
		}, function(reason) {
			$scope.join = reason.data;
			alert("error"+join);
			location.href = "/Project/main.do";
		});
	}
	
	
	$scope.cl = function() {
		location.href = "/Project/main.do";
	}
	
	
	
	
	$scope.a = false;
	$scope.b = false;
	$scope.checkId = function(){
		var ajax = $http.post("/Project/member/memberIdGet.do",{
			memberId : $scope.join.memberId
		});
		
		ajax.then(function(value){
			$scope.count = value.data;
			if($scope.count != 0){
				$scope.a = true;
				$scope.b = false;
			}else{
				$scope.a = false;
				$scope.b = true;
			}
		}, function(reason){
			alert("실패");
		})
	}
	
	
});
