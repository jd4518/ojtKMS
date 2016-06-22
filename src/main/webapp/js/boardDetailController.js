
app.config(function($routeProvider) {
	$routeProvider.when('/boardDetail/:BOARD_NO:categoryNo', {
		templateUrl : 'boardDetail.do',
		controller : 'boardDetailCtrl'
	});
});

app.controller('boardDetailCtrl',function($scope, $http, $routeParams){

	$scope.board = {};
	$scope.comment = {};
	$scope.boardDetail = function(){
		var ajax = $http.get("/Project/board/boardDetail/"+$routeParams.BOARD_NO+$routeParams.categoryNo+"x.do",{
		});
		
		ajax.then(function(value){
			$scope.board = value.data.list;
			$scope.comment = value.data.comment;
		},function(reason){
			alert("error");
		});
	}
	$scope.boardDetail();
		
});