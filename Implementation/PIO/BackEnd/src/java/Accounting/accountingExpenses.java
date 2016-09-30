/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Accounting;
import static Accounting.AmortizationTableBond.getTotalExpenses;
import Entities.Property;
/**
 *
 * @author Diana
 */
public class accountingExpenses {
    
    static int yearsToPayOffBond = 20;//bond.getNumberOfYears();
    static double rates_taxes, levy, bondFee, paymentPerMonth;
    
    static double arrayRates_Taxes[] = new double[yearsToPayOffBond];
    static  double arrayLevy[] = new double[yearsToPayOffBond];
    static  double arrayBondFee[] = new double[yearsToPayOffBond];
    

    static double propertyValue = 0;
    static double depositePercentage = 0;
    static double depositInRands = 0;
    static  double principleDebt = 0;

    static   double totalRates_Taxes[] = new double[yearsToPayOffBond];
    static   double totalLevy[] = new double[yearsToPayOffBond];
    static  double totalBondFee[] = new double[yearsToPayOffBond];
    
    //static  Property obj = new Property();
    static AmortizationTableBond test = new AmortizationTableBond();
    
    public  static void main(String[] args) {
        //getPaymentPerMonth();
      // Tax_DeductibleExpenses();
       //getArrayBondFee();
    }
      
    /**
     *
     * @param obj
    */
    public static void setArrayRates_Taxes(Property obj){
        rates_taxes = 370;//obj.getExpenses().getRates_Taxes();
        
        //increases per year for rates&taxes
        for(int i=1; i< yearsToPayOffBond; i++){
            if( i == 1){
                arrayRates_Taxes[i] = rates_taxes; 
            }
            else{
                arrayRates_Taxes[i] =  arrayRates_Taxes[i-1] * 8.00/100.00/*obj.getIncreases().getRates_taxes() */ + arrayRates_Taxes[i-1];
            }
        }    
        
        //total rates&taxes for each year
        for(int i=1; i<yearsToPayOffBond; i++){
           // System.out.println(i + " " + Math.round(arrayRates_Taxes[i] * 12));
           totalRates_Taxes[i] = Math.round(arrayRates_Taxes[i] * 12);
        }
    }
    
     /**
     *
     * @param obj
     * @return
     */
    public static double[] getArrayRates_Taxes(Property obj){
        setArrayRates_Taxes(obj);
        return totalRates_Taxes;
    }
    
    /**
     *
     * @param obj
    */
    public static void setArrayLevy(Property obj){
        levy = 534.50;//obj.getExpenses().getLevy();//expenses.getLevy();
        
        //increases per year for levy 
        for(int i =1; i<yearsToPayOffBond; i++){
            if( i == 1){
                arrayLevy[i] = levy; 
            }
            else{
                arrayLevy[i] = arrayLevy[i-1] * 8.00/100.00/*obj.getIncreases().getRates_taxes() */ + arrayLevy[i-1];
            }
        }
        //total levy for each year
        for(int i=1; i<yearsToPayOffBond; i++){
           // System.out.println(i + " " + Math.round(arrayLevy[i] * 12));
              totalLevy[i] = Math.round(arrayLevy[i] * 12);
        }
        
    }
     /**
     *
     * @param obj
     * @return
     */
    public static double[] getArrayLevy(Property obj){
        setArrayLevy(obj);
        return totalLevy;
    }
    
    /**
     *
     * @param obj
    */
    public static void setArrayBondFee(Property obj){
        bondFee = 57;//obj.getExpenses().getBondFee();//expenses.getBondFee();
        
        //increases per year for bondFee
        for(int i = 1; i<yearsToPayOffBond; i++){
            if( i == 1){
                arrayBondFee[i] = bondFee; 
            }
            else{
                arrayBondFee[i] = arrayBondFee[i-1] * 7.00/100.00/*obj.getIncreases().getRates_taxes()*/ + arrayBondFee[i-1];
            }
        }
        //total bondFee for each year
        for(int i=0; i<yearsToPayOffBond; i++){
            //System.out.println(i + " " + Math.round(arrayBondFee[i] * 12));
            totalBondFee[i] = Math.round(arrayBondFee[i] * 12);
        }       
    }
    
    /**
     *
     * @param obj
     * @return
     */
    public static double[] getArrayBondFee(Property obj){
        setArrayBondFee(obj);
//        for(int i=0; i<yearsToPayOffBond; i++){
//            System.out.println(i + " "+ totalBondFee[i]);
//        }
        return totalBondFee;
    }
    
    
    /**
     *
     * @param obj
     * @return 
    */
    public static double[] Tax_DeductibleExpenses(Property obj){
        getArrayRates_Taxes(obj);
        getArrayLevy(obj);
        getArrayBondFee(obj);
       return getTotalExpenses(obj);
    }
}
