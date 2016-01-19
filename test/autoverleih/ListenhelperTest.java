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
 * @author Danilo May
 */
public class ListenhelperTest {
    Date AD = new Date(46, 5, 10);
    Date RD = new Date(46, 6, 15);
    Date AD2 = new Date(0, 6, 10);
    Date RD2 = new Date(50, 6, 15);
    File Foto1 = new File("/Data/bmw5.jpg");
    Date TUV = new Date(120, 10,4);
    String pfad = "Data/xml/TestDatenbank2.xml";
    public DB_Verwalter DBV = new DB_Verwalter();
    
    public ListenhelperTest() {
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
        Auto auto2 = new Auto(Foto1, 1, "l", "f", "f", "g", true, 4, "s", 126, "ds", 4, "sf", "GET", 1883, 8045, RD2, 543, 234, true, "fd", true);
        DBV.addAuto(auto2);
        Ausleihe ausleihe = new Ausleihe(1, 3, AD, RD, false);
        DBV.addAusleihe(ausleihe);
        Kunde kunde5 = new Kunde(1, "vn"," nn", "05984", "wo", " str", "n3", "em", "059846874652", AD,  Foto1, RD2, "ads" );
        DBV.addKunde(kunde5);
        DBV.save(pfad);
        DBV.restore(pfad);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getKunden method, of class Listenhelper.
     */
    @Test
    public void testGetKunden() {
        System.out.println("getKunden");
        Listenhelper instance = new Listenhelper();
        DBV.restore(pfad);
        List<Kunde> expResult = new ArrayList<Kunde>();
        List<Kunde> result = instance.getKunden();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAutos method, of class Listenhelper.
     */
    @Test
    public void testGetAutos() {
        System.out.println("getAutos");
        Listenhelper instance = new Listenhelper();
        List<Auto> expResult = new ArrayList<Auto>();
        DBV.restore(pfad);
        List<Auto> result = instance.getAutos();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAusleihen method, of class Listenhelper.
     */
    @Test
    public void testGetAusleihen() {
        System.out.println("getAusleihen");
        Listenhelper instance = new Listenhelper();
        List<Ausleihe> expResult = new ArrayList<Ausleihe>();
        DBV.restore(pfad);
        List<Ausleihe> result = instance.getAusleihen();
        assertEquals(expResult, result);
    }

    /**
     * Test of setKunden method, of class Listenhelper.
     */
    @Test
    public void testSetKunden() {
        System.out.println("setKunden");
        List<Kunde> Kunden = new ArrayList<Kunde>();
        Listenhelper instance = new Listenhelper();
        instance.setKunden(Kunden);
    }

    /**
     * Test of setAutos method, of class Listenhelper.
     */
    @Test
    public void testSetAutos() {
        System.out.println("setAutos");
        List<Auto> Autos = new ArrayList<Auto>();
        Listenhelper instance = new Listenhelper();
        instance.setAutos(Autos);
    }

    /**
     * Test of setAusleihen method, of class Listenhelper.
     */
    @Test
    public void testSetAusleihen() {
        System.out.println("setAusleihen");
        List<Ausleihe> Ausleihen = new ArrayList<Ausleihe>();
        Listenhelper instance = new Listenhelper();
        instance.setAusleihen(Ausleihen);
    }

    /**
     * Test of getUsers method, of class Listenhelper.
     */
    @Test
    public void testGetUsers() {
        System.out.println("getUsers");
        Listenhelper instance = new Listenhelper();
        DBV.restore(pfad);
        List<User> expResult = new ArrayList<User>();
        List<User> result = instance.getUsers();
        assertEquals(expResult, result);
    }

    /**
     * Test of setUsers method, of class Listenhelper.
     */
    @Test
    public void testSetUsers() {
        System.out.println("setUsers");
        List<User> Users = new ArrayList<User>();
        Listenhelper instance = new Listenhelper();
        instance.setUsers(Users);
    }
    
}
