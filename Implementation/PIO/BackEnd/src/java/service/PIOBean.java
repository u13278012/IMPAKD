package service;
import Entities.*;
import Accounting.*;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Local;
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

    public PIOBean() 
    {
        //Create and initialise mock object
        property = new Property();
        
        UpFrontCosts upFrontCosts = new UpFrontCosts();
      
        upFrontCosts.setConveyancingFees(9535.91);
        upFrontCosts.setVatDebit(1310.42);
        upFrontCosts.setDeedsFees(740.0);
        upFrontCosts.setInitiationFee(5700.0);
      
        PropertyReserves reserves = new PropertyReserves();
        reserves.setMaintenance(5.0);
        reserves.setRenovation(7);
        reserves.setDeviance(0);
        reserves.setRentInsurance(0);
      
        Expenses expenses = new Expenses();
        expenses.setRates_Taxes(370.0);
      
        expenses.setLevy(534.5);
      
      
        Rental rental = new Rental();
        rental.setOccupancyRate(12.0);
        rental.setRentalAmount(6700.0);
        rental.setTotalRent(80400.0); // total rent is missing from the html page
      
        Increases increases = new Increases();
        increases.setInflation(7.0);
        increases.setLevy(8.0);
        increases.setRates_taxes(8.0);
        increases.setPropertyValue(5.0);
        increases.setBondFee(7.0);
        increases.setRent(6.0);
      
        Bond bondObj = new Bond();
        bondObj.setBondRepayment(5958.0);
        bondObj.setDepositInRands(159800.0);
        bondObj.setInterestRate(9.5);
        bondObj.setNumberOfYears(20);
        bondObj.setPropertyValue(799000.0);
      
        property.setIncreases(increases);
        property.setUpFrontCosts(upFrontCosts);
        property.setReserves(reserves);
        property.setRental(rental);
        property.setBond(bond);
        property.setExpenses(expenses);

    }
    
    
    @PersistenceContext(unitName = "BackEndPU")
    private EntityManager em;

    /**
     *
     * @param object
     */
    @Override
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
    @Override
    public double[] generateIncomeStatement(Property property)
    {
       incomeStatement = new accountingIncomeStatement(property);
       return incomeStatement.getRentIncome();
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
//        TypedQuery<Property> query = em.createQuery("SELECT a FROM Property a WHERE a.profile.id = "+id+"",Property.class);
//        property = query.getSingleResult();
        //Create a mock property object
        //Generate Income Statement
        generateIncomeStatement(property);
        
      
    }

}
