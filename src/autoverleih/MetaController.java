/*
Der MetaController stellt eine Art Überklasse zu der DB_Verwalter Klasse da. Der MetaController überprüft hierbei die Kritischen Eingaben auf Fehler
und gibt die nötigen Fehlercodes zurück.

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
 * @author Daniel Meerwald
 */

public class MetaController {
    
//##############erstellt von Daniel Meerwald####################################    
    Input eingabe = new Input();
    public DB_Verwalter DBV = new DB_Verwalter();
    String pfad = "Data/xml/TestDatenbank.xml";
    
    // 1 return alles erfolgreich gespeichert
    // 0 normal fall keine daten, nichts wird angezeigt
    // -1 auto id
    // -2 kunde
    // -3 ausleihdatum
    // -4 Auto nicht ausgeliehen.
    // -5 Auto nicht da.
    // -6 Auto schon vorhanden.
    
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
        
    //##########Überprüfung für die Auto-ID von Daniel Meerwald#################
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
            
    //###########Überprüfung für die Kunden-ID von Daniel Meerwald##############
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
      
    //##########Überprüfen für Ausleihe von Daniel Meerwald#####################
      Indikator = false;
      i = 0;
      boolean Kollision = false;
      
      
        while (i < DBV.Ausleihen.size() && Indikator == false) { 

            if (DBV.Ausleihen.get(i).getAuto_ID() == Auto_ID ) {
             
            //######Test ob Ausleihezeiträume kollidieren von Steve Vogel#######
                
                
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
        boolean token = false;
        
        while (i < DBV.Ausleihen.size() && token == false) //Suche bis zum Ende der Liste.
        { 

            if (DBV.Ausleihen.get(i).getAuto_ID() == A_ID ) {
                token = true;
            } else {
                i++; //Andernfalls wird das nächste Element vergleichen.
            }
            
        }
        if(token == true){
        while (i < DBV.Autos.size() && indikator == false)
        { 

            if (DBV.Autos.get(i).getAuto_ID() == A_ID ) {
                
                if(DBV.Autos.get(i).getIst_Da()){
                DBV.Autos.get(i).setIst_Da(false);
                indikator = true;
                }
                else{
                    return -5;
                }
            } else {
                i++;
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
        else{
            return -4;
        }
    }
//#####################Erstellt von Daniel Meerwald#############################    
    public int Auto_zurueckbringen(int A_ID){
        
        DBV.restore(pfad);
        int i = 0;
        boolean indikator = false;
        boolean token = false;
        
        while (i < DBV.Ausleihen.size() && token == false)
        { 

            if (DBV.Ausleihen.get(i).getAuto_ID() == A_ID ) {
                token = true;
            } else {
                i++;
            }
            
        }
        if(token == true){
        while (i < DBV.Autos.size() && indikator == false) { 
            
            if (DBV.Autos.get(i).getAuto_ID() == A_ID ) {
                if(DBV.Autos.get(i).getIst_Da()){
                DBV.Autos.get(i).setIst_Da(true);
                indikator = true;
                }
                else{
                    return -6;
                }
            } else {
                i++;
            }
        }
        }
        else{
            return -4;
        }
        if(indikator == false){
                return -1;
            }
        else{
            DBV.save(pfad);
            return 1;
        }
    }
//############erstellt von Danilo May###########################################
    //Formt aus String einen neuen mit allen Zahlen
    public static String Zahlen(final CharSequence input){
    final StringBuilder sb = new StringBuilder(input.length());
    for(int i = 0; i < input.length(); i++){
        final char c = input.charAt(i);
        if(c > 47 && c < 58){
            sb.append(c);
        }
    }
    return sb.toString();
}
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
    
    public int addKunde(String VN, String NN, String PLZ, String WO, 
	    String STR, String HN, String EM, String TN, Date GEB, File FS, Date FSD, String FSK){
        DBV.restore(pfad);
        int i = 0;
        boolean Indikator = false;
        Kunde kunde = new Kunde(0, VN, NN, null, WO, STR, HN, EM, null, GEB, FS, FSD, FSK);
        int indikator = -1;
        Pattern p;
        Matcher m;
        //Legt KundenID fest
        int KID = DBV.makeKundenID();
        kunde.setKunden_ID(KID);
         //Legt Postleitzahl fest
        PLZ = Zahlen(PLZ);
        kunde.setPostleitzahl(PLZ);
         //Legt Telefonnummer fest
        TN = Zahlen(TN);
        kunde.setTelefonnummer(TN);
        
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
        String Tel = "\\d{4,13}";//MUSS ÜBERARBEITET WERDEN LÄNGE 4-12
        String Plz = "\\d{5}";
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
        
        String ZB = "[0-9]{1,}[a-zA-Z]?";
        p = Pattern.compile(ZB);
        m = p.matcher(HN);
        boolean Hausnummer = m.matches();
        
        boolean Postleitzahl = PLZ.matches(Plz);
  
        boolean Telefonnummer = TN.matches(Tel);
       
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
            } 
            if (Telefonnummer == false){
                Indikator = true;
                indikator = -8;
            }
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
            }if (Postleitzahl == false){
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
//##########Erstellt von Daniel Meerwald########################################
    //Copy paste von der addKunde(), danach ergänzung der Kuden ID
    public int addKunde2(int K_ID, String VN, String NN, String PLZ, String WO, 
	    String STR, String HN, String EM, String TN, Date GEB, File FS, Date FSD, String FSK){
        DBV.restore(pfad);
        int i = 0;
        boolean Indikator = false;
        Kunde kunde = new Kunde(0, VN, NN, null, WO, STR, HN, EM, null, GEB, FS, FSD, FSK);
        int indikator = -1;
        Pattern p;
        Matcher m;
        //Legt KundenID fest
        int KID = K_ID;
        kunde.setKunden_ID(KID);
         //Legt Postleitzahl fest
        PLZ = Zahlen(PLZ);
        kunde.setPostleitzahl(PLZ);
         //Legt Telefonnummer fest
        TN = Zahlen(TN);
        kunde.setTelefonnummer(TN);
        
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
        String Tel = "\\d{4,13}";//MUSS ÜBERARBEITET WERDEN LÄNGE 4-12
        String Plz = "\\d{5}";
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
        
        String ZB = "[0-9]{1,}[a-zA-Z]?";
        p = Pattern.compile(ZB);
        m = p.matcher(HN);
        boolean Hausnummer = m.matches();
        
        boolean Postleitzahl = PLZ.matches(Plz);
  
        boolean Telefonnummer = TN.matches(Tel);
       
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
            } 
            if (Telefonnummer == false){
                Indikator = true;
                indikator = -8;
            }
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
            }if (Postleitzahl == false){
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
        DBV.restore(pfad);
        int i = 0;
        boolean Indikator = false;
        Pattern p;
        Matcher m;
	File PATH = new File("Data/dummy1.jpg");
	int AID = DBV.makeAutoID();
	int fehler = 0;
	
        Auto auto = new Auto(PATH, AID, KZ, HER, MOD, BA, AK, SP, FAR, LEI, KS, 
             VER, ANT, GET, BJ, KIL, TUE, KAU, GPT, FAH, EXT, ID);
        // Prüft ob ein Auto schon vorhanden ist/anhand des Kennzeichen und der ID
        
                if(DBV.Autos.get(i).getAuto_ID()==AID && DBV.Autos.get(i).getKennzeichen() == KZ)
                {
                    Indikator = true;
                    return fehler -1;

                }
                else
                {
                    i++;
                }
            
         String Buchstaben = "[A-Z][a-zA-Z]*";   
        //Prüft die Eingaberegeln 
        //Kennzeichen Regel
        //String Kennzeichen = "[A-Z_0-9]";
        p = Pattern.compile(Buchstaben);
        m = p.matcher(KZ);
        boolean Schild = m.matches();
        
        //Hersteller Regel
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
        //String KrSt = "[Diesel][Benzin][E10][Gas]";
        p = Pattern.compile(Buchstaben);
        m = p.matcher(KS);
        boolean Kraftstoff  = m.matches();
        
        // Antrieb Regel
        //String Antr = "[Frontantrieb][Heckantrieb][Allrad]";
        p = Pattern.compile(Buchstaben);
        m = p.matcher(ANT);
        boolean Antrieb = m.matches();
        
        //Getriebe Regel
        //String Getr = "[Schaltgetriebe][Automatikgetriebe]";
        p = Pattern.compile(Buchstaben);
        m = p.matcher(GET);
        boolean Getriebe = m.matches();
        
        
        // Extras Regel
        p = Pattern.compile(Buchstaben);
        m = p.matcher(EXT);
        boolean Extras = m.matches();    
        
                  
                    if(Schild == false)
                    {
                        Indikator = true;
                        return fehler -2;
                    }
                    
                    if(Hersteller == false)
                    {
                        Indikator  = true;
                        return fehler -3;
                    }
                    if(Modell == false)
                    {
                        Indikator = true;
                        return fehler -4;
                    }
                    if(Bauart == false)
                    {
                        Indikator = true;
                        return fehler -5;
                    }
                    if(SP < 2 || SP > 9)
                    {
                        Indikator = true;
                        return fehler -6;
                    }
                    if(Farbe == false)
                    {
                        Indikator = true;
                        return fehler -7;
                    }
                    if(LEI < 25 || LEI > 1000)
                    {
                        Indikator = true;
                        return fehler -8;
                    }
                    if(Kraftstoff == false)
                    {
                        Indikator = true;
                        return fehler -9;
                    }
                     if(VER < 3 || VER > 50)
                    {
                        Indikator = true;
                        return fehler -10;
                    }
                    if(Antrieb == false)
                    {
                        Indikator = true;
                        return fehler -11;
                    }
                    if(Getriebe == false)
                    {
                        Indikator = true;
                        return fehler -12;
                    }
                    if(BJ < 1900 || BJ > 2016)
                    {
                        Indikator = true;
                        return fehler -13;
                    }
                    if(KIL < 1)
                    {
                        Indikator = true;
                        return fehler -14;
                    }
                    
                    //TÜV ???
                    
                    if(KAU < 250 || KAU > 5000)
                    {
                        Indikator = true;
                        return fehler -16;
                    }
                    if (GPT < 5 || GPT > 500)
                    {
                        Indikator = true;
                        return fehler -17;
                    }                    
                    if(Extras == false)
                    {
                        Indikator = true;
                        return fehler -19;
                    }
        
           DBV.addAuto(auto);
           DBV.save(pfad);
	   return 1; 
        
    }
//##########Erstellt von Daniel Meerwald########################################
    //Copy paste von der addauto(), danach ergänzung der Auto ID
    public int addAuto2(int A_ID, String KZ, String HER, 
            String MOD, String BA, boolean AK ,int SP, 
            String FAR, int LEI, String KS, double VER, 
            String ANT, String GET, int BJ, int KIL, 
            Date TUE, double KAU, float GPT, boolean FAH,
            String EXT, boolean ID)
    {
        DBV.restore(pfad);
        int i = 0;
        boolean Indikator = false;
        Pattern p;
        Matcher m;
	File PATH = new File("Data/dummy1.jpg");
	int AID = A_ID;
	int fehler = 0;
	
        Auto auto = new Auto(PATH, AID, KZ, HER, MOD, BA, AK, SP, FAR, LEI, KS, 
             VER, ANT, GET, BJ, KIL, TUE, KAU, GPT, FAH, EXT, ID);
        // Prüft ob ein Auto schon vorhanden ist/anhand des Kennzeichen und der ID
        
                if(DBV.Autos.get(i).getAuto_ID()==AID && DBV.Autos.get(i).getKennzeichen() == KZ)
                {
                    Indikator = true;
                    return -1;

                }
                else
                {
                    i++;
                }
            
         String Buchstaben = "[A-Z][a-zA-Z]*";   
        //Prüft die Eingaberegeln 
        //Kennzeichen Regel
        //String Kennzeichen = "[A-Z_0-9]";
        p = Pattern.compile(Buchstaben);
        m = p.matcher(KZ);
        boolean Schild = m.matches();
        
        //Hersteller Regel
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
        //String KrSt = "[Diesel][Benzin][E10][Gas]";
        p = Pattern.compile(Buchstaben);
        m = p.matcher(KS);
        boolean Kraftstoff  = m.matches();
        
        // Antrieb Regel
        //String Antr = "[Frontantrieb][Heckantrieb][Allrad]";
        p = Pattern.compile(Buchstaben);
        m = p.matcher(ANT);
        boolean Antrieb = m.matches();
        
        //Getriebe Regel
        //String Getr = "[Schaltgetriebe][Automatikgetriebe]";
        p = Pattern.compile(Buchstaben);
        m = p.matcher(GET);
        boolean Getriebe = m.matches();
        
        
        // Extras Regel
        p = Pattern.compile(Buchstaben);
        m = p.matcher(EXT);
        boolean Extras = m.matches();    
        
                 
                    if(Schild == false)
                    {
                        return -2;
                    }
                    
                    if(Hersteller == false)
                    {
                        return -3;
                    }
                    if(Modell == false)
                    {
                        return -4;
                    }
                    if(Bauart == false)
                    {
                        return -5;
                    }
                    if(SP < 2 || SP > 9)
                    {
                        return -6;
                    }
                    if(Farbe == false)
                    {
                        return -7;
                    }
                    if(LEI < 25 || LEI > 1000)
                    {
                        return -8;
                    }
                    if(Kraftstoff == false)
                    {
                        return -9;
                    }
                     if(VER < 3 || VER > 50)
                    {
                        return -10;
                    }
                    if(Antrieb == false)
                    {
                        return -11;
                    }
                    if(Getriebe == false)
                    {
                        return -12;
                    }
                    if(BJ < 1900 || BJ > 2016)
                    {
                        return -13;
                    }
                    if(KIL < 1)
                    {
                        return -14;
                    }
                    
                    //TÜV ???
                    
                    if(KAU < 250 || KAU > 5000)
                    {
                        return -16;
                    }
                    if (GPT < 5 || GPT > 500)
                    {
                        return -17;
                    }                    
                    if(Extras == false)
                    {
                        return -19;
                    }
        
       
           DBV.addAuto(auto);
           DBV.save(pfad);
	   return 1; 
        
    }
//##########Remove Methoden erstellt von Daniel Meerwald########################
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
       {

            if (DBV.Kunden.get(i).getKunden_ID()== K_ID ) 
            {
                DBV.removeKunde(K_ID);
                indikator = true;
            } else 
            {
                i++;
            }
        }
        if(indikator == true)
        {
		DBV.save(pfad);
            return 1;
        }
        else
        {
                return -1;
        }
        }
}