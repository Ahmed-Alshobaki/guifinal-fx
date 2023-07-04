/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class GuiFinal extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
       stage.setTitle("Login");
        stage.show();
        
    }
    
    public static void main(String[] args) {
        Exam exam = new Exam() ;
        ArrayList<Question>list =new ArrayList<>();
        YesNoQuestion question =new YesNoQuestion();
        question.setQuestion("ahmed");
        question.setBaseId(1);

        question.setAnswer("zon?");
        question.setType("Yes-NO Question");
        question.setMarks(5);
        question.setBaseId(1);
        YesNoQuestion question2 =new YesNoQuestion();
        question2.setQuestion("ahmed");
        question2.setAnswer("zon?");
        question2.setType("Yes-NO Question");
        question2.setMarks(5);
        question.setBaseId(1);
        YesNoQuestion question3 =new YesNoQuestion();
        question3.setQuestion("ahmed");
        question3.setAnswer("zon?");
        question3.setType("Yes-NO Question");
        question.setBaseId(1);
        question3.setMarks(5);

        list.add(question);
        list.add(question2);
        list.add(question3);
        Util.questionOfExam.add(question2);
        Util.questionOfExam.add(question);
        Util.questionOfExam.add(question3);


        Util.allQuestionsList.add(question);
        Util.allQuestionsList.add(question2);
        Util.allQuestionsList.add(question3);
        exam.setExamQuestions(list);

        exam.setQuestions(list);
        exam.setExamQuestions(list);

        exam.setExamQuestions(list);
        exam.setFullMark(55);
        Util.exams.add(exam);
        Util.exam.setQuestions(list);
        Util.exam.setExamQuestions(list);



        Util.setExam(exam);
        Student student =new Student();
        Teacher teacher =new Teacher();
        student.setUsername("2");
        student.setPassword("2");
        teacher.setUsername("1");
        teacher.setPassword("1");
        Util.users.add(student);
        Util.users.add(teacher);

        Util.teacherList.add(teacher);
        Util.studentArrayList.add(student);
        launch(args);
        
    }
    public Stage SwitchScreen(ActionEvent event , String fxml , String title) throws IOException{
          Node node = (Node)event.getSource() ; 
           Stage stage  = (Stage)node.getScene().getWindow() ; 
           stage.close();
           FXMLLoader loader = new  FXMLLoader(getClass().getResource(fxml));
           Parent root = loader.load(); 
           stage.setScene( new Scene(root));
           stage.setTitle(title);
           stage.show();
           return stage ; 
    }
}
