package GUI;

import autoverleih.MetaController;
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
    @FXML    private Button showAllBTN;
    @FXML    private MenuItem addUserMenue;
    @FXML    private MenuItem DelUser;
    @FXML    private MenuItem Ausleihe;
    @FXML    private MenuItem carRaus;
    @FXML    private MenuItem carRein;
    @FXML    private MenuItem logIn;
    @FXML    private MenuItem changeUser;
    @FXML    private TextArea CusText;
    @FXML    private TextArea CarText;
    private final String path = "/TestDatenbank.xml";
    private String ausgabe = "";
    private MetaController MC = new MetaController();
    @FXML
    private MenuItem vfalShow;
    @FXML
    private MenuItem about;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showAllCars();
        showAllCust();
    }

    @FXML
    private void handleSaveExit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void handleBeispiel(ActionEvent event) {
    }

    /**********erstellt: Denis Bursillon********************************************/
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
    
    /**********erstellt: Denis Bursillon********************************************/
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
    
    /**********erstellt: Denis Bursillon********************************************/
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
    
    /**********erstellt: Denis Bursillon********************************************/
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
    
    /**********erstellt: Denis Bursillon********************************************/
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
    
    /**********erstellt: Denis Bursillon********************************************/
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
    
    /**********erstellt: Denis Bursillon********************************************/
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

     /**********erstellt: Denis Bursillon********************************************/
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

    @FXML
    private void handleShowAllBTN(ActionEvent event) {
         Stage popUp = new Stage();
        popUp.setTitle("Verleihen anzeigen");
        Parent Page;
        try {
            Page = FXMLLoader.load(getClass().getResource("VfallShow.fxml"));

            popUp.setScene(new Scene(Page));
            popUp.initModality(Modality.APPLICATION_MODAL);
            popUp.initOwner(saveBTN.getScene().getWindow());
            popUp.showAndWait();
        } catch (IOException ex) {
            Logger.getLogger(AdminAnsichtController.class.getName()).log(Level.SEVERE, null, ex);
	}
    }
    
    /**********erstellt: Denis Bursillon********************************************/
    private void showAllCars(){
        int i = 0;
        MC.DBV.restore(path);
        ausgabe = "Anzahl gespeicherter Autos derzeit: " + MC.DBV.Autos.size()+"\n\n";
        while (i < MC.DBV.Autos.size()) {
            ausgabe += "ID: "+MC.DBV.Autos.get(i).getAuto_ID();
             ausgabe += "   Hersteller: "+ MC.DBV.Autos.get(i).getHersteller();
              ausgabe += "    Modell:"+MC.DBV.Autos.get(i).getModell();
               ausgabe += "\n";
            i++;
        }
        CarText.setText(ausgabe);
    }
    
    /**********erstellt: Denis Bursillon********************************************/
    /**********fertiggestellt:          ********************************************/
    private void showAllCust(){
        int i = 0;
        MC.DBV.restore(path);
        ausgabe = "Anzahl gespeicherter Kunden derzeit: " + MC.DBV.Kunden.size()+"\n\n";
        while (i < MC.DBV.Kunden.size()) {
           ausgabe +="ID: "+ MC.DBV.Kunden.get(i).getKunden_ID();
            ausgabe +="    Vorname: "+ MC.DBV.Kunden.get(i).getVorname();
	     ausgabe +="    Nachname: "+ MC.DBV.Kunden.get(i).getNachname();
	      ausgabe +="   Wohnort: "+ MC.DBV.Kunden.get(i).getWohnort();
	       ausgabe += "    FS-Klasse: "+MC.DBV.Kunden.get(i).getFuehrerscheinklasse();
            ausgabe += "\n";
            i++;
        }
        CusText.setText(ausgabe);
        
    }

    
    //Haack Christopher ######################
    @FXML
    private void handleAusleiheShowMenue(ActionEvent event) {
	 Stage popUp = new Stage();
        popUp.setTitle("Verleihen anzeigen");
        Parent Page;
        try {
            Page = FXMLLoader.load(getClass().getResource("VfallShow.fxml"));

            popUp.setScene(new Scene(Page));
            popUp.initModality(Modality.APPLICATION_MODAL);
            popUp.initOwner(saveBTN.getScene().getWindow());
            popUp.showAndWait();
        } catch (IOException ex) {
            Logger.getLogger(AdminAnsichtController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handleaboutmenue(ActionEvent event) {
	Stage popUp = new Stage();
        popUp.setTitle("About");
        Parent Page;
        try {
            Page = FXMLLoader.load(getClass().getResource("hilfepopup.fxml"));
            
            popUp.setScene(new Scene(Page));
            popUp.initModality(Modality.APPLICATION_MODAL);
            popUp.initOwner(saveBTN.getScene().getWindow());
            popUp.showAndWait();
        } catch (IOException ex) {
            Logger.getLogger(AdminAnsichtController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
