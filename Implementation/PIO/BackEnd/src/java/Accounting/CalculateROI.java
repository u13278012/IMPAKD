/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Accounting;
import Entities.Property;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
/**
 *
 * @author Diana
 */
public class CalculateROI {
     public static void main(String[] args) {
//        CalculateROI test = new CalculateROI();
//        Property obj = new Property();
//        test.getRoi(obj);
    }
    
   // int yearsToPayOffBond = 20;
    
   // accountingLiabilities objL = new accountingLiabilities();

    

 
        
//    double a = 0;
//    double rate = 0;
//    DecimalFormat df = new DecimalFormat("#.###");
//    final int yearsToPayOffBond = 20;
//    double depositInRands = 159800.00;
//    double principleDebt = 639200.00;
//    double paymentPerMonth = 5958;
//    double interestRate = 9.5;
//    double propertyValue =  799000.00;
//    double rentalAmount = 6700.00;
//    
//    AmortizationTableBond objAmor = new AmortizationTableBond();
//    accountingExpenses objExp = new accountingExpenses();
//    upFrontCosts upCosts = new upFrontCosts();
//    
//    double arrayROI[] = new double[yearsToPayOffBond+1]; 
//    double arrayRent[] = new double[yearsToPayOffBond+1];
//    double totalRent[] = new double[yearsToPayOffBond+1];
//    double arrayNPV[] = new double[yearsToPayOffBond+1]; 
//    double bondPurchase[] = new double[yearsToPayOffBond+1];
//    double propertyPurchase[] = new double[yearsToPayOffBond+1];
//    double onGoing[] = new double[yearsToPayOffBond+1];
//    //double expenses[] = new double[]{0.0 ,90369.0, 91725.0, 90579.0, 94742.0, 93496.0, 95088.0, 130415.0, 98636.0, 104450.0, 102930.0, 112513.0, 122611.0, 131097.0, 184879.0, 116432.0, 137009.0, 152031.0, 119747.0, 60006.0, 64425.0};
//    double expenses[] = new double[]{0.0 ,0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
//    
//    
//    public  static void main(String[] args) {  
//        CalculateROI roi = new CalculateROI();
//        Property obj = new Property();
//        AmortizationTableBond objAmor = new AmortizationTableBond();
//        //roi.discountRate(9.5);
//        roi.getROI(obj);
//    }
//    
//    public void declarationsROI(Property obj, AmortizationTableBond objAmor){ 
//       // expenses = ;
//    }
//    
//    /**
//     *
//     * @param i
//     * @return 
//    */
//    public  double discountRate(double i){
//        rate = (i/100.00) /12;
//        a = (1 - Math.pow(1+rate, -(yearsToPayOffBond*12))) / rate;
//       // System.out.println(a);
//        return a;
//    }
//    /**
//     *
//     * @param obj
//    */
//    public  void setRentAmount(Property obj){  
//        //increases per year for rates&taxes
//        for(int i=1; i< yearsToPayOffBond+1; i++){
//            if( i == 1){
//                arrayRent[i] = rentalAmount; 
//            }
//            else{
//                arrayRent[i] = arrayRent[i-1] * (6.00/100)  + arrayRent[i-1];
//            }
//        } 
//        //total rates&taxes for each year
//        for(int i=1; i<yearsToPayOffBond+1; i++){
//           totalRent[i] = Math.round(arrayRent[i] * 12);
//        }
//    }
//    /**
//     *
//     * @param obj
//    */
//    public void setROI(Property obj){
//        setRentAmount(obj);
//        for(int i=1; i< yearsToPayOffBond+1; i++){
//            if(i == 1){
//                bondPurchase[i] = -depositInRands /*-objAmor.getDepositInRands(obj)*/ + principleDebt/*objAmor.getPrincipleDebt(obj)*/-paymentPerMonth*discountRate(interestRate);
//                propertyPurchase[i] = -propertyValue -upCosts.getUpFrontCosts()/*-Reserves */;
//                onGoing[i] = totalRent[i] -expenses[i] /*Array.getDouble(objExp.getTotalExpenses(obj),i)*/;
//                arrayNPV[i] = bondPurchase[i] + propertyPurchase[i] + onGoing[i];
//                arrayROI[i] =  (arrayNPV[i]/propertyValue) *100;
//            }
//            else{
//                bondPurchase[i] = -paymentPerMonth*discountRate(interestRate);
//                propertyPurchase[i] = 0.0;
//                onGoing[i] = totalRent[i] -expenses[i] /*Array.getDouble(objExp.getTotalExpenses(obj),i)*/;
//                arrayNPV[i] = bondPurchase[i] + propertyPurchase[i] + onGoing[i];
//                arrayROI[i] =  (arrayNPV[i]/propertyValue) *100;
//            }
//        }
//    }
//    
//    /**
//     *
//     * @param obj
//     * @return 
//    */
//    public double[] getROI(Property obj){
//        setROI(obj);
//        for(int i =0; i<20+1;i++){  
//            arrayROI[i] = new Double(String.format("%.2f",arrayROI[i]));
//            System.out.println(arrayROI[i]);
//        }
//        return arrayROI;
//    }
}
