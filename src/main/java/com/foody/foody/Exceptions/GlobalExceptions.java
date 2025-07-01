package com.foody.foody.Exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptions {


    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorObject> notFoundException(NotFoundException error) {

        return new ResponseEntity<>(
                new ErrorObject(error.getMessage(),404),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(FoundException.class)
    public ResponseEntity<ErrorObject> foundException(FoundException error) {
        return new ResponseEntity<>(
                new ErrorObject(error.getMessage(),409),
                HttpStatus.CONFLICT
        );
    }
    

}
