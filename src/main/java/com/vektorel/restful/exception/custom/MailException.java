package com.vektorel.restful.exception.custom;

import com.vektorel.restful.exception.AllException;

public class MailException extends RuntimeException {

    public MailException(AllException exception) {
        super(exception.getErrorMessage());
    }
}
