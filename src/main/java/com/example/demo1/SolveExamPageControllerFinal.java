package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SolveExamPageControllerFinal implements Initializable {
    @FXML
    private Label lbl_questionText;
    @FXML
    private TextField tf_fillAnswer;
    @FXML
    private RadioButton rb_yes;
    @FXML
    private ToggleGroup yesOrNo;
    @FXML
    private RadioButton rb_No;
    @FXML
    private RadioButton rb_choice1;
    @FXML
    private ToggleGroup choices;
    @FXML
    private RadioButton rb_choice4;
    @FXML
    private RadioButton rb_choice3;
    @FXML
    private RadioButton rb_choice2;
    @FXML
    private Button btn_submit;
    Exam exam = Util.getExam();

    int index;
    int indexCounter = 0;
    int counter = 0;
    int gettenMark = 0;
    ArrayList<String> answers = new ArrayList();
    int StudentId;
    int temp = 0;
    @FXML
    private Label aa;


    public void initialize(URL url, ResourceBundle rb) {
        ArrayList<Question>list =new ArrayList<>();
        YesNoQuestion question =new YesNoQuestion();
        question.setQuestion("ahmed");
        question.setBaseId(1);

        question.setAnswer("false");
        question.setType("Yes-NO Question");
        question.setMarks(5);
        question.setBaseId(1);
        YesNoQuestion question2 =new YesNoQuestion();
        question2.setQuestion("zon");
        question2.setAnswer("true");
        question2.setType("Yes-NO Question");
        question2.setMarks(5);
        question.setBaseId(1);
        YesNoQuestion question3 =new YesNoQuestion();
        question3.setQuestion("hala");
        question3.setAnswer("false");
        question3.setType("Yes-NO Question");
        question.setBaseId(1);
        question3.setMarks(5);

        list.add(question);
        list.add(question2);
        list.add(question3);
        exam.setExamQuestions(list);
        ActionEvent event = new ActionEvent(this.btn_submit, this.lbl_questionText);
        this.btn_submit.setText("Start");
        this.lbl_questionText.setText("");
        this.rb_choice1.setVisible(false);
        this.rb_choice2.setVisible(false);
        this.rb_choice3.setVisible(false);
        this.rb_choice4.setVisible(false);

        try {
            this.onBtnSubmitClick(event);
        } catch (IOException var5) {
            System.out.println("Error");
        }

    }

    @FXML
    private void onBtnSubmitClick(ActionEvent event) throws IOException {
        ++this.counter;
        if (this.counter != 1) {
            MultipleChoiceQuestion multiChoice;
            if (this.counter == 2) {
                this.btn_submit.setText("Submit");
                this.lbl_questionText.setText((this.exam.getExamQuestions().get(this.indexCounter)).getQuestion());
                if (this.indexCounter == this.exam.getExamQuestions().size() - 1) {
                    this.btn_submit.setText("Finish");
                }

                if ((this.exam.getExamQuestions().get(this.indexCounter)).getType().equals("Fill The Blank")) {
                    this.tf_fillAnswer.setVisible(true);
                    this.rb_yes.setVisible(false);
                    this.rb_No.setVisible(false);
                    this.rb_choice1.setVisible(false);
                    this.rb_choice2.setVisible(false);
                    this.rb_choice3.setVisible(false);
                    this.rb_choice4.setVisible(false);
                } else if ((this.exam.getExamQuestions().get(this.indexCounter)).getType().equals("Yes-NO Question")){
                    this.tf_fillAnswer.setVisible(false);
                    this.rb_yes.setVisible(true);
                    this.rb_No.setVisible(true);
                    this.rb_yes.setText("true");
                    this.rb_No.setText("false");
                    this.rb_choice1.setVisible(false);
                    this.rb_choice2.setVisible(false);
                    this.rb_choice3.setVisible(false);
                    this.rb_choice4.setVisible(false);
                } else if ((this.exam.getExamQuestions().get(this.indexCounter)).getType().equals("multipleChoiceQuestionScreen")) {
                    multiChoice = (MultipleChoiceQuestion)this.exam.getExamQuestions().get(this.indexCounter);
                    this.tf_fillAnswer.setVisible(false);
                    this.rb_yes.setVisible(false);
                    this.rb_No.setVisible(false);
                    this.rb_choice1.setText((String)multiChoice.getChoices().get(0));
                    this.rb_choice1.setVisible(true);
                    this.rb_choice2.setText((String)multiChoice.getChoices().get(1));
                    this.rb_choice2.setVisible(true);
                    this.rb_choice3.setText((String)multiChoice.getChoices().get(2));
                    this.rb_choice3.setVisible(true);
                    this.rb_choice4.setText((String)multiChoice.getChoices().get(3));
                    this.rb_choice4.setVisible(true);
                }

                ++this.indexCounter;

            } else {
                if (this.indexCounter == this.exam.getExamQuestions().size() + 1) {
                    this.btn_submit.setText("Finish");
                    this.temp = this.exam.getExamQuestions().size();
                    Stage stage1 = (Stage)this.btn_submit.getScene().getWindow();
                    stage1.hide();
                    FXMLLoader loader = new FXMLLoader(this.getClass().getResource("stedntScreen.fxml"));
                    Scene scene = new Scene((Parent)loader.load());
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.show();
//                    String examR = "StudentId : " + Util.getStudent(Utiles.username, Utiles.password).getUniversityId() + " / Student Name : " + Utiles.getStudent(Utiles.username, Utiles.password).getName() + " / Mark : " + this.gettenMark + "/" + this.exam.getFullMark();
//                    Utiles.getExam().addExamResultsE(examR);
//                    String examRforS = "ExamId : " + this.exam.getExamId() + " / Exam Name : " + this.exam.getExamName() + " Your Mark : " + this.gettenMark + "/" + this.exam.getFullMark();
//                    ((Student)Utiles.students.get(this.StudentId)).addExamResult(examRforS);
                    System.out.println(this.gettenMark + "/" + this.exam.getFullMark());
                    String correctAnswers = "";
                    String myAnswers = "";

                    for(int i = 0; i < this.answers.size(); ++i) {
                        if (i == 0) {
                            correctAnswers = correctAnswers + "Correct Answers : \n1. " + ((Question)this.exam.getExamQuestions().get(i)).getAnswer() + "\n";
                            myAnswers = myAnswers + "Your Answers : \n1. " + (String)this.answers.get(i) + "\n";
                            System.out.println(i + 1 + ". " + (String)this.answers.get(i));
                        } else {
                            correctAnswers = correctAnswers + (i + 1) + ". " + ((Question)this.exam.getExamQuestions().get(i)).getAnswer() + "\n";
                            myAnswers = myAnswers + (i + 1) + ". " + (String)this.answers.get(i) + "\n";
                            System.out.println(i + 1 + ". " + (String)this.answers.get(i));
                        }
                    }

//                    String studentDetail = examRforS + "\n" + correctAnswers + myAnswers;
//                    ((Student)Utiles.students.get(this.StudentId)).addExamResultDetaile(studentDetail);
                    this.indexCounter = 0;
                }

                if (this.indexCounter == this.exam.getExamQuestions().size()) {
                    this.lbl_questionText.setText(((Question)this.exam.getExamQuestions().get(this.indexCounter - 1)).getQuestion());
                    if (this.indexCounter == this.exam.getExamQuestions().size()) {
                        this.btn_submit.setText("Finish");
                    }

                    if ((this.exam.getExamQuestions().get(this.indexCounter-1)).getType().equals("Fill The Blank")) {
                        this.tf_fillAnswer.setVisible(true);
                        this.rb_yes.setVisible(false);
                        this.rb_No.setVisible(false);
                        this.rb_choice1.setVisible(false);
                        this.rb_choice2.setVisible(false);
                        this.rb_choice3.setVisible(false);
                        this.rb_choice4.setVisible(false);
                    } else if ((this.exam.getExamQuestions().get(this.indexCounter-1)).getType().equals("Yes-NO Question")){
                        this.tf_fillAnswer.setVisible(false);
                        this.rb_yes.setVisible(true);
                        this.rb_No.setVisible(true);
                        this.rb_choice1.setVisible(false);
                        this.rb_choice2.setVisible(false);
                        this.rb_yes.setText("true");
                        this.rb_No.setText("false");
                        this.rb_choice3.setVisible(false);
                        this.rb_choice4.setVisible(false);
                    } else if ((this.exam.getExamQuestions().get(this.indexCounter-1)).getType().equals("multipleChoiceQuestionScreen")) {
                        multiChoice = (MultipleChoiceQuestion)this.exam.getExamQuestions().get(this.indexCounter-1);
                        this.tf_fillAnswer.setVisible(false);
                        this.rb_yes.setVisible(false);
                        this.rb_No.setVisible(false);
                        this.rb_choice1.setText((String)multiChoice.getChoices().get(0));
                        this.rb_choice1.setVisible(true);
                        this.rb_choice2.setText((String)multiChoice.getChoices().get(1));
                        this.rb_choice2.setVisible(true);
                        this.rb_choice3.setText((String)multiChoice.getChoices().get(2));
                        this.rb_choice3.setVisible(true);
                        this.rb_choice4.setText((String)multiChoice.getChoices().get(3));
                        this.rb_choice4.setVisible(true);
                    }
                } else if (this.indexCounter != this.exam.getExamQuestions().size() + 1 || this.indexCounter != this.exam.getExamQuestions().size()) {
                    this.lbl_questionText.setText(((Question)this.exam.getExamQuestions().get(this.indexCounter)).getQuestion());
                    if ((this.exam.getExamQuestions().get(this.indexCounter)).getType().equals("Fill The Blank")) {
                        this.tf_fillAnswer.setVisible(true);
                        this.rb_yes.setVisible(false);
                        this.rb_No.setVisible(false);
                        this.rb_choice1.setVisible(false);
                        this.rb_choice2.setVisible(false);
                        this.rb_choice3.setVisible(false);
                        this.rb_choice4.setVisible(false);
                    } else if (((Question)this.exam.getExamQuestions().get(this.indexCounter)).getType().equals("Yes-NO Question")){
                        this.tf_fillAnswer.setVisible(false);
                        this.rb_yes.setVisible(true);
                        this.rb_No.setVisible(true);
                        this.rb_yes.setText("true");
                        this.rb_No.setText("false");
                        this.rb_choice1.setVisible(false);
                        this.rb_choice2.setVisible(false);
                        this.rb_choice3.setVisible(false);
                        this.rb_choice4.setVisible(false);
                    } else if ((this.exam.getExamQuestions().get(this.indexCounter)).getType().equals("multipleChoiceQuestionScreen")) {
                        multiChoice = (MultipleChoiceQuestion)this.exam.getExamQuestions().get(this.indexCounter);
                        this.tf_fillAnswer.setVisible(false);
                        this.rb_yes.setVisible(false);
                        this.rb_No.setVisible(false);
                        this.rb_choice1.setText((String)multiChoice.getChoices().get(0));
                        this.rb_choice1.setVisible(true);
                        this.rb_choice2.setText((String)multiChoice.getChoices().get(1));
                        this.rb_choice2.setVisible(true);
                        this.rb_choice3.setText((String)multiChoice.getChoices().get(2));
                        this.rb_choice3.setVisible(true);
                        this.rb_choice4.setText((String)multiChoice.getChoices().get(3));
                        this.rb_choice4.setVisible(true);
                    }
                }

                try {
                    String answer = "";
                    if ((this.exam.getExamQuestions().get(this.indexCounter - 1)).getType().equals("Fill The Blank")) {
                        answer = this.tf_fillAnswer.getText();
                        this.answers.add(answer);
                        aa.setText(answer);
                        if ((this.exam.getExamQuestions().get(this.indexCounter - 1)).checkAnswer(answer)) {
                            System.out.println("iiiii" + this.indexCounter);
                            this.gettenMark += (this.exam.getExamQuestions().get(this.indexCounter - 1)).getMarks();
                        }
                    } else if ((this.exam.getExamQuestions().get(this.indexCounter - 1)).getType().equals("Yes-NO Question")) {
                        this.rb_yes.setText("true");
                        this.rb_No.setText("false");
                        if (this.rb_yes.isSelected()) {
                            answer = "true";
                        } else if (this.rb_No.isSelected()) {
                            answer = "false";
                        } else {
                            answer = "No Answer";
                        }
                        this.answers.add(answer);
                        if ((this.exam.getExamQuestions().get(this.indexCounter - 1)).checkAnswer(answer)) {
                            System.out.println("iiiii" + this.indexCounter);
                            this.gettenMark += (this.exam.getExamQuestions().get(this.indexCounter - 1)).getMarks();
                        }
                    } else if (((Question)this.exam.getExamQuestions().get(this.indexCounter - 1)).getType().equals("multipleChoiceQuestionScreen")) {
                        if (this.rb_choice1.isSelected()) {
                            answer = "1";
                        } else if (this.rb_choice2.isSelected()) {
                            answer = "2";
                        } else if (this.rb_choice3.isSelected()) {
                            answer = "3";
                        } else if (this.rb_choice4.isSelected()) {
                            answer = "4";
                        } else {
                            answer = "No Answer";
                        }

                        this.answers.add(answer);
                        if (((Question)this.exam.getExamQuestions().get(this.indexCounter - 1)).checkAnswer(answer)) {
                            System.out.println("iiiii" + this.indexCounter);
                            this.gettenMark += ((Question)this.exam.getExamQuestions().get(this.indexCounter - 1)).getMarks();
                        }
                    }

                    ++this.indexCounter;

                } catch (Exception var11) {
                    System.out.println("Ignore it you finished");
                }
            }
        }

    }

    public void sendStudentId(int id) {
        this.StudentId = id;
    }
}
