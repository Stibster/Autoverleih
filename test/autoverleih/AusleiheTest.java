/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoverleih;

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
public class AusleiheTest {
    
    Date AD = new Date(116, 5, 10);
    Date RD = new Date(116, 5, 15);
    Date AD2 = new Date(116, 6, 10);
    Date RD2 = new Date(116, 6, 10);
    
    public AusleiheTest() {
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
     * Test of toString method, of class Ausleihe.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Ausleihe instance = new Ausleihe(1, 2, AD, RD, true);
        String expResult = "Kunde 2 hat den Wagen 1 von Fri Jun 10 00:00:00 CEST 2016 bis Wed Jun 15 00:00:00 CEST 2016ausgeliehen.";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAuto_ID method, of class Ausleihe.
     */
    @Test
    public void testGetAuto_ID() {
        System.out.println("getAuto_ID");
        Ausleihe instance = new Ausleihe(1, 2, AD, RD, true);
        int expResult = 1;
        int result = instance.getAuto_ID();
        assertEquals(expResult, result);
    }

    /**
     * Test of getKunden_ID method, of class Ausleihe.
     */
    @Test
    public void testGetKunden_ID() {
        System.out.println("getKunden_ID");
        Ausleihe instance = new Ausleihe(1, 2, AD, RD, true);
        int expResult = 2;
        int result = instance.getKunden_ID();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAusleihdatum method, of class Ausleihe.
     */
    @Test
    public void testGetAusleihdatum() {
        System.out.println("getAusleihdatum");
        Ausleihe instance = new Ausleihe(1, 2, AD, RD, true);
        Date expResult = AD;
        Date result = instance.getAusleihdatum();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRueckgabedatum method, of class Ausleihe.
     */
    @Test
    public void testGetRueckgabedatum() {
        System.out.println("getRueckgabedatum");
        Ausleihe instance = new Ausleihe(1, 2, AD, RD, true);
        Date expResult = RD;
        Date result = instance.getRueckgabedatum();
        assertEquals(expResult, result);
    }

    /**
     * Test of isTUEV method, of class Ausleihe.
     */
    @Test
    public void testIsTUEV() {
        System.out.println("isTUEV");
        Ausleihe instance = new Ausleihe(1, 2, AD, RD, true);
        boolean expResult = true;
        boolean result = instance.isTUEV();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAuto_ID method, of class Ausleihe.
     */
    @Test
    public void testSetAuto_ID() {
        System.out.println("setAuto_ID");
        int Auto_ID = 3;
        Ausleihe instance = new Ausleihe(1, 2, AD, RD, true);
        instance.setAuto_ID(Auto_ID);
    }

    /**
     * Test of setKunden_ID method, of class Ausleihe.
     */
    @Test
    public void testSetKunden_ID() {
        System.out.println("setKunden_ID");
        int Kunden_ID = 4;
        Ausleihe instance = new Ausleihe(1, 2, AD, RD, true);
        instance.setKunden_ID(Kunden_ID);
    }

    /**
     * Test of setAusleihdatum method, of class Ausleihe.
     */
    @Test
    public void testSetAusleihdatum() {
        System.out.println("setAusleihdatum");
        Date Ausleihdatum = AD2;
        Ausleihe instance = new Ausleihe(1, 2, AD, RD, true);
        instance.setAusleihdatum(Ausleihdatum);
    }

    /**
     * Test of setRueckgabedatum method, of class Ausleihe.
     */
    @Test
    public void testSetRueckgabedatum() {
        System.out.println("setRueckgabedatum");
        Date Rueckgabedatum = RD2;
        Ausleihe instance = new Ausleihe(1, 2, AD, RD, true);
        instance.setRueckgabedatum(Rueckgabedatum);
    }

    /**
     * Test of setTUEV method, of class Ausleihe.
     */
    @Test
    public void testSetTUEV() {
        System.out.println("setTUEV");
        boolean TUEV = false;
        Ausleihe instance = new Ausleihe(1, 2, AD, RD, true);
        instance.setTUEV(TUEV);
    }

    /**
     * Test of getAusleihe_ID method, of class Ausleihe.
     */
    @Test
    public void testGetAusleihe_ID() {
        System.out.println("getAusleihe_ID");
        Ausleihe instance = new Ausleihe(1, 2, AD, RD, true);
        int expResult = 0;
        int result = instance.getAusleihe_ID();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAusleihe_ID method, of class Ausleihe.
     */
    @Test
    public void testSetAusleihe_ID() {
        System.out.println("setAusleihe_ID");
        int Ausleihe_ID = 1;
        Ausleihe instance = new Ausleihe(1, 2, AD, RD, true);
        instance.setAusleihe_ID(Ausleihe_ID);
    }
    
}
