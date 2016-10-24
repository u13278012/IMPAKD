/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Entities.Profile;
import Entities.Property;
import javax.ejb.Local;

/**
 *
 * @author Kudzai
 */
@Local
public interface PIOBeanLocal {

    /**
     *
     * @param profile
     */
    void register(Profile profile);

    /**
     *
     * @param username
     * @param password
     * @return
     */
    Profile login(String username, String password);
    //public double[] Expenses(Property obj);
    public void persist(Object object);

    public Property retrieveProperty(Long profile, Long property);

    public double[] generateIncomeStatement(Property property);

    public double[] AssetCapitalGains(Property obj);

//    public double[] Expenses(Long id);

    public double[] AssetTotal(Property obj);
    
//    public double[] RentTotal(Long id);
    public double[] ReturnOnInvestment(Long profile, Long propertyID);
    
}
