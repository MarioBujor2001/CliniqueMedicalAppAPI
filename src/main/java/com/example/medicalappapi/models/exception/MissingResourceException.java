package com.example.medicalappapi.models.exception;

public class MissingResourceException extends Exception{
    public MissingResourceException(){
        super("The resource cannot be found");
    }
}
