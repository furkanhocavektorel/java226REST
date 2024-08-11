package com.vektorel.restful.exception.custom;

import com.vektorel.restful.exception.AllException;

public class TokenException extends RuntimeException{
    public AllException exc;

    public TokenException() {
    }

    public TokenException( AllException exc) {
        super(exc.getErrorMessage());
        this.exc = exc;
    }
}
