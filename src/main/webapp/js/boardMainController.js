
app.config(function ($routeProvider) {
	$routeProvider.when('/bMain',{
		templateUrl:'bMain.do',
		controller:'bMainCtrl'
	});
});

app.controller('boardMainCtrl', function($scope, $http, $location, $routeParams) {
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
	

	$scope.io=0;
	$scope.mOver = function(n){
		$scope.equalNum = function(item){
			return item==n;
		}
		$scope.io=n;
		if(n==1){
			a=true;
			b=false;
			c=false;
			$scope.n1=a;
			$scope.n2=b;
			$scope.n3=c;
		}else if(n==2){
			a=false;
			b=true;
			c=false;
			$scope.n1=a;
			$scope.n2=b;
			$scope.n3=c;
		}else if(n==3){
			a=false;
			b=false;
			c=true;
			$scope.n1=a;
			$scope.n2=b;
			$scope.n3=c;
		}else{
			a=false;
			b=false;
			c=false;
			$scope.n1=a;
			$scope.n2=b;
			$scope.n3=c;
		}
		
		$scope.mLeave = function(){
			a=false;
			b=false;
			c=false;
			$scope.n1=a;
			$scope.n2=b;
			$scope.n3=c;
		}
		
	}
	
	
	
});

