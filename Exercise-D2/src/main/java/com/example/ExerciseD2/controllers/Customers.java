package com.example.ExerciseD2.controllers;

import org.springframework.web.bind.annotation.RestController;

@RestController

public class Customers {

    private int ID;
    private String USERNAME;
    private int BALANCE;

    public Customers(int ID, String USERNAME, int BALANCE) {
        this.ID = ID;
        this.USERNAME = USERNAME;
        this.BALANCE = BALANCE;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUSERNAME() {
        return USERNAME;
    }

    public void setUSERNAME(String USERNAME) {
        this.USERNAME = USERNAME;
    }

    public int getBALANCE() {
        return BALANCE;
    }

    public void setBALANCE(int BALANCE) {
        this.BALANCE = BALANCE;
    }
}
