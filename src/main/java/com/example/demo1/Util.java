
package com.example.demo1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;



public class Util {
    static Random r = new Random () ; 
      // سكانر للادخال لكل الكلاس
        static Scanner scan = new Scanner(System.in);


        public static Exam exam =new Exam();
    public static ArrayList<Question> questionOfExam = new ArrayList<Question>() ;
     
      // اري ليست للمعلمين 
          public static ArrayList <Admin> users = new ArrayList<>();
        public static ArrayList <Person> teacherList = new ArrayList<>();
                    
               static ArrayList <Exam> exams = new ArrayList <>() ;


    public static com.example.demo1.Exam getExam() {
        return exam;
    }


    public static void setExam(com.example.demo1.Exam exam) {
        Util.exam = exam;
    }

    //   اري الطلاب وتعبئتها وعرضها
               
    public static ArrayList <Person> studentArrayList = new ArrayList<>();
    public static ArrayList <Person> taeyp = new ArrayList<>();

    
         public static void fillDataTeacher(Teacher t) {
                         teacherList.add(t);
                          }
   
                 public static void viewTeacher() {
                           for (Person p : teacherList) {
                            System.out.println(p.toString());
                           }
    }
      
                 // اري ليست لاضافة الاسئلة
                    ArrayList<Question> TeacherAddedQuestions = new ArrayList<>();
      public static ArrayList <Question> allQuestionsList = new ArrayList<>();
     
        // تعريف اوبجكت لاضافته داحل الاري ليست
      static Question q = new Question() {
            @Override
            public double calculateMark(String answer) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };

    public static   ArrayList <Exam> Exam = new ArrayList <>() ;
      // اضافة معلومات الطالب
    public static Student EnterStudentInfromation(){
        Student s = new Student();
        System.out.print("Enter username : ");
        s.setUsername(scan.next());
        System.out.print("Enter Password : "); 
        s.setPassword(scan.next());
        System.out.print("Enter name : ");
        s.setName(scan.next());
        s.setGender(getGenderInput());
     
        Student s1 = new Student(s.getUsername(), s.getPassword(), s.getName(), s.getGender(), s.getBirthday());
    return s1;
    }
    // ميثود لفحص تاريخ الميلاد والتحقق منه
    public static String CheckBirthday(){
          Scanner z = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); 
        String input = "" ; 
        Date date = null;
        while (date == null) {
            System.out.print("Enter a date as (dd/MM/yyyy): ");
            input = z.nextLine(); 
            try {
                date = dateFormat.parse(input);
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please enter a valid date in the format dd/MM/yyyy.");
            }
        }
        return input;
    }
    

         public static void fillDataStudent (Student t){
            studentArrayList.add( t );
    }
         public static void viewStudent (){
      for (Person p : studentArrayList) {
        System.out.println(p.toString());
      }
 
         
  }

 // فحص الجنس والتحقق من اضافة ذكر وانثى فقط
public static String getGenderInput() {
    String result = "";
        OUTER:
        while (true) {
            System.out.print("Enter gender (Male = M), (Female = F): ");
            String gender = scan.next().toUpperCase();
            switch (gender) {
                case "M":
                    result = "Male";
                    break OUTER;
                case "F":
                    result = "Female";
                    break OUTER;
                default:
                    System.out.println("Invalid input. Please enter M or F.");
                    break;
            }
        }
    return result;
}

// ميثود بفحص مدخلات رقم 
public static int CheckNumber(int min , int max){
    int NumberToCheck  = scan.nextInt(); 
    while (NumberToCheck < min || NumberToCheck > max){
        System.out.println("Enter Valid Value");
        NumberToCheck  = scan.nextInt(); 
    }
    return NumberToCheck ; 
}

