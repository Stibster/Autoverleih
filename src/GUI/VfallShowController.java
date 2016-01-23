/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import autoverleih.Auto;
import autoverleih.Kunde;
import autoverleih.Ausleihe;
import autoverleih.MetaController;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hiki-tink
 */
public class VfallShowController implements Initializable {

    @FXML    private TextField setK_ID;
    @FXML    private TextField setK_Name;
    @FXML    private TextField setK_Vorname;
    @FXML    private TextField setK_Tel;
    @FXML    private TextField setK_Ort;
    @FXML    private TextField setA_ID;
    @FXML    private TextField setA_Kennz;
    @FXML    private TextField setA_Marke;
    @FXML    private TextField setA_Model;
    @FXML    private TextField setA_Kaution;
    @FXML    private TextField setA_GpT;
    @FXML    private TextArea vfall_text;
    @FXML    private TextField getA_ID;
    @FXML    private Button showAfall;
    @FXML    private Label warningAdmin;
    @FXML    private Label warningAfall;
    @FXML    private Button delete;
    @FXML    private Button create;
    @FXML    private TextField vonDate;
    @FXML    private TextField bisDate;
    @FXML    private TableView table;
    @FXML    private TableColumn<Ausleihe, Integer> tableId;
    @FXML    private TableColumn<Ausleihe, Integer> tableCarId;
    @FXML    private TableColumn<Ausleihe, Integer> tableCusId;
    @FXML    private TableColumn<Ausleihe, String> tableVon;
    @FXML    private TableColumn<Ausleihe, String> tableBis;
    
    ObservableList<Ausleihe> ausleiheO;    
    MetaController MC_Hammer = new MetaController();
    private final String path = "TestDatenbank.xml";
    private String ausgabe = "";
    SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy", new DateFormatSymbols(Locale.GERMANY));
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) { 
	tableId.setCellValueFactory(new PropertyValueFactory<>("Ausleihe_ID"));
	tableCarId.setCellValueFactory(new PropertyValueFactory<>("Auto_ID"));
	tableCusId.setCellValueFactory(new PropertyValueFactory<>("Kunden_ID"));
	tableVon.setCellValueFactory(new PropertyValueFactory<>("Ausleihdatum"));
	tableBis.setCellValueFactory(new PropertyValueFactory<>("Rueckgabedatum"));
	table.setItems(ausleiheOfill());
//	showAllAusleihe();
    }    
    
/*######################### Nichtmehr Verwendet ##############################*/    
//    @FXML
//    private void handleShowAfallButton(ActionEvent event) { //Komplett Überarbeitet von Daniel Meerwald
//	int kid = 0;
//	int aid = 0;
//        int ausid = 0;
//	int fehler = 0;
//        
//        MC_Hammer.DBV.restore(path);
//        
//	ausid = Integer.parseInt(getA_ID.getText());
//	
//        fehler = abgleich(ausid);
//        
//        if (fehler == 1){
//        kid = MC_Hammer.DBV.getAusleihebyID(ausid).getKunden_ID();
//        aid = MC_Hammer.DBV.getAusleihebyID(ausid).getAuto_ID();
//        }
//	
////        getA_ID_Label.setTextFill(Color.BLACK);
//        warningAdmin.setVisible(false);
//	
//	switch (fehler) {
//	    case 1:
//		
//		setK_ID.setText(String.valueOf(MC_Hammer.DBV.getKundebyID(kid).getKunden_ID()));
//		setK_Name.setText(MC_Hammer.DBV.getKundebyID(kid).getNachname());
//		setK_Vorname.setText(MC_Hammer.DBV.getKundebyID(kid).getVorname());
//		setK_Tel.setText(MC_Hammer.DBV.getKundebyID(kid).getTelefonnummer());
//		setK_Ort.setText(MC_Hammer.DBV.getKundebyID(kid).getWohnort());
//		setA_ID.setText(String.valueOf(MC_Hammer.DBV.getAutobyID(aid).getAuto_ID()));
//		setA_Kennz.setText(MC_Hammer.DBV.getAutobyID(aid).getKennzeichen());
//		setA_Marke.setText(MC_Hammer.DBV.getAutobyID(aid).getHersteller());
//		setA_Model.setText(MC_Hammer.DBV.getAutobyID(aid).getModell());
//		setA_Kaution.setText(String.valueOf(MC_Hammer.DBV.getAutobyID(aid).getKaution()));
//		setA_GpT.setText(String.valueOf(MC_Hammer.DBV.getAutobyID(aid).getGebuehr_pro_Tag()));
//		
//		//############## Christopher Haack
//		//SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy", new DateFormatSymbols(Locale.GERMANY));
//		bisDate.setText("Bis: " + String.valueOf(format.format(MC_Hammer.DBV.getAusleihebyID(ausid).getRueckgabedatum())));
//		vonDate.setText("Von: " + String.valueOf(format.format(MC_Hammer.DBV.getAusleihebyID(ausid).getAusleihdatum())));
//		//######################
//		
//		break;
//	    case -1:
////                getA_ID_Label.setTextFill(Color.RED);
//		warningAdmin.setVisible(false);
//		warningAfall.setVisible(false);
//		
//		break;
//	    default:
////		getA_ID_Label.setTextFill(Color.BLACK);
//		warningAdmin.setVisible(true);
//		warningAfall.setVisible(false);
//		
//		break;
//		
//            
//        }
//    }
    
    
    
