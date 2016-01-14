/*
Bitte alle Variablen und Methoden mit geeigneten Namen versehen und in korrekter Rechtschreibung erstellen. #Raicandy
Bitte alle Kommentare von euch mit euren Tag(Nickname) versehen und einem Hashtag davon. #Raicandy
 */
package autoverleih;

import java.io.File;
import java.util.Date;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Raicandy
 */
@XmlRootElement(name = "Kunde")
public class Kunde {
    
    

//###Kundendaten erstellt von Daniel Meerwald###################################
    int Kunden_ID;
    String Vorname;
    String Nachname;
    int Postleitzahl;
    String Wohnort;
    String Strasse;
    String Hausnummer;
    String E_Mail;
    String Telefonnummer;
    Date Geburtstag;
    File Fuehrerschein;
    Date Fuehrerscheindatum;
    String Fuehrerscheinklasse;
    //Rechnung Rechnung; //Kommt später noch, wenn die Klasse Rechnung implementiert wird. #Raicandy
    
         //###Konstruktoren erstellt von Danilo May############################### 
    public Kunde(int KID, String VN, String NN, int PLZ, String WO, String STR, String HN, String EM, String TN, Date GEB, File FS, Date FSD, String FSK) {
        Kunden_ID = KID;
        Vorname = VN;
        Nachname = NN;
        Postleitzahl = PLZ;
        Wohnort = WO;
        Strasse = STR;
        Hausnummer = HN;
        E_Mail = EM;
        Telefonnummer = TN;
        Geburtstag = GEB;
        Fuehrerschein = FS;
        Fuehrerscheindatum = FSD;
        Fuehrerscheinklasse = FSK;
    }
    public Kunde() {
        
    }
//###toString Methoden erstellt von Daniel Meerwald############################# 
    public String toString(){
        
        return "Kunden_ID: " + Kunden_ID + "\n" +
                "Vorname: " + Vorname + "\n"+
                "Nachname: " + Nachname + "\n" +
                "Postleitzahl: " + Postleitzahl +  "\n" +
                "Wohnort: " + Wohnort +  "\n" +
                //#######vervollständigt von Steve Vogel#####
                "Strasse: " + Strasse + "\n" +
                "Hausnummer: " + Hausnummer + "\n" +
                "E-Mail: " + E_Mail + "\n" +
                "Telefonnummer: " + Telefonnummer + "\n" +
                "Geburtstag: " + Geburtstag + "\n" +
                "Fuehrerschein: " + Fuehrerschein + "\n" +
                "Fuehrerscheindatum: " + Fuehrerscheindatum + "\n" +
                "Fuehrerscheinklasse: " + Fuehrerscheinklasse + "\n" ;
    }
//###Getter Methoden erstellt von Daniel Meerwald###############################
    @XmlElement(name = "Kunden_ID")
    public int getKunden_ID() {
        return Kunden_ID;
    }

    @XmlElement(name = "Vorname")
    public String getVorname() {
        return Vorname;
    }
    
    @XmlElement(name = "Nachname")
    public String getNachname() {
        return Nachname;
    }

    @XmlElement(name = "Postleitzahl")
    public int getPostleitzahl() {
        return Postleitzahl;
    }

    @XmlElement(name = "Wohnort")
    public String getWohnort() {
        return Wohnort;
    }

    @XmlElement(name = "Strasse")
    public String getStrasse() {
        return Strasse;
    }

    @XmlElement(name = "Hausnummer")
    public String getHausnummer() {
        return Hausnummer;
    }

    @XmlElement(name = "E_Mail")
    public String getE_Mail() {
        return E_Mail;
    }

    @XmlElement(name = "Telefonnummer")
    public String getTelefonnummer() {
        return Telefonnummer;
    }

    @XmlElement(name = "Geburtstag")
    public Date getGeburtstag() {
        return Geburtstag;
    }

    //@XmlElement(name = "Fuehrerschein") //File, vermutlich muss das seperat gespeichert werden. #Raicandy
    public File getFuehrerschein() {
        return Fuehrerschein;
    }

    @XmlElement(name = "Fuehrerscheindatum")
    public Date getFuehrerscheindatum() {
        return Fuehrerscheindatum;
    }
    
//###Setter Methoden erstellt von Daniel Meerwald###############################
    public String getFuehrerscheinklasse() {
    return Fuehrerscheinklasse;
    }

    public void setKunden_ID(int Kunden_ID) {
        this.Kunden_ID = Kunden_ID;
    }

    public void setVorname(String Vorname) {
        this.Vorname = Vorname;
    }

    public void setNachname(String Nachname) {
        this.Nachname = Nachname;
    }

    public void setPostleitzahl(int Postleitzahl) {
        this.Postleitzahl = Postleitzahl;
    }

    public void setWohnort(String Wohnort) {
        this.Wohnort = Wohnort;
    }

    public void setStrasse(String Strasse) {
        this.Strasse = Strasse;
    }

    public void setHausnummer(String Hausnummer) {
        this.Hausnummer = Hausnummer;
    }

    public void setE_Mail(String E_Mail) {
        this.E_Mail = E_Mail;
    }

    public void setTelefonnummer(String Telefonnummer) {
        this.Telefonnummer = Telefonnummer;
    }

    public void setGeburtstag(Date Geburtstag) {
        this.Geburtstag = Geburtstag;
    }

    public void setFuehrerschein(File Fuehrerschein) {
        this.Fuehrerschein = Fuehrerschein;
    }

    public void setFuehrerscheindatum(Date Fuehrerscheindatum) {
        this.Fuehrerscheindatum = Fuehrerscheindatum;
    }

    public void setFuehrerscheinklasse(String Fuehrerscheinklasse) {
        this.Fuehrerscheinklasse = Fuehrerscheinklasse;
    }
//##############################################################################
}
