'use strict';

describe('myApp module', function() {

  beforeEach(module('myApp'));

  describe('addProperty controller', function(){

    it('should ....', inject(function($controller) {
      //spec body
      var addPropertyCtrl = $controller('AddPropertyCtrl');
      expect(addPropertyCtrl).toBeDefined();
    }));

  });
});
