/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;


import Entities.Expenses;
import Entities.Increases;
import Entities.Bond;
import Entities.Profile;


import Entities.Property;
import Entities.Rental;


import Entities.Property;
import Entities.Rental;


import Entities.Property;

import Entities.Rental;








import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Kudzai
 */
@Stateless
public class PIOBean implements PIOBeanLocal {
    
    //Bond Object
    Bond bond;
    public static void main(String[] args) {
        double arrayTotalExpeneses[] = new double[20];
//        Expenses(arrayTotalExpeneses);
//        for(int i =0; i< 20; i++){
//            System.out.println(arrayTotalExpeneses[i]);
//        }
    }
    @PersistenceContext(unitName = "BackEndPU")
    private EntityManager em;

    /**
     *
     * @param object
     */
    public void persist(Object object) {
        em.persist(object);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    /**
     *
     * @param profile
     */

    @Override
    public void register(Profile profile) {
        persist(profile);
    }
     /**
     *
     * @param username
     * @param password
     * @return
     */
    @Override
    public Profile login(String username, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    /**
     * @param arrayTotalExpeneses
     * //@param obj
     * @return
     */
    //@Override
    static public double[] Expenses(/*Property obj */){
        //double rates_taxes, levy, bondFee;
        //double arrayTotalExpeneses[] = new double[20];
        double arrayTotalExpeneses[] = new double[20];
        
        //display totalExpenses
//         for(int i=0; i< 20; i++){
//             System.out.println(i + " " + arrayTotalExpeneses[i]);
//         }
         return arrayTotalExpeneses;
    }  
    
    static double Rental(double totalRent,double occupancyRate,double rentalAmount,double onceOffAgentFee){
        Rental rent = new Rental();
        
        //totalRent = rent.getTotalRent();
        occupancyRate = rent.getOccupancyRate();
        rentalAmount = rent.getRentalAmount();
        onceOffAgentFee = rent.getOnceOffAgentFee();
        
        totalRent = rentalAmount * (12.00 * occupancyRate);
        
        return totalRent;
        
    }
    //Bond Functions

    /**
     *
     * @return
     */
    public double calculateDepositInRands()
    {
        return 0.0;
    }

}
