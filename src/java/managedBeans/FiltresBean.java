/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managedBeans;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import session.Gestionnaire;



/**
 *
 * @author CYBER INFO
 */
@ManagedBean
@SessionScoped
public class FiltresBean implements Serializable{
    @EJB
    private Gestionnaire gestionnaire;

    
    public FiltresBean() {
       
    }
    
     String choixDevice ;
         String[] typesDevice = {"Website", " Mobile phone" , "Pocket PC" , "Tablet PC" , "Interactive kiosk" , 
             "Interactive TV" , "Personal organiser" ," Interactive toy"}  ;

     String choixUser;
     String[] typesUser ={"personnes âgées" , "jeunes" , "personnes handicapées" , "toutes personnes" };
     
    String choixTypeApp ;
    String[] typesApp = {"Commerciale", "Educative" ,"divertissement","tout les types" };
    
    String[] methodes ={"Bastien & Scapin", "Nielsen"};
    List<String> methodeChoisie ;

    public String getChoixDevice() {
        return choixDevice;
    }

    public void setChoixDevice(String choixDevice) {
        this.choixDevice = choixDevice;
    }

    public String[] getTypesDevice() {
        return typesDevice;
    }

    public void setTypesDevice(String[] typesDevice) {
        this.typesDevice = typesDevice;
    }

    public String getChoixUser() {
        return choixUser;
    }

    public void setChoixUser(String choixUser) {
        this.choixUser = choixUser;
    }

    public String[] getTypesUser() {
        return typesUser;
    }

    public void setTypesUser(String[] typesUser) {
        this.typesUser = typesUser;
    }

    public String getChoixTypeApp() {
        return choixTypeApp;
    }

    public void setChoixTypeApp(String choixTypeApp) {
        this.choixTypeApp = choixTypeApp;
    }

    public String[] getTypesApp() {
        return typesApp;
    }

    public void setTypesApp(String[] typesApp) {
        this.typesApp = typesApp;
    }

    public String[] getMethodes() {
        return methodes;
    }

    public void setMethodes(String[] methodes) {
        this.methodes = methodes;
    }

    public List<String> getMethodeChoisie() {
        return methodeChoisie;
    }

    public void setMethodeChoisie(List<String> methodeChoisie) {
        this.methodeChoisie = methodeChoisie;
    }
     public List<String> getDevices() {
        return gestionnaire.getAllDevices() ;
    }
     
      public List<String> getUsers() {
        return gestionnaire.getAllUsers();
    }
       public List<String> getAppTypes() {
        return gestionnaire.getAllAppTypes();
    }
   /* public String showQuestions() { 
        
Map params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
 
String device =(String)params.get("device");
String user =(String)params.get("user");
String apptype =(String)params.get("apptype");
//String method =(String)params.get("method");
System.out.print(user+" "+device+" "+apptype+" ");
        return "QuestionsChoice?faces-redirect=true&amp;Device="+device+"&amp;User="+user+"&amp;Apptype="+apptype;//+"&amp;user="+userr+"&amp;typeapp="+apptype+"&amp;method"+method
                //?faces-redirect=true&amp;includeViewParam=true&amp;
               
    }*/ 
}
