'use strict';

angular.module('myApp', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/register', {
    templateUrl: 'register/register.html',
    controller: 'RegisterCtrl'
  });
}])

.controller('RegisterCtrl', ["$scope", "$window", "$http", function($scope, $window, $http){
        
$scope.validation = function()
{
    if($scope.Email === "" || $scope.FirstName === "" || $scope.LastName === "" || $scope.UserName === "" || $scope.Password === "" || $scope.confrimPassword === "")
    {
        alert("Please complete the entire form");
    }
    else if($scope.Password !== $scope.confrimPassword)
    {
        alert("The passwords do not match");
    }
    else
    {
        $scope.submitFunction();
    }
};


$scope.submitFunction = function() 
    {
            var encodedString = 'FirstName=' +
            encodeURIComponent($scope.FirstName) +
            '&LastName=' +
            encodeURIComponent($scope.LastName) +
            '&UserName='+
            encodeURIComponent($scope.UserName)+
            '&Email='+
            encodeURIComponent($scope.Email)+
            '&Password='+
            encodeURIComponent($scope.Password)+
            '&confrimPassword='+
            encodeURIComponent($scope.confrimPassword);
       

            $http({
                method: 'POST',
                url: 'http://localhost:8080/BackEnd/rs/profile/register',
                data: encodedString,
                headers: {'Content-Type': 'application/x-www-form-urlencoded'}
            }).success(function(response) {
                    window.location = "../login/login.html"; 

                }).
                error(function(response)
                {
                    $window.alert(response.status);
                });

        };
}]);


