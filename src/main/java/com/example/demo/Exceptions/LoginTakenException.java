package com.example.demo.Exceptions;

public class LoginTakenException extends RuntimeException{
    public LoginTakenException(String message) {
        super(message);
    }
}
