/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Entities.Profile;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import service.ProfileFacadeREST;

/**
 *
 * @author Kudzai
 */
public class ProfileTest {
    
   ProfileFacadeREST profile;
    Profile expectedp;
    
    @Before
    public void initialiseproperty(){
      profile = new  ProfileFacadeREST(); 

    }
    @Test (expected = NullPointerException.class)
    public void findProfile() throws Exception{
        Profile p;
        p = profile.find((long)33);

    }

    @Test(expected = ArithmeticException.class)
    public void deleteProperty() throws Exception{
        Profile p;

         profile.deleteProfile(-1);

    }

    @Test(expected = ArithmeticException.class)
    public void retrievePropertiesTestValidation() throws Exception{
        Profile p;
         profile.retrieveProperties((long)-1);

    }
}
