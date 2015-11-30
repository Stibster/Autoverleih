package autoverleih;

import java.io.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.util.Locale;

public class Input 
{  
//*************Erstellt von Adrian Neubert****************************#Fleescher        
    
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
        float n = Float.parseFloat(s);
        return n;
    }
    
    // Lesen eines double-Wertes von der Tastatur
    // Exception falls kein gültiger double-Wert
    public static double readdouble()throws NumberFormatException
    {
        String s = readString();
        double n = Double.parseDouble(s);
        return n;
    }
    
     // Lesen eines date-Wertes von der Tastatur
     // Exception falls kein gültiger date-Wert
    public static Date readdate() throws ParseException
    {
        String s = readString();
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy", new DateFormatSymbols(Locale.GERMANY));
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
    
}
