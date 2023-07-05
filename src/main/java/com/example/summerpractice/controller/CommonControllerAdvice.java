package com.example.summerpractice.controller;

import com.example.summerpractice.dto.ResponseGetDto;
import com.example.summerpractice.util.ResponseFactory;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CommonControllerAdvice extends ResponseEntityExceptionHandler {
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseGetDto<Void> notValidRequest(IllegalArgumentException e) {
        return ResponseFactory.createFailedResponse(HttpStatus.BAD_REQUEST, e.getMessage());
    }

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseGetDto<Void> notFoundRequest(EntityNotFoundException e) {
        return ResponseFactory.createFailedResponse(HttpStatus.NOT_FOUND, e.getMessage());
    }

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseGetDto<Void> handleException(Throwable e) {
        return ResponseFactory.createFailedResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
    }
}
