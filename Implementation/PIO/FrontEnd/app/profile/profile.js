'use strict';

angular.module('myApp', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/profile', {
    templateUrl: 'profile/profile.html',
    controller: 'ProfileCtrl'
  });
}])

.controller('ProfileCtrl',["$scope", "$window", "$http", function($scope, $window, $http ) {
        $scope.Prof;
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
                            $scope.Prof = $scope.results.profile;
                            
                            document.getElementById("pfirstName").value = $scope.results.profile.firstname;
                            document.getElementById("plastName").value  = $scope.results.profile.lastName;
                            document.getElementById("pemail").value  = $scope.results.profile.email;
                            document.getElementById("puserName").value  = $scope.results.profile.username;
                        }).
                        error(function(response)
                        {
//                            alert(response);             
                        });
                        
            }

        };
        
        $scope.update = function()
        {
            var session = localStorage.getItem("session");
            //check if not empty
            if(session === null)
            {
                alert('You are not logged in.');
                window.location = "../index.html";
            }
            
             $scope.firstName = document.getElementById("pfirstName").value;
            $scope.lastName = document.getElementById("plastName").value;
            $scope.UserName = document.getElementById("puserName").value;
            $scope.Email = document.getElementById("pemail").value;
            
            if(document.getElementById("pass").value === "" ||  document.getElementById("pcPassword").value === "")
            {
                $scope.Password = $scope.Prof.password;
                $scope.confrimPassword = $scope.Prof.password;
            }
            else
            {
                $scope.Password = document.getElementById("pass").value;
                $scope.confrimPassword = document.getElementById("pcPassword").value;
            }
            
            
            var encodedString = 
            'UserName='+
            encodeURIComponent($scope.UserName)+
            '&Email='+
            encodeURIComponent($scope.Email)+
            '&Password='+
            encodeURIComponent($scope.Password)+
            '&confrimPassword='+
            encodeURIComponent($scope.confrimPassword);
            '&firstName='+
            encodeURIComponent($scope.firstName);
            '&lastName='+
            encodeURIComponent($scope.lastName);
            '&profileID='+
            encodeURIComponent(session);

           
    
            $http({
                method: 'POST',
                url: 'http://localhost:8080/BackEnd/rs/profile/update/'+session+'/'+$scope.firstName+'/'+$scope.lastName+'/'+$scope.UserName+'/'+$scope.Email+'/'+$scope.Password+'/'+$scope.confrimPassword,
                data: encodedString,
                headers: {'Content-Type': 'application/x-www-form-urlencoded'}
            }).success(function(response) {
                    $scope.populate();
                    window.location.reload();
                }).
                error(function(response)
                {
                    $window.alert(response+" fail");
                });

        };
        
        $scope.cancel = function()
        {
          window.location.reload();  
        };
        
         $scope.back = function()
        {
           window.location = "../home/home.html"; 
        };

}]);

