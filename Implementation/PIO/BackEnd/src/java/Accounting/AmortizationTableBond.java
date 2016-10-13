/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Accounting;

//import static Accounting.accountingExpenses.getArrayBondFee;
//import static Accounting.accountingExpenses.getArrayLevy;
//import static Accounting.accountingExpenses.getArrayRates_Taxes;
import Entities.Property;

/**
 *
 * @author Diana
 */
public class AmortizationTableBond { 
    Property obj = new Property();
    
    final int yearsToPayOffBond = obj.getBond().getNumberOfYears(); 
    double interestRate = obj.getBond().getInterestRate();  
    double depositePercentage = 20.00; //obj.getBond().getDepositPercentage();
    double paymentPerMonth = obj.getBond().getBondRepayment();
    double propertyValue = obj.getBond().getPropertyValue();

    double arrayPaymentPerMonth[] = new double[yearsToPayOffBond*12+1];
    double arrayInterest[] = new double[yearsToPayOffBond*12+1];
    double arrayPrinciple[] = new double[yearsToPayOffBond*12+1];
    double arrayBalance[] = new double[yearsToPayOffBond*12+1];

    double arrayInterestPerYear[] = new double[yearsToPayOffBond+1];
    double arrayPrinciplePerYear[] = new double[yearsToPayOffBond+1];
    double interestPerYear = 0.00;
    double principlePerYear = 0.00;
    double depositInRands = 0.00;
    double principleDebt = 0.00;
    
    
    
//    public static void main(String[] args) {
//        Property obj = new Property();
//       //setAmortizationTableBond(obj);
//        //getTotalExpenses(obj);
//        //getArrayBalance(obj);
//       // getArrayPrincipleTotalPerYear(obj);
//    }
    
    /**
     *
     * @param obj
    */ 
    public  void setDepositInRands(Property obj){
        depositInRands = propertyValue * (depositePercentage/100);    
    }
    
     /**
     *
     * @param obj
    */
    public  void setPaymentPerMonth(Property obj){
        for(int i=0; i<yearsToPayOffBond*12+1; i++){
            arrayPaymentPerMonth[i] = paymentPerMonth;
        }   
    }
    
    /**
     *
     * @param obj
     * @return
     */
    public  double[] getPaymentPerMonth(Property obj){
        setPaymentPerMonth(obj);       
        return arrayPaymentPerMonth;
    }
    
    /**
     *
     * @param obj
     * @return
     */
    public  double getDepositInRands(Property obj){
        setDepositInRands(obj);
        return depositInRands;
    }
    
    /**
     *
     * @param obj
    */ 
    public  void setPrincipleDebt(Property obj){
        principleDebt = propertyValue - getDepositInRands(obj);
    }
    
    /**
     *
     * @param obj
     * @return
     */
    public  double getPrincipleDebt(Property obj){
        setPrincipleDebt(obj);
        return principleDebt;
    }
    
    /**
     *
     * @param obj
    */ 
    public  void setAmortizationTableBond(Property obj){            
        for(int i =0; i<yearsToPayOffBond*12+1; i++){
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
    public  double[] getArrayInterest(Property obj){
        setAmortizationTableBond(obj);
        return arrayInterest;
    }
    
    /**
     *
     * @param obj
     * @return
     */
    public  double[] getArrayPrinciple(Property obj){
        setAmortizationTableBond(obj);
//        for(int i =0; i<yearsToPayOffBond*12+1; i++){
//            System.out.println(i +" "+ arrayPrinciple[i]);
//        }
        return arrayPrinciple;
    }
    
    /**
     *
     * @param obj
     * @return
     */
    public double[] getArrayBalance(Property obj){
        setAmortizationTableBond(obj);
//        for(int i =0; i<yearsToPayOffBond*12+1; i++){
//            System.out.println(i +" "+ arrayBalance[i]);
//        }
       return arrayBalance;
    }  
    
    /**
     *
     * @param obj
    */ 
    public  void setArrayInterestTotalPerYear(Property obj){
        getArrayInterest(obj);   
        int number = 1;
        int count = 0;
        int k=1;
        /*calculate Interest per year from arrayInterest that calculated interest per month */
        for(int i=1; i<yearsToPayOffBond*12+1;i++){ 
            if(i< 12*number+1){
                count = count +1;
                interestPerYear += arrayInterest[i];
                if(count == 12){
                    count = 0;                    
                    if(k < yearsToPayOffBond+1){
                        arrayInterestPerYear[k] = interestPerYear;
                    }
                    number++;
                    k++;
                    interestPerYear = 0;
                }
            }          
        }

    }
    
     /**
     *
     * @param obj
     * @return
     */
    public double[] getArrayInterestTotalPerYear(Property obj){
        setArrayInterestTotalPerYear(obj);
        return arrayInterestPerYear;
    }
     
    /**
     *
     * @param obj
    */ 
    public void setArrayPrincipleTotalPerYear(Property obj){
        getArrayPrinciple(obj);   
        int number = 1;
        int count = 0;
        int k=1;
        /*calculate Interest per year from arrayInterest that calculated interest per month */
        for(int i=1; i<yearsToPayOffBond*12+1;i++){ 
            if(i< 12*number+1){
                count = count +1;
                principlePerYear += arrayPrinciple[i];
                if(count == 12){
                    count = 0;                    
                    if(k < yearsToPayOffBond+1){
                        arrayPrinciplePerYear[k] = principlePerYear;
                    }
                    number++;
                    k++;
                    principlePerYear = 0;
                }
            }          
        }

    }
    
     /**
     *
     * @param obj
     * @return
     */
    public double[] getArrayPrincipleTotalPerYear(Property obj){
        setArrayPrincipleTotalPerYear(obj);
//        for(int i =0; i<yearsToPayOffBond+1; i++){
//            System.out.println(i +" "+ arrayPrinciplePerYear[i]);
//        }
        return arrayPrinciplePerYear;
    }
    
}
