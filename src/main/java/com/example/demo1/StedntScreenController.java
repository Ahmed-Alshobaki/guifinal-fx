
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


public class StedntScreenController implements Initializable {

    @FXML
    private Label lbl_welcome;
    @FXML
    private Button examResultsE;
    @FXML
    private Button SolveExam;
    @FXML
    private Button Edit_Information;
    @FXML
    private Button examResultsdetails;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    
Student stud ; 



    public  void sendDtata(Student s) {
        this.stud = s ; 
    }

    @FXML
    public void examResultsE(ActionEvent actionEvent) throws IOException {

        Node node = (Node)actionEvent.getSource() ;
        Stage stage  = (Stage)node.getScene().getWindow() ;
        stage.close();
        FXMLLoader loader = new  FXMLLoader(getClass().getResource("examResultsE.fxml"));
        Parent root = loader.load();

        stage.setScene( new Scene(root));
        stage.show();
    }

    public void onBackClickk(ActionEvent actionEvent) throws IOException {
        Node node = (Node)actionEvent.getSource() ;
        Stage stage  = (Stage)node.getScene().getWindow() ;
        stage.close();
        FXMLLoader loader = new  FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
        Parent root = loader.load();
        stage.setScene( new Scene(root));
        stage.show();
    }





    @FXML
    public void Solve(ActionEvent actionEvent) throws IOException {

        Student s = new Student ();
        Node node = (Node)actionEvent.getSource() ;
        Stage stage  = (Stage)node.getScene().getWindow() ;
        stage.close();
        FXMLLoader loader = new  FXMLLoader(getClass().getResource("SolveExamPage.fxml"));
        Parent root = loader.load();
        stage.setScene( new Scene(root));
        stage.show();
    }

    @FXML
    public void Edit_Information(ActionEvent actionEvent) throws IOException {
        Node node = (Node)actionEvent.getSource() ;
        Stage stage  = (Stage)node.getScene().getWindow() ;
        stage.close();
        FXMLLoader loader = new  FXMLLoader(getClass().getResource("editStudent.fxml"));
        Parent root = loader.load();
        EditStudentController a = loader.getController();
        a.sendDataStudent(stud);
        stage.setScene( new Scene(root));
        stage.show();
    }

    @FXML
    public void examResultsdetails(ActionEvent actionEvent) throws IOException {
        Node node = (Node)actionEvent.getSource() ;
        Stage stage  = (Stage)node.getScene().getWindow() ;
        stage.close();
        FXMLLoader loader = new  FXMLLoader(getClass().getResource("exam_result_details.fxml"));
        Parent root = loader.load();

        stage.setScene( new Scene(root));
        stage.show();
    }
}
