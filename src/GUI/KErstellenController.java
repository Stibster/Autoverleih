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
import java.util.Date;
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
public class KErstellenController implements Initializable {

    MetaController MC_Hammer = new MetaController();

    @FXML
    private TextField name_text;
    @FXML
    private TextField vorname_text;
    @FXML
    private Button k_pop_save;
    @FXML
    private Label preLabel;
    @FXML
    private Label postLabel;
    @FXML
    private TextField birthday;
    @FXML
    private TextField Ort;
    @FXML
    private TextField street;
    @FXML
    private TextField h_num;
    @FXML
    private TextField email;
    @FXML
    private TextField tel_num;
    @FXML
    private TextField car_date;
    @FXML
    private TextField car_k;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    //von Danilo May
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
    @FXML
    private void handleK_POP_SAVE(ActionEvent event) {
	int fehler = 0; //fuehr fehler fall
	String Vorname = null;
	String Name = null;
	int Plz = -1;
	String Ort = null;
	String Str = null;
	String H_num = null;
	String email = null;
	int tel = -1;
	Date Geb = null;
	File Fschein = null;
	Date Fdate = null;
	String Fklasse = null;

	fehler = MC_Hammer.addKunde(Vorname, Name, Plz, Ort, Str,
		H_num, email, tel, Geb, Fschein, Fdate, Fklasse);

	switch (fehler) {
	    case 1:
		
		popUp.close();
		break;
	    case -1:

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
	    case -10:

		break;
	    case -11:

		break;
	    default:

		break;
	}
    }
    
}
