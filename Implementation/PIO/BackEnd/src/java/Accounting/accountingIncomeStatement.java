package Accounting;
import Entities.Property;
import java.lang.reflect.Array;

/**
 *
 * @author Priscilla, Diana
 */

public class accountingIncomeStatement 
{   
    Property obj = new Property();
    AmortizationTableBond objAmor = new AmortizationTableBond();
    accountingRental objR = new accountingRental();
    Reserves objRe = new Reserves();
    
    int yearsToPayOffBond = 20;//obj.getBond().getNumberOfYears();
    
    double rentIncome = 6700.0;//obj.getRental().getRentalAmount();
    double rentIncrease = 6.00/100.00;//obj.getIncreases().getRent();
    
    double rates_taxes = 370.0; //obj.getExpenses().getRates_Taxes();
    double rates_taxesIncrease = 8.00/100.00;//obj.getIncreases().getRates_taxes();
    
    double levy = 535.0; //obj.getExpenses().getLevy();
    double levyIncrease =8.00/100.00; //obj.getIncreases().getLevy();
    
    double bondFee = 57; //obj.getExpenses().getBondFee();
    double bondFeeIncrease = 7.00/100.00;//obj.getIncreases().getBondFee();
    
     
    double RentIncome[] = new double[yearsToPayOffBond*12+1]; 
    double rentIncYearly[] = new double[yearsToPayOffBond+1];
    
    double InterestIncome[] = new double[yearsToPayOffBond*12+1];
    double GrossProfit[] = new double[yearsToPayOffBond*12+1];
    
    double RatesTaxes[] = new double[yearsToPayOffBond*12+1];
    double ratesTaxesIncYearly[] = new double[yearsToPayOffBond+1];
    
    double Levy[] = new double[yearsToPayOffBond*12+1];
    double levyTaxesIncYearly[] = new double[yearsToPayOffBond+1];
    
    double BondFee[] = new double[yearsToPayOffBond*12+1];
    double bondFeeTaxesIncYearly[] = new double[yearsToPayOffBond+1];
    
    double maintenance[] = new double[yearsToPayOffBond*12+1];
    double TaxableExpenses[] = new double[yearsToPayOffBond*12+1];
    double PreTaxIncome[] = new double[yearsToPayOffBond*12+1];
    double TaxableProfit[] = new double[yearsToPayOffBond*12+1];
    double TaxableProfitAccumulated[] = new double[yearsToPayOffBond*12+1];
    double PayTax[] = new double[yearsToPayOffBond*12+1];
    double NetIncome[] = new double[yearsToPayOffBond*12+1];
    double Cash[] = new double[yearsToPayOffBond*12+1];
    double ShortFall[] = new double[yearsToPayOffBond*12+1];
    
    public static void main(String[] args) { 
        accountingIncomeStatement test = new accountingIncomeStatement();
        //AmortizationTableBond objAmor = new AmortizationTableBond();
        Property obj = new Property();
        //test.getRentIncome(obj);
        //test.getGrossProfit(obj);
        //test.getRatesTaxes(obj);
       // test.getLevy(obj);
      // test.getBondFee(obj);
        test.getTaxableExpenses(obj);
     // test.getMaintenance(obj);
    }
    
    /******************************************* RentIncome Calculations **************************************************/
    
    /**
     *
     * @param obj
    */ 
    public void setRentIncYearly(Property obj){
        for(int i=1; i<yearsToPayOffBond+1;i++){
            if(i == 1){
                rentIncYearly[i] = rentIncome;
            }
            else{
                rentIncYearly[i] = rentIncYearly[i-1]*rentIncrease + rentIncYearly[i-1];
            }
        }
    }
    
    /**
     *
     * @param obj
     * @return 
    */ 
    public double[] getRentIncYearly(Property obj){
        setRentIncYearly(obj);
        for(int i=1; i<yearsToPayOffBond+1;i++){
            rentIncYearly[i] = Math.round(rentIncYearly[i]);
        }
        return rentIncYearly;
    }
    
    /**
     *
     * @param obj
    */ 
    public void setRentIncome(Property obj){
        int n=1;
        int k = 1;
        int count = 0;
        for(int i=1; i<yearsToPayOffBond*12+1;i++){
            if(i < 12*n+2){
                count++;
                if(k < yearsToPayOffBond+1){
                    RentIncome[i] = Array.getDouble(getRentIncYearly(obj),k);    
                }
            }
            if(count == 12){
                count = 0;           
                i = 12*n+1;
                RentIncome[i] = Array.getDouble(getRentIncYearly(obj),k+1);
                n++;
                k++;
            }    
        }
    }
    
