/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Accounting;
import static Accounting.AmortizationTableBond.getArrayBalance;
import static Accounting.accountingAsset.getTotal;
import Entities.Property;
import java.lang.reflect.Array;

/**
 *
 * @author Diana
 */
public class accountingLiabilities {
    static final int yearsToPayOffBond = 20;//bond.getNumberOfYears();
    static double bondPrincipleDebt[] = new double[yearsToPayOffBond+1];
    static double arrayEquity[] = new double[yearsToPayOffBond+1];
    
    public  static void main(String[] args) {
        Property obj = new Property();
        //getEndingBalancePerYear(obj);
        getEquity(obj);
    }
     
    /**
     *
     * @param obj
    */
    public static void setEndingBalancePerYear(Property obj){
        int k=1;
        int number = 1;
        
        for(int i=0; i<yearsToPayOffBond*12+1; i++){
            if(i == 0){
                bondPrincipleDebt[i] = Array.getDouble(getArrayBalance(obj),i);
            }
            if(i == 12*number){
                if(k<yearsToPayOffBond+1){
                    bondPrincipleDebt[k] = Array.getDouble(getArrayBalance(obj),i);
                }
                number++;
                k++;
            }
        }   
    }
    
    /**
     *
     * @param obj
     * @return
     */
    public static double[] getEndingBalancePerYear(Property obj){
        setEndingBalancePerYear(obj);
//        for(int i=0; i<yearsToPayOffBond+1;i++){
//            System.out.println(i + " " + bondPrincipleDebt[i]);
//        }        
        return bondPrincipleDebt;
    }
    
       /**
     *
     * @param obj
    */
    public static void setEquity(Property obj){
        getEndingBalancePerYear(obj);
        for(int i=0; i<yearsToPayOffBond+1; i++){
            arrayEquity[i] = Array.getDouble(getTotal(obj),i) - bondPrincipleDebt[i];
        }
    }
    
    /**
     *
     * @param obj
     * @return
     */
    public static double[] getEquity(Property obj){
        setEquity(obj);
        for(int i=0; i<yearsToPayOffBond+1; i++){
            System.out.println(i + " " + arrayEquity[i]);
        }
        return arrayEquity;
    }

}
