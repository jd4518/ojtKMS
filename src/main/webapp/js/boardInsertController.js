
app.config(function($routeProvider) {
	$routeProvider.when('/boardInsert/:categoryNo:menuNo', {
		templateUrl : 'boardInsert.do',
		controller : 'boardInsertCtrl'
	});
});



app.controller('boardInsertCtrl',function($scope, $http, $routeParams){
	
	$scope.cNo =  $routeParams.categoryNo;
	$scope.mNo =  $routeParams.menuNo;
	
	
	$scope.board = function(loginId){
		var ajax = $http.post("/Project/board/boardWrite.do", {
			categoryNo		: $scope.cNo,
			menuNo			: $scope.mNo,
			boardTitle 		: $scope.title,
			memberId		: loginId,
			boardContent	: $scope.content
		});
		ajax.then(function(value) {
			history.back();
		}, function(reason) {
			$scope.join = reason.data;
			alert("error"+join);
		});
	}	
	$scope.back = function(){
		history.back();
	}
	
	

});