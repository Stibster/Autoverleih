/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoverleih;

import java.io.File;
import java.util.Date;
import java.util.List;
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
public class DB_VerwalterTest {
    Date AD = new Date(46, 5, 10);
    Date RD = new Date(46, 6, 15);
    Date AD2 = new Date(0, 6, 10);
    Date RD2 = new Date(50, 6, 15);
    File Foto1 = new File("C:\\Autoverleih\\Test2");
    Date TUV = new Date(120, 10,4);
    String pfad = "Data/xml/TestDatenbank2.xml";
    public DB_Verwalter DBV = new DB_Verwalter();
    
    public DB_VerwalterTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        DBV.clearAll();
        Auto auto2 = new Auto(Foto1, 2, "l", "f", "f", "g", true, 4, "s", 126, "ds", 4, "sf", "GET", 1883, 8045, RD2, 543, 234, true, "fd", true);
        DBV.addAuto(auto2);
        Auto auto3 = new Auto(Foto1, 3, "dj", "f", "f", "g", true, 4, "s", 126, "ds", 4, "sf", "GET", 1883, 8045, RD2, 543, 234, true, "fd", false);
        DBV.addAuto(auto3);
        Auto auto5 = new Auto(Foto1, 5, "g", "f", "f", "g", true, 4, "s", 126, "ds", 4, "sf", "GET", 1883, 8045, RD2, 543, 234, true, "fd", false);
        DBV.addAuto(auto5);
        Ausleihe ausleihe = new Ausleihe(2, 3, AD, RD, false);
        DBV.addAusleihe(ausleihe);
        Kunde kunde5 = new Kunde(2, "vn"," nn", "05984", "wo", " str", "n3", "em", "059846874652", AD,  Foto1, RD2, "ads" );
        DBV.addKunde(kunde5);
        DBV.save(pfad);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of clearAll method, of class DB_Verwalter.
     */
    @Test
    public void testClearAll() {
        System.out.println("clearAll");
        DB_Verwalter instance = new DB_Verwalter();
        instance.clearAll();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of clearAutos method, of class DB_Verwalter.
     */
    @Test
    public void testClearAutos() {
        System.out.println("clearAutos");
        DB_Verwalter instance = new DB_Verwalter();
        instance.clearAutos();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of clearKunden method, of class DB_Verwalter.
     */
    @Test
    public void testClearKunden() {
        System.out.println("clearKunden");
        DB_Verwalter instance = new DB_Verwalter();
        instance.clearKunden();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of clearAusleihen method, of class DB_Verwalter.
     */
    @Test
    public void testClearAusleihen() {
        System.out.println("clearAusleihen");
        DB_Verwalter instance = new DB_Verwalter();
        instance.clearAusleihen();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of Autos_anzeigen method, of class DB_Verwalter.
     */
    @Test
    public void testAutos_anzeigen() {
        System.out.println("Autos_anzeigen");
        DB_Verwalter instance = new DB_Verwalter();
        instance.Autos_anzeigen();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of Kunden_anzeigen method, of class DB_Verwalter.
     */
    @Test
    public void testKunden_anzeigen() {
        System.out.println("Kunden_anzeigen");
        DB_Verwalter instance = new DB_Verwalter();
        instance.Kunden_anzeigen();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of Ausleihen_anzeigen method, of class DB_Verwalter.
     */
    @Test
    public void testAusleihen_anzeigen() {
        System.out.println("Ausleihen_anzeigen");
        DB_Verwalter instance = new DB_Verwalter();
        instance.Ausleihen_anzeigen();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of Auto_abholen method, of class DB_Verwalter.
     */
    @Test
    public void testAuto_abholen() {
        System.out.println("Auto_abholen");
         Auto auto = new Auto(Foto1, 1, "d", "f", "f", "g", true, 4, "s", 126, "ds", 4, "sf", "GET", 1883, 8045, RD2, 543, 234, true, "fd", true);
        int A_ID = 2;
        DB_Verwalter instance = new DB_Verwalter();
        instance.Auto_abholen(A_ID);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of Auto_zurueckbringen method, of class DB_Verwalter.
     */
    @Test
    public void testAuto_zurueckbringen() {
        System.out.println("Auto_zurueckbringen");
        int A_ID = 3;
        DB_Verwalter instance = new DB_Verwalter();
        instance.Auto_zurueckbringen(A_ID);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getKunden method, of class DB_Verwalter.
     */
    @Test
    public void testGetKunden() {
        System.out.println("getKunden");
        DB_Verwalter instance = new DB_Verwalter();
        List<Kunde> expResult = null;
        List<Kunde> result = instance.getKunden();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAutos method, of class DB_Verwalter.
     */
    @Test
    public void testGetAutos() {
        System.out.println("getAutos");
        DB_Verwalter instance = new DB_Verwalter();
        List<Auto> expResult = null;
        List<Auto> result = instance.getAutos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAusleihen method, of class DB_Verwalter.
     */
    @Test
    public void testGetAusleihen() {
        System.out.println("getAusleihen");
        DB_Verwalter instance = new DB_Verwalter();
        List<Ausleihe> expResult = null;
        List<Ausleihe> result = instance.getAusleihen();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setKunden method, of class DB_Verwalter.
     */
    @Test
    public void testSetKunden() {
        System.out.println("setKunden");
        List<Kunde> Kunden = null;
        DB_Verwalter instance = new DB_Verwalter();
        instance.setKunden(Kunden);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAutos method, of class DB_Verwalter.
     */
    @Test
    public void testSetAutos() {
        System.out.println("setAutos");
        List<Auto> Autos = null;
        DB_Verwalter instance = new DB_Verwalter();
        instance.setAutos(Autos);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAusleihen method, of class DB_Verwalter.
     */
    @Test
    public void testSetAusleihen() {
        System.out.println("setAusleihen");
        List<Ausleihe> Ausleihen = null;
        DB_Verwalter instance = new DB_Verwalter();
        instance.setAusleihen(Ausleihen);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of makeAutoID method, of class DB_Verwalter.
     */
    @Test
    public void testMakeAutoID() {
        System.out.println("makeAutoID");
        DB_Verwalter instance = new DB_Verwalter();
        int expResult = 0;
        int result = instance.makeAutoID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of makeKundenID method, of class DB_Verwalter.
     */
    @Test
    public void testMakeKundenID() {
        System.out.println("makeKundenID");
        DB_Verwalter instance = new DB_Verwalter();
        int expResult = 0;
        int result = instance.makeKundenID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeKunde method, of class DB_Verwalter.
     */
    @Test
    public void testRemoveKunde() {
        System.out.println("removeKunde");
        int K_ID = 5;
        DB_Verwalter instance = new DB_Verwalter();
        instance.removeKunde(K_ID);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of removeAuto method, of class DB_Verwalter.
     */
    @Test
    public void testRemoveAuto() {
        System.out.println("removeAuto");
        int A_ID = 5;
        DB_Verwalter instance = new DB_Verwalter();
        instance.removeAuto(A_ID);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of removeAusleihe method, of class DB_Verwalter.
     */
    @Test
    public void testRemoveAusleihe() {
        System.out.println("removeAusleihe");
        int K_ID = 2;
        int A_ID = 3;
        DB_Verwalter instance = new DB_Verwalter();
        instance.removeAusleihe(K_ID, A_ID);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of addAuto method, of class DB_Verwalter.
     */
    @Test
    public void testAddAuto() {
        System.out.println("addAuto");
        Auto auto = new Auto(Foto1, 99, "j", "f", "f", "g", true, 4, "s", 126, "ds", 4, "sf", "GET", 1883, 8045, RD2, 543, 234, true, "fd", true);
        DB_Verwalter instance = new DB_Verwalter();
        instance.addAuto(auto);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of addAusleihe method, of class DB_Verwalter.
     */
    @Test
    public void testAddAusleihe() {
        System.out.println("addAusleihe");
        Ausleihe ausleihe = new Ausleihe(1, 1, AD, RD, false);;
        DB_Verwalter instance = new DB_Verwalter();
        instance.addAusleihe(ausleihe);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of addKunde method, of class DB_Verwalter.
     */
    @Test
    public void testAddKunde() {
        System.out.println("addKunde");
        Kunde Kunde = new Kunde(99, "vn"," nn", "05984", "wo", " str", "n3", "em", "059846874652", AD,  Foto1, RD2, "ads" );;
        DB_Verwalter instance = new DB_Verwalter();
        instance.addKunde(Kunde);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of save method, of class DB_Verwalter.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        String pfad = "\"Data/xml/TestDatenbank2.xml\"";
        DB_Verwalter instance = new DB_Verwalter();
        instance.save(pfad);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getUsers method, of class DB_Verwalter.
     */
    @Test
    public void testGetUsers() {
        System.out.println("getUsers");
        DB_Verwalter instance = new DB_Verwalter();
        List<User> expResult = null;
        List<User> result = instance.getUsers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUser method, of class DB_Verwalter.
     */
    @Test
    public void testSetUser() {
        System.out.println("setUser");
        List<User> Users = null;
        DB_Verwalter instance = new DB_Verwalter();
        instance.setUser(Users);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addUser method, of class DB_Verwalter.
     */
    @Test
    public void testAddUser() {
        System.out.println("addUser");
        User user = new User(4,"hans", "123");
        DB_Verwalter instance = new DB_Verwalter();
        instance.addUser(user);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of removeUser method, of class DB_Verwalter.
     */
    @Test
    public void testRemoveUser() {
        System.out.println("removeUser");
        int U_ID = 1;
        DB_Verwalter instance = new DB_Verwalter();
        instance.removeUser(U_ID);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of User_anzeigen method, of class DB_Verwalter.
     */
    @Test
    public void testUser_anzeigen() {
        System.out.println("User_anzeigen");
        DB_Verwalter instance = new DB_Verwalter();
        instance.User_anzeigen();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of restore method, of class DB_Verwalter.
     */
    @Test
    public void testRestore() {
        System.out.println("restore");
        String pfad = "Data/xml/TestDatenbank2.xml";
        DB_Verwalter instance = new DB_Verwalter();
        instance.restore(pfad);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of randomAutos method, of class DB_Verwalter.
     */
    @Test
    public void testRandomAutos() throws Exception {
        System.out.println("randomAutos");
        int Anzahl = 10;
        DB_Verwalter instance = new DB_Verwalter();
        instance.randomAutos(Anzahl);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of randomKunden method, of class DB_Verwalter.
     */
    @Test
    public void testRandomKunden() throws Exception {
        System.out.println("randomKunden");
        int Anzahl = 10;
        DB_Verwalter instance = new DB_Verwalter();
        instance.randomKunden(Anzahl);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
