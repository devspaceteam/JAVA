/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;


import com.restfb.types.ads.Rule;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.Client;
import com.twilio.type.PhoneNumber;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javax.xml.soap.MessageFactory;
import org.controlsfx.control.Notifications;
import techniques.DateConverter;
import techniques.Mail;
import techniques.Notification;
import techniques.Notif;
import techniques.SMS;
import techniques.VOICE_RSS;
import views.MService.Reclamation.BE.ReclamationController;
import views.MService.Wishlist.WishlistController;


/**
 * FXML Controller class
 *
 * @author mahjoub
 */
public class HomeFEController implements Initializable {

    @FXML
    private ImageView logo;
    @FXML
    private Button Home;
    @FXML
    private Button Shop;
    @FXML
    private Button Promotion;
    @FXML
    private Button Evenement;
    @FXML
    private Button Blog;
    @FXML
    private Button Livraison;
    @FXML
    private Button Avis;
    @FXML
    private Button Dashborad;
    @FXML
    private  BorderPane borderpane;
    @FXML
    private Button Wishlistbtn;
     public static final String ACCOUNT_SID = "ACbf5f236db556a91fa3e9bdb7a8f9e4f4";
    public static final String AUTH_TOKEN = "f575394a273d288be31676bc3ab2dd9b";
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    

    @FXML
    private void OpenHome(ActionEvent event) {
       // new Mail("mohameddhia.soudani@esprit.tn", "hello", "nigga");
     
       
               SMS.SMS();
      
    }

    @FXML
    private void OpenShop(ActionEvent event) {
        LooadUI("/views/MGestionUtilisateur/ListeUtilisateur");
    }

    @FXML
    private void OpenPromotion(ActionEvent event) {
    }

    @FXML
    private void OpenEvenement(ActionEvent event) {
    }

    @FXML
    private void OpenBlog(ActionEvent event) {
    }

    @FXML
    private void OpenLivraison(ActionEvent event) {
        new Notification(0);
        ReclamationController.HomeBorderrrr=borderpane;
        LooadUI("/views/MService/Reclamation/BE/Reclamation");
    }

    @FXML
    private void OpenAvis(ActionEvent event) {
        LooadUI("/views/MService/Reclamation/FE/Reclamation");
    }

    @FXML
    private void OpenDashborad(ActionEvent event) {
    }
    
    /**
     * Parametre ui must be the all  path to this fxml
     * @param ui 
     */
    private  void LooadUI(String ui)
    {
        Parent root=null;
        try {
            root=FXMLLoader.load(getClass().getResource(ui+".fxml"));
            
        } catch (IOException ex) {System.err.println(ex.getMessage());     }
        borderpane.setCenter(root);
    }

    
    
    
    @FXML
    private void OpenWishlist(ActionEvent event) {
        WishlistController.HomeBorderrrr=borderpane;
         LooadUI("/views/MService/Wishlist/Wishlist");
    }
   
    
   
    
}
