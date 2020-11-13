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
import org.junit.jupiter.api.Disabled;

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
        Categories instance = new Categories();
        Categories x = instance;
        boolean expResult = true;
        boolean result = instance.equals(x);
        assertEquals(expResult, result);
        x = new Categories("different");
        assertEquals(x.equals(instance), false);
    }

    /**
     * Test of hashCode method, of class Categories.
     */
    @Disabled("not needed")
    @org.junit.Test
    public void testHashCode() {
        System.out.println("hashCode");
        Categories instance = new Categories();
        int expResult = instance.hashCode();
        int result = instance.hashCode();
        assertEquals(expResult, result);
        
    }
    
}
