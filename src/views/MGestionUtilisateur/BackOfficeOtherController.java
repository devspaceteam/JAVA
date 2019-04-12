/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lazzem
 */
public class BackOfficeOtherController implements Initializable {

    @FXML
    private HBox produit;
    @FXML
    private HBox event;
    @FXML
    private HBox blog;
    @FXML
    private HBox promo;
    @FXML
    private HBox livraison;
    @FXML
    private HBox message;
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
    private void home(MouseEvent event) {
    }

    @FXML
    private void produit(MouseEvent event) throws SQLException, IOException {
        Parent root = FXMLLoader.load(getClass().getResource("OthersAfficherProduit.fxml"));
        Scene scene = new Scene(root);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();
    }

    @FXML
    private void event(MouseEvent event) {
    }

    @FXML
    private void blog(MouseEvent event) {
    }

    @FXML
    private void promo(MouseEvent event) {
    }

    @FXML
    private void livraison(MouseEvent event) {
    }

    @FXML
    private void message(MouseEvent event) {
    }

    @FXML
    private void monprofile(MouseEvent event) {
    }

    @FXML
    private void deco(MouseEvent event) {
    }
    
}