/*######################### Nichtmehr Verwendet ##############################*/
//    public void showAllAusleihe(){ // Überarbeitet von Daniel Meerwald
//        int i = 0;
//	int kID = 0;
//        int aID = 0;
//        vfall_text.clear();
//        MC_Hammer.DBV.restore(path);
//        ausgabe = "Anzahl gespeicherter Ausleihen derzeit: " + MC_Hammer.DBV.Ausleihen.size()+"\n\n";
//        while (i < MC_Hammer.DBV.Ausleihen.size()) {
//	    ausgabe += "Ausleihe-ID: " +MC_Hammer.DBV.Ausleihen.get(i).getAusleihe_ID();
//	
//	   kID = MC_Hammer.DBV.Ausleihen.get(i).getKunden_ID();
//            ausgabe +="    Kunde: "+ MC_Hammer.DBV.getKundebyID(kID).getVorname() +" "+ MC_Hammer.DBV.getKundebyID(kID).getNachname()+"   hat   ";
//	     
//	    
//           aID = MC_Hammer.DBV.Ausleihen.get(i).getAuto_ID();
//              ausgabe +="Auto: "+ MC_Hammer.DBV.getAutobyID(aID).getHersteller() +" "+ MC_Hammer.DBV.getAutobyID(aID).getModell()+" Kennzeichen: "+MC_Hammer.DBV.Autos.get(aID).getKennzeichen()+" geliehen.";
//             
//            ausgabe += "\n";
//            i++;
//        }
//        vfall_text.setText(ausgabe);
//        
//    }
    

    
/*######################### Nichtmehr Verwendet ##############################*/
    //1 kein fehler
    //-1 Ausleihe id falsch
    //-2 sollte nicht auftreten
//    private int abgleich(int aID) //Komplett Überarbeitet von Daniel Meerwald
//    {
//        
//	int i = 0;
//	boolean ausleihe_indikator = false;
//	
//	//kunden id ueberpreufen
//	MC_Hammer.DBV.restore(path);
//	while (i < MC_Hammer.DBV.Ausleihen.size() && ausleihe_indikator == false) { //Suche bis zum Ende der Liste.
//            if (MC_Hammer.DBV.Ausleihen.get(i).getAusleihe_ID()== aID ) {
//                ausleihe_indikator = true; //Ende der Methode, wenn das Objekt gefunden wurde
//                
//            } else {
//                i++; //Andernfalls wird das nächste Element vergleichen.
//            }
//        }
//	if(ausleihe_indikator == false)
//	{
//	    return -1;
//	}
//        if(ausleihe_indikator == true)
//	{
//	    return 1;
//	}
//        
//    return -2;}

 
    
/*######################### Nichtmehr Verwendet ##############################*/
//    @FXML
//    private void handleDeleteButton(ActionEvent event) {
//	
//	int ausid = 0;
//	int fehler = 0;
//	
//	
//	ausid = Integer.parseInt(getA_ID.getText());
//	fehler =  abgleich(ausid);
//        
////	getA_ID_Label.setTextFill(Color.BLACK);
//        warningAdmin.setVisible(false);
//	
//	switch (fehler) {
//	    case 1:
//		
//		MC_Hammer.DBV.removeAusleihe(ausid);
//		MC_Hammer.DBV.save(path);
//                //showAllAusleihe();
//		table.setItems(ausleiheOfill());
//		bestätigung();
//		
//		
//		break;
//	    case -1:
////                getA_ID_Label.setTextFill(Color.RED);
//		warningAdmin.setVisible(false);
//		warningAfall.setVisible(false);
//		
//		break;
//	    default:
////		getA_ID_Label.setTextFill(Color.BLACK);
//		warningAdmin.setVisible(true);
//		warningAfall.setVisible(false);
//		
//		break;
//	}
//    }

