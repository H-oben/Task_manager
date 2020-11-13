/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taskPackage;

import java.awt.Color;
import java.time.LocalDate;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Disabled;
import peoplePack.member;

/**
 *
 * @author h_obe
 */
public class SubtaskTest {
    
    public SubtaskTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getParent method, of class Subtask.
     */
    @Test
    public void testGetParent() {
        System.out.println("getParent");
        Task x = new Task();
        Subtask instance = new Subtask("test","",new Categories()
                ,new Color(0,0,0), LocalDate.now()
                ,new member(), new member(),x);
        x.addSubtask(instance);
        Task result = instance.getParent();
        assertEquals(x, result);
    }

    /**
     * Test of equals method, of class Subtask.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Subtask instance = new Subtask();
        Subtask x = instance;
        boolean expResult = true;
        boolean result = instance.equals(x);
        assertEquals(expResult, result);
        Subtask y = new Subtask("test","",new Categories()
                ,new Color(0,0,0), LocalDate.now()
                ,new member(), new member(),x);
        result = y.equals(x);
        assertEquals(result, false);
    }

    /**
     * Test of hashCode method, of class Subtask.
     */
    @Disabled("not neccesary")
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Subtask instance = new Subtask();
        int expResult = instance.hashCode();
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }
    
}
