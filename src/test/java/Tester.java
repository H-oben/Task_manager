import GUI.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import peoplePack.*;
import taskPackage.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
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
    // The methods must be annotated with annotation @Test.
    
    //<editor-fold desc="Login testing" defaultstate="collapsed">
    //tests login failure
    @Test
    public void testLoginFailure(){
        String expected = "LoginFailed";
        mainFrame m = new mainFrame();
        m.setVisible(true);
        
        loginCreationMenu inp = (loginCreationMenu) TestUtils.getChildNamed(m,"loginMenu");
        assertNotNull(inp);
        
        JTextField username = (JTextField)TestUtils.getChildNamed(inp, "NameInput");
        assertNotNull(username);
        username.setText("Admin Admin");
        
        JPasswordField pass = (JPasswordField) TestUtils.getChildNamed(inp, "PassInput");
        assertNotNull(pass);
        pass.setText("Admin"); //wrong password
        
        JComboBox role = (JComboBox) TestUtils.getChildNamed(inp, "TypeBox");
        assertNotNull(role);
        role.setSelectedIndex(1); //0=member, 1=Manager, 2=Team lead
        
        JLabel loginFail = (JLabel) TestUtils.getChildNamed(inp, "LoginFail");
        assertNotNull(loginFail);
        
        JButton login = (JButton) TestUtils.getChildNamed(inp, "LoginButton");
        assertNotNull(login);
        login.doClick();
        
        assertEquals(loginFail.getText(),expected);
    }
    //tests login exisiting logic
    @Test
    public void testLoginExists(){ 
        String expected = "User exists, please login";
        mainFrame m = new mainFrame();
        m.setVisible(true);
        
        loginCreationMenu inp = (loginCreationMenu) TestUtils.getChildNamed(m,"loginMenu");
        assertNotNull(inp);
        
        JTextField username = (JTextField)TestUtils.getChildNamed(inp, "NameInput");
        assertNotNull(username);
        username.setText("Admin Admin");
        
        JPasswordField pass = (JPasswordField) TestUtils.getChildNamed(inp, "PassInput");
        assertNotNull(pass);
        pass.setText("Admin"); //wrong password
        
        JComboBox role = (JComboBox) TestUtils.getChildNamed(inp, "TypeBox");
        assertNotNull(role);
        role.setSelectedIndex(0); //0=member, 1=Manager, 2=Team lead
        
        JLabel loginFail = (JLabel) TestUtils.getChildNamed(inp, "LoginFail");
        assertNotNull(loginFail);
        
        JButton create = (JButton) TestUtils.getChildNamed(inp, "CreateButton");
        assertNotNull(create);
        create.doClick();
        
        assertEquals(loginFail.getText(),expected);
    }
    //tests empty input logic
    @Test 
    public void testLoginEmpty(){
        String expected = "Please fill out all areas";
        mainFrame m = new mainFrame();
        m.setVisible(true);
        
        loginCreationMenu inp = (loginCreationMenu) TestUtils.getChildNamed(m,"loginMenu");
        assertNotNull(inp);
        
        JTextField username = (JTextField)TestUtils.getChildNamed(inp, "NameInput");
        assertNotNull(username);
        username.setText(null);
        
        JPasswordField pass = (JPasswordField) TestUtils.getChildNamed(inp, "PassInput");
        assertNotNull(pass);
        pass.setText("Admin"); //wrong password
        
        JComboBox role = (JComboBox) TestUtils.getChildNamed(inp, "TypeBox");
        assertNotNull(role);
        role.setSelectedIndex(0); //0=member, 1=Manager, 2=Team lead
        
        JLabel loginFail = (JLabel) TestUtils.getChildNamed(inp, "LoginFail");
        assertNotNull(loginFail);
        
        JButton login = (JButton) TestUtils.getChildNamed(inp, "LoginButton");
        assertNotNull(login);
        login.doClick();
        
        assertEquals(loginFail.getText(),expected);
    }
    //tests 
    //</editor-fold>
    
}
