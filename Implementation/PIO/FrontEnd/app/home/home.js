'use strict';

angular.module('myApp', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/home', {
    templateUrl: 'home/home.html',
    controller: 'HomeCtrl'
  });
}])

.controller('HomeCtrl',["$scope", "$window", "$http", function($scope, $window, $http ) {
$scope.populate = function()
{
    //get sesion
    var session = localStorage.getItem("session");
    //check if not empty
    if(session === null)
    {
        alert('You are not logged in.');
        window.location = "../index.html";
    }
    else
    {
        
    }

};

}]);