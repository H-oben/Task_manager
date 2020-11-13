/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taskPackage;

import java.awt.Color;
import java.time.LocalDate;
import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Disabled;
import peoplePack.Person;

/**
 *
 * @author h_obe
 */
public class TaskTest {
    
    public TaskTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of addSubtask method, of class Task.
     */
    @Test
    public void testAddSubtask() {
        System.out.println("addSubtask");
        Subtask s = null;
        Task instance = new Task();
        instance.addSubtask(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class Task.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String n = "";
        Task instance = new Task();
        instance.setName(n);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDescription method, of class Task.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String d = "";
        Task instance = new Task();
        instance.setDescription(d);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStatus method, of class Task.
     */
    @Test
    public void testSetStatus() {
        System.out.println("setStatus");
        Status s = null;
        Task instance = new Task();
        instance.setStatus(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCatagory method, of class Task.
     */
    @Test
    public void testSetCatagory() {
        System.out.println("setCatagory");
        Categories c = null;
        Task instance = new Task();
        instance.setCatagory(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDueDate method, of class Task.
     */
    @Test
    public void testSetDueDate() {
        System.out.println("setDueDate");
        LocalDate ld = null;
        Task instance = new Task();
        instance.setDueDate(ld);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of reassign method, of class Task.
     */
    @Test
    public void testReassign() {
        System.out.println("reassign");
        Person a = null;
        Task instance = new Task();
        instance.reassign(a);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setColor method, of class Task.
     */
    @Test
    public void testSetColor() {
        System.out.println("setColor");
        Color a = null;
        Task instance = new Task();
        instance.setColor(a);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTask method, of class Task.
     */
    @Test
    public void testGetTask() {
        System.out.println("getTask");
        int index = 0;
        Task instance = new Task();
        Subtask expResult = null;
        Subtask result = instance.getTask(index);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumberOfSubTasks method, of class Task.
     */
    @Test
    public void testGetNumberOfSubTasks() {
        System.out.println("getNumberOfSubTasks");
        Task instance = new Task();
        int expResult = 0;
        int result = instance.getNumberOfSubTasks();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class Task.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Task instance = new Task();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of describe method, of class Task.
     */
    @Test
    public void testDescribe() {
        System.out.println("describe");
        Task instance = new Task();
        String expResult = "";
        String result = instance.describe();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStatus method, of class Task.
     */
    @Test
    public void testGetStatus() {
        System.out.println("getStatus");
        Task instance = new Task();
        Status expResult = null;
        Status result = instance.getStatus();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDueDate method, of class Task.
     */
    @Test
    public void testGetDueDate() {
        System.out.println("getDueDate");
        Task instance = new Task();
        LocalDate expResult = null;
        LocalDate result = instance.getDueDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createdOn method, of class Task.
     */
    @Test
    public void testCreatedOn() {
        System.out.println("createdOn");
        Task instance = new Task();
        LocalDate expResult = null;
        LocalDate result = instance.createdOn();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of assignment method, of class Task.
     */
    @Test
    public void testAssignment() {
        System.out.println("assignment");
        Task instance = new Task();
        Person expResult = null;
        Person result = instance.assignment();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of creator method, of class Task.
     */
    @Test
    public void testCreator() {
        System.out.println("creator");
        Task instance = new Task();
        Person expResult = null;
        Person result = instance.creator();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getColor method, of class Task.
     */
    @Test
    public void testGetColor() {
        System.out.println("getColor");
        Task instance = new Task();
        Color expResult = null;
        Color result = instance.getColor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCategory method, of class Task.
     */
    @Test
    public void testGetCategory() {
        System.out.println("getCategory");
        Task instance = new Task();
        Categories expResult = null;
        Categories result = instance.getCategory();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSubtasks method, of class Task.
     */
    @Test
    public void testGetSubtasks() {
        System.out.println("getSubtasks");
        Task instance = new Task();
        ArrayList<Subtask> expResult = null;
        ArrayList<Subtask> result = instance.getSubtasks();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of contains method, of class Task.
     */
    @Test
    public void testContains() {
        System.out.println("contains");
        Subtask s = null;
        Task instance = new Task();
        boolean expResult = false;
        boolean result = instance.contains(s);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hasDescendants method, of class Task.
     */
    @Test
    public void testHasDescendants() {
        System.out.println("hasDescendants");
        Task instance = new Task();
        boolean expResult = false;
        boolean result = instance.hasDescendants();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Task.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Task instance = new Task();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Task.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = null;
        Task instance = new Task();
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Task.
     */
    @Disabled("not necccesary")
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Task instance = new Task();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
