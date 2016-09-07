/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import Entities.*;
import Accounting.*;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Kudzai
 */

@Stateless
public class PIOBean implements PIOBeanLocal {
    
    //Bond Object
    Bond bond;
    Property property;
    accountingIncomeStatement incomeStatement;
    
    public static void main(String[] args) {
        double arrayTotalExpeneses[] = new double[20];
        Expenses(arrayTotalExpeneses);
        for(int i =0; i< 20; i++){
            System.out.println(arrayTotalExpeneses[i]);
        }
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
    
    //Generate the income statement
    public void generateIncomeStatement(Property property)
    {
       incomeStatement = new accountingIncomeStatement(property);
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
     * @param id
     * @param arrayTotalExpeneses
     * //@param obj
     * @return
     */
    
    //@Override
    static public double[] Expenses(double arrayTotalExpeneses[]/*Property obj */){
        //double rates_taxes, levy, bondFee;
        //double arrayTotalExpeneses[] = new double[20];
        Expenses expenses = new Expenses();       
        Increases increasesPerYear = new Increases();
        double rates_taxes, levy, bondFee;
        
        rates_taxes = expenses.getRates_Taxes();/*obj.getExpenses().getRates_Taxes(); */
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
        
        //totalRent = rent.getTotalRent();
        occupancyRate = rent.getOccupancyRate();
        rentalAmount = rent.getRentalAmount();
        onceOffAgentFee = rent.getOnceOffAgentFee();
        
        totalRent = rentalAmount * (12.00 * occupancyRate);
        
        return totalRent;
        
    }
    
    @Override
    public void retrieveProperty(Long id)
    {
        TypedQuery<Property> query = em.createQuery("SELECT a FROM Property a WHERE a.profile.id = "+id+"",Property.class);
        property = query.getSingleResult();
    }

}
