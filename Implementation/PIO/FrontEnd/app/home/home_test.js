'use strict';

describe('myApp module', function() {

  beforeEach(module('myApp'));
  
  
  var $controller;

  beforeEach(inject(function(_$controller_){
    $controller = _$controller_;
  }));
  
   

  describe('HomeCtrl test', function() {
   var $scope, controller;

    beforeEach(function() {
      $scope = {};
	  
      controller = $controller('HomeCtrl', { $scope: $scope });
    });
  
   
   //it('should return 4',function() {
		 //s var controller = $controller('HomeCtrl', { $scope: $scope });
        // expect($scope.add()).toEqual("Hello");
		 
   // });
  
 
    });
});