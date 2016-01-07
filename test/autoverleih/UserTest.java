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
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author a
 */
public class UserTest {
    
    public UserTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getUser_ID method, of class User.
     */
    @Test
    public void testGetUser_ID() {
        System.out.println("getUser_ID");
        User instance = new User(123, "Alice", "ab12");
        int expResult = 123;
        int result = instance.getUser_ID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getUser_NAME method, of class User.
     */
    @Test
    public void testGetUser_NAME() {
        System.out.println("getUser_NAME");
        User instance = new User(123, "Alice", "ab12");
        String expResult = "Alice";
        String result = instance.getUser_NAME();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getUser_PW method, of class User.
     */
    @Test
    public void testGetUser_PW() {
        System.out.println("getUser_PW");
        User instance = new User(123, "Alice", "ab12");
        String expResult = "ab12";
        String result = instance.getUser_PW();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setU_ID method, of class User.
     */
    @Test
    public void testSetU_ID() {
        System.out.println("setU_ID");
        int U_ID = 4;
        User instance = new User(123, "Alice", "ab12");
        instance.setU_ID(U_ID);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setU_Name method, of class User.
     */
    @Test
    public void testSetU_Name() {
        System.out.println("setU_Name");
        String U_NAME = "Bob";
        User instance = new User(123, "Alice", "ab12");
        instance.setU_Name(U_NAME);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setU_pw method, of class User.
     */
    @Test
    public void testSetU_pw() {
        System.out.println("setU_pw");
        String U_PW = "c3";
        User instance = new User(123, "Alice", "ab12");
        instance.setU_pw(U_PW);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
