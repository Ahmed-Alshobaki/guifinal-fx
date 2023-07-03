
package com.example.demo1;

public class FillTheBlankQuestion extends Question  {
    private String answer ; 

    public FillTheBlankQuestion(int BaseId , String question, String type, String answer, int marks) {
        super(BaseId , question,type , marks);
        this.answer = answer;
    }

    public FillTheBlankQuestion() {
       
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Question.id = id;
    }

    @Override
    public int getBaseId() {
        return BaseId;
    }

    public void setBaseId(int BaseId) {
        this.BaseId = BaseId;
    }

    @Override
    public String getQuestion() {
        return question;
    }

    @Override
    public void setQuestion(String question) {
        this.question = question;
    }

    public int getMarks() {
        return marks;
    }

    @Override
    public void setMarks(int marks) {
        this.marks = marks;
    }


    public boolean checkAnswer(String answer){
        return this.answer.equals(answer);
    }


    @Override
    public double calculateMark(String answer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return super.toString()  + "answer=" + answer + '}';
    }

   
    
}
