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
 * @author Raicandy = Daniel Meerwald
 */
@XmlRootElement(name = "Auto")
public class Auto {
    
//###Autodaten erstellt von Daniel Meerwald#####################################
    File Foto;
    int Auto_ID; 
    String Kennzeichen;
    String Hersteller;
    String Modell;
    String Bauart;
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
    boolean ist_da;
    // list Werkstattfall; //Wird erst später gebraucht, wurde der Vollständigkeit halber aber schon aufgelistet. #Raicandy
    // list Schadensfall; //Dito. #Raicandy
     
         //###Konstruktoren erstellt von Danilo May############################### 
    public Auto(File Path, int AID, String KZ, String HER,String MOD, String BA, boolean AK, int SP, String FAR, int LEI, String KS, String VER, String ANT, String GET, int BJ, int KIL, Date TUE, double KAU, float GPT, boolean FAH, String EXT, boolean ID) {
        Foto = Path;
        Auto_ID = AID; 
        Kennzeichen =KZ;
        Hersteller= HER;
        Modell = MOD;
        Bauart = BA;
        Anhaengerkupplung = AK;
        Sitzplaetze = SP;
        Farbe = FAR; 
        Leistung= LEI;
        Kraftstoff = KS;
        Verbrauch = VER;
        Antrieb = ANT;
        Getriebe = GET;
        Baujahr = BJ;
        Kilometerstand = KIL;
        TUEV = TUE; 
        Kaution = KAU;
        Gebuehr_pro_Tag = GPT;
        fahrbar = FAH;
        Extras = EXT;
        ist_da = ID;   
    }
    public Auto(int AID, String KZ) {
        Auto_ID = AID;
        Kennzeichen = KZ;
    }
    //### Christopher Haack####
    public Auto()
    {
    }
    //############################
    
//###toString Methoden erstellt von Daniel Meerwald############################# 
    public String toString(){
        
        return "Auto ID: " + Auto_ID + "\n" +
                "Kennzeichen: " + Kennzeichen + "\n"+
                "Hersteller: " + Hersteller + "\n" +
                "Modell: " + Modell +  "\n" +
                "Bauart: " + Bauart +  "\n" +
                //#######vervollständigt von Steve Vogel#####
                "Anhaengerkupplung: " + Anhaengerkupplung +  "\n" +
                "Sitzplaetze: " + Sitzplaetze +  "\n" +
                "Farbe: " + Farbe +  "\n" +
                "Leistung: " + Leistung +  "\n" +
                "Kraftstoff: " + Kraftstoff +  "\n" +
                "Verbrauch: " + Verbrauch +  "\n" +
                "Antrieb: " + Antrieb +  "\n" +
                "Getriebe: " + Getriebe +  "\n" +
                "Baujahr: " + Baujahr +  "\n" +
                "Kilometerstand: " + Kilometerstand +  "\n" +
                "TÜV: " + TUEV +  "\n" +
                "Kaution: " + Kaution +  "\n" +
                "Gebuehr pro Tag: " + Gebuehr_pro_Tag +  "\n" +
                "Fahrbar: " + fahrbar +  "\n" +
                "Extras: " + Extras +  "\n" +
                "Gerade verfuegbar: " + ist_da +  "\n" ;
    }
    
//###Getter Methoden erstellt von Daniel Meerwald###############################  
    //@XmlElement(name = "Foto") //Typ file müssen wir glaube ich seperat speichern. #Raicandy
    public File getFoto() {
        return Foto;
    }
    
    @XmlElement(name = "Auto_ID")
    public int getAuto_ID() {
        return Auto_ID;
    }

    @XmlElement(name = "Kennzeichen")
    public String getKennzeichen() {
        return Kennzeichen;
    }

    @XmlElement(name = "Hersteller")
    public String getHersteller() {
        return Hersteller;
    }

    @XmlElement(name = "Modell")
    public String getModell() {
        return Modell;
    }

    @XmlElement(name = "Anhaengerkupplung")
    public boolean isAnhaengerkupplung() {
        return Anhaengerkupplung;
    }

    @XmlElement(name = "Sitzplaetze")
    public int getSitzplaetze() {
        return Sitzplaetze;
    }

    @XmlElement(name = "Farbe")
    public String getFarbe() {
        return Farbe;
    }

    @XmlElement(name = "Leistung")
    public int getLeistung() {
        return Leistung;
    }

    @XmlElement(name = "Kraftstoff")
    public String getKraftstoff() {
        return Kraftstoff;
    }

    @XmlElement(name = "Verbrauch")
    public String getVerbrauch() {
        return Verbrauch;
    }

    @XmlElement(name = "Antrieb")
    public String getAntrieb() {
        return Antrieb;
    }

    @XmlElement(name = "Getriebe")
    public String getGetriebe() {
        return Getriebe;
    }

    @XmlElement(name = "Baujahr")
    public int getBaujahr() {
        return Baujahr;
    }

    @XmlElement(name = "Kilometerstand")
    public int getKilometerstand() {
        return Kilometerstand;
    }

    @XmlElement(name = "TUEV")
    public Date getTUEV() {
        return TUEV;
    }

    @XmlElement(name = "Kaution")
    public double getKaution() {
        return Kaution;
    }

    @XmlElement(name = "Gebuehr_pro_Tag")
    public float getGebuehr_pro_Tag() {
        return Gebuehr_pro_Tag;
    }

    @XmlElement(name = "Fahrbar")
    public boolean isFahrbar() {
        return fahrbar;
    }
    
    @XmlElement(name = "ist_da")
    public boolean getIst_Da() {
        return ist_da;
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
    
    public void setIst_Da(boolean ist_da) {
        this.ist_da = ist_da;
    }
//##############################################################################   
}
