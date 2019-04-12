/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Crud.CrudCategorie;
import Entity.Categorie;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import org.apache.commons.io.FileUtils;

/**
 * FXML Controller class
 *
 * @author Lazzem
 */
public class AjouterCategorieController implements Initializable {

    @FXML
    private TextField nom;
    @FXML
    private TextArea description;
    @FXML
    private ComboBox<String> Type;
    @FXML
    private Button img1;
    @FXML
    private Button ajouter;
    @FXML
    private Label cheminimage;

    FileChooser fc1 = new FileChooser();
    File selectedFile1 = new File("");
    @FXML
    private ImageView imageview;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        Type.getItems().addAll("Service", "Outils", "Arbre");
        Type.setValue("Service");

    }

    @FXML
    private void image(ActionEvent event) throws FileNotFoundException, IOException {
        File dest = new File("C:\\wamp\\www\\DevSpace\\web\\devis\\");

        fc1.setInitialDirectory(new File("C:\\"));
        selectedFile1 = fc1.showOpenDialog(null);
        FileUtils.copyFileToDirectory(selectedFile1, dest);

        File newFile1 = new File("C:\\wamp64\\www\\DevSpace\\web\\devis\\" + selectedFile1.getName());

        FileInputStream input1 = new FileInputStream(newFile1);
        Image image1 = new Image(input1);
        cheminimage.setText(newFile1.getName());
        imageview.setImage(image1);
    }

    @FXML
    private void AjouterCategorie(ActionEvent event) {

        if ((nom.getText().equals(""))) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur de Saisie");
            alert.setHeaderText("Erreur");
            alert.setContentText("Veuillez saisir un nom valide");
            Optional<ButtonType> result = alert.showAndWait();
        } else if (description.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur de Saisie");
            alert.setHeaderText("Erreur");
            alert.setContentText("Veuillez saisir une description valide");
            Optional<ButtonType> result = alert.showAndWait();
        } else if (cheminimage.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur de Saisie");
            alert.setHeaderText("Erreur");
            alert.setContentText("Veuillez selectionner une image");
            Optional<ButtonType> result = alert.showAndWait();
        } 
        else if (Type.getValue().equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur de Saisie");
            alert.setHeaderText("Erreur");
            alert.setContentText("Veuillez selectionner le type du categorie");
            Optional<ButtonType> result = alert.showAndWait();
        }else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText("Modification");
            alert.setContentText("Vouler vous vraiment ajouter cet categorie ?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {

                String nomCategorie = nom.getText();
                String descriptionCategorie = description.getText();
                String typeCategorie = Type.getValue();
                String image1 = cheminimage.getText();

                CrudCategorie cc = new CrudCategorie();
                Categorie c = new Categorie();
                c.setNom(nomCategorie);
                c.setDescription(descriptionCategorie);
                c.setType(typeCategorie);
                c.setDevis_name(image1);
                cc.AjouterCategorie(c);

            }
        }
    }

}
