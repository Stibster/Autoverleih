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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hiki-tink
 */
public class KundeDelController implements Initializable {

    @FXML
    private TextField k_ID;
    @FXML
    private Label kunden_ID;
    @FXML
    private Label id_warning;
    @FXML
    private Button del;

     MetaController MC_Hammer = new MetaController();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
	// TODO
    }    

    @FXML
    private void handleDel(ActionEvent event) {
	int K_id;
	int fehler = 0;
	 K_id = Integer.parseInt(k_ID.getText());
	 
	 fehler = MC_Hammer.removeKunde(K_id);
	 switch (fehler) 
	    {
		case 1:
		    Stage popUp = (Stage) kunden_ID.getScene().getWindow();
		    popUp.close();
		    break;
		case -1:
		    
		    id_warning.setVisible(true);
	            
		    break;

		default:
		    id_warning.setVisible(false);
		    
		    break;
	    }
    }
    
}
