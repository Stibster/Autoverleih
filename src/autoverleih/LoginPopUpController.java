/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoverleih;

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

        if (nameText.getText().equals("root") && passText.getText().equals("root")) {
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
        if (nameText.getText().equals("a") && passText.getText().equals("a")) {
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

    @FXML
    private void handleVerlassenBTN(ActionEvent event) {
        Stage popUp = (Stage) label.getScene().getWindow();
        popUp.close();
    }
    
}
