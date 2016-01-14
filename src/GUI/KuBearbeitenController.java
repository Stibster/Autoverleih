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

/**
 * FXML Controller class
 *
 * @author hiki-tink
 */
public class KuBearbeitenController implements Initializable {

    @FXML    private TextField k_id;
    @FXML    private Label k_id_Label;
    @FXML    private Button load;
    @FXML    private TextField vorname_text;
    @FXML    private Label preLabel;
    @FXML    private TextField name_text;
    @FXML    private Label postLabel;
    @FXML    private TextField birthday;
    @FXML    private Label bdLabel;
    @FXML    private TextField Ort;
    @FXML    private Label ortLabel;
    @FXML    private TextField plz;
    @FXML    private Label plzLable;
    @FXML    private TextField street;
    @FXML    private Label streetLabel;
    @FXML    private TextField h_num;
    @FXML    private Label h_numLable;
    @FXML    private TextField email;
    @FXML    private Label emailLable;
    @FXML    private TextField tel_num;
    @FXML    private Label tel_numLable;
    @FXML    private TextField car_date;
    @FXML    private Label car_dateLable;
    @FXML    private TextField car_k;
    @FXML    private Label car_kLable;
    @FXML    private Button k_pop_save;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
	// TODO
    }    

    @FXML
    private void handleLoadButton(ActionEvent event) {
    }

    @FXML
    private void handleK_POP_SAVE(ActionEvent event) {
    }
    
}
