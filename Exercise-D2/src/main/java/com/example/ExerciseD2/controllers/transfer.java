package com.example.ExerciseD2.controllers;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class transfer {
    private int ID1;
    private int ID2;
    private int MONEY;

    public transfer(int ID1, int ID2, int MONEY) {
        this.ID1 = ID1;
        this.ID2 = ID2;
        this.MONEY = MONEY;
    }

    public int getID1() {
        return ID1;
    }

    public void setID1(int ID1) {
        this.ID1 = ID1;
    }

    public int getID2() {
        return ID2;
    }

    public void setID2(int ID2) {
        this.ID2 = ID2;
    }

    public int getMONEY() {
        return MONEY;
    }

    public void setMONEY(int MONEY) {
        this.MONEY = MONEY;
    }
}
