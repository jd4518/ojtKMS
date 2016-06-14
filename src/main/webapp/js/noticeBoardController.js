
app.config(function($routeProvider) {

		
		$routeProvider.when("/noticeBoardList", {
			templateUrl: "noticeBoard.do",
			controller: "noticeBoardListCtrl"
		});
});

app.controller('noticeBoardListCtrl',function($scope, $http){
	$scope.selectPage = function() {
		$http.get(URL.GET_PAGE_BASE + $scope.pageNo).success(function(data, status, headers, config) {
			console.dir(data);
			$scope.recommandLists = data.recommandLists;
			$scope.paging = data.paging;
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