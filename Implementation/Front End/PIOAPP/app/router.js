import Ember from 'ember';
import config from './config/environment';

const Router = Ember.Router.extend({
  location: config.locationType
});

Router.map(function() {
  this.route('registerLogin');
  this.route('addProperty');
  this.route('homePage');
});

export default Router;
