/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import autoverleih.Auto;
import autoverleih.Kunde;
import autoverleih.MetaController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

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

    MetaController MC_Hammer = new MetaController();
    private final String path = "Data/xml/TestDatenbank.xml";
    private String ausgabe = "";
    
    @FXML    private Label getA_ID_Label;
    @FXML    private Label getK_ID_Label;
    @FXML    private TextField getK_ID;
    @FXML    private Label warningAdmin;
    @FXML    private Label warningAfall;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
	// TODO
	showAllAusleihe();
    }    

    @FXML
    private void handleShowAfallButton(ActionEvent event) {
	int kid = 0;
	int aid = 0;
	int fehler = 0;
	
	kid = Integer.parseInt(getK_ID.getText());
	aid = Integer.parseInt(getA_ID.getText());
	
	fehler = abgleich(kid,aid);
	
	switch (fehler) {
	    case 1:
		
		setK_ID.setText(String.valueOf(MC_Hammer.DBV.Kunden.get(kid).getKunden_ID()));
		setK_Name.setText(MC_Hammer.DBV.Kunden.get(kid).getNachname());
		setK_Vorname.setText(MC_Hammer.DBV.Kunden.get(kid).getVorname());
		setK_Tel.setText(MC_Hammer.DBV.Kunden.get(kid).getTelefonnummer());
		setK_Ort.setText(MC_Hammer.DBV.Kunden.get(kid).getWohnort());
		setA_ID.setText(String.valueOf(MC_Hammer.DBV.Autos.get(aid).getAuto_ID()));
		setA_Kennz.setText(MC_Hammer.DBV.Autos.get(aid).getKennzeichen());
		setA_Marke.setText(MC_Hammer.DBV.Autos.get(aid).getHersteller());
		setA_Model.setText(MC_Hammer.DBV.Autos.get(aid).getModell());
		setA_Kaution.setText(String.valueOf(MC_Hammer.DBV.Autos.get(aid).getKaution()));
		setA_GpT.setText(String.valueOf(MC_Hammer.DBV.Autos.get(aid).getGebuehr_pro_Tag()));
		
		break;
	    case -1:
		getA_ID_Label.setTextFill(Color.BLACK);
		getK_ID_Label.setTextFill(Color.RED);
		warningAdmin.setVisible(false);
		warningAfall.setVisible(false);
		
		break;
	    case -2:
		getA_ID_Label.setTextFill(Color.RED);
		getK_ID_Label.setTextFill(Color.BLACK);
		warningAdmin.setVisible(false);
		warningAfall.setVisible(false);
		
		break;
	    case -3:
		getA_ID_Label.setTextFill(Color.RED);
		getK_ID_Label.setTextFill(Color.RED);
		warningAdmin.setVisible(false);
		warningAfall.setVisible(true);
		
		break;
	    case -4:
		getA_ID_Label.setTextFill(Color.BLACK);
		getK_ID_Label.setTextFill(Color.BLACK);
		warningAdmin.setVisible(true);
		warningAfall.setVisible(false);
		
		break;
	    default:
		getA_ID_Label.setTextFill(Color.BLACK);
		getK_ID_Label.setTextFill(Color.BLACK);
		warningAdmin.setVisible(true);
		warningAfall.setVisible(false);
		
		break;
		
    }
    }
    public void showAllAusleihe(){
        int i = 0;
	int kID = 0;
        MC_Hammer.DBV.restore(path);
        ausgabe = "Anzahl gespeicherter Ausleihen derzeit: " + MC_Hammer.DBV.Ausleihen.size()+"\n\n";
        while (i < MC_Hammer.DBV.Ausleihen.size()) {
	    ausgabe += "ID: " +MC_Hammer.DBV.Ausleihen.get(i);
	    /* anders realisiren
	   kID = MC_Hammer.DBV.Ausleihen.get(i).getKunden_ID();
            ausgabe +="    Vorname: "+ MC_Hammer.DBV.Kunden.get(kID).getVorname();
	     ausgabe +="    Nachname: "+ MC_Hammer.DBV.Kunden.get(kID).getNachname();
	    */
            ausgabe += "\n";
            i++;
        }
        vfall_text.setText(ausgabe);
        
    }
    
    //1 kein fehler
    //-1 kunden id falsch
    //-2 auto id falsch 
    //-3 keine ausleihe
    //-4 sollte nicht auftreten
    private int abgleich(int kID, int aID)
    {
	int i = 0;
	boolean kunde_indikator = false;
	boolean auto_indikator = false;
	boolean ausleihe_indikator = false;
	
	//kunden id ueberpreufen
	MC_Hammer.DBV.restore(path);
	while (i < MC_Hammer.DBV.Kunden.size() && kunde_indikator == false) { //Suche bis zum Ende der Liste.
            if (MC_Hammer.DBV.Kunden.get(i).getKunden_ID() == kID ) {
                kunde_indikator = true; //Ende der Methode, wenn das Objekt gefunden wurde.
            } else {
                i++; //Andernfalls wird das nächste Element vergleichen.
            }
        }
	if(kunde_indikator == false)
	{
	    return -1;
	}
	//##################
	
	
	i= 0;
	//auto id ueberpreufen 
	while (i < MC_Hammer.DBV.Autos.size() && auto_indikator == false) { //Suche bis zum Ende der Liste.
            if (MC_Hammer.DBV.Autos.get(i).getAuto_ID() == aID ) {
                auto_indikator = true; //Ende der Methode, wenn das Objekt gefunden wurde.
            } else {
                i++; //Andernfalls wird das nächste Element vergleichen.
            }
        }
	if (auto_indikator == false)
	{
	    return -2;
	}
	//########################
	i=0;
	//ausleihe ueberpreufen 
	while (i < MC_Hammer.DBV.Ausleihen.size() && ausleihe_indikator == false) { //Suche bis zum Ende der Liste.
            if ((MC_Hammer.DBV.Ausleihen.get(i).getAuto_ID() == aID) &&
		    (MC_Hammer.DBV.Ausleihen.get(i).getKunden_ID() == kID) ) {
                ausleihe_indikator = true; //Ende der Methode, wenn das Objekt gefunden wurde.
            } else {
                i++; //Andernfalls wird das nächste Element vergleichen.
            }
        }
	if (ausleihe_indikator == false)
	{
	    return -3;
	}
	//########################
	
	if(kunde_indikator == true &&
	   ausleihe_indikator == true &&
	   auto_indikator ==true)
	{
	    return 1;
	}
	
	
	return -4;    }
    
}
