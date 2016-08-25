'use strict';

var app = angular.module('myApp', ['ngRoute']);

app.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/login', {
    templateUrl: 'login/login.html',
    controller: 'LoginCtrl'
  });
}]);



app.controller('login',['$Scope', '$http','X2JS', function($Scope, $http, X2JS) {
    $Scope.username = document.getElementById('UserName').value;
    $Scope.password = document.getElementById('Password').value;
    
    $http.get("http://localhost:8080/BackEnd/rs/profile/login/"+$Scope.username+"/"+$Scope.password)
    .success(function(data) {
        var x2js = new X2JS(); 
        var json = x2js.xml_str2json( data );
        $Scope.newProfile = json;
    });
}]);


