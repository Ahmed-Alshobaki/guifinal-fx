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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AdminSecreanController implements Initializable {

    @FXML
    private Label Welcomelbl;
    @FXML
    private Button btn_ViewAllTeacher;
    @FXML
    private Button btn_AddTeacher;
    @FXML
    private Button backButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ViewAllTeacher(ActionEvent event) throws IOException {
          Node node = (Node)event.getSource() ; 
           Stage stage  = (Stage)node.getScene().getWindow() ; 
           stage.close();
           FXMLLoader loader = new  FXMLLoader(getClass().getResource("ViewAllTeacher.fxml"));
           Parent root = loader.load(); 
           ViewAllTeacherController control = loader.getController();
           control.sendDataForTable(0);
           stage.setScene( new Scene(root));
           
           stage.setTitle("Admin Screen");
           stage.show();
    }

    @FXML
    private void addTeacher(ActionEvent event) throws IOException {
          Node node = (Node)event.getSource() ; 
           Stage stage  = (Stage)node.getScene().getWindow() ; 
           stage.close();
           FXMLLoader loader = new  FXMLLoader(getClass().getResource("AddTeacherScreen.fxml"));
           Parent root = loader.load();    
           stage.setScene( new Scene(root));
           stage.show();
    }

    @FXML
    private void btn_addStudent(ActionEvent event) throws IOException {
         Node node = (Node)event.getSource() ; 
           Stage stage  = (Stage)node.getScene().getWindow() ; 
           stage.close();
           FXMLLoader loader = new  FXMLLoader(getClass().getResource("addStudentScreen.fxml"));
           Parent root = loader.load();    
           stage.setScene( new Scene(root));
           stage.show();
    }

    @FXML
    private void btn_ViewAllStudent(ActionEvent event) throws IOException {
         Node node = (Node)event.getSource() ; 
           Stage stage  = (Stage)node.getScene().getWindow() ;
           stage.close();
           FXMLLoader loader = new  FXMLLoader(getClass().getResource("ViewAllStudent.fxml"));
           Parent root = loader.load(); 

           stage.setScene( new Scene(root));
           stage.setTitle("Admin Screen");
           stage.show();
    }
   // ViewAllTeacherController control = loader.getController();
     //      control.sendDataForTable(1);
    @FXML
    private void onClickBack(ActionEvent event) throws IOException {
         Node node = (Node)event.getSource() ; 
           Stage stage  = (Stage)node.getScene().getWindow() ; 
           stage.close();
           FXMLLoader loader = new  FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
           Parent root = loader.load(); 
           stage.setScene( new Scene(root));
           stage.setTitle("Admin Screen");
           stage.show();
    }
    public void sendDat(String username){
        Welcomelbl.setText("Welcome "+ username);
    }
  
}
