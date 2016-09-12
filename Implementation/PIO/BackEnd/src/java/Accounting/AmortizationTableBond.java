/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Accounting;

import static Accounting.accountingExpenses.propertyValue;
import static Accounting.accountingExpenses.yearsToPayOffBond;
import Entities.Property;

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
    
    static double viewArray[] = new double[yearsToPayOffBond*12];
    
    
    public static void main(String[] args) {
        //getPrincipleDebt();
        setAmortizationTableBond(obj);
        getAmortizationTableBond();
    }
    /**
     *
     * @param obj
    */ 
    public static void setDepositInRands(Property obj){
        propertyValue = 799000;//obj.getBond().getPropertyValue();
        depositePercentage = 20.00; //obj.getBond().getDepositPercentage();
        //interestRate = 9.5;//obj.getBond().getInterestRate();
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
        //System.out.println(depositInRands);
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
        //System.out.println(principleDebt);
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
                arrayInterest[i] =  Math.round(arrayBalance[i-1]*((interestRate/100.00)/12.00));
               // System.out.println(arrayInterest[i]);
                arrayPrinciple[i] =  Math.round(paymentPerMonth - arrayInterest[i]);
                //System.out.println(arrayPrinciple[i]);
                arrayBalance[i] =  Math.round(arrayBalance[i-1] - arrayPrinciple[i]);
                System.out.println(arrayBalance[i]);
            }
        }
        
    }
    /**
     *
     * @return
     */
    public static double[] getAmortizationTableBond(){
        setAmortizationTableBond(obj);
//        for(int i=0; i<yearsToPayOffBond*12; i++){
//            System.out.println(Math.round(arrayBalance[i]));
//        }
        return viewArray;
    }
}