/*######################### Komplett neu erstellt ############################*/
/*######################### Denis Boursillon #################################*/
    @FXML
    private void handleDeleteButton(ActionEvent event) {
        if (table.getSelectionModel().getSelectedIndex() >= 0) {
            MC_Hammer.DBV.removeAusleihe(table.getSelectionModel().getSelectedIndex());
            MC_Hammer.DBV.save(path);
//            showAllAusleihe();
            table.setItems(ausleiheOfill());
            bestätigung();
        }
    }

    @FXML
    private void handleCreateButton(ActionEvent event) {
	Stage popUp = new Stage();
        popUp.setTitle("Vermietung Erstellen");
        Parent Page;
        try {
            Page = FXMLLoader.load(getClass().getResource("Vfall_popup.fxml"));

            popUp.setScene(new Scene(Page));
            popUp.initModality(Modality.APPLICATION_MODAL);
            popUp.initOwner(create.getScene().getWindow());
            popUp.showAndWait();
            //showAllAusleihe();
	    table.setItems(ausleiheOfill());
        } catch (IOException ex) {
            Logger.getLogger(AdminAnsichtController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

/*######################### Komplett neu erstellt ############################*/
/*######################### Denis Boursillon #################################*/
    @FXML
    private void handleTableClick(MouseEvent event) {
        if(table.getSelectionModel().getSelectedIndex()>= 0){
            int kid = ausleiheO.get(table.getSelectionModel().getSelectedIndex()).getKunden_ID();
            int aid = ausleiheO.get(table.getSelectionModel().getSelectedIndex()).getAuto_ID();
                
            setK_ID.setText(String.valueOf(MC_Hammer.DBV.getKundebyID(kid).getKunden_ID()));
            setK_Name.setText(MC_Hammer.DBV.getKundebyID(kid).getNachname());
            setK_Vorname.setText(MC_Hammer.DBV.getKundebyID(kid).getVorname());
            setK_Tel.setText(MC_Hammer.DBV.getKundebyID(kid).getTelefonnummer());
            setK_Ort.setText(MC_Hammer.DBV.getKundebyID(kid).getWohnort());
            setA_ID.setText(String.valueOf(MC_Hammer.DBV.getAutobyID(aid).getAuto_ID()));
            setA_Kennz.setText(MC_Hammer.DBV.getAutobyID(aid).getKennzeichen());
            setA_Marke.setText(MC_Hammer.DBV.getAutobyID(aid).getHersteller());
            setA_Model.setText(MC_Hammer.DBV.getAutobyID(aid).getModell());
            setA_Kaution.setText(String.valueOf(MC_Hammer.DBV.getAutobyID(aid).getKaution()));
            setA_GpT.setText(String.valueOf(MC_Hammer.DBV.getAutobyID(aid).getGebuehr_pro_Tag()));
	    //############## Christopher Haack
	    int ausid = ausleiheO.get(table.getSelectionModel().getSelectedIndex()).getAusleihe_ID();
	    //SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy", new DateFormatSymbols(Locale.GERMANY));
	    bisDate.setText("Bis: " + String.valueOf(format.format(MC_Hammer.DBV.getAusleihebyID(ausid).getRueckgabedatum())));
	    vonDate.setText("Von: " + String.valueOf(format.format(MC_Hammer.DBV.getAusleihebyID(ausid).getAusleihdatum())));
	    //######################
        }
    }
    
    private void bestätigung(){
        Stage popUp = new Stage();
        popUp.setTitle("Bestätigung");
        Parent Page;
        try {
            Page = FXMLLoader.load(getClass().getResource("Bestetigung.fxml"));

            popUp.setScene(new Scene(Page));
            popUp.initModality(Modality.APPLICATION_MODAL);
            popUp.initOwner(delete.getScene().getWindow());
            popUp.showAndWait();
        } catch (IOException ex) {
            Logger.getLogger(AdminAnsichtController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
/*######################### Christopher Haack ################################*/
/*######################### Denis Boursillon #################################*/
    public ObservableList<Ausleihe> ausleiheOfill() {
	ausleiheO = FXCollections.observableArrayList();
	int i = 0;
	ausleiheO.clear();
	
	MC_Hammer.DBV.restore(path);
	while (i < MC_Hammer.DBV.Ausleihen.size()) {
	    ausleiheO.add(new Ausleihe(
		    MC_Hammer.DBV.Ausleihen.get(i).getAusleihe_ID(),
		    MC_Hammer.DBV.Ausleihen.get(i).getAuto_ID(),
		    MC_Hammer.DBV.Ausleihen.get(i).getKunden_ID(),
		    MC_Hammer.DBV.Ausleihen.get(i).getAusleihdatum(),
		    MC_Hammer.DBV.Ausleihen.get(i).getRueckgabedatum()
		)
		    
	    );
	    i++;
	}
	return ausleiheO;
    }
}
