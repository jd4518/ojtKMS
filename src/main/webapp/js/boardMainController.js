
app.config(function ($routeProvider) {
	$routeProvider.when('/itBoardList',{
		templateUrl:'itBoardList.do',
		controller:'itListCtrl'
	}).when('/bMain',{
		templateUrl:'bMain.do',
		controller:'bMainCtrl'
	});
});

app.controller('boardMainCtrl', function($scope, $http, $location) {
	$scope.menu={};
	
	$scope.selectMenu = function() {
		var ajax = $http.get("/Project/board/menu.do", {
		});
		ajax.then(function(value) {
			$scope.menu = value.data;
		}, function(reason) {
			$scope.join = reason.data;
			alert("error");
		});
	}
	
	
	$("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#wrapper").toggleClass("toggled");
        $scope.selectMenu();
    });
	var a =false;
	$scope.mOver = function(n){
		a = !a;
		var ajax = $http.get("/Project/board/category.do",{
		});
		
		ajax.then(function(value){
			$scope.category = value.data;
		},function(reason){
			alert("errrr");
		});
		
		if(a==true){
		$scope.no = false;
		}else{
			$scope.no = true;
		}
//		var ajax = $http.get("/Project/board/category.do"+menu.MENU_NO,{
//			
//		});
	}
	
	
	
});

