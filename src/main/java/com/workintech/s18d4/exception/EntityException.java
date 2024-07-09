package com.workintech.s18d4.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class EntityException extends RuntimeException{

    private HttpStatus status;

    public EntityException(String message,HttpStatus status){
        super(message);
        this.status = status;
    }
}
