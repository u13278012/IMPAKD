package Accounting;
import Entities.Property;

/**
 *
 * @author Priscilla
 */

public class accountingIncomeStatement 
{
    double[] rentIncome;
    double[] interestIncome;
    double[] grossProfit;
    double[] ratesAndtaxes;
    double[] levy;
    double[] bondFee;
    double[] maintenance;
    double[] tenantRenewalExpense;
    double[] taxableExpenses;
    double[] preTaxIncome;
    double[] taxableProfit;
    double[] taxableProfitAccumulated;
    double[] payTax;
    double[] netIncome;
    double[] cash;
    double[] shortFall;
    
    Property property;

    /**
     * Defines a constant value for the number of months in a year
     */
    public static final double numberOfMonths = 12;
    public static final double hundredPercent = 100;
    
    public accountingIncomeStatement(Property property) 
    {
        this.property = property;
    }
    
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
        }
    }
    
    public double[] getRentIncome()
    {
        generateRentIncome();
        return rentIncome;
    }
    
    public void printRentIncome()
    {
        for(int i = 0; i < rentIncome.length; i++)
        {
            System.out.println(rentIncome[i]);
        }
    }
    
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
        for(int i = 0; i < ratesAndtaxes.length; i++)
        {
            System.out.println(ratesAndtaxes[i]);
        }
    }
    
    
    
    
    
}
