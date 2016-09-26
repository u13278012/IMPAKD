'use strict';

angular.module('myApp', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/profile', {
    templateUrl: 'profile/profile.html',
    controller: 'ProfileCtrl'
  });
}])

.controller('ProfileCtrl',["$scope", "$window", "$http", function($scope, $window, $http ) {
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
             //51029
            else
            {
                $http({
                        method: 'GET',
                        url: 'http://localhost:8080/BackEnd/rs/profile/retrieveProfile/'+session
                       // data: encodedString,
                        //headers: {'Content-Type': 'application/x-www-form-urlencoded'}
                    }).success(function(response) {
                            var x2js = new X2JS();
                            var x = x2js.xml_str2json(response);
                            $scope.results = x;
                           
                            console.log(x);
                            document.getElementById("pfirstName").value = $scope.results.profile.firstname;
                            document.getElementById("plastName").value  = $scope.results.profile.lastName;
                            document.getElementById("pemail").value  = $scope.results.profile.email;
                            document.getElementById("puserName").value  = $scope.results.profile.username;
                        }).
                        error(function(response)
                        {
                            $window.alert(response);             
                        });
            }

        };

}]);

