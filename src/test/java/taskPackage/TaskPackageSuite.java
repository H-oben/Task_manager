/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taskPackage;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author h_obe
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({taskPackage.CategoriesTest.class, taskPackage.StatusTest.class, taskPackage.SubtaskTest.class, taskPackage.TaskTest.class})
public class TaskPackageSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
}
