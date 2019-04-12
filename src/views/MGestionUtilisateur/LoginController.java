/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Crud.CrudUser;
import Entity.User;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lazzem
 */
public class LoginController implements Initializable {

    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Button login;
    @FXML
    private Label outputlogin;
    @FXML
    private Button login1;
    CrudUser sb = new CrudUser();
    public static User us;
    @FXML
    private Label mdpoublie;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void authentification(ActionEvent event) throws IOException, SQLException {
        String e, m;
        e = username.getText();
        m = password.getText();
        User ad = new User();

        ad = sb.testauthentification(e, m);
        if (ad != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Succés");
            alert.setHeaderText("Succés");
            alert.setContentText("Bienvenue " + username.getText());
            Optional<ButtonType> result = alert.showAndWait();
            us = ad;
            try {
                
                
            } catch (IllegalStateException ex) {
                System.out.println(ex);

            } catch (NullPointerException ex) {
                System.out.println(ex);
            }
            
            if (ad.getRoles().contains("ROLE_ADMIN")) {
                    Parent root = FXMLLoader.load(getClass().getResource("BackOfficeAcceuil.fxml"));
                    Scene scene = new Scene(root);
                    Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    app_stage.setScene(scene);
                    app_stage.show();
                } if (ad.getRoles().equals("a:0:{}")) {
                    Parent root = FXMLLoader.load(getClass().getResource("FrontOfficeAcceuil.fxml"));
                    Scene scene = new Scene(root);
                    Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    app_stage.setScene(scene);
                    app_stage.show();
                } if(ad.getRoles().contains("ROLE_ENTREPRISE")) {
                    Parent root = FXMLLoader.load(getClass().getResource("BackOfficeOther.fxml"));
                    Scene scene = new Scene(root);
                    Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    app_stage.setScene(scene);
                    app_stage.show();
                }
                if(ad.getRoles().contains("ROLE_AGRICULTEUR")) {
                    Parent root = FXMLLoader.load(getClass().getResource("BackOfficeOther.fxml"));
                    Scene scene = new Scene(root);
                    Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    app_stage.setScene(scene);
                    app_stage.show();
                }
                if(ad.getRoles().contains("ROLE_JARDINIER")) {
                    Parent root = FXMLLoader.load(getClass().getResource("BackOfficeOther.fxml"));
                    Scene scene = new Scene(root);
                    Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    app_stage.setScene(scene);
                    app_stage.show();
                }
        } else {
            Alert alert2 = new Alert(Alert.AlertType.ERROR);
            alert2.setTitle("Erreur");
            alert2.setHeaderText("Erreur");
            alert2.setContentText("Username or Password incorrect !");
            Optional<ButtonType> result2 = alert2.showAndWait();
        }
    }

    @FXML
    private void inscription(ActionEvent event) throws SQLException, IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Register.fxml"));
        Scene scene = new Scene(root);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();
    }

    @FXML
    private void reset(MouseEvent event) throws SQLException, IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Reset.fxml"));
        Scene scene = new Scene(root);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();

    }

}
