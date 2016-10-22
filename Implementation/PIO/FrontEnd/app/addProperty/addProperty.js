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
            $scope.session  = localStorage.getItem("session");
            
            if (typeof(Storage) === "undefined") {
            alert("You're not logged in");
//            	    localStorage.setItem("session", 1);

            window.location = "../login/login.html";     
            }
  

            $scope.encodedString = 'propertyName=' +
            encodeURIComponent($scope.propertyName) +//
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
            '&bondFee=' +
            encodeURIComponent($scope.bondFee) +
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
            encodeURIComponent($scope.session);
            //51029
            $scope.addedProperty = true;
            if(isNaN($scope.marketPriceAdjustment) || isNaN($scope.capitalGains) || isNaN($scope.annualMaintenanceCost)
              || isNaN($scope.annualCostIncrease)||isNaN($scope.interestRate) || isNaN($scope.deposit)
              || isNaN($scope.propertyValue) || isNaN($scope.numberOfYears) || isNaN($scope.bondRepaymnet)
              || isNaN($scope.Period) || isNaN($scope.additionalCash) || isNaN($scope.onceOffPayment)
              || isNaN($scope.maintenance) || isNaN($scope.renovation) || isNaN($scope.deviance)
              || isNaN($scope.rentInsurance) || isNaN($scope.conveyancingFees) || isNaN($scope.vatDebit)
              ||isNaN($scope.deedsFee) || isNaN($scope.initiationFee) || isNaN($scope.tax)
              || isNaN($scope.rates) || isNaN($scope.levy) || isNaN($scope.bondFee)
              || isNaN($scope.inflation) || isNaN($scope.propertyValueIncrease) || isNaN($scope.rentIncrease)
              || isNaN($scope.ratesIncrease) || isNaN($scope.taxIncrease) || isNaN($scope.bondFeeIncrease)
              || isNaN($scope.levyIncrease) || isNaN($scope.occupancyRate) || isNaN($scope.agentCommission)
              || isNaN($scope.rentalAmount)){
              alert("error ...wrong input");

                 }
            else{ //20285
               
           $http({
                method: 'POST',
                url: 'http://localhost:8080/BackEnd/rs/property/addProperty',
                data:  $scope.encodedString,
                headers: {'Content-Type': 'application/x-www-form-urlencoded'}
            }).success(function(response) {
                   
                               $scope.addedProperty = true;
                              window.location = "../home/home.html"; 

                }).
                error(function(response)
                {
                   // $window.alert("Server error..request not sent");
                     $scope.addedProperty = true;

                     alert(response);
                                         // alert('loaded');

                });
            }

        };
$scope.Default = function()
{
    $scope.inflation = 7;
    $scope.rentIncrease = 6;
    $scope.bondFeeIncrease = 7;
    $scope.levyIncrease = 8;
    $scope.propertyValueIncrease = 5;
    $scope.bondFeeIncrease = 7;
    $scope.taxIncrease = 8;
    
    
    $scope.ratesIncrease = 0;
    $scope.rates = 0;
    $scope.Period = 0;
    $scope.additionalCash = 0;
    $scope.onceOffPayment = 0;
}

}]);


function grow(id)
{
    var div = document.getElementById(id);
    
    if (div.className === "tile open")
    {
        div.style.height = "75px";
        div.className = "tile closed";
    }
    else
    {
        div.style.height = 100 + (div.children.length * 50) + "px";
        div.className = "tile open";
    }
}