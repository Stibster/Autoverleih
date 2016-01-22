/*
Die Klasse stellt die Ausleihe Objekte da. Sie stellt alle nötigen Methoden zum Bearbeiten der Ausleihen zur Verfügung. #Daniel Meerwald
 */
package autoverleih;

import java.util.Date;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Daniel Meerwald
 */
@XmlRootElement(name = "Ausleihe")
public class Ausleihe {

//###Ausleihedaten erstellt von Daniel Meerwald#################################

    private int Ausleihe_ID;
    private int Auto_ID;
    private int Kunden_ID;
    public Date Ausleihdatum;
    public Date Rueckgabedatum;
    boolean TUEV;
    
    
    public String toString(){ //Erstellt von Daniel Meerwald #Raicandy
        return "Kunde "+Kunden_ID+" hat den Wagen "+Auto_ID+" von "+Ausleihdatum+" bis "+Rueckgabedatum+"ausgeliehen.";
    }
    
       
//###Konstruktoren erstellt von Danilo May###################################### 
     public Ausleihe (int AID, int KID, Date AD, Date RD, boolean TUE) {
        Auto_ID = AID;
        Kunden_ID =KID;
        Ausleihdatum = AD;
        Rueckgabedatum = RD;
        TUEV = TUE;
     }

     public Ausleihe (int ausID,int carID, int cusID, Date anfD, Date backD) {
        this.Auto_ID = carID;
        this.Kunden_ID = cusID;
        this.Ausleihdatum = anfD;
        this.Rueckgabedatum = backD;
        this.Ausleihe_ID = ausID;
     } 
     
     public Ausleihe() {
         
     }
     
//###Getter Methoden erstellt von Daniel Meerwald###############################
    @XmlElement (name = "Ausleihe_ID")
    public int getAusleihe_ID() {
        return Ausleihe_ID;
    }

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
    public void setAusleihe_ID(int Ausleihe_ID) {
        this.Ausleihe_ID = Ausleihe_ID;
    }
        
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
