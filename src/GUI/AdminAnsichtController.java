/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import autoverleih.MetaController;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.TilePane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Denis
 */
public class AdminAnsichtController implements Initializable  {

    @FXML    private Button saveBTN;
    @FXML    private MenuItem logIn;
    @FXML    private MenuItem logOut;
    @FXML    private TextField markeText;
    @FXML    private TextField modellText;
    @FXML    private TextField FarbeText;
    @FXML    private TextField leistungText;
    @FXML    private TextField sitzeText;
    @FXML    private TextField kostenText;
    @FXML    private TextField kennzeichenText;
    @FXML    private TextField idText;
    @FXML    private MenuItem carCreate;
    @FXML    private Button rndCar;
    @FXML    private Button rndKunde;
    @FXML    private MenuItem carDel;
    @FXML    private MenuItem carChange;
    @FXML    private Button clearBut;
    @FXML    private Button dbcarsDelet;
    @FXML    private Button dbKuDel;
    @FXML    private Button dbVFALLDel;
    @FXML    private TextField rndCarText;
    @FXML    private TextField rndCusText;
    @FXML    private TilePane tile;
    @FXML    private Button scriptRndcar;
    @FXML    private Button testBtn;   
    @FXML    private ImageView showView;     
    
     
    MetaController MC_Hammer = new MetaController();
    String pfad = "/TestDatenbank.xml";
    @FXML
    private MenuItem about;


    /**
     * Initializes the controller class.
     */
    
