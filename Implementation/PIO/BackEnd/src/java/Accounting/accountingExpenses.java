/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Accounting;
//import static Accounting.AmortizationTableBond.getArrayPrincipleTotalPerYear;
//import static Accounting.AmortizationTableBond.getTotalTax_DeductibleExpenses;
import Entities.Property;
import java.lang.reflect.Array;

/**
 *
 * @author Diana
 */
public class accountingExpenses {
    AmortizationTableBond objAmor = new AmortizationTableBond();
    
    final int yearsToPayOffBond = 20;//bond.getNumberOfYears();
    double rates_taxes = 370;//obj.getExpenses().getRates_Taxes();
    double levy = 534.50;//obj.getExpenses().getLevy();//expenses.getLevy();
    double bondFee = 57;//obj.getExpenses().getBondFee();//expenses.getBondFee();

    double arrayRates_Taxes[] = new double[yearsToPayOffBond+1];
    double arrayLevy[] = new double[yearsToPayOffBond+1];
    double arrayBondFee[] = new double[yearsToPayOffBond+1];

    double totalRates_Taxes[] = new double[yearsToPayOffBond+1];
    double totalLevy[] = new double[yearsToPayOffBond+1];
    double totalBondFee[] = new double[yearsToPayOffBond+1];
    double expenses[]  = new double[yearsToPayOffBond+1];
    double arrayTotalExpeneses[] = new double[yearsToPayOffBond+1];
   
    public  static void main(String[] args) {
        Property obj = new Property();
       // accountingExpenses test = new accountingExpenses();
        //test.Tax_DeductibleExpenses(obj);
    }
      
    /**
     *
     * @param obj
    */
    public  void setArrayRates_Taxes(Property obj){  
        //increases per year for rates&taxes
        for(int i=1; i< yearsToPayOffBond+1; i++){
            if( i == 1){
                arrayRates_Taxes[i] = rates_taxes; 
            }
            else{
                arrayRates_Taxes[i] =  arrayRates_Taxes[i-1] * 8.00/100.00/*obj.getIncreases().getRates_taxes() */ + arrayRates_Taxes[i-1];
            }
        }    
        
        //total rates&taxes for each year
        for(int i=1; i<yearsToPayOffBond+1; i++){
           totalRates_Taxes[i] = Math.round(arrayRates_Taxes[i] * 12);
        }
    }
    
     /**
     *
     * @param obj
     * @return
     */
    public  double[] getArrayRates_Taxes(Property obj){
        setArrayRates_Taxes(obj);
        return totalRates_Taxes;
    }
    
    /**
     *
     * @param obj
    */
    public  void setArrayLevy(Property obj){     
        //increases per year for levy 
        for(int i =1; i<yearsToPayOffBond+1; i++){
            if( i == 1){
                arrayLevy[i] = levy; 
            }
            else{
                arrayLevy[i] = arrayLevy[i-1] * 8.00/100.00/*obj.getIncreases().getRates_taxes() */ + arrayLevy[i-1];
            }
        }
        //total levy for each year
        for(int i=1; i<yearsToPayOffBond+1; i++){
            totalLevy[i] = Math.round(arrayLevy[i] * 12);
        }
        
    }
     /**
     *
     * @param obj
     * @return
     */
    public  double[] getArrayLevy(Property obj){
        setArrayLevy(obj);
        return totalLevy;
    }
    
    /**
     *
     * @param obj
    */
    public  void setArrayBondFee(Property obj){
        //increases per year for bondFee
        for(int i = 1; i<yearsToPayOffBond+1; i++){
            if( i == 1){
                arrayBondFee[i] = bondFee; 
            }
            else{
                arrayBondFee[i] = arrayBondFee[i-1] * 7.00/100.00/*obj.getIncreases().getRates_taxes()*/ + arrayBondFee[i-1];
            }
        }
        //total bondFee for each year
        for(int i=0; i<yearsToPayOffBond+1; i++){
            totalBondFee[i] = Math.round(arrayBondFee[i] * 12);
        }       
    }
    
    /**
     *
     * @param obj
     * @return
     */
    public  double[] getArrayBondFee(Property obj){
        setArrayBondFee(obj);
        return totalBondFee;
    }
    
         /**
     *
     * @param obj
    */
    public void setTotalTax_DeductibleExpenses(Property obj){
        //total expenses yearly
        for(int i=0; i< yearsToPayOffBond+1; i++){
            arrayTotalExpeneses[i] = Array.getDouble(objAmor.getArrayInterestTotalPerYear(obj),i) +  Array.getDouble(getArrayLevy(obj),i) + Array.getDouble(getArrayBondFee(obj),i) + Array.getDouble(getArrayRates_Taxes(obj),i);
        }
    }
    
     /**
     *
     * @param obj
     * @return
     */
    public double[] getTotalTax_DeductibleExpenses(Property obj){
        setTotalTax_DeductibleExpenses(obj);
        // display totalExpenses
//         for(int i=0; i< yearsToPayOffBond+1; i++){
//             System.out.println(i + " " + arrayTotalExpeneses[i]);
//         }
        return arrayTotalExpeneses;
    }
    
    /**
     *
     * @param obj
     * @return 
    */
    public  double[] Tax_DeductibleExpenses(Property obj){
        getArrayRates_Taxes(obj);
        getArrayLevy(obj);
        getArrayBondFee(obj);
        return getTotalTax_DeductibleExpenses(obj);
    }
    
    /**
     *
     * @param obj
     * @return 
    */
    public  double[] non_Tax_DeductibleExpenses(Property obj){
      return objAmor.getArrayPrincipleTotalPerYear(obj);
    }
    
    /**
     *
     * @param obj
    */
    public  void setTotalExpenses(Property obj){
        for(int i=0; i<yearsToPayOffBond+1;i++){
            expenses[i] = Array.getDouble(Tax_DeductibleExpenses(obj),i) + Array.getDouble(non_Tax_DeductibleExpenses(obj),i);
        }
    }
    /**
     *
     * @param obj
     * @return 
    */
    public  double[] getTotalExpenses(Property obj){
        setTotalExpenses(obj);
        for(int i=0; i< yearsToPayOffBond+1; i++){
            System.out.println(i + " " + expenses[i]);
        }
        return expenses;
    }
}
