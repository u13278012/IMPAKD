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
    accountingIncomeStatement objIS;
    accountingAsset objA;
    
    int yearsToPayOffBond = 0;
    double bondPrincipleDebt[];
    double arrayEquity[];
    double retainedEarnings[];
    double roi[];
    
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
        retainedEarnings = new double[yearsToPayOffBond+1];
        roi = new double[yearsToPayOffBond+1];
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
        return bondPrincipleDebt;
    }
    
    /**
     *
     * @param obj
    */
    public  void setEquity(Property obj){
        for(int i=0; i<yearsToPayOffBond+1; i++){
            if(i == 0){
                arrayEquity[i] = objAmor.getDepositInRands(obj);
            }
            else{
                arrayEquity[i] = arrayEquity[i-1] +(1*Array.getDouble(objIS.getShortFallPerYear(obj),i));
            }           
        }
    }
    
    /**
     *
     * @param obj
     * @return
     */
    public  double[] getEquity(Property obj){
        setEquity(obj);
        for(int i = 0; i<yearsToPayOffBond+1; i++){
            arrayEquity[i] = Math.round(arrayEquity[i]);
        }
        return arrayEquity;
    }
    
    /**
     *
     * @param obj
    */
    public  void setRetainedEarnings(Property obj){
        getEndingBalancePerYear(obj);
        getEquity(obj);
        for(int i=0; i<yearsToPayOffBond+1; i++){
            retainedEarnings[i] = Array.getDouble(objAsset.getTotal(obj),i)- bondPrincipleDebt[i] - arrayEquity[i];
        }           
    }
   
    
    /**
     *
     * @param obj
     * @return
     */
    public  double[] getRetainedEarnings(Property obj){
        setRetainedEarnings(obj);
        for(int i = 0; i<yearsToPayOffBond+1; i++){
            retainedEarnings[i] = Math.round(retainedEarnings[i]);
        }
        return retainedEarnings;
    }
    /**
     *
     * @param obj
     */
    public void setRoi(Property obj) {
        getRetainedEarnings(obj);
        getEquity(obj);
        for(int i = 1; i<yearsToPayOffBond+1; i++){
            roi[i] = ((retainedEarnings[i]/arrayEquity[i] - 1) *100) / i;
        }
    }
    /**
     *
     * @param obj
     * @return
     */
    public double[] getRoi(Property obj) {
        setRoi(obj);
        for(int i = 0; i<yearsToPayOffBond+1; i++){
            roi[i] = Math.round(roi[i]);
        }
        return roi;
    }
}
