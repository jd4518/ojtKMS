
app.config(function($routeProvider) {
	$routeProvider.when('/reportInsert/:menuNo/:categoryNo/:boardNo', {
		templateUrl : 'reportInsert.do',
		controller : 'reportInsertCtrl'
	});
});



app.controller('reportInsertCtrl',function($scope, $http, $routeParams){
	
	$scope.mNo =  $routeParams.menuNo;
	$scope.cNo =  $routeParams.categoryNo;
	$scope.bNo =  $routeParams.boardNo;
	
	
	$scope.back = function(){
		history.back();
	}
	
	

});