/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Accounting;
import Entities.Property;

/**
 *
 * @author Diana
 */
public class AmortizationTableBond { 
  
    int yearsToPayOffBond = 0; 
    double interestRate = 0.00;  
    double depositePercentage =  0.00;
    double paymentPerMonth =  0.00;
    double propertyValue =  0.00;

    double arrayPaymentPerMonth[];
    double arrayInterest[];
    double arrayPrinciple[];
    double arrayBalance[];

    double arrayInterestPerYear[];
    double arrayPrinciplePerYear[];
    double interestPerYear = 0.00;
    double principlePerYear = 0.00;
    double depositInRands = 0.00;
    double principleDebt = 0.00;


    /**
     *
     * @param obj
    */  
    public void declarationsAM(){ 
        
        yearsToPayOffBond = 20;//obj.getBond().getNumberOfYears(); 
        interestRate = 9.5;//obj.getBond().getInterestRate();  
        depositePercentage = 20.00; //obj.getBond().getDepositPercentage();
        paymentPerMonth = 5958.00;//obj.getBond().getBondRepayment();
        propertyValue = 799000.00;//obj.getBond().getPropertyValue();

        arrayPaymentPerMonth = new double[yearsToPayOffBond*12+1];
        arrayInterest = new double[yearsToPayOffBond*12+1];
        arrayPrinciple = new double[yearsToPayOffBond*12+1];
        arrayBalance = new double[yearsToPayOffBond*12+1];

        arrayInterestPerYear = new double[yearsToPayOffBond+1];
        arrayPrinciplePerYear = new double[yearsToPayOffBond+1];
        interestPerYear = 0.00;
        principlePerYear = 0.00;
        depositInRands = 0.00;
        principleDebt = 0.00;      
    }

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
