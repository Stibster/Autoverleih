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
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author hiki-tink
 */
public class Vfall_popupController implements Initializable {

    @FXML    private TextField kundeID;
    @FXML    private TextField autoID;
    @FXML    private TextField vonDate;
    @FXML    private TextField bisDate;
    @FXML    private Button vsave_button;

    MetaController MC_Hammer = new MetaController();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
	// TODO
    }    

    @FXML
    private void handleVsave(ActionEvent event) 
    {
    }
    
}
