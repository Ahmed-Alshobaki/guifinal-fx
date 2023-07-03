/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ViewAllQuestionScreenController implements Initializable {

    @FXML
    private TableView<Question> table_veiwAllQuestion;
    @FXML
    private TableColumn<Question, Integer> col1;
    @FXML
    private TableColumn<Question, String> col2;
    @FXML
    private TableColumn<Question, String> col3;
    @FXML
    private TableColumn<Question, Integer> col4;
    @FXML
    private Button Back;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
       sendData();
    }    
    public void sendData(){
          col1.setText("ID");
            col2.setText("Question");
             col3.setText("Asnwer");
            col4.setText("Marks");
            ObservableList<Question> q = FXCollections.observableArrayList();
            q.addAll(Util.allQuestionsList );
            col1.setCellValueFactory(new PropertyValueFactory<Question, Integer>("BaseId"));
              col2.setCellValueFactory(new PropertyValueFactory<Question, String>("question"));
              col3.setCellValueFactory(new PropertyValueFactory<Question, String>("type"));
               col4.setCellValueFactory(new PropertyValueFactory<Question, Integer>("marks"));
               table_veiwAllQuestion.setItems(q);
    }
 
    @FXML
    private void editQuestions(MouseEvent event) throws IOException {
       Question question =  table_veiwAllQuestion.getSelectionModel().getSelectedItem(); 
       if(question.getType().equals("Yes-NO Question")){
           if(question instanceof YesNoQuestion){
                           Node node = (Node)event.getSource() ; 
           Stage stage  = (Stage)node.getScene().getWindow() ; 
           stage.close();
           FXMLLoader loader = new  FXMLLoader(getClass().getResource("addQuestionScreen.fxml"));
           Parent root = loader.load();
           AddQuestionScreenController a = loader.getController();
           a.sendEdit(1);
           a.sendData(question);
           stage.setScene( new Scene(root));
           stage.show();
           }
       }
         if(question.getType().equals("multipleChoiceQuestionScreen")){
           if(question instanceof MultipleChoiceQuestion){
                           Node node = (Node)event.getSource() ; 
           Stage stage  = (Stage)node.getScene().getWindow() ; 
           stage.close();
           FXMLLoader loader = new  FXMLLoader(getClass().getResource("addmultipleChoiceQuestionScreen.fxml"));
           Parent root = loader.load();
           AddmultipleChoiceQuestionScreenController a = loader.getController();
           a.sendEdit(1);
           a.sendData(question);
           stage.setScene( new Scene(root));
           stage.show();
           }
       }
         
         
           if(question.getType().equals("Fill The Blank")){
           if(question instanceof YesNoQuestion){
                           Node node = (Node)event.getSource() ; 
           Stage stage  = (Stage)node.getScene().getWindow() ; 
           stage.close();
           FXMLLoader loader = new  FXMLLoader(getClass().getResource("FillTheBlankQuestionScreenController.fxml"));
           Parent root = loader.load();
           AddQuestionScreenController a = loader.getController();
           a.sendData(question);
           stage.setScene( new Scene(root));
           Util.allQuestionsList.remove(question);
           stage.show();
           }
       }
    }

    @FXML
    public void Back_ac(ActionEvent actionEvent) throws IOException {
        Node node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("TeacherScreen.fxml"));
        Parent root = loader.load();
        TeacherScreenController c = loader.getController();

        stage.setScene(new Scene(root));
        stage.setTitle("Teacher Screen");
        stage.show();
    }
}
