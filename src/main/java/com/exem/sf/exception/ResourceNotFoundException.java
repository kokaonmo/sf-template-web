package com.exem.sf.exception;

import org.springframework.http.HttpStatus;

/**
 * Created by CHOI SUNG HOON on 2017. 6. 23..
 */
public abstract class ResourceNotFoundException extends RuntimeException {
    public HttpStatus getStatus(){
        return HttpStatus.NOT_FOUND;
    }

    public String getError(){
        return HttpStatus.NOT_FOUND.getReasonPhrase();
    }

    public String getCode(){
        return "error." + getClass().getSimpleName();
    }

    public Object[] getArgs(){
        return null;
    }
}
