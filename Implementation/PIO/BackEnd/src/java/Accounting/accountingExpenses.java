/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Accounting;
import Entities.Expenses;
import Entities.Increases;
import Entities.Bond;
import Entities.Property;
/**
 *
 * @author Diana
 */
public class accountingExpenses {
    
    static int yearsToPayOffBond = 20;//bond.getNumberOfYears();
   static  double arrayTotalExpeneses[] = new double[yearsToPayOffBond];
    static double rates_taxes, levy, bondFee;
    
    static double arrayRates_Taxes[] = new double[yearsToPayOffBond];
    static double arrayLevy[] = new double[yearsToPayOffBond];
   static  double arrayBondFee[] = new double[yearsToPayOffBond];
    
   static  double totalRates_Taxes[] = new double[yearsToPayOffBond];
   static  double totalLevy[] = new double[yearsToPayOffBond];
   static double totalBondFee[] = new double[yearsToPayOffBond];
    
    public static void main(String[] args) {
        Property obj = new Property();
        Tax_DeductibleExpenses(obj);
//        Expenses(arrayTotalExpeneses);
//        for(int i =0; i< 20; i++){
//            System.out.println(arrayTotalExpeneses[i]);
//        }
    }
        
    /**
     *
     * @param obj
    */
    public static void setArrayRates_Taxes(Property obj){
        rates_taxes = 370;//obj.getExpenses().getRates_Taxes();
        
        //increases per year for rates&taxes
        for(int i=0; i< yearsToPayOffBond; i++){
            if( i == 0){
                arrayRates_Taxes[i] = rates_taxes; 
            }
            else{
                arrayRates_Taxes[i] =  arrayRates_Taxes[i-1] * 8.00/100.00/*obj.getIncreases().getRates_taxes() */ + arrayRates_Taxes[i-1];
            }
        }    
        
        //total rates&taxes for each year
        for(int i=0; i<yearsToPayOffBond; i++){
           // System.out.println(i + " " + Math.round(arrayRates_Taxes[i] * 12));
           totalRates_Taxes[i] = Math.round(arrayRates_Taxes[i] * 12);
        }
    }
    
     /**
     *
     * @return
     */
    public static double[] getArrayRates_Taxes(){
        return totalRates_Taxes;
    }
    
    /**
     *
     * @param obj
    */
    public static void setArrayLevy(Property obj){
        levy = 534.50;//obj.getExpenses().getLevy();//expenses.getLevy();
        
        //increases per year for levy 
        for(int i =0; i<yearsToPayOffBond; i++){
            if( i == 0){
                arrayLevy[i] = levy; 
            }
            else{
                arrayLevy[i] = arrayLevy[i-1] * 8.00/100.00/*obj.getIncreases().getRates_taxes() */ + arrayLevy[i-1];
            }
        }
        //total levy for each year
        for(int i=0; i<yearsToPayOffBond; i++){
           // System.out.println(i + " " + Math.round(arrayLevy[i] * 12));
              totalLevy[i] = Math.round(arrayLevy[i] * 12);
        }
        
    }
     /**
     *
     * @return
     */
    public static double[] getArrayLevy(){
        return totalLevy;
    }
    
