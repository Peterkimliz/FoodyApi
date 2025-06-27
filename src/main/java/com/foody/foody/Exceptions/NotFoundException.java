package com.foody.foody.Exceptions;

public class NotFoundException extends RuntimeException {
    private String Message;

    public NotFoundException(String message) {
       super(message);
    }
}
