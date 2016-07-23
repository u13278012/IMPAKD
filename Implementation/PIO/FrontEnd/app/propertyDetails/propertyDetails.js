/*'use strict';

angular.module('myApp', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/propertyDetails', {
    templateUrl: 'propertyDetails/propertyDetails.html',
    controller: 'PropertyDetailsCtrl'
  });
}])

.controller('PropertyDetailsCtrl', [function() {

}]);*/


var app = angular.module('myApp', []);
app.controller('PropertyDetailsCtrl', function($scope) {
    $scope.firstName = "John";
    $scope.lastName = "Doe";
});