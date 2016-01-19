/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoverleih;

import java.io.File;
import java.util.ArrayList;
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
    File Foto1 = new File("/Data/bmw5.jpg");
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
        Kunde kunde5 = new Kunde(1, "vn"," nn", "05984", "wo", " str", "n3", "em", "059846874652", AD,  Foto1, RD2, "ads" );
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
    }

    /**
     * Test of clearAutos method, of class DB_Verwalter.
     */
    @Test
    public void testClearAutos() {
        System.out.println("clearAutos");
        DB_Verwalter instance = new DB_Verwalter();
        instance.clearAutos();
    }

    /**
     * Test of clearKunden method, of class DB_Verwalter.
     */
    @Test
    public void testClearKunden() {
        System.out.println("clearKunden");
        DB_Verwalter instance = new DB_Verwalter();
        instance.clearKunden();
    }

    /**
     * Test of clearAusleihen method, of class DB_Verwalter.
     */
    @Test
    public void testClearAusleihen() {
        System.out.println("clearAusleihen");
        DB_Verwalter instance = new DB_Verwalter();
        instance.clearAusleihen();
    }

    /**
     * Test of Autos_anzeigen method, of class DB_Verwalter.
     */
    @Test
    public void testAutos_anzeigen() {
        System.out.println("Autos_anzeigen");
        DB_Verwalter instance = new DB_Verwalter();
        instance.Autos_anzeigen();
    }

    /**
     * Test of Kunden_anzeigen method, of class DB_Verwalter.
     */
    @Test
    public void testKunden_anzeigen() {
        System.out.println("Kunden_anzeigen");
        DB_Verwalter instance = new DB_Verwalter();
        instance.Kunden_anzeigen();
    }

    /**
     * Test of Ausleihen_anzeigen method, of class DB_Verwalter.
     */
    @Test
    public void testAusleihen_anzeigen() {
        System.out.println("Ausleihen_anzeigen");
        DB_Verwalter instance = new DB_Verwalter();
        instance.Ausleihen_anzeigen();
    }

    /**
     * Test of Auto_abholen method, of class DB_Verwalter.
     */
    @Test
    public void testAuto_abholen() {
        System.out.println("Auto_abholen");
        DBV.clearAll();
        Auto auto = new Auto(Foto1, 1, "d", "f", "f", "g", true, 4, "s", 126, "ds", 4, "sf", "GET", 1883, 8045, RD2, 543, 234, true, "fd", true);
        int A_ID = 2;
        DB_Verwalter instance = new DB_Verwalter();
        instance.restore(pfad);
        instance.Auto_abholen(A_ID);
    }

    /**
     * Test of Auto_zurueckbringen method, of class DB_Verwalter.
     */
    @Test
    public void testAuto_zurueckbringen() {
        System.out.println("Auto_zurueckbringen");
        int A_ID = 3;
        DB_Verwalter instance = new DB_Verwalter();
        instance.restore(pfad);
        instance.Auto_zurueckbringen(A_ID);
    }

    /**
     * Test of getKunden method, of class DB_Verwalter.
     */
    @Test
    public void testGetKunden() {
        System.out.println("getKunden");
        DBV.clearAll();
        DB_Verwalter instance = new DB_Verwalter();
        List<Kunde> expResult = new ArrayList<Kunde>();
        List<Kunde> result = instance.getKunden();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAutos method, of class DB_Verwalter.
     */
    @Test
    public void testGetAutos() {
        System.out.println("getAutos");
        DBV.clearAll();
        DB_Verwalter instance = new DB_Verwalter();
        List<Auto> expResult = new ArrayList<Auto>();
        List<Auto> result = instance.getAutos();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAusleihen method, of class DB_Verwalter.
     */
    @Test
    public void testGetAusleihen() {
        System.out.println("getAusleihen");
        DBV.clearAll();
        DB_Verwalter instance = new DB_Verwalter();
        List<Ausleihe> expResult = new ArrayList<Ausleihe>();
        List<Ausleihe> result = instance.getAusleihen();
        assertEquals(expResult, result);
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
    }

    /**
     * Test of makeAutoID method, of class DB_Verwalter.
     */
    @Test
    public void testMakeAutoID() {
        System.out.println("makeAutoID");
        DBV.clearAll();
        DB_Verwalter instance = new DB_Verwalter();
        int expResult = 1;
        int result = instance.makeAutoID();
        assertEquals(expResult, result);
    }

    /**
     * Test of makeKundenID method, of class DB_Verwalter.
     */
    @Test
    public void testMakeKundenID() {
        System.out.println("makeKundenID");
        DBV.clearAll();
        DB_Verwalter instance = new DB_Verwalter();
        int expResult = 1;
        int result = instance.makeKundenID();
        assertEquals(expResult, result);
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
    }

    /**
     * Test of removeAusleihe method, of class DB_Verwalter.
     */
    @Test
    public void testRemoveAusleihe() {
        System.out.println("removeAusleihe");
        int A_ID = 3;
        DB_Verwalter instance = new DB_Verwalter();
        instance.removeAusleihe(A_ID);
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
    }

    /**
     * Test of getUsers method, of class DB_Verwalter.
     */
    @Test
    public void testGetUsers() {
        System.out.println("getUsers");
        DBV.clearAll();
        DB_Verwalter instance = new DB_Verwalter();
        List<User> expResult = new ArrayList<User>();
        List<User> result = instance.getUsers();
        assertEquals(expResult, result);
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
    }

    /**
     * Test of User_anzeigen method, of class DB_Verwalter.
     */
    @Test
    public void testUser_anzeigen() {
        System.out.println("User_anzeigen");
        DB_Verwalter instance = new DB_Verwalter();
        instance.User_anzeigen();
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
    }

    /**
     * Test of getAutobyID method, of class DB_Verwalter.
     */
    @Test
    public void testGetAutobyID() {
        System.out.println("getAutobyID");
        int A_ID = 3;
        DB_Verwalter instance = new DB_Verwalter();
        instance.restore(pfad);
        Auto expResult = new Auto(Foto1, 3, "dj", "f", "f", "g", true, 4, "s", 126, "ds", 4, "sf", "GET", 1883, 8045, RD2, 543, 234, true, "fd", false);
        Auto result = instance.getAutobyID(A_ID);
        assertEquals(expResult, result);

    }

    /**
     * Test of getKundebyID method, of class DB_Verwalter.
     */
    @Test
    public void testGetKundebyID() {
        System.out.println("getKundebyID");
        int K_ID = 1;
        DB_Verwalter instance = new DB_Verwalter();
        instance.restore(pfad);
        Kunde expResult = new Kunde(1, "vn"," nn", "05984", "wo", " str", "n3", "em", "059846874652", AD,  Foto1, RD2, "ads" );
        Kunde result = instance.getKundebyID(K_ID);
        assertEquals(expResult, result);
    }

    /**
     * Test of getAusleihebyID method, of class DB_Verwalter.
     */
    @Test
    public void testGetAusleihebyID() {
        System.out.println("getAusleihebyID");
        int A_ID = 1;
        DB_Verwalter instance = new DB_Verwalter();
        instance.restore(pfad);
        Ausleihe expResult = new Ausleihe(2, 3, AD, RD, false);
        Ausleihe result = instance.getAusleihebyID(A_ID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of makeAusleiheID method, of class DB_Verwalter.
     */
    @Test
    public void testMakeAusleiheID() {
        System.out.println("makeAusleiheID");
        DBV.clearAll();
        DB_Verwalter instance = new DB_Verwalter();
        int expResult = 1;
        int result = instance.makeAusleiheID();
        assertEquals(expResult, result);
    }

    /**
     * Test of randomRealAutos method, of class DB_Verwalter.
     */
    @Test
    public void testRandomRealAutos() throws Exception {
        System.out.println("randomRealAutos");
        int Anzahl = 13;
        DB_Verwalter instance = new DB_Verwalter();
        instance.randomRealAutos(Anzahl);
    }
    
}
