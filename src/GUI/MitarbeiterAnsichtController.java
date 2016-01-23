package GUI;

import autoverleih.Auto;
import autoverleih.Kunde;
import autoverleih.MetaController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Denis
 */
public class MitarbeiterAnsichtController implements Initializable {


    @FXML    private Button saveBTN;
    @FXML    private TextArea CusText;
    @FXML    private TextArea CarText;
    @FXML    private TableView carTabel;
    @FXML    private TableView custTabel;
    @FXML    private Label tablewarning;
    @FXML    private TableColumn<Auto, Integer> ctid;
    @FXML    private TableColumn<Auto, String> cther;
    @FXML    private TableColumn<Auto, String> ctmod;
    @FXML    private TableColumn<Auto, String> ctda;
    @FXML    private TableColumn<Kunde, Integer> cutid;
    @FXML    private TableColumn<Kunde, String> cutpre;
    @FXML    private TableColumn<Kunde, String> cutpost;
    @FXML    private TableColumn<Kunde, String> cutort;
    @FXML    private TableColumn<Kunde, String> cutclass;
    @FXML    private TextField txtvon;
    @FXML    private TextField txtbis;    
    
    ObservableList<Auto> cars;
    ObservableList<Kunde> custs;
    private final String path = "TestDatenbank.xml";
    private String ausgabe = "";
    private final MetaController MC = new MetaController();


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tablewarning.setVisible(false);
        
        ctid.setCellValueFactory(new PropertyValueFactory<>("Auto_ID"));
        cther.setCellValueFactory(new PropertyValueFactory<>("Hersteller"));
        ctmod.setCellValueFactory(new PropertyValueFactory<>("Modell"));
        ctda.setCellValueFactory(new PropertyValueFactory<>("da"));
        
        cutid.setCellValueFactory(new PropertyValueFactory<>("Kunden_ID"));
        cutpre.setCellValueFactory(new PropertyValueFactory<>("Vorname"));
        cutpost.setCellValueFactory(new PropertyValueFactory<>("Nachname"));
        cutort.setCellValueFactory(new PropertyValueFactory<>("Wohnort"));
        cutclass.setCellValueFactory(new PropertyValueFactory<>("Fuehrerscheinklasse"));
        
        custTabel.setItems(custMake());
        carTabel.setItems(carsMake());
        refresh();
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
        refresh();
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
        refresh();
    }
    
    /**********erstellt: Denis Bursillon********************************************/
    @FXML
    private void handleAusleiheMenue(){
        tablewarning.setVisible(false);
        int indexauto = carTabel.getSelectionModel().getSelectedIndex(); //Denis Boursillon
        int indexkunde = custTabel.getSelectionModel().getSelectedIndex(); //Denis Boursillon
        
        if (indexauto >= 0 && indexkunde >= 0) { 
            System.out.println(indexauto + "," + indexkunde);            
        } else {
            tablewarning.setVisible(true);
        }
//        Stage popUp = new Stage();
//        popUp.setTitle("Vermietung Erstellen");
//        Parent Page;
//        try {
//            Page = FXMLLoader.load(getClass().getResource("Vfall_popup.fxml"));
//
//            popUp.setScene(new Scene(Page));
//            popUp.initModality(Modality.APPLICATION_MODAL);
//            popUp.initOwner(saveBTN.getScene().getWindow());
//            popUp.showAndWait();
//        } catch (IOException ex) {
//            Logger.getLogger(AdminAnsichtController.class.getName()).log(Level.SEVERE, null, ex);
//        }
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

    @FXML
    private void handleCloseMenue(ActionEvent event) {
	System.exit(0);
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
        refresh();
    }

//    @FXML
//    private void handleShowAllBTN(ActionEvent event) {
//         Stage popUp = new Stage();
//        popUp.setTitle("Verleihen anzeigen");
//        Parent Page;
//        try {
//            Page = FXMLLoader.load(getClass().getResource("VfallShow.fxml"));
//
//            popUp.setScene(new Scene(Page));
//            popUp.initModality(Modality.APPLICATION_MODAL);
//            popUp.initOwner(saveBTN.getScene().getWindow());
//            popUp.showAndWait();
//        } catch (IOException ex) {
//            Logger.getLogger(AdminAnsichtController.class.getName()).log(Level.SEVERE, null, ex);
//	}
//    }
    
    /**********erstellt: Denis Bursillon********************************************/
    private void showAllCars(){
        int i = 0;
        MC.DBV.restore(path);
        ausgabe = "Anzahl gespeicherter Autos derzeit: " + MC.DBV.Autos.size()+"\n\n";
        while (i < MC.DBV.Autos.size()) {
            ausgabe += "ID: "+MC.DBV.Autos.get(i).getAuto_ID();
             ausgabe += "   Hersteller: "+ MC.DBV.Autos.get(i).getHersteller();
              ausgabe += "    Modell:"+MC.DBV.Autos.get(i).getModell();
              if(MC.DBV.Autos.get(i).getIst_Da()==true) ausgabe += "    IM HAUS";
              else ausgabe += "    AUSERHAUS";
               ausgabe += "\n";
            i++;
        }
        CarText.setText(ausgabe);
    }
    
    /**********erstellt: Denis Bursillon********************************************/
    /**********fertiggestellt:  Haack   ********************************************/
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
    
    private void refresh() {
//        CusText.clear();
//        showAllCust();
//        CarText.clear();
//        showAllCars();
        carsMake();
        custMake();
        tablewarning.setVisible(false);

    }

/*######################### Denis Boursillon #################################*/
    public ObservableList<Auto> carsMake(){
        cars = FXCollections.observableArrayList();
        cars.clear();
        MC.DBV.restore(path);
        int i = 0;
        while(i < MC.DBV.Autos.size()){
            cars.add(new Auto(
                    MC.DBV.Autos.get(i).getAuto_ID(),
                    MC.DBV.Autos.get(i).getHersteller(),
                    MC.DBV.Autos.get(i).getModell(),
                    MC.DBV.Autos.get(i).getIst_Da()
//                    if(MC.DBV.Autos.get(i).getIst_Da() == true) "Im Haus"
//                    else "Außer Haus"
                )
            );
            i++;
        }
        return cars;
    }
 
/*######################### Denis Boursillon #################################*/    
    public ObservableList<Kunde> custMake(){
        custs = FXCollections.observableArrayList();
        custs.clear();
        MC.DBV.restore(path);
        int i = 0;
        while(i < MC.DBV.Kunden.size()){
            custs.add(new Kunde(
                    MC.DBV.Kunden.get(i).getKunden_ID(),
                    MC.DBV.Kunden.get(i).getVorname(),
                    MC.DBV.Kunden.get(i).getNachname(),
                    MC.DBV.Kunden.get(i).getWohnort(),
                    MC.DBV.Kunden.get(i).getFuehrerscheinklasse()
                )
            );
            i++;
        }
        return custs;
    }
}
