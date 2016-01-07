/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoverleih;

import java.io.File;
import java.util.Date;
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
public class KundeTest {
    
    File FS = new File("C:\\Autoverleih\\Test2");
    File FS2 = new File("C:\\Autoverleih\\Test1");
    Date Geb = new Date(70, 10, 13);
    Date FD = new Date(118, 10, 16);
    
    public KundeTest() {
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
     * Test of toString method, of class Kunde.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Kunde instance = new Kunde(2, "vn"," nn", 9045, "wo", " str", "n3", "em", 134, Geb,  FS, FD, "ads" );
        String expResult = "Kunden_ID: 2\n" + "Vorname: vn\n" + "Nachname:  nn\n" + "Postleitzahl: 9045\n" + "Wohnort: wo\n" + "Strasse:  str\n" + "Hausnummer: n3\n" + "E-Mail: em\n" + "Telefonnummer: 134\n" + "Geburtstag: Fri Nov 13 00:00:00 CET 1970\n" + "Fuehrerschein: C:\\Autoverleih\\Test2\n" + "Fuehrerscheindatum: Fri Nov 16 00:00:00 CET 2018\n" + "Fuehrerscheinklasse: ads\n";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //
    }

    /**
     * Test of getKunden_ID method, of class Kunde.
     */
    @Test
    public void testGetKunden_ID() {
        System.out.println("getKunden_ID");
        Kunde instance = new Kunde(2, "vn"," nn", 9045, "wo", " str", "n3", "em", 134, Geb,  FS, FD, "ads" );
        int expResult = 2;
        int result = instance.getKunden_ID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //
    }

    /**
     * Test of getVorname method, of class Kunde.
     */
    @Test
    public void testGetVorname() {
        System.out.println("getVorname");
        Kunde instance = new Kunde(2, "vn"," nn", 9045, "wo", " str", "n3", "em", 134, Geb,  FS, FD, "ads" );
        String expResult = "vn";
        String result = instance.getVorname();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //
    }

    /**
     * Test of getNachname method, of class Kunde.
     */
    @Test
    public void testGetNachname() {
        System.out.println("getNachname");
        Kunde instance = new Kunde(2, "vn", "nn", 9045, "wo", " str", "n3", "em", 134, Geb,  FS, FD, "ads" );
        String expResult = "nn";
        String result = instance.getNachname();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //
    }

    /**
     * Test of getPostleitzahl method, of class Kunde.
     */
    @Test
    public void testGetPostleitzahl() {
        System.out.println("getPostleitzahl");
        Kunde instance = new Kunde(2, "vn"," nn", 9045, "wo", " str", "n3", "em", 134, Geb,  FS, FD, "ads" );
        int expResult = 9045;
        int result = instance.getPostleitzahl();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //
    }

    /**
     * Test of getWohnort method, of class Kunde.
     */
    @Test
    public void testGetWohnort() {
        System.out.println("getWohnort");
        Kunde instance = new Kunde(2, "vn"," nn", 9045, "wo", " str", "n3", "em", 134, Geb,  FS, FD, "ads" );
        String expResult = "wo";
        String result = instance.getWohnort();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //
    }

    /**
     * Test of getStrasse method, of class Kunde.
     */
    @Test
    public void testGetStrasse() {
        System.out.println("getStrasse");
        Kunde instance = new Kunde(2, "vn"," nn", 9045, "wo", "str", "n3", "em", 134, Geb,  FS, FD, "ads" );
        String expResult = "str";
        String result = instance.getStrasse();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //
    }

    /**
     * Test of getHausnummer method, of class Kunde.
     */
    @Test
    public void testGetHausnummer() {
        System.out.println("getHausnummer");
        Kunde instance = new Kunde(2, "vn"," nn", 9045, "wo", " str", "n3", "em", 134, Geb,  FS, FD, "ads" );
        String expResult = "n3";
        String result = instance.getHausnummer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //
    }

    /**
     * Test of getE_Mail method, of class Kunde.
     */
    @Test
    public void testGetE_Mail() {
        System.out.println("getE_Mail");
        Kunde instance = new Kunde(2, "vn"," nn", 9045, "wo", " str", "n3", "em", 134, Geb,  FS, FD, "ads" );
        String expResult = "em";
        String result = instance.getE_Mail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //
    }

