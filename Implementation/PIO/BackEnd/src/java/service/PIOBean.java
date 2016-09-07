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
    
    @Override
    public void retrieveProperty(Long id)
    {
        TypedQuery<Property> query = em.createQuery("SELECT a FROM Property a WHERE a.profile.id = "+id+"",Property.class);
        property = query.getSingleResult();
    }

}
