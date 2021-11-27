/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blue.sky;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import javafx.scene.image.Image;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import oracle.jdbc.pool.OracleDataSource;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class FlightsController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TableView<Book> roundTrip;
     @FXML
    private TableColumn<Book, String> arrive;

    @FXML
    private TableColumn<Book, String> arriveDate;

    @FXML
    private TableColumn<Book, String> depart;

    @FXML
    private TableColumn<Book, String> departDate;
    
    ObservableList<Book> data  =FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         try {
        
        OracleDataSource ods = new OracleDataSource() ;
        ods.setURL("jdbc:oracle:thin:@localhost:1521:xe");
         ods.setUser("system");
                  ods.setPassword("Roa1234");
        Connection con = ods.getConnection();
        Statement stm = con.createStatement(); 
         String s = "select * from roundTrip where arrive='arrive' & depart='depart' ";
         ResultSet re = stm.executeQuery(s) ;
         while(re.next()){
         
        String depart = re.getString("depart");
        String arrive = re.getString("arrive");
        String departDate = re.getString("departDate");
        String arriveDate = re.getString("arriveDate");
      
        
       data.add(new Book(depart ,arrive,departDate , arriveDate ));
         }
            depart.setCellValueFactory( new PropertyValueFactory<Book, String>("depart"));
            arrive.setCellValueFactory( new PropertyValueFactory<Book, String>("arrive"));
            departDate.setCellValueFactory( new PropertyValueFactory<Book, String>("departDate"));
            arriveDate.setCellValueFactory( new PropertyValueFactory<Book, String>("arriveDate"));
        
            
               
               
                 roundTrip.setItems(data);
       } catch (Exception ex) {
           // Logger.getLogger(showProductsController.class.getName()).log(Level.SEVERE, null, ex);
               JOptionPane.showMessageDialog(null,ex,"Error",JOptionPane.ERROR_MESSAGE);
                               }
    }    
   @FXML
      private  void back(ActionEvent event) throws IOException {
        Parent tabelViewParent = FXMLLoader.load(getClass().getResource("URoundtrip.fxml"));//مكان ما بدي اروح
        Scene tabelViewScene = new Scene(tabelViewParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tabelViewScene);
        window.show();
    }
//     @FXML
//      private  void book(ActionEvent event) throws IOException {
//        Parent tabelViewParent = FXMLLoader.load(getClass().getResource("/clientpage/takeflight.fxml"));//مكان ما بدي اروح
//        Scene tabelViewScene = new Scene(tabelViewParent);
//
//        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
//        window.setScene(tabelViewScene);
//        window.show();
//    }
}
