package Accounting;

import Entities.Property;

/**
 *
 * @author Diana
 */
public class upFrontCosts {
    double conveyancingFees;  
    double vatDebit;
    double deedsFees;
    double initiationFee;
    double totalUpFrontCosts;
    
    /**
     *
     * @param obj
    */  
    public void declarationsAM(Property obj){ 
        conveyancingFees = obj.getUpFrontCosts().getConveyancingFees();  
        vatDebit = obj.getUpFrontCosts().getVatDebit();
        deedsFees = obj.getUpFrontCosts().getDeedsFees();
        initiationFee = obj.getUpFrontCosts().getInitiationFee();
        totalUpFrontCosts = 0.00;
    }
    /**
     *
     * @
    */ 
    public void setUpFrontCosts(){
        totalUpFrontCosts = conveyancingFees + vatDebit + deedsFees + initiationFee + totalUpFrontCosts;
    }
    /**
     *
     * @return 
     * @
    */ 
    public double getUpFrontCosts(){
        setUpFrontCosts();
        return totalUpFrontCosts;
    }   
}
