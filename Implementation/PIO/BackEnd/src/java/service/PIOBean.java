/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

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
    
    //Bond Functions
    public double calculateDepositInRands()
    {
        
    }
    
}