// اضافة اسئلة وانواعها 
   public static void addQuestion() {
       q.BaseId = Question.id++ ; 
       String result = "" ; 
        boolean ifYouNeedAddMore = false ; 
        while(ifYouNeedAddMore==false){
       System.out.printf("Whate tybe your Questions? \n  1 - Yes-No Questions \n  2 - Multiple Choice Question \n 3 - Fill the blank question ");
        int numForTypeOfQuestions = CheckNumber(1, 3);
        q.BaseId = Question.id++ ;
        switch (numForTypeOfQuestions){
            
case 1 :
  
    // اضافة نوع السءال الاول
     YesNoQuestion yn = new YesNoQuestion (); 
     
     System.out.println("Add a question : ");
     scan.nextLine() ;
     yn.setQuestion(scan.nextLine());
     System.out.println("Add mark for question ");
     yn.setMarks(scan.nextInt()); 
     System.out.println("Add Answer by (True) / (False) only:");
while (true) {
    result = scan.next().toLowerCase();
    if (result.equals("true") || result.equals("false")) {
         yn.setAnswer(result);
         allQuestionsList.add(yn);
         ifYouNeedAddMore= true ; 
         break;
    }
    else{
    System.out.println("Enter a valid value!");
}
}
break;

case 2 : 
  // اضافة نوع السءال الثاني 
    MultipleChoiceQuestion mcq = new MultipleChoiceQuestion () ;

     // ادخال المعلومات العامة  
        System.out.println("Add a question : ");
         scan.nextLine() ;
         mcq.setQuestion(scan.nextLine());
         System.out.println("Add mark for question ");
         mcq.setMarks(scan.nextInt()); 
         
     // ادخال الخيارات 
         
    System.out.println("Add Answer no1 : ");
    String choise1 = scan.next();
    System.out.println("Add Answer no2 : ");
    String choise2 = scan.next();
    System.out.println("Add Answer no3 : ");
    String choise3 = scan.next();
    System.out.println("Witch of this right Answer ? 1- " + choise1 + " 2-  "+choise2 + " 3-  "+choise3);
    mcq.setAsnwer(CheckNumber(1, 3));
    allQuestionsList.add(mcq);    
break;
        case 3 : 
            // تعريف اوبجكت 
            FillTheBlankQuestion ftbq = new FillTheBlankQuestion () ; 
              // ادخال المعلومات 
         System.out.println("Add a question : ");
         scan.nextLine() ;
         ftbq.setQuestion(scan.nextLine());
         System.out.println("Add mark for question ");
         ftbq.setMarks(scan.nextInt());        
         System.out.print("Add Answer :");
         result = scan.nextLine() ; 
         ftbq.setAnswer(result) ; 
         allQuestionsList.add(ftbq);
    break;
    }
    }
    }
     public static void showQuestions() {
         for (Question ques : allQuestionsList) {
        System.out.println(ques.toString());
    }
}
    public static void editQuestion() {
     showQuestions();
     System.out.println("what number you need to edit? ");
     int numberToEditQusestion = scan.nextInt(); 
      while (numberToEditQusestion != allQuestionsList.size()){
           System.out.println("Enter Right Number Please !! : ");
                 numberToEditQusestion = scan.nextInt(); 
    }
    for(int i = 0 ; numberToEditQusestion > i ; i++ ){
        if(i==Question.id){
            System.out.printf("What You Need Edit ?  \n 1- question \n  2- trueResult \n 3-marks  ");
            int WhatNeedToEdit = scan.nextInt();
            if(WhatNeedToEdit <= 4 ||  WhatNeedToEdit >= 1){
                switch(WhatNeedToEdit){
                    case 1 : 
                    allQuestionsList.get(i).setQuestion(scan.nextLine());
                    break ;  
                    case 2 : 
                    if ( allQuestionsList.get(i) instanceof YesNoQuestion){
                         YesNoQuestion y = (YesNoQuestion) allQuestionsList.get(i) ; 
                         y.setAnswer(scan.nextLine());
                    }
                    else if ( allQuestionsList.get(i) instanceof MultipleChoiceQuestion){
                         MultipleChoiceQuestion y = (MultipleChoiceQuestion) allQuestionsList.get(i) ; 
                         y.setAsnwer(scan.nextInt());
                    }  
                       else if ( allQuestionsList.get(i) instanceof FillTheBlankQuestion){
                         FillTheBlankQuestion y = (FillTheBlankQuestion) allQuestionsList.get(i) ; 
                         y.setAnswer(scan.nextLine());
                    }  
                    break ;
                    case 3 : 
                    allQuestionsList.get(i).setMarks(scan.nextInt());
                    break ;
                }
            }
        }
        else{
            while(true){
                System.out.println("Please Enter True Number");
                numberToEditQusestion = scan.nextInt();  ; 
            }
        }
    }
}

    
    
    /// مهم جدا زبطها اليوم 
        public  void addExam(){
            Exam e = new Exam () ;

//        ++id ;
//        e.setBaseId(id);
        System.out.print("Enter Number Of Question : ");
        //e.setNumberOfQuestion();
        System.out.print("Enter Min Pass Average : ");
        e.setMinPassAverage (scan.nextInt()) ; 
        System.out.printf("Enter Tybe Of Question By Number withot Space  \n 1 - Yes-No Question \n 2 - Multiple Choice Question \n 3 - Fill The Blank \n 4 - Order Question");
        //e.setAllowedQuestionsType(); 
        exams.add(e); 
        int random = r.nextInt(Util.allQuestionsList.size());
          for(int i = 0  ; e.getNumberOfQuestion() > i ; i ++  ){
               if (allQuestionsList.get(random).getType().equals(e.getAllowedQuestionsType())){
                // Exam.questionOfExam.add( allQuestionsList.get(random)) ; 
              }
    }
}
           // عرض جميع الامتحانات 
    public static void viewAllExam (){
        exams.forEach((e) -> {
            System.out.println(e.toString());
         });
    }
    

}


