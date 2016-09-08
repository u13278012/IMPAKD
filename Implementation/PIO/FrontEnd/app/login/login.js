'use strict';

angular.module('myApp', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/home', {
    templateUrl: 'login/login.html',
    controller: 'LoginCtrl'
  });
}])

.controller('LoginCtrl', ["$scope", "$window", "$http", function($scope, $window, $http ){

$scope.validation = function()
{
//    if($scope.loginEmail == undefined || $scope.loginPassword == undefined)
//    {
//        alert("Please fill in all fields");
//    }
//    else
//    {
        alert($scope.loginEmail+','+$scope.loginPassword);
        $scope.submitFunction();
//    }
};

$scope.submitFunction = function() 
    {
            var encodedString = 'loginEmail=' +
            encodeURIComponent($scope.loginEmail) +
            '&loginPassword='+
            encodeURIComponent($scope.loginPassword);
       
//51029
            $http({
                method: 'GET',
                url: 'http://localhost:51029/BackEnd/rs/profile/login/'+$scope.loginEmail+'/'+$scope.loginPassword
               // data: encodedString,
                //headers: {'Content-Type': 'application/x-www-form-urlencoded'}
            }).success(function(response) {
                    var x2js = new X2JS();
                    var x = x2js.xml_str2json(response);
                    $scope.a = x;

                    if (typeof(Storage) !== "undefined") {
                        // Store
                        localStorage.setItem("session", x.profile.id);
                        // Retrieve
                        var session = localStorage.getItem("session");
                    } else {
                        document.getElementById("result").innerHTML = "Sorry, your browser does not support Web Storage...";
                    }

                  window.location = "../home/home.html"; 
                       

                }).
                error(function(response)
                {
                    $window.alert('The username or password is incorrect.');
                    
                                
                });

        };

}]);