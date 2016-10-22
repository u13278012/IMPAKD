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
        Property obj = new Property();
        //test.getRentIncome(obj);
        //test.getGrossProfit(obj);
        test.getRatesTaxes(obj);
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
//        for(int i=0; i<yearsToPayOffBond*12+1;i++){
//            System.out.println(i +" "+ RentIncome[i]);
//        }
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
        for(int i=0; i<yearsToPayOffBond*12+1;i++){
            System.out.println(i +" "+ GrossProfit[i]);
        }
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
        for(int i=0; i<yearsToPayOffBond*12+1;i++){
            System.out.println(i +" "+ RatesTaxes[i]);
        }
        return RatesTaxes;
    }
    
    /******************************************* Levy Calculations **************************************************/
    
    
    /******************************************* BondFee Calculations **************************************************/
    
}
