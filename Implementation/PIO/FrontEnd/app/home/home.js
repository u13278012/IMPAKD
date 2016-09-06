'use strict';

angular.module('myApp', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/home', {
    templateUrl: 'home/home.html',
    controller: 'HomeCtrl'
  });
}])

.controller('HomeCtrl',["$scope", "$window", "$http", function($scope, $window, $http ) {
//$scope.init = function(){
// //your code
//                   alert('works');
//    populate();
//};
//
//$timeout($scope.init);      
//
//$scope.$on('$viewContentLoaded', function() 
//{
//                    alert('works');
//    populate();
//});


 $scope.populate = function()
{
    alert('yess00');
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
                        alert(session);
        $http({
                method: 'GET',
                url: 'http://localhost:8080/BackEnd/rs/property/retrieveProperties/'+session
               // data: encodedString,
                //headers: {'Content-Type': 'application/x-www-form-urlencoded'}
            }).success(function(response) {
                    var x2js = new X2JS();
                    var x = x2js.xml_str2json(response);
                    $scope.a = x;

                    console.log(x)
                       

                }).
                error(function(response)
                {
                    $window.alert('Failed to load properties.');
                    
                                
                });
    }

};

}]);