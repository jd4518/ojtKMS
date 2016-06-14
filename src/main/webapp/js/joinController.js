
app.config(function($routeProvider) {
	$routeProvider.when('/join', {
		templateUrl : 'join.do',
		controller : 'joinCtrl'
	});
});

app.controller('joinCtrl', function($scope, $http, $location) {
	$scope.name = "fihi";
	$scope.join = {};
	$scope.join.memberId = "hihi";

	$scope.cl = function() {
		alert($location.path());
		location.href = "/Project/main.do";
	}

	$scope.submit = function() {
		var ajax = $http.post("/Project/member/member.do", {
			memberId : $scope.join.memberId,
			memberEmail : $scope.join.memberEmail,
			memberName : $scope.join.memberName,
			memberPassword : $scope.join.memberPassword
		});
		ajax.then(function(value) {
			location.href = "/Project/board/boardMain.do#/bMain";
		}, function(reason) {
			$scope.join = reason.data;
			alert("error");
			location.href = "/Project/main.do";
		});
	}

});