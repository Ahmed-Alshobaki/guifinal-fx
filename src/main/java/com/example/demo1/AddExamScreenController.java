
package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;


public class AddExamScreenController implements Initializable {

    @FXML
    private TextField tf_ExamName;
    @FXML
    private TextField tf_noOfQ;
    @FXML
    private TextField tf_minPass;
    @FXML
    private CheckBox yesNo;
    @FXML
    private CheckBox mc;
    @FXML
    private CheckBox ftb;
    int a;

    public static ArrayList<Question> questionOfExam = new ArrayList <>() ;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    }    

    @FXML
    private void onAddClick(ActionEvent event) {

          Random r = new Random () ; 
          Exam exam = new Exam ();  
        exam.setBaseId(Exam.id);
        exam.setName(tf_ExamName.getText());
        exam.setNumberOfQuestion(Integer.parseInt(tf_noOfQ.getText()));
        exam.setMinPassAverage(Integer.parseInt(tf_minPass.getText()));
       
        if(yesNo.isSelected()){
            exam.setAllowedQuestionsType("Yes-NO Question");

        }
        if(mc.isSelected()){
             exam.setAllowedQuestionsType("MultipleChoiceQuestion");

        }
         if(ftb.isSelected()){
             exam.setAllowedQuestionsType("Fill The Blank");


        }

   
         for (int i = 0; i < Util.allQuestionsList.size(); i++) {
              int random = r.nextInt(Util.allQuestionsList.size());
              if (exam.getAllowedQuestionsType().contains(Util.allQuestionsList.get(random).getType()) ) {
                 a+= Util.allQuestionsList.get(random).getMarks();


                 questionOfExam.add(Util.allQuestionsList.get(random));
                  exam.setExamQuestions(questionOfExam);
                  Util.exam.setQuestions(questionOfExam);
                  Util.exam.setExamQuestions(Util.allQuestionsList);
                  Util.questionOfExam.add(Util.allQuestionsList.get(random));


             
        }


         }
         exam.setFullMark(6);

        exam.setTotalMarks(a);
        Util.exams.add(exam);

        Util.setExam(exam);

        for (int i = 0; i <    questionOfExam.size(); i++) {
            System.out.println(  questionOfExam.get(i).toString());
        }
           Exam.id++;
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
    public void sendExamData(){
        
    }
    
}
