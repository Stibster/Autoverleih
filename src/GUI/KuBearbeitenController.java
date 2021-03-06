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
public class KuBearbeitenController implements Initializable {

    @FXML    private TextField k_id;
    @FXML    private Label k_id_Label;
    @FXML    private Button load;
    @FXML    private TextField vorname_text;
    @FXML    private Label preLabel;
    @FXML    private TextField name_text;
    @FXML    private Label postLabel;
    @FXML    private TextField birthday;
    @FXML    private Label bdLabel;
    @FXML    private TextField Ort;
    @FXML    private Label ortLabel;
    @FXML    private TextField plz;
    @FXML    private Label plzLable;
    @FXML    private TextField street;
    @FXML    private Label streetLabel;
    @FXML    private TextField h_num;
    @FXML    private Label h_numLable;
    @FXML    private TextField email;
    @FXML    private Label emailLable;
    @FXML    private TextField tel_num;
    @FXML    private Label tel_numLable;
    @FXML    private TextField car_date;
    @FXML    private Label car_dateLable;
    @FXML    private TextField car_k;
    @FXML    private Label car_kLable;
    @FXML    private Button k_pop_save;
   
    MetaController MC_Hammer = new MetaController();
    String pfad = "TestDatenbank.xml";
    int K_ID;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
	// TODO
    }    

    @FXML
    private void handleLoadButton(ActionEvent event) {
        
        int i = 0;
        K_ID = Integer.parseInt(k_id.getText());
        boolean indikator = false;

        MC_Hammer.DBV.restore(pfad);
        while (i < MC_Hammer.DBV.Kunden.size() && indikator == false) { //Suche bis zum Ende der Liste.
            if (MC_Hammer.DBV.Kunden.get(i).getKunden_ID() == K_ID ) {
                indikator = true; //Ende der Methode, wenn das Objekt gefunden wurde.
            } else {
                i++; //Andernfalls wird das nächste Element vergleichen.
            }
        }
	SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy", new DateFormatSymbols(Locale.GERMANY));
	vorname_text.setText(MC_Hammer.DBV.Kunden.get(i).getVorname());
	name_text.setText(MC_Hammer.DBV.Kunden.get(i).getNachname());
	birthday.setText(String.valueOf(format.format(MC_Hammer.DBV.Kunden.get(i).getGeburtstag())));
	Ort.setText(MC_Hammer.DBV.Kunden.get(i).getWohnort());
	plz.setText(MC_Hammer.DBV.Kunden.get(i).getPostleitzahl());
	street.setText(MC_Hammer.DBV.Kunden.get(i).getStrasse());
	h_num.setText(MC_Hammer.DBV.Kunden.get(i).getHausnummer());
	email.setText(MC_Hammer.DBV.Kunden.get(i).getE_Mail());
	tel_num.setText(MC_Hammer.DBV.Kunden.get(i).getTelefonnummer());
	car_date.setText(String.valueOf(format.format(MC_Hammer.DBV.Kunden.get(i).getFuehrerscheindatum())));
	car_k.setText(MC_Hammer.DBV.Kunden.get(i).getFuehrerscheinklasse());
    }

    @FXML
    private void handleK_POP_SAVE(ActionEvent event) throws ParseException {
	int fehler = 0;
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
        int KID;
	SimpleDateFormat format = new SimpleDateFormat("dd.mm.yyyy", new DateFormatSymbols(Locale.GERMANY));        
	
        KID = Integer.parseInt(k_id.getText());
	Vorname =vorname_text.getText();
	Name =  name_text.getText();
	Plz = plz.getText();
	ort = Ort.getText();
	H_num = h_num.getText();
	Str = street.getText();
	Email = email.getText();
	tel = tel_num.getText();
        Fklasse = car_k.getText();
        //Überprüfung ob Kunde zum bearbeiten vorhanden ist, erstellt von Daniel Meerwald #Raicandy
        int i = 0;
        boolean Indikator = false;
        
        while (i < MC_Hammer.DBV.Kunden.size() && Indikator == false) { 

            if (MC_Hammer.DBV.Kunden.get(i).getKunden_ID()== KID ) {
                Indikator = true; 
            } 
            else {
                i++; 
            }
        }
        
        boolean token = true;
        
        if(Indikator == false){
                k_id_Label.setTextFill(Color.RED);
                preLabel.setTextFill(Color.RED);
		postLabel.setTextFill(Color.RED);
		bdLabel.setTextFill(Color.RED);
		ortLabel.setTextFill(Color.RED);
		plzLable.setTextFill(Color.RED);
		streetLabel.setTextFill(Color.RED);
		h_numLable.setTextFill(Color.RED);
		emailLable.setTextFill(Color.RED);
		tel_numLable.setTextFill(Color.RED);
		car_dateLable.setTextFill(Color.RED);
		car_kLable.setTextFill(Color.RED);
		token = false;
                
        }
	
	    Geb = format.parse(birthday.getText());
	
	
	    //Fschein???? //grad keinen plan
	    Fdate = format.parse(car_date.getText());
	
	if(token){
	fehler = MC_Hammer.addKunde2(K_ID, Vorname, Name, Plz, ort, Str,
		H_num, Email, tel, Geb, Fschein, Fdate, Fklasse);

	switch (fehler) {
	    case 1:
		MC_Hammer.removeKunde(K_ID);
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
}
