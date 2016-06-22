
var app = angular.module('projectApp', ['ngRoute','ui.bootstrap','ngTouch']);

app.config(function ($routeProvider) {
	$routeProvider
	.otherwise({
		redirectTo : '/join'
	});
});

app.controller('mainCtrl', function($scope, $http, $location) {
	
	
});