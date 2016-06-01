/**
 * @author java
 */

var app = angular.module('projectApp',['ngRoute']);





 	app.config(['$routeProvider'],function($routeProvider) {
		console.log("/insert config...")
		
		$routeProvider.when('/join', {				
			templateUrl: "join.do",				
			controller: "mainCtrl"			
		});
		
		
	});

app.controller("mainCtrl", function($scope, $http, $location) {
	
	$scope.name="hi";

});