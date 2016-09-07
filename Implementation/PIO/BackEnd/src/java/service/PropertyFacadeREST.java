/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import Entities.Bond;
import Entities.Expenses;
import Entities.Increases;
import Entities.Profile;
import Entities.Property;
import Entities.PropertyReserves;
import Entities.Rental;
import Entities.Reserves;
import Entities.UpFrontCosts;
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
 * @author Khumalo
 */
@Stateless
@Path("property")
public class PropertyFacadeREST extends AbstractFacade<Property> {
   
    @EJB
    private PIOBeanLocal pIOBean;
    
    @PersistenceContext(unitName = "BackEndPU")
    private EntityManager em;

    /**
     *
     */
    public PropertyFacadeREST() {
        super(Property.class);
    }

    /**
     *
     * @param entity
     */
    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Property entity) {
        super.create(entity);
    }

    /**
     *
     * @param id
     * @param entity
     */
    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Long id, Property entity) {
        super.edit(entity);
    }

    /**
     *
     * @param id
     */
    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }

    /**
     *
     * @param id
     * @return
     */
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Property find(@PathParam("id") Long id) {
        return super.find(id);
    }

    /**
     *
     * @return
     */
    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Property> findAll() {
        return super.findAll();
    }

    /**
     *
     * @param from
     * @param to
     * @return
     */
    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Property> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    /**
     *
     * @return
     */
    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    /**
     *
     * @return
     */
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
  
 @Path("/addProperty")
 @POST
 @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
 @Produces(MediaType.APPLICATION_JSON)
 public void addProperty(@FormParam("propertyName") String propertyName,@FormParam("marketPriceAdjustment") double marketPriceAdjustment
  ,@FormParam("capitalGains") double capitalGains,@FormParam("annualMaintenanceCost") double annualMaintenanceCost,@FormParam("annualCostIncrease") double annualCostIncrease
  ,@FormParam("interestRate") double interestRate,@FormParam("deposit") double deposit
  ,@FormParam("propertyValue") double propertyValue,@FormParam("numberOfYears") int numberOfYears
  ,@FormParam("bondRepaymnet") double bondRepaymnet,@FormParam("Period") int Period
  ,@FormParam("additionalCash") double additionalCash,@FormParam("onceOffPayment") double onceOffPayment
  ,@FormParam("maintenance") double maintenance,@FormParam("renovation") double renovation
  ,@FormParam("deviance") double deviance,@FormParam("rentInsurance") double rentInsurance
  ,@FormParam("conveyancingFees") double conveyancingFees,@FormParam("vatDebit") double vatDebit
  ,@FormParam("deedsFee") double deedsFee,@FormParam("initiationFee") double initiationFee
  ,@FormParam("tax") double tax,@FormParam("rates") double rates
 ,@FormParam("levy") double levy,@FormParam("managementFee") double managementFee,@FormParam("inflation") double inflation
 ,@FormParam("propertyValueIncrease") double propertyValueIncrease,@FormParam("rentIncrease") double rentIncrease
 ,@FormParam("ratesIncrease") double ratesIncrease,@FormParam("taxIncrease") double taxIncrease
 ,@FormParam("bondFeeIncrease") double bondFeeIncrease,@FormParam("levyIncrease") double levyIncrease
 ,@FormParam("occupancyRate") double occupancyRate,@FormParam("agentCommission") double agentCommission
 ,@FormParam("rentalAmount") double rentalAmount,@FormParam("profileID") Long profileID){
     System.out.print(profileID);
     System.out.print(marketPriceAdjustment);
     
     Property propertyObj = new Property();
      

      UpFrontCosts upFrontCostsObj = new UpFrontCosts();
      
      upFrontCostsObj.setConveyancingFees(conveyancingFees);
      upFrontCostsObj.setVatDebit(vatDebit);
      upFrontCostsObj.setDeedsFees(deedsFee);
      upFrontCostsObj.setInitiationFee(initiationFee);
      
      PropertyReserves reservesObj = new PropertyReserves();
      reservesObj.setMaintenance(maintenance);
      reservesObj.setRenovation(renovation);
      reservesObj.setDeviance(deviance);
      reservesObj.setRentInsurance(rentInsurance);
      reservesObj.setMinReserves(maintenance);// minireserves is missing from the html page
      
      Expenses expensesObj = new Expenses();
      expensesObj.setRates_Taxes(tax);
      
      expensesObj.setLevy(levy);
      
      
      Rental rentalObj = new Rental();
      rentalObj.setOccupancyRate(occupancyRate);
      rentalObj.setOnceOffAgentFee(onceOffPayment);// onceOffPayment is missing from the html page
      rentalObj.setRentalAmount(rentalAmount);
      rentalObj.setTotalRent(rentalAmount); // total rent is missing from the html page
      rentalObj.setAgentCommission(agentCommission);
      
      Increases increasesObj = new Increases();
      increasesObj.setInflation(inflation);
      increasesObj.setLevy(levyIncrease);
      increasesObj.setRates_taxes(taxIncrease);
      increasesObj.setPropertyValue(propertyValueIncrease);
      increasesObj.setBondFee(bondFeeIncrease);
      increasesObj.setRent(rentIncrease);
      
      Bond bondObj = new Bond();
      bondObj.setBondRepayment(bondRepaymnet);
      bondObj.setDepositInRands(deposit);
      bondObj.setInterestRate(interestRate);
      bondObj.setNumberOfYears(numberOfYears);
      bondObj.setPropertyValue(propertyValue);
     
      
      
      propertyObj.setPropertyName(propertyName);
      propertyObj.setMarketPriceAdjustment(marketPriceAdjustment);
      propertyObj.setCapitalGains(capitalGains);
    //  propertyObj.setProfileID(profileID);
     
      pIOBean.persist(upFrontCostsObj);
      pIOBean.persist(reservesObj);
      pIOBean.persist(expensesObj);
      pIOBean.persist(rentalObj);
      pIOBean.persist(bondObj);
      pIOBean.persist(increasesObj);
      TypedQuery<Profile> query = em.createQuery("SELECT a FROM Profile a WHERE a.id= "+profileID+" ",Profile.class);
       Profile profile = query.getSingleResult();
      

      propertyObj.setIncreases(increasesObj);
      propertyObj.setUpFrontCosts(upFrontCostsObj);
      propertyObj.setReserves(reservesObj);
      propertyObj.setRental(rentalObj);
      propertyObj.setBond(bondObj);
      propertyObj.setExpenses(expensesObj);
      propertyObj.setProfile(profile);
      pIOBean.persist(propertyObj);

    }
 @Path("/getPropertyDetails")
 @POST
 @Consumes(MediaType.APPLICATION_FORM_URLENCODED)

 @Produces(MediaType.APPLICATION_XML)
  public  List<Property> addProperty(@FormParam("profileID") int profileID){

  TypedQuery<Property> query = em.createQuery("SELECT a FROM Property a WHERE a.profile.id = "+profileID+"",Property.class);
      List<Property> p = query.getResultList();
      
      return p;
      
  }
    

      
      
     

  @GET
  @Path("retrieveProperties/{id}")
  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
  @Produces({MediaType.APPLICATION_XML})
  public List<Property> retrieveProperties(@PathParam("id") Long id) {
      TypedQuery<Property> query = em.createQuery("SELECT a FROM Property a WHERE a.profile.id = "+id+"",Property.class);
      List<Property> p = query.getResultList();
      
      return p;
  }  
      
}
 


