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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lazzem
 */
public class BackOfficeAcceuilController implements Initializable {

    @FXML
    private HBox produit;
    @FXML
    private Text username;
    @FXML
    private Text deco;
    @FXML
    private HBox users1;
    @FXML
    private HBox categorie;
    @FXML
    private HBox produit1;
    @FXML
    private HBox produit2;
    @FXML
    private HBox produit3;
    @FXML
    private HBox produit4;
    @FXML
    private HBox users;
    @FXML
    private HBox users2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        username.setText("Bienvenue "+LoginController.us.getUsername().toUpperCase());
    }

    @FXML
    private void categorie(MouseEvent event) throws IOException, SQLException {
        Parent root = FXMLLoader.load(getClass().getResource("AfficherCategorie.fxml"));
        Scene scene = new Scene(root);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();
    }

    @FXML
    private void produit(MouseEvent event) throws IOException, SQLException {
        Parent root = FXMLLoader.load(getClass().getResource("AfficherProduit.fxml"));
        Scene scene = new Scene(root);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();
    }

    @FXML
    private void deco(MouseEvent event) throws IOException, SQLException {
        LoginController.us = null;
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(root);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();

    }

    @FXML
    private void users(MouseEvent event) throws IOException, SQLException {
        Parent root = FXMLLoader.load(getClass().getResource("AfficherUser.fxml"));
        Scene scene = new Scene(root);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();
    }

    @FXML
    private void monprofile(MouseEvent event) throws IOException, SQLException {
        Parent root = FXMLLoader.load(getClass().getResource("BackOfficeProfile.fxml"));
        Scene scene = new Scene(root);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();
    }



}
