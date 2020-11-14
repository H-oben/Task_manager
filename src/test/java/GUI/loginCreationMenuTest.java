/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Disabled;

/**
 *
 * @author h_obe
 */
public class loginCreationMenuTest {
    private mainFrame m;
    public loginCreationMenuTest() {
        
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterEach
    public void tearDown() {
        m.dispatchEvent(new WindowEvent(m, WindowEvent.WINDOW_CLOSING));
    }

    /**
     * Test of main method, of class loginCreationMenu.
     */
    @Disabled("not needed")
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        loginCreationMenu.main(args);
    }
    
    //<editor-fold desc="Login testing" defaultstate="collapsed">
    //tests login failure
    @Test
    public void testLoginFailure(){
        System.out.println("Test Login Failure");
        String expected = "LoginFailed";
        m = new mainFrame();
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
        System.out.println("Test Login Exists");
        String expected = "User exists, please login";
        m = new mainFrame();
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
        System.out.println("Test Login Empty");
        String expected = "Please fill out all areas";
        m = new mainFrame();
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
    //tests login success
    @Test
    public void testLoginSuccess(){
        System.out.println("Test Login Success");
        m = new mainFrame();
        m.setVisible(true);
        
        loginCreationMenu inp = (loginCreationMenu) TestUtils.getChildNamed(m,"loginMenu");
        assertNotNull(inp);
        
        JTextField username = (JTextField)TestUtils.getChildNamed(inp, "NameInput");
        assertNotNull(username);
        username.setText("Admin Admin");
        
        JPasswordField pass = (JPasswordField) TestUtils.getChildNamed(inp, "PassInput");
        assertNotNull(pass);
        pass.setText("Adm1n");
        
        JComboBox role = (JComboBox) TestUtils.getChildNamed(inp, "TypeBox");
        assertNotNull(role);
        role.setSelectedIndex(1); //0=member, 1=Manager, 2=Team lead
        
        JLabel loginFail = (JLabel) TestUtils.getChildNamed(inp, "LoginFail");
        assertNotNull(loginFail);
        
        JButton login = (JButton) TestUtils.getChildNamed(inp, "LoginButton");
        assertNotNull(login);
        login.doClick();
        
        assertFalse(loginFail.isVisible());
    }
}
