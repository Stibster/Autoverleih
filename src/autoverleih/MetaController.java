/*

 */
package autoverleih;

import GUI.Vfall_popupController;
import java.io.File;
import java.text.ParseException;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *  
 * @author DMeer
 */

public class MetaController {
    
    
    Input eingabe = new Input();
    DB_Verwalter DBV = new DB_Verwalter();
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
	int indikator = -1;
        
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
            if (Indikator = true){
                ausleihe.setAuto_ID(Auto_ID);
            }
            else{
		indikator = -1;
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
            if (Indikator = true){
                ausleihe.setKunden_ID(Kunden_ID);
            }
            else{
		indikator = -2;
	    }
      }
      
    //#####################Überprüfen für Ausleihe.#############################
      Indikator = false;
      i = 0;
      boolean Kollision = false;
      /*
      while(Indikator != true){
        while (i < DBV.Ausleihen.size() && Indikator == false) { 

            if (DBV.Ausleihen.get(i).getAuto_ID() == Auto_ID ) {
                //Test ob ausleihezeiträume kollidieren.
                // Autor: Steve Vogel
                
                Vfall_popupController Vfall = new Vfall_popupController();
                
                GregorianCalendar cal_aus = DateToCalendar(Vfall.start); //Eingegebenes Ausleihdatum
                GregorianCalendar cal_rue = DateToCalendar(Vfall.back);
                GregorianCalendar cal_Baus = DateToCalendar(ausleihe.Ausleihdatum); //Bestehendes Ausleihdatum
                GregorianCalendar cal_Brue = DateToCalendar(ausleihe.Rueckgabedatum);
                
                long aus = cal_aus.getTimeInMillis();
                long rue = cal_rue.getTimeInMillis();
                long Baus = cal_Baus.getTimeInMillis();
                long Brue = cal_Brue.getTimeInMillis();
                
                long zeitraum = ((rue-aus) / 1000 / 60 / 60 / 24) + 1;
                long Bzeitraum = ((Brue-Baus) / 1000 / 60 / 60 / 24) + 1;
                
                for(long j=0; j<zeitraum; j++) {
                    for(long k=0; k<Bzeitraum; k++) {
                        if(cal_Baus.equals(cal_aus)) {
                            Kollision = true;
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
                
		indikator = -3;
            }
            else{
                ausleihe.setAusleihdatum(Ausleihdatum);
                ausleihe.setRueckgabedatum(Rueckgabedatum);
            }
      }*/
      
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
    
