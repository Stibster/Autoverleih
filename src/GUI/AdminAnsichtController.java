/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import autoverleih.MetaController;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
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
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Denis
 */
public class AdminAnsichtController implements Initializable {

    @FXML    private Button saveBTN;
    @FXML    private MenuItem logIn;
    @FXML    private MenuItem logOut;
    @FXML    private ImageView fahrzeugFoto;
    @FXML    private TextField markeText;
    @FXML    private TextField modellText;
    @FXML    private TextField FarbeText;
    @FXML    private TextField leistungText;
    @FXML    private TextField sitzeText;
    @FXML    private TextField kostenText;
    @FXML    private TextField kennzeichenText;
    @FXML    private TextField idText;
    @FXML    private Button newCar;
    @FXML    private Button changeCar;
    @FXML
    private MenuItem carCreate;
    @FXML
    private Button rndCar;
    @FXML
    private Button rndKunde;
    
    MetaController MC_Hammer = new MetaController();
    String pfad = "Data/xml/TestDatenbank.xml";
    @FXML
    private MenuItem carDel;
    @FXML
    private MenuItem carChange;
    @FXML
    private Button clearBut;
    @FXML
    private Button dbcarsDelet;
    @FXML
    private Button dbKuDel;
    @FXML
    private Button dbVFALLDel;
    @FXML
    private TextField rndCarText;
    @FXML
    private TextField rndCusText;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void handleLogOut(ActionEvent event) {
        Stage stage = (Stage) saveBTN.getScene().getWindow();
        Parent Page;
        try {
            Page = FXMLLoader.load(getClass().getResource("KundenAnsicht.fxml"));

            Scene scene = new Scene(Page);

            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(MitarbeiterAnsichtController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void handleSaveExit(ActionEvent event) {
        System.exit(0);
        
        Stage stage = (Stage) saveBTN.getScene().getWindow();
        Parent Page;
        try {
            Page = FXMLLoader.load(getClass().getResource("MitarbeiterAnsicht.fxml"));

            Scene scene = new Scene(Page);

            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(MitarbeiterAnsichtController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handleCarCreateMenue(ActionEvent event) {
	Stage popUp = new Stage();
	popUp.setTitle("Auto Erstellen");
	Parent Page;
	try {
	    Page = FXMLLoader.load(getClass().getResource("Autoerstellen.fxml"));

	    popUp.setScene(new Scene(Page));
	    popUp.initModality(Modality.APPLICATION_MODAL);
	    popUp.initOwner(saveBTN.getScene().getWindow());
	    popUp.showAndWait();
	} catch (IOException ex) {
	    Logger.getLogger(AdminAnsichtController.class.getName()).log(Level.SEVERE, null, ex);
	}	
    }
    
    @FXML
    private void handleRndCar(ActionEvent event) throws ParseException {
	MC_Hammer.DBV.restore(pfad);
	MC_Hammer.DBV.randomAutos(Integer.parseInt(rndCarText.getText()));
	MC_Hammer.DBV.save(pfad);
    }

    @FXML
    private void handleRndKunde(ActionEvent event) throws ParseException {
	MC_Hammer.DBV.restore(pfad);
	MC_Hammer.DBV.randomKunden(Integer.parseInt(rndCusText.getText()));
	MC_Hammer.DBV.save(pfad);
    }

    @FXML
    private void handleCarDelMenue(ActionEvent event) {
	Stage popUp = new Stage();
        popUp.setTitle("Auto Löschen");
        Parent Page;
        try {
            Page = FXMLLoader.load(getClass().getResource("AutoDel.fxml"));

            popUp.setScene(new Scene(Page));
            popUp.initModality(Modality.APPLICATION_MODAL);
            popUp.initOwner(saveBTN.getScene().getWindow());
            popUp.showAndWait();
        } catch (IOException ex) {
            Logger.getLogger(AdminAnsichtController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handleCarChangeMenue(ActionEvent event) {
	Stage popUp = new Stage();
        popUp.setTitle("Auto Löschen");
        Parent Page;
        try {
            Page = FXMLLoader.load(getClass().getResource("AutoBearbeiten.fxml"));

            popUp.setScene(new Scene(Page));
            popUp.initModality(Modality.APPLICATION_MODAL);
            popUp.initOwner(saveBTN.getScene().getWindow());
            popUp.showAndWait();
        } catch (IOException ex) {
            Logger.getLogger(AdminAnsichtController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handleClearButton(ActionEvent event) {
	
        MC_Hammer.DBV.clearAll();
        MC_Hammer.DBV.save(pfad);
	
    }

    @FXML
    private void handleDbCarsDelButton(ActionEvent event) {
        
        MC_Hammer.DBV.clearAutos();
        MC_Hammer.DBV.save(pfad);
    }

    @FXML
    private void handleDbKuDelButton(ActionEvent event) {
        
        MC_Hammer.DBV.clearKunden();
        MC_Hammer.DBV.save(pfad);
    }

    @FXML
    private void handleDbVFALLDelButton(ActionEvent event) {
        
        MC_Hammer.DBV.clearAusleihen();
        MC_Hammer.DBV.save(pfad);
    }
    
}
