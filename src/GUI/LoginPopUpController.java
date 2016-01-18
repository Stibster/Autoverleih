/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Denis
 */
public class LoginPopUpController implements Initializable {
        
    @FXML
    private Label label;
    @FXML
    private Button anmeldenBTN;
    @FXML
    private Button verlassenBTN;
    @FXML
    private TextField passText;
    @FXML
    private TextField nameText;
//    Stage popUp = (Stage) label.getScene().getWindow();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    //toDo  
    }

    @FXML
    private void handleAnmeldenBTN(ActionEvent event) {
	login();
    }

    @FXML
    private void handleVerlassenBTN(ActionEvent event) {
        Stage popUp = (Stage) label.getScene().getWindow();
        popUp.close();
    }
    
    private void login(){
	// Hashabfrage erstellt von Daniel Meerwald
        String Passhash = passText.getText();
        int Hash = Passhash.hashCode();
        int Adminhash = 3506402;
        int Mitarbeiterhash = 103149417;
        
	if (nameText.getText().equals("root") && Hash == Adminhash) { //pass = root
	    try {
		Stage popUp = (Stage) label.getScene().getWindow();
		Stage stage = (Stage) popUp.getOwner();

		Parent Page = FXMLLoader.load(getClass().getResource("AdminAnsicht.fxml"));

		stage.setScene(new Scene(Page));
		stage.show();
		popUp.close();
	    } catch (IOException ex) {
		Logger.getLogger(MitarbeiterAnsichtController.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
	if (nameText.getText().equals("Mitarbeiter") && Hash == Mitarbeiterhash) { // pass = login
	    try {
		Stage popUp = (Stage) label.getScene().getWindow();
		Stage stage = (Stage) popUp.getOwner();

		Parent Page = FXMLLoader.load(getClass().getResource("MitarbeiterAnsicht.fxml"));

		stage.setScene(new Scene(Page));
		stage.show();
		popUp.close();
	    } catch (IOException ex) {
		Logger.getLogger(MitarbeiterAnsichtController.class.getName()).log(Level.SEVERE, null, ex);
	    }
	} else {
	    label.setVisible(true);
	    passText.clear();
	}
    }
    
}
