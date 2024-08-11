package com.vektorel.restful.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum AllException {

    ADMIN_ZATEN_KAYITLI(1757,"BU MAIL ILE ADMIN ZATEN MEVCUT"),
    KULLANICI_ZATEN_KAYITLI(1801,"KULLANICI MAILI ZATEN KAYITLI"),
    ADMIN_BULUNAMADI(2001,"BU ADA AIT ADMIN/ADMINLER BULUNAMADI"),
    ADMIN_BULUNUMADI_ID(2002,"BU Id ye ait admin bulunamadi"),

    TOKENA_AIT_ADMIN_BULUNAMADI(1001,"tokendan admin bulunamadi. hatali token"),
    TOKEN_HATASI(1000,"Token acilirken Hata");

    int statusCode;
    String errorMessage;
}
