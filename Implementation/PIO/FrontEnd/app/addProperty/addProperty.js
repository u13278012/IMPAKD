'use strict';

angular.module('myApp', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/addProperty', {
    templateUrl: 'addProperty/addProperty.html',
    controller: 'AddPropertyCtrl'
  });
}])

.controller('AddPropertyCtrl', ["$scope", "$window", "$http", function($scope, $window, $http) {

    $scope.submitFunction = function() 
    {
            var encodedString = 'username=' +
            encodeURIComponent($scope.userName) +
            '&password=' +
            encodeURIComponent($scope.password);
       
            alert(encodedString);
            $http({
                method: 'POST',
                url: 'http://localhost:51029/BackEnd/rs/property/addProperty',
                data: encodedString,
                headers: {'Content-Type': 'application/x-www-form-urlencoded'}
            }).success(function(response) {
                   // window.location = "admin.html"; 
                              alert('ok');

                }).
                error(function(response)
                {
                   // $window.alert("Server error..request not sent");
                     alert(response);
                });

        };


}]);


