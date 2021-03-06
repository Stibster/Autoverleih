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
public class AutoTest {
    Date tuev = new Date(116, 10, 2);
    File Foto1 = new File("/Data/bmw5.jpg");
    public AutoTest() {
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
     * Test of toString method, of class Auto.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Auto Proto = new Auto(Foto1, 11, "abc", "audi", "abc", "bau", true, 5, "g", 500, "b", 5, "all", "sch", 1995, 60000, tuev, 5000, 50, true, "klima", true);
        String expResult = "Auto ID: 11\nKennzeichen: abc\nHersteller: audi\nModell: abc\nBauart: bau\nAnhaengerkupplung: true\nSitzplaetze: 5\nFarbe: g\nLeistung: 500\nKraftstoff: b\nVerbrauch: 5.0\nAntrieb: all\nGetriebe: sch\nBaujahr: 1995\nKilometerstand: 60000\nTÜV: Wed Nov 02 00:00:00 CET 2016\nKaution: 5000.0\nGebuehr pro Tag: 50.0\nFahrbar: true\nExtras: klima\nGerade verfuegbar: true\n";
        String result = Proto.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFoto method, of class Auto.
     */
    @Test
    public void testGetFoto() {
        System.out.println("getFoto");
        Auto Proto = new Auto(Foto1, 11, "abc", "audi", "abc", "bau", true, 5, "g", 500, "b", 5, "all", "sch", 1995, 60000, tuev, 5000, 50, true, "klima", true);
        File expResult = Foto1;
        File result = Proto.getFoto();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAuto_ID method, of class Auto.
     */
    @Test
    public void testGetAuto_ID() {
        System.out.println("getAuto_ID");
        Auto Proto = new Auto(Foto1, 11, "abc", "audi", "abc", "bau", true, 5, "g", 500, "b", 5, "all", "sch", 1995, 60000, tuev, 5000, 50, true, "klima", true);
        int expResult = 11;
        int result = Proto.getAuto_ID();
        assertEquals(expResult, result);
    }

    /**
     * Test of getKennzeichen method, of class Auto.
     */
    @Test
    public void testGetKennzeichen() {
        System.out.println("getKennzeichen");
        Auto Proto = new Auto(Foto1, 11, "abc", "audi", "bde", "bau", true, 5, "g", 500, "b", 5, "all", "sch", 1995, 60000, tuev, 5000, 50, true, "klima", true);
        String expResult = "abc";
        String result = Proto.getKennzeichen();
        assertEquals(expResult, result);
    }

    /**
     * Test of getHersteller method, of class Auto.
     */
    @Test
    public void testGetHersteller() {
        System.out.println("getHersteller");
        Auto Proto = new Auto(Foto1, 11, "abc", "audi", "abc", "bau", true, 5, "g", 500, "b", 5, "all", "sch", 1995, 60000, tuev, 5000, 50, true, "klima", true);
        String expResult = "audi";
        String result = Proto.getHersteller();
        assertEquals(expResult, result);
    }

    /**
     * Test of getModell method, of class Auto.
     */
    @Test
    public void testGetModell() {
        System.out.println("getModell");
        Auto Proto = new Auto(Foto1, 11, "abc", "audi", "abc", "bau", true, 5, "g", 500, "b", 5, "all", "sch", 1995, 60000, tuev, 5000, 50, true, "klima", true);
        String expResult = "abc";
        String result = Proto.getModell();
        assertEquals(expResult, result);
    }

    /**
     * Test of isAnhaengerkupplung method, of class Auto.
     */
    @Test
    public void testIsAnhaengerkupplung() {
        System.out.println("isAnhaengerkupplung");
        Auto Proto = new Auto(Foto1, 11, "abc", "audi", "abc", "bau", true, 5, "g", 500, "b", 5, "all", "sch", 1995, 60000, tuev, 5000, 50, true, "klima", true);
        boolean expResult = true;
        boolean result = Proto.getAnhaengerkupplung();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSitzplaetze method, of class Auto.
     */
    @Test
    public void testGetSitzplaetze() {
        System.out.println("getSitzplaetze");
        Auto Proto = new Auto(Foto1, 11, "abc", "audi", "abc", "bau", true, 5, "g", 500, "b", 5, "all", "sch", 1995, 60000, tuev, 5000, 50, true, "klima", true);
        int expResult = 5;
        int result = Proto.getSitzplaetze();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFarbe method, of class Auto.
     */
    @Test
    public void testGetFarbe() {
        System.out.println("getFarbe");
        Auto Proto = new Auto(Foto1, 11, "abc", "audi", "abc", "bau", true, 5, "g", 500, "b", 5, "all", "sch", 1995, 60000, tuev, 5000, 50, true, "klima", true);
        String expResult = "g";
        String result = Proto.getFarbe();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLeistung method, of class Auto.
     */
    @Test
    public void testGetLeistung() {
        System.out.println("getLeistung");
        Auto Proto = new Auto(Foto1, 11, "abc", "audi", "abc", "bau", true, 5, "g", 500, "b", 5, "all", "sch", 1995, 60000, tuev, 5000, 50, true, "klima", true);
        int expResult = 500;
        int result = Proto.getLeistung();
        assertEquals(expResult, result);
    }

    /**
     * Test of getKraftstoff method, of class Auto.
     */
    @Test
    public void testGetKraftstoff() {
        System.out.println("getKraftstoff");
        Auto Proto = new Auto(Foto1, 11, "abc", "audi", "abc", "bau", true, 5, "g", 500, "b", 5, "all", "sch", 1995, 60000, tuev, 5000, 50, true, "klima", true);
        String expResult = "b";
        String result = Proto.getKraftstoff();
        assertEquals(expResult, result);
    }

    /**
     * Test of getVerbrauch method, of class Auto.
     */
    @Test
    public void testGetVerbrauch() {
        System.out.println("getVerbrauch");
        Auto Proto = new Auto(Foto1, 11, "abc", "audi", "abc", "bau", true, 5, "g", 500, "b", 5, "all", "sch", 1995, 60000, tuev, 5000, 50, true, "klima", true);
        double delta = 0.0;
        double expResult = 5.0;
        double result = Proto.getVerbrauch();
        assertEquals(expResult, result, delta);
    }

    /**
     * Test of getAntrieb method, of class Auto.
     */
    @Test
    public void testGetAntrieb() {
        System.out.println("getAntrieb");
        Auto Proto = new Auto(Foto1, 11, "abc", "audi", "abc", "bau", true, 5, "g", 500, "b", 5, "all", "sch", 1995, 60000, tuev, 5000, 50, true, "klima", true);
        String expResult = "all";
        String result = Proto.getAntrieb();
        assertEquals(expResult, result);
    }

    /**
     * Test of getGetriebe method, of class Auto.
     */
    @Test
    public void testGetGetriebe() {
        System.out.println("getGetriebe");
        Auto Proto = new Auto(Foto1, 11, "abc", "audi", "abc", "bau", true, 5, "g", 500, "b", 5, "all", "sch", 1995, 60000, tuev, 5000, 50, true, "klima", true);
        String expResult = "sch";
        String result = Proto.getGetriebe();
        assertEquals(expResult, result);
    }

    /**
     * Test of getBaujahr method, of class Auto.
     */
    @Test
    public void testGetBaujahr() {
        System.out.println("getBaujahr");
        Auto Proto = new Auto(Foto1, 11, "abc", "audi", "abc", "bau", true, 5, "g", 500, "b", 5, "all", "sch", 1995, 60000, tuev, 5000, 50, true, "klima", true);
        int expResult = 1995;
        int result = Proto.getBaujahr();
        assertEquals(expResult, result);
    }

    /**
     * Test of getKilometerstand method, of class Auto.
     */
    @Test
    public void testGetKilometerstand() {
        System.out.println("getKilometerstand");
        Auto Proto = new Auto(Foto1, 11, "abc", "audi", "abc", "bau", true, 5, "g", 500, "b", 5, "all", "sch", 1995, 60000, tuev, 5000, 50, true, "klima", true);
        int expResult = 60000;
        int result = Proto.getKilometerstand();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTUEV method, of class Auto.
     */
    @Test
    public void testGetTUEV() {
        System.out.println("getTUEV");
        Auto Proto = new Auto(Foto1, 11, "abc", "audi", "abc", "bau", true, 5, "g", 500, "b", 5, "all", "sch", 1995, 60000, tuev, 5000, 50, true, "klima", true);
        Date expResult = tuev;
        Date result = Proto.getTUEV();
        assertEquals(expResult, result);
    }

    /**
     * Test of getKaution method, of class Auto.
     */
    @Test
    public void testGetKaution() {
        System.out.println("getKaution");
        Auto Proto = new Auto(Foto1, 11, "abc", "audi", "abc", "bau", true, 5, "g", 500, "b", 5, "all", "sch", 1995, 60000, tuev, 5000, 50, true, "klima", true);
        double expResult = 5000;
        double result = Proto.getKaution();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getGebuehr_pro_Tag method, of class Auto.
     */
    @Test
    public void testGetGebuehr_pro_Tag() {
        System.out.println("getGebuehr_pro_Tag");
        Auto Proto = new Auto(Foto1, 11, "abc", "audi", "abc", "bau", true, 5, "g", 500, "b", 5, "all", "sch", 1995, 60000, tuev, 5000, 50, true, "klima", true);
        float expResult = 50F;
        float result = Proto.getGebuehr_pro_Tag();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of isFahrbar method, of class Auto.
     */
    @Test
    public void testIsFahrbar() {
        System.out.println("isFahrbar");
        Auto Proto = new Auto(Foto1, 11, "abc", "audi", "abc", "bau", true, 5, "g", 500, "b", 5, "all", "sch", 1995, 60000, tuev, 5000, 50, true, "klima", true);
        boolean expResult = true;
        boolean result = Proto.isFahrbar();
        assertEquals(expResult, result);
    }

    /**
     * Test of getIst_Da method, of class Auto.
     */
    @Test
    public void testGetIst_Da() {
        System.out.println("getIst_Da");
        Auto Proto = new Auto(Foto1, 11, "abc", "audi", "abc", "bau", true, 5, "g", 500, "b", 5, "all", "sch", 1995, 60000, tuev, 5000, 50, true, "klima", true);
        boolean expResult = true;
        boolean result = Proto.getIst_Da();
        assertEquals(expResult, result);
    }

    /**
     * Test of getExtras method, of class Auto.
     */
    @Test
    public void testGetExtras() {
        System.out.println("getExtras");
        Auto Proto = new Auto(Foto1, 11, "abc", "audi", "abc", "bau", true, 5, "g", 500, "b", 5, "all", "sch", 1995, 60000, tuev, 5000, 50, true, "klima", true);
        String expResult = "klima";
        String result = Proto.getExtras();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFoto method, of class Auto.
     */
    @Test
    public void testSetFoto() {
        System.out.println("setFoto");
        File Foto2 = new File("/Data/bmw3.jpg");
        Auto Proto = new Auto(Foto1, 11, "abc", "audi", "abc", "bau", true, 5, "g", 500, "b", 5, "all", "sch", 1995, 60000, tuev, 5000, 50, true, "klima", true);
        Proto.setFoto(Foto2);
    }

    /**
     * Test of setAuto_ID method, of class Auto.
     */
    @Test
    public void testSetAuto_ID() {
        System.out.println("setAuto_ID");
        int Auto_ID =9;
        Auto Proto = new Auto(Foto1, 11, "abc", "audi", "abc", "bau", true, 5, "g", 500, "b", 5, "all", "sch", 1995, 60000, tuev, 5000, 50, true, "klima", true);
        Proto.setAuto_ID(Auto_ID);
    }

    /**
     * Test of setKennzeichen method, of class Auto.
     */
    @Test
    public void testSetKennzeichen() {
        System.out.println("setKennzeichen");
        String Kennzeichen = "asd";
        Auto Proto = new Auto(Foto1, 11, "abc", "audi", "abc", "bau", true, 5, "g", 500, "b", 5, "all", "sch", 1995, 60000, tuev, 5000, 50, true, "klima", true);
        Proto.setKennzeichen(Kennzeichen);
    }

    /**
     * Test of setHersteller method, of class Auto.
     */
    @Test
    public void testSetHersteller() {
        System.out.println("setHersteller");
        String Hersteller = "benz";
        Auto Proto = new Auto(Foto1, 11, "abc", "audi", "abc", "bau", true, 5, "g", 500, "b", 5, "all", "sch", 1995, 60000, tuev, 5000, 50, true, "klima", true);
        Proto.setHersteller(Hersteller);
    }

    /**
     * Test of setModell method, of class Auto.
     */
    @Test
    public void testSetModell() {
        System.out.println("setModell");
        String Modell = "oh";
        Auto Proto = new Auto(Foto1, 11, "abc", "audi", "abc", "bau", true, 5, "g", 500, "b", 5, "all", "sch", 1995, 60000, tuev, 5000, 50, true, "klima", true);
        Proto.setModell(Modell);
    }

    /**
     * Test of setAnhaengerkupplung method, of class Auto.
     */
    @Test
    public void testSetAnhaengerkupplung() {
        System.out.println("setAnhaengerkupplung");
        boolean Anhaengerkupplung = false;
        Auto Proto = new Auto(Foto1, 11, "abc", "audi", "abc", "bau", true, 5, "g", 500, "b", 5, "all", "sch", 1995, 60000, tuev, 5000, 50, true, "klima", true);
        Proto.setAnhaengerkupplung(Anhaengerkupplung);
    }

    /**
     * Test of setSitzplaetze method, of class Auto.
     */
    @Test
    public void testSetSitzplaetze() {
        System.out.println("setSitzplaetze");
        int Sitzplaetze = 8;
        Auto Proto = new Auto(Foto1, 11, "abc", "audi", "abc", "bau", true, 5, "g", 500, "b", 5, "all", "sch", 1995, 60000, tuev, 5000, 50, true, "klima", true);
        Proto.setSitzplaetze(Sitzplaetze);
    }

    /**
     * Test of setFarbe method, of class Auto.
     */
    @Test
    public void testSetFarbe() {
        System.out.println("setFarbe");
        String Farbe = "b";
        Auto Proto = new Auto(Foto1, 11, "abc", "audi", "abc", "bau", true, 5, "g", 500, "b", 5, "all", "sch", 1995, 60000, tuev, 5000, 50, true, "klima", true);
        Proto.setFarbe(Farbe);
    }

    /**
     * Test of setLeistung method, of class Auto.
     */
    @Test
    public void testSetLeistung() {
        System.out.println("setLeistung");
        int Leistung = 6;
        Auto Proto = new Auto(Foto1, 11, "abc", "audi", "abc", "bau", true, 5, "g", 500, "b", 5, "all", "sch", 1995, 60000, tuev, 5000, 50, true, "klima", true);
        Proto.setLeistung(Leistung);
    }

    /**
     * Test of setKraftstoff method, of class Auto.
     */
    @Test
    public void testSetKraftstoff() {
        System.out.println("setKraftstoff");
        String Kraftstoff = "uh";
        Auto Proto = new Auto(Foto1, 11, "abc", "audi", "abc", "bau", true, 5, "g", 500, "b", 5, "all", "sch", 1995, 60000, tuev, 5000, 50, true, "klima", true);
        Proto.setKraftstoff(Kraftstoff);
    }

    /**
     * Test of setVerbrauch method, of class Auto.
     */
    @Test
    public void testSetVerbrauch() {
        System.out.println("setVerbrauch");
        double Verbrauch = 6.0;
        Auto Proto = new Auto(Foto1, 11, "abc", "audi", "abc", "bau", true, 5, "g", 500, "b", 5, "all", "sch", 1995, 60000, tuev, 5000, 50, true, "klima", true);
        Proto.setVerbrauch(Verbrauch);
    }

    /**
     * Test of setAntrieb method, of class Auto.
     */
    @Test
    public void testSetAntrieb() {
        System.out.println("setAntrieb");
        String Antrieb = "ur";
        Auto Proto = new Auto(Foto1, 11, "abc", "audi", "abc", "bau", true, 5, "g", 500, "b", 5, "all", "sch", 1995, 60000, tuev, 5000, 50, true, "klima", true);
        Proto.setAntrieb(Antrieb);
    }

    /**
     * Test of setGetriebe method, of class Auto.
     */
    @Test
    public void testSetGetriebe() {
        System.out.println("setGetriebe");
        String Getriebe = "eser";
        Auto Proto = new Auto(Foto1, 11, "abc", "audi", "abc", "bau", true, 5, "g", 500, "b", 5, "all", "sch", 1995, 60000, tuev, 5000, 50, true, "klima", true);
        Proto.setGetriebe(Getriebe);
    }

    /**
     * Test of setBaujahr method, of class Auto.
     */
    @Test
    public void testSetBaujahr() {
        System.out.println("setBaujahr");
        int Baujahr = 65;
        Auto Proto = new Auto(Foto1, 11, "abc", "audi", "abc", "bau", true, 5, "g", 500, "b", 5, "all", "sch", 1995, 60000, tuev, 5000, 50, true, "klima", true);
        Proto.setBaujahr(Baujahr);
    }

    /**
     * Test of setKilometerstand method, of class Auto.
     */
    @Test
    public void testSetKilometerstand() {
        System.out.println("setKilometerstand");
        int Kilometerstand = 546;
        Auto Proto = new Auto(Foto1, 11, "abc", "audi", "abc", "bau", true, 5, "g", 500, "b", 5, "all", "sch", 1995, 60000, tuev, 5000, 50, true, "klima", true);
        Proto.setKilometerstand(Kilometerstand);
    }

    /**
     * Test of setTUEV method, of class Auto.
     */
    @Test
    public void testSetTUEV() {
        System.out.println("setTUEV");
        Date TUEV = null;
        Auto Proto = new Auto(Foto1, 11, "abc", "audi", "abc", "bau", true, 5, "g", 500, "b", 5, "all", "sch", 1995, 60000, tuev, 5000, 50, true, "klima", true);
        Proto.setTUEV(TUEV);
    }

    /**
     * Test of setKaution method, of class Auto.
     */
    @Test
    public void testSetKaution() {
        System.out.println("setKaution");
        double Kaution = 30;
        Auto Proto = new Auto(Foto1, 11, "abc", "audi", "abc", "bau", true, 5, "g", 500, "b", 5, "all", "sch", 1995, 60000, tuev, 5000, 50, true, "klima", true);
        Proto.setKaution(Kaution);
    }

    /**
     * Test of setGebuehr_pro_Tag method, of class Auto.
     */
    @Test
    public void testSetGebuehr_pro_Tag() {
        System.out.println("setGebuehr_pro_Tag");
        float Gebuehr_pro_Tag = 60F;
        Auto Proto = new Auto(Foto1, 11, "abc", "audi", "abc", "bau", true, 5, "g", 500, "b", 5, "all", "sch", 1995, 60000, tuev, 5000, 50, true, "klima", true);
        Proto.setGebuehr_pro_Tag(Gebuehr_pro_Tag);
    }

    /**
     * Test of setFahrbar method, of class Auto.
     */
    @Test
    public void testSetFahrbar() {
        System.out.println("setFahrbar");
        boolean fahrbar = false;
        Auto Proto = new Auto(Foto1, 11, "abc", "audi", "abc", "bau", true, 5, "g", 500, "b", 5, "all", "sch", 1995, 60000, tuev, 5000, 50, true, "klima", true);
        Proto.setFahrbar(fahrbar);
    }

    /**
     * Test of setExtras method, of class Auto.
     */
    @Test
    public void testSetExtras() {
        System.out.println("setExtras");
        String Extras = "nix";
        Auto Proto = new Auto(Foto1, 11, "abc", "audi", "abc", "bau", true, 5, "g", 500, "b", 5, "all", "sch", 1995, 60000, tuev, 5000, 50, true, "klima", true);
        Proto.setExtras(Extras);
    }

    /**
     * Test of setIst_Da method, of class Auto.
     */
    @Test
    public void testSetIst_Da() {
        System.out.println("setIst_Da");
        boolean ist_da = false;
        Auto Proto = new Auto(Foto1, 11, "abc", "audi", "abc", "bau", true, 5, "g", 500, "b", 5, "all", "sch", 1995, 60000, tuev, 5000, 50, true, "klima", true);
        Proto.setIst_Da(ist_da);
    }

    /**
     * Test of getFotoString method, of class Auto.
     */
    @Test
    public void testGetFotoString() throws Exception {
        System.out.println("getFotoString");
        Auto instance = new Auto(Foto1, 11, "abc", "audi", "abc", "bau", true, 5, "g", 500, "b", 5, "all", "sch", 1995, 60000, tuev, 5000, 50, true, "klima", true);
        String expResult = "file:/C:/Data/bmw5.jpg";
        String result = instance.getFotoString();
        assertEquals(expResult, result);
     }

    /**
     * Test of getAnhaengerkupplung method, of class Auto.
     */
    @Test
    public void testGetAnhaengerkupplung() {
        System.out.println("getAnhaengerkupplung");
        Auto instance = new Auto(Foto1, 11, "abc", "audi", "abc", "bau", true, 5, "g", 500, "b", 5, "all", "sch", 1995, 60000, tuev, 5000, 50, true, "klima", true);
        boolean expResult = true;
        boolean result = instance.getAnhaengerkupplung();
        assertEquals(expResult, result);
    }

    /**
     * Test of getBauart method, of class Auto.
     */
    @Test
    public void testGetBauart() {
        System.out.println("getBauart");
        Auto instance = new Auto(Foto1, 11, "abc", "audi", "abc", "bau", true, 5, "g", 500, "b", 5, "all", "sch", 1995, 60000, tuev, 5000, 50, true, "klima", true);
        String expResult = "bau";
        String result = instance.getBauart();
        assertEquals(expResult, result);
    }

    /**
     * Test of setBauart method, of class Auto.
     */
    @Test
    public void testSetBauart() {
        System.out.println("setBauart");
        String Bauart = "art";
        Auto instance = new Auto(Foto1, 11, "abc", "audi", "abc", "bau", true, 5, "g", 500, "b", 5, "all", "sch", 1995, 60000, tuev, 5000, 50, true, "klima", true);
        instance.setBauart(Bauart);
    }
    
}
