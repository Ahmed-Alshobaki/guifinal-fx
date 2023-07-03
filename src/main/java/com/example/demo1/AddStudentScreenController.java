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
import javafx.scene.control.*;
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
public class AddStudentScreenController implements Initializable {

    @FXML
    private ToggleGroup Gender;
    @FXML
    private PasswordField tf_PaswwordStudent;
    @FXML
    private TextField td_UserNameStudent;
    @FXML
    private TextField tf_NameStudent;

    Person person = new Person();
    Admin student ; 

    @FXML
    private Button btn_Back;
    @FXML
    private RadioButton male;
    @FXML
    private RadioButton fmale;
    @FXML
    private DatePicker Birthday;
    @FXML
    private Button onAddClick;
    @FXML
    private Label id_text;
    @FXML
    private Label aa;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    


    @FXML
    private void onBackClick(ActionEvent event) throws IOException {
        
        if(person instanceof Teacher){
            Node node = (Node)event.getSource() ; 
           Stage stage  = (Stage)node.getScene().getWindow() ; 
           stage.close();
           FXMLLoader loader = new  FXMLLoader(getClass().getResource("TeacherScreen.fxml"));
           Parent root = loader.load();    
           stage.setScene( new Scene(root));
           stage.show();
        }
        else{
             Node node = (Node)event.getSource() ; 
           Stage stage  = (Stage)node.getScene().getWindow() ; 
           stage.close();
           FXMLLoader loader = new  FXMLLoader(getClass().getResource("adminSecrean.fxml"));
           Parent root = loader.load();    
           stage.setScene( new Scene(root));
           stage.show();
        }
       
    }
    public void sendData(Person p){
         this.person = p ;
    }
    public void sendStudentData (Admin s){
        this.student = s ; 
    }

    @FXML
    public void onAddClickk(ActionEvent actionEvent) {
        if(student instanceof Student){
            td_UserNameStudent.setText(student.getUsername());
            tf_PaswwordStudent.setText(student.getPassword());
            tf_NameStudent.setText(student.getName());


        }
        Boolean bo =true;
        for (int i = 0; i < Util.users.size(); i++) {
            if (td_UserNameStudent.getText().equals(Util.users.get(i).getUsername())){
                aa.setText("Frequent UserName");
                bo=false;


            }

        }
        if (bo){
            Student s = new Student ();
            s.setBaseunivarsityId(Student.univarsityId);
            s.setUsername(td_UserNameStudent.getText());
            s.setPassword(tf_PaswwordStudent.getText());
            s.setName(tf_NameStudent.getText());
            if(male.isSelected()){
                s.setGender(male.getText());
            }
            else if(fmale.isSelected()){
                s.setGender(fmale.getText());
            }
            s.setBirthday(Birthday.getValue());

            Util.studentArrayList.add(s);

            Student.univarsityId++;
            Util.users.add(s);

            aa.setTextFill(Color.web("#19ff00"));
            aa.setText("Done ! Student Added");
        }



    }
}
