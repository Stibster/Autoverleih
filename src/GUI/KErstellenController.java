/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import autoverleih.DB_Verwalter;
import autoverleih.Kunde;
import autoverleih.MetaController;
import java.io.File;
import java.net.URL;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class KErstellenController implements Initializable {

    MetaController MC_Hammer = new MetaController();

    @FXML    private TextField name_text;
    @FXML    private TextField vorname_text;
    @FXML    private Button k_pop_save;
    @FXML    private Label preLabel;
    @FXML    private Label postLabel;
    @FXML    private TextField birthday;
    @FXML    private TextField Ort;
    @FXML    private TextField street;
    @FXML    private TextField h_num;
    @FXML    private TextField email;
    @FXML    private TextField tel_num;
    @FXML    private TextField car_date;
    @FXML    private TextField car_k;
    @FXML    private Label bdLabel;
    @FXML    private Label ortLabel;
    @FXML    private Label streetLabel;
    @FXML    private Label h_numLable;
    @FXML    private Label emailLable;
    @FXML    private Label tel_numLable;
    @FXML    private Label car_dateLable;
    @FXML    private Label car_kLable;
    @FXML
    private TextField plz;
    @FXML
    private Label plzLable;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

   
    // 1 return alles erfolgreich gespeichert
    // 0 normal fall keine daten, nichts wird angezeigt
    // -1 Vorname, Nachname und Geburtstag schon einmal zusammen vorhanden
    // -2 Vorname muss ersten Buchstaben groß und Rest klein haben
    // -3 Nachname muss ersten Buchstaben groß und Rest klein haben
    // -4 Wohnort muss ersten Buchstaben groß und Rest klein haben
    // -5 Strasse muss ersten Buchstaben groß und Rest klein haben
    // -6 Hausnummer besteht nur aus Zahlen und/oder Buchstaben
    // -7 EMail schema xxx(.yyy)@aaa.bb.cc
    // -8 Telefonnummer falsch
    // -9 Gebrutstag falsch
    // -10 Führerschein falsch
    // -11 Führerscheindatum falsch
    // -12 Postleitzahl
    
    //int mit vorgestellter 0 gehen beim parsen weg!!
    @FXML
    private void handleK_POP_SAVE(ActionEvent event) throws ParseException {
	int fehler = 0; //fuehr fehler fall
	String Vorname = null;
	String Name = null;
        String Plz = null;
	String ort = null;
	String Str = null;
	String H_num = null;
	String Email = null;
	String tel = null;
	Date Geb = null;
	File Fschein = null;
	Date Fdate = null;
	String Fklasse = null;
	SimpleDateFormat format = new SimpleDateFormat("dd.mm.yyyy", new DateFormatSymbols(Locale.GERMANY));        
	
	Vorname =vorname_text.getText();
	Name =  name_text.getText();
	Plz = plz.getText();
	ort = Ort.getText();
	H_num = h_num.getText();
	Str = street.getText();
	Email = email.getText();
	tel = tel_num.getText();
	Fklasse = car_k.getText();
        
	    Geb = format.parse(birthday.getText());
	
	
	    //Fschein???? //grad keinen plan
	    Fdate = format.parse(car_date.getText());
	
	
	fehler = MC_Hammer.addKunde(Vorname, Name, Plz, ort, Str,
		H_num, Email, tel, Geb, Fschein, Fdate, Fklasse);

	switch (fehler) {
	    case 1:
		Stage popUp = (Stage) preLabel.getScene().getWindow();
		popUp.close();
		break;
	    case -1:
		preLabel.setTextFill(Color.RED);
		postLabel.setTextFill(Color.RED);
		bdLabel.setTextFill(Color.RED);
		ortLabel.setTextFill(Color.BLACK);
		plzLable.setTextFill(Color.BLACK);
		streetLabel.setTextFill(Color.BLACK);
		h_numLable.setTextFill(Color.BLACK);
		emailLable.setTextFill(Color.BLACK);
		tel_numLable.setTextFill(Color.BLACK);
		car_dateLable.setTextFill(Color.BLACK);
		car_kLable.setTextFill(Color.BLACK);
		break;
	    case -2:
		preLabel.setTextFill(Color.RED);
		postLabel.setTextFill(Color.BLACK);
		bdLabel.setTextFill(Color.BLACK);
		ortLabel.setTextFill(Color.BLACK);
		plzLable.setTextFill(Color.BLACK);
		streetLabel.setTextFill(Color.BLACK);
		h_numLable.setTextFill(Color.BLACK);
		emailLable.setTextFill(Color.BLACK);
		tel_numLable.setTextFill(Color.BLACK);
		car_dateLable.setTextFill(Color.BLACK);
		car_kLable.setTextFill(Color.BLACK);

		break;
	    case -3:
		preLabel.setTextFill(Color.BLACK);
		postLabel.setTextFill(Color.RED);
		bdLabel.setTextFill(Color.BLACK);
		ortLabel.setTextFill(Color.BLACK);
		plzLable.setTextFill(Color.BLACK);
		streetLabel.setTextFill(Color.BLACK);
		h_numLable.setTextFill(Color.BLACK);
		emailLable.setTextFill(Color.BLACK);
		tel_numLable.setTextFill(Color.BLACK);
		car_dateLable.setTextFill(Color.BLACK);
		car_kLable.setTextFill(Color.BLACK);

		break;
	    case -4:
		preLabel.setTextFill(Color.BLACK);
		postLabel.setTextFill(Color.BLACK);
		bdLabel.setTextFill(Color.BLACK);
		ortLabel.setTextFill(Color.RED);
		plzLable.setTextFill(Color.BLACK);
		streetLabel.setTextFill(Color.BLACK);
		h_numLable.setTextFill(Color.BLACK);
		emailLable.setTextFill(Color.BLACK);
		tel_numLable.setTextFill(Color.BLACK);
		car_dateLable.setTextFill(Color.BLACK);
		car_kLable.setTextFill(Color.BLACK);

		break;
	    case -5:
		preLabel.setTextFill(Color.BLACK);
		postLabel.setTextFill(Color.BLACK);
		bdLabel.setTextFill(Color.BLACK);
		ortLabel.setTextFill(Color.BLACK);
		plzLable.setTextFill(Color.BLACK);
		streetLabel.setTextFill(Color.RED);
		h_numLable.setTextFill(Color.BLACK);
		emailLable.setTextFill(Color.BLACK);
		tel_numLable.setTextFill(Color.BLACK);
		car_dateLable.setTextFill(Color.BLACK);
		car_kLable.setTextFill(Color.BLACK);

		break;
	    case -6:
		preLabel.setTextFill(Color.BLACK);
		postLabel.setTextFill(Color.BLACK);
		bdLabel.setTextFill(Color.BLACK);
		ortLabel.setTextFill(Color.BLACK);
		plzLable.setTextFill(Color.BLACK);
		streetLabel.setTextFill(Color.BLACK);
		h_numLable.setTextFill(Color.RED);
		emailLable.setTextFill(Color.BLACK);
		tel_numLable.setTextFill(Color.BLACK);
		car_dateLable.setTextFill(Color.BLACK);
		car_kLable.setTextFill(Color.BLACK);

		break;
	    case -7:
		preLabel.setTextFill(Color.BLACK);
		postLabel.setTextFill(Color.BLACK);
		bdLabel.setTextFill(Color.BLACK);
		ortLabel.setTextFill(Color.BLACK);
		plzLable.setTextFill(Color.BLACK);
		streetLabel.setTextFill(Color.BLACK);
		h_numLable.setTextFill(Color.BLACK);
		emailLable.setTextFill(Color.RED);
		tel_numLable.setTextFill(Color.BLACK);
		car_dateLable.setTextFill(Color.BLACK);
		car_kLable.setTextFill(Color.BLACK);

		break;
	    case -8:
		preLabel.setTextFill(Color.BLACK);
		postLabel.setTextFill(Color.BLACK);
		bdLabel.setTextFill(Color.BLACK);
		ortLabel.setTextFill(Color.BLACK);
		plzLable.setTextFill(Color.BLACK);
		streetLabel.setTextFill(Color.BLACK);
		h_numLable.setTextFill(Color.BLACK);
		emailLable.setTextFill(Color.BLACK);
		tel_numLable.setTextFill(Color.RED);
		car_dateLable.setTextFill(Color.BLACK);
		car_kLable.setTextFill(Color.BLACK);

		break;
	    case -9:
		preLabel.setTextFill(Color.BLACK);
		postLabel.setTextFill(Color.BLACK);
		bdLabel.setTextFill(Color.RED);
		ortLabel.setTextFill(Color.BLACK);
		plzLable.setTextFill(Color.BLACK);
		streetLabel.setTextFill(Color.BLACK);
		h_numLable.setTextFill(Color.BLACK);
		emailLable.setTextFill(Color.BLACK);
		tel_numLable.setTextFill(Color.BLACK);
		car_dateLable.setTextFill(Color.BLACK);
		car_kLable.setTextFill(Color.BLACK);

		break;
	    case -10://kein bild ausgewaehlt
		preLabel.setTextFill(Color.BLUE);
		postLabel.setTextFill(Color.BLACK);
		bdLabel.setTextFill(Color.BLACK);
		ortLabel.setTextFill(Color.BLACK);
		plzLable.setTextFill(Color.BLACK);
		streetLabel.setTextFill(Color.BLACK);
		h_numLable.setTextFill(Color.BLACK);
		emailLable.setTextFill(Color.BLACK);
		tel_numLable.setTextFill(Color.BLACK);
		car_dateLable.setTextFill(Color.BLACK);
		car_kLable.setTextFill(Color.BLACK);
		
		//sollte gar nicht aufrteten bis jetze

		break;
	    case -11:
		preLabel.setTextFill(Color.BLACK);
		postLabel.setTextFill(Color.BLACK);
		bdLabel.setTextFill(Color.BLACK);
		ortLabel.setTextFill(Color.BLACK);
		plzLable.setTextFill(Color.BLACK);
		streetLabel.setTextFill(Color.BLACK);
		h_numLable.setTextFill(Color.BLACK);
		emailLable.setTextFill(Color.BLACK);
		tel_numLable.setTextFill(Color.BLACK);
		car_dateLable.setTextFill(Color.BLACK);
		car_kLable.setTextFill(Color.RED);

		break;
	    case -12:
		preLabel.setTextFill(Color.BLACK);
		postLabel.setTextFill(Color.BLACK);
		bdLabel.setTextFill(Color.BLACK);
		ortLabel.setTextFill(Color.BLACK);
		plzLable.setTextFill(Color.RED);
		streetLabel.setTextFill(Color.BLACK);
		h_numLable.setTextFill(Color.BLACK);
		emailLable.setTextFill(Color.BLACK);
		tel_numLable.setTextFill(Color.BLACK);
		car_dateLable.setTextFill(Color.BLACK);
		car_kLable.setTextFill(Color.BLACK);

		break;
	    default:
		preLabel.setTextFill(Color.BLACK);
		postLabel.setTextFill(Color.BLACK);
		bdLabel.setTextFill(Color.BLACK);
		ortLabel.setTextFill(Color.BLACK);
		plzLable.setTextFill(Color.BLACK);
		streetLabel.setTextFill(Color.BLACK);
		h_numLable.setTextFill(Color.BLACK);
		emailLable.setTextFill(Color.BLACK);
		tel_numLable.setTextFill(Color.BLACK);
		car_dateLable.setTextFill(Color.BLACK);
		car_kLable.setTextFill(Color.BLACK);

		break;
	}
    }
    
}
