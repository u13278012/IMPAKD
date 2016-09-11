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
                    rentIncome[i] = rentIncome[i-1] + (rentIncome[i-1] * (property.getIncreases().getRent()/100));
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
    
    
    
    
    
}
