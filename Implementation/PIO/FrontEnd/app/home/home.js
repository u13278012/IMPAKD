'use strict';

angular.module('myApp', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/home', {
    templateUrl: 'home/home.html',
    controller: 'HomeCtrl'
  });
}])

.controller('HomeCtrl', [function() {
//        $scope.propertyDetails = [
//            {
//                number: '1',
//                name: '3 Bedroom House',
//                price: 'R 1 995 000',
//                ROI: '15%'
//
//            },{
//                number: '2',
//                name: '1.5 Bedroom Apartment',
//                price: 'R 330 000',
//                ROI: '5%'
//            },{
//                number: '3',
//                name: '3 Bedroom Townhouse',
//                price: 'R 1 250 000',
//                ROI: '20%'
//            }	
//        ];
}]);