    /**
     * Test of getTelefonnummer method, of class Kunde.
     */
    @Test
    public void testGetTelefonnummer() {
        System.out.println("getTelefonnummer");
        Kunde instance = new Kunde(2, "vn"," nn", 9045, "wo", " str", "n3", "em", 134, Geb,  FS, FD, "ads" );
        int expResult =134;
        int result = instance.getTelefonnummer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //
    }

    /**
     * Test of getGeburtstag method, of class Kunde.
     */
    @Test
    public void testGetGeburtstag() {
        System.out.println("getGeburtstag");
        Kunde instance = new Kunde(2, "vn"," nn", 9045, "wo", " str", "n3", "em", 134, Geb,  FS, FD, "ads" );
        Date expResult = Geb;
        Date result = instance.getGeburtstag();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //
    }

    /**
     * Test of getFuehrerschein method, of class Kunde.
     */
    @Test
    public void testGetFuehrerschein() {
        System.out.println("getFuehrerschein");
        Kunde instance = new Kunde(2, "vn"," nn", 9045, "wo", " str", "n3", "em", 134, Geb,  FS, FD, "ads" );
        File expResult = FS;
        File result = instance.getFuehrerschein();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //
    }

    /**
     * Test of getFuehrerscheindatum method, of class Kunde.
     */
    @Test
    public void testGetFuehrerscheindatum() {
        System.out.println("getFuehrerscheindatum");
        Kunde instance = new Kunde(2, "vn"," nn", 9045, "wo", " str", "n3", "em", 134, Geb,  FS, FD, "ads" );
        Date expResult = FD;
        Date result = instance.getFuehrerscheindatum();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //
    }

    /**
     * Test of getFuehrerscheinklasse method, of class Kunde.
     */
    @Test
    public void testGetFuehrerscheinklasse() {
        System.out.println("getFuehrerscheinklasse");
        Kunde instance = new Kunde(2, "vn"," nn", 9045, "wo", " str", "n3", "em", 134, Geb,  FS, FD, "ads" );
        String expResult = "ads";
        String result = instance.getFuehrerscheinklasse();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //
    }

    /**
     * Test of setKunden_ID method, of class Kunde.
     */
    @Test
    public void testSetKunden_ID() {
        System.out.println("setKunden_ID");
        int Kunden_ID = 3;
        Kunde instance = new Kunde(2, "vn"," nn", 9045, "wo", " str", "n3", "em", 134, Geb,  FS, FD, "ads" );
        instance.setKunden_ID(Kunden_ID);
        // TODO review the generated test code and remove the default call to fail.
        //
    }

    /**
     * Test of setVorname method, of class Kunde.
     */
    @Test
    public void testSetVorname() {
        System.out.println("setVorname");
        String Vorname = "fds";
        Kunde instance = new Kunde(2, "vn"," nn", 9045, "wo", " str", "n3", "em", 134, Geb,  FS, FD, "ads" );
        instance.setVorname(Vorname);
        // TODO review the generated test code and remove the default call to fail.
        //
    }

    /**
     * Test of setNachname method, of class Kunde.
     */
    @Test
    public void testSetNachname() {
        System.out.println("setNachname");
        String Nachname = "fsg";
        Kunde instance = new Kunde(2, "vn"," nn", 9045, "wo", " str", "n3", "em", 134, Geb,  FS, FD, "ads" );
        instance.setNachname(Nachname);
        // TODO review the generated test code and remove the default call to fail.
        //
    }

    /**
     * Test of setPostleitzahl method, of class Kunde.
     */
    @Test
    public void testSetPostleitzahl() {
        System.out.println("setPostleitzahl");
        int Postleitzahl = 064;
        Kunde instance = new Kunde(2, "vn"," nn", 9045, "wo", " str", "n3", "em", 134, Geb,  FS, FD, "ads" );
        instance.setPostleitzahl(Postleitzahl);
        // TODO review the generated test code and remove the default call to fail.
        //
    }

