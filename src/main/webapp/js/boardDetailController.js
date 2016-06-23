
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
	
	$scope.reply = function(loginId){
		var ajax = $http.post("/Project/board/comment.do", {
			boardNo 		: $scope.board.boardNo,
			categoryNo		: $scope.board.categoryNo,
			replyContent	:	$scope.content,
			memberId		: loginId
		});
		ajax.then(function(value) {
			$scope.boardDetail();
			$scope.content = "";
		}, function(reason) {
			$scope.join = reason.data;
			alert("error"+join);
			location.href = "/Project/main.do";
		});
	}
	
	
	
});