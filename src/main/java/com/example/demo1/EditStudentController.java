/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class EditStudentController implements Initializable {

    @FXML
    private PasswordField tf_newPassword;
    @FXML
    private TextField tf_Name;
    @FXML
    private TextField tf_lastPassword;

    

    Student s ; 
    @FXML
    private Label labelWorng;
    @FXML
    private Button onBackClick;
    @FXML
    private DatePicker BirthDay;
    @FXML
    private Button UPDATE;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    

   public void sendDataStudent(Student s){
       this.s = s ; 
        tf_Name.setText(s.getName()); 
   }

    @FXML
    private void onBackClickk(ActionEvent event) throws IOException {
            Node node = (Node)event.getSource() ; 
           Stage stage  = (Stage)node.getScene().getWindow() ; 
           stage.close();
           FXMLLoader loader = new  FXMLLoader(getClass().getResource("stedntScreen.fxml"));
           Parent root = loader.load(); 
           stage.setScene( new Scene(root));
           stage.show();
    }

    @FXML
    public void onUpdateClick(ActionEvent actionEvent) {
        if(tf_lastPassword.getText().equals(s.getPassword())){
            s.setPassword(tf_newPassword.getText());
            s.setBirthday(BirthDay.getValue());
            s.setName(tf_Name.getText());
            labelWorng.setText("Done");
        }
        else{
            labelWorng.setText("Last User Name Wrong !!");
        }

    }
}
