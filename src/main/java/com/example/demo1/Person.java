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
public class Person extends Admin {
     
    String name ;
    String gender ;
    LocalDate birthday ;
    String password ;

    @Override
    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

  

    public Person(String username, String name, String gender, String password,   LocalDate birthday) {
        this.username = username;
        this.name = name;
         this.gender = gender;
        this.password = password;
        this.birthday = birthday;
    }



    public Person(String username, String name, String gender) {
        this.username = username;
        this.name = name;
        this.gender = gender;
    }



    public Person() {
    }

    @Override
    public String toString() {
        return "Person [username=" + username + ", name=" + name + ", gender=" + gender
                 + "]";
    }
    
}
