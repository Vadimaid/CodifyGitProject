package com.codify.codifygitproject.controller.advice;

import com.codify.codifygitproject.controller.Cody5Controller;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackageClasses = Cody5Controller.class)
public class Codify5ControllerAdvice {

    @ExceptionHandler(value =  IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleIllegalArgumentException(IllegalArgumentException ex){
      return ex.getLocalizedMessage();
    }
    @ExceptionHandler(value =  MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleIllegalArgumentException(MissingServletRequestParameterException ex){
        return "Параметр <name> не должен быть null";
    }
}
