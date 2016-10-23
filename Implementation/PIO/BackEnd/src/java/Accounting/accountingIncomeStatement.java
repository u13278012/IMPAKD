package Accounting;
import Entities.Property;
import java.lang.reflect.Array;

/**
 *
 * @author Priscilla, Diana
 */

public class accountingIncomeStatement 
{   
    AmortizationTableBond objAmor;
    ReservesCalculations objRe;
        
    int yearsToPayOffBond;
    double incomeTax;
    
    double cashPerYear[];
    double CashPerYear;
    
    double rentIncome;
    double rentIncrease;
    
    double rates_taxes;
    double rates_taxesIncrease;
    
    double levy;
    double levyIncrease;
    
    double bondFee;
    double bondFeeIncrease ;
    
     
    double RentIncome[]; 
    double rentIncYearly[];
    
    double InterestIncome[];
    double GrossProfit[];
    
    double RatesTaxes[];
    double ratesTaxesIncYearly[];
    
    double Levy[];
    double levyTaxesIncYearly[];
    
    double BondFee[];
    double bondFeeTaxesIncYearly[];
    
    double maintenance[];
    double TaxableExpenses[];
    double PreTaxIncome[];
    double TaxableProfit[];
    double TaxableProfitAccumulated[];
    double PayTax[];
    double NetIncome[];
    double Cash[];
    double ShortFall[];
    double ShortFallPerYear;
    double shortFallPerYear[];
    
    /**
     *
     * @param obj
     * @param objAmor
     * @param objRe
    */
    public void declarationsInc(Property obj, AmortizationTableBond objAmor,ReservesCalculations objRe){
        this.objAmor = objAmor;
        this.objRe = objRe;
        
        yearsToPayOffBond = obj.getBond().getNumberOfYears();
        incomeTax = 36.00/100.00;
        CashPerYear = 0;

        rentIncome = obj.getRental().getRentalAmount();
        rentIncrease = obj.getIncreases().getRent();

        rates_taxes = obj.getExpenses().getRates_Taxes();
        rates_taxesIncrease = obj.getIncreases().getRates_taxes();

        levy = obj.getExpenses().getLevy();
        levyIncrease = obj.getIncreases().getLevy();

        bondFee = obj.getExpenses().getBondFee();
        bondFeeIncrease = obj.getIncreases().getBondFee();


        cashPerYear = new double[yearsToPayOffBond+1];
        RentIncome = new double[yearsToPayOffBond*12+1]; 
        rentIncYearly = new double[yearsToPayOffBond+1];

        InterestIncome = new double[yearsToPayOffBond*12+1];
        GrossProfit = new double[yearsToPayOffBond*12+1];

        RatesTaxes = new double[yearsToPayOffBond*12+1];
        ratesTaxesIncYearly = new double[yearsToPayOffBond+1];

        Levy = new double[yearsToPayOffBond*12+1];
        levyTaxesIncYearly = new double[yearsToPayOffBond+1];

        BondFee = new double[yearsToPayOffBond*12+1];
        bondFeeTaxesIncYearly = new double[yearsToPayOffBond+1];

        maintenance = new double[yearsToPayOffBond*12+1];
        TaxableExpenses = new double[yearsToPayOffBond*12+1];
        PreTaxIncome = new double[yearsToPayOffBond*12+1];
        TaxableProfit = new double[yearsToPayOffBond*12+1];
        TaxableProfitAccumulated = new double[yearsToPayOffBond*12+1];
        PayTax = new double[yearsToPayOffBond*12+1];
        NetIncome = new double[yearsToPayOffBond*12+1];
        Cash = new double[yearsToPayOffBond*12+1];
        ShortFall = new double[yearsToPayOffBond*12+1];
        ShortFallPerYear = 0.0;
        shortFallPerYear = new double[yearsToPayOffBond*12+1];
        
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
        /*Not needed */
    }
    /**
     *
     * @param obj
     * @return 
    */ 
    public double[] getInterestIncome(Property obj){
        setInterestIncome(obj);
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
        return maintenance;
    }
    