    /**
     * Test of setWohnort method, of class Kunde.
     */
    @Test
    public void testSetWohnort() {
        System.out.println("setWohnort");
        String Wohnort = "fds";
        Kunde instance = new Kunde(2, "vn"," nn", 9045, "wo", " str", "n3", "em", 134, Geb,  FS, FD, "ads" );
        instance.setWohnort(Wohnort);
        // TODO review the generated test code and remove the default call to fail.
        //
    }

    /**
     * Test of setStrasse method, of class Kunde.
     */
    @Test
    public void testSetStrasse() {
        System.out.println("setStrasse");
        String Strasse = "jg";
        Kunde instance = new Kunde(2, "vn"," nn", 9045, "wo", " str", "n3", "em", 134, Geb,  FS, FD, "ads" );
        instance.setStrasse(Strasse);
        // TODO review the generated test code and remove the default call to fail.
        //
    }

    /**
     * Test of setHausnummer method, of class Kunde.
     */
    @Test
    public void testSetHausnummer() {
        System.out.println("setHausnummer");
        String Hausnummer = "jhg";
        Kunde instance = new Kunde(2, "vn"," nn", 9045, "wo", " str", "n3", "em", 134, Geb,  FS, FD, "ads" );
        instance.setHausnummer(Hausnummer);
        // TODO review the generated test code and remove the default call to fail.
        //
    }

    /**
     * Test of setE_Mail method, of class Kunde.
     */
    @Test
    public void testSetE_Mail() {
        System.out.println("setE_Mail");
        String E_Mail = "jhg";
        Kunde instance = new Kunde(2, "vn"," nn", 9045, "wo", " str", "n3", "em", 134, Geb,  FS, FD, "ads" );
        instance.setE_Mail(E_Mail);
        // TODO review the generated test code and remove the default call to fail.
        //
    }

    /**
     * Test of setTelefonnummer method, of class Kunde.
     */
    @Test
    public void testSetTelefonnummer() {
        System.out.println("setTelefonnummer");
        int Telefonnummer = 78;
        Kunde instance = new Kunde(2, "vn"," nn", 9045, "wo", " str", "n3", "em", 134, Geb,  FS, FD, "ads" );
        instance.setTelefonnummer(Telefonnummer);
        // TODO review the generated test code and remove the default call to fail.
        //
    }

    /**
     * Test of setGeburtstag method, of class Kunde.
     */
    @Test
    public void testSetGeburtstag() {
        System.out.println("setGeburtstag");
        Date Geburtstag = FD;
        Kunde instance = new Kunde(2, "vn"," nn", 9045, "wo", " str", "n3", "em", 134, Geb,  FS, FD, "ads" );
        instance.setGeburtstag(Geburtstag);
        // TODO review the generated test code and remove the default call to fail.
        //
    }

    /**
     * Test of setFuehrerschein method, of class Kunde.
     */
    @Test
    public void testSetFuehrerschein() {
        System.out.println("setFuehrerschein");
        File Fuehrerschein = FS2;
        Kunde instance = new Kunde(2, "vn"," nn", 9045, "wo", " str", "n3", "em", 134, Geb,  FS, FD, "ads" );
        instance.setFuehrerschein(Fuehrerschein);
        // TODO review the generated test code and remove the default call to fail.
        //
    }

    /**
     * Test of setFuehrerscheindatum method, of class Kunde.
     */
    @Test
    public void testSetFuehrerscheindatum() {
        System.out.println("setFuehrerscheindatum");
        Date Fuehrerscheindatum = Geb;
        Kunde instance = new Kunde(2, "vn"," nn", 9045, "wo", " str", "n3", "em", 134, Geb,  FS, FD, "ads" );
        instance.setFuehrerscheindatum(Fuehrerscheindatum);
        // TODO review the generated test code and remove the default call to fail.
        //
    }

    /**
     * Test of setFuehrerscheinklasse method, of class Kunde.
     */
    @Test
    public void testSetFuehrerscheinklasse() {
        System.out.println("setFuehrerscheinklasse");
        String Fuehrerscheinklasse = "uh";
        Kunde instance = new Kunde(2, "vn"," nn", 9045, "wo", " str", "n3", "em", 134, Geb,  FS, FD, "ads" );
        instance.setFuehrerscheinklasse(Fuehrerscheinklasse);
        // TODO review the generated test code and remove the default call to fail.
        //
    }
    
}
