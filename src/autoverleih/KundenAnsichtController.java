package autoverleih;

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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Denis
 */
public class KundenAnsichtController implements Initializable {

    @FXML    private Button saveBTN;
    @FXML    private Button beispielBTN;
    @FXML    private Button SearchBTN;
    @FXML    private MenuItem loginAdmin;
    @FXML    private MenuItem LoginWorker;
    @FXML    private TextField searchText;
    @FXML    private TextField markeText;
    @FXML    private TextField modellText;
    @FXML    private TextField FarbeText;
    @FXML    private TextField leistungText;
    @FXML    private TextField sitzeText;
    @FXML    private TextField kostenText;
    @FXML    private MenuItem handleLoginWorker;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void handleLoginAdmin() {
        Stage stage = (Stage) saveBTN.getScene().getWindow();
        Parent Page;
        try {
            Page = FXMLLoader.load(getClass().getResource("AdminAnsicht.fxml"));

            Scene scene = new Scene(Page);

            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(MitarbeiterAnsichtController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//  Methode für das Login als Mittarbeiter im DropDownMenü 
    @FXML
    private void handleLoginWorker() {
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
        //>X
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
}
