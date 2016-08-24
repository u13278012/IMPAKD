/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Entities.Property;
import Entities.Reserves;
import Entities.UpFrontCosts;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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

    @PersistenceContext(unitName = "BackEndPU")
    private EntityManager em;

    public PropertyFacadeREST() {
        super(Property.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Property entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Long id, Property entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Property find(@PathParam("id") Long id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Property> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Property> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
  
 @Path("/addProperty")
 @POST
 @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
 @Produces(MediaType.APPLICATION_JSON)
 public void login(@FormParam("propertyName") String propertyName,@FormParam("marketPriceAdjustment") double marketPriceAdjustment
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
 ,@FormParam("levy") double levy,@FormParam("inflation") double inflation
 ,@FormParam("propertyValueIncrease") double propertyValueIncrease,@FormParam("rentIncrease") double rentIncrease
 ,@FormParam("ratesIncrease") double ratesIncrease,@FormParam("taxIncrease") double taxIncrease
 ,@FormParam("bondFeeIncrease") double bondFeeIncrease,@FormParam("levyIncrease") double levyIncrease
 ,@FormParam("occupancyRate") double occupancyRate,@FormParam("agentCommission") double agentCommission
 ,@FormParam("rentalAmount") double rentalAmount){
     System.out.print(propertyName);
     System.out.print(marketPriceAdjustment);
      Property propertyObj = new Property();
      
      propertyObj.setPropertyName(propertyName);
      propertyObj.setMarketPriceAdjustment(marketPriceAdjustment);
      propertyObj.setCapitalGains(capitalGains);
    //propertyObj.setAnnualMaintenanceCost(annualMaintenanceCost);
    //propertyObj.setAnnualCostIncrease(annualCostIncrease);
      
      UpFrontCosts upFrontCostsObj = new UpFrontCosts();
      
      upFrontCostsObj.setConveyancingFees(conveyancingFees);
      upFrontCostsObj.setVatDebit(vatDebit);
      upFrontCostsObj.setDeedsFees(deedsFee);
      upFrontCostsObj.setInitiationFee(initiationFee);
      
      Reserves reservesObj = new Reserves();
      reservesObj.setMaintenacePerYear(maintenance);
      
      
     

    
      
 }
    
}
