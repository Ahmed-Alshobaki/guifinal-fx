
package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.example.demo1.Util.allQuestionsList;


public class AddQuestionScreenController implements Initializable {

    @FXML
    private TextField tf_Question;
    @FXML
    private TextField tf_mark;
    @FXML
    private ToggleGroup answer;
    @FXML
    private Button btn_Add;
    @FXML
    private Label lbl_ifAdded;
    @FXML
    private RadioButton trueCH;
    @FXML
    private RadioButton falseCH;

    int ifNewOrEdit ;
    YesNoQuestion y ;
    @FXML
    private Label qq;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
    }    

    

    public void sendData(Question q){
        if(ifNewOrEdit == 1){
            this.y = (YesNoQuestion)q;
            tf_Question.setText(q.getQuestion());
        tf_mark.setText(String.valueOf(q.getMarks()));
        if(answer.equals("true")){
            trueCH.selectedProperty();
        }
        else if(answer.equals("false")){
            falseCH.selectedProperty();
        }
        }
        qq.setText("Done");
    }
    public void sendEdit(int s){
        this.ifNewOrEdit = s ; 
    }

    @FXML
    public void onBackClick(ActionEvent actionEvent) throws IOException {
        String result = "" ;
        if(this.ifNewOrEdit == 1){
            YesNoQuestion yyyy = y ;
            yyyy.setQuestion(tf_Question.getText());
            yyyy.setMarks(Integer.parseInt(tf_mark.getText()));
            if(trueCH.isSelected()){
                result = trueCH.getText();
            }
            else if(falseCH.isSelected()){
                result = falseCH.getText();
            }
            yyyy.setAnswer(result);
            allQuestionsList.add(yyyy);
            Question.id++;
        }else{
            YesNoQuestion yn = new YesNoQuestion ();
            yn.setBaseId(Question.id);
            yn.setQuestion(tf_Question.getText());
            yn.setMarks(Integer.parseInt(tf_mark.getText()));
            yn.setType("Yes-NO Question");
            if(trueCH.isSelected()){
                result = trueCH.getText();
            }
            else if(falseCH.isSelected()){
                result = falseCH.getText();
            }
            yn.setAnswer(result);
            allQuestionsList.add(yn);
            Question.id++;
        }
        Node node = (Node)actionEvent.getSource() ;
        Stage stage  = (Stage)node.getScene().getWindow() ;
        stage.close();
        FXMLLoader loader = new  FXMLLoader(getClass().getResource("TeacherScreen.fxml"));
        Parent root = loader.load();
        stage.setScene( new Scene(root));
        stage.show();
    }
}