    /**
     *
     * @param obj
    */
    public static void setArrayBondFee(Property obj){
        bondFee = 57;//obj.getExpenses().getBondFee();//expenses.getBondFee();
        
        //increases per year for bondFee
        for(int i = 0; i<yearsToPayOffBond; i++){
            if( i == 0){
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
     * @return
     */
    public static double[] getArrayBondFee(){
        return totalBondFee;
    }
    
    /**
     *
     * @param obj
    */
    public static void setTotalExpenses(Property obj){
        //total expenses yearly
        for(int i=0; i< yearsToPayOffBond; i++){
            arrayTotalExpeneses[i] = totalLevy[i] + totalBondFee[i] + totalRates_Taxes[i];
        }
    }
     /**
     *
     * @return
     */
    public static double[] getTotalExpenses(){
        // display totalExpenses
         for(int i=0; i< yearsToPayOffBond; i++){
             System.out.println(i + " " + arrayTotalExpeneses[i]);
         }
        return arrayTotalExpeneses;
    }
    
    public static double[] Tax_DeductibleExpenses(Property obj){
        setArrayRates_Taxes(obj);
        getArrayRates_Taxes();

        setArrayLevy(obj);
        getArrayLevy();

        setArrayBondFee(obj);
        getArrayBondFee();

        setTotalExpenses(obj);
       return getTotalExpenses();
       // Property propertyObj = new Property();
//        Expenses expenses = new Expenses();      
//        Increases increasesPerYear = new Increases();
//        Bond bond = new Bond();
       
//        int yearsToPayOffBond = 20;//bond.getNumberOfYears();
//        double arrayTotalExpeneses[] = new double[yearsToPayOffBond];
//        double rates_taxes, levy, bondFee;
       
//        rates_taxes = 370;//obj.getExpenses().getRates_Taxes();
//        levy = 534.50;//obj.getExpenses().getLevy();//expenses.getLevy(); 
//        bondFee = 57;//obj.getExpenses().getBondFee();//expenses.getBondFee(); 
        
//        double arrayRates_Taxes[] = new double[yearsToPayOffBond];
//        double arrayLevy[] = new double[yearsToPayOffBond];
//        double arrayBondFee[] = new double[yearsToPayOffBond];
//       
//        double totalRates_Taxes[] = new double[yearsToPayOffBond];
//        double totalLevy[] = new double[yearsToPayOffBond];
//        double totalBondFee[] = new double[yearsToPayOffBond];
        
        //increases per year for rates&taxes
//        for(int i=0; i< yearsToPayOffBond; i++){
//            if( i == 0){
//                arrayRates_Taxes[i] = rates_taxes; 
//            }
//            else{
//                arrayRates_Taxes[i] =  arrayRates_Taxes[i-1] * 8.00/100.00/*obj.getIncreases().getRates_taxes() */ + arrayRates_Taxes[i-1];
//            }
//        }
        //total rates&taxes for each year
//        for(int i=0; i<yearsToPayOffBond; i++){
//           // System.out.println(i + " " + Math.round(arrayRates_Taxes[i] * 12));
//           totalRates_Taxes[i] = Math.round(arrayRates_Taxes[i] * 12);
//        }
        
        //increases per year for levy 
//        for(int i =0; i<yearsToPayOffBond; i++){
//            if( i == 0){
//                arrayLevy[i] = levy; 
//            }
//            else{
//                arrayLevy[i] = arrayLevy[i-1] * 8.00/100.00/*obj.getIncreases().getRates_taxes() */ + arrayLevy[i-1];
//            }
//        }
//        //total levy for each year
//        for(int i=0; i<yearsToPayOffBond; i++){
//           // System.out.println(i + " " + Math.round(arrayLevy[i] * 12));
//              totalLevy[i] = Math.round(arrayLevy[i] * 12);
//        }
        
        //increases per year for bondFee
//        for(int i = 0; i<yearsToPayOffBond; i++){
//            if( i == 0){
//                arrayBondFee[i] = bondFee; 
//            }
//            else{
//                arrayBondFee[i] = arrayBondFee[i-1] * 7.00/100.00/*obj.getIncreases().getRates_taxes()*/ + arrayBondFee[i-1];
//            }
//        }
//        //total bondFee for each year
//        for(int i=0; i<yearsToPayOffBond; i++){
//            //System.out.println(i + " " + Math.round(arrayBondFee[i] * 12));
//            totalBondFee[i] = Math.round(arrayBondFee[i] * 12);
//        }
        
        //total expenses yearly
//        for(int i=0; i< yearsToPayOffBond; i++){
//            arrayTotalExpeneses[i] = totalLevy[i] + totalBondFee[i] + totalRates_Taxes[i];
//        }
//
//       // display totalExpenses
//         for(int i=0; i< yearsToPayOffBond; i++){
//             System.out.println(i + " " + arrayTotalExpeneses[i]);
//         }
//        return arrayTotalExpeneses;
    }
   
//   static public double[] AmortizationTableforBond(){
//       
//   }
}
