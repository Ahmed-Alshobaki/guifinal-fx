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
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class FillTheBlankQuestionScreenController implements Initializable {

    @FXML
    private TextField tf_Question;
    @FXML
    private TextField tf_Mark;
    @FXML
    private TextField tf_Answer;
    @FXML
    private Button Add;
    @FXML
    private Button back;
    @FXML
    private Label text;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
    }    


//    public void SendData(Question q){
//        tf_Question.setText(q.getQuestion());
//        tf_Mark.setText(String.valueOf(q.getMarks()));
//    }

    @FXML
    public void ADd_ac(ActionEvent actionEvent) {
        FillTheBlankQuestion ftbq = new FillTheBlankQuestion () ;

        ftbq.setType("Fill The Blank");
        ftbq.setBaseId(Question.id);
        ftbq.setQuestion(tf_Question.getText());
        ftbq.setMarks(Integer.parseInt(tf_Mark.getText()));
        ftbq.setAnswer(tf_Answer.getText()) ;
        Util.allQuestionsList.add(ftbq);
        Question.id++;
        text.setTextFill(Color.web("#19ff00"));
        text.setText("Done !");
    }

    @FXML
    public void back_ac(ActionEvent actionEvent) throws IOException {
        Node node = (Node)actionEvent.getSource() ;
        Stage stage  = (Stage)node.getScene().getWindow() ;
        stage.close();
        FXMLLoader loader = new  FXMLLoader(getClass().getResource("TeacherScreen.fxml"));
        Parent root = loader.load();
        stage.setScene( new Scene(root));
        stage.show();
    }
}
