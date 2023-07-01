package com.tech.blog.entities;

import java.sql.*;


public class User {
    
    private int id;
    private String name ;
    private String email ;
    private String gender ;
    private String about ;
    private String password ;
    private Timestamp currentTime ;
    private String Profile;
    private int userPosition=1;

    public String getProfile() {
        return Profile;
    }

    public void setProfile(String Profile) {
        this.Profile = Profile;
    }

    public User(int id, String name, String email, String gender, String about, String password, Timestamp currentTime) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.about = about;
        this.password = password;
        this.currentTime = currentTime;
        
    }

    public User(String name, String email, String gender, String about, String password) {
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.about = about;
        this.password = password;
    }

    public int getUserPosition() {
        return userPosition;
    }

    public void setUserPosition(int userPosition) {
        this.userPosition = userPosition;
    }

    public User() {
        
    }
    
    
//    setter and getter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(Timestamp currentTime) {
        this.currentTime = currentTime;
    }
    

}
