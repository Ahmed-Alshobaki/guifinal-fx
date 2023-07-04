package com.example.demo1;

import javafx.event.Event;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class exam_result_details implements Initializable {
    Exam exam =Util.getExam();

    @javafx.fxml.FXML
    private Label text;
    String z;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        for (int i = 0; i < Util.exam.getQuestions().size(); i++) {
            text.setText(Util.exam.getQuestions().get(i).getQuestion());
        }

        for (int i = 0; i < exam.getExamQuestions().size(); i++) {
           z +="\n"+exam.getExamQuestions().get(i).getQuestion()+"-----"+exam.getExamQuestions().get(i).getAnswer();
            text.setText(z);
        }



    }

    @Deprecated
    public void textArea(Event event) {

    }
}
