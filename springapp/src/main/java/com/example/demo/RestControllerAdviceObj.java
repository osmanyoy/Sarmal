package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Osman on 1.08.2017.
 */
@ControllerAdvice
public class RestControllerAdviceObj {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Error errorHandler(Exception ex){
        Error error = new Error();
        error.setCause(101);
        error.setDescription(ex.getMessage());
        return error;
    }
}
