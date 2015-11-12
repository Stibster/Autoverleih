/*
Bitte alle Variablen und Methoden mit geeigneten Namen versehen und in korrekter Rechtschreibung erstellen. #Raicandy
 */
package autoverleih;

import java.io.File;
import java.util.Date;

/**
 *
 * @author Raicandy
 */
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
    int Telefonnummer;
    Date Geburtstag;
    File Fuehrerschein;
    Date Fuehrerscheindatum;
    String Fuehrerscheinklasse;
    //Rechnung Rechnung; //Kommt später noch, wenn die Klasse Rechnung implementiert wird.
    
//###Getter Methoden erstellt von Daniel Meerwald###############################
    public int getKunden_ID() {
        return Kunden_ID;
    }

    public String getVorname() {
        return Vorname;
    }

    public String getNachname() {
        return Nachname;
    }

    public int getPostleitzahl() {
        return Postleitzahl;
    }

    public String getWohnort() {
        return Wohnort;
    }

    public String getStrasse() {
        return Strasse;
    }

    public String getHausnummer() {
        return Hausnummer;
    }

    public String getE_Mail() {
        return E_Mail;
    }

    public int getTelefonnummer() {
        return Telefonnummer;
    }

    public Date getGeburtstag() {
        return Geburtstag;
    }

    public File getFuehrerschein() {
        return Fuehrerschein;
    }

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

    public void setTelefonnummer(int Telefonnummer) {
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
