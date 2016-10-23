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
public class ReservesCalculations {
    
    accountingRental objR = new accountingRental();
    AmortizationTableBond objAmor = new AmortizationTableBond();
    
    int yearsToPayOffBond = 20;//obj.getBond().getNumberOfYears();
    double maintenancePerYear = 5.00/100.00;//obj.getReserves().getMaintenance();
    double arrayMaintenancePerYear[] = new double[yearsToPayOffBond+1];
    double maintenanceRunningTotal[] = new double[yearsToPayOffBond+1];
     
    
    
//    public static void main(String[] args) { 
//        Reserves objR = new Reserves();
//        Property obj = new Property();
//        //objR.getMaintenance(obj);
//       objR.getMaintenanceRunningTotal(obj);
//    }
    
    /**
     *
     * @param obj
    */ 
    public void setMaintenance(Property obj){
        objR.declarationsR(obj,objAmor);
        for(int i=1; i<yearsToPayOffBond+1;i++){
            arrayMaintenancePerYear[i] = Array.getDouble(objR.getTotalRent(obj),i)*maintenancePerYear;
        }
    }
    
    /**
     *
     * @param obj
     * @return 
    */ 
    public double[] getMaintenance(Property obj){
        setMaintenance(obj);
        for(int i=1; i< yearsToPayOffBond+1; i++){
            arrayMaintenancePerYear[i] = Math.round(arrayMaintenancePerYear[i]);
        }         
        return arrayMaintenancePerYear;
    }
    
    /**
     *
     * @param obj
    */ 
    public void setMaintenanceRunningTotal(Property obj){
        int extend = 0;
        for(int i=1; i<yearsToPayOffBond+1;i++){
            if(i == 1){
                maintenanceRunningTotal[i] = Array.getDouble(getMaintenance(obj),i);
            }
            else{
                if(i == (7 + extend) + 1){
                    maintenanceRunningTotal[i] = (Array.getDouble(getMaintenance(obj),i) + maintenanceRunningTotal[i-1]) - maintenanceRunningTotal[i-1];
                    extend = 7;
                }
                else{
                    maintenanceRunningTotal[i] = Array.getDouble(getMaintenance(obj),i) + maintenanceRunningTotal[i-1];
                }
            }
            
        }
    }
    
    /**
     *
     * @param obj
     * @return 
    */ 
    public double[] getMaintenanceRunningTotal(Property obj){
        setMaintenanceRunningTotal(obj); 
        return maintenanceRunningTotal;
    }
 }
