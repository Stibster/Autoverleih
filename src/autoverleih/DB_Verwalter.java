/*
 Bitte alle Variablen und Methoden mit geeigneten Namen versehen und in korrekter Rechtschreibung erstellen. #Raicandy
Bitte alle Kommentare von euch mit euren Tag(Nickname) versehen und einem Hashtag davon. #Raicandy
 */
package autoverleih;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author punker
 */
public class DB_Verwalter {

//###DB_Verwalterdaten erstellt von Daniel Meerwald#############################
    List<Kunde> Kunden = new ArrayList<>();
    List<Auto> Autos = new ArrayList<>();
    List<Ausleihe> Ausleihen = new ArrayList<>();    
    //List<Warteliste> Warteliste = new ArrayList<>();
    //List<Rechnung> Rechnungen = new ArrayList<>();
    
//###Getter Methoden erstellt von Daniel Meerwald###############################
    public List<Kunde> getKunden() {
    return Kunden;
    }

    public List<Auto> getAutos() {
        return Autos;
    }
    
    public List<Ausleihe> getAusleihen() {
    return Ausleihen;
    }
//###Setter Methoden erstellt von Daniel Meerwald###############################
        public void setKunden(List<Kunde> Kunden) {
        this.Kunden = Kunden;
    }

    public void setAutos(List<Auto> Autos) {
        this.Autos = Autos;
    }
    public void setAusleihen(List<Ausleihe> Ausleihen) {
    this.Ausleihen = Ausleihen;
    }
//##############################################################################
}
