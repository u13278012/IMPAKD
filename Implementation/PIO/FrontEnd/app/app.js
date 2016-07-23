'use strict';

// Declare app level module which depends on views, and components
angular.module('myApp', [
  'ngRoute',
  'myApp.report',
  'myApp.home',
  'myApp.version'
]).
config(['$locationProvider', '$routeProvider', function($locationProvider, $routeProvider) {
//  $locationProvider.hashPrefix('main');
//
//  $routeProvider.otherwise({redirectTo: '/main'});
}]);
