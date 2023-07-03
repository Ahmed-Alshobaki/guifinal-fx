
package com.example.demo1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;

public class ViewAllExamController implements Initializable {

    @FXML
    private TableView<Exam> taple_exam;
    @FXML
    private TableColumn<Exam, Integer> col1;
    @FXML
    private TableColumn<Exam, String> col2;
    @FXML
    private TableColumn<Exam, Integer> col3;
    @FXML
    private TableColumn<Exam, Integer> col4;
    @FXML
    private TableColumn<Exam, Integer> col5;
    @FXML
    private Button btn_export;

   Person p = new Person();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
  sendDataa();
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
       public void sendDataa(){
          col1.setText("ID");
            col2.setText("Name");
             col3.setText("Number of Question");
            col4.setText("Min Pass");
            col5.setText("Total Mark");
            ObservableList<Exam> e = FXCollections.observableArrayList();
            e.addAll(Util.exams );
            col1.setCellValueFactory(new PropertyValueFactory<Exam, Integer>("BaseId"));
              col2.setCellValueFactory(new PropertyValueFactory<Exam, String>("name"));
              col3.setCellValueFactory(new PropertyValueFactory<Exam, Integer>("numberOfQuestion"));
               col4.setCellValueFactory(new PropertyValueFactory<Exam, Integer>("minPassAverage"));
                col5.setCellValueFactory(new PropertyValueFactory<Exam, Integer>("totalMarks"));
               taple_exam.setItems(e);
    }

    @FXML
    private void sulutionExam(MouseEvent event) throws IOException {


    }


    @FXML
    
  
    private void onExportClick(ActionEvent event) {
         Exam exam =   taple_exam.getSelectionModel().getSelectedItem(); 
        if(p instanceof Teacher){
            FileChooser fc = new FileChooser();
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("text file", "*.txt"));
            File f = fc.showSaveDialog(stage);
            try (PrintWriter pw = new PrintWriter(f)) {
                for (int i = 0; i < Util.questionOfExam.size(); i++) {
                    pw.println(Util.questionOfExam.get(i).toString());
                }
                pw.close();
            } catch (IOException e) {

            }

        }
    }
       public void sendData(Person p ){
           this.p = p ; 
       }
}
