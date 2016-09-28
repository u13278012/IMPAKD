describe('myApp module', function() {

  beforeEach(module('myApp'));
  
  
  var $controller;
  
  beforeEach(inject(function(_$controller_){
    $controller = _$controller_;
  }));
  
   

  describe('add property', function() {
   var $scope, controller ;
    var $httpBackend, authRequestHandler;
    beforeEach(function() {
      $scope = {};
       
      controller = $controller('AddPropertyCtrl', { $scope: $scope});

	    localStorage.setItem("session", 1);
            $scope.propertyName = "City";
            $scope.marketPriceAdjustment = 23232;
            $scope.capitalGains = 2323;
            $scope.annualMaintenanceCost = 2323;
            $scope.annualCostIncrease = 5656;
            $scope.interestRate =545;
            $scope.deposit = 6565;
            $scope.propertyValue = 45454;
            $scope.numberOfYears = 45545;
            $scope.bondRepaymnet = 67867;
            $scope.Period = 67677;
            $scope.additionalCash = 76767;
            $scope.onceOffPayment = 87787;
            $scope.maintenance = 565656;
            $scope.renovation = 4646;
            $scope.deviance = 454545;
            $scope.rentInsurance = 46546;
            $scope.conveyancingFees = 6565;
            $scope.vatDebit = 56565;
            $scope.deedsFee = 65656;
            $scope.initiationFee = 76765;
            $scope.tax = 7877;
            $scope.rates =66565;
            $scope.levy =5656;
            $scope.managementFee =667;
            $scope.inflation =34343;
            $scope.propertyValueIncrease =87665;
            $scope.rentIncrease =54545;
            $scope.ratesIncrease = 9887;
            $scope.taxIncrease = 54545;
            $scope.bondFeeIncrease = 98989;
            $scope.levyIncrease =76767;
            $scope.occupancyRate =54545;
            $scope.agentCommission =45454;
            $scope.rentalAmount =7788;
            

    });
  
   
   it('should return true when Property is added...',function() {
             $scope.submitFunction();
	     expect($scope.addedProperty).toBe(true);	 
    });
      
  it('session to be undefined before the submit function call...',function() {
            expect($scope.session).toBeUndefined();
            $scope.submitFunction();
        	 
    });  
  
  
    it('session to be 1 after the sumbit function call...',function() {
            $scope.submitFunction();
            expect($scope.session).toBe('1');	 
    });
   
   
     it('expected encode string with parameters should match the provided',function() {
            $scope.submitFunction();
            expect($scope.encodedString).toBe('propertyName=City&marketPriceAdjustment=23232&capitalGains=2323&annualMaintenanceCost=2323&annualCostIncrease=5656&interestRate=545&deposit=6565&propertyValue=45454&numberOfYears=45545&bondRepaymnet=67867&Period=67677&additionalCash=76767&onceOffPayment=87787&maintenance=565656&renovation=4646&deviance=454545&rentInsurance=46546&conveyancingFees=6565&vatDebit=56565&deedsFee=65656&initiationFee=76765&tax=7877&rates=66565&levy=5656&managementFee=667&inflation=34343&propertyValueIncrease=87665&rentIncrease=54545&ratesIncrease=9887&taxIncrease=54545&bondFeeIncrease=98989&levyIncrease=76767&occupancyRate=54545&agentCommission=45454&rentalAmount=7788&profileID=1');

    });
   
    it('encoded string to Back End undefined...',function() {
           expect($scope.encodedString).toBeUndefined();
           $scope.submitFunction();
  
    });
   
    it('Data send to Back End is defined...',function() {
           $scope.submitFunction();
           expect($scope.encodedString).toBeDefined();
  
    });
      
    });
});