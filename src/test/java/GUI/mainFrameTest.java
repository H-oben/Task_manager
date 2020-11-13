/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.time.LocalDate;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import taskPackage.Task;

/**
 *
 * @author h_obe
 */
public class mainFrameTest {
    
    public mainFrameTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }

    /**
     * Test of getToday method, of class mainFrame.
     */
    @Test
    public void testGetToday() {
        System.out.println("getToday");
        mainFrame instance = new mainFrame();
        LocalDate expResult = LocalDate.now();
        LocalDate result = instance.getToday();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setTaskOptions method, of class mainFrame.
     */
    @Test
    public void testSetTaskOptions() {
        System.out.println("setTaskOptions");
        mainFrame instance = new mainFrame();
        ArrayList<Task> expResult = null;
        ArrayList<Task> result = instance.setTaskOptions();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of setTableTop method, of class mainFrame.
     */
    @Test
    public void testSetTableTop() {
        System.out.println("setTableTop");
        mainFrame instance = new mainFrame();
        boolean expResult = true;
        boolean result = instance.setTableTop();
        assertEquals(expResult, result);
        
    }    
}
