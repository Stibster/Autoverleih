/*
DB_Verwalter Klasse, die Klasse enthält alle Nötigen Arrays für Autos, Kunden, Ausleihen und User, sowie alle Grundfunktionen des Programms # Daniel Meerwald
 */
package autoverleih;

import java.io.File;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Daniel Meerwald
 */
@XmlRootElement(name = "Autoverleih")
public class DB_Verwalter {

//###DB_Verwalterdaten erstellt von Daniel Meerwald#############################
    @XmlElement(name = "Kundenliste")
    @XmlElementWrapper(name = "wrapper")
    public List<Kunde> Kunden = new ArrayList<>();
    
    @XmlElement(name = "Autoliste")
    @XmlElementWrapper(name = "wrapper")
    public List<Auto> Autos = new ArrayList<>();
    
    @XmlElement(name = "Ausleiheliste")
    @XmlElementWrapper(name = "wrapper")
    public List<Ausleihe> Ausleihen = new ArrayList<>();    

//############################# User erstellung Christopher Haack ###############
 
    @XmlElement(name = "Userliste")
    @XmlElementWrapper(name = "wrapper")
    List<User> Users = new ArrayList<>();
    
//###Konstruktor################################################################
    
    public DB_Verwalter(){
	
    }
    
//###Clear-Methoden erstellt von Daniel Meerwald################################
    
public void clearAll(){
    Kunden.clear();
    Autos.clear();
    Ausleihen.clear();
}
public void clearAutos(){
    Autos.clear();
}
public void clearKunden(){
    Kunden.clear();
}
public void clearAusleihen(){
    Ausleihen.clear();
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
//###getbyID  Methoden erstellt von Daniel Meerwald#############################

    public Auto getAutobyID(int A_ID){
        int i = 0;
        boolean indikator = false;

        while (i < Autos.size() && indikator == false) { //Suche bis zum Ende der Liste.

            if (Autos.get(i).getAuto_ID() == A_ID ) {
                indikator = true; //Ende der Methode, wenn das Objekt gefunden wurde.
            } else {
                i++; //Andernfalls wird das nächste Element vergleichen.
            }
        }
        return Autos.get(i);
    }
    
    public Kunde getKundebyID(int K_ID){
        int i = 0;
        boolean indikator = false;

        while (i < Kunden.size() && indikator == false) { //Suche bis zum Ende der Liste.

            if (Kunden.get(i).getKunden_ID() == K_ID ) {
                indikator = true; //Ende der Methode, wenn das Objekt gefunden wurde.
            } else {
                i++; //Andernfalls wird das nächste Element vergleichen.
            }
        }
        return Kunden.get(i);
    }
    
    public Ausleihe getAusleihebyID(int A_ID){
        int i = 0;
        boolean indikator = false;

        while (i < Ausleihen.size() && indikator == false) { //Suche bis zum Ende der Liste.

            if (Ausleihen.get(i).getAusleihe_ID()== A_ID ) {
                indikator = true; //Ende der Methode, wenn das Objekt gefunden wurde.
            } else {
                i++; //Andernfalls wird das nächste Element vergleichen.
            }
        }
        if(indikator == true){
        return Ausleihen.get(i);
        }
        else{
            return null;
        }
    }
    
//###Ausleihen und zurueckgeben Methoden erstellt von Daniel Meerwald########### 
    public void Auto_abholen(int A_ID){
        getAutobyID(A_ID).setIst_Da(false);
    }
    
    public void Auto_zurueckbringen(int A_ID){
        getAutobyID(A_ID).setIst_Da(true);
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

//###MakeID Methoden erstellt von Daniel Meerwald###############################
    
    public int makeAutoID(){
        int i = 0;
        int A_ID = 1;
        while (i < Autos.size()) { //Suche bis zum Ende der Liste.

            if (Autos.get(i).getAuto_ID() == A_ID ) {
                A_ID++;
            } else {
                i++; //Andernfalls wird das nächste Element vergleichen.
            }
        }
        return A_ID;
    }
    
    public int makeKundenID(){
        int i = 0;
        int K_ID = 1;
        while (i < Kunden.size()) { //Suche bis zum Ende der Liste.

            if (Kunden.get(i).getKunden_ID() == K_ID ) {
                K_ID++;
                
            } else {
                i++; //Andernfalls wird das nächste Element vergleichen.
            }
        }
        return K_ID;
    }
    
    public int makeAusleiheID(){
        int i = 0;
        int Au_ID = 1;
        while (i < Ausleihen.size()) { //Suche bis zum Ende der Liste.

            if (Ausleihen.get(i).getKunden_ID() == Au_ID ) {
                Au_ID++;
                
            } else {
                i++; //Andernfalls wird das nächste Element vergleichen.
            }
        }
        return Au_ID;
    }
    
//####Remove Methoden, erstellt von Daniel Meerwald#############################
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
    public void removeAusleihe(int A_ID){
        int i = 0;
        boolean indikator = false;

        while (i < Ausleihen.size() && indikator == false) { //Suche bis zum Ende der Liste.

            if (Ausleihen.get(i).getAusleihe_ID()== A_ID) {
                Ausleihen.remove(i);
                indikator = true; //Ende der Methode, wenn das Objekt gefunden wurde.
            } else {
                i++; //Andernfalls wird das nächste Element vergleichen.
            }
        }
    }
//###add Methoden erstellt von Steve Vogel #####################################
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
	
//######################## Christopher Haack User add,set,remoove, anzeigen#####
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
        
//###Random Methode erstellt von Daniel Meerwald################################
        private static String generateRandomString(String allowedChars,
            Random random, int L) {
            int max = allowedChars.length();
            StringBuffer buffer = new StringBuffer();
            for (int i=0; i<L; i++) {
            int value = random.nextInt(max);
            buffer.append(allowedChars.charAt(value));
            }
            return buffer.toString();
            }
        
        private static int generateRandomInt(String allowedChars,
            Random random, int L) {
            int max = allowedChars.length();
            StringBuffer buffer = new StringBuffer();
            for (int i=0; i<L; i++) {
            int value = random.nextInt(max);
            buffer.append(allowedChars.charAt(value));
            }
            return Integer.parseInt(buffer.toString());
            }
        
//###Random Autos Methode erstellt von Daniel Meerwald##########################
        public void randomAutos(int Anzahl) throws ParseException{
            
            String Chars ="0123456789abcdefghijklmnopqrstuvwxyz";
            String Numbers ="0123456789";
            String Alphabet ="abcdefghijklmnopqrstuvwxyz";
            Random random = new Random();
            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy", new DateFormatSymbols(Locale.GERMANY));
	    File PATH = new File("Data/dummy1.jpg");

            for (int i=0; i<Anzahl; i++){
                
                 Auto auto = new Auto();
                 
		 auto.setFoto(PATH);
                 auto.setAuto_ID(makeAutoID());
                 auto.setKennzeichen(generateRandomString(Chars, random, 8));
                 auto.setHersteller(generateRandomString(Alphabet, random, 6));
                 auto.setModell(generateRandomString(Alphabet, random, 3));
                 auto.setAnhaengerkupplung(true);
                 auto.setSitzplaetze(generateRandomInt(Numbers, random, 1));
                 auto.setFarbe(generateRandomString(Alphabet, random, 4));
                 auto.setLeistung(generateRandomInt(Numbers, random, 3));
                 auto.setKraftstoff(generateRandomString(Alphabet, random, 5));
                 auto.setVerbrauch(Double.parseDouble(generateRandomString(Numbers, random, 1)));
                 auto.setAntrieb(generateRandomString(Alphabet, random, 5));
                 auto.setGetriebe(generateRandomString(Alphabet, random, 5));
                 auto.setBaujahr(generateRandomInt(Numbers, random, 4));
                 auto.setKilometerstand(generateRandomInt(Numbers, random, 6));
                 auto.setTUEV(format.parse("01.01.2017"));
                 auto.setKaution(generateRandomInt(Numbers, random, 3));
                 auto.setGebuehr_pro_Tag(generateRandomInt(Numbers, random, 2));
                 auto.setBauart(generateRandomString(Alphabet, random, 5));
		 auto.setIst_Da(true);
		 auto.setFahrbar(true);
                 auto.setExtras("Keine");
		 Autos.add(auto);
            }
        }
        
//###Random Kunden Methode erstellt von Daniel Meerwald#########################
        public void randomKunden(int Anzahl) throws ParseException{
            
            String Chars ="0123456789abcdefghijklmnopqrstuvwxyz";
            String Numbers ="0123456789";
            String Alphabet ="abcdefghijklmnopqrstuvwxyz";
            Random random = new Random();
            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy", new DateFormatSymbols(Locale.GERMANY));
            
             for (int i=0; i<Anzahl; i++){
                
                 Kunde kunde = new Kunde();
                 
                 kunde.setKunden_ID(makeKundenID()); 
                 kunde.setNachname(generateRandomString(Alphabet, random, 7)); 
                 kunde.setVorname(generateRandomString(Alphabet, random, 5));
                 kunde.setPostleitzahl(generateRandomString(Numbers, random, 5));
                 kunde.setWohnort(generateRandomString(Alphabet, random, 6));
                 kunde.setStrasse(generateRandomString(Alphabet, random, 10));
                 kunde.setHausnummer(generateRandomString(Chars, random, 4));
                 kunde.setE_Mail(generateRandomString(Chars, random, 12));
                 kunde.setTelefonnummer(generateRandomString(Numbers, random, 11-12));
                 kunde.setGeburtstag(format.parse("01.01.1990"));
                 kunde.setFuehrerscheindatum(format.parse("01.01.2008"));
                 kunde.setFuehrerscheinklasse("B");
		 Kunden.add(kunde);
            }
        }
        
//##############################################################################
        
//###Random Auto Script Methode erstellt von Steve Vogel########################
        public void randomRealAutos(int Anzahl) throws ParseException {
            
            String Chars ="0123456789abcdefghijklmnopqrstuvwxyz";
            String Numbers ="0123456789";
            String Alphabet ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            Random random = new Random();
            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy", new DateFormatSymbols(Locale.GERMANY));
            File AUDIA3 = new File("Data/audia3.jpg");
            File AUDIA4 = new File("Data/audia4.jpg");
            File AUDIRS6 = new File("Data/audirs6.jpg");
            File BMW3 = new File("Data/bmw3.jpg");
            File BMW5 = new File("Data/bmw5.jpg");
            File BMWM3 = new File("Data/bmwm3.jpg");
            File VWPOLO = new File("Data/vwpolo.jpg");
            File VWGOLF = new File("Data/vwgolf.jpg");
            File VWPASSAT = new File("Data/vwpassat.jpg");
            File PATH = new File("Data/dummy1.jpg");
            
            String[] marke;
            String[] audiModell;
            String[] bmwModell;
            String[] vwModell;
            String[] farbe;
            String[] rndMarke = new String[1];
            String[] rndAudiModell = new String[1];
            String[] rndBmwModell = new String[1];
            String[] rndVwModell = new String[1];
            String[] rndFarbe = new String[1];
            
            marke = new String[] {"Audi", "BMW", "Volkswagen"};
            audiModell = new String[] {"A3", "A4", "RS6 Performance"};
            bmwModell = new String[] {"330d", "M3 GTS", "535i"};
            vwModell = new String[] {"Polo", "Golf R", "Passat"};
            farbe = new String[] {"Rot", "Blau", "Silber", "Schwarz", "Weiss"};
            
            for (int i=0; i<Anzahl; i++) {
                
                for (int j=0; j<rndMarke.length; j++) {
                    
                    rndMarke[j] = marke[random.nextInt(marke.length)];
                }
                for (int j=0; j<rndFarbe.length; j++) {
                    
                    rndFarbe[j] = farbe[random.nextInt(farbe.length)];
                }
                for (int j=0; j<rndBmwModell.length; j++) {
                    
                    rndBmwModell[j] = bmwModell[random.nextInt(bmwModell.length)];
                }
                for (int j=0; j<rndVwModell.length; j++) {
                    
                    rndVwModell[j] = vwModell[random.nextInt(vwModell.length)];
                }
                for (int j=0; j<rndAudiModell.length; j++) {
                    
                    rndAudiModell[j] = audiModell[random.nextInt(audiModell.length)];
                }
                
                Auto auto = new Auto();
                
                for (int j=0; j<rndMarke.length; j++) {
                    auto.setHersteller(rndMarke[j]);
                    
                    if(rndMarke[j] == "Audi") {
                        for (int k=0; k<rndAudiModell.length; k++) {
                            auto.setModell(rndAudiModell[k]);
                            
                            if(rndAudiModell[k] == "A3") {
                                
                                auto.setFoto(AUDIA3);
                                auto.setSitzplaetze(Integer.parseInt("5"));
                                auto.setLeistung(Integer.parseInt("180"));
                                auto.setKraftstoff("Benzin");
                                auto.setVerbrauch(Double.parseDouble("6.6"));
                                auto.setAntrieb("Allrad");
                                auto.setGetriebe("Schaltgetriebe");
                                auto.setBaujahr(Integer.parseInt("2015"));
                                auto.setBauart("Cabriolet");
                                auto.setExtras("Ausstattungsserie Comfort");
                            }
                            else if(rndAudiModell[k] == "A4") {
                                
                                auto.setFoto(AUDIA4);
                                auto.setSitzplaetze(Integer.parseInt("5"));
                                auto.setLeistung(Integer.parseInt("190"));
                                auto.setKraftstoff("Diesel");
                                auto.setVerbrauch(Double.parseDouble("7.9"));
                                auto.setAntrieb("Vorderradantrieb");
                                auto.setGetriebe("Schaltgetriebe");
                                auto.setBaujahr(Integer.parseInt("2015"));
                                auto.setBauart("Limousine");
                                auto.setExtras("Matrix-LED-Scheinwerfer");
                            }
                            else if(rndAudiModell[k] == "RS6 Performance"){
                                
                                auto.setFoto(AUDIRS6);
                                auto.setSitzplaetze(Integer.parseInt("5"));
                                auto.setLeistung(Integer.parseInt("605"));
                                auto.setKraftstoff("Benzin");
                                auto.setVerbrauch(Double.parseDouble("7.9"));
                                auto.setAntrieb("Allrad");
                                auto.setGetriebe("8-Gang-tiptronic");
                                auto.setBaujahr(Integer.parseInt("2015"));
                                auto.setBauart("Kombi");
                                auto.setExtras("Dynamikpaket plus (305 km/h)");
                            }
                        }
                    }
                    else if(rndMarke[j] == "BMW") {
                        for (int k=0; k<rndBmwModell.length; k++) {
                            auto.setModell(rndBmwModell[k]);
                            
                            if(rndBmwModell[k] == "330d") {
                                
                                auto.setFoto(BMW3);
                                auto.setSitzplaetze(Integer.parseInt("5"));
                                auto.setLeistung(Integer.parseInt("258"));
                                auto.setKraftstoff("Diesel");
                                auto.setVerbrauch(Double.parseDouble("4.9"));
                                auto.setAntrieb("Hinterradantrieb");
                                auto.setGetriebe("Automatik");
                                auto.setBaujahr(Integer.parseInt("2015"));
                                auto.setBauart("Limousine");
                                auto.setExtras("Luxery Line");
                            }
                            else if(rndBmwModell[k] == "M3 GTS") {
                                
                                auto.setFoto(BMWM3);
                                auto.setSitzplaetze(Integer.parseInt("2"));
                                auto.setLeistung(Integer.parseInt("450"));
                                auto.setKraftstoff("Bezin");
                                auto.setVerbrauch(Double.parseDouble("12.7"));
                                auto.setAntrieb("Hinterradantrieb");
                                auto.setGetriebe("7-Gang-Doppelkupplung");
                                auto.setBaujahr(Integer.parseInt("2010"));
                                auto.setBauart("Limousine");
                                auto.setExtras("Überrollkäfig");
                            }
                            else {
                                
                                auto.setFoto(BMW5);
                                auto.setSitzplaetze(Integer.parseInt("5"));
                                auto.setLeistung(Integer.parseInt("306"));
                                auto.setKraftstoff("Benzin");
                                auto.setVerbrauch(Double.parseDouble("8.1"));
                                auto.setAntrieb("Hinterradantrieb");
                                auto.setGetriebe("Automatik");
                                auto.setBaujahr(Integer.parseInt("2015"));
                                auto.setBauart("Kombi");
                                auto.setExtras("Keine");
                            }
                        }
                    }
                    else if(rndMarke[j] == "Volkswagen"){
                        for (int k=0; k<rndVwModell.length; k++) {
                            auto.setModell(rndVwModell[k]);
                            
                            if(rndVwModell[k] == "Polo") {
                                
                                auto.setFoto(VWPOLO);
                                auto.setSitzplaetze(Integer.parseInt("4"));
                                auto.setLeistung(Integer.parseInt("60"));
                                auto.setKraftstoff("Benzin");
                                auto.setVerbrauch(Double.parseDouble("4.7"));
                                auto.setAntrieb("Vorderradantrieb");
                                auto.setGetriebe("Schaltgetriebe");
                                auto.setBaujahr(Integer.parseInt("2015"));
                                auto.setBauart("Stufenheck");
                                auto.setExtras("BlueMotion");
                            }
                            else if(rndVwModell[k] == "Golf R") {
                                
                                auto.setFoto(VWGOLF);
                                auto.setSitzplaetze(Integer.parseInt("5"));
                                auto.setLeistung(Integer.parseInt("300"));
                                auto.setKraftstoff("Benzin");
                                auto.setVerbrauch(Double.parseDouble("7.1"));
                                auto.setAntrieb("Allrad");
                                auto.setGetriebe("Schaltgetriebe");
                                auto.setBaujahr(Integer.parseInt("2015"));
                                auto.setBauart("Stufenheck");
                                auto.setExtras("Keine");
                            }
                            else {
                                
                                auto.setFoto(VWPASSAT);
                                auto.setSitzplaetze(Integer.parseInt("5"));
                                auto.setLeistung(Integer.parseInt("280"));
                                auto.setKraftstoff("Benzin");
                                auto.setVerbrauch(Double.parseDouble("7.2"));
                                auto.setAntrieb("Allrad");
                                auto.setGetriebe("6-Gang-DSG");
                                auto.setBaujahr(Integer.parseInt("2015"));
                                auto.setBauart("Kombi");
                                auto.setExtras("Ausstattungsserie Highline");
                            }
                        }
                    }
                }
                for (int j=0; j<rndFarbe.length; j++) {
                    auto.setFarbe(rndFarbe[j]);
                }
                auto.setIst_Da(true);
		auto.setFahrbar(true);
                auto.setKaution(generateRandomInt(Numbers, random, 3));
                auto.setGebuehr_pro_Tag(generateRandomInt(Numbers, random, 2));
                auto.setKilometerstand(generateRandomInt(Numbers, random, 5));
                auto.setTUEV(format.parse("01.01.2017"));
                auto.setAnhaengerkupplung(false);
                auto.setAuto_ID(makeAutoID());
                auto.setKennzeichen("MW-" + (generateRandomString(Alphabet, random, 2)) + " " + (generateRandomInt(Numbers, random, 4)));
                              
                Autos.add(auto);
                
            }
        }        
}
