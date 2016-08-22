'use strict';

angular.module('myApp', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/addProperty', {
    templateUrl: 'addProperty/addProperty.html',
    controller: 'AddPropertyCtrl'
  });
}])

.controller('AddPropertyCtrl', ["$scope", "$window", "$http", function($scope, $window, $http) {

    $scope.submitFunction = function() 
    {
            var encodedString = 'propertyName=' +
            encodeURIComponent($scope.propertyName) +
            '&marketPriceAdjustment=' +
            encodeURIComponent($scope.marketPriceAdjustment) +
            '&capitalGains=' +
            encodeURIComponent($scope.capitalGains) +
            '&annualMaintenanceCost=' +
            encodeURIComponent($scope.annualMaintenanceCost) +
            '&annualCostIncrease=' +
            encodeURIComponent($scope.annualCostIncrease) +
            '&interestRate=' +
            encodeURIComponent($scope.interestRate) +
            '&deposit=' +
            encodeURIComponent($scope.deposit) +
            '&propertyValue=' +
            encodeURIComponent($scope.propertyValue) +
            '&numberOfYears=' +
            encodeURIComponent($scope.numberOfYears) +
            '&bondRepaymnet=' +
            encodeURIComponent($scope.bondRepaymnet) +
            '&occupancyRate=' +
            encodeURIComponent($scope.occupancyRate) +
            '&agentCommission=' +
            encodeURIComponent($scope.agentCommission) +
            '&rentalAmount=' +
            encodeURIComponent($scope.rentalAmount) +
            '&maintenance=' +
            encodeURIComponent($scope.maintenance) +
            '&renovation=' +
            encodeURIComponent($scope.renovation) +
            '&deviance=' +
            encodeURIComponent($scope.deviance) +
            '&rentInsurance=' +
            encodeURIComponent($scope.rentInsurance) +
            '&conveyancingFees=' +
            encodeURIComponent($scope.conveyancingFees) +
            '&vatDebit=' +
            encodeURIComponent($scope.vatDebit) +
            '&deedsFee=' +
            encodeURIComponent($scope.deedsFee) +
            '&initiationFee=' +
            encodeURIComponent($scope.initiationFee) +
            '&tax=' +
            encodeURIComponent($scope.tax) +
            '&rates=' +
            encodeURIComponent($scope.rates) +
            '&levy=' +
            encodeURIComponent($scope.levy) +
            '&inflation=' +
            encodeURIComponent($scope.inflation) +
            '&propertyValueIncrease=' +
            encodeURIComponent($scope.propertyValueIncrease) +
            '&rentIncrease=' +
            encodeURIComponent($scope.rentIncrease) +
            '&ratesIncrease=' +
            encodeURIComponent($scope.ratesIncrease) +
            '&marketPriceAdjustment=' +
            encodeURIComponent($scope.marketPriceAdjustment)+
            '&marketPriceAdjustment=' +
            encodeURIComponent($scope.marketPriceAdjustment)+
            '&marketPriceAdjustment=' +
            encodeURIComponent($scope.marketPriceAdjustment)+
            '&marketPriceAdjustment=' +
            encodeURIComponent($scope.marketPriceAdjustment)+
            '&marketPriceAdjustment=' +
            encodeURIComponent($scope.marketPriceAdjustment)+
            '&marketPriceAdjustment=' +
            encodeURIComponent($scope.marketPriceAdjustment)+
            '&marketPriceAdjustment=' +
            encodeURIComponent($scope.marketPriceAdjustment);
       
            alert(encodedString);
            $http({
                method: 'POST',
                url: 'http://localhost:51029/BackEnd/rs/property/addProperty',
                data: encodedString,
                headers: {'Content-Type': 'application/x-www-form-urlencoded'}
            }).success(function(response) {
                   // window.location = "admin.html"; 
                              alert('ok');

                }).
                error(function(response)
                {
                   // $window.alert("Server error..request not sent");
                     alert(response);
                });

        };


}]);


