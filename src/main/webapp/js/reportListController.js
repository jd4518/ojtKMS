
app.config(function($routeProvider) {
	$routeProvider.when('/reportList' , {
		templateUrl : 'reportList.do',
		controller : 'reportListCtrl'
	});
});

app.controller('reportListCtrl',function($scope, $http, $routeParams){

	$scope.list={};
	$scope.pageNo=1;

	 
	$scope.selectPage = function(){
		var ajax = $http.get("/Project/admin/reportGet/"+$scope.pageNo+"x.do",{
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
		
		$scope.memberWarning = function(memberId){
			if(confirm("경고를 주시겠습니까???")){
			var ajax = $http.put("/Project/admin/memberWarning.do",{
				memberId : memberId
			});
			ajax.then(function(value){
				
			}, function(reason){
				
			});
			}
        }
        $scope.memberStop = function(memberId){
        	if(confirm("정지를 하시겠습니까???")){
        	var ajax = $http.put("/Project/admin/memberStop.do",{
				memberId : memberId
			});
			ajax.then(function(value){
				
			}, function(reason){
				
			});
        	}
        }
		$scope.memberSave = function(memberId){
			if(confirm("용서  하시겠습니까???")){
			var ajax = $http.put("/Project/admin/memberSave.do",{
				memberId : memberId
			});
			ajax.then(function(value){
				
			}, function(reason){
				
			});
			}
		}
});