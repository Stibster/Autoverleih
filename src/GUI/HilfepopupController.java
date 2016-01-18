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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hiki-tink
 */
public class HilfepopupController implements Initializable {

    @FXML    private Button okBTN;
    @FXML    private Label nameLabel;
    @FXML    private ImageView imgView;
    @FXML    private TextField textfiel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        imgView.setImage(new Image ("Data/HSMW_Logo.png"));
        
        nameLabel.setText("Autoverleih: Finale Version, 2. Sprint \n\n "+
                    "Projektteam: \n"+
                        "   Projektleiter: Daniel Meerwald \n"+
                        "   Softwarearchitekt: Christopher Haack \n"+
                        "   Chefprogrammierer: Denis Brousillon \n"+
                        "   Dokumentenbeauftragter: Steve Vogel \n"+
                        "   Testmanager: Adrian Neubert \n"+
                        "   Tester: Danilo May \n"+
                        "   Projektmanagerin: Ribanna Meister \n");
        
	
    }    

    @FXML
    private void handleOkBTN(ActionEvent event) {
	Stage popUp = (Stage) nameLabel.getScene().getWindow();
	popUp.close();
    }
    
}
