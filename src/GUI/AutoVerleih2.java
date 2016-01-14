package GUI;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import autoverleih.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Denis Boursillon
 */
public class AutoVerleih2 extends Application {

    public Stage stage;
    public MetaController MC = new MetaController(); 
   
    
    @Override
    public void start(Stage stage) {

	File datas = new File("Data/xml/TestDatenbank.xml");
	if (datas.exists() == true) {
	    MC.DBV.restore("Data/xml/TestDatenbank.xml");
	} else {
	    MC.DBV.save("Data/xml/TestDatenbank.xml");
	}
	this.stage = stage;

        stage.setTitle("Verleih Sofware ver.0.0.5");
        Parent root; 
	try {
	    root = FXMLLoader.load(getClass().getResource("KundenAnsicht.fxml"));
	    Scene scene = new Scene(root);
	    stage.setScene(scene);
	    stage.show();

	} catch (IOException ex) {
	    Logger.getLogger(AutoVerleih2.class.getName()).log(Level.SEVERE, null, ex);
	}
        
        
        
//        css anweden
//        String style = AutoVerleih2.class.getResource("Stylesheet.css").toExternalForm();
//        scene.getStylesheets().add(style);
        

    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
