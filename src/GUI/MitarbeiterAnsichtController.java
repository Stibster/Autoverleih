package GUI;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Denis
 */
public class MitarbeiterAnsichtController implements Initializable {


    @FXML    private Button saveBTN;
    @FXML    private Button beispielBTN;
    @FXML    private MenuItem logOut;
    @FXML    private TextField customerSearchText;
    @FXML    private Button SearchWorkerBTN;
    @FXML    private TextField carSearchText;
    @FXML    private TextArea console;
    @FXML    private TextField consoleText;
    @FXML
    private Button showAllBTN;
    @FXML
    private MenuItem addUserMenue;
    @FXML
    private MenuItem DelUser;
    @FXML
    private MenuItem Ausleihe;
    @FXML
    private MenuItem carRaus;
    @FXML
    private MenuItem carRein;
    @FXML
    private MenuItem logIn;
    @FXML
    private MenuItem changeUser;
    @FXML
    private TextArea CusText;
    @FXML
    private TextArea CarText;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void handleSaveExit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void handleBeispiel(ActionEvent event) {
    }

    @FXML
    private void handleLogin() {
        Stage popUp = new Stage();
        popUp.setTitle("Login");
        Parent Page;
        try {
            Page = FXMLLoader.load(getClass().getResource("LoginPopUp.fxml"));

            popUp.setScene(new Scene(Page));
            popUp.initModality(Modality.APPLICATION_MODAL);
            popUp.initOwner(saveBTN.getScene().getWindow());
            popUp.showAndWait();
        } catch (IOException ex) {
            Logger.getLogger(AdminAnsichtController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    private void handleSearch(ActionEvent event) {
    }
    
    @FXML 
    private void handleAddUserMenue() throws InterruptedException{
	Stage popUp = new Stage();
	popUp.setTitle("Kunde Erstellen");
	Parent Page;
	try {
	    Page = FXMLLoader.load(getClass().getResource("KErstellen.fxml"));

	    popUp.setScene(new Scene(Page));
	    popUp.initModality(Modality.APPLICATION_MODAL);
	    popUp.initOwner(saveBTN.getScene().getWindow());
	    popUp.showAndWait();
	} catch (IOException ex) {
	    Logger.getLogger(AdminAnsichtController.class.getName()).log(Level.SEVERE, null, ex);
	}	
    }
    
    @FXML
    private void handleDelUserMenue(){
        Stage popUp = new Stage();
        popUp.setTitle("Kunde Löschen");
        Parent Page;
        try {
            Page = FXMLLoader.load(getClass().getResource("KundeDel.fxml"));

            popUp.setScene(new Scene(Page));
            popUp.initModality(Modality.APPLICATION_MODAL);
            popUp.initOwner(saveBTN.getScene().getWindow());
            popUp.showAndWait();
        } catch (IOException ex) {
            Logger.getLogger(AdminAnsichtController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void handleAusleiheMenue(){
        Stage popUp = new Stage();
        popUp.setTitle("Vermietung Erstellen");
        Parent Page;
        try {
            Page = FXMLLoader.load(getClass().getResource("Vfall_popup.fxml"));

            popUp.setScene(new Scene(Page));
            popUp.initModality(Modality.APPLICATION_MODAL);
            popUp.initOwner(saveBTN.getScene().getWindow());
            popUp.showAndWait();
        } catch (IOException ex) {
            Logger.getLogger(AdminAnsichtController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @FXML
     private void handleCarRausMenue(){
        Stage popUp = new Stage();
        popUp.setTitle("Auto verleihen");
        Parent Page;
        try {
            Page = FXMLLoader.load(getClass().getResource("AutoAbgeben.fxml"));

            popUp.setScene(new Scene(Page));
            popUp.initModality(Modality.APPLICATION_MODAL);
            popUp.initOwner(saveBTN.getScene().getWindow());
            popUp.showAndWait();
        } catch (IOException ex) {
            Logger.getLogger(AdminAnsichtController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @FXML
     private void handleCarReinMenue(){
        Stage popUp = new Stage();
        popUp.setTitle("Auto zurück");
        Parent Page;
        try {
            Page = FXMLLoader.load(getClass().getResource("AutoRein.fxml"));

            popUp.setScene(new Scene(Page));
            popUp.initModality(Modality.APPLICATION_MODAL);
            popUp.initOwner(saveBTN.getScene().getWindow());
            popUp.showAndWait();
        } catch (IOException ex) {
            Logger.getLogger(AdminAnsichtController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handleChangeUserMenue(ActionEvent event) {
	Stage popUp = new Stage();
        popUp.setTitle("Kunde Bearbeiten");
        Parent Page;
        try {
            Page = FXMLLoader.load(getClass().getResource("KuBearbeiten.fxml"));

            popUp.setScene(new Scene(Page));
            popUp.initModality(Modality.APPLICATION_MODAL);
            popUp.initOwner(saveBTN.getScene().getWindow());
            popUp.showAndWait();
        } catch (IOException ex) {
            Logger.getLogger(AdminAnsichtController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
