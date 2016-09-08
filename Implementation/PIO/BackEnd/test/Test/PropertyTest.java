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
public void deletePropertyUnitTest() throws Exception{
    Property p;
    p = property.find((long)2);
    
  //s  assertEquals("check if it returns the right property", null,p);

}


}
