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
 * @author Denis
 */
public class LoginPopUpController implements Initializable {
    
    @FXML    private Label label;
    @FXML    private Button anmeldenBTN;
    @FXML    private Button verlassenBTN;
    @FXML    private TextField passText;
    @FXML    private TextField nameText;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleAnmeldenBTN(ActionEvent event) {
        label.setVisible(true);
        passText.clear();
    }

    @FXML
    private void handleVerlassenBTN(ActionEvent event) {
        Stage stage = (Stage) label.getScene().getWindow();
        stage.close();
    }
    
}
