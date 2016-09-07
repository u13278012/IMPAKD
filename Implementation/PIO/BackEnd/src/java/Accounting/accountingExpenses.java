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
    
     
    
        public static void main(String[] args) {
        //Tax_DeductibleExpenses();
//        Expenses(arrayTotalExpeneses);
//        for(int i =0; i< 20; i++){
//            System.out.println(arrayTotalExpeneses[i]);
//        }
    }
   static  public double[] Tax_DeductibleExpenses(Object obj){
       // Property propertyObj = new Property();
        Expenses expenses = new Expenses();      
        Increases increasesPerYear = new Increases();
        Bond bond = new Bond();
        int yearsToPayOffBond = bond.getNumberOfYears();
        double arrayTotalExpeneses[] = new double[bond.getNumberOfYears()];
        double rates_taxes, levy, bondFee;
       
        rates_taxes = expenses.getRates_Taxes();/*obj.getExpenses().getRates_Taxes(); */
        levy = expenses.getLevy(); 
        bondFee = expenses.getBondFee(); 
        
        double arrayRates_Taxes[] = new double[yearsToPayOffBond];
        double arrayLevy[] = new double[yearsToPayOffBond];
        double arrayBondFee[] = new double[yearsToPayOffBond];
       
        double totalRates_Taxes[] = new double[yearsToPayOffBond];
        double totalLevy[] = new double[yearsToPayOffBond];
        double totalBondFee[] = new double[yearsToPayOffBond];
        
        //increases per year for rates&taxes
        for(int i=0; i< yearsToPayOffBond; i++){
            if( i == 0){
                arrayRates_Taxes[i] = rates_taxes; 
            }
            else{
                arrayRates_Taxes[i] =  arrayRates_Taxes[i-1] * increasesPerYear.getRates_taxes() + arrayRates_Taxes[i-1];
            }
        }
        //total rates&taxes for each year
        for(int i=0; i<yearsToPayOffBond; i++){
           // System.out.println(i + " " + Math.round(arrayRates_Taxes[i] * 12));
           totalRates_Taxes[i] = Math.round(arrayRates_Taxes[i] * 12);
        }
        
        //increases per year for levy 
        for(int i =0; i<yearsToPayOffBond; i++){
            if( i == 0){
                arrayLevy[i] = levy; 
            }
            else{
                arrayLevy[i] = arrayLevy[i-1] * increasesPerYear.getLevy() + arrayLevy[i-1];
            }
        }
        //total levy for each year
        for(int i=0; i<yearsToPayOffBond; i++){
           // System.out.println(i + " " + Math.round(arrayLevy[i] * 12));
              totalLevy[i] = Math.round(arrayLevy[i] * 12);
        }
        
        //increases per year for bondFee
        for(int i = 0; i<yearsToPayOffBond; i++){
            if( i == 0){
                arrayBondFee[i] = bondFee; 
            }
            else{
                arrayBondFee[i] = arrayBondFee[i-1] * increasesPerYear.getBondFee() + arrayBondFee[i-1];
            }
        }
        //total bondFee for each year
        for(int i=0; i<yearsToPayOffBond; i++){
            //System.out.println(i + " " + Math.round(arrayBondFee[i] * 12));
            totalBondFee[i] = Math.round(arrayBondFee[i] * 12);
        }
        
        //total expenses yearly
        for(int i=0; i< yearsToPayOffBond; i++){
            arrayTotalExpeneses[i] = totalLevy[i] + totalBondFee[i] + totalRates_Taxes[i];
        }

       // display totalExpenses
         for(int i=0; i< yearsToPayOffBond; i++){
             System.out.println(i + " " + arrayTotalExpeneses[i]);
         }
        return arrayTotalExpeneses;
    }
   
//   static public double[] AmortizationTableforBond(){
//       
//   }
}
