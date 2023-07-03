
package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class TybeQuestionScreenController implements Initializable {

    @FXML
    private ChoiceBox<String> ChoiseTypeOfQuestion;
    @FXML
    private Button btn_back;
    @FXML
    private Button btn_Next;
    @FXML
    private Label erorlbl;

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       ArrayList <String> types = new ArrayList<>();
       types.add("Yes-No Question");
       types.add("Multiple Choice Question");
       types.add("FillTheBlankQuestion");
       ChoiseTypeOfQuestion.getItems().addAll(types);
    }    

    @FXML
    private void onBackButton(ActionEvent event) throws IOException {
        Node node = (Node)event.getSource() ;
        Stage stage  = (Stage)node.getScene().getWindow() ;
        stage.close();
        FXMLLoader loader = new  FXMLLoader(getClass().getResource("TeacherScreen.fxml"));
        Parent root = loader.load();
        stage.setScene( new Scene(root));
        stage.show();

    }

    @FXML
    private void OnNextButton(ActionEvent event) throws IOException {
        if(ChoiseTypeOfQuestion.getValue()!=null){
            
            switch(ChoiseTypeOfQuestion.getValue()){
                case "Yes-No Question" : 
                     Node node = (Node)event.getSource() ; 
           Stage stage  = (Stage)node.getScene().getWindow() ; 
           stage.close();
           FXMLLoader loader = new  FXMLLoader(getClass().getResource("addQuestionScreen.fxml"));
           Parent root = loader.load();    
           stage.setScene( new Scene(root));
           stage.show();
           
                     break ;  
                case "Multiple Choice Question" :     
            node = (Node)event.getSource() ; 
            stage  = (Stage)node.getScene().getWindow() ; 
            stage.close();
             loader = new  FXMLLoader(getClass().getResource("addmultipleChoiceQuestionScreen.fxml"));
             root = loader.load();   
                    System.out.println("aa");
            stage.setScene( new Scene(root));
            stage.show();
                      break ;  
                      
                 case "FillTheBlankQuestion" :  
                       node = (Node)event.getSource() ; 
            stage  = (Stage)node.getScene().getWindow() ; 
            stage.close();
             loader = new  FXMLLoader(getClass().getResource("FillTheBlankQuestionScreen.fxml"));
             root = loader.load();    
            stage.setScene( new Scene(root));
            stage.show();
                      break ;  
                        
            }
            
        }
        else{
            erorlbl.setText("Please Choise One!");
        }
    }
    
}
