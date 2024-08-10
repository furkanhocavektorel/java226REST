package com.vektorel.restful.exception.custom;

import com.vektorel.restful.exception.AllException;

public class AdminBulunamadiException extends RuntimeException{

    public AllException exc;

    public AdminBulunamadiException(AllException ex) {
        super(ex.getErrorMessage());
        this.exc=ex;
    }

    public AdminBulunamadiException() {
    }
}
