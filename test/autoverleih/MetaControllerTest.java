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
    Date AD = new Date(116, 5, 10);
    Date RD = new Date(116, 5, 15);
    Date AD2 = new Date(116, 6, 10);
    Date RD2 = new Date(116, 6, 15);
    File Foto1 = new File("C:\\Autoverleih\\Test2");
    Date TUV = new Date(120, 10,4);
    
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
        Date date = null;
        GregorianCalendar expResult = null;
        GregorianCalendar result = MetaController.DateToCalendar(date);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        MetaController instance = new MetaController();
        int expResult = 1;
        int result = instance.addAusleihe(Auto_ID, Kunden_ID, Ausleihdatum, Rueckgabedatum);
        assertEquals(expResult, result);
    }

    /**
     * Test of Auto_abholen method, of class MetaController.
     */
    @Test
    public void testAuto_abholen() {
        System.out.println("Auto_abholen");
        int A_ID = 1;
        MetaController instance = new MetaController();
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
        int A_ID = 1;
        MetaController instance = new MetaController();
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
        String VN = "Hans";
        String NN = "Kröger";
        int PLZ = 67892;
        String WO = "Dorf";
        String STR = "Hauptstraße";
        String HN = "5a";
        String EM = "Hans23.Kroe@kdd.er";
        int TN = 2379621;
        Date GEB = AD2 ;
        File FS = Foto1;
        Date FSD = RD2;
        String FSK = "h6";
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
        File PATH = Foto1;
        String KZ = "B A 5";
        String HER = "BMW";
        String MOD = "A6";
        String BA = "Sport";
        boolean AK = true;
        int SP = 6;
        String FAR = "Grün";
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
        int result = instance.addAuto(PATH, KZ, HER, MOD, BA, AK, SP, FAR, LEI, KS, VER, ANT, GET, BJ, KIL, TUE, KAU, GPT, FAH, EXT, ID);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeAuto method, of class MetaController.
     */
    @Test
    public void testRemoveAuto() {
        System.out.println("removeAuto");
        int A_ID = 1;
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
        int K_ID = 1;
        MetaController instance = new MetaController();
        int expResult = 1;
        int result = instance.removeKunde(K_ID);
        assertEquals(expResult, result);
    }
    
}
