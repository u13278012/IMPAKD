import Ember from 'ember';
import config from './config/environment';

const Router = Ember.Router.extend({
  location: config.locationType
});

Router.map(function() {
  this.route('login');
  this.route('addProperty');
  this.route('homePage');
  this.route('propertyDetails');
  this.route('mainPage');
  this.route('register');
});

export default Router;
