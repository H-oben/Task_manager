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
public class MemberManagerExceptionTest {
    
    public MemberManagerExceptionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getCode method, of class MemberManagerException.
     */
    @Test
    public void testGetCode() {
        System.out.println("getCode");
MemberManagerException instance = new MemberManagerException("first","second");
        String expResult = "first";
        String result = instance.getCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCode method, of class MemberManagerException.
     */
    @Test
    public void testSetCode() {
        System.out.println("setCode");
        String c = "third";
        MemberManagerException instance = new MemberManagerException("first","second");
        String expResult = "third";  
        assertNotEquals(expResult,instance.getCode());
        instance.setCode(c);
        assertEquals(expResult,instance.getCode());
    }
    
}