    public int addKunde(String VN, String NN, int PLZ, String WO, String STR, String HN, String EM, int TN, Date GEB, File FS, Date FSD, String FSK){
        DBV.restore(pfad);
        int i = 0;
        boolean Indikator = false;
        Kunde kunde = new Kunde(0, VN, NN, PLZ, WO, STR, HN, EM, TN, GEB, FS, FSD, FSK);
        int indikator = -1;
        //Legt KundenID fest
        int KID = DBV.makeKundenID();
        kunde.setKunden_ID(KID);
        //Prüft ob eine Person mit gleichem Vorname, Nachname, Geburtstag vorhanden ist
        while (Indikator!=true){
            while (i < DBV.Kunden.size() && Indikator == false){ 
                if (DBV.Kunden.get(i).getVorname() == VN ) {
                     if (DBV.Kunden.get(i).getNachname() == NN ) {
                          if (DBV.Kunden.get(i).getGeburtstag() == GEB ) {
                              Indikator = true;
                          }
                     }
                } 
                else {
                    i++; 
                }
            }
            if (Indikator = true){
                indikator = -1;
            }
        }
        //Legt Eingabe Regeln fest
        String Buchstaben = "^([A-Z]) [a-z] ";
        //String ZS = "^\\+[1-9]{1}[0-9]{3,14}$";
        String At = "^[_A-Za-z0-9-\\\\+]+(\\\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\\\.[A-Za-z0-9]+)*(\\\\.[A-Za-z]{2,})$;";
        String ZB = "[A-Za-z0-9]";
        String Plz = "\\d{5})";
        //Prüft ob Eingaberegeln mit Eingabe übereinstimmen
        boolean Vorname = VN.matches(Buchstaben);
        boolean Nachname = NN.matches(Buchstaben);
        boolean Wohnort = WO.matches(Buchstaben);
        boolean Strasse = STR.matches(Buchstaben);
        boolean Hausnummer = HN.matches(ZB);
        boolean EMail = EM.matches(At);
        //boolean Telefonnummer = TN.matches(ZS);
       
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
            /*if (Telefonnummer == null){
                Indikator = true;
                indikator = -8;
            }*/
            if (GEB == null){
                Indikator = true;
                indikator = -9;
            }
            if (FS == null){
                Indikator = true;
                indikator = -10;
            }
            if (FSD == null){
                Indikator = true;
                indikator = -11;
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
    -10 Verbrauch Format: 000l/100km
    -11 Antrieb nur Allrad/Heckantrieb/Frontantrieb
    -12 Getriebe nur Automatikgetriebe/Schaltgetriebe
    -13 Baujahr 1990 - 2016
    -14 1 - max Integer
    -15 TÜV
    -16 Kaution bis 250 - 5000 Euro
    -17 Gebühr pro Tag 5 - 500 Euro
    -18 fahrbar
    -19 Extras nur Buchstaben 1. Groß
    -20 Ist da
    */
    
    //********************************Adrian Neubert****************************
    public int addAuto(File PATH,  String KZ, String HER, 
            String MOD, String BA, boolean AK ,int SP, 
            String FAR, int LEI, String KS, String VER, 
            String ANT, String GET, int BJ, int KIL, 
            Date TUE, double KAU, float GPT, boolean FAH,
            String EXT, boolean ID)
    {
        int AID = DBV.makeAutoID();
        DBV.restore(pfad);
        int i = 0;
        boolean Indikator = false;
        Auto auto = new Auto(PATH, AID, KZ, HER, MOD, BA, AK, SP, FAR, LEI, KS, 
             VER, ANT, GET, BJ, KIL, TUE, KAU, GPT, FAH, EXT, ID);
        int indikator = -1;
        // Prüft ob ein Auto schon vorhanden ist/anhand des Kennzeichen und der ID
        while(Indikator != true)
        {
            while(i < DBV.Autos.size() && Indikator == false)
            {
                if(DBV.Autos.get(i).getAuto_ID()==AID)
                {
                    if(DBV.Autos.get(i).getKennzeichen()==KZ)
                    {
                        Indikator = true;
                    }
                }
                else
                {
                    i++;
                }
            }
            if(Indikator = true)
            {
                indikator = -1;               
            }        
        }
        
        //Regeln für ddie Texteingabe
        String Buchstaben ="([A-Z])[a-z]";
        //String Verbrauch =  "[]";
        String BuchZahl = "[a-zA-Z_0-9]";
        String Kenn = "[A-Z_0-9]";
        String KrSt = "[Diesel][Benzin][E10][Gas]";
        String Antr = "[Frontantrieb][Heckantrieb][Allrad]";
        String Getr = "[Schaltgetriebe][Automatikgetriebe]";

        boolean Kennzeichen = KZ.matches(Kenn);
        boolean Hersteller = HER.matches(Buchstaben);
        boolean Modell = MOD.matches(BuchZahl);
        boolean Bauart = BA.matches(Buchstaben);
        boolean Farbe = FAR.matches(Buchstaben);
        boolean Kraftstoff = KS.matches(KrSt);
        //boolean Verbrauch = VER.matches(Verbrauch);
        boolean Antrieb = ANT.matches(Antr);
        boolean Getriebe = GET.matches(Getr);
        boolean Extras = EXT.matches(Buchstaben);
        
        if(Indikator!=true)
        {
            if(Kennzeichen == false)
                    {
                        Indikator = true;
                        indikator = -2;
                    }
                    if(Hersteller == false)
                    {
                        Indikator = true;
                        indikator = -3;
                    }
                    if(Modell == false)
                    {
                        Indikator = true;
                        indikator = -4;
                    }
                    if(Bauart == false)
                    {
                        Indikator = true;
                        indikator = -5;
                    }
                    if(SP < 2 || SP > 9)
                    {
                        Indikator = true;
                        indikator = -6;
                    }
                    if(Farbe == false)
                    {
                        Indikator = true;
                        indikator = -7;
                    }
                    if(LEI < 25 || LEI > 1000)
                    {
                        Indikator = true;
                        indikator = -8;
                    }
                    if(Kraftstoff == false)
                    {
                        Indikator = true;
                        indikator = -9;
                    }
                  //   if(Verbrauch == false)
                  //  {
                  //    Indikator = true;
                  //    indikator = -10;
                  //  }
                    if(Antrieb == false)
                    {
                        Indikator = true;
                        indikator = -11;
                    }
                    if(Getriebe == false)
                    {
                        Indikator = true;
                        indikator = -12;
                    }
                    if(BJ < 1990 || BJ > 2016)
                    {
                        Indikator = true;
                        indikator = -13;
                    }
                    if(KIL < 1)
                    {
                        Indikator = true;
                        indikator = -14;
                    }
                    //TÜV
                    
                    if(KAU < 250 || KAU > 5000)
                    {
                        Indikator = true;
                        indikator = -16;
                    }
                    if (GPT < 5 || GPT > 500)
                    {
                        Indikator = true;
                        indikator = -17;
                    }
                    //ist da und fahrbar??
                    
                    if(Extras == false)
                    {
                        Indikator = true;
                        indikator = -11;
                    }
                     
        }
        
        if (Indikator != true)
        {
            DBV.addAuto(auto);
            DBV.save(pfad);
            indikator = 1;
        }
        return indikator;
    }
//##############################################################################
      public int removeAuto(int A_ID)
      {
          int indikator; 
          if (DBV.Autos.contains(A_ID))
          {
              DBV.removeAuto(A_ID);
              indikator = 1; //erfolgreich
          }
          else 
          {
              indikator = -1; //fehlschlag
          }
	  
	  return indikator;
      }
      public int removeKunde(int K_ID)
      {
          int indikator; 
          if (DBV.Kunden.contains(K_ID))
          {
              DBV.removeKunde(K_ID);
              indikator = 1; //erfolgreich
          }
          else 
          {
              indikator = -1; //fehlschlag
          }
	  
	  return indikator;
    
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

