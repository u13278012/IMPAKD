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
<<<<<<< HEAD
     * Defines a constant value for the number of months in a year
     */
    public static final double numberOfMonths = 12;
    public static final double hundredPercent = 100;
=======
     *
     * @param obj
     * @return 
    */ 
    public double[] getInterestIncome(Property obj){

        return InterestIncome;
    }
>>>>>>> master
    
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
    
<<<<<<< HEAD
    //Generate Rent Income
    public void generateRentIncome()
    {   
        for(int i = 0; i < property.getBond().getNumberOfYears(); i++)
        {
           for(int j = 0; j < numberOfMonths; j++)
           {
               if(i == 0)
               {
                    rentIncome[i] = property.getRental().getRentalAmount();
               }
               else
               {
                    rentIncome[i] = rentIncome[i-1] + (rentIncome[i-1] * (property.getIncreases().getRent()/hundredPercent));
               }
           }
=======
    /**
     *
     * @param obj
     * @return 
    */ 
    public double[] getGrossProfit(Property obj){
        setGrossProfit(obj);
        for(int i=0; i<yearsToPayOffBond*12+1;i++){
            System.out.println(i +" "+ GrossProfit[i]);
>>>>>>> master
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
    
<<<<<<< HEAD
    //Calculate Rates & Taxes
    public void generateRatesAndTaxes()
    {
        for(int i = 0; i < property.getBond().getNumberOfYears(); i++)
        {
           for(int j = 0; j < numberOfMonths; j++)
           {
               if(i == 0)
               {
                    ratesAndtaxes[i] = property.getExpenses().getRates_Taxes();
               }
               else
               {
                    ratesAndtaxes[i] = ratesAndtaxes[i-1] + (ratesAndtaxes[i-1] * (property.getIncreases().getRates_taxes()/hundredPercent));
               }
           }
        }
    }
    
    public double[] getRatesAndTaxes()
    {
        generateRatesAndTaxes();
        return ratesAndtaxes;
    }
    
    public void printRatesAndTaxes()
    {
        for(int i = 0; i < ratesAndtaxes.length; i++)
        {
            System.out.println(ratesAndtaxes[i]);
        }
    }
    
    //Calculate Levy
    public void generateLevy()
    {
        for(int i = 0; i < property.getBond().getNumberOfYears(); i++)
        {
           for(int j = 0; j < numberOfMonths; j++)
           {
               if(i == 0)
               {
                    levy[i] = property.getExpenses().getLevy();
               }
               else
               {
                    levy[i] = levy[i-1] + (levy[i-1] * (property.getIncreases().getLevy()/hundredPercent));
               }
           }
        }
    }
    
    public double[] getLevy()
    {
        generateLevy();
        return levy;
    }
    
    public void printLevy()
    {
        for(int i = 0; i < levy.length; i++)
        {
            System.out.println(levy[i]);
        }
    }
    
    //Calculate BondFee
    public void generateBondFee()
    {
        for(int i = 0; i < property.getBond().getNumberOfYears(); i++)
        {
           for(int j = 0; j < numberOfMonths; j++)
           {
               if(i == 0)
               {
                    bondFee[i] = property.getExpenses().getBondFee();
               }
               else
               {
                    bondFee[i] = bondFee[i-1] + (bondFee[i-1] * (property.getIncreases().getBondFee()/hundredPercent));
               }
           }
        }
    }
    
    public double[] getBondFee()
    {
        generateBondFee();
        return bondFee;
    }
    
    public void printBondFee()
    {
        for(int i = 0; i < bondFee.length; i++)
        {
            System.out.println(bondFee[i]);
        }
    }
=======
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
>>>>>>> master
    
    
    /******************************************* BondFee Calculations **************************************************/
    
}
