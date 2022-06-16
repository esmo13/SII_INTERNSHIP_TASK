package com.example.demo.Exceptions;

public class LessonFullException extends RuntimeException{
    public LessonFullException(String message) {
        super(message);
    }
}
