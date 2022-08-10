package com.example.ExerciseD2.controllers;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResponseAPI {

    private String message;

    public ResponseAPI(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;

}
}

