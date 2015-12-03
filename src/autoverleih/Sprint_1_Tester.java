package autoverleih;

import java.text.ParseException;


public class Sprint_1_Tester 
{
       public static void main(String[] args) throws ParseException
    {
        Input eingabe = new Input();
        Auto auto = new Auto();
        Kunde kunde = new Kunde();
	Ausleihe ausleihe = new Ausleihe();
	DB_Verwalter DBV = new DB_Verwalter();
	while(true)
	{
         System.out.println("Guten Tag");
         System.out.println("Was möchten sie tun?");
         System.out.println("(K)unden bearbeiten, (A)utos bearbeiten");
         
         //Bearbeitungsdialog für Kunden
         if("K".equals(eingabe.readString()))
         {
             System.out.println("-----Kunden-----");
             System.out.println("Kunde (E)rstellen --- Kunde (L)öschen --- (V)ermeitung ");
             if("E".equals(eingabe.readString()))
             {
		 
                 // Daten des neuen Kunden eingeben
                 System.out.println("---Neuer Kunde---");
                 System.out.println("Kunden ID: ");
                 kunde.setKunden_ID(eingabe.readint());          
                 System.out.println("Nachname: ");
                 kunde.setNachname(eingabe.readString());
                 System.out.println("Vorname: ");
                 kunde.setVorname(eingabe.readString());
                 /*System.out.println("Postleitzahl: ");
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
                 kunde.setFuehrerscheindatum(eingabe.readdate());*/
		 DBV.addKunde(kunde);
		 DBV.save("C:\\TestDatenbank.xml"); 
        /*Hier muss jetzt die addKunde() Methode aufgerufen werden, die diesen 
        Gerade angelegten Kudnen in die Datenbank hinzufügt. Danach könnte die 
        Save() Methode aus dem DB_Verwalter mit einem Vom User Bestimmten Path 
        aufgerufen werden. #Raicandy*/
                 // Noch keine File-Eingabe hier aber erstmal nebensächlich
             }
             else
             {
                 System.out.println("Bitte geben sie nur E oder L ein!");
             }
	     /*
             if("L".equals(eingabe.readString())) 
             {
                 // Kundendaten löschen
                 System.out.println("---Kunde löschen ---");
                 kunde.setKunden_ID(0);          
                 kunde.setNachname(null);
                 kunde.setVorname(null);
                 kunde.setPostleitzahl(0);
                 kunde.setWohnort(null);
                 kunde.setStrasse(null);
                 kunde.setHausnummer(null);
                 kunde.setE_Mail(null);
                 kunde.setTelefonnummer(0);
                 kunde.setGeburtstag(null);
                 kunde.setFuehrerscheindatum(null);
             }
             else
             {
                 System.out.println("Bitte geben sie nur E oder L ein!");
             }
	     */
         }
         else
         {
             System.out.println("Bitte geben sie nur K oder A ein!");
         }
         
	 if("V".equals(eingabe.readString()))
	{
	    System.out.println("-----Vermietung-----");
             System.out.println("Vermietung (E)rstellen --- Auto (L)öschen");
             if("E".equals(eingabe.readString()))
	     {
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
		 DBV.save("C:\\TestDatenbank_aus.xml"); 
	     }
	    
	}
	 
         // Bearbeitungsdialog für Autos
          if("A".equals(eingabe.readString()) )
         {
             System.out.println("-----Auto-----");
             System.out.println("Auto (E)rstellen --- Auto (L)öschen");
             if("E".equals(eingabe.readString()))
             {
                 // Autodaten eingeben
                 System.out.println("---Neues Auto---"); 
                 System.out.println("Auto ID: ");
                 auto.setAuto_ID(eingabe.readint());
                 System.out.println("Kennzeichen: ");
                 auto.setKennzeichen(eingabe.readString());
		 /*
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
		 */
		 //######## metting 3.12.2015######################
		 DBV.addAuto(auto);
		 DBV.save("C:\\TestDatenbank_a.xml"); 
		 //################################################
             }
             else
             {
                 System.out.println("Bitte geben sie nur E oder L ein!");
             }
             // Auto löschen
             if("L".equals(eingabe.readString())) 
             {
                 System.out.println("---Auto löschen ---");
                 auto.setAuto_ID(0);
                 auto.setKennzeichen(null);
                 auto.setHersteller(null);          
                 auto.setModell(null);
                 //auto.setAnhaengerkupplung(false);
                 auto.setSitzplaetze(0);
                 auto.setFarbe(null);
                 auto.setLeistung(0);
                 auto.setKraftstoff(null);
                 auto.setVerbrauch(null);
                 auto.setAntrieb(null);
                 auto.setGetriebe(null);
                 auto.setBaujahr(0);
                 auto.setBaujahr(0);
                 auto.setKilometerstand(0);
                 auto.setTUEV(null);
                 auto.setKaution(0);
                 auto.setGebuehr_pro_Tag(0);                                  
             }
         }
         else
         {
             System.out.println("Bitte geben sie nur K oder A oder V ein!");
         }
         
         System.out.println("");
	}
    }
} //***************************Ende Adrian Neubert #Fleescher*******************

