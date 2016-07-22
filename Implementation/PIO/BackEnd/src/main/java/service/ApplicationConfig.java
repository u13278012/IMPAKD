/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Kudzai Muranga
 */
@javax.ws.rs.ApplicationPath("rs")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.impakd.backend.NewCrossOriginResourceSharingFilter.class);
        resources.add(service.AdditionalBondRepaymentFacadeREST.class);
        resources.add(service.AuthenticationFacadeREST.class);
        resources.add(service.BondFacadeREST.class);
        resources.add(service.ExpensesFacadeREST.class);
        resources.add(service.IncreasesFacadeREST.class);
        resources.add(service.PersonFacadeREST.class);
        resources.add(service.ProfileFacadeREST.class);
        resources.add(service.PropertyFacadeREST.class);
        resources.add(service.RentalFacadeREST.class);
        resources.add(service.ReportFacadeREST.class);
        resources.add(service.ReservesFacadeREST.class);
        resources.add(service.StatisticsFacadeREST.class);
        resources.add(service.UpFrontCostsFacadeREST.class);
    }
    
}
