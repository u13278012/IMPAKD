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
    double totalInterestForRent[];
    double arrayRentalAmount[];
    
    /**
     *
     * @param obj
     * @param objAmor
    */  
    public void declarationsR(Property obj, AmortizationTableBond objAmor){ 
        
        yearsToPayOffBond = 20;//objAmor.yearsToPayOffBond;
        occupancyRate = 1;//obj.getRental().getOccupancyRate()*12;
        agentCommission = 8.00/100.00;//obj.getRental().getAgentCommission();
        rentalAmount = 6700.00;//obj.getRental().getRentalAmount();
        onceOffAgentFee = 13.5/100.00;//obj.getRental().getOnceOffAgentFee()/100;

        totalRent = new double[yearsToPayOffBond+1];
        arrayRentalAmount = new double[yearsToPayOffBond+1];
        totalInterestForRent = new double[]{0.0, 0.0, 22.0, 58.00, 141.0, 182.0, 239.0, 345.0, 338.0, 575.0, 1079.0, 1676.0, 1982.0, 2069.0,2266.0,1109.0, 2118.0, 2759.0, 3004.0, 6829.0, 12083.0};
    }
    
    /**
     *
     * @param obj
     * @param objAmor
    */ 

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
                arrayRentalAmount[i] =  arrayRentalAmount[i-1] *(6.00/100.00) /*(obj.getIncreases().getRent()/100) */ + arrayRentalAmount[i-1];
            }
        }    
        
        //total rent for each year
        for(int i=1; i<yearsToPayOffBond+1; i++){
           totalRent[i] = Math.round(arrayRentalAmount[i]*(occupancyRate*12) + totalInterestForRent[i]);
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
