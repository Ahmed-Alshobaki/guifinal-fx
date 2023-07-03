package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class FXMLDocumentController {


    @FXML
    private TextField user_name;
    @FXML
    private PasswordField password_id;
    @FXML
    private Button id_Login;
    @FXML
    private Label wornglbl;
    int indexUser;
    Boolean aBoolean = true;

    @FXML
    public void handleButtonAction(ActionEvent actionEvent) throws IOException {
        if (user_name.getText().toLowerCase().equals("admin")){
            if(password_id.getText().toLowerCase().equals("admin")){
                Node node = (Node)actionEvent.getSource() ;
                Stage stage  = (Stage)node.getScene().getWindow() ;
                stage.close();
                FXMLLoader loader = new  FXMLLoader(getClass().getResource("adminSecrean.fxml"));
                Parent root = loader.load();
                stage.setScene( new Scene(root));
                AdminSecreanController conrol = loader.getController();
                conrol.sendDat(user_name.getText());
                stage.setTitle("Admin Screen");
                stage.show();
            }
        }
        else{


           indexUser =0 ;
            for(int i = 0 ; Util.users.size()>i;i++){
                if(Util.users.get(i).getUsername().equals(user_name.getText())) {
                    indexUser = i;
                    if (Util.users.get(indexUser).getPassword().equals(password_id.getText())) {
                        if (Util.users.get(indexUser) instanceof Teacher) {
                            Teacher t = (Teacher) Util.users.get(indexUser);
                            aBoolean=false;
                            Node node = (Node) actionEvent.getSource();
                            Stage stage = (Stage) node.getScene().getWindow();
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("TeacherScreen.fxml"));
                            Parent root = loader.load();
                            TeacherScreenController c = loader.getController();
                            c.sendData(user_name.getText());
                            c.sendData(t);
                            stage.setScene(new Scene(root));
                            stage.setTitle("Teacher Screen");
                            stage.show();
                        } else if (Util.users.get(indexUser) instanceof Student) {
                            Student s = (Student) Util.users.get(i);
                            aBoolean=false;
                            Node node = (Node) actionEvent.getSource();
                            Stage stage = (Stage) node.getScene().getWindow();
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("stedntScreen.fxml"));
                            Parent root = loader.load();
                            StedntScreenController a = loader.getController();
                            a.sendDtata(s);
                            stage.setScene(new Scene(root));
                            stage.setTitle("Student Screen");
                            stage.show();
                        }


                    }

                }

                }

                }
                 if ( !(user_name.getText().toLowerCase().equals("admin"))&&aBoolean) {
                     wornglbl.setText("Your Password Worng , Try Again");
                 }
                if ( !(password_id.getText().toLowerCase().equals("admin"))&&aBoolean) {
                        wornglbl.setText("Your Password Worng , Try Again");
                    }

                }

}