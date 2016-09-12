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
     //51029
    else
    {
        $http({
                method: 'GET',
                url: 'http://localhost:51029/BackEnd/rs/property/retrieveProperties/'+session
               // data: encodedString,
                //headers: {'Content-Type': 'application/x-www-form-urlencoded'}
            }).success(function(response) {
                    var x2js = new X2JS();
                    var x = x2js.xml_str2json(response);
                    $scope.results = x.properties;
                    if ($scope.results.property instanceof Array == false)
                    {
                        $scope.results.property = [$scope.results.property];
                    }
                    console.log($scope.results);
                }).
                error(function(response)
                {
                    $window.alert(response);             
                });
    }

};

$scope.homeTodetails = function(el)
{
    localStorage.setItem("property", el.id)
    window.location = "../propertyDetails/propertyDetails.html";
}

 $scope.deleteProperty = function(el) 
    {
            var session  = localStorage.getItem("session");
            var propertyid  = el.id;
            var encodedString = 'profileID=' +
            encodeURIComponent(session)+
            '&propertyid=' +
            encodeURIComponent(propertyid);
 
            //51029
           
        
            $http({
                method: 'POST',
                url: 'http://localhost:51029/BackEnd/rs/property/deleteProperty',
                data: encodedString,
                headers: {'Content-Type': 'application/x-www-form-urlencoded'}
            }).success(function(response) {
                    var x2js = new X2JS();
                    var x = x2js.xml_str2json(response);
                    $scope.propertyresults = x;
                     window.location = "../home/home.html"; 

                   

                }).
                error(function(response)
                {
                     alert(response);

                });

        };
   


$scope.logout = function()
{
    localStorage.clear();
    window.location = "../index.html";
}
 $scope.updatePage= function(el)
{
     window.location = "../updateProperty/updateProperty.html";
}
}]);