/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import autoverleih.MetaController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
	// TODO
    }    

    @FXML
    private void handleSaveButton(ActionEvent event) {
    }

    @FXML
    private void handleLoadButton(ActionEvent event) {
	/* kann auf dbv net zugreifen!!!!
        int i = 0;
        boolean indikator = false;

        while (i < MC_Hammer.DBV.Users.size() && indikator == false) { //Suche bis zum Ende der Liste.

            if (Users.get(i).getUser_ID() == U_ID ) {
                indikator = true; //Ende der Methode, wenn das Objekt gefunden wurde.
            } else {
                i++; //Andernfalls wird das nächste Element vergleichen.
            }
        }
	*/
    }
    
}
