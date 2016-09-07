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
            var session  = localStorage.getItem("session");
            if (typeof(Storage) === "undefined") {
            alert("You're not logged in");
            window.location = "../login/login.html";     
            }
        
            var encodedString = 'propertyName=' +
            encodeURIComponent($scope.propertyName) +
            '&marketPriceAdjustment=' +
            encodeURIComponent($scope.marketPriceAdjustment) +
            '&capitalGains=' +
            encodeURIComponent($scope.capitalGains) +
            '&annualMaintenanceCost=' +
            encodeURIComponent($scope.annualMaintenanceCost) +
            '&annualCostIncrease=' +
            encodeURIComponent($scope.annualCostIncrease)+
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
            '&Period=' +
            encodeURIComponent($scope.Period) +
            '&additionalCash=' +
            encodeURIComponent($scope.additionalCash) +
            '&onceOffPayment=' +
            encodeURIComponent($scope.onceOffPayment) +
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
            '&managementFee=' +
            encodeURIComponent($scope.managementFee) +
            '&inflation=' +
            encodeURIComponent($scope.inflation) +
            '&propertyValueIncrease=' +
            encodeURIComponent($scope.propertyValueIncrease) +
            '&rentIncrease=' +
            encodeURIComponent($scope.rentIncrease) +
            '&ratesIncrease=' +
            encodeURIComponent($scope.ratesIncrease) +
            '&taxIncrease=' +
            encodeURIComponent($scope.taxIncrease)+
            '&bondFeeIncrease=' +
            encodeURIComponent($scope.bondFeeIncrease)+
            '&levyIncrease=' +
            encodeURIComponent($scope.levyIncrease)+
            '&occupancyRate=' +
            encodeURIComponent($scope.occupancyRate)+
            '&agentCommission=' +
            encodeURIComponent($scope.agentCommission)+
            '&rentalAmount=' +
            encodeURIComponent($scope.rentalAmount)+
            '&profileID=' +
            encodeURIComponent(session);
            //51029
            alert(encodedString);
            $http({
                method: 'POST',
                url: 'http://localhost:51029/BackEnd/rs/property/addProperty',
                data: encodedString,
                headers: {'Content-Type': 'application/x-www-form-urlencoded'}
            }).success(function(response) {
                   // window.location = "admin.html"; 
                              alert(response);

                }).
                error(function(response)
                {
                   // $window.alert("Server error..request not sent");
                     alert(response);
                                         // alert('loaded');

                });

        };


}]);


