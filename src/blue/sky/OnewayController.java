/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blue.sky;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.awt.Checkbox;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author Mass
 */

public class OnewayController implements Initializable {

    /**
     * Initializes the controller class.
     */
      @FXML
    private TextField arrive;

    @FXML
    private TextField cabin;

    @FXML
    private DatePicker departdate;

    @FXML
    private TextField dpart;

    @FXML
    private TextField travelers;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    @FXML
         
         private  void search(ActionEvent event) throws IOException, SQLException {
        boolean flag1 = true,flag2=true,flag3=true ;
        if ((flag1&&flag2&&flag3) )
           {
         try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            String str = "jdbc:oracle:thin:@localhost:1521:xe" ;
            Connection con = DriverManager.getConnection(str ,"system" , "Roa1234" );
            Statement stm = con.createStatement();
       
            String FName = this.dpart.getText();
            String LName = this.arrive.getText() ;
            String BirthDate = this.departdate.getId();
            
            
            String str_st = "insert into oneWaysearch values( '"+dpart+"','"+arrive+"', '"+departdate+"')" ;
            
            stm.executeUpdate(str_st);
        
         Parent tabelViewParent = FXMLLoader.load(getClass().getResource("oneflight.fxml"));//مكان ما بدي اروح
       Scene tabelViewScene = new Scene(tabelViewParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tabelViewScene);
       window.show();
    }
     catch (Exception ex) {
           JOptionPane.showMessageDialog(null, ex.toString());
        //   JOptionPane.showMessageDialog(null,ex,"Error",JOptionPane.ERROR_MESSAGE);
           
                   }
           }
        else 
           {
                 Alert alert = new Alert(Alert.AlertType.INFORMATION);                                           
        alert.setTitle("Error message");                                               
        alert.setHeaderText("there is an issue");                                                             
       // alert.setContentText("The password and repeated password doesn't same !");                         
        alert.showAndWait(); 
        JOptionPane.showMessageDialog(null,"Registering done .. welcome!");
           }
      }
         @FXML
      private  void back1(ActionEvent event) throws IOException {
        Parent tabelViewParent = FXMLLoader.load(getClass().getResource("oneway.fxml"));//مكان ما بدي اروح
        Scene tabelViewScene = new Scene(tabelViewParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tabelViewScene);
        window.show();
    }
}

    

