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
    
    
    Property property;
    
    public accountingIncomeStatement(Property property) 
    {
        this.property = property;
    }
    
    
    
}
