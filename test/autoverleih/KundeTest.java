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
        Kunde instance = new Kunde(2, "vn"," nn", "05984", "wo", " str", "n3", "em", "059846874652", Geb,  FS, FD, "ads" );
        String expResult = "Kunden_ID: 2\n" + "Vorname: vn\n" + "Nachname:  nn\n" + "Postleitzahl: 05984\n" + "Wohnort: wo\n" + "Strasse:  str\n" + "Hausnummer: n3\n" + "E-Mail: em\n" + "Telefonnummer: 059846874652\n" + "Geburtstag: Fri Nov 13 00:00:00 CET 1970\n" + "Fuehrerschein: C:\\Autoverleih\\Test2\n" + "Fuehrerscheindatum: Fri Nov 16 00:00:00 CET 2018\n" + "Fuehrerscheinklasse: ads\n";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getKunden_ID method, of class Kunde.
     */
    @Test
    public void testGetKunden_ID() {
        System.out.println("getKunden_ID");
        Kunde instance = new Kunde(2, "vn"," nn", "05984", "wo", " str", "n3", "em", "059846874652", Geb,  FS, FD, "ads" );
        int expResult = 2;
        int result = instance.getKunden_ID();
        assertEquals(expResult, result);
    }

    /**
     * Test of getVorname method, of class Kunde.
     */
    @Test
    public void testGetVorname() {
        System.out.println("getVorname");
        Kunde instance = new Kunde(2, "vn"," nn", "05984", "wo", " str", "n3", "em", "059846874652", Geb,  FS, FD, "ads" );
        String expResult = "vn";
        String result = instance.getVorname();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNachname method, of class Kunde.
     */
    @Test
    public void testGetNachname() {
        System.out.println("getNachname");
        Kunde instance = new Kunde(2, "vn", "nn", "05984", "wo", " str", "n3", "em", "059846874652", Geb,  FS, FD, "ads" );
        String expResult = "nn";
        String result = instance.getNachname();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPostleitzahl method, of class Kunde.
     */
    @Test
    public void testGetPostleitzahl() {
        System.out.println("getPostleitzahl");
        Kunde instance = new Kunde(2, "vn"," nn", "05984", "wo", " str", "n3", "em", "059846874652", Geb,  FS, FD, "ads" );
        String expResult = "05984";
        String result = instance.getPostleitzahl();
        assertEquals(expResult, result);
    }

    /**
     * Test of getWohnort method, of class Kunde.
     */
    @Test
    public void testGetWohnort() {
        System.out.println("getWohnort");
        Kunde instance = new Kunde(2, "vn"," nn", "05984", "wo", " str", "n3", "em", "059846874652", Geb,  FS, FD, "ads" );
        String expResult = "wo";
        String result = instance.getWohnort();
        assertEquals(expResult, result);
    }

    /**
     * Test of getStrasse method, of class Kunde.
     */
    @Test
    public void testGetStrasse() {
        System.out.println("getStrasse");
        Kunde instance = new Kunde(2, "vn"," nn", "05984", "wo", "str", "n3", "em", "059846874652", Geb,  FS, FD, "ads" );
        String expResult = "str";
        String result = instance.getStrasse();
        assertEquals(expResult, result);
    }

    /**
     * Test of getHausnummer method, of class Kunde.
     */
    @Test
    public void testGetHausnummer() {
        System.out.println("getHausnummer");
        Kunde instance = new Kunde(2, "vn"," nn", "05984", "wo", " str", "n3", "em", "059846874652", Geb,  FS, FD, "ads" );
        String expResult = "n3";
        String result = instance.getHausnummer();
        assertEquals(expResult, result);
    }

    /**
     * Test of getE_Mail method, of class Kunde.
     */
    @Test
    public void testGetE_Mail() {
        System.out.println("getE_Mail");
        Kunde instance = new Kunde(2, "vn"," nn", "05984", "wo", " str", "n3", "em", "059846874652", Geb,  FS, FD, "ads" );
        String expResult = "em";
        String result = instance.getE_Mail();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTelefonnummer method, of class Kunde.
     */
    @Test
    public void testGetTelefonnummer() {
        System.out.println("getTelefonnummer");
        Kunde instance = new Kunde(2, "vn"," nn", "05984", "wo", " str", "n3", "em", "059846874652", Geb,  FS, FD, "ads" );
        String expResult ="059846874652";
        String result = instance.getTelefonnummer();
        assertEquals(expResult, result);
    }

    /**
     * Test of getGeburtstag method, of class Kunde.
     */
    @Test
    public void testGetGeburtstag() {
        System.out.println("getGeburtstag");
        Kunde instance = new Kunde(2, "vn"," nn", "05984", "wo", " str", "n3", "em", "059846874652", Geb,  FS, FD, "ads" );
        Date expResult = Geb;
        Date result = instance.getGeburtstag();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFuehrerschein method, of class Kunde.
     */
    @Test
    public void testGetFuehrerschein() {
        System.out.println("getFuehrerschein");
        Kunde instance = new Kunde(2, "vn"," nn", "05984", "wo", " str", "n3", "em", "059846874652", Geb,  FS, FD, "ads" );
        File expResult = FS;
        File result = instance.getFuehrerschein();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFuehrerscheindatum method, of class Kunde.
     */
    @Test
    public void testGetFuehrerscheindatum() {
        System.out.println("getFuehrerscheindatum");
        Kunde instance = new Kunde(2, "vn"," nn", "05984", "wo", " str", "n3", "em", "059846874652", Geb,  FS, FD, "ads" );
        Date expResult = FD;
        Date result = instance.getFuehrerscheindatum();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFuehrerscheinklasse method, of class Kunde.
     */
    @Test
    public void testGetFuehrerscheinklasse() {
        System.out.println("getFuehrerscheinklasse");
        Kunde instance = new Kunde(2, "vn"," nn", "05984", "wo", " str", "n3", "em", "059846874652", Geb,  FS, FD, "ads" );
        String expResult = "ads";
        String result = instance.getFuehrerscheinklasse();
        assertEquals(expResult, result);
    }

    /**
     * Test of setKunden_ID method, of class Kunde.
     */
    @Test
    public void testSetKunden_ID() {
        System.out.println("setKunden_ID");
        int Kunden_ID = 3;
        Kunde instance = new Kunde(2, "vn"," nn", "05984", "wo", " str", "n3", "em", "059846874652", Geb,  FS, FD, "ads" );
        instance.setKunden_ID(Kunden_ID);
    }

    /**
     * Test of setVorname method, of class Kunde.
     */
    @Test
    public void testSetVorname() {
        System.out.println("setVorname");
        String Vorname = "fds";
        Kunde instance = new Kunde(2, "vn"," nn", "05984", "wo", " str", "n3", "em", "059846874652", Geb,  FS, FD, "ads" );
        instance.setVorname(Vorname);
    }

    /**
     * Test of setNachname method, of class Kunde.
     */
    @Test
    public void testSetNachname() {
        System.out.println("setNachname");
        String Nachname = "fsg";
        Kunde instance = new Kunde(2, "vn"," nn", "05984", "wo", " str", "n3", "em", "059846874652", Geb,  FS, FD, "ads" );
        instance.setNachname(Nachname);
    }

    /**
     * Test of setPostleitzahl method, of class Kunde.
     */
    @Test
    public void testSetPostleitzahl() {
        System.out.println("setPostleitzahl");
        String Postleitzahl = "06489";
        Kunde instance = new Kunde(2, "vn"," nn", "05984", "wo", " str", "n3", "em", "059846874652", Geb,  FS, FD, "ads" );
        instance.setPostleitzahl(Postleitzahl);
    }

    /**
     * Test of setWohnort method, of class Kunde.
     */
    @Test
    public void testSetWohnort() {
        System.out.println("setWohnort");
        String Wohnort = "fds";
        Kunde instance = new Kunde(2, "vn"," nn", "05984", "wo", " str", "n3", "em", "059846874652", Geb,  FS, FD, "ads" );
        instance.setWohnort(Wohnort);
    }

    /**
     * Test of setStrasse method, of class Kunde.
     */
    @Test
    public void testSetStrasse() {
        System.out.println("setStrasse");
        String Strasse = "jg";
        Kunde instance = new Kunde(2, "vn"," nn", "05984", "wo", " str", "n3", "em", "059846874652", Geb,  FS, FD, "ads" );
        instance.setStrasse(Strasse);
    }

    /**
     * Test of setHausnummer method, of class Kunde.
     */
    @Test
    public void testSetHausnummer() {
        System.out.println("setHausnummer");
        String Hausnummer = "jhg";
        Kunde instance = new Kunde(2, "vn"," nn", "05984", "wo", " str", "n3", "em", "059846874652", Geb,  FS, FD, "ads" );
        instance.setHausnummer(Hausnummer);
    }

    /**
     * Test of setE_Mail method, of class Kunde.
     */
    @Test
    public void testSetE_Mail() {
        System.out.println("setE_Mail");
        String E_Mail = "jhg";
        Kunde instance = new Kunde(2, "vn"," nn", "05984", "wo", " str", "n3", "em", "059846874652", Geb,  FS, FD, "ads" );
        instance.setE_Mail(E_Mail);
    }

    /**
     * Test of setTelefonnummer method, of class Kunde.
     */
    @Test
    public void testSetTelefonnummer() {
        System.out.println("setTelefonnummer");
        String Telefonnummer = "78879412318";
        Kunde instance = new Kunde(2, "vn"," nn", "05984", "wo", " str", "n3", "em", "059846874652", Geb,  FS, FD, "ads" );
        instance.setTelefonnummer(Telefonnummer);
    }

    /**
     * Test of setGeburtstag method, of class Kunde.
     */
    @Test
    public void testSetGeburtstag() {
        System.out.println("setGeburtstag");
        Date Geburtstag = FD;
        Kunde instance = new Kunde(2, "vn"," nn", "05984", "wo", " str", "n3", "em", "059846874652", Geb,  FS, FD, "ads" );
        instance.setGeburtstag(Geburtstag);
    }

    /**
     * Test of setFuehrerschein method, of class Kunde.
     */
    @Test
    public void testSetFuehrerschein() {
        System.out.println("setFuehrerschein");
        File Fuehrerschein = FS2;
        Kunde instance = new Kunde(2, "vn"," nn", "05984", "wo", " str", "n3", "em", "059846874652", Geb,  FS, FD, "ads" );
        instance.setFuehrerschein(Fuehrerschein);
    }

    /**
     * Test of setFuehrerscheindatum method, of class Kunde.
     */
    @Test
    public void testSetFuehrerscheindatum() {
        System.out.println("setFuehrerscheindatum");
        Date Fuehrerscheindatum = Geb;
        Kunde instance = new Kunde(2, "vn"," nn", "05984", "wo", " str", "n3", "em", "059846874652", Geb,  FS, FD, "ads" );
        instance.setFuehrerscheindatum(Fuehrerscheindatum);
    }

    /**
     * Test of setFuehrerscheinklasse method, of class Kunde.
     */
    @Test
    public void testSetFuehrerscheinklasse() {
        System.out.println("setFuehrerscheinklasse");
        String Fuehrerscheinklasse = "uh";
        Kunde instance = new Kunde(2, "vn"," nn", "05984", "wo", " str", "n3", "em", "059846874652", Geb,  FS, FD, "ads" );
        instance.setFuehrerscheinklasse(Fuehrerscheinklasse);
    }
    
}
