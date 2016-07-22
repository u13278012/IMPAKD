'use strict';

angular.module('myApp.propertyDetails', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/propertyDetails', {
    templateUrl: 'propertyDetails/propertyDetails.html',
    controller: 'PropertyDetailsCtrl'
  });
}])

.controller('PropertyDetailsCtrl', [function() {

}]);


