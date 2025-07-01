package com.foody.foody.Exceptions;

public class ErrorObject {
    private String message;
    private Integer statusCode;

    public ErrorObject(String message,Integer statusCode) {
        this.message = message;
        this.statusCode=statusCode;
    }

    public String getMessage() {
        return message;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
