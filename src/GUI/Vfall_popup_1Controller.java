/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import autoverleih.MetaController;
import java.net.URL;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.util.Date;
import java.util.Locale;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Haack Christopher
 */
public class Vfall_popup_1Controller implements Initializable {

    @FXML    private TextField kundeID;
    @FXML    private TextField autoID;
    @FXML    private TextField vonDate;
    @FXML    private TextField bisDate;
    @FXML    private Button vsave_button;
    @FXML    private Label eror_k_id;
    @FXML    private Label eror_a_id;
    @FXML    private Label eror_date;
    
    Date start;
    Date back;
    int A_id = -1;  //auto id
    int K_id = -1;	//kunden id
    
    MetaController MC_Hammer = new MetaController();
    MitarbeiterAnsichtController MAC = new MitarbeiterAnsichtController();
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
	A_id =MAC.getCarTable();
	autoID.setText(
		    String.valueOf(
			A_id
		    )
		    //MAC.cars.get(MAC.carTabel.getSelectionModel().getSelectedIndex()).getAuto_ID()
		);
	
	kundeID.setText(
		    String.valueOf(
			MAC.getCustTabel()
		    )
		    //MAC.custs.get(MAC.custTabel.getSelectionModel().getSelectedIndex()).getKunden_ID()
		);
	//MitarbeiterAnsichtController.carTabel.getSelectionModel().getSelectedIndex();
	//MitarbeiterAnsichtController.custTabel.getSelectionModel().getSelectedIndex();
	
    }    

    @FXML
    private void handleVsave(ActionEvent event) throws ParseException 
    {
	int fehler = 0; //fuehr fehler fall
	start = null; //start datum 
	back = null;   //ruegabe datum
        SimpleDateFormat format = new SimpleDateFormat("dd.mm.yyyy", new DateFormatSymbols(Locale.GERMANY)); //#Raicandy
        

	    	    A_id = Integer.parseInt(autoID.getText());
		    K_id = Integer.parseInt(kundeID.getText());
		    start = format.parse(vonDate.getText());
		    back = format.parse(bisDate.getText());
		    fehler = MC_Hammer.addAusleihe(A_id, K_id, start, back);
		    
	    switch (fehler) 
	    {
		case 1:
		    Stage popUp = (Stage) eror_k_id.getScene().getWindow();
		    popUp.close();
		    break;
		case -1:
		    
		    eror_a_id.setVisible(true);
	            eror_k_id.setVisible(false);
		    eror_date.setVisible(false);
		    /*
		    A_id = Integer.parseInt(autoID.getText());
		    K_id = Integer.parseInt(kundeID.getText());
		    start = format.parse(vonDate.getText());
		    back = format.parse(bisDate.getText());
		    fehler = MC_Hammer.addAusleihe(A_id, K_id, start, back);
		    */
		    break;
		case -2:
	
		    eror_a_id.setVisible(false);
	            eror_k_id.setVisible(true);
		    eror_date.setVisible(false);
		    /*
		    A_id = Integer.parseInt(autoID.getText());
		    K_id = Integer.parseInt(kundeID.getText());
		    start = format.parse(vonDate.getText());
		    back = format.parse(bisDate.getText());
		    fehler = MC_Hammer.addAusleihe(A_id, K_id, start, back);
		    */
		    break;
		case -3:
		    eror_a_id.setVisible(false);
	            eror_k_id.setVisible(false);
		    eror_date.setVisible(true);
		    /*
		    A_id = Integer.parseInt(autoID.getText());
		    K_id = Integer.parseInt(kundeID.getText());
		    start = format.parse(vonDate.getText());
		    back = format.parse(bisDate.getText());
		    fehler = MC_Hammer.addAusleihe(A_id, K_id, start, back);
		    */
		    break;
		default:
		    eror_a_id.setVisible(false);
	            eror_k_id.setVisible(false);
		    eror_date.setVisible(false);
		    
		   /*
		    A_id = Integer.parseInt(autoID.getText());
		    K_id = Integer.parseInt(kundeID.getText());
		    start = format.parse(vonDate.getText());
		    back = format.parse(bisDate.getText());
		    fehler = MC_Hammer.addAusleihe(A_id, K_id, start, back);
		    */
		    break;
	    }


    }
    
}
