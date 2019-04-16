/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.MCommunication;

import crud.MCommunication.Crud_Comment;
import entities.MCommunication.Blog_Post;
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
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import techniques.DateConverter;

/**
 * FXML Controller class
 *
 * @author kratos
 */
public class BlogController implements Initializable {

    @FXML
    private ImageView blogImg;
    @FXML
    private Label title;
    @FXML
    private Label createdAt;
    @FXML
    private Label category;
    @FXML
    private Button readMore;
    @FXML
    private Label CommentsCount;
    @FXML
    private TextArea body;
    private Crud_Comment cc = new Crud_Comment();
    private Blog_Post blog ;
    public static BorderPane homeBorderPane;
    private BorderPane hbPane ;
    public void setBlog(Blog_Post blog) {
        this.blog = blog;
    }

    
  

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        hbPane = homeBorderPane;
    }    
    public void init()
    {
     
        title.setText(blog.getTitle());
        createdAt.setText(DateConverter.Date_To_String(blog.getCreated_at()));
        category.setText(blog.getCategoryName());
        body.setText(blog.getBody());
        blogImg.setImage(new Image ("/other/img/"+blog.getImg()));
        
        CommentsCount.setText(""+cc.commentsCount(blog.getId()));
    }
    @FXML
    private void readMoreAction(ActionEvent event) {
        Blog_DetailController.blog = blog ;
        LooadUI("/views/MCommunication/Blog_Detail");
    }
    
    
   private void LooadUI(String ui)
    {
        Parent root=null;
        try {
            root=FXMLLoader.load(getClass().getResource(ui+".fxml"));
            
        } catch (IOException ex) {System.err.println(ex.getMessage());     }
        hbPane.setCenter(root);
    }
    
}
