
app.config(function($routeProvider) {
	$routeProvider.when('/memberList' , {
		templateUrl : 'memberList.do',
		controller : 'memberListCtrl'
	});
});

app.controller('memberListCtrl',function($scope, $http, $routeParams){

	$scope.list={};
	$scope.pageNo=1;

	 
	$scope.selectPage = function(){
		var ajax = $http.get("/Project/admin/memberGet/"+$scope.pageNo+"x.do",{
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
		
		$scope.memberDelete = function(memberId){
			if(confirm("탈퇴 시키시겠습니까?")){
			var ajax = $http.put("/Project/admin/memberDelete.do",{
				memberId : memberId
			});
			ajax.then(function(value){
				alert("성공");
				$scope.selectPage();
			}, function(reason){
				
			});
			}else{
				
			}
			
		}
		$scope.memberUpgrade = function(memberId){
			if(confirm("매니저로 임명 하시겠습니까?")){
			var ajax = $http.put("/Project/admin/memberUpgrade.do",{
				memberId : memberId
			});
			ajax.then(function(value){
				alert("성공");
				$scope.selectPage();
			}, function(reason){
				
			});
			}else{
				
			}
		}
		$scope.memberDowngrade = function(memberId){
			if(confirm("강등 시키시겠습니까?")){
			var ajax = $http.put("/Project/admin/memberDowngrade.do",{
				memberId : memberId
			});
			ajax.then(function(value){
				alert("성공");
				$scope.selectPage();
			}, function(reason){
				
			});
			}else{
				
			}
		}
});