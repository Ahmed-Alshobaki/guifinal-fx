/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo1;


import java.time.LocalDate;

/**
 *
 * @author ASUS
 */
public class Student extends Person {
  static int univarsityId = 120220000; 
  int BaseunivarsityId ; 
    public String getUsername() {
        return username;
    }

    public int getBaseunivarsityId() {
        return BaseunivarsityId;
    }

    public void setBaseunivarsityId(int BaseunivarsityId) {
        this.BaseunivarsityId = BaseunivarsityId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getBirthday() {
        return birthday;
    }



    public Student(String username, String password, String name, String gender, LocalDate birthday) {
        super(username, password, name, gender, birthday);
    }

     public Student(String username , String name,  String gender ,int univarsityId) {
        super(username, name  ,gender);
        this.univarsityId = univarsityId;
    }

    public int getUnivarsityId() {
        return univarsityId;
    }
    public Student() {
        univarsityId++;
    }
 public static void  solveExam () { 
     int i = 1;
    
     for (Exam ee : Util.exams){
         System.out.println(i+")"+ee.toString());
         i++;
     }
     System.out.println("What Number Of Exam You Need Solve ? ");
     int numberOfExam = Util.CheckNumber(1, Util.exams.size()+1);
//     for(Exam e: exams){
//         int numberOfQuestion = e.getBaseId() ; 
//         System.out.println(e.questionOfExam.get(numberOfQuestion).getQuestion());
//         System.out.println("Enter Your : ");
//        String result = scan.nextLine();
//        if(result.equals(e.questionOfExam.get(numberOfQuestion).getTrueResult())){
//             int marks =+ e.questionOfExam.get(numberOfQuestion).getMarks() ; 
//        }
//     }    Exam e = Util.exams.get(numberOfExam-1);
   //   System.out.println(e.questionOfExam.size());
     //  for(Question q : e.questionOfExam){
       //    System.out.println(q);
       //    System.out.println("enter the answer");
       //    String answer = scan.next();
        //   System.out.println(getTrueResult());
      // if(q.equals(answer))System.out.println("sfg");

       }
    @Override
    public String toString() {
        return super.toString()+"Student [univarsityId=" + BaseunivarsityId + "]";
    }
}
 
    

