/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Denis
 */
public class AdminAnsichtController implements Initializable {

    @FXML    private Button saveBTN;

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
    }

    @FXML
    private void handleLoginBeispiel() {
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
    private void handleSaveExit(ActionEvent event) {
        System.exit(0);
    }

}
