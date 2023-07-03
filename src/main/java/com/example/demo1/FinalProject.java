
package com.example.demo1;


import java.util.ArrayList;
import java.util.Scanner;

public class FinalProject {

    public static void main(String[] args) {

         System.out.println(Util.allQuestionsList.get(0).toString());


         Exam exam = new Exam() ;
         YesNoQuestion question =new YesNoQuestion();
         question.setQuestion("ahmed");
        question.setAnswer("zon?");
        question.setType("Yes-NO Question");
        question.setMarks(5);
        YesNoQuestion question2 =new YesNoQuestion();
        question2.setQuestion("ahmed");
        question2.setAnswer("zon?");
        question2.setType("Yes-NO Question");
        question2.setMarks(5);
        ArrayList<Question> list =new ArrayList<>();
        list.add(question);
        list.add(question2);
         exam.setExamQuestions(list);
         Util.setExam(exam);
         Scanner scan = new Scanner(System.in);
         boolean b = false ; 
while(b==false){   
        System.out.println("Enter Your Username And Password");
        System.out.print("User : ");
        String user = scan.next() ;
        System.out.print("Password : ");
        String password = scan.next() ;
        
        if (user.equals("admin") && password.equals("admin")){
            int numForAdminChoose =0;
            while(numForAdminChoose!=5){
            System.out.printf(" 1 - if you need to add Teacher \n 2- if you need to add students \n 3- if you need to view all students \n 4- if you need able to view all teachers \n 5- Exit \n");
             numForAdminChoose = scan.nextInt() ; 
            switch (numForAdminChoose) {
                case 1:
                    Teacher t = new Teacher() ;
                    System.out.print("Enter username : ");
                    t.setUsername(scan.next());
                    scan.nextLine() ;
                    System.out.print("Enter Password : "); 
                    t.setPassword(scan.next());
                    System.out.print("Enter name : ");
                    t.setName(scan.nextLine());
                    t.setGender(Util.getGenderInput());
//                    t.setBirthday(Util.CheckBirthday());
                    System.out.print("Enter your Salary :"); 
                    t.setSalary(scan.nextInt());
                    System.out.print("Enter specialty :");
                    t.setSpecialty(scan.next());
                    Teacher t2 =new Teacher();
                    t2 = new Teacher (t.getUsername() , t.getPassword() , t.getName() , t.getGender(),t.getBirthday(),t.getSalary() , t.getSpecialty());
                    Util.fillDataTeacher(t2);
                    break;
                    case 2:          
                    Util.fillDataStudent(Util.EnterStudentInfromation());
                                        break;
                     case 3: 
                     Util.viewStudent(); 
                         break;
                         case 4: Util.viewTeacher();
                         break;
            }  
        }
    }

        else {
    int indexUser =0 ; 
    for(int i = 0 ; Util.teacherList.size()>i;i++){
        if(Util.teacherList.get(i).username.equals(user)) {
         indexUser = i ;  
         if(Util.teacherList.get(indexUser).password.equals(password)){
            System.out.printf("1- add student \n 2- view student \n 3- add questions \n 4- edit questions \n 5- view all questions\n  6- add exam \n 7- view all exams \n 8- view exam's results \n 9- view student's exam result \nn10- export exams to a text file");
            int  numForTeacherChoose =scan.nextInt(); 
            switch(numForTeacherChoose){
                case 1 : Util.EnterStudentInfromation();
                break;
                case 2 : Util.viewStudent();
                break;
                case 3 : Util.addQuestion();
                break;
                case 4 :Util.editQuestion();
                break;
                case 5 :Util.showQuestions();
                break;
                case 6 :// Util.addExam();
                break;
                 case 7 : Util.viewAllExam();
                break; 
                case 8 : Student.solveExam();
                break; 
            }
         
          }
            else{
             System.out.println("Password Worng !! ");
            }
         
       }
        else{
         System.out.println("username Wrong !! ");
         break ;
        }
        }
}
}
}

}