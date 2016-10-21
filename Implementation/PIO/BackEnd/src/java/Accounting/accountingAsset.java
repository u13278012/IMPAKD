/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Accounting;

import Entities.Property;
//import java.text.DecimalFormat;

/**
 *
 * @author Diana
 */
public class accountingAsset {
    //DecimalFormat df = new DecimalFormat(); 
    int yearsToPayOffBond = 0;  
    double propertyValue = 0.00;
    double propertyValueInc = 0.00;

    double fixedAsset[] = new double[yearsToPayOffBond+1];
    double capitalGains[] = new double[yearsToPayOffBond+1];
    double total[] = new double[yearsToPayOffBond+1];
    
    public static void main(String[] args) {
        
        //accountingAsset test = new accountingAsset();
        //getCapital(obj);
       // test.getCapitalGains(obj);
        //getTotal(obj);
    }
    /**
     *
     * @param obj
    */  
    public void declarationsAss(Property obj){ 
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
//        for(int i=0; i<yearsToPayOffBond+1;i++){
//            System.out.println(i + " " + fixedAsset[i]);
//        }        
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
                total[i] = Math.round(total[i-1] + capitalGains[i]);
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
//        for(int i=0; i<yearsToPayOffBond+1;i++){
//            System.out.println(i + " " + capitalGains[i]);
//        }        
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

