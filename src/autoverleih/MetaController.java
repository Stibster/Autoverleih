/*

 */
package autoverleih;

import GUI.Vfall_popupController;
import java.io.File;
import java.text.ParseException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *  
 * @author DMeer
 */

public class MetaController {
    
    
    Input eingabe = new Input();
    public DB_Verwalter DBV = new DB_Verwalter();
    String pfad = "Data/xml/TestDatenbank.xml";
    
    // 1 return alles erfolgreich gespeichert
    // 0 normal fall keine daten, nichts wird angezeigt
    // -1 auto id
    // -2 kunde
    // -3 ausleihdatum
    
//#####################Erstellt von Steve Vogel#################################
    
    public static GregorianCalendar DateToCalendar(Date date) {
        
        GregorianCalendar cal = (GregorianCalendar)GregorianCalendar.getInstance();
        cal.setTime(date);
        return cal;
    }
    
//#####################Ende Steve Vogel#############################    
    
    
//#####################Erstellt von Daniel Meerwald#############################
    public int addAusleihe(int Auto_ID, int Kunden_ID, Date Ausleihdatum, Date Rueckgabedatum) throws ParseException{
        
        DBV.restore(pfad);
        Ausleihe ausleihe = new Ausleihe();       
        int i = 0;
        boolean Indikator = false;
	int indikator = 0;
        
    //#####################Überprüfung für die Auto-ID.#########################
      while(Indikator != true){
        while (i < DBV.Autos.size() && Indikator == false) { 

            if (DBV.Autos.get(i).getAuto_ID() == Auto_ID ) {
                Indikator = true; 
            } 
            else {
                i++; 
            }
        }
            if (Indikator == true){
                ausleihe.setAuto_ID(Auto_ID);
            }
            else{
		return -1;
            }
      }
            
    //#####################Überprüfung für die Kunden-ID.#######################
      Indikator = false;
      i = 0;
      while(Indikator != true){
        while (i < DBV.Kunden.size() && Indikator == false) { 

            if (DBV.Kunden.get(i).getKunden_ID() == Kunden_ID ) {
                Indikator = true; 
            } 
            else {
                i++; 
            }
        }
            if (Indikator == true){
                ausleihe.setKunden_ID(Kunden_ID);
            }
            else{
		return -2;
	    }
      }
      
    //#####################Überprüfen für Ausleihe.#############################
      Indikator = false;
      i = 0;
      boolean Kollision = false;
      
      
        while (i < DBV.Ausleihen.size() && Indikator == false) { 

            if (DBV.Ausleihen.get(i).getAuto_ID() == Auto_ID ) {
                //Test ob ausleihezeiträume kollidieren.
                // Autor: Steve Vogel
                
                
                GregorianCalendar cal_aus = DateToCalendar(Ausleihdatum); //Eingegebenes Ausleihdatum
                GregorianCalendar cal_rue = DateToCalendar(Rueckgabedatum);
                GregorianCalendar cal_Baus = DateToCalendar(DBV.Ausleihen.get(i).Ausleihdatum); //Bestehendes Ausleihdatum
                GregorianCalendar cal_Brue = DateToCalendar(DBV.Ausleihen.get(i).Rueckgabedatum);
                
                long aus = cal_aus.getTimeInMillis();
                long rue = cal_rue.getTimeInMillis();
                long Baus = cal_Baus.getTimeInMillis();
                long Brue = cal_Brue.getTimeInMillis();
                
                long zeitraum = ((rue-aus) / 1000 / 60 / 60 / 24) + 1;
                long Bzeitraum = ((Brue-Baus) / 1000 / 60 / 60 / 24) + 1;
                
                for(long j=0; j<zeitraum; j++) {
                    for(long k=0; k<Bzeitraum; k++) {
                        if(cal_Baus.equals(cal_aus)) {
                            Indikator = true;
                        }
                        else {
                            cal_Baus.add(GregorianCalendar.DAY_OF_MONTH, 1);
                        }
                        k++;
                    }
                    cal_aus.add(GregorianCalendar.DAY_OF_MONTH, 1);
                    j++;
                }
                //Ende Steve Vogel
                
                i++;
            } 
            else {
                i++; 
            }
        }
            if (Indikator == true){
                
		return -3;
            }
            else{
                ausleihe.setAusleihdatum(Ausleihdatum);
                ausleihe.setRueckgabedatum(Rueckgabedatum);
            }
      
      
        //Wenn alles korrekt ist wird die Ausleihe hinzugefügt.
	if(indikator >= 0)
	{
	    DBV.addAusleihe(ausleihe);
	    DBV.save(pfad);
	    return 1;
	}
	else 
	{return indikator;}
        }
        
    

//#####################Erstellt von Daniel Meerwald#############################
    public int Auto_abholen(int A_ID){
        
        DBV.restore(pfad);
        int i = 0;
        boolean indikator = false;

        while (i < DBV.Autos.size() && indikator == false) //Suche bis zum Ende der Liste.
        { 

            if (DBV.Autos.get(i).getAuto_ID() == A_ID ) {
                DBV.Autos.get(i).setIst_Da(false);
                indikator = true; //Ende der Methode, wenn das Objekt gefunden wurde.
            } else {
                i++; //Andernfalls wird das nächste Element vergleichen.
            }
            
        }
        if(indikator == false){
                return -1;
            }
        else{
            DBV.save(pfad);
            return 1;
        }
    }
//#####################Erstellt von Daniel Meerwald#############################    
    public int Auto_zurueckbringen(int A_ID){
        
        DBV.restore(pfad);
        int i = 0;
        boolean indikator = false;

        while (i < DBV.Autos.size() && indikator == false) { //Suche bis zum Ende der Liste.

            if (DBV.Autos.get(i).getAuto_ID() == A_ID ) {
                DBV.Autos.get(i).setIst_Da(true);
                indikator = true; //Ende der Methode, wenn das Objekt gefunden wurde.
            } else {
                i++; //Andernfalls wird das nächste Element vergleichen.
            }
        }
        if(indikator == false){
                return -1;
            }
        else{
            DBV.save(pfad);
            return 1;
        }
    }
//##############################################################################
   
