/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Accounting;

import Entities.Property;
import java.lang.reflect.Array;
//import java.text.DecimalFormat;

/**
 *
 * @author Diana
 */
public class accountingAsset {
    //DecimalFormat df = new DecimalFormat();
    accountingIncomeStatement objIS = new accountingIncomeStatement();
    AmortizationTableBond objAmor = new AmortizationTableBond() ;
    accountingRental objR = new accountingRental();
    ReservesCalculations objRe = new ReservesCalculations() ;
    
    int yearsToPayOffBond = 0;  
    double propertyValue = 0.00;
    double propertyValueInc = 0.00;

    double fixedAsset[];
    double capitalGains[];
    double total[];
    
    public static void main(String[] args) {
        accountingAsset test = new accountingAsset();
        Property obj = new Property();
        test.getTotal(obj);
    }
    /**
     *
     * @param obj
     * @param objIS
    */  
    public void declarationsAss(accountingIncomeStatement objIS){ 
        this.objIS = objIS;
        yearsToPayOffBond = 20;//obj.getBond().getNumberOfYears();  
        propertyValue = 799000;//obj.getBond().getPropertyValue();
        propertyValueInc = 5/100.00;//obj.getInceases().getPropertyValue()/100.0;

        fixedAsset = new double[yearsToPayOffBond+1];
        capitalGains = new double[yearsToPayOffBond+1];
        total = new double[yearsToPayOffBond+1];
    }
     /**
     *
     * @param obj
    */
    public void setCapital(Property obj){
        declarationsAss(objIS);
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
        declarationsAss(objIS);
       // objIS.declarationsInc(obj, objAmor, objR, objRe);
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
       //df.setMaximumFractionDigits(9);
//        for(int i=0; i<yearsToPayOffBond+1;i++){
//            System.out.println(i + " " + /*df.format(*/total[i]);
//        }        
        return total;
    }
    
}

