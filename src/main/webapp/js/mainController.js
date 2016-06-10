
var app = angular.module('projectApp', ['ngRoute'])

app.config(function ($routeProvider) {
	$routeProvider
	.otherwise({
		redirectTo : '/join'
	});
});

app.controller('mainCtrl', function($scope, $http, $location) {
	
	
});