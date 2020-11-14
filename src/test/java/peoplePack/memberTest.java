package peoplePack;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Disabled;

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
        member x = instance;
        assertEquals(x.equals(instance),true);
    }

    /**
     * Test of hashCode method, of class member.
     */
    @Disabled("unused")
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        member instance = new member();
        int expResult = instance.hashCode();
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of testPassword method, of class member.
     */
    @Test
    public void testTestPassword() {
        System.out.println("testPassword");
        char[] a = "Password".toCharArray();
        member instance = new member();
        boolean expResult = false;
        boolean result = instance.testPassword(a);
        assertEquals(expResult, result);
        assertEquals(instance.testPassword("password".toCharArray()),true);
    }

    /**
     * Test of getRole method, of class member.
     */
    @Test
    public void testGetRole() {
        System.out.println("getRole");
        member instance = new member();
        Role expResult = Role.MEMBER;
        Role result = instance.getRole();
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class member.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        member instance = new member();
        String expResult = "empty empty";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class member.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String f = "not";
        String l = "empty";
        member instance = new member();
        instance.setName(f, l);
        assertEquals(instance.getName().equals(f+" "+l),true);
    }

    /**
     * Test of assignTeam method, of class member.
     */
    @Test
    public void testAssignTeam() {
        System.out.println("assignTeam");
        Manager a = new Manager();
        member instance = new member();
        instance.assignTeam(a);;
        assertEquals(instance.getTeam().equals(a),true);
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
    }
    
}
