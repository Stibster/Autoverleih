/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoverleih;

import java.net.URL;
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
    
    DB_Verwalter DBV = new DB_Verwalter();
    String pfad = "C:\\TestDatenbank.xml";

    @FXML    private TextField id_text;
    @FXML    private TextField name_text;
    @FXML    private TextField vorname_text;
    @FXML    private Button k_pop_save;
    @FXML    private Label idLabel;
    @FXML    private Label preLabel;
    @FXML    private Label postLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
	
    }    

    @FXML
    private void handleK_POP_SAVE(ActionEvent event) {
	DBV.restore(pfad);
	Kunde kunde = new Kunde();
	kunde.setKunden_ID(Integer.parseInt(id_text.getText()));
	
	kunde.setNachname(name_text.getText());
	
	kunde.setVorname(vorname_text.getText());
	DBV.addKunde(kunde);
	DBV.save(pfad);
	
/*	if(mcmethode == 0){
		DBV.addKunde(kunde);
		DBV.save(pfad);	
		Stage popUp = (Stage) id_text.getScene().getWindow();
	        popUp.close();	
	}if(returnwert == -1){
	    idLabel soll rot werden.
	}
	
*/	
	Stage popUp = (Stage) id_text.getScene().getWindow();
        popUp.close();
    }
    
}
