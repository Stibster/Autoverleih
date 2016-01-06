/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoverleih;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Daniel Meerwald
 */
//###Listenhelper Klasse, erstellt von Daniel Meerwald##########################
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "DB_Verwalter_Root")
public class Listenhelper {

    @XmlElement(name = "Kundenliste")
    private List<Kunde> Kunden = new ArrayList<Kunde>();
    
    @XmlElement(name = "Autoliste")
    private List<Auto> Autos = new ArrayList<Auto>();
        
    @XmlElement(name = "Ausleiheliste")
    private List<Ausleihe> Ausleihen = new ArrayList<Ausleihe>();
    
    //############### Christopher Haack
    @XmlElement(name = "Userliste")
    private List<User> Users = new ArrayList<User>();
    //########################
     
    
    
    public Listenhelper() {}
  
    
    //Christopher Useres hinzugefuegt
    public Listenhelper(List<Kunde> Kunden, List<Auto> Autos, List<Ausleihe> Ausleihen,List<User> Useres) {
        this.Kunden = Kunden;
        this.Autos = Autos;
        this.Ausleihen = Ausleihen;
	this.Users = Useres;
    }
 
    
    public List<Kunde> getKunden() {
        return Kunden;
    }

    public List<Auto> getAutos() {
        return Autos;
    }

    public List<Ausleihe> getAusleihen() {
        return Ausleihen;
    }

    public void setKunden(List<Kunde> Kunden) {
        this.Kunden = Kunden;
    }

    public void setAutos(List<Auto> Autos) {
        this.Autos = Autos;
    }

    public void setAusleihen(List<Ausleihe> Ausleihen) {
        this.Ausleihen = Ausleihen;
    }   
//##############################################################################
    //##############Christopher Haack
    public List<User> getUsers() 
    {
        return Users;
    }
     public void setUsers(List<User> Users) 
     {
        this.Users = Users;
    }
    //########################################
}
