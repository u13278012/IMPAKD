/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Entities.Profile;
import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Diana
 */
public class ProfileFacadeRESTTest {
    
    public ProfileFacadeRESTTest() {
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
     * Test of edit method, of class ProfileFacadeREST.
     */
    @Test
    public void testEdit_GenericType() throws Exception {
        System.out.println("edit");
        Profile entity = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ProfileFacadeREST instance = (ProfileFacadeREST)container.getContext().lookup("java:global/classes/ProfileFacadeREST");
        instance.edit(entity);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class ProfileFacadeREST.
     */
    @Test
    public void testRemove_GenericType() throws Exception {
        System.out.println("remove");
        Profile entity = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ProfileFacadeREST instance = (ProfileFacadeREST)container.getContext().lookup("java:global/classes/ProfileFacadeREST");
        instance.remove(entity);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class ProfileFacadeREST.
     */
    @Test
    public void testFind_Object() throws Exception {
        System.out.println("find");
        Object id = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ProfileFacadeREST instance = (ProfileFacadeREST)container.getContext().lookup("java:global/classes/ProfileFacadeREST");
        Profile expResult = null;
        Profile result = instance.find(id);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findRange method, of class ProfileFacadeREST.
     */
    @Test
    public void testFindRange_intArr() throws Exception {
        System.out.println("findRange");
        int[] range = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ProfileFacadeREST instance = (ProfileFacadeREST)container.getContext().lookup("java:global/classes/ProfileFacadeREST");
        List<Profile> expResult = null;
        List<Profile> result = instance.findRange(range);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of count method, of class ProfileFacadeREST.
     */
    @Test
    public void testCount() throws Exception {
        System.out.println("count");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ProfileFacadeREST instance = (ProfileFacadeREST)container.getContext().lookup("java:global/classes/ProfileFacadeREST");
        int expResult = 0;
        int result = instance.count();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class ProfileFacadeREST.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Profile entity = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ProfileFacadeREST instance = (ProfileFacadeREST)container.getContext().lookup("java:global/classes/ProfileFacadeREST");
        instance.create(entity);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of edit method, of class ProfileFacadeREST.
     */
    @Test
    public void testEdit_Long_Profile() throws Exception {
        System.out.println("edit");
        Long id = null;
        Profile entity = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ProfileFacadeREST instance = (ProfileFacadeREST)container.getContext().lookup("java:global/classes/ProfileFacadeREST");
        instance.edit(id, entity);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class ProfileFacadeREST.
     */
    @Test
    public void testRemove_Long() throws Exception {
        System.out.println("remove");
        Long id = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ProfileFacadeREST instance = (ProfileFacadeREST)container.getContext().lookup("java:global/classes/ProfileFacadeREST");
        instance.remove(id);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class ProfileFacadeREST.
     */
    @Test
    public void testFind_Long() throws Exception {
        System.out.println("find");
        Long id = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ProfileFacadeREST instance = (ProfileFacadeREST)container.getContext().lookup("java:global/classes/ProfileFacadeREST");
        Profile expResult = null;
        Profile result = instance.find(id);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class ProfileFacadeREST.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ProfileFacadeREST instance = (ProfileFacadeREST)container.getContext().lookup("java:global/classes/ProfileFacadeREST");
        List<Profile> expResult = null;
        List<Profile> result = instance.findAll();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findRange method, of class ProfileFacadeREST.
     */
    @Test
    public void testFindRange_Integer_Integer() throws Exception {
        System.out.println("findRange");
        Integer from = null;
        Integer to = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ProfileFacadeREST instance = (ProfileFacadeREST)container.getContext().lookup("java:global/classes/ProfileFacadeREST");
        List<Profile> expResult = null;
        List<Profile> result = instance.findRange(from, to);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of countREST method, of class ProfileFacadeREST.
     */
    @Test
    public void testCountREST() throws Exception {
        System.out.println("countREST");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ProfileFacadeREST instance = (ProfileFacadeREST)container.getContext().lookup("java:global/classes/ProfileFacadeREST");
        String expResult = "";
        String result = instance.countREST();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of login method, of class ProfileFacadeREST.
     */
    @Test
    public void testLogin() throws Exception {
        System.out.println("login");
        String username = "";
        String lastname = "";
        String FirstName = "";
        String Email = "";
        String Password = "";
        String confrimPassword = "";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ProfileFacadeREST instance = (ProfileFacadeREST)container.getContext().lookup("java:global/classes/ProfileFacadeREST");
        instance.login(username, lastname, FirstName, Email, Password, confrimPassword);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