    /******************************************* taxableExpense Calculations **************************************************/
    /**
     *
     * @param obj
    */ 
    public void setTaxableExpenses(Property obj){
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
        return TaxableExpenses;
    }
    /******************************************* pre-Tax Income Calculations **************************************************/
    /**
     *
     * @param obj
    */ 
    public void setPreTaxIncome(Property obj){
        for(int i=1; i<yearsToPayOffBond*12+1;i++){
            PreTaxIncome[i] = Array.getDouble(getGrossProfit(obj),i) - Array.getDouble(getTaxableExpenses(obj),i) - Array.getDouble(objAmor.getArrayPrinciple(obj),i);
        }
    }

    /**
     *
     * @param obj
     * @return 
    */ 
    public double[] getPreTaxIncome(Property obj){
        setPreTaxIncome(obj);
        return PreTaxIncome;
    }
    /******************************************* Taxable Profit Calculations **************************************************/
    /**
     *
     * @param obj
    */ 
    public void setTaxableProfit(Property obj){
        for(int i=1; i<yearsToPayOffBond*12+1;i++){
            TaxableProfit[i] = Array.getDouble(getGrossProfit(obj),i) - Array.getDouble(getTaxableExpenses(obj),i);
        }
    }

    /**
     *
     * @param obj
     * @return 
    */ 
    public double[] getTaxableProfit(Property obj){
        setTaxableProfit(obj);
        return TaxableProfit;
    }
    /******************************************* Taxable Profit Accumulated Calculations **************************************************/
    /**
     *
     * @param obj
    */ 
    public void setTaxableProfitAccumulated(Property obj){
        for(int i=1; i<yearsToPayOffBond*12+1;i++){
            TaxableProfit[i] = Array.getDouble(getGrossProfit(obj),i) - Array.getDouble(getTaxableExpenses(obj),i);
        }
        
        /* calculating taxableProfitAccumulated here*/
        for(int i=1; i<yearsToPayOffBond*12+1;i++){
            TaxableProfitAccumulated[i] = TaxableProfitAccumulated[i-1] + TaxableProfit[i];
        }
    }

    /**
     *
     * @param obj
     * @return 
    */ 
    public double[] getTaxableProfitAccumulated(Property obj){
        setTaxableProfitAccumulated(obj);
        return TaxableProfitAccumulated;
    }
    
    /******************************************* Pay Tax Calculations **************************************************/
    /**
     *
     * @param obj
    */ 
    public void setPayTax(Property obj){
        for(int i=1; i<yearsToPayOffBond*12+1;i++){
            TaxableProfit[i] = Array.getDouble(getGrossProfit(obj),i) - Array.getDouble(getTaxableExpenses(obj),i);
        }
        for(int i=1; i<yearsToPayOffBond*12+1;i++){
            TaxableProfitAccumulated[i] = TaxableProfitAccumulated[i-1] + TaxableProfit[i];
        }
        
        /* calculating payTax here*/
        for(int i=1; i<yearsToPayOffBond*12+1;i++){
            if((i%6)==0){
                PayTax[i] = TaxableProfitAccumulated[i]*incomeTax;
            }
        }
    }

    /**
     *
     * @param obj
     * @return 
    */ 
    public double[] getPayTax(Property obj){
        setPayTax(obj);
        for(int i=0; i<yearsToPayOffBond*12+1;i++){
            PayTax[i] = Math.round(PayTax[i]);
        }
        return PayTax;
    }
    
