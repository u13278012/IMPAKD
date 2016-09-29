/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Accounting;

import static Accounting.accountingExpenses.getArrayBondFee;
import static Accounting.accountingExpenses.getArrayLevy;
import static Accounting.accountingExpenses.getArrayRates_Taxes;
import Entities.Property;
import java.lang.reflect.Array;

/**
 *
 * @author Priscilla
 */
public class AmortizationTableBond {
     static Property obj = new Property();
    
     static int yearsToPayOffBond = 20;//bond.getNumberOfYears();
     static double interestRate = 0;
     static double depositInRands = 0;
     static double principleDebt = 0;
     static double depositePercentage = 0;
     static double interest = 0;
     static double paymentPerMonth = 0;
    
     static double arrayPaymentPerMonth[] = new double[yearsToPayOffBond*12];
     static double arrayInterest[] = new double[yearsToPayOffBond*12];
     static double arrayPrinciple[] = new double[yearsToPayOffBond*12];
     static double arrayBalance[] = new double[yearsToPayOffBond*12];
    
     static double viewArray[] = new double[yearsToPayOffBond];
     static  double arrayTotalExpeneses[] = new double[yearsToPayOffBond];
     static double arrayInterestPerYear = 0.00;
     static double propertyValue = 0;
    
    
    public static void main(String[] args) {
        //getPrincipleDebt();
       //setAmortizationTableBond(obj);
       // getArrayInterest();
       //getAmortizationTableBond();
        //getArrayBalance();
       // getArrayInterest();
        //getArrayInterestTotalPerYear();
        getTotalExpenses();
    }
    /**
     *
     * @param obj
    */ 
    public static void setDepositInRands(Property obj){
        propertyValue = 799000;//obj.getBond().getPropertyValue();
        depositePercentage = 20.00; //obj.getBond().getDepositPercentage();
        depositInRands = propertyValue * (depositePercentage/100);    
    }
     /**
     *
     * @param obj
    */
    public static void setPaymentPerMonth(Property obj){
        paymentPerMonth = 5958;//obj.getBond().getBondRepayment();
        for(int i=0; i<yearsToPayOffBond*12; i++){
            arrayPaymentPerMonth[i] = paymentPerMonth;
        }   
    }
    
    /**
     *
     * @return
     */
    public static double[] getPaymentPerMonth(){
        setPaymentPerMonth(obj);
//        for(int i=0; i<yearsToPayOffBond*12;i++){
//            System.out.println(i + " " + arrayPaymentPerMonth[i]);
//        }        
        return arrayPaymentPerMonth;
    }
    /**
     *
     * @return
     */
    public static double getDepositInRands(){
        setDepositInRands(obj);
        return depositInRands;
    }
    /**
     *
     * @param obj
    */ 
    public static void setPrincipleDebt(Property obj){
        propertyValue = 799000;//obj.getBond().getPropertyValue();
        principleDebt = propertyValue - getDepositInRands();
    }
    /**
     *
     * @return
     */
    public static double getPrincipleDebt(){
        setPrincipleDebt(obj);
        return principleDebt;
    }
    
    /**
     *
     * @param obj
    */ 
    public static void setAmortizationTableBond(Property obj){
        interestRate = 9.5;//obj.getBond().getInterestRate();
        paymentPerMonth = 5958;//obj.getBond().getBondRepayment();
        for(int i =0; i<yearsToPayOffBond*12; i++){
            if(i == 0){
                arrayBalance[i] = getPrincipleDebt();
            }
            else{
                /* EndingBalance * interestRate/12  */
                arrayInterest[i] =  Math.round(arrayBalance[i-1]*((interestRate/100.00)/12.00)); 
                
                /* payment Per Month - arrayInterest */
                arrayPrinciple[i] =  Math.round(paymentPerMonth - arrayInterest[i]);
                
                /* previous years ending balance - principle */
                arrayBalance[i] =  Math.round(arrayBalance[i-1] - arrayPrinciple[i]);
            }
        }   
    }
    /**
     *
     * @return
     */
    public static double[] getArrayInterest(){
        setAmortizationTableBond(obj);
//        for(int i=0; i<yearsToPayOffBond*12; i++){
//            System.out.println(i + " " + Math.round(arrayInterest[i]));
//        }
        return arrayInterest;
    }
    /**
     *
     * @return
     */
    public static double[] getArrayPrinciple(){
        setAmortizationTableBond(obj);
//        for(int i=0; i<yearsToPayOffBond*12; i++){
//            System.out.println(i + " " + Math.round(arrayPrinciple[i]));
//        }
        return arrayPrinciple;
    }
    /**
     *
     * @return
     */
    public static double[] getArrayBalance(){
       setAmortizationTableBond(obj);
//       for(int i=0; i<yearsToPayOffBond*12; i++){
//            System.out.println(i + " " + Math.round(arrayBalance[i]));
//        }
       return arrayBalance;
    }  
    /**
     *
     * @param obj
    */ 
    public static void setArrayInterestTotalPerYear(Property obj){
        getArrayInterest();   
        int number = 1;
        int count = 0;
        int k=1;
        /*calculate Interest per year from arrayInterest that calculated interest per month */
        for(int i=1; i<yearsToPayOffBond*12;i++){ 
            if(i< 12*number+1){
                count = count +1;
                arrayInterestPerYear += arrayInterest[i];
                if(count == 12){
                    count = 0;                    
                    if(k < yearsToPayOffBond){
                        viewArray[k] = arrayInterestPerYear;
                    }
                    number++;
                    k++;
                    arrayInterestPerYear = 0;
                }
            }          
        }

    }
    public static double[] getArrayInterestTotalPerYear(){
        setArrayInterestTotalPerYear(obj);
//                for(int k=1; k<yearsToPayOffBond; k++){
//            System.out.println(k + " " + Math.round(viewArray[k]));
//        }
        return viewArray;
    }
     /**
     *
     * @param obj
    */
    public static void setTotalExpenses(Property obj){
        //total expenses yearly
        getArrayInterestTotalPerYear();
        for(int i=0; i< yearsToPayOffBond; i++){
//            for(int k=1; k<yearsToPayOffBond;k++){
//               System.out.println(viewArray[k]); 
//            }
           // for(int k=1; k<yearsToPayOffBond;k++){
                arrayTotalExpeneses[i] = viewArray[i] +  Array.getDouble(getArrayLevy(),i) + Array.getDouble(getArrayBondFee(),i) + Array.getDouble(getArrayRates_Taxes(),i);
            //}
        }
    }
     /**
     *
     * @return
     */
    public static double[] getTotalExpenses(){
        setTotalExpenses(obj);
        // display totalExpenses
         for(int i=0; i< yearsToPayOffBond; i++){
             System.out.println(i + " " + arrayTotalExpeneses[i]);
         }
        return arrayTotalExpeneses;
    }
}
