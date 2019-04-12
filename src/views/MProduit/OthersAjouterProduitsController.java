/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Lazzem
 */
public class OthersAjouterProduitsController implements Initializable {

    @FXML
    private TextField nom;
    @FXML
    private TextArea description;
    @FXML
    private TextField quantite;
    @FXML
    private Button img1;
    @FXML
    private Button img2;
    @FXML
    private Button img3;
    @FXML
    private ComboBox<?> categorie;
    @FXML
    private TextField prix;
    @FXML
    private Button ajouter;
    @FXML
    private Label cheminimage1;
    @FXML
    private Label cheminimage2;
    @FXML
    private Label cheminimage3;
    @FXML
    private ImageView imageview1;
    @FXML
    private ImageView imageview2;
    @FXML
    private ImageView imageview3;
    @FXML
    private Label UserName;
    @FXML
    private Text username;
    @FXML
    private Text deco;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajoutImage1(ActionEvent event) {
    }

    @FXML
    private void ajoutImage2(ActionEvent event) {
    }

    @FXML
    private void ajoutImage3(ActionEvent event) {
    }

    @FXML
    private void Ajouter(ActionEvent event) {
    }

    @FXML
    private void home(MouseEvent event) {
    }

    @FXML
    private void monprofile(MouseEvent event) {
    }

    @FXML
    private void deco(MouseEvent event) {
    }
    
}
