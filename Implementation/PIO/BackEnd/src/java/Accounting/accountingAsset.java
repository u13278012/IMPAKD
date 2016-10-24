package Accounting;

import Entities.Property;
import java.lang.reflect.Array;

/**
 *
 * @author Diana
 */
public class accountingAsset {
    accountingIncomeStatement objIS = new accountingIncomeStatement(); 
    int yearsToPayOffBond = 0;  
    double propertyValue = 0.00;
    double propertyValueInc = 0.00;

    double fixedAsset[];
    double capitalGains[];
    double total[];

    /**
     *
     * @param obj
     * @param objIS
    */  
    public void declarationsAss(Property obj,accountingIncomeStatement objIS, AmortizationTableBond objAmor, ReservesCalculations objRe,accountingRental objR){ 
        objIS.declarationsInc(obj, objAmor, objRe,objR);
        this.objIS = objIS;
        yearsToPayOffBond = obj.getBond().getNumberOfYears();  
        propertyValue = obj.getBond().getPropertyValue();
        propertyValueInc = obj.getInceases().getPropertyValue()/100.0;

        fixedAsset = new double[yearsToPayOffBond+1];
        capitalGains = new double[yearsToPayOffBond+1];
        total = new double[yearsToPayOffBond+1];
    }
    /**
     *
     * @param obj
    */
    public void setCapital(Property obj){
        for(int i=0; i<yearsToPayOffBond+1; i++){
            fixedAsset[i] = propertyValue;
        }   
    }
    
    /**
     *
     * @param obj
     * @return
     */
    public double[] getCapital(Property obj){
        setCapital(obj);       
        return fixedAsset;
    }
    
     /**
     *
     * @param obj
    */
    public void setAssset(Property obj){
        for(int i=0; i<yearsToPayOffBond+1; i++){
            if(i==0){
                capitalGains[i] = 0.00;
                total[i] = Math.round(propertyValue);
            }
            else{
                capitalGains[i] = Math.round(capitalGains[i-1] + (total[i-1]*propertyValueInc));
                total[i] = Math.round(total[i-1] + capitalGains[i] + Array.getDouble(objIS.getCashPerYear(obj),i));
            }
        }   
    }
    
    /**
     *
     * @param obj
     * @return
     */
    public double[] getCapitalGains(Property obj){
        setAssset(obj);       
        return capitalGains;
    }
    
    /**
     *
     * @param obj
     * @return
     */
    public double[] getTotal(Property obj){
        setAssset(obj);             
        return total;
    }   
}

