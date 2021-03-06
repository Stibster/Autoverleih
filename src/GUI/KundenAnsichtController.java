
package GUI;

import autoverleih.MetaController;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.TilePane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Denis
 */
public class KundenAnsichtController implements Initializable {

    private boolean accessAdmin, accessWorker = false;
    @FXML    private Button saveBTN;
    @FXML    private Button beispielBTN;
    @FXML    private Button SearchBTN;
    @FXML    private MenuItem logIn;
    @FXML    private TextField searchText;
    @FXML    private TextField markeText;
    @FXML    private TextField modellText;
    @FXML    private TextField FarbeText;
    @FXML    private TextField leistungText;
    @FXML    private TextField sitzeText;
    @FXML    private TextField kostenText;
    @FXML    private MenuItem logOut;
    @FXML    private TilePane tile;
    @FXML    private ImageView showView;
    @FXML    private Button shorty;
    @FXML    private Button shortyA;
    
    
    
    MetaController MC_Hammer = new MetaController();
    String pfad = "TestDatenbank.xml";
    @FXML
    private MenuItem about;

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)  {
        try {
            showCars();
        } catch (MalformedURLException ex) {
            Logger.getLogger(KundenAnsichtController.class.getName()).log(Level.SEVERE, null, ex);
        }
        tile.getChildren().clear();  
        try {
            showCars();
        } catch (MalformedURLException ex) {
            Logger.getLogger(KundenAnsichtController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    
//  Beistpeil für die anzeige eines Fahrzeugs
//  Wird in nur zum testen Verwendet
    @FXML
    private void handleBeispiel(ActionEvent event) {
        markeText.setText("Nissan");
        modellText.setText("Skyline");
        FarbeText.setText("Blau");
        leistungText.setText("259PS");
        sitzeText.setText("4 Türen");
        kostenText.setText("89€ pro Tag");

    }
    
//  Methode Für den Suchen Button
    @FXML
    private void handleSearch(ActionEvent event) {

    }

//  Methode für den Save und Exit Button
    @FXML
    private void handleSaveExit(ActionEvent event) {
        System.exit(0);
    }
    
    /**********erstellt: Denis Bursillon********************************************/
    @FXML
    private void handleShorty(ActionEvent event) throws IOException{
        Stage stage = (Stage) saveBTN.getScene().getWindow();
        Parent Page = FXMLLoader.load(getClass().getResource("MitarbeiterAnsicht.fxml"));
        stage.setScene(new Scene(Page));
    }
    //###########################################
    // Admin shortcut Christopher Haack
    @FXML
    private void handleShortyA(ActionEvent event) throws IOException{
        Stage stage = (Stage) saveBTN.getScene().getWindow();
        Parent Page = FXMLLoader.load(getClass().getResource("AdminAnsicht.fxml"));
        stage.setScene(new Scene(Page));
    }
    //#######################################
    
    
    /**********erstellt: Denis Bursillon********************************************/
    private void showCars() throws MalformedURLException {
        try {
            MC_Hammer.DBV.restore(pfad);
        } catch (Exception e) {
            MC_Hammer.DBV.save(pfad);
            System.err.println(e);
            System.out.println("Neue Datenbank erstellt");
        }
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
                    Image imageBig = new Image(MC_Hammer.DBV.Autos.get(i2).getFotoString());

                    @Override
                    public void handle(MouseEvent event) {
                        markeText.setText(Hersteller);
                        modellText.setText(modell);
                        FarbeText.setText(Farbe);
                        leistungText.setText(leistung);
                        sitzeText.setText(sitze);
                        kostenText.setText(kosten);
                        if (MC_Hammer.DBV.Autos.get(i2).getFoto().exists()) showView.setImage(imageBig);
                        else showView.setImage(new Image("Data/dummy1.jpg"));
                    }
                });
                
                if (!MC_Hammer.DBV.Autos.get(i).getFoto().exists()) imageView.setImage(new Image("Data/dummy1.jpg"));
                else imageView.setImage(image);
                
                imageView.setFitHeight(75);
                imageView.setPreserveRatio(true);
                tile.getChildren().add(imageView);
            }
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
    private void handelCloseMenue(ActionEvent event) {
	System.exit(0);
    }
}
