import { moduleFor, test } from 'ember-qunit';

moduleFor('route:home-page', 'Unit | Route | home page', {
  // Specify the other units that are required for this test.
  // needs: ['controller:foo']
});

test('it exists', function(assert) {
  let route = this.subject();
  assert.ok(route);
});

//Test Module
module('Unit: home');

test('calling homeProperty method to check values', function() {
  var homePropertyGet = App.home.create();
  equal(homePropertyGet());
});