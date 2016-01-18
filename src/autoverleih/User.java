/*
Die Klasse stellt die User Objekte da. Sie stellt alle nötigen Methoden zum Bearbeiten der User zur Verfügung. #Daniel Meerwald

 */
package autoverleih;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Christopher Haack
 */
@XmlRootElement(name = "User")
public class User 
{
    int User_ID;    //id des nutzers
    String User_Name; //name des nutzers
    String User_PW; //user password
    
    public User(int U_ID, String U_NAME, String U_PW)
    {
	User_ID = U_ID;
	User_Name = U_NAME;
	User_PW = U_PW;
    }
    public User()
    {
    }
    
    @XmlElement(name = "User_ID")
    public int getUser_ID() 
    {
        return User_ID;
    }
    
    @XmlElement(name = "Username")
    public String getUser_NAME() 
    {
        return User_Name;
    }
    
    @XmlElement(name = "Userpasswort")
    public String getUser_PW() 
    {
        return User_PW;
    }
    
    public void setU_ID(int U_ID) 
    {
        this.User_ID = U_ID;
    }
    
    public void setU_Name(String U_NAME) 
    {
        this.User_Name = U_NAME;
    }
    
    public void setU_pw(String U_PW) 
    {
        this.User_PW = U_PW;
    }
}

