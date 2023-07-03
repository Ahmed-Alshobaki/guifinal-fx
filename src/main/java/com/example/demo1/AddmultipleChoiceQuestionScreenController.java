
package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class AddmultipleChoiceQuestionScreenController implements Initializable {

    @FXML
    private Button OnBackClick;
    @FXML
    private TextField tf_Question;
    @FXML
    private TextField tf_mark;
    @FXML
    private TextField tf_AnwerNO1;
    @FXML
    private TextField tf_AnwerNO2;
    @FXML
    private TextField tf_AnwerNO3;
    @FXML
    private ChoiceBox<Integer> TrueAnserCH;
    @FXML
    private TextField tf_AnwerNO4;
    @FXML
    private TextField tf_AnwerNO5;
    @FXML
    private CheckBox ch_an1;
    @FXML
    private CheckBox ch_an2;
    @FXML
    private CheckBox ch_an3;
    @FXML
    private CheckBox ch_an4;
    @FXML
    private CheckBox ch_an5;
    boolean a1 =true;
    boolean a2 =true;

   
    MultipleChoiceQuestion m ;
    int edit ; 
      ArrayList <String> choises = new ArrayList <>();
      ArrayList <Integer> answer = new ArrayList <>();

    @FXML
    private Button ADd;
    @FXML
    private Label text;

    @Override
    
    public void initialize(URL url, ResourceBundle rb) {



    }    


    @FXML
    private void onBackClick(ActionEvent event) throws IOException {
         Node node = (Node)event.getSource() ; 
           Stage stage  = (Stage)node.getScene().getWindow() ; 
           stage.close();
           FXMLLoader loader = new  FXMLLoader(getClass().getResource("TeacherScreen.fxml"));
           Parent root = loader.load();    
           stage.setScene( new Scene(root));
           stage.show();
    }
 

    @FXML
    private void showAnswers(MouseEvent event) {
        TrueAnserCH.getItems().clear();

        TrueAnserCH.getItems().addAll(answer);
    }






    @FXML
    private void selested3(MouseEvent event) {
         if(ch_an3.isSelected()){
          tf_AnwerNO3.setDisable(false);
           choises.add(tf_AnwerNO3.getText());
            answer.add(3);
      }
    }

    @FXML
    private void selested4(MouseEvent event) {
           if(ch_an4.isSelected()){
          tf_AnwerNO4.setDisable(false);
          choises.add(tf_AnwerNO4.getText());
            answer.add(4);
           
      }  
    }

    @FXML
    private void selested5(MouseEvent event) {
      if(ch_an5.isSelected()){
          tf_AnwerNO5.setDisable(false);
             choises.add(tf_AnwerNO5.getText());
            answer.add(5);
           
      }

    }
    
    public void sendData(Question q  ){
      if(edit == 1 ){
          this.m = (MultipleChoiceQuestion)q ; 
           tf_Question.setText(q.getQuestion());
       tf_mark.setText(String.valueOf(q.getMarks()));
      }
       
       
    }
    public void sendEdit(int t){
        this.edit = t ; 
    }

    @FXML
    public void selested1(Event event) {
        if(ch_an1.isSelected()){
            tf_AnwerNO1.setDisable(false);
            choises.add(tf_AnwerNO1.getText());
            for (int i = 0; i < answer.size(); i++) {
                if (1==answer.get(i)){
                    a1=false;
                }

            }
            if (a1){
                answer.add(1);
            }
        }
    }

    @FXML
    public void selested2(Event event) {
        if(ch_an2.isSelected()){
            tf_AnwerNO2.setDisable(false);
            choises.add(tf_AnwerNO2.getText());
            for (int i = 0; i < answer.size(); i++) {
                if (2==answer.get(i)){
                    a2=false;
                }
                if (a2){
                    answer.add(2);
                }
            }


        }
    }

    @FXML
    public void onAddClick(ActionEvent actionEvent) {
        if(edit == 1){
            m.setQuestion(tf_Question.getText());
            m.setChoices(choises);
            m.setAsnwer(TrueAnserCH.getValue());
            m.setMarks(Integer.parseInt(tf_mark.getText()));

        }
        else{
            MultipleChoiceQuestion mcq = new MultipleChoiceQuestion () ;
            mcq.setBaseId(Question.id);
            mcq.setType("multipleChoiceQuestionScreen");
            mcq.setQuestion(tf_Question.getText());
            mcq.setChoices(choises);
            mcq.setAsnwer(TrueAnserCH.getValue());
            mcq.setMarks(Integer.parseInt(tf_mark.getText()));
            Util.allQuestionsList.add(mcq);
            Question.id++;
            System.out.println(mcq.toString());
            text.setTextFill(Color.web("#19ff00"));
            text.setText("Done !");
        }

    }

    @FXML
    public void showAnswers1(Event event) {
        TrueAnserCH.getItems().clear();

        TrueAnserCH.getItems().addAll(answer);
    }

    @FXML
    public void showAnswers2(Event event) {
        TrueAnserCH.getItems().clear();

        TrueAnserCH.getItems().addAll(answer);
    }
}
