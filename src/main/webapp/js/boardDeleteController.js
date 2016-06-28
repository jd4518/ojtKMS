
app.config(function($routeProvider) {
	$routeProvider.when('/boardDelete/:BOARD_NO:categoryNo:menuNo', {
		templateUrl : 'boardDelete.do',
		controller : 'boardDeleteCtrl'
	});
});

app.controller('boardDeleteCtrl',function($scope, $http, $routeParams){
	
	
	$scope.cNo = $routeParams.categoryNo;
	$scope.bNo = $routeParams.BOARD_NO;
	$scope.mNo = $routeParams.menuNo;
	$scope.Flag = "N";
	
	$scope.nClick = function(){
		history.back();
	}
	
	$scope.yClick = function(){
		var ajax = $http.put("/Project/board/boardDelete.do", {
			categoryNo		: $scope.cNo,
			boardNo			: $scope.bNo,
			boardFlag 		: $scope.Flag 
		});
		ajax.then(function(value) {
			history.go(-2);
		}, function(reason) {
			$scope.join = reason.data;
			alert("error"+join);
			location.href = "/Project/main.do";
		});
	}
	
	
	
});