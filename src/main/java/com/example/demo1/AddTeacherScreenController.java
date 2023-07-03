
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


public class AddTeacherScreenController implements Initializable {

    @FXML
    private TextField tf_userName;
    @FXML
    private TextField tf_Password;
    @FXML
    private TextField tf_Name;

    @FXML
    private TextField tf_salary;
    @FXML
    private TextField tf_speclity;
    @FXML
    private ToggleGroup gender;
    @FXML
    private Label lbl_doneAdd;
    @FXML
    private Button btn_back;
    @FXML
    private Label lbl_WorngMessageSalary;
    @FXML
    private RadioButton male;
    @FXML
    private RadioButton fmale;
    @FXML
    private DatePicker Birthday_1;


    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @Deprecated
    private void addButtonClick(ActionEvent event) {
         Teacher teacher = new Teacher () ; 
         if(tf_userName.getText().isEmpty() || tf_Password.getText().isEmpty() || tf_Name.getText().isEmpty()  || tf_speclity.getText().isEmpty()){
            lbl_doneAdd.setTextFill(Color.web("#e40000"));
             lbl_doneAdd.setText("Error In Informayion :( ");
         }

         else {
             teacher.setUsername(tf_userName.getText());
        teacher.setPassword(tf_Password.getText());
        teacher.setName(tf_Name.getText());
        if(male.isSelected()){
             teacher.setGender(male.getText());
        }
        else{
              teacher.setGender(fmale.getText());
        }
        if( isValidSalary() == true ){
            
        
         
        teacher.setSalary(tf_salary.getAnchor());
        teacher.setBirthday(Birthday_1.getValue());
             teacher.setSpecialty(tf_speclity.getText()); 
         Util.teacherList.add(teacher);
         Util.users.add(teacher);
          lbl_doneAdd.setTextFill(Color.web("#19ff00"));
          lbl_doneAdd.setText("Done ! Teacher Added");
       }
        }
    }

    // الرجوع للصفحة السابقة 
    @FXML
    private void backButton(ActionEvent event) throws IOException {
         Node node = (Node)event.getSource() ; 
           Stage stage  = (Stage)node.getScene().getWindow() ; 
           stage.close();
           FXMLLoader loader = new  FXMLLoader(getClass().getResource("adminSecrean.fxml"));
           Parent root = loader.load();    
           stage.setScene( new Scene(root));
           stage.show();
    }

public boolean isValidSalary(){
   boolean x = true ; 
    if(tf_salary.getText().isEmpty()){
        lbl_WorngMessageSalary.setText("Enter A value !");
x = false ; 
    }
        try {
            if(Double.parseDouble(tf_salary.getText())<0){
                lbl_WorngMessageSalary.setText("Enter Positve Number !");
                x = false ; 
            }
            }catch( NumberFormatException e){
                    lbl_WorngMessageSalary.setText("Enter Number ! ");
                  
                    } 
      return x ; 
}
    boolean bo =true;
    public void addtonClick(ActionEvent actionEvent) {

        for (int i = 0; i < Util.users.size(); i++) {
            if (tf_userName.getText().equals(Util.users.get(i).getUsername())){
                lbl_doneAdd.setText("Frequent UserName");
                bo=false;
            }
        }


        Teacher teacher = new Teacher () ;
        if(tf_userName.getText().isEmpty() || tf_Password.getText().isEmpty() || tf_Name.getText().isEmpty()  || tf_speclity.getText().isEmpty()){
            lbl_doneAdd.setTextFill(Color.web("#e40000"));
            lbl_doneAdd.setText("Error In Informayion :( ");
        }
        if (bo&&!(tf_userName.getText().isEmpty() && tf_Password.getText().isEmpty() && tf_Name.getText().isEmpty()  && tf_speclity.getText().isEmpty())){
            teacher.setUsername(tf_userName.getText());
            teacher.setPassword(tf_Password.getText());
            teacher.setName(tf_Name.getText());
            if(male.isSelected()){
                teacher.setGender(male.getText());
            }
            else{
                teacher.setGender(fmale.getText());
            }
            if( isValidSalary() == true ){



                teacher.setSalary(Integer.parseInt(tf_salary.getText()));
                teacher.setBirthday(Birthday_1.getValue());
                teacher.setSpecialty(tf_speclity.getText());
                Util.teacherList.add(teacher);
                Util.users.add(teacher);
                lbl_doneAdd.setTextFill(Color.web("#19ff00"));
                lbl_doneAdd.setText("Done ! Teacher Added");
        }




        }
    }
}
