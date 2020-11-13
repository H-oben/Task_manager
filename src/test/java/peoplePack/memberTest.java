/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peoplePack;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author h_obe
 */
public class memberTest {
    
    public memberTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of equals method, of class member.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = null;
        member instance = new member();
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class member.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        member instance = new member();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of testPassword method, of class member.
     */
    @Test
    public void testTestPassword() {
        System.out.println("testPassword");
        char[] a = null;
        member instance = new member();
        boolean expResult = false;
        boolean result = instance.testPassword(a);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRole method, of class member.
     */
    @Test
    public void testGetRole() {
        System.out.println("getRole");
        member instance = new member();
        Role expResult = null;
        Role result = instance.getRole();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class member.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        member instance = new member();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class member.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String f = "";
        String l = "";
        member instance = new member();
        instance.setName(f, l);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of assignTeam method, of class member.
     */
    @Test
    public void testAssignTeam() {
        System.out.println("assignTeam");
        Manager a = null;
        member instance = new member();
        instance.assignTeam(a);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTeam method, of class member.
     */
    @Test
    public void testGetTeam() {
        System.out.println("getTeam");
        member instance = new member();
        Manager expResult = null;
        Manager result = instance.getTeam();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of inTeam method, of class member.
     */
    @Test
    public void testInTeam() {
        System.out.println("inTeam");
        member instance = new member();
        boolean expResult = false;
        boolean result = instance.inTeam();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
