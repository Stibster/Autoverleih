/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoverleih;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Danilo May
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({autoverleih.AutoTest.class, autoverleih.KundeTest.class, autoverleih.UserTest.class, autoverleih.AusleiheTest.class, autoverleih.ListenhelperTest.class, autoverleih.DB_VerwalterTest.class, autoverleih.MetaControllerTest.class})
public class AutoverleihSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
