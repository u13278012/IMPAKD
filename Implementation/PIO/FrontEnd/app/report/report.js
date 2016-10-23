/*'use strict';

angular.module('myApp.report', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/report', {
    templateUrl: 'report/report.html',
    controller: 'ReportCtrl'
  });
}])

.controller('ReportCtrl', [function() {

}]);*/


'use strict';


angular.module('myApp', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/report', {
    templateUrl: 'report/report.html',
    controller: 'ReportCtrl'
  });
}])

.controller('ReportCtrl', ["$scope", "$window", "$http", function($scope, $window, $http) {

   $scope.loadpdf = function() 
       {
            var session  = localStorage.getItem("session");
           // var propertyid  = el.id;
            var encodedString = 'profileID=' +
            encodeURIComponent(session);
            
 
          
          //20285
               $http({
                method: 'GET',
                url: 'http://localhost:8080/BackEnd/rs/tr/pdf',
                data:  $scope.encodedString,
                headers: {'Content-Type': 'application/x-www-form-urlencoded'}
            }).success(function(response) {
                  /* alert("good");
                    var file = new Blob([response]);
                    var fileURL = URL.createObjectURL(file);
                    $scope.content = response;*/
                }).
                error(function(response)
                {
                  
                     alert(response);
                                          

                });
            
       }


}]);

