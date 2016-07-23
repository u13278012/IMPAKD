/* jshint ignore:start */
import Ember from 'ember';

export default Ember.Route.extend({
        	model(){
		let myArray = [
			{
				propertyName: "City Properties",
				tax: "21%",
				inflation: "5.5%",
			    anualMantainance: "6000.00",
                anualCostIncrease: "10%",
				
                interestRate: "10%",
			    depositeASPercentage: "21%",
				propertyValue: "R500000.00",
                 numberOfYears: "30",
                
			    occupancyRate: "11%",
				agentCommission: "R 17000.00",
				rentalAmount: "5000.00",
                
                
			}			
		];
		return myArray;
	}
    
  
});
/* jshint ignore:end */