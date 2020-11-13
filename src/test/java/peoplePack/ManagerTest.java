/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peoplePack;

import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author h_obe
 */
public class ManagerTest {
    
    public ManagerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getTeamMembers method, of class Manager.
     */
    @Test
    public void testGetTeamMembers() {
        System.out.println("getTeamMembers");
        Manager instance = new Manager();
        ArrayList<Person> expResult = null;
        ArrayList<Person> result = instance.getTeamMembers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addTeamMember method, of class Manager.
     */
    @Test
    public void testAddTeamMember() {
        System.out.println("addTeamMember");
        member a = null;
        Manager instance = new Manager();
        boolean expResult = false;
        boolean result = instance.addTeamMember(a);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findTeamMember method, of class Manager.
     */
    @Test
    public void testFindTeamMember() {
        System.out.println("findTeamMember");
        Person a = null;
        Manager instance = new Manager();
        boolean expResult = false;
        boolean result = instance.findTeamMember(a);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of testPassword method, of class Manager.
     */
    @Test
    public void testTestPassword() {
        System.out.println("testPassword");
        char[] a = null;
        Manager instance = new Manager();
        boolean expResult = false;
        boolean result = instance.testPassword(a);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRole method, of class Manager.
     */
    @Test
    public void testGetRole() {
        System.out.println("getRole");
        Manager instance = new Manager();
        Role expResult = null;
        Role result = instance.getRole();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class Manager.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Manager instance = new Manager();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class Manager.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String f = "";
        String l = "";
        Manager instance = new Manager();
        instance.setName(f, l);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Manager.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        Manager instance = new Manager();
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Manager.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Manager instance = new Manager();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
