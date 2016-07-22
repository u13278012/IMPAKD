'use strict';

angular.module('myApp.addProperty', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/addProperty', {
    templateUrl: 'addProperty/addProperty.html',
    controller: 'AddPropertyCtrl'
  });
}])

.controller('AddPropertyCtrl', [function() {

}]);


