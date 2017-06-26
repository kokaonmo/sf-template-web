package com.exem.sf.exception;

import org.springframework.http.HttpStatus;

/**
 * Created by CHOI SUNG HOON on 2017. 6. 23..
 */
public class UsersNotFoundException extends ResourceNotFoundException  {

    private final String username;

    public UsersNotFoundException(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String getError() {
        return "User " + HttpStatus.NOT_FOUND.getReasonPhrase();
    }

    @Override
    public Object[] getArgs() {
        return new Object[]{ username };
    }
}
