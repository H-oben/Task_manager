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
public class RoleTest {
    
    public RoleTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of values method, of class Role.
     */
    @Test
    public void testValues() {
        System.out.println("values");
        Role[] expResult = {Role.MANAGER, Role.TEAMLEAD, Role.MEMBER};
        Role[] result = Role.values();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of valueOf method, of class Role.
     */
    @Test
    public void testValueOf() {
        System.out.println("valueOf");
        String string = "MANAGER";
        Role expResult = Role.MANAGER;
        Role result = Role.valueOf(string);
        assertEquals(expResult, result);
    }
    
}
