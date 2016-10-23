/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Accounting;
import Entities.Property;
import java.lang.reflect.Array;

/**
 *
 * @author Diana
 */
public class accountingLiabilities {
    accountingAsset objAsset;          
    AmortizationTableBond objAmor; 
    
    int yearsToPayOffBond = 0;
    double bondPrincipleDebt[];
    double arrayEquity[];
    
    /**
     *
     * @param obj
     * @param objAmor
     * @param objAsset
    */
    public void declarationsEx(Property obj, AmortizationTableBond objAmor,accountingAsset objAsset){ 
        
        this.objAmor = objAmor;
        this.objAsset = objAsset;
         
        yearsToPayOffBond = obj.getBond().getNumberOfYears();
        bondPrincipleDebt = new double[yearsToPayOffBond+1];
        arrayEquity = new double[yearsToPayOffBond+1];
    }
    /**
     *
     * @param obj
    */
    public  void setEndingBalancePerYear(Property obj){
        int k=1;
        int number = 1;
        
        for(int i=0; i<yearsToPayOffBond*12+1; i++){
            if(i == 0){
                bondPrincipleDebt[i] = Array.getDouble(objAmor.getArrayBalance(obj),i);
            }
            if(i == 12*number){
                if(k<yearsToPayOffBond+1){
                    bondPrincipleDebt[k] = Array.getDouble(objAmor.getArrayBalance(obj),i);
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
    public  double[] getEndingBalancePerYear(Property obj){
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
    public  void setEquity(Property obj){
        getEndingBalancePerYear(obj);
        for(int i=0; i<yearsToPayOffBond+1; i++){
            arrayEquity[i] = Array.getDouble(objAsset.getTotal(obj),i) - bondPrincipleDebt[i];
        }
    }
    
    /**
     *
     * @param obj
     * @return
     */
    public  double[] getEquity(Property obj){
        setEquity(obj);
//        for(int i=0; i<yearsToPayOffBond+1; i++){
//            System.out.println(i + " " + arrayEquity[i]);
//        }
        return arrayEquity;
    }

}