    /**
     *
     * @param obj
     * @return 
    */ 
    public double[] getRentIncome(Property obj){
        setRentIncome(obj);
        return RentIncome;
    }
    
    /******************************************* InterestIncome Calculations **************************************************/
    /**
     *
     * @param obj
    */ 
    public void setInterestIncome(Property obj){

    }
    /**
     *
     * @param obj
     * @return 
    */ 
    public double[] getInterestIncome(Property obj){
        return InterestIncome;
    }
    

    
    /******************************************* GrossProfit Calculations **************************************************/
     /**
     *
     * @param obj
    */ 
    public void setGrossProfit(Property obj){
        for(int i=1; i<yearsToPayOffBond*12+1;i++){
            GrossProfit[i] = Array.getDouble(getRentIncome(obj),i) + Array.getDouble(getInterestIncome(obj),i);
        }
    }

    /**
     *
     * @param obj
     * @return 
    */ 
    public double[] getGrossProfit(Property obj){
        setGrossProfit(obj);
<<<<<<< HEAD
//        for(int i=0; i<yearsToPayOffBond*12+1;i++){
//            System.out.println(i +" "+ GrossProfit[i]);
//        }
=======
        for(int i=0; i<yearsToPayOffBond*12+1;i++){
            System.out.println(i +" "+ GrossProfit[i]);

        }
>>>>>>> master
        return GrossProfit;
    }
    
    /******************************************* Rates & Taxes Calculations **************************************************/
    /**
     *
     * @param obj
    */ 
    public void setRatesTaxesIncYearly(Property obj){
        for(int i=1; i<yearsToPayOffBond+1;i++){
            if(i == 1){
                ratesTaxesIncYearly[i] = rates_taxes;
            }
            else{
                ratesTaxesIncYearly[i] = ratesTaxesIncYearly[i-1]*rates_taxesIncrease + ratesTaxesIncYearly[i-1];
            }
        }
    }
    
    /**
     *
     * @param obj
     * @return 
    */ 
    public double[] getRatesTaxesIncYearly(Property obj){
        setRatesTaxesIncYearly(obj);
        for(int i=1; i<yearsToPayOffBond+1;i++){
            ratesTaxesIncYearly[i] = Math.round(ratesTaxesIncYearly[i]);
        }
        return ratesTaxesIncYearly;
    }
    /**
     *
     * @param obj
    */ 
    public void setRatesTaxes(Property obj){
        int n=1;
        int k = 1;
        int count = 0;
        for(int i=1; i<yearsToPayOffBond*12+1;i++){
            if(i < 12*n+2){
                count++;
                if(k < yearsToPayOffBond+1){
                    RatesTaxes[i] = Array.getDouble(getRatesTaxesIncYearly(obj),k);    
                }
            }
            if(count == 12){
                count = 0;           
                i = 12*n+1;
                RatesTaxes[i] = Array.getDouble(getRatesTaxesIncYearly(obj),k+1);
                n++;
                k++;
            }    
        }
    }
    
    /**
     *
     * @param obj
     * @return 
    */ 
    public double[] getRatesTaxes(Property obj){
        setRatesTaxes(obj);
        return RatesTaxes;
    }
    
    /******************************************* Levy Calculations **************************************************/
<<<<<<< HEAD
    /**
     *
     * @param obj
    */ 
    public void setLevyIncYearly(Property obj){
        for(int i=1; i<yearsToPayOffBond+1;i++){
            if(i == 1){
                levyTaxesIncYearly[i] = levy;
            }
            else{
                levyTaxesIncYearly[i] = levyTaxesIncYearly[i-1]*levyIncrease + levyTaxesIncYearly[i-1];
            }
        }
    }
    
    /**
     *
     * @param obj
     * @return 
    */ 
    public double[] getLevyIncYearly(Property obj){
        setLevyIncYearly(obj);
        for(int i=1; i<yearsToPayOffBond+1;i++){
            levyTaxesIncYearly[i] = Math.round(levyTaxesIncYearly[i]);
        }
        return levyTaxesIncYearly;
    }
    
