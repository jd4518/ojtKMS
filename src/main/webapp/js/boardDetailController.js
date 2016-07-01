
app.config(function($routeProvider) {
	$routeProvider.when('/boardDetail/:BOARD_NO:categoryNo:menuNo', {
		templateUrl : 'boardDetail.do',
		controller : 'boardDetailCtrl'
	});
});

app.controller('boardDetailCtrl',function($scope, $http, $routeParams){
	$scope.board = {};
	$scope.comment = {};
	$scope.files  = {};
	$scope.mNo = $routeParams.menuNo;
	$scope.bNo = $routeParams.BOARD_NO;
	$scope.cNo = $routeParams.categoryNo;
	
	
	// 해당하는 게시판의 정보를 불러옴
	$scope.boardDetail = function(){
		var ajax = $http.get("/Project/board/boardDetail/"+$routeParams.BOARD_NO+$routeParams.categoryNo+"x.do",{
		});
		
		ajax.then(function(value){
			$scope.board = value.data.b;
			$scope.comment = value.data.comment;
			$scope.files   = value.data.files;
		},function(reason){
			alert("error");
		});
	}
	$scope.boardDetail();
	
	// 조회수 증가
	$scope.boardHit = function(){
		var ajax = $http.put("/Project/board/boardHit.do",{
			boardNo 		: $scope.bNo,
			categoryNo		: $scope.cNo
		});
		
		ajax.then(function(value) {
		}, function(reason) {
			$scope.join = reason.data;
			alert("error"+join);
			location.href = "/Project/main.do";
		});
	}
	
	$scope.boardHit();
	
	$scope.list = function(){
		history.back();
	}
	
	// 댓글 입력
	$scope.reply = function(loginId){
		var ajax = $http.post("/Project/board/comment.do", {
			boardNo 		: $scope.board.boardNo,
			categoryNo		: $scope.board.categoryNo,
			menuNo			: $scope.mNo,
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
	
	$scope.replyDelete = function(replyNo){
		var ajax = $http.put("/Project/board/commentDelete.do", {
			boardNo 		: $scope.board.boardNo,
			categoryNo		: $scope.board.categoryNo,
			menuNo			: $scope.mNo,
			replyNo			: replyNo
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
	
	//자신이 쓴 글인지를 확인
	$scope.checkId = function(loginId){
		if($scope.board.memberId == loginId){
		return true;
		}
		else{
			return false;
		}
	}
	
	//추천
	$scope.recommand = function(loginId){
		var ajax = $http.post("/Project/board/boardRecommand.do",{
			boardNo 		   : $scope.board.boardNo,
			categoryNo		   : $scope.board.categoryNo,
			memberId		   : loginId
		});
		ajax.then(function(value){
			$scope.result = value.data;
			$scope.boardDetail();
			if($scope.result == 1){
				alert("좋아요는 한번만!");
			}
			
		}, function(reason){
			
		});
	}
	
});
	
