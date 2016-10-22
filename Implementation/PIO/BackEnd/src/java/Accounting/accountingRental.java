/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Accounting;
import Entities.Property;
/**
 *
 * @author Diana
 */
public class accountingRental {  
    int yearsToPayOffBond = 0;
    double occupancyRate = 0.00;
    double agentCommission = 0.00;
    double rentalAmount = 0.00;
    double onceOffAgentFee = 0.00;
    
    double totalRent[];
    double arrayRentalAmount[];
    
    public static void main(String[] args) {
//        Property obj = new Property();
//        accountingRental objRent = new accountingRental();
//        objRent.getTotalRent(obj);
    }
    
    /**
     *
     * @param obj
     * @param objAmor
    */  
    public void declarationsR(Property obj, AmortizationTableBond objAmor){ 
        
        yearsToPayOffBond = objAmor.yearsToPayOffBond;
        occupancyRate = obj.getRental().getOccupancyRate()*12;
        agentCommission = obj.getRental().getAgentCommission();
        rentalAmount = obj.getRental().getRentalAmount();
        onceOffAgentFee = obj.getRental().getOnceOffAgentFee()/100;

        totalRent = new double[yearsToPayOffBond+1];
        arrayRentalAmount = new double[yearsToPayOffBond+1];
    }
    
    /**
     *
     * @param obj
    */ 
    public  void setTotalRent(Property obj){
        for(int i=1; i< yearsToPayOffBond+1; i++){
            if( i == 1){
                arrayRentalAmount[i] = rentalAmount; 
            }
            else{
                arrayRentalAmount[i] =  arrayRentalAmount[i-1] * (obj.getIncreases().getRent()/100) + arrayRentalAmount[i-1];
            }
        }    
        
        //total rent for each year
        for(int i=1; i<yearsToPayOffBond+1; i++){
           totalRent[i] = Math.round(arrayRentalAmount[i] * occupancyRate);
        }  
    }
    /**
     *
     * @param obj
     * @return
     */
    public  double[] getTotalRent(Property obj){
        setTotalRent(obj);
//        for(int i=0; i< yearsToPayOffBond+1; i++){
//             System.out.println(i + " " + totalRent[i]);
//        }
        return totalRent;
    }
    
}
