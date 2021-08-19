package com.example.demo.entities;

import com.sun.istack.NotNull;

public class Feedback {
    @NotNull
    private String ename;

    @NotNull
    private String email;

    @NotNull
    private String feedback;

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}

