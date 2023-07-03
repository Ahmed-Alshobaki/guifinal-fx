package com.example.demo1;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ViewAllStudent implements Initializable {
    @FXML
    private TableView<Person> tb_AllTeacherTV;
    @FXML
    private TableColumn<Person, String> col1;
    @FXML
    private TableColumn<Person, String> col2;
    @FXML
    private TableColumn<Person, String> col3;
    @FXML
    private TableColumn<Person, String> col4;
    @FXML
    private Button back;
    ObservableList<Person> allperson ;
    @FXML
    private TableColumn<Person, String> col5;
    @FXML
    private TableColumn<Person, String> col6;

    @javafx.fxml.FXML
    private Button remove;
    @FXML
    private TextField name_edit;
    @FXML
    private TextField password_edit;
    @FXML
    private TextField username_edit;
    @FXML
    private DatePicker birthdate_edit;
    @FXML
    private RadioButton male;
    @FXML
    private ToggleGroup Gender;
    @FXML
    private RadioButton fmale;
    @FXML
    private Button edit;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        col1.setText("username");
        col2.setText("Name");
        col3.setText("Gender");
        col4.setText("univarsityId");
        col5.setText("password");
        col6.setText("birthday");
        allperson = FXCollections.observableArrayList(Util.studentArrayList);
        col1.setCellValueFactory(new PropertyValueFactory<Person, String>("username"));//
        col2.setCellValueFactory(new PropertyValueFactory<Person, String>("name"));//
        col3.setCellValueFactory(new PropertyValueFactory<Person, String>("gender"));//
        col4.setCellValueFactory(new PropertyValueFactory<Person, String>("univarsityId"));//
        col5.setCellValueFactory(new PropertyValueFactory<Person, String>("password"));
        col6.setCellValueFactory(new PropertyValueFactory<Person, String>("birthday"));

        tb_AllTeacherTV.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Person>() {
            @Override
            public void changed(ObservableValue<? extends Person> observableValue, Person person, Person t1) {
                Student St = (Student) observableValue.getValue();
                name_edit.setText(St.getName());
                username_edit.setText(St.getUsername());

                birthdate_edit.setValue(St.getBirthday());
                password_edit.setText(St.getPassword());

                System.out.print(Util.studentArrayList.get(0).name);
                System.out.print(Util.studentArrayList.get(1).name);



            }
        });
        tb_AllTeacherTV.setItems(allperson);
    }

    @javafx.fxml.FXML
    public void back(ActionEvent actionEvent) throws IOException {
        Node node = (Node)actionEvent.getSource() ;
        Stage stage  = (Stage)node.getScene().getWindow() ;
        stage.close();
        FXMLLoader loader = new  FXMLLoader(getClass().getResource("adminSecrean.fxml"));
        Parent root = loader.load();

        stage.setScene( new Scene(root));
        stage.setTitle("Admin Screen");
        stage.show();
    }

    @javafx.fxml.FXML
    public void remove_ac(ActionEvent actionEvent) {
        int Index =tb_AllTeacherTV.getSelectionModel().getFocusedIndex();
        Util.studentArrayList.remove(Index);
        allperson.remove(Index);
        Util.users.remove(Index);
    }

    @FXML
    public void edit_ac1(ActionEvent actionEvent) {
        int  index = tb_AllTeacherTV.getSelectionModel().getSelectedIndex();
        Student Student = (Student)allperson.get(index);
        Student.setUsername(username_edit.getText());
        Student.setName(name_edit.getText());
        if (male.isSelected()){
            Student.setGender("male");
        }if (fmale.isSelected()){
            Student.setGender("fmale");
        }

        Student.setBirthday(birthdate_edit.getValue());


        Student.setPassword(password_edit.getText());
        Student.setBaseunivarsityId(Student.BaseunivarsityId);

        allperson.set(index,Student);
    }
}