    //von Danilo May
    // 1 return alles erfolgreich gespeichert
    // 0 normal fall keine daten, nichts wird angezeigt
    // -1 Vorname, Nachname und Geburtstag schon einmal zusammen vorhanden
    // -2 Vorname muss ersten Buchstaben groß und Rest klein haben
    // -3 Nachname muss ersten Buchstaben groß und Rest klein haben
    // -4 Wohnort muss ersten Buchstaben groß und Rest klein haben
    // -5 Strasse muss ersten Buchstaben groß und Rest klein haben
    // -6 Hausnummer besteht nur aus Zahlen und/oder Buchstaben
    // -7 EMail schema xxx(.yyy)@aaa.bb.cc
    // -8 Telefonnummer falsch
    // -9 Gebrutstag falsch
    // -10 Führerschein falsch
    // -11 Führerscheindatum falsch
    // -12 Postleitzahl
    
    public int addKunde(String VN, String NN, int PLZ, String WO, 
	    String STR, String HN, String EM, String TN, Date GEB, File FS, Date FSD, String FSK){
        DBV.restore(pfad);
        int i = 0;
        boolean Indikator = false;
        Kunde kunde = new Kunde(0, VN, NN, PLZ, WO, STR, HN, EM, TN, GEB, FS, FSD, FSK);
        int indikator = -1;
        Pattern p;
        Matcher m;
        //Legt KundenID fest
        int KID = DBV.makeKundenID();
        kunde.setKunden_ID(KID);
        //Prüft ob eine Person mit gleichem Vorname, Nachname, Geburtstag vorhanden ist
	while (i < DBV.Kunden.size() && Indikator == false) { //Suche bis zum Ende der Liste.

            if (DBV.Kunden.get(i).getVorname() == VN && DBV.Kunden.get(i).getNachname() == NN && DBV.Kunden.get(i).getGeburtstag() == GEB) {
                Indikator = true; //Ende der Methode, wenn das Objekt gefunden wurde.
		return -1;
            } else {
                i++; //Andernfalls wird das nächste Element vergleichen.
            }
        }
	
        //Legt Eingabe Regeln fest
        String Buchstaben = "/^[a-z ,.'-]+$/i";
        String ZS = "^\\+[1-9]{1}[0-9]{3,14}$";
        String Plz = "\\d{5})";
        //Prüft ob Eingaberegeln mit Eingabe übereinstimmen
        
        String Name = "[A-Z][a-zA-Z]*";
        p = Pattern.compile(Name);
        m = p.matcher(VN);
        boolean Vorname = m.matches();
        
        m = p.matcher(NN);
        boolean Nachname = m.matches();
        
        m = p.matcher(WO);
        boolean Wohnort = m.matches();
        
        m = p.matcher(STR);
        boolean Strasse = m.matches();
        
        String At = "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        p = Pattern.compile(At);
        m = p.matcher(EM);
        boolean EMail = m.matches();  
        
        String ZB = "[0-9][a-zA-Z]";
        p = Pattern.compile(ZB);
        m = p.matcher(HN);
        boolean Hausnummer = m.matches();
        int Postleitzahl = (int)(Math.log10(PLZ)+1);
  
        boolean Telefonnummer = TN.matches(ZS);
       
        //Prüft ob Alle Ergebnisse passen
        if (Indikator!=true){
            if (Vorname == false){
                Indikator = true;
                indikator = -2;
            }
            if (Nachname == false){
                Indikator = true;
                indikator = -3;
            }
            if (Wohnort == false){
                Indikator = true;
                indikator = -4;
            }
            if (Strasse == false){
                Indikator = true;
                indikator = -5;
            }
            if (Hausnummer == false){
                Indikator = true;
                indikator = -6;
            }
            if (EMail == false){
                Indikator = true;
                indikator = -7;
            }/* 
            if (Telefonnummer == false){
                Indikator = true;
                indikator = -8;
            }*/
            if (GEB == null){
                Indikator = true;
                indikator = -9;
            }/*
            if (FS == null){
                Indikator = true;
                indikator = -10;
            }*/
            if (FSD == null){
                Indikator = true;
                indikator = -11;
            }if (Postleitzahl != 5){
                Indikator = true;
                indikator = -12;
            }
        }
        // speichert
        if (Indikator != true){
            DBV.addKunde(kunde);
	    DBV.save(pfad);
	    indikator = 1;
        }
        //gibt Erfolg oder Fehlschlag mit jeweiligem Fehlercode zurück
        return indikator;    
    }
    
