package com.example.demo1;


import java.time.LocalDate;

public class Teacher extends Person {
   
   

    public static final String TeacherAddedQuestions = null;
    int salary;
    String specialty;

    
    


    public Teacher(String username, String password, String name, String gender, LocalDate birthday, int salary, String specialty) {
        super(username, password, name, gender, birthday);
        this.specialty=specialty;
        this.salary = salary;
    }

    public Teacher() {
    }

    public Teacher(String specialty, String username, String name, String gender) {
        super(username, name, gender);
        this.specialty = specialty;
    }

   
    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getUsername() {
        return username;
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
        return gender ;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return super.toString()+"Teacher [ specialty=" + specialty + "]";
    }

}

