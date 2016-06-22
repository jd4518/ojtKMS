
app.config(function($routeProvider) {
	$routeProvider.when('/boardList/:CATEGORY_NO', {
		templateUrl : 'boardList.do',
		controller : 'boardListCtrl'
	});
});

app.controller('boardListCtrl',function($scope, $http, $routeParams){

	$scope.list={};
	$scope.pageNo=1;
	$scope.categoryNo = $routeParams.CATEGORY_NO;
	 
	$scope.selectPage = function(){
		var ajax = $http.get("/Project/board/boardGet/"+$routeParams.CATEGORY_NO+$scope.pageNo+"x.do",{
		});	//ajax를 이용하여 페이지 호출
		
		ajax.then(function(value) {			//ajax if문 표현 
			$scope.list = value.data;		//model에 binding이 자동으로 된다.
		}, function(reason) {
			console.dir(reason);
			alert("error...");
		});
		};
		
	
		$scope.selectPage();
		
	
		$scope.prevClick = function(pageNo) {
			console.log("prevClick()... pageNo = " + pageNo);
			$scope.pageNo = pageNo
			$scope.selectPage();
// 			alert("pageNo=" + pageNo);
		};
		
		$scope.pageClick = function(pageNo) {
			console.log("pageClick()... pageNo = " + pageNo);
			$scope.pageNo = pageNo
			$scope.selectPage();
// 			alert("pageNo=" + pageNo);
		};
		
		$scope.nextClick = function(pageNo) {
			console.log("nextClick()... pageNo = " + pageNo);
			$scope.pageNo = pageNo
			$scope.selectPage();
// 			alert("pageNo=" + pageNo);
		};
		
});