    /**********erstellt: Denis Bursillon********************************************/
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            fillTile();
        } catch (MalformedURLException ex) {
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
    private void handleSaveExit(ActionEvent event) {
        System.exit(0);
    }

    /**********erstellt: Denis Bursillon********************************************/
    @FXML
    private void handleCarCreateMenue(ActionEvent event) throws MalformedURLException {
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
        refreshTile();
    }
    
    @FXML
    private void handleRndCar(ActionEvent event) throws ParseException, MalformedURLException {
	MC_Hammer.DBV.restore(pfad);
	MC_Hammer.DBV.randomAutos(Integer.parseInt(rndCarText.getText()));
	MC_Hammer.DBV.save(pfad);
        bestätigung();
        refreshTile();
    }

    @FXML
    private void handleRndKunde(ActionEvent event) throws ParseException, MalformedURLException {
	MC_Hammer.DBV.restore(pfad);
	MC_Hammer.DBV.randomKunden(Integer.parseInt(rndCusText.getText()));
	MC_Hammer.DBV.save(pfad);
        bestätigung();
        refreshTile();
    }

    @FXML
    private void handleCarDelMenue(ActionEvent event) throws MalformedURLException {
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
        refreshTile();
    }

    @FXML
    private void handleCarChangeMenue(ActionEvent event) throws MalformedURLException {
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
        refreshTile();
    }

    @FXML
    private void handleClearButton(ActionEvent event) throws MalformedURLException {
	
        MC_Hammer.DBV.clearAll();
        MC_Hammer.DBV.save(pfad);
        bestätigung();
        refreshTile();
    }

    @FXML
    private void handleDbCarsDelButton(ActionEvent event) throws MalformedURLException {
        
        MC_Hammer.DBV.clearAutos();
        MC_Hammer.DBV.save(pfad);
        bestätigung();
        refreshTile();
    }

    @FXML
    private void handleDbKuDelButton(ActionEvent event) {
        
        MC_Hammer.DBV.clearKunden();
        MC_Hammer.DBV.save(pfad);
        bestätigung();
    }

    @FXML
    private void handleDbVFALLDelButton(ActionEvent event) {
        
        MC_Hammer.DBV.clearAusleihen();
        MC_Hammer.DBV.save(pfad);
        bestätigung();
    }

    @FXML
    private void handleScriptRndCarButton(ActionEvent event) throws ParseException, MalformedURLException {
        MC_Hammer.DBV.restore(pfad);
	MC_Hammer.DBV.randomRealAutos(Integer.parseInt(rndCarText.getText()));
	MC_Hammer.DBV.save(pfad);
        bestätigung();
        refreshTile();
    }
    
    @FXML
    private void handleTestBtn(ActionEvent event) throws MalformedURLException {
        refreshTile();
    }

    /**********erstellt: Denis Bursillon********************************************/
    private void refreshTile() throws MalformedURLException {
        tile.getChildren().clear();  
        fillTile();
    }
    
    /**********erstellt: Denis Bursillon********************************************/
    private void fillTile() throws MalformedURLException {
        MC_Hammer.DBV.restore(pfad);
        Image dummy = new Image("Data/dummy1.jpg");
        int i;
        if (!MC_Hammer.DBV.Autos.isEmpty()) {

            for (i = 0; i < MC_Hammer.DBV.Autos.size(); i++) {
                Image image = new Image(MC_Hammer.DBV.Autos.get(i).getFotoString());                
                ImageView imageView = new ImageView();
                int i2 = i;
                imageView.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {

                    String Hersteller = MC_Hammer.DBV.Autos.get(i2).getHersteller();
                    String modell = MC_Hammer.DBV.Autos.get(i2).getModell();
                    String Farbe = MC_Hammer.DBV.Autos.get(i2).getFarbe();
                    String leistung = String.valueOf(MC_Hammer.DBV.Autos.get(i2).getLeistung() + " PS");
                    String sitze = String.valueOf(MC_Hammer.DBV.Autos.get(i2).getSitzplaetze() + " Sitzplätze");
                    String kosten = String.valueOf(MC_Hammer.DBV.Autos.get(i2).getGebuehr_pro_Tag() + " € Pro Tag");
                    String a_id = String.valueOf(MC_Hammer.DBV.Autos.get(i2).getAuto_ID());
                    String kennz = MC_Hammer.DBV.Autos.get(i2).getKennzeichen();
                    Image imageBig = new Image(MC_Hammer.DBV.Autos.get(i2).getFotoString());

                    @Override
                    public void handle(MouseEvent event) {
                        markeText.setText(Hersteller);
                        modellText.setText(modell);
                        FarbeText.setText(Farbe);
                        leistungText.setText(leistung);
                        sitzeText.setText(sitze);
                        kostenText.setText(kosten);
                        idText.setText(a_id);
                        kennzeichenText.setText(kennz);
                        if (MC_Hammer.DBV.Autos.get(i2).getFoto().exists()) showView.setImage(imageBig);
                        else showView.setImage(new Image("Data/dummy1.jpg"));
                    }
                });
                imageView.addEventHandler(ContextMenuEvent.CONTEXT_MENU_REQUESTED, new EventHandler<ContextMenuEvent>() {

                    @Override
                    public void handle(ContextMenuEvent event) {
                        MC_Hammer.DBV.restore(pfad);
                        FileChooser fileChooser = new FileChooser();
                        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
                        File file = fileChooser.showOpenDialog(tile.getScene().getWindow());
                       try {
                            System.out.println("" + file.toURI().toURL().toString());
                        } catch (MalformedURLException ex) {
                            Logger.getLogger(AdminAnsichtController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        MC_Hammer.DBV.Autos.get(i2).setFoto(file);
                        MC_Hammer.DBV.save(pfad);                     
                        try {
                            refreshTile();
                        } catch (MalformedURLException ex) {
                            Logger.getLogger(AdminAnsichtController.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }
                    
                    
                });
                if(!MC_Hammer.DBV.Autos.get(i).getFoto().exists()) imageView.setImage(dummy);
                else imageView.setImage(image);
                
                imageView.setFitHeight(75);
                imageView.setPreserveRatio(true);
                tile.getChildren().add(imageView);
            }
        }
    }
    
    /**********erstellt: Denis Bursillon********************************************/
    private void bestätigung(){
        Stage popUp = new Stage();
        popUp.setTitle("Bestätigung");
        Parent Page;
        try {
            Page = FXMLLoader.load(getClass().getResource("Bestetigung.fxml"));

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
    private void handlCloseMenue(ActionEvent event) {
	System.exit(0);
    }
}
