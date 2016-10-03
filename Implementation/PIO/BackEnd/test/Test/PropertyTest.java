/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import Entities.Bond;
import Entities.Expenses;
import Entities.Increases;
import Entities.Profile;
import Entities.PropertyReserves;
import Entities.Rental;
import Entities.Reserves;
import Entities.UpFrontCosts;
import Entities.Property;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import service.PropertyFacadeREST;
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
public class PropertyTest {
    
PropertyFacadeREST property;
Property expectedp;
@Before
public void initialiseproperty(){
  property = new  PropertyFacadeREST(); 
  
}
@Test (expected = NullPointerException.class)
public void findProperty() throws Exception{
    Property p;
    p = property.find((long)33);
    
}

@Test (expected = NullPointerException.class)
public void getPropeties(){
  
     List<Property>  results;
     results =  property.getProperties(1,(long)8);
     for (Property c : results) {
       assertEquals("City property",c.getPropertyName());

    }
    
}

@Test(expected = ArithmeticException.class)
public void deleteProperty() throws Exception{
    Property p;
   
     property.deleteProperty(-1, (long)44);
    
}

@Test(expected = ArithmeticException.class)
public void addPropertyValidation() throws Exception{
    Property p;
    String propertyName ="University Of pretoria";
     property.addProperty(propertyName, -1, 1, 1, 4545, 4554, 4343, 888676, 55435, 4545, 75557, 7677, 6565, 86767, 6466546, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, (long)1);
    
}

}
