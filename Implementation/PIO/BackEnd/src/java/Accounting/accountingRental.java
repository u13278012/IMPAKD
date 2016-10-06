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
    Property obj = new Property();
    
    final int yearsToPayOffBond = 20;//obj.getBond().getNumberOfYears();
    double occupancyRate = 1*12;//obj.getRental().getOccupancyRate()*12;
    double agentCommission = 8.00;//obj.getRental().getAgentCommission();
    double rentalAmount = 6700.00;//obj.getRental().getRentalAmount();
    double onceOffAgentFee = 15.37/100.00;//obj.getRental().getOnceOffAgentFee();
    double totalRent[] = new double[yearsToPayOffBond+1];
    double arrayRentalAmount[] = new double[yearsToPayOffBond+1];
    
    public static void main(String[] args) {
//        Property obj = new Property();
//        accountingRental objRent = new accountingRental();
//        objRent.getTotalRent(obj);
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
                arrayRentalAmount[i] =  arrayRentalAmount[i-1] * 6.00/100.00/*obj.getIncreases().getRent() */ + arrayRentalAmount[i-1];
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
