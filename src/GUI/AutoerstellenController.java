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
    String Verbrauch = null;
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
	Verbrauch = verbrauch.getText();
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
    
	fehler = MC_Hammer.addAuto(Foto, Kennzeichen, hersteller
		,modell, Bauart, anhaengerkupplung, sitzplaetze,
		farbe, leistung, kraftstoff,Verbrauch, Antrieb,
		getriebe, baujahr, kilometerstand,TUEV, Kaution, 
		gebuehr_pro_Tag, fahrbar, extras, ist_da);

	switch (fehler) {
	    case 1:
		Stage popUp = (Stage) kennLabel.getScene().getWindow();
		popUp.close();
		break;
	    case -1:
		/*
kennLabel;
 HerLabel;
 ModLabel;
bauLabel;
 FarbeLabel;
 oilLable;
verLabel;
antLable;
getriebLabel;
exLabel;
 anLabel;
sitzLabel;
psLabel;
yearLabel;
kmLabel;
tuevLabel;
kautLabel;
    gptLabel;*/
		
		break;
	    case -2:
		

		break;
	    case -3:
		
		

		break;
	    case -4:
		

		break;
	    case -5:
		

		break;
	    case -6:
		

		break;
	    case -7:
		

		break;
	    case -8:
		

		break;
	    case -9:
		

		break;
	    case -10://kein bild ausgewaehlt
		
		break;
	    case -11:
		

		break;
	    default:
		

		break;
	}
    }
    
}