     /******************************************* Net Income Calculations **************************************************/
    /**
     *
     * @param obj
    */ 
    public void setNetIncome(Property obj){
        for(int i=1; i<yearsToPayOffBond*12+1;i++){
            GrossProfit[i] = Array.getDouble(getRentIncome(obj),i) + Array.getDouble(getInterestIncome(obj),i);
        }
        for(int i=1; i<yearsToPayOffBond*12+1;i++){
            TaxableExpenses[i] = Array.getDouble(getRatesTaxes(obj),i)+ Array.getDouble(getLevy(obj),i) + Array.getDouble(getBondFee(obj),i) + Array.getDouble(getMaintenance(obj),i)+ Array.getDouble(objAmor.getArrayInterest(obj),i);
        }
        for(int i=1; i<yearsToPayOffBond*12+1;i++){
            TaxableProfit[i] = GrossProfit[i] - TaxableExpenses[i];
        }
        for(int i=1; i<yearsToPayOffBond*12+1;i++){
            TaxableProfitAccumulated[i] = TaxableProfitAccumulated[i-1] + TaxableProfit[i];
        }
        for(int i=1; i<yearsToPayOffBond*12+1;i++){
            if((i%6)==0){
                PayTax[i] = TaxableProfitAccumulated[i]*incomeTax;
            }
        }
        
        /* calculating netIncome here*/
        for(int i=1; i<yearsToPayOffBond*12+1;i++){
            NetIncome[i] = (GrossProfit[i] - TaxableExpenses[i] - Array.getDouble(objAmor.getArrayPrinciple(obj),i)) - Math.max(PayTax[i], 0);
        }
    }

    /**
     *
     * @param obj
     * @return 
    */ 
    public double[] getNetIncome(Property obj){
        setNetIncome(obj);
        for(int i=0; i<yearsToPayOffBond*12+1;i++){
            NetIncome[i] = Math.round(NetIncome[i]);
        }
        return NetIncome;
    }
    
    /******************************************* Cash Calculations **************************************************/
    /**
     *
     * @param obj
    */ 
    public void setCash_ShortFall(Property obj){
        for(int i=1; i<yearsToPayOffBond*12+1;i++){
            GrossProfit[i] = Array.getDouble(getRentIncome(obj),i) + Array.getDouble(getInterestIncome(obj),i);
        }
        for(int i=1; i<yearsToPayOffBond*12+1;i++){
            TaxableExpenses[i] = Array.getDouble(getRatesTaxes(obj),i)+ Array.getDouble(getLevy(obj),i) + Array.getDouble(getBondFee(obj),i) + Array.getDouble(getMaintenance(obj),i)+ Array.getDouble(objAmor.getArrayInterest(obj),i);
        }
        for(int i=1; i<yearsToPayOffBond*12+1;i++){
            TaxableProfit[i] = GrossProfit[i] - TaxableExpenses[i];
        }
        for(int i=1; i<yearsToPayOffBond*12+1;i++){
            TaxableProfitAccumulated[i] = TaxableProfitAccumulated[i-1] + TaxableProfit[i];
        }
        for(int i=1; i<yearsToPayOffBond*12+1;i++){
            if((i%6)==0){
                PayTax[i] = TaxableProfitAccumulated[i]*incomeTax;
            }
        }
        for(int i=1; i<yearsToPayOffBond*12+1;i++){
            NetIncome[i] = (GrossProfit[i] - TaxableExpenses[i] - Array.getDouble(objAmor.getArrayPrinciple(obj),i)) - Math.max(PayTax[i], 0);
        }
        
        for(int i=0; i<yearsToPayOffBond*12+1;i++){
            if(NetIncome[i]<0.0){
                ShortFall[i] = -(NetIncome[i]);
            }
        }
        
        /* calculating cash here*/
        for(int i=1; i<yearsToPayOffBond*12+1;i++){
            Cash[i] =Cash[i-1] + NetIncome[i] +(1*ShortFall[i-1]) - (Math.min(PayTax[i], 0));
        }
    }

