/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Accounting;

/**
 *
 * @author Diana
 */
public class upFrontCosts {
    double conveyancingFees = 9535.91;  
    double vatDebit = 1310.42;
    double deedsFees = 740.00;
    double initiationFee = 5700.00;
    double totalUpFrontCosts = 0.00;

    public void setUpFrontCosts(){
        totalUpFrontCosts = conveyancingFees + vatDebit + deedsFees + initiationFee + totalUpFrontCosts;
    }
    
    public double getUpFrontCosts(){
        setUpFrontCosts();
        return totalUpFrontCosts;
    }   
}
