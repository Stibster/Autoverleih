/*

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
    
    // 1 return alles erfolgreich gespeichert
    // 0 normal fall keine daten, nichts wird angezeigt
    // -1 auto id
    // -2 kunde
    // -3 ausleihdatum
    
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
                
		indikator = -3;
            }
            else{
                ausleihe.setAusleihdatum(Ausleihdatum);
                ausleihe.setRueckgabedatum(Rueckgabedatum);
            }
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

        while (i < DBV.Autos.size() && indikator == false) { //Suche bis zum Ende der Liste.

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

