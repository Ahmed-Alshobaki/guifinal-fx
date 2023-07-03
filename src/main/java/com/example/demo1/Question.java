package com.example.demo1;

public abstract class Question {
    
     // تعريف متغيرات   
        static int id =1;
        int BaseId = 0 ;
        String question;
        String type ; 
         int marks;


         String answer;


    public Question(int BaseId, String question, String type, int marks) {
        this.BaseId = BaseId;
        this.question = question;
        this.type = type;
        this.marks = marks;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
        
 
        
  
    public Question() {
    }
    
    public String getQuestion() {
        return question;
    }
    public void setQuestion(String question) {
        this.question = question;
    
    }
    public int getMarks() {
        return marks;
    }
    public void setMarks(int marks) {
        this.marks = marks;
    }
  

   public abstract double calculateMark(String answer);


    public boolean checkAnswer(String answer){
        return this.answer.equals(answer);
    }



    public String toString() {
    return " ID = " + id + " question = " + getQuestion() +  ", marks = " + marks  + "";
}
public String toStringToExam() {
    return  " question = " + getQuestion() + ", marks = " + marks ;
}

    public int getBaseId() {
        return BaseId;
    }

 



}
