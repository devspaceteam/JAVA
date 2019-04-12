/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Crud.CrudCategorie;
import Crud.CrudProduit;
import Entity.Categorie;
import Entity.Produit;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.controlsfx.control.textfield.TextFields;

/**
 * FXML Controller class
 *
 * @author Lazzem
 */
public class FrontAfficherProduitController implements Initializable {

    @FXML
    private Button retour;
    @FXML
    private TableView<Produit> tableview;
    @FXML
    private TableColumn<?, ?> id_prod;
    @FXML
    private TableColumn<?, ?> nom_prod;
    @FXML
    private TableColumn<?, ?> prix_prod;
    @FXML
    private TableColumn<?, ?> quant_prod;
    @FXML
    private TableColumn<?, ?> type_prod;
    @FXML
    private TableColumn<?, ?> desc_prod;
    @FXML
    private TextField nom;
    @FXML
    private ComboBox<String> type;
    @FXML
    private TextField prix;
    @FXML
    private TextField quant;
    @FXML
    private ImageView imageviewer1;
    @FXML
    private ImageView imageviewer3;
    @FXML
    private ImageView imageviewer2;
    @FXML
    private TextArea description;
    @FXML
    private TextField rech;
    @FXML
    private ComboBox<String> affcat;

    private ObservableList<Produit> data;
    @FXML
    private Label idE;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        affcat.getItems().addAll("Service", "Outils", "Arbre");
        data = FXCollections.observableArrayList();

        loadDataFromDatabase();
        setsCllTable();
        setcellValue();
        CrudProduit cp = new CrudProduit();
        List<Produit> cat = cp.AfficherCategorie();
        List<String> listS = new ArrayList<>();
        listS.add("Service");
        listS.add("Arbre");
        TextFields.bindAutoCompletion(rech, listS);
        search();
    }

    @FXML
    private void retour(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("BackOfficeAcceuil.fxml"));
            Scene scene = new Scene(root);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.setScene(scene);
            app_stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AfficherProduitController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void search() {
        FilteredList<Produit> filterdata = new FilteredList<>(data, e -> true);
        rech.setOnKeyReleased(e -> {
            rech.textProperty().addListener((observableValue, oldValue, newValue) -> {
                filterdata.setPredicate((Predicate<? super Produit>) prods -> {
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }
                    if ((prods.getNom().contains(newValue))
                            || (prods.getNom().toLowerCase().contains(newValue))) {
                        return true;
                    }
                    return false;
                });
            });
            SortedList<Produit> sorteddata = new SortedList<>(filterdata);
            sorteddata.comparatorProperty().bind(tableview.comparatorProperty());
            tableview.setItems(sorteddata);
        });
    }

    private void setcellValue() {
        tableview.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent event) {
                Produit p = tableview.getItems().get(tableview.getSelectionModel().getSelectedIndex());
                idE.setText(String.valueOf(p.getId_produit()));
                nom.setText(p.getNom());
                Crud.CrudCategorie categorieType = new CrudCategorie();
                List<Categorie> list = categorieType.AfficherCategorie();
                for (Categorie c : list) {
                    if (c.getId_categorie() == p.getId_categorie()) {
                        type.setValue(c.getNom());
                    }
                }
                description.setText(p.getDescription());
                prix.setText(String.valueOf(p.getPrix()));
                quant.setText(String.valueOf(p.getQuantite()));

            }
        });

    }

    private void loadDataFromDatabase() {
        try {
            List<Produit> rs = null;
            CrudProduit service = new CrudProduit();
            rs = service.AfficherCategorie();
            for (Produit c : rs) {
                Produit cr = new Produit();
                cr.setId_produit(c.getId_produit());
                cr.setNom(c.getNom());
                cr.setPrix(c.getPrix());
                cr.setQuantite(c.getQuantite());
                cr.setId_categorie(c.getId_categorie());
                data.add(cr);
                System.out.println("Table vien a etais recuperé avec succes !");
            }
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        tableview.setItems(data);
    }

    public void setsCllTable() {
        id_prod.setCellValueFactory(new PropertyValueFactory<>("id_produit"));
        nom_prod.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prix_prod.setCellValueFactory(new PropertyValueFactory<>("prix"));
        quant_prod.setCellValueFactory(new PropertyValueFactory<>("quantite"));
        desc_prod.setCellValueFactory(new PropertyValueFactory<>("description"));
        type_prod.setCellValueFactory(new PropertyValueFactory<>("id_categorie"));
    }
}
