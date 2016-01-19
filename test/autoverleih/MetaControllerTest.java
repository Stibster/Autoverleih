/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoverleih;

import java.io.File;
import java.util.Date;
import java.util.GregorianCalendar;
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
public class MetaControllerTest {
    Date AD = new Date(116, 1, 18);
    Date RD = new Date(116, 6, 15);
    Date AD2 = new Date(50, 6, 10);
    Date RD2 = new Date(118, 6, 15);
    File Foto1 = new File("/Data/bmw5.jpg");
    Date TUV = new Date(120, 10,4);
    String pfad = "Data/xml/TestDatenbank2.xml";
    public DB_Verwalter DBV = new DB_Verwalter();
    public MetaControllerTest() {
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
        Ausleihe ausleihe = new Ausleihe(2, 3, AD, RD, false);
        Ausleihe ausleihe2 = new Ausleihe(3, 5, AD, RD, false);
        
        Auto auto3 = new Auto(Foto1, 3, "dj", "f", "f", "g", true, 4, "s", 126, "ds", 4, "sf", "GET", 1883, 8045, RD2, 543, 234, true, "fd", false);
        Auto auto2 = new Auto(Foto1, 2, "l", "f", "f", "g", true, 4, "s", 126, "ds", 4, "sf", "GET", 1883, 8045, RD2, 543, 234, true, "fd", true);
        
        Kunde kunde2 = new Kunde(2, "vn"," nn", "05984", "wo", " str", "n3", "em", "059846874652", AD,  Foto1, RD2, "ads" );
        
        DBV.addAuto(auto2);
        
        
       
        
        
        DBV.addAusleihe(ausleihe2);
        DBV.save(pfad);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of DateToCalendar method, of class MetaController.
     */
    @Test
    public void testDateToCalendar() {
        System.out.println("DateToCalendar");
        Date date = AD;
        GregorianCalendar expResult = new GregorianCalendar(2016,10,5);
        GregorianCalendar result = MetaController.DateToCalendar(date);
        assertEquals(expResult, result); 
    }

    /**
     * Test of addAusleihe method, of class MetaController.
     */
    @Test
    public void testAddAusleihe() throws Exception {    
        System.out.println("addAusleihe");
        int Auto_ID = 1;
        int Kunden_ID = 1;
        Date Ausleihdatum = AD;
        Date Rueckgabedatum = RD;
        Auto auto = new Auto(Foto1, 1, "d", "f", "f", "g", true, 4, "s", 126, "ds", 4, "sf", "GET", 1883, 8045, RD2, 543, 234, true, "fd", true);
        Kunde kunde = new Kunde(1, "vn"," nn", "05984", "wo", " str", "n3", "em", "059846874652", AD,  Foto1, RD2, "ads" );
        DBV.addAuto(auto);
        DBV.addKunde(kunde);
        DBV.save(pfad);
        MetaController instance = new MetaController();
        DBV.restore(pfad);
        int expResult = 1;
        int result = instance.addAusleihe(Auto_ID, Kunden_ID, Ausleihdatum, Rueckgabedatum);
        assertEquals(expResult, result);
        DBV.clearAll();
    }

    /**
     * Test of Auto_abholen method, of class MetaController.
     */
    @Test
    public void testAuto_abholen() {
        System.out.println("Auto_abholen");
        int A_ID = 2;
        MetaController instance = new MetaController();
        DBV.restore(pfad);
        int expResult = 1;
        int result = instance.Auto_abholen(A_ID);
        assertEquals(expResult, result);
    }

    /**
     * Test of Auto_zurueckbringen method, of class MetaController.
     */
    @Test
    public void testAuto_zurueckbringen() {
        System.out.println("Auto_zurueckbringen");
        Auto auto3 = new Auto(Foto1, 3, "dj", "f", "f", "g", true, 4, "s", 126, "ds", 4, "sf", "GET", 1883, 8045, RD2, 543, 234, true, "fd", false);
        DBV.addAuto(auto3);
        Ausleihe ausleihe = new Ausleihe(2, 3, AD, RD, false);
        DBV.addAusleihe(ausleihe);
        DBV.save(pfad);
        int A_ID = 3;
        MetaController instance = new MetaController();
        DBV.restore(pfad);
        int expResult = 1;
        int result = instance.Auto_zurueckbringen(A_ID);
        assertEquals(expResult, result);
    }

    /**
     * Test of addKunde method, of class MetaController.
     */
    @Test
    public void testAddKunde() {
        System.out.println("addKunde");
        String VN = "Hans'Peter";
        String NN = "Krager";
        String PLZ = "67892";
        String WO = "Dorf";
        String STR = "Hauptstrasse-Weg";
        String HN = "555";
        String EM = "Hans23.Kroe@kdd.er";
        String TN = "023796214578";
        Date GEB = AD2 ;
        File FS = Foto1;
        Date FSD = RD2;
        String FSK = "A1";
        MetaController instance = new MetaController();
        int expResult = 1;
        int result = instance.addKunde(VN, NN, PLZ, WO, STR, HN, EM, TN, GEB, FS, FSD, FSK);
        assertEquals(expResult, result);
    }

    /**
     * Test of addAuto method, of class MetaController.
     */
    @Test
    public void testAddAuto() {
        System.out.println("addAuto");
        String KZ = "BA-S54";
        String HER = "BMW";
        String MOD = "A1";
        String BA = "Sport";
        boolean AK = true;
        int SP = 6;
        String FAR = "Gruen";
        int LEI = 400;
        String KS = "Diesel";
        double VER = 10.4;
        String ANT = "Allrad";
        String GET = "Schaltgetriebe";
        int BJ = 1992;
        int KIL = 19234;
        Date TUE = TUV;
        double KAU = 600.0;
        float GPT = 79.0F;
        boolean FAH = true;
        String EXT = "Radio";
        boolean ID = true;
        MetaController instance = new MetaController();
        int expResult = 1;
        int result = instance.addAuto(KZ, HER, MOD, BA, AK, SP, FAR, LEI, KS, VER, ANT, GET, BJ, KIL, TUE, KAU, GPT, FAH, EXT, ID);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeAuto method, of class MetaController.
     */
    @Test
    public void testRemoveAuto() {
        System.out.println("removeAuto");
        int A_ID = 4;
        Auto auto4 = new Auto(Foto1, 4, "j", "f", "f", "g", true, 4, "s", 126, "ds", 4, "sf", "GET", 1883, 8045, RD2, 543, 234, true, "fd", false);
        DBV.addAuto(auto4);
        DBV.save(pfad);
        MetaController instance = new MetaController();
        int expResult = 1;
        int result = instance.removeAuto(A_ID);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeKunde method, of class MetaController.
     */
    @Test
    public void testRemoveKunde() {
        System.out.println("removeKunde");
        int K_ID = 2;
        Kunde kunde2 = new Kunde(2, "vn"," nn", "05984", "wo", " str", "n3", "em", "059846874652", AD,  Foto1, RD2, "ads" );
        DBV.addKunde(kunde2);
        DBV.save(pfad);
        MetaController instance = new MetaController();
        int expResult = 1;
        int result = instance.removeKunde(K_ID);
        assertEquals(expResult, result);
    }

    /**
     * Test of Zahlen method, of class MetaController.
     */
    @Test
    public void testZahlen() {
        System.out.println("Zahlen");
        CharSequence input = "568452";
        String expResult = "568452";
        String result = MetaController.Zahlen(input);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of addKunde2 method, of class MetaController.
     */
    @Test
    public void testAddKunde2() {
        System.out.println("addKunde2");
        int K_ID = 99;
        String VN = "Bob";
        String NN = "Sanders";
        String PLZ = "05662";
        String WO = "Zwickau";
        String STR = "Riesenweg";
        String HN = "4535e";
        String EM = "dfsa.adsf@dsa.df";
        String TN = "08562068423";
        Date GEB = AD2;
        File FS = Foto1;
        Date FSD = RD2;
        String FSK = "B";
        MetaController instance = new MetaController();
        int expResult = 1;
        int result = instance.addKunde2(K_ID, VN, NN, PLZ, WO, STR, HN, EM, TN, GEB, FS, FSD, FSK);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of addAuto2 method, of class MetaController.
     */
    @Test
    public void testAddAuto2() {
        System.out.println("addAuto2");
        int A_ID = 99;
        String KZ = "AA-FE223";
        String HER = "Audi";
        String MOD = "Az";
        String BA = "Sport";
        boolean AK = false;
        int SP = 2;
        String FAR = "Rot";
        int LEI = 600;
        String KS = "Benzin";
        double VER = 20.0;
        String ANT = "Frontantrieb";
        String GET = "Automatikgetriebe";
        int BJ = 1960;
        int KIL = 68754;
        Date TUE = TUV;
        double KAU = 300.0;
        float GPT = 60.0F;
        boolean FAH = false;
        String EXT = "Radio";
        boolean ID = true;
        MetaController instance = new MetaController();
        int expResult = 1;
        int result = instance.addAuto2(A_ID, KZ, HER, MOD, BA, AK, SP, FAR, LEI, KS, VER, ANT, GET, BJ, KIL, TUE, KAU, GPT, FAH, EXT, ID);
        assertEquals(expResult, result);
    }
    
}
