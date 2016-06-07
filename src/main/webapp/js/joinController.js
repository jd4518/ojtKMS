
var app = angular.module("projectApp", [ 'ngRoute' ]);

app.config(function($routeProvider) {
	$routeProvider.when("/join", {
		templeteUrl : "join.do",
		cotroller : "joinCtrl"
	}).otherwise({
		redirectTo : "/join"
	});
});

app.controller('joinCtrl', function($scope, $http, $location) {
	console.log("recommandListController...");
	$scope.name = "hihi";
	$scope.join = {};
	$scope.join.memberId = "hihi";
	// $scope.cl = function(){
	//		
	// alert("잘만되네?");
	// }
	//	
	//	
	//	
	// $scope.submit = function(){
	// var ajax = $http.post({
	// memberId : $scope.join.memberId,
	// memberEmail : $scope.join.memberEmail,
	// memberName : $scope.join.memberName,
	// memberPassword : $scope.join.memberPassword
	// });
	//		
	// ajax.then(function(value){
	// $location.path("main.do");
	// }, function(reason){
	// $scope.join = reason.data;
	// alert("에러");
	// });
	// }

});