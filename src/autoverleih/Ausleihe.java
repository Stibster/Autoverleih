/*
Bitte alle Variablen und Methoden mit geeigneten Namen versehen und in korrekter Rechtschreibung erstellen. #Raicandy
Bitte alle Kommentare von euch mit euren Tag(Nickname) versehen und einem Hashtag davon. #Raicandy
 */
package autoverleih;

import java.util.Date;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Raicandy
 */
@XmlRootElement(name = "Ausleihe")
public class Ausleihe {

//###Ausleihedaten erstellt von Daniel Meerwald#################################
    int Auto_ID;
    int Kunden_ID;
    Date Ausleihdatum;
    Date Rueckgabedatum;
    boolean TUEV;
    
    
    public String toString(){ //Erstellt von Daniel Meerwald #Raicandy
        return "Kunde "+Kunden_ID+" hat den Wagen "+Auto_ID+" von "+Ausleihdatum+" bis "+Rueckgabedatum+"ausgeliehen.";
    }
    
<<<<<<< HEAD
        
     //###Konstruktoren erstellt von Danilo May############################### 
=======
//###Konstruktoren erstellt von Danilo May############################### 
>>>>>>> fa1d40ccdee21de9e8d67fb96f67caa2c813fc79
     public Ausleihe (int AID, int KID, Date AD, Date RD, boolean TUE) {
        Auto_ID = AID;
        Kunden_ID =KID;
        Ausleihdatum = AD;
        Rueckgabedatum = RD;
        TUEV = TUE;
     }
     
     public Ausleihe() {
         
     }
     
//###Getter Methoden erstellt von Daniel Meerwald###############################
    @XmlElement(name = "Auto_ID")
    public int getAuto_ID() {
        return Auto_ID;
    }

    @XmlElement(name = "Kunden_ID")
    public int getKunden_ID() {
        return Kunden_ID;
    }

    @XmlElement(name = "Ausleihdatum")
    public Date getAusleihdatum() {
        return Ausleihdatum;
    }

    @XmlElement(name = "Rueckgabedatum")
    public Date getRueckgabedatum() {
        return Rueckgabedatum;
    }
    
    @XmlElement(name = "TUEV")
    public boolean isTUEV() {
    return TUEV;
    }
    
//###Setter Methoden erstellt von Daniel Meerwald###############################
    public void setAuto_ID(int Auto_ID) {
    this.Auto_ID = Auto_ID;
    }

    public void setKunden_ID(int Kunden_ID) {
        this.Kunden_ID = Kunden_ID;
    }

    public void setAusleihdatum(Date Ausleihdatum) {
        this.Ausleihdatum = Ausleihdatum;
    }

    public void setRueckgabedatum(Date Rueckgabedatum) {
        this.Rueckgabedatum = Rueckgabedatum;
    }
    public void setTUEV(boolean TUEV) {
        this.TUEV = TUEV;
    }
//##############################################################################
}
