package com.foody.foody.Exceptions;

public class FoundException extends  RuntimeException{
    private String message;

    public FoundException(String message) {
        super(message);
    }


}