    /**
     *
     * @param obj
     * @return 
    */ 
    public double[] getCash(Property obj){
        setCash_ShortFall(obj);
        for(int i=0; i<yearsToPayOffBond*12+1;i++){
            Cash[i] = Math.round(Cash[i]);
        }
        return Cash;
    }
    /**
     *
     * @param obj
    */ 
    public  void setCashPerYear(Property obj){
        for(int i=1; i<yearsToPayOffBond*12+1;i++){
            GrossProfit[i] = Array.getDouble(getRentIncome(obj),i) + Array.getDouble(getInterestIncome(obj),i);
        }
        for(int i=1; i<yearsToPayOffBond*12+1;i++){
            TaxableExpenses[i] = Array.getDouble(getRatesTaxes(obj),i)+ Array.getDouble(getLevy(obj),i) + Array.getDouble(getBondFee(obj),i) + Array.getDouble(getMaintenance(obj),i)+ Array.getDouble(objAmor.getArrayInterest(obj),i);
        }
        for(int i=1; i<yearsToPayOffBond*12+1;i++){
            TaxableProfit[i] = GrossProfit[i] - TaxableExpenses[i];
        }
        for(int i=1; i<yearsToPayOffBond*12+1;i++){
            TaxableProfitAccumulated[i] = TaxableProfitAccumulated[i-1] + TaxableProfit[i];
        }
        for(int i=1; i<yearsToPayOffBond*12+1;i++){
            if((i%6)==0){
                PayTax[i] = TaxableProfitAccumulated[i]*incomeTax;
            }
        }
        for(int i=1; i<yearsToPayOffBond*12+1;i++){
            NetIncome[i] = (GrossProfit[i] - TaxableExpenses[i] - Array.getDouble(objAmor.getArrayPrinciple(obj),i)) - Math.max(PayTax[i], 0);
        }
        
        for(int i=0; i<yearsToPayOffBond*12+1;i++){
            if(NetIncome[i]<0.0){
                ShortFall[i] = -(NetIncome[i]);
            }
        }
        
        /* calculating cash here*/
        for(int i=1; i<yearsToPayOffBond*12+1;i++){
            Cash[i] =Cash[i-1] + NetIncome[i] +(1*ShortFall[i-1]) - (Math.min(PayTax[i], 0));
        }
  
        int number = 1;
        int count = 0;
        int k=1;
        /*calculate Cash per year from Cash array that calculated Cash per month */
        for(int i=1; i<yearsToPayOffBond*12+1;i++){ 
            if(i< 12*number+1){
                count = count +1;
                CashPerYear += Cash[i];
                if(count == 12){
                    count = 0;                    
                    if(k < yearsToPayOffBond+1){
                        cashPerYear[k] = CashPerYear;
                    }
                    number++;
                    k++;
                    CashPerYear = 0;
                }
            }          
        }

    }
    
     /**
     *
     * @param obj
     * @return
     */
    public double[] getCashPerYear(Property obj){
        setCashPerYear(obj);
        for(int i=0; i<yearsToPayOffBond+1;i++){
            if(cashPerYear[i]<0.0){
                cashPerYear[i] = 0.0;
            }
            cashPerYear[i] = Math.round(cashPerYear[i]);
        }   
        return cashPerYear;
    }
    
