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
import javafx.stage.Stage;
import javafx.scene.paint.Color;

/**
 * FXML Controller class
 *
 * @author hiki-tink
 */
public class AutoerstellenController implements Initializable {

    MetaController MC_Hammer = new MetaController();
    @FXML    private TextField kennzeichen;
    @FXML    private TextField Hersteller;
    @FXML    private TextField Modell;
    @FXML    private TextField bauart;
    @FXML    private TextField Farbe;
    @FXML    private TextField oil;
    @FXML    private TextField verbrauch;
    @FXML    private TextField antrieb;
    @FXML    private TextField getrib;
    @FXML    private TextField extra;
    @FXML    private TextField g_b_t;
    @FXML    private TextField kaution;
    @FXML    private TextField tuev;
    @FXML    private TextField km_stand;
    @FXML    private TextField year;
    @FXML    private TextField ps;
    @FXML    private TextField space;
    @FXML    private TextField anheanger;
    @FXML    private Button SaveButton;
    @FXML    private Label kennLabel;
    @FXML    private Label HerLabel;
    @FXML    private Label ModLabel;
    @FXML    private Label bauLabel;
    @FXML    private Label FarbeLabel;
    @FXML    private Label oilLable;
    @FXML    private Label verLabel;
    @FXML    private Label antLable;
    @FXML    private Label getriebLabel;
    @FXML    private Label exLabel;
    @FXML    private Label anLabel;
    @FXML    private Label sitzLabel;
    @FXML    private Label psLabel;
    @FXML    private Label yearLabel;
    @FXML    private Label kmLabel;
    @FXML    private Label tuevLabel;
    @FXML    private Label kautLabel;
    @FXML    private Label gptLabel;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
	// TODO
    }    

    @FXML
    private void handleSaveButton(ActionEvent event) throws ParseException {
	int fehler = 0; //fuehr fehler fall

	// alle werte die uebergeben werden meussen############
	File Foto = null;
     
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
	if (anheanger.getText() == "yes") {
	    anhaengerkupplung = true;
	}
	//#####################
    
	fehler = MC_Hammer.addAuto(Kennzeichen, hersteller
		,modell, Bauart, anhaengerkupplung, sitzplaetze,
		farbe, leistung, kraftstoff,Verbrauch, Antrieb,
		getriebe, baujahr, kilometerstand,TUEV, Kaution, 
		gebuehr_pro_Tag, fahrbar, extras, ist_da);

	switch (fehler) {
	    case 1:
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
	    case -10://kein bild ausgewaehlt
		kennLabel.setTextFill(Color.BLUE);
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
                
            //Ende Steve Vogel
                
                
                //dmflkdflk
	}
    }
    
}
