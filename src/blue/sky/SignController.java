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
 * @author HP
 */
public class SignController implements Initializable {

    @FXML
    private DatePicker BirthDate;

    @FXML
    private TextField Email;

    @FXML
    private TextField FName;

    @FXML
    private RadioButton Gender;

    @FXML
    private TextField LName;

    @FXML
    private TextField PhoneNumber;

    @FXML
    private TextField country;

    @FXML
    private TextField creditcard;

    @FXML
    private PasswordField password;

    @FXML
    void signup(ActionEvent event) {

    }


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
        // TODO
         @FXML
         
         private  void signUp(ActionEvent event) throws IOException, SQLException {
             
         boolean flag1 = true,flag2=true,flag3=true , flag4=true,flag5=true,flag6=true,flag7=true ,flag8=true,flag9=true, loginFlag= false;
           
        if (FName.getText().equals("")|| FName.getText().equals(" "))
            flag1 = false ;
         if (LName.getText().equals("")|| LName.getText().equals(" "))
            flag2 = false ;
        if (Email.getText().equals("")|| Email.getText().equals(" "))
            flag3 = false ;
        if (BirthDate.getId().equals("")|| BirthDate.getId().equals(" "))
            flag4 = false ;
         if (password.getText().equals("")|| password.getText().equals(" "))
             flag5 = false ;
         if (PhoneNumber.getText().equals("")|| PhoneNumber.getText().equals(" "))
             flag6 = false ;
         if (creditcard.getText().equals("")|| creditcard.getText().equals(" "))
             flag7 = false ;
         if (country.getText().equals("")|| country.getText().equals(" "))
             flag8 = false ;
          if (Gender.getText().equals("")|| Gender.getText().equals(" "))
             flag9 = false ;
         
        if ( !(flag1&&flag2&&flag3&&flag4&&flag5&&flag6&&flag7&&flag8&&flag9) )
            {
          Alert alert = new Alert(Alert.AlertType.INFORMATION);                             
        alert.setTitle("Error message");                                                
        alert.setHeaderText("Empty box");                                         
        alert.setContentText("you have one box or more is empty");                         
        alert.showAndWait();
                
            }
         else if ((flag1&&flag2&&flag3&&flag4&&flag5&&flag6&&flag7&&flag8&&flag9) )
           {
         try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            String str = "jdbc:oracle:thin:@localhost:1521:xe" ;
            Connection con = DriverManager.getConnection(str ,"system" , "Roa1234" );
            Statement stm = con.createStatement();
       
            String FName = this.FName.getText();
            String LName = this.LName.getText() ;
            String Email= this.Email.getText();
            String BirthDate = this.BirthDate.getId();
            String password = this.password.getText();
            String PhoneNumber = this.PhoneNumber.getText() ;
            String creditcard=this.creditcard.getText();
            String country=this.country.getText();
            String Gender=this.Gender.getText();
            
            String str_st = "insert into CUSTOMER values( '"+FName+"','"+LName+"', '"+Email+"', '"+BirthDate+"','"+password+"','"+PhoneNumber+"', '"+creditcard+"','"+country+"','"+Gender+"')" ;
            
            stm.executeUpdate(str_st);
            
 //                 FName.setText("");
//                  LName.setText("");
//                  Email.setText("");
//                  password.setText("");
//                  country.setText("");
//                  PhoneNumber.setText("");
                  
       Parent tabelViewParent = FXMLLoader.load(getClass().getResource("BOOK.fxml"));//مكان ما بدي اروح
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
      private  void back(ActionEvent event) throws IOException {
        Parent tabelViewParent = FXMLLoader.load(getClass().getResource("log.fxml"));//مكان ما بدي اروح
        Scene tabelViewScene = new Scene(tabelViewParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tabelViewScene);
        window.show();
    }
}

