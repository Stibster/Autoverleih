package autoverleih;

public class Sprint_1_Tester 
{
       public static void main(String[] args)
    {
        Input eingabe = new Input();
        Auto auto = new Auto();
        Kunde kunde = new Kunde();
        
         System.out.println("Guten Tag");
         System.out.println("Was möchten sie tun?");
         System.out.println("(K)unden bearbeiten, (A)utos bearbeiten");
         //Bearbeitungsdialog für Kunden
         if("K".equals(eingabe.readString()) )
         {
             System.out.println("-----Kunden-----");
             System.out.println("Kunde (E)rstellen --- Kunde (L)öschen");
             if("E".equals(eingabe.readString()))
             {
                 System.out.println("---Neuer Kunde---");// Daten des neuen Kunden eingeben
                 System.out.println("Kunden ID: ");
                 kunde.setKunden_ID(eingabe.readint());          
                 System.out.println("Nachname: ");
                 kunde.setNachname(eingabe.readString());
                 System.out.println("Vorname: ");
                 kunde.setVorname(eingabe.readString());
                 //gibt noch mehr Kundendaten war zu faul die noch einzutragen :D
                 //Für einige Dateneingaben müssen oben noch Methoden entwickelt werden
             }
             else
             {
                 System.out.println("Bitte geben sie nur E oder L ein!");
             }
             if("L".equals(eingabe.readString()))// Kundendaten löschen
             {
                 System.out.println("---Kunde löschen ---");
                 kunde.setKunden_ID(0);          
                 kunde.setNachname(null);
                 kunde.setVorname(null);
             }
             else
             {
                 System.out.println("Bitte geben sie nur E oder L ein!");
             }
         }
         else
         {
             System.out.println("Bitte geben sie nur K oder A ein!");
         }
         
         // Bearbeitungsdialog für Autos
          if("A".equals(eingabe.readString()) )
         {
             System.out.println("-----Auto-----");
             System.out.println("Auto (E)rstellen --- Auto (L)öschen");
             if("E".equals(eingabe.readString()))
             {
                 System.out.println("---Neues Auto---");// Autodaten eingeben
                 System.out.println("Auto ID: ");
                 auto.setAuto_ID(eingabe.readint());
                 System.out.println("Hersteller: ");
                 auto.setHersteller(eingabe.readString());
                 System.out.println("Kaution: ");
                 auto.setKaution(eingabe.readdouble());
                 // gibt noch mehr Autodaten war zu faul alle hier hin zu schreiben :D
                 // Für einige Daten müssen oben noch Methoden entwickelt werden
             }
             else
             {
                 System.out.println("Bitte geben sie nur E oder L ein!");
             }
             
             if("L".equals(eingabe.readString()))// Auto löschen
             {
                 System.out.println("---Auto löschen ---");
                 auto.setAuto_ID(0);
                 auto.setHersteller(null);
                 auto.setKaution(0);
             }
         }
         else
         {
             System.out.println("Bitte geben sie nur K oder A ein!");
         }
         
         System.out.println("");
    }
} //***************************Ende Adrian Neubert #Fleescher*******************

