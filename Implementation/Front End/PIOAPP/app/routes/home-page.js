import Ember from 'ember';

export default  Ember.Route.extend({
	model(){
		let homeArray = [
			{
				number: "1",
				name: "3 Bedroom House",
				price: "R 1 995 000",
				ROI: "15%"
			
			},{
				number: "2",
				name: "1.5 Bedroom Apartment",
				price: "R 330 000",
				ROI: "5%"
			},{
				number: "3",
				name: "3 Bedroom Townhouse",
				price: "R 1 250 000",
				ROI: "20%"
			}			
		];
		return homeArray;
	},
	
	//Get Method
	homePropertyGet: function() {
  	return this.get(homeArray['number']) + ' ' + this.get(homeArray['name']) + ' ' + this.get(homeArray['price']) + ' ' + this.get(homeArray['ROI']);
	}.property(homeArray['number'], homeArray['name'], homeArray['price'] , homeArray['ROI'])
	
	/*//Set Method
	homePropertySet: function() {
  	return this.set(homeArray['number'],'4') + ' ' + this.set(homeArray['name'],'2 Bedroom House') + ' ' + this.set(homeArray['price'],'2000000') + ' ' + this.get(homeArray['ROI','25']);
	}	*/
});
