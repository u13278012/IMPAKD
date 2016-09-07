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
                        
        $http({
                method: 'GET',
                url: 'http://localhost:8080/BackEnd/rs/property/retrieveProperties/'+session
               // data: encodedString,
                //headers: {'Content-Type': 'application/x-www-form-urlencoded'}
            }).success(function(response) {
                    var x2js = new X2JS();
                    var x = x2js.xml_str2json(response);
                    $scope.results = x.properties;

                    
                    console.log($scope.results);
                       

                }).
                error(function(response)
                {
                    $window.alert(response);
                    
                                
                });
    }

};

$scope.goToPropertyDetails = function(el)
{

    localStorage.setItem("property", el.id);
    window.location = "../propertyDetails/propertyDetails.html";
}

}]);