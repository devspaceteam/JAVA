/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.MGestionUtilisateur;

import crud.MGestionUtilisateurs.CrudUser;
import entities.MGestionUtilisateur.User;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
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
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import techniques.BCryptPasswordEncoder;

/**
 * FXML Controller class
 *
 * @author Lazzem
 */
public class OthersBackOfficePasswordController implements Initializable {

    @FXML
    private Text username;
    @FXML
    private Text deco;
    @FXML
    private PasswordField pass;
    @FXML
    private PasswordField confpass;
    @FXML
    private Button changer;
    @FXML
    private PasswordField passactuel;
    @FXML
    private Button retour;

    int id = LoginController.us.getId();
    User user = LoginController.us;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        username.setText("Bienvenue " + LoginController.us.getUsername().toUpperCase());
    }

    @FXML
    private void deco(MouseEvent event) throws IOException, SQLException {
        LoginController.us = null;
        Parent root = FXMLLoader.load(getClass().getResource("/views/MGestionUtilisateur/Login.fxml"));
        Scene scene = new Scene(root);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();
    }

    @FXML
    private void changer(ActionEvent event) throws IOException, SQLException {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if (!(pass.getText().equals(confpass.getText()))) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur de Saisie");
            alert.setHeaderText("Erreur");
            alert.setContentText("La nouveaux mot de passe et le mot de passe de confirmation ne sont pas les memes");
            Optional<ButtonType> result = alert.showAndWait();
        } else if (confpass.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur de Saisie");
            alert.setHeaderText("Erreur");
            alert.setContentText("Veuillez saisir un mot de passe valide");
            Optional<ButtonType> result = alert.showAndWait();

        } else if (!(passwordEncoder.matches(passactuel.getText(), user.getPassword()))) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur de Saisie");
            alert.setHeaderText("Erreur");
            alert.setContentText("Mot de passe incorrect");
            Optional<ButtonType> result = alert.showAndWait();
        } else if ((passactuel.getText().equals(""))) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur de Saisie");
            alert.setHeaderText("Erreur");
            alert.setContentText("Veuillez saisir votre mot de passe");
            Optional<ButtonType> result = alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText("Modification");
            alert.setContentText("Vouler vous vraiment modifier votre mot de passe ?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                CrudUser cu = new CrudUser();
                System.out.println("Mot de passe modifié");
                
                User u = new User();
                String hashedPassword = passwordEncoder.encode(confpass.getText());
                u.setPassword(hashedPassword);
                user.setPassword(hashedPassword);
                cu.changerMdp(u, id);

                Parent root = FXMLLoader.load(getClass().getResource("/views/MGestionUtilisateur/OthersBackOfficeProfile.fxml"));
                Scene scene = new Scene(root);
                Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.setScene(scene);
                app_stage.show();

            }
        }
    }

    @FXML
    private void retour(ActionEvent event) throws IOException, SQLException {
        Parent root = FXMLLoader.load(getClass().getResource("/views/MGestionUtilisateur/OthersBackOfficeProfile.fxml"));
        Scene scene = new Scene(root);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();
    }

}
