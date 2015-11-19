package autoverleih;

import java.io.*;
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
    //**************************************************************************
    /*
    * Nur Tastatur-Eingabe!!
    * Noch kein Dialog!!!! 
    */
    
}
