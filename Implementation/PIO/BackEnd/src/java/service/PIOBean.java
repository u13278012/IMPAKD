package service;
import Entities.*;
import Accounting.*;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Kudzai
 */

@Stateless
public class PIOBean implements PIOBeanLocal {
    
    Property property;    
    AmortizationTableBond objAmor = new AmortizationTableBond();
    accountingExpenses objExp = new accountingExpenses();
    accountingAsset objAss = new accountingAsset();
    accountingRental objRental = new accountingRental();
    accountingIncomeStatement objIS = new accountingIncomeStatement();
    ReservesCalculations objRE = new ReservesCalculations();
    accountingLiabilities objLi = new accountingLiabilities();
            
//    public static void main(String[] args) {
//        PIOBean objTest = new PIOBean();
//        Long id = new Long(1);
////         property = objTest.retrieveProperty(Long.MIN_VALUE);
//        //AssetTotal(property);
//        //AssetCapitalGains(property);
//        //objTest.RentTotal(property);
//        objTest.ReturnOnInvestment(id);
//    }
    

    public PIOBean() 
    {
        //Create and initialise mock object

//        property = new Property();
//        
//        UpFrontCosts upFrontCosts = new UpFrontCosts();
//      
//        upFrontCosts.setConveyancingFees(9535.91);
//        upFrontCosts.setVatDebit(1310.42);
//        upFrontCosts.setDeedsFees(740.0);
//        upFrontCosts.setInitiationFee(5700.0);
//      
//        PropertyReserves reserves = new PropertyReserves();
//        reserves.setMaintenance(5.0);
//        reserves.setRenovation(7);
//        reserves.setDeviance(0);
//        reserves.setRentInsurance(0);
//      
//        Expenses expenses = new Expenses();
//        expenses.setRates_Taxes(370.0);  
//        expenses.setLevy(534.5);
//        expenses.setBondFee(57);
//      
//      
//        Rental rental = new Rental();
//        rental.setOccupancyRate(12.0);
//        rental.setRentalAmount(6700.0);
//        rental.setTotalRent(80400.0); // total rent is missing from the html page
//      
//        Increases increases = new Increases();
//        increases.setInflation(7.0);
//        increases.setLevy(8.0);
//        increases.setRates_taxes(8.0);
//        increases.setPropertyValue(5.0);
//        increases.setBondFee(7.0);
//        increases.setRent(6.0);
//      
//        Bond bondObj = new Bond();
//        bondObj.setBondRepayment(5958.0);
//        bondObj.setDepositInRands(159800.0);
//        bondObj.setInterestRate(9.5);
//        bondObj.setNumberOfYears(20);
//        bondObj.setPropertyValue(799000.0);
//      
//        property.setIncreases(increases);
//        property.setUpFrontCosts(upFrontCosts);
//        property.setReserves(reserves);
//        property.setRental(rental);
////        property.setBond(bond);
//        property.setExpenses(expenses);
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
//       incomeStatement = new accountingIncomeStatement(property);
//       return incomeStatement.getRentIncome();
        return null;
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
    
    public double[] ReturnOnInvestment(Long profile, Long propertyID)
    {
        property = retrieveProperty(profile, propertyID);
//                System.out.println(property.getBond());
//        System.out.println(property.getCapitalGains());
//        System.out.println(property.getExpenses());
//        System.out.println(property.getId());
//        System.out.println(property.getMarketPriceAdjustment());
//        System.out.println(property.getIncreases());
//        System.out.println(property.getProfileID());
//        System.out.println(property.getPropertyName());
//        System.out.println(property.getRental());
//        System.out.println(property.getReserves());
//        System.out.println(property.getUpFrontCosts());
        
        objAmor.declarationsAM(property);
       
//        System.out.println("getPropertyValue"+property.getBond().getPropertyValue());
//        System.out.println("getNumberOfYears"+property.getBond().getNumberOfYears());
       
        System.out.println("propertyValue"+objAmor.propertyValue);
        System.out.println("yearsToPayOffBond"+objAmor.yearsToPayOffBond);
        objAss.declarationsAss(property,objIS,objAmor,objRE,objRental);
        System.out.println("2");
        objLi.declarationsL(property, objAmor, objAss,objRE,objRental);
        System.out.println("3");
        objExp.declarationsEx(property, objAmor);
        System.out.println("4");
        objRental.declarationsR(property, objAmor);
        System.out.println("5");
        objRE.declarationsReserves(property, objAmor, objRental);
        System.out.println("6");
        objIS.declarationsInc(property, objAmor, objRE,objRental);
        System.out.println("7");
        System.out.println(objLi.toString());
        double[] roi = objLi.getRoi(property);
       
       System.out.println("8");
        
        for(int i = 0; i<roi.length; i++)
        {
            System.out.println(i+". "+roi[i]);
        }
        return roi;
    }
    

    /**
     * @param id
     * @return
     */
//    @Override
//    public double[] Expenses(Long id){
//        property = retrieveProperty(id);
//        
//        objAmor.declarationsAM(property);
//        objExp.declarationsEx(property, objAmor);
//        objAss.declarationsAss(property,objIS);
//        return objExp.getTotalExpenses(property);        
//    } 
    
    /**
     * @param obj
     * @return
     */
    @Override
    public double[] AssetCapitalGains(Property obj){
        //return objAss.getCapitalGains(obj);
       return null;
    }
    
     /**
     * @param obj
     * @return
     */
    @Override
    public double[] AssetTotal(Property obj){
//        return objAss.getTotal(obj);
        return null;
    }
    
    /**
     * @param id
     * @return
     */
//    @Override
//    public double[] RentTotal(Long id){
//        property = retrieveProperty(id);
//        
//        objAmor.declarationsAM(property);
//        objExp.declarationsEx(property, objAmor);
//        objAss.declarationsAss(property,objIS);
//        objRental.declarationsR(property, objAmor);
//        
//        return objRental.getTotalRent(property);
//    }
    
    @Override
    public Property retrieveProperty(Long profile, Long property)
    {
        TypedQuery<Property> query = em.createQuery("SELECT a FROM Property a WHERE a.profile.id = "+profile+" AND a.id = "+property+" ",Property.class);
        Property propertyObj = query.getSingleResult();
        return propertyObj;
//        Create a mock property object
//        Generate Income Statement
//        generateIncomeStatement(property);
        
      
    }

}
