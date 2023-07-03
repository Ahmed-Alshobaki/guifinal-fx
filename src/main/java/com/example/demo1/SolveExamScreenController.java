/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo1;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class SolveExamScreenController implements Initializable {

    @FXML
    private RadioButton r_true;
    @FXML
    private ToggleGroup asnwer;
    @FXML
    private RadioButton r_false;
    @FXML
    private Label lbl_question;
Person p = new Person();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    } 
    public void sendData(Question q){
        lbl_question.setText(q.getQuestion());
        
    }
     public void SendData(Person p){
        this.p = p;
    }
}
