/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Accounting;
import Entities.Property;
import java.lang.reflect.Array;

/**
 *
 * @author Diana
 */
public class accountingLiabilities {
    accountingAsset objAsset = new accountingAsset();          
    AmortizationTableBond objAmor = new AmortizationTableBond(); 
    accountingIncomeStatement objIS = new accountingIncomeStatement();
    accountingAsset objA= new accountingAsset();
    
    int yearsToPayOffBond = 0;
    double bondPrincipleDebt[];
    double arrayEquity[];
    double retainedEarnings[];
    double roi[];
    
    public static void main(String[] args) {
        accountingLiabilities test = new accountingLiabilities();
        Property obj = new Property();
       //test.getRetainedEarnings(obj);
        test.getRoi(obj);
    }
    /**
     *
     * @param obj
     * @param objAmor
     * @param objAsset
    */
    public void declarationsEx(Property obj, AmortizationTableBond objAmor,accountingAsset objAsset){ 
            objAmor.declarationsAM();
        objAsset.declarationsAss(objIS);
        this.objAmor = objAmor;
        this.objAsset = objAsset;
    
        yearsToPayOffBond = 20;//obj.getBond().getNumberOfYears();
        bondPrincipleDebt = new double[yearsToPayOffBond+1];
        arrayEquity = new double[yearsToPayOffBond+1];
        retainedEarnings = new double[yearsToPayOffBond+1];
        roi = new double[yearsToPayOffBond+1];
    }
    /**
     *
     * @param obj
    */
    public  void setEndingBalancePerYear(Property obj){
        int k=1;
        int number = 1;
        declarationsEx( obj,  objAmor, objAsset);
        for(int i=0; i<yearsToPayOffBond*12+1; i++){
            if(i == 0){
                bondPrincipleDebt[i] = Array.getDouble(objAmor.getArrayBalance(obj),i);
            }
            if(i == 12*number){
                if(k<yearsToPayOffBond+1){
                    bondPrincipleDebt[k] = Array.getDouble(objAmor.getArrayBalance(obj),i);
                }
                number++;
                k++;
            }
        }   
    }
    
    /**
     *
     * @param obj
     * @return
     */
    public  double[] getEndingBalancePerYear(Property obj){
        setEndingBalancePerYear(obj);
//        for(int i=0; i<yearsToPayOffBond+1;i++){
//            System.out.println(i + " " + bondPrincipleDebt[i]);
//        }        
        return bondPrincipleDebt;
    }
    
    /**
     *
     * @param obj
    */
    public  void setEquity(Property obj){
        //getEndingBalancePerYear(obj);
       // declarationsEx(obj, objAmor, objAsset);
        for(int i=0; i<yearsToPayOffBond+1; i++){
            if(i == 0){
                arrayEquity[i] = objAmor.getDepositInRands(obj);
            }
            else{
                arrayEquity[i] = arrayEquity[i-1] +(1*Array.getDouble(objIS.getShortFallPerYear(obj),i));
            }           
        }
    }
    
    /**
     *
     * @param obj
     * @return
     */
    public  double[] getEquity(Property obj){
        setEquity(obj);
//        for(int i=0; i<yearsToPayOffBond+1; i++){
//            System.out.println(i + " " + arrayEquity[i]);
//        }
        return arrayEquity;
    }
    
    /**
     *
     * @param obj
    */
    public  void setRetainedEarnings(Property obj){
        declarationsEx(obj, objAmor, objAsset);
        getEndingBalancePerYear(obj);
        getEquity(obj);
        for(int i=0; i<yearsToPayOffBond+1; i++){
               retainedEarnings[i] = Array.getDouble(objAsset.getTotal(obj),i)- bondPrincipleDebt[i] - arrayEquity[i];
        }           
    }
   
    
    /**
     *
     * @param obj
     * @return
     */
    public  double[] getRetainedEarnings(Property obj){
        setRetainedEarnings(obj);
//        for(int i=0; i<yearsToPayOffBond+1; i++){
//            System.out.println(i + " " + retainedEarnings[i]);
//        }
        return retainedEarnings;
    }
    
    public void setRoi(Property obj) {
        declarationsEx(obj, objAmor, objAsset);
        getRetainedEarnings(obj);
        getEquity(obj);
        for(int i = 1; i<yearsToPayOffBond+1; i++){
            roi[i] = ((retainedEarnings[i]/arrayEquity[i] - 1) *100) / i;
        }
    }
    public double[] getRoi(Property obj) {
        setRoi(obj);
        for(int i = 0; i<yearsToPayOffBond+1; i++){
            roi[i] = Math.round(roi[i]);
        }
        for(int i = 0; i<yearsToPayOffBond+1; i++){
            System.out.println(i+". "+ roi[i]);
        }
        return roi;
    }

}