    /**
     *
     * @param obj
    */ 
    public void setLevy(Property obj){
        int n=1;
        int k = 1;
        int count = 0;
        for(int i=1; i<yearsToPayOffBond*12+1;i++){
            if(i < 12*n+2){
                count++;
                if(k < yearsToPayOffBond+1){
                    Levy[i] = Array.getDouble(getLevyIncYearly(obj),k);    
                }
            }
            if(count == 12){
                count = 0;           
                i = 12*n+1;
                Levy[i] = Array.getDouble(getLevyIncYearly(obj),k+1);
                n++;
                k++;
            }    
        }
    }
    
    /**
     *
     * @param obj
     * @return 
    */ 
    public double[] getLevy(Property obj){
        setLevy(obj);
        return Levy;
    }
=======

>>>>>>> master
    
    
    /******************************************* BondFee Calculations **************************************************/
    /**
     *
     * @param obj
    */ 
    public void setBondFeeIncYearly(Property obj){
        for(int i=1; i<yearsToPayOffBond+1;i++){
            if(i == 1){
                bondFeeTaxesIncYearly[i] = bondFee;
            }
            else{
                bondFeeTaxesIncYearly[i] = bondFeeTaxesIncYearly[i-1]*bondFeeIncrease + bondFeeTaxesIncYearly[i-1];
            }
        }
    }
    
    /**
     *
     * @param obj
     * @return 
    */ 
    public double[] getBondFeeIncYearly(Property obj){
        setBondFeeIncYearly(obj);
        for(int i=1; i<yearsToPayOffBond+1;i++){
            bondFeeTaxesIncYearly[i] = Math.round(bondFeeTaxesIncYearly[i]);
        }
        return bondFeeTaxesIncYearly;
    }
    
    /**
     *
     * @param obj
    */ 
    public void setBondFee(Property obj){
        int n=1;
        int k = 1;
        int count = 0;
        for(int i=1; i<yearsToPayOffBond*12+1;i++){
            if(i < 12*n+2){
                count++;
                if(k < yearsToPayOffBond+1){
                    BondFee[i] = Array.getDouble(getBondFeeIncYearly(obj),k);    
                }
            }
            if(count == 12){
                count = 0;           
                i = 12*n+1;
                BondFee[i] = Array.getDouble(getBondFeeIncYearly(obj),k+1);
                n++;
                k++;
            }    
        }
    }
    
    /**
     *
     * @param obj
     * @return 
    */ 
    public double[] getBondFee(Property obj){
        setBondFee(obj);
        return BondFee;
    }
    
    /******************************************* Maintenance Calculations **************************************************/
    /**
     *
     * @param obj
    */ 
    public void setMaintenance(Property obj){
       // int k = 1;
        int extend = 0;
        for(int i=1; i<yearsToPayOffBond*12+1;i++){
            for(int k=1;k < yearsToPayOffBond+1;k++){
                if(i == 12*(7+extend) && k == (7+extend)){
                    maintenance[i] = Array.getDouble(objRe.getMaintenanceRunningTotal(obj),k);
                    extend = 7;
                }
            }
            
        }
    }
    
    /**
     *
     * @param obj
     * @return 
    */ 
    public double[] getMaintenance(Property obj){
        setMaintenance(obj);
//        for(int i=0; i<yearsToPayOffBond*12+1;i++){
//            System.out.println(i +" "+ maintenance[i]);
//        }
        return maintenance;
    }
    
    /******************************************* taxableExpense Calculations **************************************************/
    /**
     *
     * @param obj
    */ 
    public void setTaxableExpenses(Property obj){
        objAmor.declarationsAM(obj);
        for(int i=1; i<yearsToPayOffBond*12+1;i++){
            TaxableExpenses[i] = Array.getDouble(getRatesTaxes(obj),i)+ Array.getDouble(getLevy(obj),i) + Array.getDouble(getBondFee(obj),i) + Array.getDouble(getMaintenance(obj),i)+ Array.getDouble(objAmor.getArrayInterest(obj),i);
        }
    }
    
    /**
     *
     * @param obj
     * @return 
    */ 
    public double[] getTaxableExpenses(Property obj){
        setTaxableExpenses(obj);
        objR.declarationsR(obj,objAmor);
        for(int i=0; i<yearsToPayOffBond*12+1;i++){
            System.out.println(i +" "+ TaxableExpenses[i]);
        }
        return TaxableExpenses;
    }
    
    
}
