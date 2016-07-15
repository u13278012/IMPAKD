import Ember from 'ember';

export default Ember.Route.extend({
	model(){
		let homeArray = [
			{
				name: "3 Bedroom House",
				price: "R 1 995 000",
				ROI: "15%"
			
			},{
				name: "1.5 Bedroom Apartment",
				price: "R 330 000",
				ROI: "5%"
			},{
				name: "3 Bedroom Townhouse",
				price: "R 1 250 000",
				ROI: "20%"
			}			
		];
		return homeArray;
	}
});
