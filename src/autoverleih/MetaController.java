/*
Komplette Klasse erstellt von Daniel Meerwald
 */
package autoverleih;

import java.text.ParseException;
import java.util.Date;

/**
 *  
 * @author DMeer
 */
public class MetaController {
    
    
    Input eingabe = new Input();
    DB_Verwalter DBV = new DB_Verwalter();
    String pfad = "C:\\TestDatenbank.xml";
        
        
    public void addAusleihe(int Auto_ID, int Kunden_ID, Date Ausleihdatum, Date Rueckgabedatum) throws ParseException{
        
        Ausleihe ausleihe = new Ausleihe();       
        int i = 0;
        boolean Indikator = false;
        
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
                System.out.println("Auto-ID nicht gefunden, bitte erneut eingeben.");
                System.out.println("Auto-ID: ");
                Auto_ID = eingabe.readint();
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
                System.out.println("Kunden-ID nicht gefunden, bitte erneut eingeben.");
                System.out.println("Kunden-ID: ");
                Auto_ID = eingabe.readint();
            }
      }
      
    //#####################Überprüfen für Ausleihe.#############################
      Indikator = false;
      i = 0;
      boolean Kollision = false;
      while(Indikator != true){
        while (i < DBV.Ausleihen.size() && Indikator == false) { 

            if (DBV.Ausleihen.get(i).getAuto_ID() == Auto_ID ) {
                //Test ob ausleihezeiträume kollidieren.
                
                i++;
            } 
            else {
                i++; 
            }
        }
            if (Indikator = true){
                System.out.println("Kollision der Ausleihezeit. Bitte neuen Zeitraum festlegen");
                //Kollision näher bestimmen.
                System.out.println("Ausleihdatum: ");
                Ausleihdatum = eingabe.readdate();
                System.out.println("Rueckgabedatum: ");
                Rueckgabedatum = eingabe.readdate();
            }
            else{
                ausleihe.setAusleihdatum(Ausleihdatum);
                ausleihe.setRueckgabedatum(Rueckgabedatum);
            }
      }
	
        //Wenn alles korrekt ist wird die Ausleihe hinzugefügt.
        DBV.addAusleihe(ausleihe);
        }
        
    }

/*    
    public void Auto_abholen(int A_ID){
        
    }
    
    public void Auto_zurueckbringen(int A_ID){
       
    }
    
    public void setKunden(List<Kunde> Kunden) {
       
    }

    public void setAutos(List<Auto> Autos) {
      
    }
    public void setAusleihen(List<Ausleihe> Ausleihen) {
    
    }

    public void removeKunde(int K_ID){
    
    }
    
    public void removeAuto(int A_ID){
       
    }
    public void removeAusleihe(int K_ID, int A_ID){
        
    }
*/

