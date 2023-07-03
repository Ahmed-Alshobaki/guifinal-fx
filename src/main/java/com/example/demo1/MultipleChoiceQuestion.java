/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo1;

import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class MultipleChoiceQuestion   extends Question  {
    private int answer ; 
    private ArrayList <String> choices = new ArrayList <String>();

    public int getAsnwer() {
        return answer;
    }

    public void setAsnwer(int asnwer) {
        this.answer = asnwer;
    }

    public ArrayList getChoices() {
        return choices;
    }

    public void setChoices(ArrayList choices) {
        this.choices = choices;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Question.id = id;
    }

    public int getBaseId() {
        return BaseId;
    }

    public void setBaseId(int BaseId) {
        this.BaseId = BaseId;
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
    
    @Override
    public double calculateMark(String answer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return super.toString() + "answer=" + answer + '}';
    }
    
    
}
