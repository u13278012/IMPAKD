/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.*;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Diana
 */
public class PIOBeanTest {

    PIOBean pIOBean = lookupPIOBeanBean();
    
    public PIOBeanTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class PIOBean.
     */
    /*@Test
    public void testMain() throws Exception {
        System.out.println("main");
        String[] args = null;
        PIOBean.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    } */

    /**
     * Test of persist method, of class PIOBean.
     */
    /*@Test
    public void testPersist() throws Exception {
        System.out.println("persist");
        Object object = null;
        PIOBean instance = new PIOBean();
        instance.persist(object);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    } */

    /**
     * Test of register method, of class PIOBean.
     */
    /*@Test
    public void testRegister() throws Exception {
        System.out.println("register");
        Profile profile = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        PIOBeanLocal instance = (PIOBeanLocal)container.getContext().lookup("java:global/classes/PIOBean");
        instance.register(profile);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    } */

    /**
     * Test of login method, of class PIOBean.
     */
   /* @Test
    public void testLogin() throws Exception {
        System.out.println("login");
        String username = "";
        String password = "";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        PIOBeanLocal instance = (PIOBeanLocal)container.getContext().lookup("java:global/classes/PIOBean");
        Profile expResult = null;
        Profile result = instance.login(username, password);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    } */

    /**
     * Test of Expenses method, of class PIOBean.
     */
   // @Test
//    public void testExpenses() throws Exception {
//        System.out.println("Expenses");


//        PIOBean.Expenses();

       // PIOBean.Expenses();


//       PIOBean.Expenses();
       // PIOBean.Expenses();

        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of calculateDepositInRands method, of class PIOBean.
     * @throws java.lang.Exception
     */
   /* @Test
    public void testCalculateDepositInRands() throws Exception {
        System.out.println("calculateDepositInRands");
        PIOBean instance = new PIOBean();
        double expResult = 0.0;
        double result = instance.calculateDepositInRands();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    } */
    
    @Test
    public void avoidAnnoyingErrorMessageWhenRunningTestsInAnt() {
    assertTrue(true); // do nothing;
}
    
    @Test
    public void testGenerateIncomeStatement() throws Exception {
    System.out.println("Generate Rent Income Values");
   
    
            double[] expResult = new double[20];
            PIOBean instance = lookupPIOBeanBean();
            
            //Put Values in expResults
            for(int i = 0; i < 20; i++)
            {
                for(int j = 0; j < 12; j++)
                {
                    if(i == 0)
                    {
                        expResult[i] = 6700.0;
                    }
                    else
                    {
                        expResult[i] = expResult[i-1] + (expResult[i-1] * 6/100);
                    }
                }
            }
            
            double[] result = instance.generateIncomeStatement(instance.property);
            assertTrue(Arrays.equals(expResult, result));
        }

    private PIOBean lookupPIOBeanBean() {
        try {
            Context c = new InitialContext();
            return (PIOBean) c.lookup(PIOBean.class.getName());
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
    
