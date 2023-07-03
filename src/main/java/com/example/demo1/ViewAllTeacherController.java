
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


public class ViewAllTeacherController implements Initializable {

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
    @FXML
    private TableColumn<Person, String> col5;
    @FXML
    private TableColumn<Person, String> col6;
    ObservableList<Person> all;
    @FXML
    private Button remove;
    ObservableList<Person> allperson ;
    int a;
    @FXML
    private TextField name_edit;

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
    private Label specialty;
    @FXML
    private TextField specialty_edit;
    @FXML
    private TextField password_edit;
    @FXML
    private Button edit;
    @FXML
    private TextField Salary_edit1;
    @FXML
    private TableColumn<Person,Integer> col7;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tb_AllTeacherTV.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Person>() {
            @Override
            public void changed(ObservableValue<? extends Person> observableValue, Person person, Person t1) {
                Teacher teachersO1 = (Teacher) observableValue.getValue();
                name_edit.setText(teachersO1.getName());
                username_edit.setText(teachersO1.getUsername());
                specialty_edit.setText(teachersO1.getSpecialty());
                birthdate_edit.setValue(teachersO1.getBirthday());
                password_edit.setText(teachersO1.getPassword());
                Salary_edit1.setText(String.valueOf(teachersO1.getSalary()));




            }
        });


    }

    public void sendDataForTable(int tybe){
        if(tybe == 0 ){
            col1.setText("username");
            col2.setText("Name");
            col3.setText("Gender");
            col4.setText("Specialty");
            col5.setText("birthdate");
            col6.setText("password");
            allperson = FXCollections.observableArrayList();

            col1.setCellValueFactory(new PropertyValueFactory<Person, String>("username"));
            col2.setCellValueFactory(new PropertyValueFactory<Person, String>("name"));
            col3.setCellValueFactory(new PropertyValueFactory<Person, String>("gender"));
            col4.setCellValueFactory(new PropertyValueFactory<Person, String>("specialty"));
            col5.setCellValueFactory(new PropertyValueFactory<Person, String>("birthday"));
            col6.setCellValueFactory(new PropertyValueFactory<Person, String>("password"));
            col7.setCellValueFactory(new PropertyValueFactory<Person, Integer>("salary"));

            allperson.addAll(Util.teacherList );
            tb_AllTeacherTV.setItems(allperson);
            a=0;

        }
        if(tybe == 1 ){

            col1.setText("UserName");
            col2.setText("Name");
            col3.setText("Gender");
            col4.setText("univarsityId");
            col5.setText("birthdate");
            col6.setText("password");
            allperson = FXCollections.observableArrayList();
            allperson.addAll(Util.studentArrayList );
            col1.setCellValueFactory(new PropertyValueFactory<Person, String>("username"));
            col2.setCellValueFactory(new PropertyValueFactory<Person, String>("name"));
            col3.setCellValueFactory(new PropertyValueFactory<Person, String>("gender"));
            col4.setCellValueFactory(new PropertyValueFactory<Person, String>("univarsityId"));
            col5.setCellValueFactory(new PropertyValueFactory<Person, String>("birthday"));
            col6.setCellValueFactory(new PropertyValueFactory<Person, String>("password"));

            tb_AllTeacherTV.setItems(allperson);
            a=1;
        }

    }
    @FXML
    public void back(ActionEvent actionEvent) throws IOException {

        Node node = (Node)actionEvent.getSource() ;
        Stage stage  = (Stage)node.getScene().getWindow() ;
        stage.close();
        FXMLLoader loader = new  FXMLLoader(getClass().getResource("adminSecrean.fxml"));
        Parent root = loader.load();
        stage.setScene( new Scene(root));
        AdminSecreanController conrol = loader.getController();
        stage.setTitle("Admin Screen");
        stage.show();
    }

    @FXML
    public void remove_ac(ActionEvent actionEvent) {
        int Index =tb_AllTeacherTV.getSelectionModel().getFocusedIndex();
        if (a==0){
            Util.teacherList.remove(Index);
            allperson.remove(Index);
            Util.users.remove(Index);
        }if (a==1){
            Util.studentArrayList.remove(Index);
            allperson.remove(Index);
            Util.users.remove(Index);
        }

    }

    @FXML
    public void edit_ac(ActionEvent actionEvent) {
        int  index = tb_AllTeacherTV.getSelectionModel().getSelectedIndex();
        Teacher teachersO1 = (Teacher)allperson.get(index);
        teachersO1.setUsername(username_edit.getText());
        teachersO1.setName(name_edit.getText());
        if (male.isSelected()){
            teachersO1.setGender("male");
        }if (fmale.isSelected()){
            teachersO1.setGender("fmale");
        }

        teachersO1.setBirthday(birthdate_edit.getValue());

        teachersO1.setSalary(Integer.parseInt(Salary_edit1.getText()));
        teachersO1.setPassword(password_edit.getText());
        teachersO1.setSpecialty(specialty_edit.getText());
        allperson.set(index,teachersO1);


    }
}
