package com.example.bank.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor @Data
public class Customer {
    private int id;
    private String username;
    private int balance;
}
