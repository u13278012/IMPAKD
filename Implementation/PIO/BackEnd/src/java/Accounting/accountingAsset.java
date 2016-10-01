/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Accounting;

import Entities.Property;
import java.text.DecimalFormat;

/**
 *
 * @author Diana
 */
public class accountingAsset {
    static DecimalFormat df = new DecimalFormat();
    static final int yearsToPayOffBond = 20;//bond.getNumberOfYears();  
    static double propertyValue = 799000;//obj.getBond().getPropertyValue();
    static double propertyValueInc = 0.05; //obj.getInceases().getPropertyValue();
    
    static double fixedAsset[] = new double[yearsToPayOffBond];
    static double capitalGains[] = new double[yearsToPayOffBond];
    static double total[] = new double[yearsToPayOffBond];
    
    public static void main(String[] args) {
        //Property obj = new Property();
        //getCapital(obj);
        //getCapitalGains(obj);
        //getTotal(obj);
    }
    
     /**
     *
     * @param obj
    */
    public static void setCapital(Property obj){
        for(int i=0; i<yearsToPayOffBond; i++){
            fixedAsset[i] = propertyValue;
        }   
    }
    
    /**
     *
     * @param obj
     * @return
     */
    public static double[] getCapital(Property obj){
        setCapital(obj);
//        for(int i=0; i<yearsToPayOffBond;i++){
//            System.out.println(i + " " + fixedAsset[i]);
//        }        
        return fixedAsset;
    }
    
     /**
     *
     * @param obj
    */
    public static void setAssset(Property obj){
        for(int i=0; i<yearsToPayOffBond; i++){
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
    public static double[] getCapitalGains(Property obj){
        setAssset(obj);
        for(int i=0; i<yearsToPayOffBond;i++){
            System.out.println(i + " " + capitalGains[i]);
        }        
        return capitalGains;
    }
    
    /**
     *
     * @param obj
     * @return
     */
    public static double[] getTotal(Property obj){
        setAssset(obj);       
       //df.setMaximumFractionDigits(9);
        for(int i=0; i<yearsToPayOffBond;i++){
            System.out.println(i + " " + /*df.format(*/total[i]);
        }        
        return total;
    }
    
}

