/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo1;

public class YesNoQuestion extends Question {
   private String answer ;
     final private String type = "YesNoQuestion";
    @Override
    public String toString() {
        return super.toString() + "Type = " + type + "answer= " + answer ;
    }

    public YesNoQuestion( int BaseId, String question, String type , int marks , String answer) {
        super(id, question, type,marks);
        this.answer = answer;
    }

    public YesNoQuestion(String answer) {
        this.answer = answer;
    }
    


    YesNoQuestion() {

    }

    public String isAnswer() {
        return answer;
    }


    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public double calculateMark(String answer) {
      while(true){
           if (answer.toLowerCase().equals(String.valueOf(this.answer))){
               
           }
      }
       
           
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

    @Override
    public int getMarks() {
        return marks;
    }

    @Override
    public void setMarks(int marks) {
        this.marks = marks;
    }
    
}
