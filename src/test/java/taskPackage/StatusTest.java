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
public class StatusTest {
    
    public StatusTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of values method, of class Status.
     */
    @Test
    public void testValues() {
        System.out.println("values");
        Status[] expResult = {Status.NOT_STARTED,
            Status.IN_PROGRESS,
            Status.COMPLETE,
            Status.OVERDUE,
            Status.DUE_SOON};
        Status[] result = Status.values();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of valueOf method, of class Status.
     */
    @Test
    public void testValueOf() {
        System.out.println("valueOf");
        String string = "NOT_STARTED";
        Status expResult = Status.NOT_STARTED;
        Status result = Status.valueOf(string);
        assertEquals(expResult, result);
    }
    
}
