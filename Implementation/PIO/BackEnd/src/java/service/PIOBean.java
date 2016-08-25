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
    
    @PersistenceContext(unitName = "BackEndPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void register(Profile profile) {
        persist(profile);
    }

    @Override
    public Profile login(String username, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    public void Expenses(){
        double rates_taxes, levy, managementFee;
        Expenses expenses = new Expenses();       
        Increases increasesPerYear = new Increases();
        
        rates_taxes = expenses.getRates_Taxes();
        levy = expenses.getLevy();    
        
        int arrayRates_Taxes[] = new int[20];
        int arrayLevy[] = new int[20];
        //int arrayManagementFee[] = new int[20];
        
        // array for rates & taxes
        for(int i=0; i< 20; i++){
            if( i == 0){
                arrayRates_Taxes[i] = (int) rates_taxes; 
            }
            else{
                arrayRates_Taxes[i] = (int) rates_taxes * (int) increasesPerYear.getRates_taxes();
            }
        }
        
        //array for levy
        for(int i =0; i<20; i++){
            if( i == 0){
                arrayLevy[i] = (int) levy; 
            }
            else{
                arrayLevy[i] = (int) levy * (int) increasesPerYear.getLevy();
            }
        }
 
    }  

    //Bond Functions
    public double calculateDepositInRands()
    {
        return 0.0;
    }
}
