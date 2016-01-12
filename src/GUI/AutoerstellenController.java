/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author hiki-tink
 */
public class AutoerstellenController implements Initializable {

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
    @FXML    private Button SaveButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
	// TODO
    }    

    @FXML
    private void handleSaveButton(ActionEvent event) {
    }
    
}
