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
   /* $scope.propertyName = 9;
    $scope.marketPriceAdjustment = 6;
    $scope.capitalGains = 7;
    $scope.annualMaintenanceCost = 8;
    $scope.annualCostIncrease = 5;
    //bond
    $scope.interestRate = 7;
    $scope.deposit = 8;
    $scope.propertyValue = 0;
    $scope.numberOfYears = 0;
    $scope.bondRepaymnet = 0;
    //Additional Bond Repayment
    $scope.Period = 0;
    $scope.additionalCash = 0;
    $scope.onceOffPayment = 7;
    //Reserves
    $scope.maintenance = 6;
    $scope.renovation = 7;
    $scope.deviance = 8;
    $scope.rentInsurance = 5;
    //Conveyancing Fees
    $scope.conveyancingFees = 7;
    $scope.vatDebit = 8;
    $scope.deedsFee = 0;
    $scope.initiationFee = 0;
    //Expenses
    $scope.tax = 0;
    $scope.rates = 0;
    $scope.levy = 0;
    //increases
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
    //Rental Information
    $scope.occupancyRate = 0;
    $scope.agentCommission = 0;
    $scope.rentalAmount = 0;*/
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
    $scope.marketPriceAdjustment = 6;
    $scope.capitalGains = 7;
    $scope.annualMaintenanceCost = 8;
    $scope.annualCostIncrease = 5;

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