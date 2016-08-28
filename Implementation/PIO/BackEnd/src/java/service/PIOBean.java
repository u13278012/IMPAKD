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
<<<<<<< HEAD
import Entities.Property;
=======
import Entities.Rental;
>>>>>>> 941e04cc0d05b30d4dc3486545a7a28ea455ee4e
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
        Expenses(arrayTotalExpeneses);
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
     * @param arrayTotalExpeneses[]
     * @return
     */
    static public double[] Expenses(double arrayTotalExpeneses[]){
        //double rates_taxes, levy, bondFee;
        Expenses expenses = new Expenses();       
        Increases increasesPerYear = new Increases();
        double rates_taxes, levy, bondFee;
        
        rates_taxes = expenses.getRates_Taxes();
        levy = expenses.getLevy(); 
        bondFee = expenses.getBondFee(); 
        
        double arrayRates_Taxes[] = new double[20];
        double arrayLevy[] = new double[20];
        double arrayBondFee[] = new double[20];
       // arrayTotalExpeneses[20];// = new double[20]; 
        
        double totalRates_Taxes[] = new double[20];
        double totalLevy[] = new double[20];
        double totalBondFee[] = new double[20];
        
        //increases per year for rates&taxes
        for(int i=0; i< 20; i++){
            if( i == 0){
                arrayRates_Taxes[i] = rates_taxes; 
            }
            else{
                arrayRates_Taxes[i] =  arrayRates_Taxes[i-1] * increasesPerYear.getRates_taxes() + arrayRates_Taxes[i-1];
            }
        }
        //total rates&taxes for each year
        for(int i=0; i<20; i++){
           // System.out.println(i + " " + Math.round(arrayRates_Taxes[i] * 12));
           totalRates_Taxes[i] = Math.round(arrayRates_Taxes[i] * 12);
        }
        
        //increases per year for levy 
        for(int i =0; i<20; i++){
            if( i == 0){
                arrayLevy[i] = levy; 
            }
            else{
                arrayLevy[i] = arrayLevy[i-1] * increasesPerYear.getLevy() + arrayLevy[i-1];
            }
        }
        //total levy for each year
        for(int i=0; i<20; i++){
           // System.out.println(i + " " + Math.round(arrayLevy[i] * 12));
              totalLevy[i] = Math.round(arrayLevy[i] * 12);
        }
        
        //increases per year for bondFee
        for(int i =0; i<20; i++){
            if( i == 0){
                arrayBondFee[i] = bondFee; 
            }
            else{
                arrayBondFee[i] = arrayBondFee[i-1] * increasesPerYear.getBondFee() + arrayBondFee[i-1];
            }
        }
        //total bondFee for each year
        for(int i=0; i<20; i++){
            //System.out.println(i + " " + Math.round(arrayBondFee[i] * 12));
            totalBondFee[i] = Math.round(arrayBondFee[i] * 12);
        }
        
        //total expenses yearly
        for(int i=0; i< 20; i++){
            arrayTotalExpeneses[i] = totalLevy[i] + totalBondFee[i] + totalRates_Taxes[i];
        }
        //display totalExpenses
//         for(int i=0; i< 20; i++){
//             System.out.println(i + " " + arrayTotalExpeneses[i]);
//         }
         return arrayTotalExpeneses;
    }  
    
    static double Rental(double totalRent,double occupancyRate,double rentalAmount,double onceOffAgentFee){
        Rental rent = new Rental();
        
        totalRent = rent.getTotalRent();
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
