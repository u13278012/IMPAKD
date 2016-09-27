'use strict';
var ready = false;
var property;

angular.module('myApp', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/updateProperty', {
    templateUrl: 'updateProperty/updateProperty.html',
    controller: 'UpdatePropertyCtrl'
  });
}])

.controller('UpdatePropertyCtrl', ["$scope", "$window", "$http", function($scope, $window, $http) {

           
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
                   
                              alert(response);
                               window.location = "../home/home.html"; 

                }).
                error(function(response)
                {
                   // $window.alert("Server error..request not sent");
                     alert(response);
                                         // alert('loaded');

                });

        };
$scope.default = function()
{
            $scope.propertyresults;
          
            var session  = localStorage.getItem("session");
            var propertyid  = localStorage.getItem("property");
            var encodedString = 'profileID=' +
            encodeURIComponent(session)+
            '&propertyid=' +
            encodeURIComponent(propertyid);
            //51029
           alert(encodedString);
        
            $http({
                method: 'POST',
                url: 'http://localhost:51029/BackEnd/rs/property/getPropertyDetails',
                data: encodedString,
                headers: {'Content-Type': 'application/x-www-form-urlencoded'}
            }).success(function(response) {
                    var x2js = new X2JS();
                    var x = x2js.xml_str2json(response);
                    property = x;
                    ready = true;
                    console.log(x);
                     update($scope);



                }).
                error(function(response)
                {
                     alert(response);

                });

   
    //Property Details
   /* */
}

}]);

function update($scope)
{    
    if (!ready)
        setTimeout(function(){update($scope);}, 100);
    else
    {
           //Property Details
  
    $scope.propertyName = property.properties.property.propertyName;
    $scope.marketPriceAdjustment = property.properties.property.marketPriceAdjustment;
    $scope.capitalGains = property.properties.property.capitalGains;
    $scope.annualMaintenanceCost = 8;
    $scope.annualCostIncrease = 5;
    //bond
    $scope.interestRate = property.properties.property.bond.interestRate;
    $scope.deposit = property.properties.property.bond.depositInRands;
    $scope.propertyValue = property.properties.property.bond.propertyValue;
    $scope.numberOfYears = property.properties.property.bond.numberOfYears;
    $scope.bondRepaymnet = property.properties.property.bond.bondRepayment;
    //Additional Bond Repayment
    $scope.Period = property.properties.property.bond.Period;
    $scope.additionalCash = property.properties.property.bond.additionalCash;
    $scope.onceOffPayment = property.properties.property.bond.onceOffPayment;
    //Reserves
    $scope.maintenance = property.properties.property.reserves.maintenance;
    $scope.renovation = property.properties.property.reserves.renovation;
    $scope.deviance = property.properties.property.reserves.deviance;
    $scope.rentInsurance = property.properties.property.reserves.rentInsurance;
    //Conveyancing Fees
    $scope.conveyancingFees = property.properties.property.upFrontCosts.conveyancingFees;
    $scope.vatDebit = property.properties.property.upFrontCosts.vatDebit;
    $scope.deedsFee = property.properties.property.upFrontCosts.deedsFees;
    $scope.initiationFee = property.properties.property.upFrontCosts.initiationFee;
    //Expenses
    $scope.bondFee = property.properties.property.expenses.bondFee;
    $scope.rates_Taxes = property.properties.property.expenses.rates_Taxes;
    $scope.levy = property.properties.property.expenses.levy;
    //increases

    $scope.propertyValueIncrease =  property.properties.property.increases.propertyValue;
    $scope.rentIncrease =  property.properties.property.increases.rentIncrease;
    $scope.ratesAnstaxes =  property.properties.property.increases.rates_taxes;
    $scope.bondFeeIncrease =  property.properties.property.increases.bondFee;
    $scope.levyIncrease =  property.properties.property.increases.levy;
    $scope.rentIncrease =  property.properties.property.increases.rent;
    $scope.inflation =  property.properties.property.increases.inflation;

    //Rental Information
    $scope.occupancyRate =  property.properties.property.rental.occupancyRate;
    $scope.agentCommission =  property.properties.property.rental.agentCommission;
    $scope.rentalAmount =  property.properties.property.rental.rentalAmount;

    }
}

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