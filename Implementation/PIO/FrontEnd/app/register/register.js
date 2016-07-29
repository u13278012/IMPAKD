'use strict';

angular.module('myApp', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/register', {
    templateUrl: 'register/register.html',
    controller: 'RegisterCtrl'
  });
}])

.controller('RegisterCtrl', [function($scope) {
$scope.registerUser = function($http)
{
    $scope.profile = {
        firstname: document.getElementById("FirstName").value,
        lastname: document.getElementById("LastName").value,
        username: document.getElementById("UserName").value,
        email: document.getElementById("Email").value,
        password: document.getElementById("Password").value,
        contactDetails: document.getElementById("contacDetails").value
    };
        
        $http({
            method:"POST",
            url: 'http:localhost:8080/BackEndPIO/rs/profile',
            data: angular.toJson($scope.profile),
            header: {
                        'Content-Type': 'application/json'
            }
            });
    
};
}]);


