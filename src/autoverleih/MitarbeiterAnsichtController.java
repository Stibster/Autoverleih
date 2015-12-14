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
public class MitarbeiterAnsichtController implements Initializable {

    @FXML    private Button saveBTN;
    @FXML    private Button beispielBTN;
    @FXML    private MenuItem loginAdmin;
    @FXML    private MenuItem LoginWorker;
    @FXML    private MenuItem logOut;
    @FXML    private TextField customerSearchText;
    @FXML    private Button SearchWorkerBTN;
    @FXML    private TextField carSearchText;
    @FXML    private Button SearchWorkerBTN1;

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

}
