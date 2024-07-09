package com.workintech.s18d4.util;

import com.workintech.s18d4.exception.EntityException;
import org.springframework.http.HttpStatus;

public class Validation {

    public static void isIdValid(long id) {
        if( id == 0 || id < 0){
            throw new EntityException(id + " can not be 0 or less", HttpStatus.BAD_REQUEST);
        }
    }

    public static void idIsNotExist(){
        throw new EntityException("Id is not exist", HttpStatus.BAD_REQUEST);
    }
}
