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
    // static Property obj = new Property();
    
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
        //getTotalExpenses(obj);
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
     * @param obj
     * @return
     */
    public static double[] getPaymentPerMonth(Property obj){
        setPaymentPerMonth(obj);
//        for(int i=0; i<yearsToPayOffBond*12;i++){
//            System.out.println(i + " " + arrayPaymentPerMonth[i]);
//        }        
        return arrayPaymentPerMonth;
    }
    /**
     *
     * @param obj
     * @return
     */
    public static double getDepositInRands(Property obj){
        setDepositInRands(obj);
        return depositInRands;
    }
    /**
     *
     * @param obj
    */ 
    public static void setPrincipleDebt(Property obj){
        propertyValue = 799000;//obj.getBond().getPropertyValue();
        principleDebt = propertyValue - getDepositInRands(obj);
    }
    /**
     *
     * @param obj
     * @return
     */
    public static double getPrincipleDebt(Property obj){
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
                arrayBalance[i] = getPrincipleDebt(obj);
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
     * @param obj
     * @return
     */
    public static double[] getArrayInterest(Property obj){
        setAmortizationTableBond(obj);
        return arrayInterest;
    }
    /**
     *
     * @param obj
     * @return
     */
    public static double[] getArrayPrinciple(Property obj){
        setAmortizationTableBond(obj);
        return arrayPrinciple;
    }
    /**
     *
     * @param obj
     * @return
     */
    public static double[] getArrayBalance(Property obj){
       setAmortizationTableBond(obj);
       return arrayBalance;
    }  
    /**
     *
     * @param obj
    */ 
    public static void setArrayInterestTotalPerYear(Property obj){
        getArrayInterest(obj);   
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
    public static double[] getArrayInterestTotalPerYear(Property obj){
        setArrayInterestTotalPerYear(obj);
        return viewArray;
    }
     /**
     *
     * @param obj
    */
    public static void setTotalExpenses(Property obj){
        //total expenses yearly
        getArrayInterestTotalPerYear(obj);
        for(int i=0; i< yearsToPayOffBond; i++){
            arrayTotalExpeneses[i] = viewArray[i] +  Array.getDouble(getArrayLevy(obj),i) + Array.getDouble(getArrayBondFee(obj),i) + Array.getDouble(getArrayRates_Taxes(obj),i);
        }
    }
     /**
     *
     * @param obj
     * @return
     */
    public static double[] getTotalExpenses(Property obj){
        setTotalExpenses(obj);
        // display totalExpenses
         for(int i=0; i< yearsToPayOffBond; i++){
             System.out.println(i + " " + arrayTotalExpeneses[i]);
         }
        return arrayTotalExpeneses;
    }
}
