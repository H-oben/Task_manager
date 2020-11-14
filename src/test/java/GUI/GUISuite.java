package GUI;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * GUI testing currently not working, peoplePack & taskPackage testing work and are correct
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
