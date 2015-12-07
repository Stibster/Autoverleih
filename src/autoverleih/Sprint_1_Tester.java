package autoverleih;

import java.text.ParseException;
import java.util.Scanner;


public class Sprint_1_Tester 
{
       public static void main(String[] args) throws ParseException
    {
        //Noch zu programmieren:    #Raicandy
                //Überprüfen ob Datei  C:\\TestDatenbank.xml vorhanden ist, wenn nicht wird diese leer erstellt. #Raicandy
            
        Input eingabe = new Input();
        Auto auto = new Auto();
        Kunde kunde = new Kunde();
	Ausleihe ausleihe = new Ausleihe();
	DB_Verwalter DBV = new DB_Verwalter();
        String pfad = "C:\\TestDatenbank.xml";
        String eingegeben;
        
        try (Scanner in = new Scanner(System.in)) { //Scanner zum einlesen.
        //Menü Tokens
        boolean Token1 = false;
        boolean Token2 = false;
        boolean Token3 = false;
        boolean Token4 = false;
        boolean Token5 = false;
        
        System.out.println("**************************************************");
        System.out.println("!!!!!!!Infolines!!!!!!!");
        System.out.println("Anzeige Methoden sind noch nicht korrekt implementiert.");
        System.out.println("Die toString() Methoden sind alle implementiert.");
        System.out.println("Eine Einlesefunktion fehlt noch im Dialog.");
        System.out.println("Das Programm liest einen bereits Existierenden Standardpfad ein.");
        System.out.println("**************************************************");
        
            System.out.println("Verstanden? (Y/N)?");
            while(Token5 != true){
                
                eingegeben = in.nextLine();
                if("Y".equals(eingegeben)){
                    Token5 = true;
                }
                if("N".equals(eingegeben)){
                    System.out.println("Nein gibts nicht!");
                }
                
            }
            try {
                DBV.restore(pfad);
            } catch (Exception e) {              
                throw e;
            }
        
	while(Token1 != true) //Menü While Schleife #Raicandy
	{
//######################################################Welcome Screen #Raicandy
        System.out.println("########################################################");
        System.out.println("Guten Tag.");
        System.out.println("Was moechten Sie tun? Folgende Optionen stehen zur Wahl:");
        System.out.println("********************************************************");
        System.out.println("K:    Kunden bearbeiten.");
        System.out.println("A:    Autos bearbeiten");
        System.out.println("V:    Vermietung bearbeiten");
        System.out.println("********************************************************");
        System.out.println("SaveExit: Die Listen speichern und das Programm verlassen");
        System.out.println("########################################################");

        eingegeben = in.nextLine();
        
//#########################################################Kundenmenue #Raicandy
         
            
        
         if("K".equals(eingegeben))
         {
             Token2 = true;
        while(Token2 != true){
        System.out.println("########################################################");
        System.out.println("Kundenmeue");
        System.out.println("Was moechten Sie tun? Folgende Optionen stehen zur Wahl:");
        System.out.println("********************************************************");
        System.out.println("A:    Alle Kunden Anzeigen");
        System.out.println("E:    Einen Kunden erstellen.");
        System.out.println("q:    Einen Kunden schnell erstellen.");
        System.out.println("B:    Einen Kunden bearbeiten.");
        System.out.println("L:    Einen Kunden löschen");
        System.out.println("********************************************************");
        System.out.println("Back:     Das Menue verlassen und zum vorherigen Menue zurueckkehren");
        System.out.println("SaveExit: Die Listen speichern und das Programm verlassen");
        System.out.println("########################################################");
        
        eingegeben = in.nextLine();
        
            if("A".equals(eingegeben))
                 {
                     DBV.Kunden_anzeigen();
                 }
        
        
             if("E".equals(eingegeben))
             {
		 
                 // Daten des neuen Kunden eingeben
                 System.out.println("---Neuer Kunde---");
                 System.out.println("Kunden ID: ");
                 kunde.setKunden_ID(eingabe.readint());          
                 System.out.println("Nachname: ");
                 kunde.setNachname(eingabe.readString()); 
                 System.out.println("Vorname: ");
                 kunde.setVorname(eingabe.readString());
                 System.out.println("Postleitzahl: ");
                 kunde.setPostleitzahl(eingabe.readint());
                 System.out.println("Wohnort: ");
                 kunde.setWohnort(eingabe.readString());
                 System.out.println("Straße: ");
                 kunde.setStrasse(eingabe.readString());
                 System.out.println("Hausnummer: ");
                 kunde.setHausnummer(eingabe.readString());
                 System.out.println("E-Mail: ");
                 kunde.setE_Mail(eingabe.readString());
                 System.out.println("Telefonnummer: ");
                 kunde.setTelefonnummer(eingabe.readint());
                 System.out.println("Geburtstag: ");
                 kunde.setGeburtstag(eingabe.readdate());
                 System.out.println("Führerscheindatum: ");
                 kunde.setFuehrerscheindatum(eingabe.readdate());
		 DBV.addKunde(kunde);
		 DBV.save(pfad); 
                 System.out.println(kunde);

             }
             
             
             
             if("q".equals(eingegeben))
             {
                 System.out.println("---Neuer Kunde---");
                 System.out.println("Kunden ID: ");
                 kunde.setKunden_ID(eingabe.readint());          
                 System.out.println("Nachname: ");
                 kunde.setNachname(eingabe.readString());
                 System.out.println("Vorname: ");
                 kunde.setVorname(eingabe.readString());
                 DBV.addKunde(kunde);
                 DBV.save(pfad);
                 System.out.println(kunde);
             }
             
             
	     
             if("B".equals(eingegeben))
             {
                 int KID;
                 System.out.println("Welchen Kunden wollen sie bearbeiten?");
                 System.out.println("KundenID: ");
                 
                 KID = eingabe.readint();
                 
                 DBV.removeKunde(KID);
                 
                 System.out.println("---Neuer Kunde---");
                 System.out.println("Kunden ID: ");
                 kunde.setKunden_ID(eingabe.readint());          
                 System.out.println("Nachname: ");
                 kunde.setNachname(eingabe.readString());
                 System.out.println("Vorname: ");
                 kunde.setVorname(eingabe.readString());
                 System.out.println("Postleitzahl: ");
                 kunde.setPostleitzahl(eingabe.readint());
                 System.out.println("Wohnort: ");
                 kunde.setWohnort(eingabe.readString());
                 System.out.println("Straße: ");
                 kunde.setStrasse(eingabe.readString());
                 System.out.println("Hausnummer: ");
                 kunde.setHausnummer(eingabe.readString());
                 System.out.println("E-Mail: ");
                 kunde.setE_Mail(eingabe.readString());
                 System.out.println("Telefonnummer: ");
                 kunde.setTelefonnummer(eingabe.readint());
                 System.out.println("Geburtstag: ");
                 kunde.setGeburtstag(eingabe.readdate());
                 System.out.println("Führerscheindatum: ");
                 kunde.setFuehrerscheindatum(eingabe.readdate());
		 DBV.addKunde(kunde);
		 DBV.save(pfad); 
                 System.out.println(kunde);
                 
                 
             }
                          
             
             
             if("L".equals(eingegeben)) 
             {
                 int KID;
                 System.out.println("Welchen Kunden wollen sie löschen?");
                 System.out.println("KundenID: ");
                 
                 KID = eingabe.readint();
                 
                 DBV.removeKunde(KID);
                 DBV.save(pfad);
             }
             
             
             
	     if("Back".equals(eingegeben))
             {
                 Token2 = true;
             }
             
             
             
             if("SaveExit".equals(eingegeben))
             {
                 DBV.save(pfad);
                 Token2 = true;
                 Token1 = true;
             }

             
             
         }
}
//####################################################Vermietungsmenue #Raicandy

         
	 if("V".equals(eingegeben))
	{
            Token3 = true;
        while(Token3 != true){
        System.out.println("########################################################");
        System.out.println("Vermietung");
        System.out.println("Was moechten Sie tun? Folgende Optionen stehen zur Wahl:");
        System.out.println("********************************************************");
        System.out.println("A:    Alle Vermietungen anzeigen.");
        System.out.println("E:    Eine Vermietung erstellen.");
        System.out.println("q:    Eine Vermietung schnell erstellen.");
        System.out.println("B:    Eine Vermietung bearbeiten.");
        System.out.println("L:    Eine Vermietung löschen");
        System.out.println("********************************************************");
        System.out.println("Back:     Das Menue verlassen und zum vorherigen Menue zurueckkehren");
        System.out.println("SaveExit: Die Listen speichern und das Programm verlassen");
        System.out.println("########################################################");
        
        eingegeben = in.nextLine();
        
        if("A".equals(eingegeben))
                 {
                     DBV.Ausleihen_anzeigen();
                 }
        
        
        
             if("E".equals(eingegeben))
	     {
                 System.out.println("---Neue Ausleihe---");
		 System.out.println("Auto ID: ");
		 ausleihe.setAuto_ID(eingabe.readint());
		 System.out.println("Kunden ID: ");
		 ausleihe.setKunden_ID(eingabe.readint());
		 System.out.println("Beginn der Ausleihe: ");
		 ausleihe.setAusleihdatum(eingabe.readdate());
		 System.out.println("Rückgabedatum: ");
		 ausleihe.setRueckgabedatum(eingabe.readdate());
		 System.out.println("Ausleihe erstellt");
		 DBV.addAusleihe(ausleihe);
		 DBV.save(pfad); 
                 System.out.println(ausleihe);
	     }
             
             
             
             if("q".equals(eingegeben))
             {
                 System.out.println("---Neue Ausleihe---");
		 System.out.println("Auto ID: ");
		 ausleihe.setAuto_ID(eingabe.readint());
		 System.out.println("Kunden ID: ");
                 ausleihe.setKunden_ID(eingabe.readint());
                 DBV.addAusleihe(ausleihe);
                 DBV.save(pfad);
                 System.out.println(ausleihe);
             }
             
             
	     
             if("B".equals(eingegeben))
             {
                 int AID;
                 int KID;
                 System.out.println("Welches Ausleihe wollen sie bearbeiten?");
                 
                 System.out.println("AutoID: ");
                 AID = eingabe.readint();
                 
                 System.out.println("KudnenID: ");
                 KID = eingabe.readint();
                 
                 DBV.removeAusleihe(KID,AID);
                 
                 System.out.println("---Neue Ausleihe---");
		 System.out.println("Auto ID: ");
		 ausleihe.setAuto_ID(eingabe.readint());
		 System.out.println("Kunden ID: ");
		 ausleihe.setKunden_ID(eingabe.readint());
		 System.out.println("Beginn der Ausleihe: ");
		 ausleihe.setAusleihdatum(eingabe.readdate());
		 System.out.println("Rückgabedatum: ");
		 ausleihe.setRueckgabedatum(eingabe.readdate());
		 System.out.println("Ausleihe erstellt");
		 DBV.addAusleihe(ausleihe);
		 DBV.save(pfad); 
                 System.out.println(ausleihe);
                 
                 
             }
                          
             
             
             if("L".equals(eingegeben)) 
             {
                 int AID;
                 int KID;
                 System.out.println("Welches Ausleihe wollen sie löschen?");
                 
                 System.out.println("AutoID: ");
                 AID = eingabe.readint();
                 
                 System.out.println("KudnenID: ");
                 KID = eingabe.readint();
                 
                 DBV.removeAusleihe(KID,AID);
             }
             
             
             
             if("Back".equals(eingegeben))
             {
                 Token3 = true;
             }
             
             
             
             if("SaveExit".equals(eingegeben))
             {
                 DBV.save(pfad);
                 Token3 = true;
                 Token1 = true;
             }

	    
	}
}
//###########################################################Automenue #Raicandy
    
          if("A".equals(eingegeben) )
         {
             Token4 = true;
            while(Token4 != true){
            System.out.println("########################################################");
            System.out.println("Autos");
            System.out.println("Was moechten Sie tun? Folgende Optionen stehen zur Wahl:");
            System.out.println("********************************************************");
            System.out.println("A:    Alle Autos anzeigen.");
            System.out.println("E:    Ein Auto erstellen.");
            System.out.println("q:    Ein Auto schnell erstellen.");
            System.out.println("B:    Ein Auto bearbeiten.");
            System.out.println("L:    Ein Auto löschen");
            System.out.println("Ab:    Ein Auto abholen");
            System.out.println("Z:    Ein Auto zurückbringen");
            System.out.println("********************************************************");
            System.out.println("Back:     Das Menue verlassen und zum vorherigen Menue zurueckkehren");
            System.out.println("SaveExit: Die Listen speichern und das Programm verlassen");
            System.out.println("########################################################");
            
            eingegeben = in.nextLine();
          
        if("A".equals(eingegeben))
                 {
                     DBV.Autos_anzeigen();
                 }
        
        
             if("E".equals(eingegeben))
             {
		 
                 System.out.println("---Neues Auto---"); 
                 System.out.println("Auto ID: ");
                 auto.setAuto_ID(eingabe.readint());
                 System.out.println("Kennzeichen: ");
                 auto.setKennzeichen(eingabe.readString());
		 System.out.println("Hersteller: ");
                 auto.setHersteller(eingabe.readString());
                 System.out.println("Modell: ");
                 auto.setModell(eingabe.readString());
                 System.out.println("Anhängerkupplung: ");
                 if("J".equals(eingabe.readString()))
                 {
                     auto.setAnhaengerkupplung(true);
                 }
                 else if("N".equals(eingabe.readString()))
                 {
                     auto.setAnhaengerkupplung(false);
                 }                 
                 else
                 {
                     System.out.println("Bitte geben sie nur J oder N ein!");
                 }
                 System.out.println("Anzahl der Sitzpleatze: ");
                 auto.setSitzplaetze(eingabe.readint());
                 System.out.println("Farbe: ");
                 auto.setFarbe(eingabe.readString());
                 System.out.println("Leistung: ");
                 auto.setLeistung(eingabe.readint());
		 System.out.println("Kraftstoff: ");
                 auto.setKraftstoff(eingabe.readString());
                 System.out.println("Verbrauch: ");
                 auto.setVerbrauch(eingabe.readString());
                 System.out.println("Antrieb: ");
                 auto.setAntrieb(eingabe.readString());
                 System.out.println("Getriebe: ");
                 auto.setGetriebe(eingabe.readString());
                 System.out.println("Baujahr: ");
                 auto.setBaujahr(eingabe.readint());
                 System.out.println("Kilometerstand: ");
                 auto.setKilometerstand(eingabe.readint());
                 System.out.println("TUEV");
                 auto.setTUEV(eingabe.readdate());
                 System.out.println("Kaution: ");
                 auto.setKaution(eingabe.readdouble());
                 System.out.println("Gebühr pro Tag: ");
                 auto.setGebuehr_pro_Tag(eingabe.readfloat());
		 DBV.addAuto(auto);
		 DBV.save(pfad); 
                 System.out.println(auto);

             }
             
             
             
             if("q".equals(eingegeben))
             {
                 System.out.println("---Neues Auto---"); 
                 System.out.println("Auto ID: ");
                 auto.setAuto_ID(eingabe.readint());
                 System.out.println("Kennzeichen: ");
                 auto.setKennzeichen(eingabe.readString());
		 System.out.println("Hersteller: ");
                 auto.setHersteller(eingabe.readString());
                 System.out.println("Modell: ");
                 auto.setModell(eingabe.readString());
                 DBV.addAuto(auto);
                 DBV.save(pfad);
                 System.out.println(auto);
             }
             
             
	     
             if("B".equals(eingegeben))
             {
                 int AID;
                 System.out.println("Welches Auto wollen sie bearbeiten?");
                 System.out.println("AutoID: ");
                 
                 AID = eingabe.readint();
                 
                 DBV.removeKunde(AID);
                 
                 System.out.println("Auto ID: ");
                 auto.setAuto_ID(eingabe.readint());
                 System.out.println("Kennzeichen: ");
                 auto.setKennzeichen(eingabe.readString());
		 System.out.println("Hersteller: ");
                 auto.setHersteller(eingabe.readString());
                 System.out.println("Modell: ");
                 auto.setModell(eingabe.readString());
                 System.out.println("Anhängerkupplung: ");
                 if("J".equals(eingabe.readString()))
                 {
                     auto.setAnhaengerkupplung(true);
                 }
                 else if("N".equals(eingabe.readString()))
                 {
                     auto.setAnhaengerkupplung(false);
                 }                 
                 else
                 {
                     System.out.println("Bitte geben sie nur J oder N ein!");
                 }
                 System.out.println("Anzahl der Sitzpleatze: ");
                 auto.setSitzplaetze(eingabe.readint());
                 System.out.println("Farbe: ");
                 auto.setFarbe(eingabe.readString());
                 System.out.println("Leistung: ");
                 auto.setLeistung(eingabe.readint());
		 System.out.println("Kraftstoff: ");
                 auto.setKraftstoff(eingabe.readString());
                 System.out.println("Verbrauch: ");
                 auto.setVerbrauch(eingabe.readString());
                 System.out.println("Antrieb: ");
                 auto.setAntrieb(eingabe.readString());
                 System.out.println("Getriebe: ");
                 auto.setGetriebe(eingabe.readString());
                 System.out.println("Baujahr: ");
                 auto.setBaujahr(eingabe.readint());
                 System.out.println("Kilometerstand: ");
                 auto.setKilometerstand(eingabe.readint());
                 System.out.println("TUEV");
                 auto.setTUEV(eingabe.readdate());
                 System.out.println("Kaution: ");
                 auto.setKaution(eingabe.readdouble());
                 System.out.println("Gebühr pro Tag: ");
                 auto.setGebuehr_pro_Tag(eingabe.readfloat());
		 DBV.addAuto(auto);
		 DBV.save(pfad); 
                 System.out.println(auto);
                 
                 
             }
                          
             
             
             if("L".equals(eingegeben)) 
             {
                 int AID;
                 System.out.println("Welches Auto wollen sie löschen?");
                 System.out.println("AutoID: ");
                 
                 AID = eingabe.readint();
                 
                 DBV.removeKunde(AID);
                 DBV.save(pfad);
             }
             
             
             
             
             if("Ab".equals(eingegeben)) 
             {
                int AID;
                System.out.println("Welches moechte der Kunde abholen?");
                System.out.println("AutoID: ");
                 
                AID = eingabe.readint();  
                 
                DBV.Auto_abholen(AID);
                DBV.save(pfad);
             }
             
             
             
             if("Z".equals(eingegeben)) 
             {
                int AID;
                System.out.println("Welches Auto moechte der Kunde zurueckgeben?");
                System.out.println("AutoID: ");
                 
                AID = eingabe.readint();  
                 
                DBV.Auto_zurueckbringen(AID);
                DBV.save(pfad);
             }
             
             
             
	     if("Back".equals(eingegeben))
             {
                 Token4 = true;
             }
             
             
             
             if("SaveExit".equals(eingegeben))
             {
                 DBV.save(pfad);
                 Token4 = true;
                 Token1 = true;
             }
             
             
         
         System.out.println("");
	}
    }
        
        
        
    }
        System.exit(0);     //wenn das Token1 auf true steht wird das Programm beendet.
  }
} //***************************Ende Adrian Neubert #Fleescher*******************
 //><><><><><><><><><><Komplett überarbeitet von Daniel Meerwald #Raicandy><><><
}

