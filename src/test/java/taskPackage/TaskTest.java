package taskPackage;

import java.awt.Color;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Disabled;
import peoplePack.Manager;
import peoplePack.Person;
import peoplePack.member;

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
        Subtask s = new Subtask();
        Task instance = new Task();
        assertEquals(instance.getNumberOfSubTasks(),0);
        instance.addSubtask(s);
        assertEquals(instance.getNumberOfSubTasks(),1);
    }

    /**
     * Test of setName method, of class Task.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String n = "notEmpty";
        Task instance = new Task();
        instance.setName(n);
        assertEquals(instance.getName(), n);
    }

    /**
     * Test of setDescription method, of class Task.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String d = "new description";
        Task instance = new Task();
        instance.setDescription(d);
        assertEquals(instance.describe(), d);
    }

    /**
     * Test of setStatus method, of class Task.
     */
    @Test
    public void testSetStatus() {
        System.out.println("setStatus");
        Status s = Status.IN_PROGRESS;
        Task instance = new Task();
        assertEquals(instance.getStatus(), Status.NOT_STARTED);
        instance.setStatus(s);
        assertEquals(instance.getStatus(),s);
    }

    /**
     * Test of setCatagory method, of class Task.
     */
    @Test
    public void testSetCatagory() {
        System.out.println("setCatagory");
        Categories c = new Categories("Admin");
        Task instance = new Task();
        assertNotEquals(instance.getCategory(),c);
        instance.setCatagory(c);
        assertEquals(instance.getCategory(),c);
    }

    /**
     * Test of setDueDate method, of class Task.
     */
    @Test
    public void testSetDueDate() {
        System.out.println("setDueDate");
        LocalDate ld = LocalDate.of(2020,01,01);
        Task instance = new Task();
        instance.setDueDate(ld);
        assertEquals(instance.getDueDate(),ld); // date correctness testing done in GUI
        
    }

    /**
     * Test of reassign method, of class Task.
     */
    @Test
    public void testReassign() {
        System.out.println("reassign");
        Person a = new member();
        Task instance = new Task();
        instance.reassign(a);
        assertEquals(instance.assignment(),a);
    }

    /**
     * Test of setColor method, of class Task.
     */
    @Test
    public void testSetColor() {
        System.out.println("setColor");
        Color a = Color.BLACK;
        Task instance = new Task();
        assertNotEquals(instance.getColor(),a);
        instance.setColor(a);
        assertEquals(instance.getColor(),a);
    }

    /**
     * Test of getTask method, of class Task.
     */
    @Test
    public void testGetTask() {
        System.out.println("getTask");
        int index = 0;
        Task instance = new Task();
        Subtask expResult = new Subtask();
        instance.addSubtask(expResult);
        Subtask result = instance.getTask(index);
        assertEquals(expResult, result);
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
        instance.addSubtask(new Subtask());
        assertEquals(instance.getNumberOfSubTasks(),1);
    }

    /**
     * Test of getName method, of class Task.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Task instance = new Task();
        String expResult = "empty";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of describe method, of class Task.
     */
    @Test
    public void testDescribe() {
        System.out.println("describe");
        Task instance = new Task();
        String expResult = "empty";
        String result = instance.describe();
        assertEquals(expResult, result);
    }

    /**
     * Test of getStatus method, of class Task.
     */
    @Test
    public void testGetStatus() {
        System.out.println("getStatus");
        Task instance = new Task();
        Status expResult = Status.NOT_STARTED;
        Status result = instance.getStatus();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDueDate method, of class Task.
     */
    @Test
    public void testGetDueDate() {
        System.out.println("getDueDate");
        Task instance = new Task();
        LocalDate expResult = LocalDate.now();
        LocalDate result = instance.getDueDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of createdOn method, of class Task.
     */
    @Test
    public void testCreatedOn() {
        System.out.println("createdOn");
        Task instance = new Task();
        LocalDate expResult = LocalDate.now();
        LocalDate result = instance.createdOn();
        assertEquals(expResult, result);
    }

    /**
     * Test of assignment method, of class Task.
     */
    @Test
    public void testAssignment() {
        System.out.println("assignment");
        Task instance = new Task();
        Manager x = new Manager();
        assertNotEquals(instance.assignment(),x);
        instance.reassign(x);
        assertEquals(instance.assignment(),x);
    }

    /**
     * Test of creator method, of class Task.
     */
    @Test
    public void testCreator() {
        System.out.println("creator");
        Manager x = new Manager();
        Task instance = new Task("empty","empty",new Categories(), Color.BLACK, LocalDate.now(), new member(),x);
        Person result = instance.creator();
        assertEquals(x, result);
    }

    /**
     * Test of getColor method, of class Task.
     */
    @Test
    public void testGetColor() {
        System.out.println("getColor");
        Task instance = new Task();
        Color expResult = Color.RED;
        Color result = instance.getColor();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCategory method, of class Task.
     */
    @Test
    public void testGetCategory() {
        System.out.println("getCategory");
        Task instance = new Task();
        Categories expResult = new Categories();
        Categories result = instance.getCategory();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSubtasks method, of class Task.
     */
    @Test
    public void testGetSubtasks() {
        System.out.println("getSubtasks");
        Task instance = new Task();
        ArrayList<Subtask> result = instance.getSubtasks();
        assertEquals(0, result.size());
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
    }

    /**
     * Test of toString method, of class Task.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Task t = new Task();
        String expResult = "Task: " + t.getName() +"\nDescription: " +t.describe()+"\n"
                + "Status: " + t.getStatus().toString() +"\nColor: "+t.getColor().toString()
                +"\nCatagory: "+ t.getCategory().toString()
                + "\nDue Date: " +t.getDueDate().toString() +
                "\nCreated On: " +t.createdOn().toString()+
                "\nAssigned To: "+ t.assignment().getName()+
                "\nCreated By: "+t.creator().getName();
        String result = t.toString();
        assertEquals(expResult, result);
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
        Task t = instance;
        assertEquals(t.equals(t), true);
    }

    /**
     * Test of hashCode method, of class Task.
     */
    @Disabled("not necccesary")
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Task instance = new Task();
        int expResult = instance.hashCode();
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }
    
}
