
app.controller('changePwCtrl', function($scope, $http, $location) {
	
	$scope.checkPw = function(memberId) {
		var ajax = $http.put("/Project/member/checkPw.do", {
			memberId : memberId,
			memberPassword : $scope.memberPassword
		});
		ajax.then(function(value) {
			$scope.result = value.data;
			if($scope.result!=0){
				$scope.a=true;
			}else{
				alert("비밀번호가 틀렸습니다.");
			}
				
		}, function(reason) {
			$scope.join = reason.data;
			alert("error");
			$location.path("main.do");
		});
	}
	
	$scope.back = function(){
		history.back();
	}
	
	$scope.changePassword = function(memberId){
		var ajax = $http.put("/Project/member/changePassword.do",{
			memberId : memberId,
			memberPassword : $scope.memberChangePassword
		});
		ajax.then(function(value) {
			$scope.result = value.data;
			if($scope.result!=0){
				alert("비밀번호가 변경되었습니다.");
				self.close();
				opener.location.href="/Project/logout.do";
			}else{
				alert("error");
			}
				
		}, function(reason) {
			$scope.join = reason.data;
			alert("error");
			$location.path("main.do");
		});
	}

});