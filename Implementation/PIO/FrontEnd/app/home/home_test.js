'use strict';

describe('myApp module', function() {

  beforeEach(module('myApp'));

  describe('home controller', function(){

    it('should ....', inject(function($controller) {
      //spec body
      var homeCtrl = $controller('HomeCtrl');
      expect(homeCtrl).toBeDefined();
    }));

  });
});