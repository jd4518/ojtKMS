

app.config(function ($routeProvider) {
	$routeProvider.when('/itBoardList',{
		templateUrl:'itBoardList.do',
		controller:'itListCtrl'
	});
});

app.controller('boardMainCtrl', function($scope, $http, $location) {
	$("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#wrapper").toggleClass("toggled");
    });
	
	
	
});