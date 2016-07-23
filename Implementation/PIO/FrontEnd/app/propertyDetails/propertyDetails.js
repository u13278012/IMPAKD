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
    $scope.model = {
			propertyName: 'City Properties',
			tax: '21%',
			inflation: '5.5%',
			anualMantainance: '6000.00',
                        anualCostIncrease: '10%',
				
                        interestRate: '10%',
			depositeASPercentage: '21%',
		        propertyValue: 'R500000.00',
                        numberOfYears: '30',
                
			 occupancyRate: '11%',
		         agentCommission: 'R 17000.00',
		         rentalAmount: '5000.00'
                
                
				};
});