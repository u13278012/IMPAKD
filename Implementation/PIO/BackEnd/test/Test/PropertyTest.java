/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Entities.Property;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import service.PropertyFacadeREST;

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
    p = property.find((long)1);
    
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
     property.addProperty(propertyName, -1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, (long)1);
    
}

}
