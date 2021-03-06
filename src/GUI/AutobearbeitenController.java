/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import autoverleih.MetaController;
import java.io.File;
import java.net.URL;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hiki-tink
 */
public class AutobearbeitenController implements Initializable {

    @FXML    private TextField a_id;
    @FXML    private Label a_id_label;
    @FXML    private Button loadBut;
    @FXML    private TextField kennzeichen;
    @FXML    private Label kennLabel;
    @FXML    private TextField Hersteller;
    @FXML    private Label HerLabel;
    @FXML    private TextField Modell;
    @FXML    private Label ModLabel;
    @FXML    private TextField bauart;
    @FXML    private Label bauLabel;
    @FXML    private TextField anheanger;
    @FXML    private Label anLabel;
    @FXML    private TextField space;
    @FXML    private Label sitzLabel;
    @FXML    private TextField Farbe;
    @FXML    private Label FarbeLabel;
    @FXML    private TextField ps;
    @FXML    private Label psLabel;
    @FXML    private TextField oil;
    @FXML    private Label oilLable;
    @FXML    private TextField verbrauch;
    @FXML    private Label verLabel;
    @FXML    private TextField antrieb;
    @FXML    private Label antLable;
    @FXML    private TextField getrib;
    @FXML    private Label getriebLabel;
    @FXML    private TextField year;
    @FXML    private Label yearLabel;
    @FXML    private TextField km_stand;
    @FXML    private Label kmLabel;
    @FXML    private TextField tuev;
    @FXML    private Label tuevLabel;
    @FXML    private TextField kaution;
    @FXML    private Label kautLabel;
    @FXML    private TextField g_b_t;
    @FXML    private Label gptLabel;
    @FXML    private TextField extra;
    @FXML    private Label exLabel;
    @FXML    private Button SaveButton;
    /**
     * Initializes the controller class.
     */
    
