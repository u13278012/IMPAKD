/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Accounting;

import static Accounting.accountingExpenses.propertyValue;
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
    
    static double viewArray[] = new double[yearsToPayOffBond];
    static double arrayInterestTotalPerYear = 0.00;// = new double[yearsToPayOffBond];
    
    
    public static void main(String[] args) {
        //getPrincipleDebt();
       //setAmortizationTableBond(obj);
       // getArrayInterest();
       //getAmortizationTableBond();
        //getArrayBalance();
       // getArrayInterest();
        test();
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
               //System.out.println(arrayInterest[i]);
                arrayPrinciple[i] =  Math.round(paymentPerMonth - arrayInterest[i]);
                //System.out.println(arrayPrinciple[i]);
                arrayBalance[i] =  Math.round(arrayBalance[i-1] - arrayPrinciple[i]);
                //System.out.println(arrayBalance[i]);
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
    public static double[] getArrayPrinciple(){
        setAmortizationTableBond(obj);
//        for(int i=0; i<yearsToPayOffBond*12; i++){
//            System.out.println(i + " " + Math.round(arrayPrinciple[i]));
//        }
        return arrayPrinciple;
    }
    public static double[] getArrayBalance(){
       setAmortizationTableBond(obj);
//       for(int i=0; i<yearsToPayOffBond*12; i++){
//            System.out.println(i + " " + Math.round(arrayBalance[i]));
//        }
       return arrayBalance;
    }  
    
    public static double[] test(){
        getArrayInterest();
        int number = 1;
        int count = 0;
        int k=1;
//        for(int i=1; i<yearsToPayOffBond*12; i++){
//            if(i< 12*number+1){
//                count += count++;
//                arrayInterest[i] += arrayInterest[i];
//                viewArray[i] = arrayInterest[i];
//                if(count == 12){
//                    count = 0;
//                    number++;
//                    i = 12*number+1;
//                }
//            }        
//        }
//        
//        for(int i=0; i<yearsToPayOffBond*12; i++){
//            System.out.println(i + " " + Math.round(viewArray[i]));
//        }
        for(int i=1; i<yearsToPayOffBond*12;i++){ 
//            System.out.println("num: "+ number);
//            System.out.println("count: "+ count);
//            System.out.println("i: "+ i);
                if(i< 12*number+1){
                    count = count +1;
                   // System.out.println(i +" "+ arrayInterest[i]);
                    arrayInterestTotalPerYear += arrayInterest[i];
                    if(count == 12){
                        count = 0;                    
                        if(k < yearsToPayOffBond){
                            viewArray[k] = arrayInterestTotalPerYear;
                        }
                        number++;
                        k++;
                        arrayInterestTotalPerYear = 0;
                    }
                }
                else
                    break;
            
        }
        for(int i=0; i<yearsToPayOffBond; i++){
            System.out.println(i + " " + Math.round(viewArray[i]));
        }
        return viewArray;
    }
}
