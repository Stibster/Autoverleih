package autoverleih;

import java.io.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.util.Locale;
/**
 *
 * @author Raicandy(Punker)
 */
public class IO_Class_first_Sprint 
//*************Erstellt von Adrian Neubert****************************#Fleescher        
{
    
    // Zum EInlesen der Tastatur-Eingabe wird ein Standart-Eingabe-Kanal verwendet.
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    
    /**
     * Lesen einer Zeichenkette von der Tastatur. 
     * Theoretisch mögliche IOException wird ohne Reaktion abgefangen
    **/
    public static String readString()
    {
        String s = "";
        try
        {
            s = input.readLine();
        }
        catch(IOException e)
        {
            // keine Reaktion
        }
        
        return s;
    }
     // Lesen eines int-Wertes von der Tastatur
     // Exception falls kein gültiger int-Wert
    public static int readint() throws NumberFormatException
    {
        String s = readString();
        int n = Integer.parseInt(s);
        return n;
    }
     // Lesen eines float-Wertes von der Tastatur
     // Exception falls kein gültiger float-Wert
    public static float readfloat() throws NumberFormatException
    {
        String s = readString();
        float n = Float.valueOf(s).floatValue();
        return n;
    }
    
    // Lesen eines double-Wertes von der Tastatur
    // Exception falls kein gültiger double-Wert
    public static double readdouble()throws NumberFormatException
    {
        String s = readString();
        double n = Double.valueOf(s).doubleValue();
        return n;
    }
    
     // Lesen eines date-Wertes von der Tastatur
     // Exception falls kein gültiger date-Wert
    public static Date readdate() throws ParseException
    {
        String s = readString();
        SimpleDateFormat format = new SimpleDateFormat("dd MM yyyy", new DateFormatSymbols(Locale.GERMANY));
        Date date = format.parse(s);
        return date;
        
        /*
        d = Day a Month 
        D = Day a Year
        w = week in Year
        W = Week in month
        y = Year
        
        dd -> 03
        d -> 3
        D -> 65
        DDD -> 065 
        w -> 23
        W -> 3
        yy -> 12
        yyyy -> 2012
        
        Formatierungen fürs Datum, gibt noch mehr, 
        sollten wir diskutieren welches Format!!!!
        */      
    }
    
    public static void main(String[] args)
    {
        Auto auto = new Auto();
        Kunde kunde = new Kunde();
         System.out.println("Guten Tag");
         System.out.println("Was möchten sie tun?");
         System.out.println("(K)unden bearbeiten, (A)utos bearbeiten");
         //Bearbeitungsdialog für Kunden
         if(readString() == "K" )
         {
             System.out.println("-----Kunden-----");
             System.out.println("Kunde (E)rstellen --- Kunde (L)öschen");
             if(readString() == "E")
             {
                 System.out.println("---Neuer Kunde---");// Daten des neuen Kunden eingeben
                 System.out.println("Kunden ID: ");
                 kunde.setKunden_ID(readint());          
                 System.out.println("Nachname: ");
                 kunde.setNachname(readString());
                 System.out.println("Vorname: ");
                 kunde.setVorname(readString());
                 //gibt noch mehr Kundendaten war zu faul die noch einzutragen :D
                 //Für einige Dateneingaben müssen oben noch Methoden entwickelt werden
             }
             else
             {
                 System.out.println("Bitte geben sie nur E oder L ein!");
             }
             if(readString() == "L")// Kundendaten löschen
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
          if(readString() == "A" )
         {
             System.out.println("-----Auto-----");
             System.out.println("Auto (E)rstellen --- Auto (L)öschen");
             if(readString() == "E")
             {
                 System.out.println("---Neues Auto---");// Autodaten eingeben
                 System.out.println("Auto ID: ");
                 auto.setAuto_ID(readint());
                 System.out.println("Hersteller: ");
                 auto.setHersteller(readString());
                 System.out.println("Kaution: ");
                 auto.setKaution(readdouble());
                 // gibt noch mehr Autodaten war zu faul alle hier hin zu schreiben :D
                 // Für einige Daten müssen oben noch Methoden entwickelt werden
             }
             else
             {
                 System.out.println("Bitte geben sie nur E oder L ein!");
             }
             
             if(readString() == "L")// Auto löschen
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
