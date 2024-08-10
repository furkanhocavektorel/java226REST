package com.vektorel.restful.exception.custom;
// en basit Yöntem-
// GRUP_1 EXCEPTION

public class KullaniciBulunamadiException extends RuntimeException {


    public KullaniciBulunamadiException() {
    }

    public KullaniciBulunamadiException(String message) {
        super(message);
    }
}