    /**
     *
     * @param obj
     * @return 
    */ 
    public double[] getShortFall(Property obj){

        for(int i=1; i<yearsToPayOffBond*12+1;i++){
            GrossProfit[i] = Array.getDouble(getRentIncome(obj),i) + Array.getDouble(getInterestIncome(obj),i);
        }
        for(int i=1; i<yearsToPayOffBond*12+1;i++){
            TaxableExpenses[i] = Array.getDouble(getRatesTaxes(obj),i)+ Array.getDouble(getLevy(obj),i) + Array.getDouble(getBondFee(obj),i) + Array.getDouble(getMaintenance(obj),i)+ Array.getDouble(objAmor.getArrayInterest(obj),i);
        }
        for(int i=1; i<yearsToPayOffBond*12+1;i++){
            TaxableProfit[i] = GrossProfit[i] - TaxableExpenses[i];
        }
        for(int i=1; i<yearsToPayOffBond*12+1;i++){
            TaxableProfitAccumulated[i] = TaxableProfitAccumulated[i-1] + TaxableProfit[i];
        }
        for(int i=1; i<yearsToPayOffBond*12+1;i++){
            if((i%6)==0){
                PayTax[i] = TaxableProfitAccumulated[i]*incomeTax;
            }
        }
        for(int i=1; i<yearsToPayOffBond*12+1;i++){
            NetIncome[i] = (GrossProfit[i] - TaxableExpenses[i] - Array.getDouble(objAmor.getArrayPrinciple(obj),i)) - Math.max(PayTax[i], 0);
        }
        
        for(int i=0; i<yearsToPayOffBond*12+1;i++){
            if(NetIncome[i]<0.0){
                ShortFall[i] = -(NetIncome[i]);
            }
        }
        for(int i=0; i<yearsToPayOffBond*12+1;i++){
            ShortFall[i] = Math.round(ShortFall[i]);
        }
        return ShortFall;
    }
    
    /**
     *
     * @param obj
    */ 
    public  void setShortFallPerYear(Property obj){
        for(int i=1; i<yearsToPayOffBond*12+1;i++){
            GrossProfit[i] = Array.getDouble(getRentIncome(obj),i) + Array.getDouble(getInterestIncome(obj),i);
        }
        for(int i=1; i<yearsToPayOffBond*12+1;i++){
            TaxableExpenses[i] = Array.getDouble(getRatesTaxes(obj),i)+ Array.getDouble(getLevy(obj),i) + Array.getDouble(getBondFee(obj),i) + Array.getDouble(getMaintenance(obj),i)+ Array.getDouble(objAmor.getArrayInterest(obj),i);
        }
        for(int i=1; i<yearsToPayOffBond*12+1;i++){
            TaxableProfit[i] = GrossProfit[i] - TaxableExpenses[i];
        }
        for(int i=1; i<yearsToPayOffBond*12+1;i++){
            TaxableProfitAccumulated[i] = TaxableProfitAccumulated[i-1] + TaxableProfit[i];
        }
        for(int i=1; i<yearsToPayOffBond*12+1;i++){
            if((i%6)==0){
                PayTax[i] = TaxableProfitAccumulated[i]*incomeTax;
            }
        }
        for(int i=1; i<yearsToPayOffBond*12+1;i++){
            NetIncome[i] = (GrossProfit[i] - TaxableExpenses[i] - Array.getDouble(objAmor.getArrayPrinciple(obj),i)) - Math.max(PayTax[i], 0);
        }
        
        for(int i=0; i<yearsToPayOffBond*12+1;i++){
            if(NetIncome[i]<0.0){
                ShortFall[i] = -(NetIncome[i]);
            }
        }
        /* calculating cash here*/
        for(int i=1; i<yearsToPayOffBond*12+1;i++){
            Cash[i] =Cash[i-1] + NetIncome[i] +(1*ShortFall[i-1]) - (Math.min(PayTax[i], 0));
        }
  
        int number = 1;
        int count = 0;
        int k=1;
        /*calculate Shortfall per year from ShortFall array that calculated shortFall per month */
        for(int i=1; i<yearsToPayOffBond*12+1;i++){ 
            if(i< 12*number+1){
                count = count +1;
                ShortFallPerYear += ShortFall[i];
                if(count == 12){
                    count = 0;                    
                    if(k < yearsToPayOffBond+1){
                        shortFallPerYear[k] = ShortFallPerYear;
                    }
                    number++;
                    k++;
                    ShortFallPerYear = 0;
                }
            }          
        }

    }
    
     /**
     *
     * @param obj
     * @return
     */
    public double[] getShortFallPerYear(Property obj){
        setShortFallPerYear(obj);
        for(int i=0; i<yearsToPayOffBond+1;i++){
            shortFallPerYear[i] = Math.round(shortFallPerYear[i]);
        }   
        return shortFallPerYear;
    }
}
