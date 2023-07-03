package com.example.demo1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class examResultsE implements Initializable  {
    @javafx.fxml.FXML
    private TableColumn<Exam, String> name;
    @javafx.fxml.FXML
    private TableColumn<Exam, Integer> minPassAverage;
    @javafx.fxml.FXML
    private TableColumn  <Exam,Integer>fullMark;
    @javafx.fxml.FXML
    private Button back;
    @javafx.fxml.FXML
    private TableView<Exam> er;
    ObservableList<Exam> eET ;
    @javafx.fxml.FXML
    private TableColumn<Exam,Integer> totalMarks;
    @javafx.fxml.FXML
    private TableColumn<Exam,Integer> id;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        eET = FXCollections.observableArrayList(Util.exams);
        name.setCellValueFactory(new PropertyValueFactory<Exam, String>("name"));//
        minPassAverage.setCellValueFactory(new PropertyValueFactory<Exam, Integer>("minPassAverage"));//
        fullMark.setCellValueFactory(new PropertyValueFactory<Exam, Integer>("fullMark"));//
        totalMarks.setCellValueFactory(new PropertyValueFactory<Exam, Integer>("totalMarks"));//
        id.setCellValueFactory(new PropertyValueFactory<Exam, Integer>("id"));
        er.setItems(eET);

    }

    @javafx.fxml.FXML
    public void back(ActionEvent actionEvent) throws IOException {
        Node node = (Node)actionEvent.getSource() ;
        Stage stage  = (Stage)node.getScene().getWindow() ;
        stage.close();
        FXMLLoader loader = new  FXMLLoader(getClass().getResource("stedntScreen.fxml"));
        Parent root = loader.load();

        stage.setScene( new Scene(root));
        stage.setTitle("Admin Screen");
        stage.show();
    }

    @javafx.fxml.FXML
    public void er(Event event) {

    }
}
