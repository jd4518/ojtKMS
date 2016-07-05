
app.config(function($routeProvider) {
	$routeProvider.when('/memberInfo', {
		templateUrl : 'memberInfo.do',
		controller : 'memberInfoCtrl'
	});
	
});

app.controller('memberInfoCtrl', function($scope, $http, $location) {
	
	$scope.memberInfoUpdate = function(memberId) {
		
		
		var ajax = $http.put("/Project/member/memberInfoUpdate.do", {
			memberId : memberId,
			memberName : $scope.memberName,
			memberEmail : $scope.memberEmail,
			memberPassword : $scope.memberPassword
		});
		ajax.then(function(value) {
			$scope.result = value.data;
			if($scope.result!=0){
				alert("수정성공");
			location.href="/boardMain.do#/bMain";
			}else{
				alert("비밀번호가 틀렸습니다.");
			}
				
		}, function(reason) {
			$scope.join = reason.data;
			alert("error");
			$location.path("main.do");
		});
	}
	

});