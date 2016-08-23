/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Entities.Property;
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
  ,@FormParam("interestRate") String interestRate,@FormParam("deposit") String deposit
  ,@FormParam("propertyValue") String propertyValue,@FormParam("numberOfYears") String numberOfYears
  ,@FormParam("bondRepaymnet") String bondRepaymnet,@FormParam("Period") String Period
  ,@FormParam("additionalCash") String additionalCash,@FormParam("onceOffPayment") String onceOffPayment
  ,@FormParam("maintenance") String maintenance,@FormParam("renovation") String renovation
  ,@FormParam("deviance") String deviance,@FormParam("rentInsurance") String rentInsurance
  ,@FormParam("conveyancingFees") String conveyancingFees,@FormParam("vatDebit") String vatDebit
  ,@FormParam("deedsFee") String deedsFee,@FormParam("initiationFee") String initiationFee
  ,@FormParam("tax") String tax,@FormParam("rates") String rates
 ,@FormParam("levy") String levy,@FormParam("inflation") String inflation
 ,@FormParam("propertyValueIncrease") String propertyValueIncrease,@FormParam("rentIncrease") String rentIncrease
 ,@FormParam("ratesIncrease") String ratesIncrease,@FormParam("taxIncrease") String taxIncrease
 ,@FormParam("bondFeeIncrease") String bondFeeIncrease,@FormParam("levyIncrease") String levyIncrease
 ,@FormParam("occupancyRate") String occupancyRate,@FormParam("agentCommission") String agentCommission
 ,@FormParam("rentalAmount") String rentalAmount){
     System.out.print(propertyName);
     System.out.print(marketPriceAdjustment);
      Property propertyObj = new Property();
      propertyObj.setPropertyName(propertyName);
      propertyObj.setMarketPriceAdjustment(marketPriceAdjustment);
      propertyObj.setCapitalGains(capitalGains);
      propertyObj.setAnnualMaintenanceCost(annualMaintenanceCost);
      propertyObj.setAnnualCostIncrease(annualCostIncrease);
    
      
 }
    
}
