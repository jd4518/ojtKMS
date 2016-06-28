
app.config(function($routeProvider) {
	$routeProvider.when('/boardModify/:BOARD_NO:categoryNo', {
		templateUrl : 'boardModify.do',
		controller : 'boardModifyCtrl'
	});
});

app.controller('boardModifyCtrl',function($scope, $http, $routeParams){
	$scope.board = {};
	$scope.comment = {};
	
	
	$scope.cNo =  $routeParams.categoryNo;
	$scope.bNo =  $routeParams.BOARD_NO;
	
	$scope.boardDetail = function(){
		var ajax = $http.get("/Project/board/boardDetail/"+$routeParams.BOARD_NO+$routeParams.categoryNo+"x.do",{
		});
		
		ajax.then(function(value){
			$scope.board = value.data.b;
			$scope.comment = value.data.comment;
		},function(reason){
			alert("error");
		});
	}
	$scope.boardDetail();
		
	$scope.list = function(){
		history.back();
	}
	
	$scope.boardUpdate = function(){
		var ajax = $http.put("/Project/board/boardModify.do", {
			categoryNo		: $scope.cNo,
			boardNo			: $scope.bNo,
			menuNo			: $scope.board.menuNo,
			boardTitle 		: $scope.board.boardTitle,
			boardContent	: $scope.board.boardContent,
		});
		ajax.then(function(value) {
			history.back();
		}, function(reason) {
			$scope.join = reason.data;
			alert("error"+join);
			location.href = "/Project/main.do";
		});
	}
	
	
	
});