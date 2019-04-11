/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.MService.Reclamation.BE;

import crud.MService.Reclamation.BE.CrudReclamation;
import entities.MGestionUtilisateur.User;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import techniques.Mail;

/**
 * FXML Controller class
 *
 * @author mahjoub
 */
public class ProfileRController implements Initializable {

    @FXML
    private Label UserName;
    @FXML
    private Label Email;
    @FXML
    private Label About;
    @FXML
    private Label PhoneNumber;
    @FXML
    private Label Location;
    @FXML
    private Label Address;
    @FXML
    private Label Job;
    @FXML
    private Button banUser;
    private CrudReclamation CR = new CrudReclamation();
    public static User u;
    @FXML
    private Button retrurn;
    @FXML
    private BorderPane BPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        
        UserName.setText(u.getUsername());
        Email.setText(u.getEmail());
        About.setText(u.getAbout());
        PhoneNumber.setText(u.getPhone_number()+"");
        Location.setText(u.getLocation());        
        Address.setText(u.getLocation());       
        Job.setText(u.getLocation());        
                
                
    }    

    @FXML
    private void banuserAction(ActionEvent event) {
         CR.ban(u.getId());
         new Mail(u.getEmail(), "E-nersery", "Vous ete banné");
    }

    @FXML
    private void returnaction(ActionEvent event) {
        LooadUI("Reclamation");
    }
    private  void LooadUI(String ui)
    {
        Parent root=null;
        try {
            root=FXMLLoader.load(getClass().getResource("/views/MService/Reclamation/BE/"+ui+".fxml"));
            
        } catch (IOException ex) {System.err.println(ex.getMessage());     }
        BPane.setCenter(root);
    }
}
/*
FXMLLoader loader =new FXMLLoader(getClass().getResource("/views/MService/Reclamation/BE/"+ui+".fxml"));
Parent root = loader.load();
xxxControler pc=loader.getControler();
pc.setNom();
pc.setPrenom();
tfNom.getScean().setRoot(root);
*/