    MetaController MC_Hammer = new MetaController();
    String pfad = "TestDatenbank.xml";
    int A_ID;
    File PATH = null;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
	// TODO
    }    

    @FXML
    private void handleSaveButton(ActionEvent event) throws ParseException {
    int fehler = 0; //fuehr fehler fall

	// alle werte die uebergeben werden meussen############
	File Foto = null;
     
    int AID;
    String Kennzeichen = null;
    String hersteller = null;
    String modell = null;
    String Bauart = null;
    boolean anhaengerkupplung  = false;
    int sitzplaetze  = -1;
    String farbe  = null; 
    int leistung  = -1;
    String kraftstoff  = null;
    double Verbrauch = -1;
    String Antrieb = null;
    String getriebe = null;
    int baujahr  = -1; //int ist einfach einfacher als date, da es nur um das Jahr geht. #Raicandy
    int kilometerstand = -1; 
    Date TUEV  = null; 
    double Kaution  = -1;  
    float gebuehr_pro_Tag  = -1;
    boolean fahrbar  = true;
    String extras  = null;
    boolean ist_da  = true;
    
    SimpleDateFormat format = new SimpleDateFormat("dd.mm.yyyy", new DateFormatSymbols(Locale.GERMANY));
    //###############
// werte uebergeben    
        AID = Integer.parseInt(a_id.getText());
	Kennzeichen = kennzeichen.getText();
	hersteller = Hersteller.getText();
	modell = Modell.getText();
	Bauart = bauart.getText();
	farbe = Farbe.getText();
	kraftstoff = oil.getText();
	Verbrauch = Double.parseDouble(verbrauch.getText());
	Antrieb = antrieb.getText();
	getriebe = getrib.getText();
	extras = extra.getText();
	gebuehr_pro_Tag = Float.parseFloat(g_b_t.getText());
	Kaution = Double.parseDouble(kaution.getText());
	TUEV = format.parse(tuev.getText());
	kilometerstand = Integer.parseInt(km_stand.getText());
	baujahr = Integer.parseInt(year.getText());
	leistung = Integer.parseInt(ps.getText());
	sitzplaetze = Integer.parseInt(space.getText());
        
        //Überprüfung ob Auto zum bearbeiten vorhanden ist, erstellt von Daniel Meerwald #Raicandy
        int i = 0;
        boolean Indikator = false;
        
        while (i < MC_Hammer.DBV.Autos.size() && Indikator == false) { 

            if (MC_Hammer.DBV.Autos.get(i).getAuto_ID() == AID ) {
                Indikator = true; 
            } 
            else {
                i++; 
            }
        }
        
        boolean token = true;
        
        if(Indikator == false){
                a_id_label.setTextFill(Color.RED);
                kennLabel.setTextFill(Color.RED);
                HerLabel.setTextFill(Color.RED);
                ModLabel.setTextFill(Color.RED);
                bauLabel.setTextFill(Color.RED);
                FarbeLabel.setTextFill(Color.RED);
                oilLable.setTextFill(Color.RED);
                verLabel.setTextFill(Color.RED);
                antLable.setTextFill(Color.RED);
                getriebLabel.setTextFill(Color.RED);
                exLabel.setTextFill(Color.RED);
                anLabel.setTextFill(Color.RED);
                sitzLabel.setTextFill(Color.RED);
                psLabel.setTextFill(Color.RED);
                yearLabel.setTextFill(Color.RED);
                kmLabel.setTextFill(Color.RED);
                tuevLabel.setTextFill(Color.RED);
                kautLabel.setTextFill(Color.RED);
                gptLabel.setTextFill(Color.RED);
		token = false;
                
        }
	if (anheanger.getText() == "Ja") {
	    anhaengerkupplung = true;
	}
	else{
	    anhaengerkupplung = false;
	}
	//#####################
        if(token){
	fehler = MC_Hammer.addAuto2(A_ID, Kennzeichen, hersteller
		,modell, Bauart, anhaengerkupplung, sitzplaetze,
		farbe, leistung, kraftstoff,Verbrauch, Antrieb,
		getriebe, baujahr, kilometerstand,TUEV, Kaution, 
		gebuehr_pro_Tag, fahrbar, extras, ist_da,PATH);

	switch (fehler) {
	    case 1:
		MC_Hammer.DBV.restore(pfad);
		MC_Hammer.removeAuto(A_ID);
		Stage popUp = (Stage) kennLabel.getScene().getWindow();
		popUp.close();
		break;
                
                //Autor: Steve Vogel
                
	    case -1:
                kennLabel.setTextFill(Color.RED);
                HerLabel.setTextFill(Color.BLACK);
                ModLabel.setTextFill(Color.BLACK);
                bauLabel.setTextFill(Color.BLACK);
                FarbeLabel.setTextFill(Color.BLACK);
                oilLable.setTextFill(Color.BLACK);
                verLabel.setTextFill(Color.BLACK);
                antLable.setTextFill(Color.BLACK);
                getriebLabel.setTextFill(Color.BLACK);
                exLabel.setTextFill(Color.BLACK);
                anLabel.setTextFill(Color.BLACK);
                sitzLabel.setTextFill(Color.BLACK);
                psLabel.setTextFill(Color.BLACK);
                yearLabel.setTextFill(Color.BLACK);
                kmLabel.setTextFill(Color.BLACK);
                tuevLabel.setTextFill(Color.BLACK);
                kautLabel.setTextFill(Color.BLACK);
                gptLabel.setTextFill(Color.BLACK);
		
		break;
	    case -2:
		kennLabel.setTextFill(Color.RED);
                HerLabel.setTextFill(Color.BLACK);
                ModLabel.setTextFill(Color.BLACK);
                bauLabel.setTextFill(Color.BLACK);
                FarbeLabel.setTextFill(Color.BLACK);
                oilLable.setTextFill(Color.BLACK);
                verLabel.setTextFill(Color.BLACK);
                antLable.setTextFill(Color.BLACK);
                getriebLabel.setTextFill(Color.BLACK);
                exLabel.setTextFill(Color.BLACK);
                anLabel.setTextFill(Color.BLACK);
                sitzLabel.setTextFill(Color.BLACK);
                psLabel.setTextFill(Color.BLACK);
                yearLabel.setTextFill(Color.BLACK);
                kmLabel.setTextFill(Color.BLACK);
                tuevLabel.setTextFill(Color.BLACK);
                kautLabel.setTextFill(Color.BLACK);
                gptLabel.setTextFill(Color.BLACK);

		break;
	    case -3:
		kennLabel.setTextFill(Color.BLACK);
                HerLabel.setTextFill(Color.RED);
                ModLabel.setTextFill(Color.BLACK);
                bauLabel.setTextFill(Color.BLACK);
                FarbeLabel.setTextFill(Color.BLACK);
                oilLable.setTextFill(Color.BLACK);
                verLabel.setTextFill(Color.BLACK);
                antLable.setTextFill(Color.BLACK);
                getriebLabel.setTextFill(Color.BLACK);
                exLabel.setTextFill(Color.BLACK);
                anLabel.setTextFill(Color.BLACK);
                sitzLabel.setTextFill(Color.BLACK);
                psLabel.setTextFill(Color.BLACK);
                yearLabel.setTextFill(Color.BLACK);
                kmLabel.setTextFill(Color.BLACK);
                tuevLabel.setTextFill(Color.BLACK);
                kautLabel.setTextFill(Color.BLACK);
                gptLabel.setTextFill(Color.BLACK);
		

		break;
	    case -4:
		kennLabel.setTextFill(Color.BLACK);
                HerLabel.setTextFill(Color.BLACK);
                ModLabel.setTextFill(Color.RED);
                bauLabel.setTextFill(Color.BLACK);
                FarbeLabel.setTextFill(Color.BLACK);
                oilLable.setTextFill(Color.BLACK);
                verLabel.setTextFill(Color.BLACK);
                antLable.setTextFill(Color.BLACK);
                getriebLabel.setTextFill(Color.BLACK);
                exLabel.setTextFill(Color.BLACK);
                anLabel.setTextFill(Color.BLACK);
                sitzLabel.setTextFill(Color.BLACK);
                psLabel.setTextFill(Color.BLACK);
                yearLabel.setTextFill(Color.BLACK);
                kmLabel.setTextFill(Color.BLACK);
                tuevLabel.setTextFill(Color.BLACK);
                kautLabel.setTextFill(Color.BLACK);
                gptLabel.setTextFill(Color.BLACK);

		break;
	    case -5:
		kennLabel.setTextFill(Color.BLACK);
                HerLabel.setTextFill(Color.BLACK);
                ModLabel.setTextFill(Color.BLACK);
                bauLabel.setTextFill(Color.RED);
                FarbeLabel.setTextFill(Color.BLACK);
                oilLable.setTextFill(Color.BLACK);
                verLabel.setTextFill(Color.BLACK);
                antLable.setTextFill(Color.BLACK);
                getriebLabel.setTextFill(Color.BLACK);
                exLabel.setTextFill(Color.BLACK);
                anLabel.setTextFill(Color.BLACK);
                sitzLabel.setTextFill(Color.BLACK);
                psLabel.setTextFill(Color.BLACK);
                yearLabel.setTextFill(Color.BLACK);
                kmLabel.setTextFill(Color.BLACK);
                tuevLabel.setTextFill(Color.BLACK);
                kautLabel.setTextFill(Color.BLACK);
                gptLabel.setTextFill(Color.BLACK);

		break;
	    case -6:
		kennLabel.setTextFill(Color.BLACK);
                HerLabel.setTextFill(Color.BLACK);
                ModLabel.setTextFill(Color.BLACK);
                bauLabel.setTextFill(Color.BLACK);
                FarbeLabel.setTextFill(Color.BLACK);
                oilLable.setTextFill(Color.BLACK);
                verLabel.setTextFill(Color.BLACK);
                antLable.setTextFill(Color.BLACK);
                getriebLabel.setTextFill(Color.BLACK);
                exLabel.setTextFill(Color.BLACK);
                anLabel.setTextFill(Color.BLACK);
                sitzLabel.setTextFill(Color.RED);
                psLabel.setTextFill(Color.BLACK);
                yearLabel.setTextFill(Color.BLACK);
                kmLabel.setTextFill(Color.BLACK);
                tuevLabel.setTextFill(Color.BLACK);
                kautLabel.setTextFill(Color.BLACK);
                gptLabel.setTextFill(Color.BLACK);

		break;
	    case -7:
		kennLabel.setTextFill(Color.BLACK);
                HerLabel.setTextFill(Color.BLACK);
                ModLabel.setTextFill(Color.BLACK);
                bauLabel.setTextFill(Color.BLACK);
                FarbeLabel.setTextFill(Color.RED);
                oilLable.setTextFill(Color.BLACK);
                verLabel.setTextFill(Color.BLACK);
                antLable.setTextFill(Color.BLACK);
                getriebLabel.setTextFill(Color.BLACK);
                exLabel.setTextFill(Color.BLACK);
                anLabel.setTextFill(Color.BLACK);
                sitzLabel.setTextFill(Color.BLACK);
                psLabel.setTextFill(Color.BLACK);
                yearLabel.setTextFill(Color.BLACK);
                kmLabel.setTextFill(Color.BLACK);
                tuevLabel.setTextFill(Color.BLACK);
                kautLabel.setTextFill(Color.BLACK);
                gptLabel.setTextFill(Color.BLACK);

		break;
	    case -8:
		kennLabel.setTextFill(Color.BLACK);
                HerLabel.setTextFill(Color.BLACK);
                ModLabel.setTextFill(Color.BLACK);
                bauLabel.setTextFill(Color.BLACK);
                FarbeLabel.setTextFill(Color.BLACK);
                oilLable.setTextFill(Color.BLACK);
                verLabel.setTextFill(Color.BLACK);
                antLable.setTextFill(Color.BLACK);
                getriebLabel.setTextFill(Color.BLACK);
                exLabel.setTextFill(Color.BLACK);
                anLabel.setTextFill(Color.BLACK);
                sitzLabel.setTextFill(Color.BLACK);
                psLabel.setTextFill(Color.RED);
                yearLabel.setTextFill(Color.BLACK);
                kmLabel.setTextFill(Color.BLACK);
                tuevLabel.setTextFill(Color.BLACK);
                kautLabel.setTextFill(Color.BLACK);
                gptLabel.setTextFill(Color.BLACK);

		break;
	    case -9:
		kennLabel.setTextFill(Color.BLACK);
                HerLabel.setTextFill(Color.BLACK);
                ModLabel.setTextFill(Color.BLACK);
                bauLabel.setTextFill(Color.BLACK);
                FarbeLabel.setTextFill(Color.BLACK);
                oilLable.setTextFill(Color.RED);
                verLabel.setTextFill(Color.BLACK);
                antLable.setTextFill(Color.BLACK);
                getriebLabel.setTextFill(Color.BLACK);
                exLabel.setTextFill(Color.BLACK);
                anLabel.setTextFill(Color.BLACK);
                sitzLabel.setTextFill(Color.BLACK);
                psLabel.setTextFill(Color.BLACK);
                yearLabel.setTextFill(Color.BLACK);
                kmLabel.setTextFill(Color.BLACK);
                tuevLabel.setTextFill(Color.BLACK);
                kautLabel.setTextFill(Color.BLACK);
                gptLabel.setTextFill(Color.BLACK);

		break;
	    case -10:
		kennLabel.setTextFill(Color.BLACK);
                HerLabel.setTextFill(Color.BLACK);
                ModLabel.setTextFill(Color.BLACK);
                bauLabel.setTextFill(Color.BLACK);
                FarbeLabel.setTextFill(Color.BLACK);
                oilLable.setTextFill(Color.BLACK);
                verLabel.setTextFill(Color.RED);
                antLable.setTextFill(Color.BLACK);
                getriebLabel.setTextFill(Color.BLACK);
                exLabel.setTextFill(Color.BLACK);
                anLabel.setTextFill(Color.BLACK);
                sitzLabel.setTextFill(Color.BLACK);
                psLabel.setTextFill(Color.BLACK);
                yearLabel.setTextFill(Color.BLACK);
                kmLabel.setTextFill(Color.BLACK);
                tuevLabel.setTextFill(Color.BLACK);
                kautLabel.setTextFill(Color.BLACK);
                gptLabel.setTextFill(Color.BLACK);
                
		break;
	    case -11:
		kennLabel.setTextFill(Color.BLACK);
                HerLabel.setTextFill(Color.BLACK);
                ModLabel.setTextFill(Color.BLACK);
                bauLabel.setTextFill(Color.BLACK);
                FarbeLabel.setTextFill(Color.BLACK);
                oilLable.setTextFill(Color.BLACK);
                verLabel.setTextFill(Color.BLACK);
                antLable.setTextFill(Color.RED);
                getriebLabel.setTextFill(Color.BLACK);
                exLabel.setTextFill(Color.BLACK);
                anLabel.setTextFill(Color.BLACK);
                sitzLabel.setTextFill(Color.BLACK);
                psLabel.setTextFill(Color.BLACK);
                yearLabel.setTextFill(Color.BLACK);
                kmLabel.setTextFill(Color.BLACK);
                tuevLabel.setTextFill(Color.BLACK);
                kautLabel.setTextFill(Color.BLACK);
                gptLabel.setTextFill(Color.BLACK);
                
                break;
	    case -12:
		kennLabel.setTextFill(Color.BLACK);
                HerLabel.setTextFill(Color.BLACK);
                ModLabel.setTextFill(Color.BLACK);
                bauLabel.setTextFill(Color.BLACK);
                FarbeLabel.setTextFill(Color.BLACK);
                oilLable.setTextFill(Color.BLACK);
                verLabel.setTextFill(Color.BLACK);
                antLable.setTextFill(Color.BLACK);
                getriebLabel.setTextFill(Color.RED);
                exLabel.setTextFill(Color.BLACK);
                anLabel.setTextFill(Color.BLACK);
                sitzLabel.setTextFill(Color.BLACK);
                psLabel.setTextFill(Color.BLACK);
                yearLabel.setTextFill(Color.BLACK);
                kmLabel.setTextFill(Color.BLACK);
                tuevLabel.setTextFill(Color.BLACK);
                kautLabel.setTextFill(Color.BLACK);
                gptLabel.setTextFill(Color.BLACK);
                
                break;
	    case -13:
		kennLabel.setTextFill(Color.BLACK);
                HerLabel.setTextFill(Color.BLACK);
                ModLabel.setTextFill(Color.BLACK);
                bauLabel.setTextFill(Color.BLACK);
                FarbeLabel.setTextFill(Color.BLACK);
                oilLable.setTextFill(Color.BLACK);
                verLabel.setTextFill(Color.BLACK);
                antLable.setTextFill(Color.BLACK);
                getriebLabel.setTextFill(Color.BLACK);
                exLabel.setTextFill(Color.BLACK);
                anLabel.setTextFill(Color.BLACK);
                sitzLabel.setTextFill(Color.BLACK);
                psLabel.setTextFill(Color.BLACK);
                yearLabel.setTextFill(Color.RED);
                kmLabel.setTextFill(Color.BLACK);
                tuevLabel.setTextFill(Color.BLACK);
                kautLabel.setTextFill(Color.BLACK);
                gptLabel.setTextFill(Color.BLACK);

                break;
	    case -14:
		kennLabel.setTextFill(Color.BLACK);
                HerLabel.setTextFill(Color.BLACK);
                ModLabel.setTextFill(Color.BLACK);
                bauLabel.setTextFill(Color.BLACK);
                FarbeLabel.setTextFill(Color.BLACK);
                oilLable.setTextFill(Color.BLACK);
                verLabel.setTextFill(Color.BLACK);
                antLable.setTextFill(Color.BLACK);
                getriebLabel.setTextFill(Color.BLACK);
                exLabel.setTextFill(Color.BLACK);
                anLabel.setTextFill(Color.BLACK);
                sitzLabel.setTextFill(Color.BLACK);
                psLabel.setTextFill(Color.BLACK);
                yearLabel.setTextFill(Color.BLACK);
                kmLabel.setTextFill(Color.RED);
                tuevLabel.setTextFill(Color.BLACK);
                kautLabel.setTextFill(Color.BLACK);
                gptLabel.setTextFill(Color.BLACK);
                
                break;
	    case -15:
		kennLabel.setTextFill(Color.BLACK);
                HerLabel.setTextFill(Color.BLACK);
                ModLabel.setTextFill(Color.BLACK);
                bauLabel.setTextFill(Color.BLACK);
                FarbeLabel.setTextFill(Color.BLACK);
                oilLable.setTextFill(Color.BLACK);
                verLabel.setTextFill(Color.BLACK);
                antLable.setTextFill(Color.BLACK);
                getriebLabel.setTextFill(Color.BLACK);
                exLabel.setTextFill(Color.BLACK);
                anLabel.setTextFill(Color.BLACK);
                sitzLabel.setTextFill(Color.BLACK);
                psLabel.setTextFill(Color.BLACK);
                yearLabel.setTextFill(Color.BLACK);
                kmLabel.setTextFill(Color.BLACK);
                tuevLabel.setTextFill(Color.RED);
                kautLabel.setTextFill(Color.BLACK);
                gptLabel.setTextFill(Color.BLACK);
                
                break;
	    case -16:
		kennLabel.setTextFill(Color.BLACK);
                HerLabel.setTextFill(Color.BLACK);
                ModLabel.setTextFill(Color.BLACK);
                bauLabel.setTextFill(Color.BLACK);
                FarbeLabel.setTextFill(Color.BLACK);
                oilLable.setTextFill(Color.BLACK);
                verLabel.setTextFill(Color.BLACK);
                antLable.setTextFill(Color.BLACK);
                getriebLabel.setTextFill(Color.BLACK);
                exLabel.setTextFill(Color.BLACK);
                anLabel.setTextFill(Color.BLACK);
                sitzLabel.setTextFill(Color.BLACK);
                psLabel.setTextFill(Color.BLACK);
                yearLabel.setTextFill(Color.BLACK);
                kmLabel.setTextFill(Color.BLACK);
                tuevLabel.setTextFill(Color.BLACK);
                kautLabel.setTextFill(Color.RED);
                gptLabel.setTextFill(Color.BLACK);
                
                break;
	    case -17:
		kennLabel.setTextFill(Color.BLACK);
                HerLabel.setTextFill(Color.BLACK);
                ModLabel.setTextFill(Color.BLACK);
                bauLabel.setTextFill(Color.BLACK);
                FarbeLabel.setTextFill(Color.BLACK);
                oilLable.setTextFill(Color.BLACK);
                verLabel.setTextFill(Color.BLACK);
                antLable.setTextFill(Color.BLACK);
                getriebLabel.setTextFill(Color.BLACK);
                exLabel.setTextFill(Color.BLACK);
                anLabel.setTextFill(Color.BLACK);
                sitzLabel.setTextFill(Color.BLACK);
                psLabel.setTextFill(Color.BLACK);
                yearLabel.setTextFill(Color.BLACK);
                kmLabel.setTextFill(Color.BLACK);
                tuevLabel.setTextFill(Color.BLACK);
                kautLabel.setTextFill(Color.BLACK);
                gptLabel.setTextFill(Color.RED);
                
                break;
	    case -18:
		kennLabel.setTextFill(Color.BLACK);
                HerLabel.setTextFill(Color.BLUE);
                ModLabel.setTextFill(Color.BLUE);
                bauLabel.setTextFill(Color.BLACK);
                FarbeLabel.setTextFill(Color.BLACK);
                oilLable.setTextFill(Color.BLACK);
                verLabel.setTextFill(Color.BLACK);
                antLable.setTextFill(Color.BLACK);
                getriebLabel.setTextFill(Color.BLACK);
                exLabel.setTextFill(Color.BLACK);
                anLabel.setTextFill(Color.BLACK);
                sitzLabel.setTextFill(Color.BLACK);
                psLabel.setTextFill(Color.BLACK);
                yearLabel.setTextFill(Color.BLACK);
                kmLabel.setTextFill(Color.BLACK);
                tuevLabel.setTextFill(Color.BLACK);
                kautLabel.setTextFill(Color.BLACK);
                gptLabel.setTextFill(Color.BLACK);
                
                break;
	    case -19:
		kennLabel.setTextFill(Color.BLACK);
                HerLabel.setTextFill(Color.BLACK);
                ModLabel.setTextFill(Color.BLACK);
                bauLabel.setTextFill(Color.BLACK);
                FarbeLabel.setTextFill(Color.BLACK);
                oilLable.setTextFill(Color.BLACK);
                verLabel.setTextFill(Color.BLACK);
                antLable.setTextFill(Color.BLACK);
                getriebLabel.setTextFill(Color.BLACK);
                exLabel.setTextFill(Color.RED);
                anLabel.setTextFill(Color.BLACK);
                sitzLabel.setTextFill(Color.BLACK);
                psLabel.setTextFill(Color.BLACK);
                yearLabel.setTextFill(Color.BLACK);
                kmLabel.setTextFill(Color.BLACK);
                tuevLabel.setTextFill(Color.BLACK);
                kautLabel.setTextFill(Color.BLACK);
                gptLabel.setTextFill(Color.BLACK);
                
                break;
	    case -20:
		kennLabel.setTextFill(Color.BLACK);
                HerLabel.setTextFill(Color.BLACK);
                ModLabel.setTextFill(Color.BLACK);
                bauLabel.setTextFill(Color.BLACK);
                FarbeLabel.setTextFill(Color.BLACK);
                oilLable.setTextFill(Color.BLACK);
                verLabel.setTextFill(Color.BLACK);
                antLable.setTextFill(Color.BLACK);
                getriebLabel.setTextFill(Color.BLUE);
                exLabel.setTextFill(Color.BLACK);
                anLabel.setTextFill(Color.BLACK);
                sitzLabel.setTextFill(Color.BLUE);
                psLabel.setTextFill(Color.BLACK);
                yearLabel.setTextFill(Color.BLACK);
                kmLabel.setTextFill(Color.BLACK);
                tuevLabel.setTextFill(Color.BLACK);
                kautLabel.setTextFill(Color.BLACK);
                gptLabel.setTextFill(Color.BLACK);
                
		break;
	    default:
		kennLabel.setTextFill(Color.BLACK);
                HerLabel.setTextFill(Color.BLUE);
                ModLabel.setTextFill(Color.BLACK);
                bauLabel.setTextFill(Color.BLUE);
                FarbeLabel.setTextFill(Color.BLACK);
                oilLable.setTextFill(Color.BLUE);
                verLabel.setTextFill(Color.BLACK);
                antLable.setTextFill(Color.BLUE);
                getriebLabel.setTextFill(Color.BLACK);
                exLabel.setTextFill(Color.BLUE);
                anLabel.setTextFill(Color.BLACK);
                sitzLabel.setTextFill(Color.BLUE);
                psLabel.setTextFill(Color.BLACK);
                yearLabel.setTextFill(Color.BLUE);
                kmLabel.setTextFill(Color.BLACK);
                tuevLabel.setTextFill(Color.BLUE);
                kautLabel.setTextFill(Color.BLACK);
                gptLabel.setTextFill(Color.BLUE);

		break;
                
            //Ende Steve Vogel
	}
       }
    }

    @FXML
    private void handleLoadButton(ActionEvent event) {
	//kann auf dbv net zugreifen!!!!
        int i = 0;
        A_ID = Integer.parseInt(a_id.getText());
        boolean indikator = false;

        MC_Hammer.DBV.restore(pfad);
        while (i < MC_Hammer.DBV.Autos.size() && indikator == false) { //Suche bis zum Ende der Liste.
            if (MC_Hammer.DBV.Autos.get(i).getAuto_ID() == A_ID ) {
                indikator = true; //Ende der Methode, wenn das Objekt gefunden wurde.
            } else {
                i++; //Andernfalls wird das nächste Element vergleichen.
            }
        }
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy", new DateFormatSymbols(Locale.GERMANY));
        kennzeichen.setText(MC_Hammer.DBV.Autos.get(i).getKennzeichen());
	Hersteller.setText(MC_Hammer.DBV.Autos.get(i).getHersteller());
	Modell.setText(MC_Hammer.DBV.Autos.get(i).getModell());
	bauart.setText(MC_Hammer.DBV.Autos.get(i).getBauart());
	Farbe.setText(MC_Hammer.DBV.Autos.get(i).getFarbe());
	oil.setText(MC_Hammer.DBV.Autos.get(i).getKraftstoff());
	verbrauch.setText(String.valueOf(MC_Hammer.DBV.Autos.get(i).getVerbrauch()));
	antrieb.setText(MC_Hammer.DBV.Autos.get(i).getAntrieb());
	getrib.setText(MC_Hammer.DBV.Autos.get(i).getGetriebe());
	extra.setText(MC_Hammer.DBV.Autos.get(i).getExtras());
	g_b_t.setText(String.valueOf(MC_Hammer.DBV.Autos.get(i).getGebuehr_pro_Tag()));
	kaution.setText(String.valueOf(MC_Hammer.DBV.Autos.get(i).getKaution()));
	tuev.setText(String.valueOf(format.format(MC_Hammer.DBV.Autos.get(i).getTUEV())));
	km_stand.setText(String.valueOf(MC_Hammer.DBV.Autos.get(i).getKilometerstand()));
	year.setText(String.valueOf(MC_Hammer.DBV.Autos.get(i).getBaujahr()));
	ps.setText(String.valueOf(MC_Hammer.DBV.Autos.get(i).getLeistung()));
        if(MC_Hammer.DBV.Autos.get(i).getAnhaengerkupplung()){
            anheanger.setText("Ja");
        }
        else{
            anheanger.setText("Nein");
        }
        PATH = MC_Hammer.DBV.Autos.get(i).getFoto();
	space.setText(String.valueOf(MC_Hammer.DBV.Autos.get(i).getSitzplaetze()));
    }
    
}
