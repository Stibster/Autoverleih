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
public class AutoAbgebenController implements Initializable {

    @FXML    private TextField ausleihID;
    @FXML    private Label warningVer;
    @FXML    private Button giveCar;

    MetaController MC_Hammer = new MetaController();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
	// TODO
    }    

    @FXML
    private void handeleGiveCar(ActionEvent event) 
    {
	int fehler = 0; //fuehr fehler fall
	int leih_id = -1;  //auto id
	
	
	    	    leih_id = Integer.parseInt(ausleihID.getText());
		    fehler = MC_Hammer.Auto_abholen(leih_id);
		    
	    switch (fehler) 
	    {
		case 1:
		    Stage popUp = (Stage) warningVer.getScene().getWindow();
		    popUp.close();
		    break;
		case -1:
		    warningVer.setText("Kein Verleih vorhanden");
		    warningVer.setVisible(true);
	            
		    break;
                case -2:
		    warningVer.setText("Auto nicht im Haus");
		    warningVer.setVisible(true);
                    break;
		/*    
                case -4:  //fall der mit -1 shcon geklart ist
		    warningVer.setText("Kein Verleih vorhanden");
		    warningVer.setVisible(true);
	            
		    break;
		 */

		default:
		    warningVer.setVisible(false);
		    
		    break;
	    }
	
    }

    
}
