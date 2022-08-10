package com.example.demo3;

public class Customers {

    private int ID;
    private String Username;
    private int Balance;

    public Customers() {
    }

    public Customers(int ID, String username, int balance) {
        this.ID = ID;
        this.Username = username;
        this. Balance = balance;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public void setBalance(int balance) {
        Balance = balance;
    }

    public int getID() {
        return ID;
    }

    public String getUsername() {
        return Username;
    }

    public int getBalance() {
        return Balance;
    }
}
