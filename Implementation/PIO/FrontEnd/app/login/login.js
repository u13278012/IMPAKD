'use strict';

angular.module('myApp', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/home', {
    templateUrl: 'login/login.html',
    controller: 'LoginCtrl'
  });
}])

.controller('LoginCtrl', ["$scope", "$window", "$http", function($scope, $window, $http){

$scope.validation = function()
{
    if($scope.loginUserName === "" || $scope.loginPassword === "")
    {
        alert("Please complete the entire form");
    }
    else
    {
        $scope.submitFunction();
    }
};

$scope.submitFunction = function() 
    {
            var encodedString = 'UserName=' +
            encodeURIComponent($scope.UserName) +
            '&Password='+
            encodeURIComponent($scope.Password);
       

            $http({
                method: 'POST',
                url: 'http://localhost:8080/BackEnd/rs/profile/login/'+$scope.loginUserName/+$scope.loginPassword,
               // data: encodedString,
                //headers: {'Content-Type': 'application/x-www-form-urlencoded'}
            }).success(function(response) {
                    window.location = "../home/home.html"; 

                }).
                error(function(response)
                {
                    $window.alert(response.status);
                });

        };

}]);