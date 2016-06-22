
app.config(function($routeProvider) {
	$routeProvider.when('/login', {
		templateUrl : 'login.do',
		controller : 'loginCtrl'
	});
	
});

app.controller('loginCtrl', function($scope, $http, $location) {
//	$scope.name = "fihi";
//	$scope.join = {};
//	$scope.join.memberId = "hihi";
//	$scope.cl = function() {
//		$location.path("/main.do");
//		alert("아아아");
//	}
//
//	$scope.submit = function() {
//		var ajax = $http.post("/Project/member/member.do", {
//			memberId : $scope.join.memberId,
//			memberEmail : $scope.join.memberEmail,
//			memberName : $scope.join.memberName,
//			memberPassword : $scope.join.memberPassword
//		});
//		ajax.then(function(value) {
//			$location.path("member/main.do");
//		}, function(reason) {
//			$scope.join = reason.data;
//			alert("error");
//			$location.path("main.do");
//		});
//	}

});