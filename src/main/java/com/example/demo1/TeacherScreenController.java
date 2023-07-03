
package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class TeacherScreenController implements Initializable {

    @FXML
    private Label lbl_welcome;
   Person p = new Person();
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    Teacher t = new Teacher (); 

    @FXML
    private void onAddStudentClick(ActionEvent event) throws IOException {
          Node node = (Node)event.getSource() ; 
           Stage stage  = (Stage)node.getScene().getWindow() ; 
           stage.close();
           FXMLLoader loader = new  FXMLLoader(getClass().getResource("addStudentScreen.fxml"));
           Parent root = loader.load();
            AddStudentScreenController a = loader.getController();
           a.sendData(t);
           stage.setScene( new Scene(root));
           stage.show();
    }
    

    @FXML
    private void onViewStudentClick(ActionEvent event) throws IOException {
            Node node = (Node)event.getSource() ; 
           Stage stage  = (Stage)node.getScene().getWindow() ; 
           stage.close();
           FXMLLoader loader = new  FXMLLoader(getClass().getResource("ViewAllTeacher.fxml"));
           Parent root = loader.load(); 
           ViewAllTeacherController control = loader.getController();
           control.sendDataForTable(1);
           stage.setScene( new Scene(root));
           stage.setTitle("Admin Screen");
           stage.show();
    }

    @FXML
    private void onAddQusetionClick(ActionEvent event) throws IOException {
           Node node = (Node)event.getSource() ; 
           Stage stage  = (Stage)node.getScene().getWindow() ; 
           stage.close();
           FXMLLoader loader = new  FXMLLoader(getClass().getResource("tybeQuestionScreen.fxml"));
           Parent root = loader.load(); 
           stage.setScene( new Scene(root));
           stage.setTitle("Type Question Screen");
           stage.show();
    }

    @FXML
    private void OnViewAllQuestionClick(ActionEvent event) throws IOException {
           Node node = (Node)event.getSource() ; 
           Stage stage  = (Stage)node.getScene().getWindow() ; 
           stage.close();
           FXMLLoader loader = new  FXMLLoader(getClass().getResource("viewAllQuestionScreen.fxml"));
           Parent root = loader.load(); 
           stage.setScene( new Scene(root));
           stage.setTitle("view Question Screen");
           stage.show();
    }

    @FXML
    private void onAddExamClick(ActionEvent event) throws IOException {
         Node node = (Node)event.getSource() ; 
           Stage stage  = (Stage)node.getScene().getWindow() ; 
           stage.close();
           FXMLLoader loader = new  FXMLLoader(getClass().getResource("addExamScreen.fxml"));
           Parent root = loader.load(); 
           stage.setScene( new Scene(root));
           stage.setTitle("Add Exam Screen");
           stage.show();
    }

    @FXML
    private void onViewAllExamClick(ActionEvent event) throws IOException {
        
                  Node node = (Node)event.getSource() ; 
           Stage stage  = (Stage)node.getScene().getWindow() ; 
           stage.close();
           FXMLLoader loader = new  FXMLLoader(getClass().getResource("viewAllExam.fxml"));
           Parent root = loader.load(); 
            ViewAllExamController v = loader.getController();
           v.sendData(t);
           stage.setScene( new Scene(root));
           stage.setTitle("Add Exam Screen");
           stage.show();
    }

    @FXML
    private void onBackClik(ActionEvent event) throws IOException {
        
        if(this.t instanceof Teacher){
               Node node = (Node)event.getSource() ; 
           Stage stage  = (Stage)node.getScene().getWindow() ; 
           stage.close();
           FXMLLoader loader = new  FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
           Parent root = loader.load(); 
           stage.setScene( new Scene(root));
           stage.show();
        }
     
    }
    public void sendData(String username){
        lbl_welcome.setText("Welcome "+username);
    }
     public void sendData(Teacher t){
         this.t = t ; 
     }
    // public void sendDataExam(Person p){
     //    this.p = p ; 
   //  }
}
