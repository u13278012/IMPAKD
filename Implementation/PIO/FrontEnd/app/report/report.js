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
    controller: 'UpdatePropertyCtrl'
  });
}])

.controller('ReportCtrl', ["$scope", "$window", "$http", function($scope, $window, $http) {

           


}]);

