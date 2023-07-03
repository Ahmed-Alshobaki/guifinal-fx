
package com.example.demo1;

import java.util.ArrayList;

import static com.example.demo1.Util.scan;


public class Exam {
    
     private int BaseId ;
     private String name ; 
     private int numberOfQuestion ; 
    private int minPassAverage ;
    private int allowedQuestionType;
    private ArrayList<Question> examQuestions =new ArrayList<>();
    private String allQuestions;
    private int fullMark;
    private ArrayList<String> examResultsE = new ArrayList();
    private ArrayList <String> allowedQuestionsType = new  ArrayList <>();

    private ArrayList<Question> questions = new ArrayList<>();
      int totalMarks ; 
    static int id =1;

    public int getMinPassAverage() {
        return minPassAverage;
    }

    public void setAllowedQuestionsType(ArrayList<String> allowedQuestionsType) {
        this.allowedQuestionsType = allowedQuestionsType;
    }




    public Exam() {
    }

    public int getNumberOfQuestion() {
        return numberOfQuestion;
    }

    public  void setNumberOfQuestion(int numberOfQuestion ) {
        this.numberOfQuestion =  numberOfQuestion; 
                //Util.CheckNumber(  numberOfQuestion ,Util.allQuestionsList.size()) ; 
    }

    public Exam(int BaseId, String name, int numberOfQuestion, int minPassAverage, ArrayList allowedQuestionsType, int totalMarks) {
        this.BaseId = BaseId;
        this.name = name;
        this.numberOfQuestion = numberOfQuestion;
        this.minPassAverage = minPassAverage;
        this.allowedQuestionsType = allowedQuestionsType;
        this.totalMarks = totalMarks;
    }


    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Exam.id = id;
    }

    public  void setMinPassAverage(int minPassAverage) {
        while (minPassAverage < 0 ) {
            System.out.print("Enter Valid Value !! : ");
            minPassAverage = scan.nextInt(); 
        }
        this.minPassAverage = minPassAverage;
    }

    public ArrayList getAllowedQuestionsType() {
        return this.allowedQuestionsType ;
   //     String typeOfExamQuestion = "" ;  
   //     switch (Integer.parseInt(allowedQuestionsType)){
      //      case 1 : typeOfExamQuestion = "Yes-No Questions" ; 
             //   break ; 
              //  case 2 :  typeOfExamQuestion = "Multiple Choice Question" ; 
              //  break ; 
                //case 3 :  typeOfExamQuestion = "Fill The Blank" ; 
             //   break ; 
             //   case 4 :  typeOfExamQuestion = "Order Question" ; 
             //   break ; 
       // }
       // return typeOfExamQuestion ;
    }

    public void setAllowedQuestionsType(String allowedQuestionsType) {
       this.allowedQuestionsType.add(allowedQuestionsType);
    }

 

    public int getBaseId() {
        return BaseId;
    }
    
    @Override
    public String toString() {
        return "Id=" + BaseId + ", numberOfQuestion=" + numberOfQuestion + ", minPassAverage=" + minPassAverage + ", allowedQuestionsType=" + allowedQuestionsType + ' ';
    }

    public void setBaseId(int BaseId) {
        this.BaseId = BaseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(int mark) {
        this.totalMarks =mark;
    }
    public ArrayList<String> getExamResultsE() {
        return this.examResultsE;
    }

    public void setExamResultsE(ArrayList<String> examResults) {
        this.examResultsE = examResults;
    }

    public void addExamResultsE(String e) {
        this.examResultsE.add(e);
    }

    public int getFullMark() {
        return this.fullMark;
    }

    public void setFullMark(int fullMark) {
        this.fullMark = fullMark;
    }





    public int getAllowedQuestionType() {
        return this.allowedQuestionType;
    }

    public void setAllowedQuestionType(int allowedQuestionType) {
        this.allowedQuestionType = allowedQuestionType;
    }

    public ArrayList<Question> getExamQuestions() {
        return this.examQuestions;
    }

    public void setExamQuestions(ArrayList<Question> examQuestions) {
        this.examQuestions = examQuestions;
    }


    public String getAllQuestions() {
        return this.allQuestions;
    }

    public void setAllQuestions(String allQuestions) {
        this.allQuestions = allQuestions;
    }

    public static String printChoices(ArrayList<Question> examQuestions) {
        String allQuestions = "";

        for(int i = 0; i < examQuestions.size(); ++i) {
            int questionNumber = i + 1;
            allQuestions = allQuestions + " " + questionNumber + "." + examQuestions.get(i) + "\n";
        }

        return "[" + allQuestions + "]";
    }

    public static int getTotalExamMark(ArrayList<Question> examQuestions) {
        int examMark = 0;

        for(int i = 0; i < examQuestions.size(); ++i) {
            examMark += ((Question)examQuestions.get(i)).getMarks();
        }

        return examMark;
    }
}    