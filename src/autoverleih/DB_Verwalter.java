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
import javax.xml.bind.Unmarshaller;
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
    
//###feherl meldung von Bool anderungweg von Christopher Haack##################
    Auto Auto = new Auto();
    //versteh nur noicht wiso wir dann auch keine instance von Kunde benotigen?
//##############################################################################
    
//############################# User erstellung Christopher Haack###############
 
    @XmlElement(name = "Userliste")
    @XmlElementWrapper(name = "wrapper")
    List<User> Users = new ArrayList<>();
    
//##############################################################################
    
//###Konstruktor################################################################
    
    public DB_Verwalter(){
	
    }
    
//###Listen.Anzeige-Methoden erstellt von Daniel Meerwald#######################
    public void Autos_anzeigen(){
        int i = 0;

        while (i <= Autos.size()-1) { 

                System.out.println("ID: " + Autos.get(i).getAuto_ID() + " Hersteller: " + Autos.get(i).getHersteller() + 
                     " Modell: " +  Autos.get(i).getModell() + " Kennzeichen: " + Autos.get(i).getKennzeichen()); 
                
                i++; 
            
        }
    }
    
    
    
    public void Kunden_anzeigen(){
        int i = 0;

        while (i <= Kunden.size()-1) { 
            
            System.out.println("KundenID: " + Kunden.get(i).getKunden_ID() + " Name: " + Kunden.get(i).getVorname() + " " +  Kunden.get(i).getNachname());
            
                
           i++;
            
        }
    }
    
    
    
    public void Ausleihen_anzeigen(){
        int i = 0;

        while (i <= Ausleihen.size()-1) {

                System.out.println("Kunden " + Ausleihen.get(i).getKunden_ID() + " hat das Auto " + Ausleihen.get(i).getKunden_ID() + " von " + Ausleihen.get(i).getAusleihdatum() + " bis " + Ausleihen.get(i).getRueckgabedatum() + " gemietet.");
                
                i++; 
        }
    }
//###Ausleihen und zurueckgeben Methoden erstellt von Daniel Meerwald###########
    
    public void Auto_abholen(int A_ID){
        int i = 0;
        boolean indikator = false;

        while (i < Autos.size() && indikator == false) { //Suche bis zum Ende der Liste.

            if (Autos.get(i).getAuto_ID() == A_ID ) {
                Autos.get(i).setIst_Da(false);
                indikator = true; //Ende der Methode, wenn das Objekt gefunden wurde.
            } else {
                i++; //Andernfalls wird das nächste Element vergleichen.
            }
        }
    }
    
    public void Auto_zurueckbringen(int A_ID){
        int i = 0;
        boolean indikator = false;

        while (i < Autos.size() && indikator == false) { //Suche bis zum Ende der Liste.

            if (Autos.get(i).getAuto_ID() == A_ID ) {
                Autos.get(i).setIst_Da(true);
                indikator = true; //Ende der Methode, wenn das Objekt gefunden wurde.
            } else {
                i++; //Andernfalls wird das nächste Element vergleichen.
            }
        }
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

    //####Remove Methoden, erstellt von Daniel Meerwald#Raicandy################
    public void removeKunde(int K_ID){
        int i = 0;
        boolean indikator = false;

        while (i < Kunden.size() && indikator == false) { //Suche bis zum Ende der Liste.

            if (Kunden.get(i).getKunden_ID() == K_ID ) {
                Kunden.remove(i);
                indikator = true; //Ende der Methode, wenn das Objekt gefunden wurde.
            } else {
                i++; //Andernfalls wird das nächste Element vergleichen.
            }
        }
    }
    public void removeAuto(int A_ID){
        int i = 0;
        boolean indikator = false;

        while (i < Autos.size() && indikator == false) { //Suche bis zum Ende der Liste.

            if (Autos.get(i).getAuto_ID() == A_ID ) {
                Autos.remove(i);
                indikator = true; //Ende der Methode, wenn das Objekt gefunden wurde.
            } else {
                i++; //Andernfalls wird das nächste Element vergleichen.
            }
        }
    }
    public void removeAusleihe(int K_ID, int A_ID){
        int i = 0;
        boolean indikator = false;

        while (i < Ausleihen.size() && indikator == false) { //Suche bis zum Ende der Liste.

            if (Ausleihen.get(i).getKunden_ID() == K_ID &&Ausleihen.get(i).getAuto_ID() == A_ID) {
                Ausleihen.remove(i);
                indikator = true; //Ende der Methode, wenn das Objekt gefunden wurde.
            } else {
                i++; //Andernfalls wird das nächste Element vergleichen.
            }
        }
    }
    //###add Methoden erstellt von Steve Vogel @Stibster########################
    public void addAuto(Auto auto) {
        
       	Autos.add(auto);
    }
    
    public void addAusleihe(Ausleihe ausleihe)
    {
	Ausleihen.add(ausleihe);
    }
    
    public void addKunde(Kunde Kunde) {
	
	Kunden.add(Kunde);
    }
 
//###Save Methode erstellt von Daniel Meerwald##################################
    
        public void save(String pfad) {
     
        Listenhelper Listehelper = new Listenhelper(Kunden, Autos, Ausleihen,Users);
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
	
//######################## Christopher Haack User add,set,remoove, anzeigen
    public List<User> getUsers() {
        return Users;
    }
    
    public void setUser(List<User> Users) 
    {
        this.Users = Users;
    }
    
    public void addUser(User user) 
    {
        
       	Users.add(user);
    }
    
    public void removeUser(int U_ID)
    {
        int i = 0;
        boolean indikator = false;

        while (i < Users.size() && indikator == false) { //Suche bis zum Ende der Liste.

            if (Users.get(i).getUser_ID() == U_ID ) {
                Users.remove(i);
                indikator = true; //Ende der Methode, wenn das Objekt gefunden wurde.
            } else {
                i++; //Andernfalls wird das nächste Element vergleichen.
            }
        }
    }
    
     public void User_anzeigen()
    {
        int i = 0;

        while (i <= Users.size()-1) { 
            
            System.out.println("KundenID: " + Users.get(i).getUser_ID() + " Name: " + 
		    Users.get(i).getUser_NAME() + " " +  Users.get(i).getUser_PW());           
           i++;
            
        }
    }
//############################################################################## 
 
//###Restore Methode erstellt von Daniel Meerwald###############################
        public void restore(String pfad) { 
            
        Listenhelper Listehelper = new Listenhelper(Kunden, Autos, Ausleihen,Users);
    try {

		File file = new File(pfad);
		JAXBContext jaxbContext = JAXBContext.newInstance(Listenhelper.class);

		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		Listehelper = (Listenhelper) jaxbUnmarshaller.unmarshal(file);

	  } catch (JAXBException e) {
		e.printStackTrace();
	  }
    
          Kunden.clear();
          Kunden = Listehelper.getKunden();
    
          Autos.clear();
          Autos = Listehelper.getAutos();
          
          Ausleihen.clear();
          Ausleihen = Listehelper.getAusleihen();
	  
	  //###########Christopher Haack###########
	  Users.clear();
	  Users = Listehelper.getUsers();
	  //#################
    }
//##############################################################################
}
