/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blue.sky;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import oracle.jdbc.pool.OracleDataSource;
import cc.c2.*;




/**
 * FXML Controller class
 *
 * @author HP
 */
public class LogController implements Initializable {

    
    /**
     * Initializes the controller class.
     */
    
     String email = "MOHAMMAD@gmail.com";
     String password= "mohamadd123";  
    
    
     @FXML
    private TextField Email;

     @FXML
    private PasswordField PASS;
     
    @FXML
    private ComboBox<String> combobox;
   
     ObservableList<String> list=FXCollections.observableArrayList("Admin","Client") ;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        combobox.setItems(list);
    }    
    @FXML
        private  void handelButtonAction(ActionEvent event) throws IOException, SQLException {
            
                   
         
             boolean flag = false ;

             String s=combobox.getSelectionModel().getSelectedItem().toString();
              if(s== "Admin"){
                  
              
       

                
       if (email.equals( Email.getText())&& password .equals(PASS.getText())) {
            
            Parent tabelViewParent = FXMLLoader.load(getClass().getResource("adminpage.fxml"));//مكان ما بدي اروح
         Scene tabelViewScene = new Scene(tabelViewParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tabelViewScene);
        window.show();
                
       } else{
             JOptionPane.showMessageDialog(null,"Incorrect username or password ,please try again");
         }
      
               
            
                               }
             
          
        
          
       else  if (s == "Client"){
               try {
           
        
        OracleDataSource ods = new OracleDataSource() ;
        
        ods.setURL("jdbc:oracle:thin:@localhost:1521:xe");
        ods.setUser("system");
        ods.setPassword("Roa1234");
        Connection con = ods.getConnection();
        //JOptionPane.showMessageDialog(null, "Connection Established Successfully");
        Statement stmt=con.createStatement();
         String x = "select password from account where Email='" +Integer.parseInt( Email.getText()) + "'";
         ResultSet re = stmt.executeQuery(x) ;
      
      while(re.next()){
       
   
      
               if (re.getString("PASS").equals(PASS.getText())) {
                   cc.c2.user=Integer.parseInt( Email.getText());
                   Parent tabelViewParent = FXMLLoader.load(getClass().getResource("customerhome.fxml"));//مكان ما بدي اروح
        Scene tabelViewScene = new Scene(tabelViewParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tabelViewScene);
        window.show();
               }
               else{
             JOptionPane.showMessageDialog(null,"Incorrect username or password ,please try again");
         }
                   
               }
               
                }catch (Exception ex) {
           JOptionPane.showMessageDialog(null,ex,"Error",JOptionPane.ERROR_MESSAGE);
            
                               }
           }} 

   @FXML
      private  void Signup(ActionEvent event) throws IOException {
          
        Parent tabelViewParent = FXMLLoader.load(getClass().getResource("sign.fxml"));//مكان ما بدي اروح
        Scene tabelViewScene = new Scene(tabelViewParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tabelViewScene);
        window.show();
        
    }
     
      
}
