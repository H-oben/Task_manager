import GUI.*;
import peoplePack.*;
import taskPackage.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import javax.swing.JTextArea;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author h_obe
 */
public class Tester {
    
    public Tester() {
    }

    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    @Test
    public void testMainAndLogin(){
        String expected = "Description:\nCreate tasks for employees to work on";
        mainFrame m = new mainFrame();
        m.setVisible(true);
        JTextArea inp = (JTextArea) TestUtils.getChildNamed(m,"DescrArea");
    }
}
