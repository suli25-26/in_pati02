package com.example.models;

public class User {
    private String user;
    private String pass;
    private String role;

    public User() {
    }

    public User(String user, String pass, String role) {
        this.user = user;
        this.pass = pass;
        this.role = role;
    }

    public User(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
