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
    
    int yearsToPayOffBond;
    double maintenancePerYear;
    double arrayMaintenancePerYear[];
    double maintenanceRunningTotal[];
    
    public void declarationsReserves(Property obj, AmortizationTableBond objAmor,accountingRental objR){
        objAmor.declarationsAM(obj);
        objR.declarationsR(obj, objAmor);
        this.objAmor = objAmor;
        this.objR = objR;
        
        yearsToPayOffBond = obj.getBond().getNumberOfYears();
        maintenancePerYear = obj.getReserves().getMaintenance()/100.0;
        arrayMaintenancePerYear = new double[yearsToPayOffBond+1];
        maintenanceRunningTotal = new double[yearsToPayOffBond+1];
    }
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
