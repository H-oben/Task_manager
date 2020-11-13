/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taskPackage;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author h_obe
 */
public class CategoriesTest {
    
    public CategoriesTest() {
    }

    @org.junit.BeforeClass
    public static void setUpClass() throws Exception {
    }

    @org.junit.AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     * Test of setCategory method, of class Categories.
     */
    @org.junit.Test
    public void testSetCategory() {
        System.out.println("setCategory");
        String s = "notEmpty";
        Categories instance = new Categories("notEmpty");
        instance.setCategory(s);
        assertEquals(instance.toString(), s);
    }

    /**
     * Test of toString method, of class Categories.
     */
    @org.junit.Test
    public void testToString() {
        System.out.println("toString");
        Categories instance = new Categories();
        String expResult = "empty";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Categories.
     */
    @org.junit.Test
    public void testEquals() {
        System.out.println("equals");
        Object o = null;
        Categories instance = new Categories();
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Categories.
     */
    @org.junit.Test
    public void testHashCode() {
        System.out.println("hashCode");
        Categories instance = new Categories();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