    /*
    1 Erfolgreich gespeichert
    0 normal, keine Daten nix wird angezeigt
    -1 Auto_ID und Kennzeichen schon vorhanden
    -2 Kennzeichen nur Großbuchstaben und Zahlen
    -3 Hersteller nur Buchstaben 1. Groß
    -4 Modell keine Sonderzeichen
    -5 Bauart nur Buchstaben
    -6 Sitzplätze nur 2-9
    -7 Farbe nur Buchstaben 1. Groß
    -8 Leistung 25-1000 
    -9 Kraftstoff: Nur Diesel/Benzin/E10/Gas
    -10 Verbrauch 0-9 
    -11 Antrieb nur Allrad/Heckantrieb/Frontantrieb
    -12 Getriebe nur Automatikgetriebe/Schaltgetriebe
    -13 Baujahr 1900 - 2016 //Steve: 1900, sonst blutet mein Herz
    -14 km-Stand: 1 - max Integer
    -15 TÜV
    -16 Kaution bis 250 - 5000 Euro
    -17 Gebühr pro Tag 5 - 500 Euro
    -18 fahrbar
    -19 Extras nur Buchstaben 1. Groß
    -20 Ist da
    */
    
    //********************************Adrian Neubert****************************
    public int addAuto(String KZ, String HER, 
            String MOD, String BA, boolean AK ,int SP, 
            String FAR, int LEI, String KS, double VER, 
            String ANT, String GET, int BJ, int KIL, 
            Date TUE, double KAU, float GPT, boolean FAH,
            String EXT, boolean ID)
    {
        int AID = DBV.makeAutoID();
        DBV.restore(pfad);
        int i = 0;
        boolean Indikator = false;
        Pattern p;
        Matcher m;
	File PATH = new File("Data/dummy1.jpg");
	
        Auto auto = new Auto(PATH, AID, KZ, HER, MOD, BA, AK, SP, FAR, LEI, KS, 
             VER, ANT, GET, BJ, KIL, TUE, KAU, GPT, FAH, EXT, ID);
        // Prüft ob ein Auto schon vorhanden ist/anhand des Kennzeichen und der ID
        
            while(i < DBV.Autos.size() && Indikator == false)
            {
                if(DBV.Autos.get(i).getAuto_ID()==AID && DBV.Autos.get(i).getKennzeichen() == KZ)
                {
                    Indikator = true;
                    return -1;

                }
                else
                {
                    i++;
                }
            }
            
        //Prüft die Eingaberegeln 
        //Kennzeichen Regel
        String Kennzeichen = "[A-Z_0-9]";
        p = Pattern.compile(Kennzeichen);
        m = p.matcher(KZ);
        boolean Schild = m.matches();
        
        //Hersteller Regel
        String Buchstaben = "[A-Z][a-zA-Z]*";
        p = Pattern.compile(Buchstaben);
        m = p.matcher(HER);
        boolean Hersteller = m.matches();
        
        // Modell Regel(Buchstaben)
        p = Pattern.compile(Buchstaben);
        m = p.matcher(MOD);
        boolean Modell = m.matches();
        
        // Bauart Regel       
        p = Pattern.compile(Buchstaben);
        m = p.matcher(BA);
        boolean Bauart = m.matches();
        
        //Farbe Regel
        p = Pattern.compile(Buchstaben);
        m = p.matcher(FAR);
        boolean Farbe = m.matches();
        
        // Kraftstoff
        String KrSt = "[Diesel][Benzin][E10][Gas]";
        p = Pattern.compile(KrSt);
        m = p.matcher(KS);
        boolean Kraftstoff  = m.matches();
        
        // Antrieb Regel
        String Antr = "[Frontantrieb][Heckantrieb][Allrad]";
        p = Pattern.compile(Antr);
        m = p.matcher(ANT);
        boolean Antrieb = m.matches();
        
        //Getriebe Regel
        String Getr = "[Schaltgetriebe][Automatikgetriebe]";
        p = Pattern.compile(Getr);
        m = p.matcher(GET);
        boolean Getriebe = m.matches();
        
        
        // Extras Regel
        p = Pattern.compile(Buchstaben);
        m = p.matcher(EXT);
        boolean Extras = m.matches();    
        
        if(Indikator!=true)
        {           
                    if(Schild == false)
                    {
                        Indikator = true;
                        return -2;
                    }
                    
                    if(Hersteller == false)
                    {
                        Indikator = true;
                        return -3;
                    }
                    if(Modell == false)
                    {
                        Indikator = true;
                        return -4;
                    }
                    if(Bauart == false)
                    {
                        Indikator = true;
                        return -5;
                    }
                    if(SP < 2 || SP > 9)
                    {
                        Indikator = true;
                        return -6;
                    }
                    if(Farbe == false)
                    {
                        Indikator = true;
                        return -7;
                    }
                    if(LEI < 25 || LEI > 1000)
                    {
                        Indikator = true;
                        return -8;
                    }
                    if(Kraftstoff == false)
                    {
                        Indikator = true;
                        return -9;
                    }
                     if(VER < 3 || VER > 50)
                    {
                        Indikator = true;
                        return -10;
                    }
                    if(Antrieb == false)
                    {
                        Indikator = true;
                        return -11;
                    }
                    if(Getriebe == false)
                    {
                        Indikator = true;
                        return -12;
                    }
                    if(BJ < 1900 || BJ > 2016)
                    {
                        Indikator = true;
                        return -13;
                    }
                    if(KIL < 1)
                    {
                        Indikator = true;
                        return -14;
                    }
                    
                    //TÜV ???
                    
                    if(KAU < 250 || KAU > 5000)
                    {
                        Indikator = true;
                        return -16;
                    }
                    if (GPT < 5 || GPT > 500)
                    {
                        Indikator = true;
                        return -17;
                    }                    
                    if(Extras == false)
                    {
                        Indikator = true;
                        return -19;
                    }
        }
        else
        {
           DBV.addAuto(auto);
           DBV.save(pfad);
           return 1;              
        }
        return 0;
    }
//##############################################################################
   public int removeAuto(int A_ID)
      {              
              boolean indikator = false;
              int i = 0;

       while (i < DBV.Autos.size() && indikator == false) 
       { //Suche bis zum Ende der Liste.

            if (DBV.Autos.get(i).getAuto_ID() == A_ID ) 
            {
                DBV.removeAuto(A_ID);
                indikator = true; //Ende der Methode, wenn das Objekt gefunden wurde.
            } else 
            {
                i++; //Andernfalls wird das nächste Element vergleichen.
            }
        }
        if(indikator == false)
        {
            
                return -1;
        }
        else
        {
            DBV.save(pfad);
            return 1;
        }
        
      }
      public int removeKunde(int K_ID)
       {              
              boolean indikator = false;
              int i = 0;

       while (i < DBV.Kunden.size() && indikator == false) 
       { //Suche bis zum Ende der Liste.

            if (DBV.Kunden.get(i).getKunden_ID()== K_ID ) 
            {
                DBV.removeKunde(K_ID);
                indikator = true; //Ende der Methode, wenn das Objekt gefunden wurde.
            } else 
            {
                i++; //Andernfalls wird das nächste Element vergleichen.
            }
        }
        if(indikator == true)
        {
		DBV.save(pfad);
            return 1;
        }
        else
        {
	    System.out.println(",meopü");
                return -1;
        }
        }
}
/*   
    
    public void Auto_abholen(int A_ID){
        
    }
    /*
    public void Auto_zurueckbringen(int A_ID){
       
    }
    
    public void setKunden(List<Kunde> Kunden) {
       
    }

    public void setAutos(List<Auto> Autos) {
      
    }
    public void setAusleihen(List<Ausleihe> Ausleihen) {
    
    }


    

    public void removeAusleihe(int K_ID, int A_ID){
        
    }
*/

