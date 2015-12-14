package autoverleih;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Denis Boursillon
 */
public class AutoVerleih2 extends Application {

    public Stage stage;
  
   
    
    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        stage.setTitle("Verleih Sofware ver.0.0.5");
        Parent root = FXMLLoader.load(getClass().getResource("KundenAnsicht.fxml")); 
        
        Scene scene = new Scene(root);
        
//        css anweden
//        String style = AutoVerleih2.class.getResource("Stylesheet.css").toExternalForm();
//        scene.getStylesheets().add(style);
        
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
