/*
Bitte alle Variablen und Methoden mit geeigneten Namen versehen und in korrekter Rechtschreibung erstellen. #Raicandy
 */
package autoverleih;

import java.util.Date;

/**
 *
 * @author Raicandy
 */
public class Ausleihe {

//###Ausleihedaten erstellt von Daniel Meerwald#################################
    int Auto_ID;
    int Kunden_ID;
    Date Ausleihdatum;
    Date Rueckgabedatum;
    boolean TUEV;
    
//###Getter Methoden erstellt von Daniel Meerwald###############################
    public int getAuto_ID() {
        return Auto_ID;
    }

    public int getKunden_ID() {
        return Kunden_ID;
    }

    public Date getAusleihdatum() {
        return Ausleihdatum;
    }

    public Date getRueckgabedatum() {
        return Rueckgabedatum;
    }
    
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
