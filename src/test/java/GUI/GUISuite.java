/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author h_obe
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({GUI.addTeamMemberTest.class, GUI.mainFrameTest.class, GUI.loginCreationMenuTest.class, GUI.TaskCreationTest.class, GUI.SubtaskCreationTest.class})
public class GUISuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
}
