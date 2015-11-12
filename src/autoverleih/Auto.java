/*
Bitte alle Variablen und Methoden mit geeigneten Namen versehen und in korrekter Rechtschreibung erstellen. #Raicandy
 */
package autoverleih;

import java.io.File;
import java.util.Date;




/**
 *
 * @author Raicandy = Daniel Meerwald
 */
public class Auto {
    
//###Autodaten erstellt von Daniel Meerwald#####################################
    File Foto;
    int Auto_ID; 
    String Kennzeichen;
    String Hersteller;
    String Modell;
    boolean Anhaengerkupplung;
    int Sitzplaetze;
    String Farbe; 
    int Leistung;
    String Kraftstoff;
    String Verbrauch;
    String Antrieb;
    String Getriebe;
    int Baujahr; //int ist einfach einfacher als date, da es nur um das Jahr geht. #Raicandy
    int Kilometerstand;
    Date TUEV; 
    double Kaution;
    float Gebuehr_pro_Tag;
    boolean fahrbar;
    String Extras;
    
    // list Werkstattfall; //WIrd erst später gebraucht, wurde der Vollständigkeit halber aber schon aufgelistet.
    // list Schadensfall; //Dito.
 
    
//###Getter Methoden erstellt von Daniel Meerwald###############################   
    public File getFoto() {
        return Foto;
    }

    public int getAuto_ID() {
        return Auto_ID;
    }

    public String getKennzeichen() {
        return Kennzeichen;
    }

    public String getHersteller() {
        return Hersteller;
    }

    public String getModell() {
        return Modell;
    }

    public boolean isAnhaengerkupplung() {
        return Anhaengerkupplung;
    }

    public int getSitzplaetze() {
        return Sitzplaetze;
    }

    public String getFarbe() {
        return Farbe;
    }

    public int getLeistung() {
        return Leistung;
    }

    public String getKraftstoff() {
        return Kraftstoff;
    }

    public String getVerbrauch() {
        return Verbrauch;
    }

    public String getAntrieb() {
        return Antrieb;
    }

    public String getGetriebe() {
        return Getriebe;
    }

    public int getBaujahr() {
        return Baujahr;
    }

    public int getKilometerstand() {
        return Kilometerstand;
    }

    public Date getTUEV() {
        return TUEV;
    }

    public double getKaution() {
        return Kaution;
    }

    public float getGebuehr_pro_Tag() {
        return Gebuehr_pro_Tag;
    }

    public boolean isFahrbar() {
        return fahrbar;
    }

//###Setter Methoden erstellt von Daniel Meerwald###############################    
    public String getExtras() {
        return Extras;
    }

    public void setFoto(File Foto) {
        this.Foto = Foto;
    }

    public void setAuto_ID(int Auto_ID) {
        this.Auto_ID = Auto_ID;
    }

    public void setKennzeichen(String Kennzeichen) {
        this.Kennzeichen = Kennzeichen;
    }

    public void setHersteller(String Hersteller) {
        this.Hersteller = Hersteller;
    }

    public void setModell(String Modell) {
        this.Modell = Modell;
    }

    public void setAnhaengerkupplung(boolean Anhaengerkupplung) {
        this.Anhaengerkupplung = Anhaengerkupplung;
    }

    public void setSitzplaetze(int Sitzplaetze) {
        this.Sitzplaetze = Sitzplaetze;
    }

    public void setFarbe(String Farbe) {
        this.Farbe = Farbe;
    }

    public void setLeistung(int Leistung) {
        this.Leistung = Leistung;
    }

    public void setKraftstoff(String Kraftstoff) {
        this.Kraftstoff = Kraftstoff;
    }

    public void setVerbrauch(String Verbrauch) {
        this.Verbrauch = Verbrauch;
    }

    public void setAntrieb(String Antrieb) {
        this.Antrieb = Antrieb;
    }

    public void setGetriebe(String Getriebe) {
        this.Getriebe = Getriebe;
    }

    public void setBaujahr(int Baujahr) {
        this.Baujahr = Baujahr;
    }

    public void setKilometerstand(int Kilometerstand) {
        this.Kilometerstand = Kilometerstand;
    }

    public void setTUEV(Date TUEV) {
        this.TUEV = TUEV;
    }

    public void setKaution(double Kaution) {
        this.Kaution = Kaution;
    }

    public void setGebuehr_pro_Tag(float Gebuehr_pro_Tag) {
        this.Gebuehr_pro_Tag = Gebuehr_pro_Tag;
    }

    public void setFahrbar(boolean fahrbar) {
        this.fahrbar = fahrbar;
    }

    public void setExtras(String Extras) {
        this.Extras = Extras;
    }
//##############################################################################
    
    
}
