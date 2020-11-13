/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peoplePack;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author h_obe
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({peoplePack.MemberManagerExceptionTest.class, peoplePack.memberTest.class, peoplePack.ManagerTest.class, peoplePack.PersonTest.class, peoplePack.RoleTest.class})
public class PeoplePackSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
}
