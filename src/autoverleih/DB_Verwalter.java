/*
 Bitte alle Variablen und Methoden mit geeigneten Namen versehen und in korrekter Rechtschreibung erstellen. #Raicandy
Bitte alle Kommentare von euch mit euren Tag(Nickname) versehen und einem Hashtag davon. #Raicandy
 */
package autoverleih;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author punker
 */
@XmlRootElement(name = "Autoverleih")
public class DB_Verwalter {

//###DB_Verwalterdaten erstellt von Daniel Meerwald#############################
    @XmlElement(name = "Kundenliste")
    @XmlElementWrapper(name = "wrapper")
    List<Kunde> Kunden = new ArrayList<>();
    
    @XmlElement(name = "Autoliste")
    @XmlElementWrapper(name = "wrapper")
    List<Auto> Autos = new ArrayList<>();
    
    @XmlElement(name = "Ausleiheliste")
    @XmlElementWrapper(name = "wrapper")
    List<Ausleihe> Ausleihen = new ArrayList<>();    
    //List<Warteliste> Warteliste = new ArrayList<>();
    //List<Rechnung> Rechnungen = new ArrayList<>();
    
//###Konstruktor################################################################
    
    public DB_Verwalter(){
	
    }
    
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

    //###addKunde erstellt von Steve Vogel @Stibster################################
    public void addKunde(Kunde Kunde) {
	
	Kunden.add(Kunde);
    }
    
    //###addAuto, abholen, abgeben erstellt von Steve Vogel @Stibster###############
    public void addAuto(File Path, int AID, String KZ, String HER,String MOD, String BA, boolean AK, int SP, String FAR, int LEI, String KS, String VER, String ANT, String GET, int BJ, int KIL, Date TUE, double KAU, float GPT, boolean FAH, String EXT, boolean ID) {
        
        Auto newAuto = new Auto();
	
	Autos.add(newAuto);
    }
    
    public boolean autoAbholen() {
        
        Auto.setIst_Da(false);
        return Auto.ist_da;
    }
    
    public boolean autoAbgeben() {
        
        Auto.setIst_Da(true);
        return Auto.ist_da;
    }
    //Muss Auto_ID mit übergeben werden?
//##############################################################################
 
//###Save Methode erstellt von Daniel Meerwald##################################
    
        public void save(String pfad) {
     
       
        Listenhelper Listehelper = new Listenhelper(Kunden, Autos, Ausleihen);
	  try { 

		File file = new File(pfad);
		JAXBContext jaxbContext = JAXBContext.newInstance(Listenhelper.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller(); //Marshaller erstellen
		
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		jaxbMarshaller.marshal(Listehelper, file); //XML im pfad speichern
		jaxbMarshaller.marshal(Listehelper, System.out);

	      } catch (JAXBException e) {
		e.printStackTrace();
	      }
    }
//##############################################################################
}
