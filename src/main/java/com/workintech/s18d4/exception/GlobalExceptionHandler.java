package com.workintech.s18d4.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityException.class)
    public ResponseEntity<EntityErrorResponse> handleException(EntityException entityException){
        EntityErrorResponse error = new EntityErrorResponse(entityException.getMessage(),entityException.getStatus().value());
        return new ResponseEntity<>(error,entityException.getStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<EntityErrorResponse> handleException(Exception exception){
        EntityErrorResponse error = new EntityErrorResponse(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity(error,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
